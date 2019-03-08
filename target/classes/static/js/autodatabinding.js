class TableClass{
	
		constructor(){			
		}
		set type(value){
			this._type=value;
		}
		set tableId(value){
			if (value.includes("#")){
				this._tableId=value;	
			}else{
				this._tableId="#"+value;
			}			
		}	
		set numberOfColumns(value){
			this._numberOfColumns=value;
		}
		set getTableData(value){
			this._getTableData=value;
		}
		set deleteController(value){
			this._deleteController=value;
		}		
		set editFormObj(value){
			this._editFormObj=value;
		}
		set jsonObj(value){
			this._jsonObj=value;
		}
		set bFilter(value){
			this._bFilter=value;
		}
		set bInfo(value){
			this._bInfo=value;
		}
		set bPaginate(value){
			this._bPaginate=value;
		}
		set pageLength(value){
			this._pageLength=value;
		}
		set bLengthChange(value){
			this._bLengthChange=value;
		}
		set order(value){
			this._order=value;
		}
		set displayIfNoData(value){
			this._displayIfNoData=value;
		}
		set buttonAddId(value){
			this._buttonAddId=value;
		}
		set checkAllId(value){
			this._checkAllId=value;
		}		
		set divTableData(value){
			if (value.includes("#")){
				this._divTableData=value;	
			}else{
				this._divTableData="#"+value;
			}
		}	
		set bLazyTable(value){
			this._bLazyTable=value;
		}
		set searchPlaceholder(value){
			this._searchPlaceholder=value;
		}
		
		show(){
			$(this._divTableData).removeClass("hide");
		}		
		hide(){
			$(this._divTableData).addClass("hide");
		}
		
		loadElement(){
			if($('iconloading')!=null ){
				 $('body').append('<div class="loadingProcess" id="iconloading"></div>');
			}			
			if($('edit-container')!=null){
				 $('body').append('<div id="edit-container" class="modal-container"></div>');
			}
			if(this._editFormObj!=null ){				
				$('#edit-container').load(this._editFormObj._editFormHtml);
			}
			
			if(this._buttonAddId!=null){			
					$(this._buttonAddId).click({editForm:this._editFormObj},callAddForm);
			}
		}
		
		loadTable(){				
			this.loadElement();	
			if(this._bLazyTable==true){			
				this.buildLazyTable(this);					
			}else{
				this.callAjax(this);
			}
			if (this._searchPlaceholder==null){
				this._searchPlaceholder="Type here to search . . .";
			}
			$('.dataTables_wrapper').children('.dataTables_filter').children('label').children('input').attr("placeholder", this._searchPlaceholder);
			$('.dataTables_wrapper').children('.dataTables_filter').children('label').children('input').focus();
		}	
		
		reloadTable(){
			this.loadElement();
			if(this._bLazyTable==true){			
				var table=$(this._tableId).DataTable().ajax.reload( null, false )					
			}else{
				this.callAjax(this);
			}
		}
		
		buildLazyTable(tableObj){
			var tableObjectName;
			var getTableData =this._getTableData;
			if (tableObj._editFormObj!=null){
				tableObjectName=tableObj._editFormObj._saveButtonId[1];
			}
			var dynamicColumn=getDataColumn(tableObjectName,this._numberOfColumns,this._type);
					
		    var bFilter =this._bFilter;    
		    var checkAllId=this._checkAllId;
		    var bInfo=this._bInfo;
		    if (bFilter==null){
		    	bFilter=true;
		    }
		    if (bInfo==null){
		    	bInfo=true;
		    }
		    var bPaginate=this._bPaginate;
		    if (bPaginate==null){
		    	bPaginate=true;
		    }
		    var pageLength=this._pageLength;		    
		    var bLengthChange=this._bLengthChange;		    
		    var order=this._order;
		    var ordering =true;
		    if(order==null){		    	
		    	order=1;
		    }    			
			var table=$(this._tableId);			
			var dataTable=table.DataTable({	
					"ordering" : ordering,
					"order": [[ order, "asc" ]],
					"bPaginate" : bPaginate,
					"bLengthChange" : bLengthChange,
					"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
					"bAutoWidth": false,
					"bFilter" : bFilter,
					"bInfo" : bInfo,	
					"responsive": true,
					"retrieve": true,
				  	"processing": true,
			        "serverSide": true,			        
			        "pageLength": pageLength,			        
			        "columns":dynamicColumn,
				   "ajax": {
		               "url": getTableData,
		               "type": "POST",
		               "contentType" : "application/json; charset=utf-8",			    
		               "data": function ( d ) {
		                   return JSON.stringify(d); // NOTE: you also need to stringify POST payload
		               },
					 "error": function(jqXHR, textStatus, errorThrown){
					     alert(errorThrown);					
					   }           
		           }
			    } );
		}
		
		callAjax(tableObj){			
			var getTableData =this._getTableData;
			var type =this._type;
			var jsonObj= this._jsonObj;
			var displayIfNoData=this._displayIfNoData;			
			var numberOfColumns=this._numberOfColumns;
			var tableObjectName;
			if (tableObj._editFormObj!=null){
				tableObjectName=tableObj._editFormObj._saveButtonId[1];
			}
			$.ajax({
				type : "POST",
				url : getTableData, 
				contentType : "application/json; charset=utf-8",
				async: false,
				dataType : "json",
				data:JSON.stringify(jsonObj),
				beforeSend : function() {					
					$("body").addClass("loading");
				},
				success : function(data) {					
					var rowDataSet = getDataRow(data);					
					var dynamicColumn=getDataColumn(tableObjectName,numberOfColumns,type);				
					buildTable(tableObj,dynamicColumn,rowDataSet);
				},
				error: function(xhr, errorType, exception) {	
					alert(xhr.responseText);					
					showErrorMessage();
				},
				complete: function() {					
					$("body").removeClass("loading");					
				}
			});
		} // End call Ajax method

		deleteRecord(listId){		
			var deleteController= this._deleteController;
			$.ajax({
				type : "POST",
				url : deleteController, 
				data: JSON.stringify(listId),
				async: false,
				contentType : "application/json; charset=utf-8",
				success : function(data) {
					callAlert("Deleted successfully!");
				},
				error: function (jqXHR, exception) {
					showErrorMessage();
					return false;
		        },
				complete: function () {										
					$("body").removeClass("loading");
				}
			});			
			this.reloadTable();
			return true;
		}
		
		deleteRecords() {			
			var selected = this.getAllSelected();			
			deleteRecord(selected, this._deleteController)
		}
		
		saveRecord(){			
			if(this._editFormObj.saveRecord()){
				this.reloadTable();				
			}
		}
		
		getAllSelected(){
			var selected = [];
			var allPages = $(this._tableId).DataTable().cells().nodes();
			$(allPages).find('input[type="checkbox"]:checked').each(function() {
			    selected.push($(this).attr('id'));
			});			
			return selected;
		}
}
//End of Table Class
//-------------------------------------------

