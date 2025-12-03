(function($, AxHrmsHolidayEmployeeWebPortlet) {
    let namespace;
    function setConfigsForRenderHolidayWithYear(config){
        namespace = config.namespace;
        console.log(config);
        
            var url = config.renderUrl;
            console.log(url);
            url = url.replace('SELECTED_YEAR', config.selectedYear);
            console.log("Url Value is "+url);

			window.location.href = url;
            
    }
    
    AxHrmsHolidayEmployeeWebPortlet.setConfigsForRenderHolidayWithYear = setConfigsForRenderHolidayWithYear;
    
})($, (window.AxHrmsHolidayEmployeeWebPortlet = window.AxHrmsHolidayEmployeeWebPortlet || {}));

