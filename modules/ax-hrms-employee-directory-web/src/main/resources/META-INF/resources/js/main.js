(function($, AxHrmsEmployeeDirectoryHrAdminWebPortlet) {
    let namespace;
    
    function setConfigsForSearchData(config){
    	namespace = config.namespace;
    
    	console.log(config);
    	
    	var url = config.renderUrl;
        console.log(url);
        console.log(config.searchValue);
        url = url.replace('SEARCHQUERY', config.searchValue);
        console.log(url);

		window.location.href = url;
    }

    function setConfigsForRenderFetchData(config){
    	
    	namespaceDesignation = '<portlet:namespace />selectedDesig';
        namespaceDepartment = '<portlet:namespace />selectedDepart';
        namespaceSearch = '<portlet:namespace />serachQuery';
        
        namespaceDesignation = config.namespace;
        console.log(config);
        
//            var url = config.renderUrl;
//            console.log(url);
//            url = url.replace('SELECTED_YEAR', config.selectedYear);
//            console.log(url);
//
//			window.location.href = url;
            
    }
    
    AxHrmsEmployeeDirectoryHrAdminWebPortlet.setConfigsForRenderFetchData = setConfigsForRenderFetchData;
    
    AxHrmsEmployeeDirectoryHrAdminWebPortlet.setConfigsForSearchData = setConfigsForSearchData;
    

})($, (window.AxHrmsEmployeeDirectoryHrAdminWebPortlet = window.AxHrmsEmployeeDirectoryHrAdminWebPortlet || {}));