class EditForm{
	constructor(){		
	}
	
	set idFieldName(value){
		this._idFieldName=value;
	}
	set editForm(value){
		this._editForm=value;
	}
	set getDropDownValue(value){
		this._getDropDownValue=value;
	}
	set getValuesToBind(value){
		this._getValuesToBind=value;
	}	
	set saveDataObject(value){
		this._saveDataObject=value;
	}	
	set datePickerList(value){
		this._datePickerList=value;
	}	
	set suggestionList(value){
		this._suggestionList=value;
	}		
	set dataTableListObj(value){
		this._dataTableListObj=value;
	}
	set editFormHtml(value){
		this._editFormHtml=value;
	}	
	set saveButtonId(value){
		this._saveButtonId=value;
	}
	set dropdownList(value){
		this._dropdownList=value;
	}
	set searchButton(value){
		this._searchButton=value;
	}	
	
	openAddModal(){	
		
		$(this._editForm).modal("show");
		this.openEditModal(0);
		//this.initiateForm();
	}
	
	openEditModal(recordId){		
		$(this._editForm).modal("show");
		this.openEditForm(recordId);
	}
	
	openEditForm(recordId) {		
		this.initiateForm();		
		if (this._idFieldName==null){
			this._idFieldName="id";
		}		
		this.bindValueToFields(this._idFieldName,this._getValuesToBind, recordId);		
		if (this._dataTableListObj!=null){
			//var jsonObj=this._idFieldName+'='+recordId;
			var jsonObj=recordId;
			this.loadAllTables(jsonObj);	
		}			
	}
	
