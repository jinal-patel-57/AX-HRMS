package com.aixtor.ddos.filter;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.servlet.PortalSessionThreadLocal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.URLCodec;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.time.Instant;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
/**
 * @author nikunj.malaviya
 */

@Component(immediate = true, 
	property = { "servlet-context-name=", 
				 "servlet-filter-name=IP-Filter", 
				 "url-pattern=/*", 
				 "before-filter=Virtual Host Filter" 
				}, service = Filter.class
)
public class IPFilter implements Filter {

	private static Log _log = LogFactoryUtil.getLog(IPFilter.class);

	private static String REGEX_PATTERN = "(/image/layout_*|/o/js_*/.*|/o/frontend-js-web/.*|/documents/.*|/combo?|(/o/.+\\.(css|gif|html|ico|jpg|js|png|woff)(\\?.*)?$))";

	private static final String CURRENT_URL = "CURRENT_URL";
	private static final String VIRTUAL_HOST_LAYOUT_SET = "VIRTUAL_HOST_LAYOUT_SET";
	private static final String COMPANY_ID = "COMPANY_ID";
	private boolean _private = false;
	private static final String URL_PREFIX = "/web";
	private static final String GUEST_GROUP_PATH = "/guest";

	private static final String ERROR_PATH = "/error";
	private static Pattern _urlRegexIgnorePattern = Pattern.compile(REGEX_PATTERN);

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		String currentCompleteURL = URLCodec.decodeURL(PortalUtil.getCurrentURL(httpServletRequest));

