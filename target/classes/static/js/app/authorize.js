function checkPermision() {
	$.ajax({
        type : "GET",
        url : "checkPermission",
        contentType : "application/json; charset=utf-8",
        success : function(data) {
        	console.log(data);
        	if(data == true) {
	        	$("#tabAdmin").removeClass("hide");
	        	$("#tabConfig").removeClass("hide");
	        	$("#tabProduct").removeClass("hide");
	        	$("#tabData").removeClass("hide");
        	} else if (data == false) {
        		$("#tabAdmin").addClass("hide");
	        	$("#tabConfig").addClass("hide");
	        	$("#tabProduct").addClass("hide");
	        	$("#tabData").addClass("hide");
	        	if(window.location.href.indexOf("searchData.html") < 0) {
	        		window.location.href="searchData.html";
	        	}
        	} else {
        		window.location.href="searchData.html";
        		return;
        	}
        }
    });
	
}

function getCurrentUser(){
	$.ajax({
		type : "GET",
		url : "getCurrentUser",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		success : function(response) {
			bemId = response;
		},
		error: function(error) {
			showErrorMessage();
		}
	});
}