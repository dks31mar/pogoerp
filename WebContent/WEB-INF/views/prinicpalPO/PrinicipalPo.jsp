<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<script src="resources/bootstrap-3.3.6/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="resources/css/displaytag.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/messagebox.css" />
<link rel="stylesheet" type="text/css" href="resources/css/autocom.css" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<%
//HttpSession session=request.getSession();
String hh=(String)session.getAttribute("jsonp");
String norml=(String)session.getAttribute("normal");
String cb=(String)session.getAttribute("CBW");
/* Integer total=(Integer)session.getAttribute("total"); */
java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("MM/dd/yyyy");
java.util.Date date = new java.util.Date();
System.out.println();
%>
<form method="POST" action="savepodetails">
		<div class="row" style="margin-top: 15px">
			<br>
			<div align="center">
				<i>
				
				</i> <input type="hidden" name="profile" value="0" />
			</div>
		</div>

		<div class="row">

			<div class="page-heading col-sm-11" id="createpo"
				style="background-color: #3C8DBC; left: 10px">
				<span class="glyphicon glyphicon-copy"></span> Create PO
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="normal" type="radio"
					name="potype" checked />Normal <input id="CBW" type="radio"
					name="potype" />CBW
				
			</div>
		</div>

		<div class="row" id="editpo">
			<div class="page-heading col-sm-11"
				style="background-color: #3C8DBC; left: 10px">
				<span class="glyphicon glyphicon-copy"></span> Edit PO
			</div>
		</div>
		
		
	<div style="border: 1px solid #CCCCCC; padding: 7px; width: 93%">
		<div class="row form-group">

				<div class="col-sm-3 form-level">
					PO Reference No:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-4">
					<input type="text" name="porefno" placeholder="PO Reference No."
						onkeyup="myFunction()" id="porefno" size="150" value="<%=norml %>"
						class="form-control" />
				</div>

				<div class="col-sm-1 form-level">
					Date:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-2">
					<span> <input path="" type="text" class="form-control" name="dateTodate"
						id="datepicker" value="<%=dateFormat.format(date) %>" ReadOnly></input>
						
					</span>

				</div>
			</div>
			<div class="row form-group">
				<div class="col-sm-3 form-level">
					Principal Name:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-9">
					<input type="text" name="principalname"
						placeholder="Principal Name" value="YMC Co. Ltd., Japan"
						class="form-control" style="display: inline-block;" ReadOnly>
				</div>
			</div>
			<div class="row form-group">
				<div class="col-sm-3 form-level">
					Address:<font color="#FF0000">*</font>
				</div>
				<div class="col-sm-9">
					<textarea rows="4" cols="77" name="address"
						style="border-radius: 5px; background-color: #f2f2f2;" readonly>YMC CO.,LTD. YMC Karasuma-Gojo Building 284 Daigo-cho Karasuma Nishiliru Gojo-dori,Shimogyo -Ku Kyoto 600-8106 Japan"  </textarea>
						
				</div>
			</div>
			<hr style="color: black">
					<div class="row form-group">
						<div class="col-sm-7">
						</div>
					</div>
				
					<table style="width: 100%; bottom: 15px; position: relative;" border="0" id="quotprodtable">
					<thead>
						<tr bgcolor="#3C8DBC">
							<td style="display: none;"><label>id</label> </td>
									<td class="col-sm-1 form-level" style="width: 10px">&nbsp;
										<font size="2" color="white">
										<label>S.No.</label></font></td>
									<td class="col-sm-3 form-level" style="width: 80px"align="center">&nbsp;<font size="2" color="white">
										<label >Part No</label></font></td>
									<td align="center" class="col-sm-1 form-level"style="width: 80px">&nbsp;&nbsp;&nbsp;<font size="2" color="white">
										<label >Description</label></font></td>
									<td align="center">&nbsp;<font size="2" style="width: 80px"color="white">
										<label >TP In JPY</label></font></td>
									<td align="center">&nbsp;<font size="2" style="width: 80px"color="white">
										<label >QTY</label></font></td>
									<td align="center">&nbsp;<font size="2" style="width: 80px"color="white">
										<label >Total JPY</label></font></td>
									<td align="center">&nbsp;<font size="2" style="width: 65px"color="white">
										<label >Customer PO Reference</label></font></td>
							<%-- <td align="center"> &nbsp;<font size="2" style="width: 80px" color="white"><label path="">Total INR</label></font> --%>
					
					</tr>
					</thead>
					<tbody id="addprolisttbody">
					
					</tbody>
					</table>
					
					<table>
					<tr>
					<td style="display: none;"><input type="hidden" value="" id="getid1"></input> </td>
					<td style="right: 5px; position: relative;">&nbsp; 
					<input type='text' style='width: 60px' name='posrno' id='sr'
								value="" class='form-control'/></td>
							<td style="left: 2px; position: relative; width: 150px">&nbsp;
								<input type='text' value="" name='particulee1'
								style='overflow: auto; border-radius: 3px; width: 223px;'
								id='autocomplete' class='form-control'
								/>
							</td>
							<td style="width: 250px">&nbsp; <input name='description'
									id='description' class='form-control'
									style="text-align: center;width: 238px;" value="" onfocus='closeDiv();'></input></td>
							
							<td style="right: 7px; position: relative;">&nbsp; <input
								type='text' style='text-align: center;' name='tpinjpy' 
								id='tpinjpy' value="" class='form-control' /></td>

							<td align="center" style="right: 4px; position: relative;">&nbsp;
								<input  type='text' style='text-align: center;' name='qty'
								id='qty' class='form-control' value=""
								onfocus='closeDiv();'/>
							</td>
							<td align="center">&nbsp; 
							<input  type='text'
								style='text-align: center;' name='totaljpy' id='totaljpy' value=""
								class='form-control'  onfocus='closeDiv();'/></td>

							<td align="center">&nbsp; 
							
							<input type='text'
								style='text-align: center;width: 132px;' onkeyup='this.value=value.toUpperCase();' 
								name='customerporefe' id='customerporefe' value=""
								class='form-control'/>
								
							</td>
							<td>
								<input type="hidden" style="text-align:center;" name="unitcost" id="unitcostx" value="" class="form-control"  ></td>
							<td>
							<td align="center">&nbsp; <input type="button" value='+'
							 id='addmorepro12' class='btn btn-success pull-right' data-toggle='tooltip'
								title='Add More Product'/>
					</tr>
					
					</table>
