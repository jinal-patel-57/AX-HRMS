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
    	console.log("calling.....")
    	//namespaceDesignation = '<portlet:namespace />selectedDesig';
        namespaceDepartment = '<portlet:namespace />selectedDepart';
        namespaceSearch = '<portlet:namespace />serachQuery';
        
        namespaceDesignation = config.namespace;
        console.log(config);
        
            var url = config.renderUrl;
            console.log(url);
         //   url = url.replace('SELECTEDDESIG', config.selectedDesig);
            url = url.replace('SELECTEDDEPART', config.selectedDepart);
            url = url.replace('SEARCHQUERY', config.searchedValue);

			window.location.href = url;
            
    }
    
    AxHrmsEmployeeDirectoryHrAdminWebPortlet.setConfigsForRenderFetchData = setConfigsForRenderFetchData;
    
    AxHrmsEmployeeDirectoryHrAdminWebPortlet.setConfigsForSearchData = setConfigsForSearchData;
    

})($, (window.AxHrmsEmployeeDirectoryHrAdminWebPortlet = window.AxHrmsEmployeeDirectoryHrAdminWebPortlet || {}));