	initiateForm(){
		
		this.handleFormSubmit(this._editForm);	
		if($(this._editForm).tagName=='Form'){			
			this.handleFormSubmit(this._editForm);	
		}		
		if(this._getDropDownValue!=null){
			this.bindDropDownValue(this._getDropDownValue,this._dropdownList);
		}		
		if(this._datePickerList!=null){
			this.bindDatePicker(this._datePickerList);
		}		
		if (this._suggestionList!=null){
			this.bindSuggestion(this._suggestionList);
		}			
		if(this._saveButtonId!=null){
			$(this._saveButtonId[0]).attr('onClick', this._saveButtonId[1]+'.saveRecord()');
		}
		if(this._searchButton!=null){			
			this.search();
			$(this._searchButton[0]).attr('onClick', this._searchButton[1]+'.search()');
		}
		
	}	
	
	search(){
//		if(!$(this._editForm)[0].reportValidity()){		    		
//			 return false;
//		}		
		var jsonObj=this.getDataObj(this._idFieldName,this._getValuesToBind);	
		this.loadAllTables(jsonObj);
	}
	
	loadAllTables(jsonObj){		
		for(var i=0;i<this._dataTableListObj.length;i++){
			this._dataTableListObj[i].jsonObj=jsonObj;
			this._dataTableListObj[i].loadTable();	
			this._dataTableListObj[i].show();
		}	
	}
	
	handleFormSubmit(editForm){
		  $(editForm).submit(function(event){
			  event.preventDefault();		  
		  });
	}
	
	bindDropDownValue(getDropDownValue,dropdownList){		
		for(var i=0;i<dropdownList.length;i++){
			$('select[id$='+dropdownList[i][0] +'] > option').remove();		
			if (dropdownList[i][2]==true){				
				var dropdown = document.getElementById(dropdownList[i][0]);
				$(dropdown).append('<option value=0>All</option>');
			}
		}
		$.ajax({
			type : "GET",
			url : getDropDownValue, 
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			success : function(response) {
				var len = response.length;
	            for(var i=0; i<len; i++){	            	
	            	var catGroup = response[i].categoryGroup;
	            	var dropdownLen = dropdownList.length;
	            	for (var j=0;j<dropdownLen;j++){
	            		if (dropdownList[j][1]==catGroup){
	            			var controlid=dropdownList[j][0];
	            			var dropdown = document.getElementById(controlid);
	    	            	if (dropdown!=null){
	    	            		$(dropdown).append('<option value="' + response[i].id + '">' + response[i].value + '</option>');
	    	            	}	            			
	            		}
	            	}            	
	            }
			},				
			error: function(event, status, xhr) {		
				showErrorMessage();
			}
		});
	}

	bindDatePicker(datePickerList) {
		for (var controlId in datePickerList){		
			$(datePickerList[controlId]).datepicker({
				showOn:"button",
				   	buttonImage: "images/Calendar-icon.png",
				   	buttonImageOnly: true,
				   	changeMonth: true,
			      	changeYear: true
			});
		}
	}
	
	bindSuggestion(suggestionList){	
		for(var i=0;i<suggestionList.length;i++){
			var controlId=suggestionList[i][0];
			var category =suggestionList[i][1];
			var minCharToSuggest=suggestionList[i][2];
			var isMulti=suggestionList[i][3];
			
			var cache = {};
			$(controlId).keyup(function(event){
			}).autocomplete({
		        minLength: minCharToSuggest,
		        source: function( request, response ) {
		        	var value = $(controlId).val()
		        		if(isMulti){
		        			value =extractLast($(controlId).val());            
		        		}
		            if ( value in cache ) {
		            	response( $.ui.autocomplete.filter(
		            			cache[ value ].slice(0, 10), extractLast( request.term ) ) );
		                 return;
		            }        	      	
			        $.ajax({
			        		type: "GET",
			                url: encodeURI("suggestion?searchKey="+ value +"&searchCat=" + category),
			                contentType: "application/json; charset=utf-8",
			                dataType: "json",
			                success: function (data) {           
			                    cache[ value ] = data;	        
			                	response( $.ui.autocomplete.filter(
			                            data.slice(0, 10), extractLast( request.term ) ) );
			                },
			                error: function(event, status, xhr) {
			              }
			        	});        	
		        },
		        focus: function() {
		          return false;
		        },
		        select: function( event, ui ) {
		        	if(isMulti){
			          var terms = split( this.value );
			          terms.pop();
			          terms.push( ui.item.value );
			          terms.push( "" );
			          this.value = terms.join( ", " );
			          return false;
		        	}
		        	else{
		        		return true;
		        	}          
		        }        
			});
		}
	}
	