</form>

			
				<div class="row form-group" style="top: 10px; position: relative;"
					onclick="">
					<div class="col-sm-10 form-level" align="right">
						Total:<font color="#FF0000"></font>
					</div>
					<div align="right">
						<input type="text" name="tjpy1" id="tjpy1" class="form-control"
							value="${total}" style="width: 15%;" readonly="true">
					</div>
				</div>

				<hr align="left" size="1" width="100%"
					style="background-color: #000000" />

				<div align="center">



					<tr>
						<td align="center">
							<button type="button" value="update" onclick="updatebutton();"
								class="btn btn-success pull-center" id="update"
								style="background-color: #3C8DBC;">Update</button>
						</td>
						<td>&nbsp;&nbsp;&nbsp;</td>
						<td>
							<button type="button" value="update" onclick="updatebutton();"
								class="btn btn-success pull-center" id="print"
								style="background-color: #3C8DBC;">Print</button>
						</td>
						<td>&nbsp;&nbsp;&nbsp;</td>
						<td>
							<button type="button" value="update" onclick=""
								class="btn btn-success pull-center" id="pdf"
								style="background-color: #3C8DBC;">PDF</button>
						</td>
						<td>&nbsp;&nbsp;&nbsp;</td>
						<td>
							<button type="button" value="update" onclick="updatebutton();"
								class="btn btn-success pull-center" id="back"
								style="background-color: #3C8DBC;">Back</button>
						</td>
						<td>
							<button type="button" value="update"
								class="btn btn-success pull-center" id="addmore"
								style="background-color: #3C8DBC;">Add More</button>
						</td>

					</tr>


					</table>



					<button type="button" value="Save" onClick=""
						class="btn btn-success pull-center" id="savedata445"
						style="background-color: #3C8DBC;">Save</button>
					<!-- <button type="button" value="AddMore" onClick="productdetail();"
						class="btn btn-success pull-right"
						style="background-color: #3C8DBC;">Add More</button> -->


				</div>

			</div>
	
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/messagebox.js"></script>
<script type="text/javascript" src="resources/js/messagebox.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript"src="resources/js/jquery.autocomplete.min.js"></script>