		if (Validator.isNotNull(currentCompleteURL) && !currentCompleteURL.contains("/control_panel/manage") && !currentCompleteURL.contains("/group") && !currentCompleteURL.contains("/combo")  && !currentCompleteURL.contains("/dashboard")) {

			Long stTimeInSec = Instant.now().toEpochMilli();
			boolean foundXSS = false;

			Map<String, String> queryParams = getQueryParameters(httpServletRequest);
			for (Map.Entry<String, String> queryParamsEntrySet : queryParams.entrySet()) {
				String paramName = queryParamsEntrySet.getKey();
				String paramValue = queryParamsEntrySet.getValue();
				String value = URLCodec.decodeURL(paramValue);
				_log.debug(":::: Query Param :::: >>>> " + paramName + " :::: Value :::: >>>> " + value);
				if (foundXSS) {
					break;
				}
				foundXSS = containsJS(value, true);
			}

			Enumeration<String> params = httpServletRequest.getParameterNames();

			_log.debug(":::: >>>> Param values Display START :::: >>>>");

			while (params.hasMoreElements()) {
				String param = params.nextElement();
				String value = URLCodec.decodeURL(httpServletRequest.getParameter(param));
				_log.debug(":::: Param :::: >>>> " + param + " :::: Value :::: >>>> " + value);
				if (foundXSS) {
					break;
				}
				foundXSS = containsJS(value, false);
			}
			_log.debug(":::: >>>> Param values Display END :::: >>>>");

			if (!foundXSS) {
				_log.debug(":::: XSS Attack Vulnerability not found ::::");
				calculateDuration(stTimeInSec);

				chain.doFilter(request, response);

			} else {
				_log.error(":::: Request is more prone to XSS attack ::::");
				calculateDuration(stTimeInSec);
				httpServletResponse.sendRedirect("/error");
			}

		} else {

			// Normal request processing
			chain.doFilter(request, response);

		}
	}

	private void calculateDuration(Long stTimeInSec) {
		Long endTimeInSec = Instant.now().toEpochMilli();
		Long elapsedTime = endTimeInSec - stTimeInSec;
		_log.debug(":::: Total time taken for processing of Filter to check XSS :::: Time :::: >>>> " + elapsedTime + " ms");

	}

	public static Map<String, String> getQueryParameters(HttpServletRequest request) {
		Map<String, String> queryParameters = new HashMap<String, String>();
		String queryString = request.getQueryString();

		if (Validator.isNull(queryString)) {
			return queryParameters;
		}

		String[] parameters = queryString.split("&");

		for (String parameter : parameters) {
			String[] keyValuePair = parameter.split("=");
			if (Validator.isNotNull(keyValuePair) && keyValuePair.length > 0) {
				String key = keyValuePair.length > 0 && Validator.isNotNull(keyValuePair[0]) ? keyValuePair[0] : "";
				String value = keyValuePair.length > 1 && Validator.isNotNull(keyValuePair[1]) ? keyValuePair[1] : "";
				_log.debug(":::: QueryParameter key :::: >>>> " + key + " :::: value :::: >>>> " + value);
				if (Validator.isNotNull(key) && Validator.isNotNull(value)) {
					queryParameters.put(key, value);
				}

			}

		}
		return queryParameters;
	}

	public boolean containsJS(String value, boolean isQueryParam) {
		boolean foundXSS = false;
		if (value == null || value.isEmpty()) {
			return false;
		}
		Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
		Matcher scriptMat = scriptPattern.matcher(value);
		if (scriptMat.find()) {
			foundXSS = true;
		}
		scriptPattern = Pattern.compile("<script>", Pattern.CASE_INSENSITIVE);
		scriptMat = scriptPattern.matcher(value);
		if (scriptMat.find()) {
			foundXSS = true;
		}
		scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
		scriptMat = scriptPattern.matcher(value);
		if (scriptMat.find()) {
			foundXSS = true;
		}
		scriptPattern = Pattern.compile("javascript", Pattern.CASE_INSENSITIVE);
		scriptMat = scriptPattern.matcher(value);
		if (scriptMat.find()) {
			foundXSS = true;
		}

		scriptPattern = Pattern.compile("<qss", Pattern.CASE_INSENSITIVE);
		scriptMat = scriptPattern.matcher(value);
		if (scriptMat.find()) {
			foundXSS = true;
		}

		scriptPattern = Pattern.compile("-qss", Pattern.CASE_INSENSITIVE);
		scriptMat = scriptPattern.matcher(value);
		if (scriptMat.find()) {
			foundXSS = true;
		}

		scriptPattern = Pattern.compile("<qxss", Pattern.CASE_INSENSITIVE);
		scriptMat = scriptPattern.matcher(value);
		if (scriptMat.find()) {
			foundXSS = true;
		}

		scriptPattern = Pattern.compile("-qxss", Pattern.CASE_INSENSITIVE);
		scriptMat = scriptPattern.matcher(value);
		if (scriptMat.find()) {
			foundXSS = true;
		}

		if (isQueryParam) {
			scriptPattern = Pattern.compile("\"", Pattern.CASE_INSENSITIVE);
			scriptMat = scriptPattern.matcher(value);
			if (scriptMat.find()) {
				foundXSS = true;
			}
			scriptPattern = Pattern.compile("\'", Pattern.CASE_INSENSITIVE);
			scriptMat = scriptPattern.matcher(value);
			if (scriptMat.find()) {
				foundXSS = true;
			}
		}

		scriptPattern = Pattern.compile("<", Pattern.CASE_INSENSITIVE);
		scriptMat = scriptPattern.matcher(value);
		if (scriptMat.find()) {
			foundXSS = true;
		}
		scriptPattern = Pattern.compile(">", Pattern.CASE_INSENSITIVE);
		scriptMat = scriptPattern.matcher(value);
		if (scriptMat.find()) {
			foundXSS = true;
		}
		return foundXSS;
	}

	protected boolean getRedirect(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Map params = request.getParameterMap();

		String currentURL = (String) request.getAttribute(CURRENT_URL);
		String rectifiedCurrentURL = getRectifiedCurrentURL(currentURL);
		Group group = null;

		_log.debug(":::: currentURL :::: >>>> " + currentURL);
		_log.debug(":::: rectifiedCurrentURL :::: >>>> " + rectifiedCurrentURL);

		User user = (User) request.getAttribute(WebKeys.USER);
		Long companyId = (Long) request.getAttribute(COMPANY_ID);

		if (Validator.isNotNull(user)) {
			_log.debug(":::: companyId :::: >>>> " + companyId);
			group = getGuestGroup(companyId);
		} else {
			LayoutSet virtualHostLayoutSet = (LayoutSet) request.getAttribute(VIRTUAL_HOST_LAYOUT_SET);
			_log.debug(":::: virtualHostLayoutSet :::: >>>> " + virtualHostLayoutSet);

			if (Validator.isNotNull(virtualHostLayoutSet)) {
				group = Validator.isNotNull(virtualHostLayoutSet) && Validator.isNotNull(virtualHostLayoutSet.getGroup()) ? virtualHostLayoutSet.getGroup() : null;
			}
		}

		_log.debug(":::: group :::: >>>> " + group);

		if (Validator.isNull(group)) {
			return false;
		}

		Map<String, Object> requestContext = new HashMap<String, Object>();

		requestContext.put("request", request);

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		if (serviceContext == null) {
			serviceContext = ServiceContextFactory.getInstance(request);

			ServiceContextThreadLocal.pushServiceContext(serviceContext);
		}

		return false;
	}

	private boolean redirectToErrorURL(HttpServletRequest request, HttpServletResponse response) throws Exception {

		LayoutSet virtualHostLayoutSet = (LayoutSet) request.getAttribute(VIRTUAL_HOST_LAYOUT_SET);

		_log.debug(":::: virtualHostLayoutSet :::: >>>> " + virtualHostLayoutSet);

		Group group = null;

		group = Validator.isNotNull(virtualHostLayoutSet) && Validator.isNotNull(virtualHostLayoutSet.getGroup()) ? virtualHostLayoutSet.getGroup() : null;

		_log.debug(":::: group :::: >>>> " + group);

		HttpSession session = PortalSessionThreadLocal.getHttpSession();

		if (session == null) {
			session = request.getSession();
		}

		ServletContext servletContext = session.getServletContext();
		String redirect = getErrorRedirectURL();
		if (Validator.isNull(redirect)) {
			return false;
		}

		_log.debug(":::: URL_PREFIX :::: >>>> " + URL_PREFIX);
		_log.debug(":::: Redirect :::: >>>> " + redirect);

		if (Validator.isNotNull(group)) {
			_log.debug(":::: Group FriendlyURL :::: >>>> " + group.getFriendlyURL());
			RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(URL_PREFIX + group.getFriendlyURL() + redirect);

			if (requestDispatcher != null) {
				requestDispatcher.forward(request, response);
			}
		}

		return true;
	}

	private String getErrorRedirectURL() {
		return ERROR_PATH;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	private static String getRectifiedCurrentURL(String currentURL) {
		String rectifiedCurrentURL = StringPool.BLANK;

		if (currentURL.contains(StringPool.QUESTION)) {
			rectifiedCurrentURL = currentURL.split("\\" + StringPool.QUESTION)[0];
		} else {
			rectifiedCurrentURL = currentURL;
		}

		return rectifiedCurrentURL;
	}

	private static Group getGuestGroup(long companyId) {
		try {
			Group guestGroup = GroupLocalServiceUtil.getFriendlyURLGroup(companyId, GUEST_GROUP_PATH);
			return guestGroup;
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}
		return null;
	}

}