	bindValueToFields(idFieldName,getValuesToBind,recordId){		
		$.ajax({
			type : "GET",
			url : getValuesToBind,
			contentType : "application/json; charset=utf-8",
			data : idFieldName + "=" +recordId,
			beforeSend : function() {
				$("body").addClass("loading");
			},
			success : function(result) {					
				 var columnsIn = result;			 
			        for(var key in columnsIn){		 
			        	var control= document.getElementById(key);
			        	if (control !=null){
			        		if (control.type ==="checkbox"){		        			
			        			control.checked=columnsIn[key];
			        		}else{
			        			control.value=columnsIn[key];
			        		}		        		
			        	}		            
			        } 
			},
			error: function(event, status, xhr) {	
				//alert(status);
				showErrorMessage();
			},
			complete: function(data, textStatus, xhr) {
				$("body").removeClass("loading");
			}
		});	
	}	
		
	saveRecord(){		
		 if(!$(this._editForm)[0].reportValidity()){		    		
			 return false;
		 }
		 var jsonObj=this.getDataObj(this._idFieldName,this._getValuesToBind);	 
		 this.saveDataObj(this._editForm,jsonObj,this._saveDataObject);		 		 
		 return true;
	}
	
	getDataObj(idFieldName,getValuesToBind){
		var jsonObj;
		$.ajax({
			type : "GET",
			url : getValuesToBind, 
			dataType : "json",
			async: false,
			contentType : "application/json; charset=utf-8",
			data : idFieldName +"="+0,
			beforeSend : function() {
				$("body").addClass("loading");
			},
			success : function(columnsIn) {	 
			        for(var key in columnsIn){			        	
			        	var control= document.getElementById(key);
			        	if (control !=null){			        		
			        		if (control.nodeName ==="TABLE"){			        			
			        			columnsIn[key]=getAllSelected(control.id);			   
			        		}else{
			        			columnsIn[key]=control.value;
			        		}		        		
			        	}		            
			        } 		        
			        jsonObj=columnsIn;			    	
			},
			error: function(event, status, xhr) {
				showErrorMessage();
			}
		});	
		return jsonObj;
	}
	
	saveDataObj(editForm, jsonObj,saveDataObject){
		if (jsonObj!=null){
			$.ajax({
	    		type : "POST",
	    		url : saveDataObject,
	    		contentType : "application/json; charset=utf-8",	    		
	    		async: false,
	    		data: JSON.stringify(jsonObj),	    		
	    		success : function(response) {
	    			$('.modal-backdrop').remove();
	    			callAlert("Save succesfully!");	    		},
	    		error: function (jqXHR, textStatus, errorThrown) {	
	    			//alert(errorThrown);  		    	
	    			showErrorMessage();
	    		},		
	    		complete: function(data, textStatus, xhr) {		    		
	    			$("body").removeClass("loading");
	    		}
	    	});
		}
	}
}
//End of EditForm Class
//--------------------------------------------