<script src="https://cdn.jsdelivr.net/sweetalert2/6.1.0/sweetalert2.min.js"></script>
<script src="https://cdn.jsdelivr.net/sweetalert2/6.1.0/sweetalert2.js"></script>
<script>


$(document).ready(function(){
	var table = document.getElementById("quotprodtable");
	var len=table.rows.length-1;
	$('#sr').val('');
	$('#sr').val(len);
	
});
/* $(document).ready(function(){

}); */

$('#qty').keyup(function(){
	var qty=$('#qty').val();
	var unit=$('#unitcostx').val();
	var jpy=$('#tpinjpy').val();
	var total=parseInt(qty) * parseInt(jpy);
	$('#totaljpy').val(total);
	
	//alert(qty);
});
$(document).ready(function(){
	$('#editpo').hide();
	$('#update').hide();
	$('#back').hide();
	$('#pdf').hide();
	$('#print').hide();
	$('#addmore').hide();
    $('[data-toggle="tooltip"]').tooltip();
});

$("#normal").click(function(){
	$("#porefno").val("<%=norml%>");
});
$("#CBW").click(function(){
	$("#porefno").val("<%=cb%>");
});
$( function() {
    $( "#datepicker" ).datepicker();
  } );
  
  
  
  
$('#autocomplete').click(function(){
	$('#autocomplete').val('');
	$('#description').val('');
	$('#tpinjpy').val('');
	$('#qty').val('');
	$('#totaljpy').val('');
	$('#customerporefe').val('');
	$.ajax({
		url: "getpartno?word=b", 
		success: function(result){
			//alert(""+result)
			search(result);
			/* var currencies =jQuery.parseJSON(result);
			alert(currencies);
			$('#autocomplete').autocomplete({
			    lookup: currencies,
			    onSelect: function (suggestion) {
			      alert(suggestion);
			    }
			  }); */
    }});
	
});


function search(result){
var currencies =jQuery.parseJSON(result);
/* alert(currencies); */
$('#autocomplete').autocomplete({
    lookup: currencies,
    onSelect: function (suggestion) {
    var pro= suggestion.value;
      $.ajax({
			url: "getpartdetail?pro="+pro, 
			success: function(result){
					//alert("ddd");
				//$('#autocomplete').val('');
				for(i=0;i<result.length;i++){
					var data=result.replace('"','');
					data=data.replace('"','');
				}
			var	productdescription=data.split(',')[0]
			var cost=data.split(',')[1];
					//alert(productdescription);
				var unitcostx=data.split(',')[2];	
				
				//$('#particulee1').val(pro)
				$('#description').val(productdescription);
				$('#tpinjpy').val(cost);
				$('#unitcostx').val(unitcostx)
	    }});
      
      
    }
  });
}

 /* $(document).ready(function(){
	$('#savedata445').click(function(){
	$.ajax({
			url: "getviewproduct",
			type: "POST",
			
			success: function(result){
				$('#editpo').show();
				$('#update').show();
				$('#back').show();
				$('#pdf').show();
				$('#print').show();
				$('#addmore').show();
				$('#createpo').hide();
				$('#savedata445').hide();
				$('#mainForm').hide();
				
			}});
	});
}); */
 
 $('#addmore').click(function (){
	 $('#mainForm').show();
 });
 
 /* $(document).ready(function(){
		$('#saveproduct123').click(function(){
			var idd=$('#getid1').val();
			var  dis	= $('#description').val();
			var  partno	=$('#autocomplete').val();
			var	 tpn	=$('#tpinjpy').val();
			var	 qty	=$('#qty').val();
			var	 totjpy	=$('#totaljpy').val();
			var	 custpo	=$('#customerporefe').val();
			var jsonObj={'porefentryitemdetailid':'',
					'porefno':partno, 'particular':partno, 
				 	  	'tpinjpy':tpn,
				 	  'qty':qty,
				 	  'totaljpy':totjpy,
				 	  'customerporefe':custpo,
				 	  'productdescription':dis
			} ;
		$.ajax({
				url: "savedatadb",
				type: "POST",
				
				  data :JSON.stringify(jsonObj),
				  cache:false,
			        beforeSend: function(xhr) {  
			            xhr.setRequestHeader("Accept", "application/json");  
			            xhr.setRequestHeader("Content-Type", "application/json");  
			        },
				     success: function(resposeJsonObject){
				    	 
			     
			    }});
		});
	}); */
	
	
	
	 $(document).ready(function(){
		 var id=$('#addprolisttbody').children('tr').length;
		 $('#sr').val(id+1);
	        $("#addmorepro12").click(function(){
	        	var id=$('#addprolisttbody').children('tr').length+1;
	        	var idd=$('#getid1').val();
				var  dis	= $('#description').val();
				var  partno	=$('#autocomplete').val();
				var	 tpn	=$('#tpinjpy').val();
				var	 qty	=$('#qty').val();
				var	 totjpy	=$('#totaljpy').val();
				var	 custpo	=$('#customerporefe').val();
	            var markup = "<tr>"+
					"<td style='display: none;'><input type='hidden' value='"+idd+"' id='getid"+id+"'></input> </td>"+
					"<td style='right: 5px; position: relative;'>&nbsp;"+ 
					"<input type='text' style='width: 60px' name='posrno' id='sr"+id+"' value='"+id+"' class='form-control' readonly/></td>"+
					"<td style='left: 2px; position: relative; width: 150px'>&nbsp;"+
					"<input readonly type='text' value='"+partno+"' name='particulee1'style='overflow: auto; border-radius: 3px; width: 223px;'id='partno"+id+"' class='form-control'/></td>"+
					"<td style='width: 250px'>&nbsp; <input readonly name='description' id='description"+id+"' class='form-control' style='text-align: center;width: 238px;' value='"+dis+"' onfocus='closeDiv();'></input></td>"+
					"<td style='right: 7px; position: relative;'>&nbsp; <input readonly type='text' style='text-align: center;' name='tpinjpy' id='tpinjpy"+id+"' value='"+tpn+"' class='form-control' /></td>"+
					"<td align='center' style='right: 4px; position: relative;'>&nbsp;<input readonly type='text' style='text-align: center;' name='qty' id='qty"+id+"' class='form-control' value='"+qty+"' onfocus='closeDiv();'/></td>"+
					"<td align='center'>&nbsp; <input readonly type='text' style='text-align: center;' name='totaljpy' id='totaljpy"+id+"' value='"+totjpy+"' class='form-control'  onfocus='closeDiv();'/></td>"+
					"<td align='center'>&nbsp;<input readonly type='text' style='text-align: center;width: 132px;' onkeyup='this.value=value.toUpperCase();' name='customerporefe' id='customerporefe"+id+"' value='"+custpo+"' class='form-control'/>"+
					"</td>"+
					"<td><input type='hidden' style='text-align:center;' name='unitcost' id='unitcostx' value='' class='form-control'  ></td>"+
					"<td><a class='glyphicon glyphicon-pencil' href='#'></a> | <a class='glyphicon glyphicon-remove' href='#' onclick='deletethisrow("+(id)+")' id="+(id)+"></a></td>"+
					"</tr>";
	            $("#addprolisttbody").append(markup);
	            //id++;
	            $('#sr').val(id+1);
	        });
	 });
	
	
	function deletethisrow(id){
		
			 $("#"+id).parents("tr").remove();
		id=$('#addprolisttbody').children('tr').length;
		 $('#sr').val(id+1);
		 for (i=0;i<id ; i++){
			 
		 }
	}
	
	
	$('#savedata445').click( function() {
		  var table = $('#quotprodtable').tableToJSON();
		  console.log(table);
		  alert(JSON.stringify(table));  
		});
	
	
	
	(function ($) {
	    'use strict';

	    $.fn.tableToJSON = function (opts) {

	        // Set options
	        var defaults = {
	            ignoreColumns: [],
	            onlyColumns: null,
	            ignoreHiddenRows: true,
	            headings: null,
	            allowHTML: false
	        };
	        opts = $.extend(defaults, opts);

	        var notNull = function (value) {
	            return value !== undefined && value !== null;
	        };

	        var ignoredColumn = function (index) {
	            if (notNull(opts.onlyColumns)) {
	                return $.inArray(index, opts.onlyColumns) === -1;
	            }
	            return $.inArray(index, opts.ignoreColumns) !== -1;
	        };

	        var arraysToHash = function (keys, values) {
	            var result = {}, index = 0;
	            $.each(values, function (i, value) {
	                // when ignoring columns, the header option still starts
	                // with the first defined column
	                if (index < keys.length && notNull(value)) {
	                    result[keys[index]] = value;
	                    index++;
	                }
	            });
	            return result;
	        };

	        var cellValues = function (cellIndex, cell) {
	            var value, result;
	            if (!ignoredColumn(cellIndex)) {
	                var override = $(cell).data('override');
	                if (opts.allowHTML) {
	                    value = $.trim($(cell).html());
	                } else {
	                    value = $.trim($(cell).text());
	                }
	                result = notNull(override) ? override : value;
	            }
	            return result;
	        };

	        var rowValues = function (row) {
	            var result = [];
	            $(row).children('td,th').each(function (cellIndex, cell) {
	                if (!ignoredColumn(cellIndex)) {
	                    result.push(cellValues(cellIndex, cell));
	                }
	            });
	            return result;
	        };

	        var getHeadings = function (table) {
	            var firstRow = table.find('tr:first').first();
	            return notNull(opts.headings) ? opts.headings : rowValues(firstRow);
	        };

	        var construct = function (table, headings) {
	            var i, j, len, len2, txt, $row, $cell,
	            tmpArray = [],
	                cellIndex = 0,
	                result = [];
	            table.children('tbody,*').children('tr').each(function (rowIndex, row) {
	                if (rowIndex > 0 || notNull(opts.headings)) {
	                    $row = $(row);
	                    if ($row.is(':visible') || !opts.ignoreHiddenRows) {
	                        if (!tmpArray[rowIndex]) {
	                            tmpArray[rowIndex] = [];
	                        }
	                        cellIndex = 0;
	                        $row.children().each(function () {
	                            if (!ignoredColumn(cellIndex)) {
	                                $cell = $(this);

	                                // process rowspans
	                                if ($cell.filter('[rowspan]').length) {
	                                    len = parseInt($cell.attr('rowspan'), 10) - 1;
	                                    txt = cellValues(cellIndex, $cell, []);
	                                    for (i = 1; i <= len; i++) {
	                                        if (!tmpArray[rowIndex + i]) {
	                                            tmpArray[rowIndex + i] = [];
	                                        }
	                                        tmpArray[rowIndex + i][cellIndex] = txt;
	                                    }
	                                }
	                                // process colspans
	                                if ($cell.filter('[colspan]').length) {
	                                    len = parseInt($cell.attr('colspan'), 10) - 1;
	                                    txt = cellValues(cellIndex, $cell, []);
	                                    for (i = 1; i <= len; i++) {
	                                        // cell has both col and row spans
	                                        if ($cell.filter('[rowspan]').length) {
	                                            len2 = parseInt($cell.attr('rowspan'), 10);
	                                            for (j = 0; j < len2; j++) {
	                                                tmpArray[rowIndex + j][cellIndex + i] = txt;
	                                            }
	                                        } else {
	                                            tmpArray[rowIndex][cellIndex + i] = txt;
	                                        }
	                                    }
	                                }
	                                // skip column if already defined
	                                while (tmpArray[rowIndex][cellIndex]) {
	                                    cellIndex++;
	                                }
	                                if (!ignoredColumn(cellIndex)) {
	                                    txt = tmpArray[rowIndex][cellIndex] || cellValues(cellIndex, $cell, []);
	                                    if (notNull(txt)) {
	                                        tmpArray[rowIndex][cellIndex] = txt;
	                                    }
	                                }
	                            }
	                            cellIndex++;
	                        });
	                    }
	                }
	            });
	            $.each(tmpArray, function (i, row) {
	                if (notNull(row)) {
	                    txt = arraysToHash(headings, row);
	                    result[result.length] = txt;
	                }
	            });
	            return result;
	        };

	        // Run
	        var headings = getHeadings(this);
	        return construct(this, headings);
	    };
	})(jQuery);
</script>