function getDataColumn(tableObjectName,numberOfColumns,type){
	var dynamicColumns=[];

	dynamicColumns.length=numberOfColumns;		

    var n=numberOfColumns-1;
    if(type==null){    	
    	dynamicColumns[0]= {
             	"render": function ( ddata, type, row ) {
             		var id = row[0];
             		return '<input type="hidden" class="hide" name="touchbutton" id='+id+' value='+id+'>';
             	},
             	"orderable": false,
             	"visible":false
             };    	
    }else{    	
    	switch (type){
    		case "edit":
    			dynamicColumns[0]= {
                 	"render": function ( ddata, type, row ) {
                 		var id = row[0];
                 		return '<input type="hidden" class="hide" name="touchbutton" id='+id+' value='+id+'>';
                 	},
                 	"orderable": false,
                 	"visible":false
                 };  
	    		dynamicColumns[n]= {"render" : function(data,type,row) {				
	    			return '<div class="table-data-feature">'
	    			+'<button id="btnEdit" class="item" data-toggle="tooltip" data-placement="top" title="Edit" data-backdrop="false" onclick="'+tableObjectName +'._editFormObj.openEditModal('+row[0]+')" ><i class="zmdi zmdi-edit"></i></button>'
	    			+'<button id="btnDelete" class="item" data-toggle="tooltip" data-placement="top" title="Delete" onclick="callDeleteDialog('+row[0]+','+tableObjectName+')"><i class="zmdi zmdi-delete"></i></button>'
	    			+'</div>';
	    		},
	    		sClass: "alignCenter",
	    		"orderable": false
	    		}
	    		break;
    		case "checkbox":
    			dynamicColumns[0]={
    				"render" : function(ddata, type, row ) {
    					var id = row[0];    				
    					return '<input type="checkbox" name="id[]" class="chkBox" '+row[n+1]+' id="'+ id +'" >';
    					},
    					"orderable": false
    			};	    		
    			break;
    		case "radio":
    			dynamicColumns[0]= {
                 	"render": function ( ddata, type, row ) {
                 		var id = row[0];                 		                 		
                 		return '<input type="radio" class="singleRadio" name="touchbutton" id='+id+' value='+id+'>';
                 	},
                 	"orderable": false
                 };
    			break;
    	} 		    
    }
	return dynamicColumns;
}

function getDataRow(data){     
    var rowDataSet = [];
    var i = 0;
    $.each(data, function (key, value) {    	
        var rowData = [];
        var j = 0;
        $.each(data[i], function (key, value) {
            rowData[j] = value;           
            j++;
        });
        rowDataSet[i] = rowData;
        i++;
    });
    return rowDataSet;
}

function buildTable(tableObj, dynamicColumns,rowDataSet){	
	var table=$(tableObj._tableId);    
    var bFilter =tableObj._bFilter;    
    var checkAllId=tableObj._checkAllId;
    var bInfo=tableObj._bInfo;
    if (bFilter==null){
    	bFilter=true;
    }
    if (bInfo==null){
    	bInfo=true;
    }
    var bPaginate=tableObj._bPaginate;
    if (bPaginate==null){
    	bPaginate=true;
    }
    var pageLength=this._pageLength;
    
    var bLengthChange=this._bLengthChange;
    var order=tableObj._order;
    
    var ordering =true;
    if(order!=null){
    	ordering=false;    	
    }else {
    	order=1;
    }    
    var dataTable=table.DataTable({
	"ordering" : ordering,
	"order": [[ order, "asc" ]],
	"bPaginate" : bPaginate,
	"bLengthChange" : bLengthChange,
	"lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
	"bAutoWidth": false,
	"bFilter" : bFilter,
	"bInfo" : bInfo,	
    "aaData": rowDataSet,
    "columns": dynamicColumns,
    "responsive": true,
    "retrieve": true
    });
    
	dataTable.clear().draw();
	dataTable.rows.add(rowDataSet).draw();
	
	if ($(checkAllId)!=null){
       	if (table.DataTable().$(".chkBox:checked", { "page": "all" }).length == table.DataTable().rows().data().length){       		
       		$(checkAllId).prop('checked', true);            
        }else{        	
        	$(checkAllId).prop('checked', false);
        }
       	
        $(checkAllId).on('click', function(){
 	       var rows = table.DataTable().rows({ 'search': 'applied' }).nodes();
 	       $('input[type="checkbox"]', rows).prop('checked', this.checked);
 	    });	
 	    table.on('change', 'input[type="checkbox"]', function(){
 	       	if(!this.checked){
 				$(checkAllId).prop("checked",false);
 	       	} 
 	       	if (table.DataTable().$(".chkBox:checked", { "page": "all" }).length == table.DataTable().rows().data().length){
 	            $(checkAllId).prop('checked', true);
 	        }
 	    });  
	}
}

function getAllSelected(tableId){
	var selected = [];
	var allPages = $('#'+tableId).DataTable().cells().nodes();
	$(allPages).find('input[type="checkbox"]:checked').each(function() {
	    selected.push($(this).attr('id'));
	});
	
	return selected;
}

function showInformationDialog(title,message){
	doModal("infoModal",title,message,"");
}

function cancelProcess() {
	$("body").removeClass("loading");
}

function showErrorMessage(){	
	showInformationDialog("Error Message","Sorry, an error has occurred! Please contact Administrator to troubleshoot.");
}

function extractLast( term ) {
    return split( term ).pop();
  }

function split( val ) {
    return val.split( /,\s*/ );
}

function callAddForm(event){	
	event.data.editForm.openAddModal();
}

function callDeleteDialog(id,tableObj){
	doModal("confirmModal","Confirmation","Are you sure to delete this record?","Confirm");
	if ($("#btnSubmit")!=null){
		$("#btnSubmit").off("click");	
		$("#btnSubmit").click({id:id,tableObj:tableObj},function(event){			
			var listId=[];
			listId.push(event.data.id);
			event.data.tableObj.deleteRecord(listId);
			$("#confirmModal").modal('toggle');
		});	
	}	
}

function callAlert(message){
	html ='<i class="zmdi zmdi-check-circle"></i>';
	html += '<span class="content">'+message +'</span>';
	$("#alertDiv").html(html);
	$("#alertDiv").toggle("fast");
	setTimeout(function(){
	    		    $("#alertDiv").toggle("fast");
			  }, 2000);
}

function doModal(divId, heading, formContent,btnText) {
    html =  '<div id='+divId +' class="modal fade" tabindex="-1" role="dialog" aria-labelledby="confirm-modal" aria-hidden="true">';
    html += '<div class="modal-dialog">';
    html += '<div class="modal-content">';
    html += '<div class="modal-header">';    
    html += '<h4 class="modal-title">'+heading+'</h4>'
    html += '<button type="button" class="close" data-dismiss="modal">&times;</button>';
    html += '</div>';
    html += '<div class="modal-body" align="center">';
    html += formContent;
    html += '</div>';
    html += '<div class="modal-footer">';
    if (btnText!='') {
        html += '<span id="btnSubmit" class="btn btn-success"';
        html += '">'+btnText+'</span>';
    }
    html += '<span class="btn btn-primary" data-dismiss="modal">Close</span>';
    html += '</div>';  // content
    html += '</div>';  // dialog
    html += '</div>';  // footer
    html += '</div>';  // modalWindow
    $('body').append(html);
    $("#"+divId).modal();
    $("#"+divId).modal('show');	
    
    $('#'+divId).on('hidden.bs.modal', function (e) {
        $(this).remove();
    });
}

function loadHtml(divAndHtmlList){		
	for (var i=0;i< divAndHtmlList.length;i++){	
		$('#'+divAndHtmlList[i][0]).load(divAndHtmlList[i][1]);
	}	
}

function createBreadcrumb(breadcrumbDiv, itemAndLinkList){
	var html='<div class="row">';
	html +='<div class="col-md-12">';
	html +='<div class="au-breadcrumb-content">';
	html +='<div class="au-breadcrumb-left">'
	
	html +='<ul class="list-unstyled list-inline au-breadcrumb__list">';
	var n=itemAndLinkList.length-1;	
	for (var i=0;i<n ;i++){
		html +='<li class="list-inline-item active">';
		html += '<a class="active-link" href="'+itemAndLinkList[i][1] +'">'+ itemAndLinkList[i][0] + '</a>';
		html +='</li>';
		html +='<li class="list-inline-item seprate"><span> / </span></li>';		
	}			
	html +='<li class="list-inline-item">'+ itemAndLinkList[n][0] +'</li>';
	html +='</ul></div></div></div></div>';	
	$('#'+breadcrumbDiv).html(html);	
}

$(document).ajaxError(function(event, jqXHR, ajaxSettings, thrownError) {
	if (undefined != jqXHR.responseText && "" != jqXHR.responseText && jqXHR.status == 200) {
		showErrorMessage();
		return;
	} 
});

