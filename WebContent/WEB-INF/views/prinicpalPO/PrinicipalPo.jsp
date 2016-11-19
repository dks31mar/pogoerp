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
					<span> <input type="text" class="form-control" name="dateTodate"
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
									style="text-align: center;width: 238px;" value="" ></input></td>
							
							<td style="right: 7px; position: relative;">&nbsp; <input
								type='text' style='text-align: center;' name='tpinjpy' 
								id='tpinjpy' value="" class='form-control' /></td>

							<td align="center" style="right: 4px; position: relative;">&nbsp;
								<input  type='text' style='text-align: center;' name='qty'
								id='qty' class='form-control' value=""/>
							</td>
							<td align="center">&nbsp; 
							<input  type='text'
								style='text-align: center;' name='totaljpy' id='totaljpy' value=""
								class='form-control'  /></td>

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
							value="${total}" style="width: 15%;" readonly>
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
				});
				$('#autocomplete').on("click",function(){
				var word=$('#autocomplete').val();
		
		//alert($(e.target).val() );	
			$.ajax({
				url: "getpartno?word="+word, 
				success: function(result){
					
					search(result);
					
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
						for(i=0;i<result.length;i++){
							var data=result.replace('"','');
							data=data.replace('"','');
						}
					var	productdescription=data.split(',')[0]
					var cost=data.split(',')[1];
						
						var unitcostx=data.split(',')[2];	
						
						
						$('#description').val(productdescription);
						$('#tpinjpy').val(cost);
						$('#unitcostx').val(unitcostx)
			    }});
		      
		      
		    }
		  });
		}
		
		 
		 $('#addmore').click(function (){
			 $('#mainForm').show();
		 });
		 
		 
			
			
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
						var poref=$('#porefno').val();
						var date=$('#datepicker').val();
			            var markup = "<tr>"+
			            "<td style='display: none;'><input type='hidden' name='date"+id+"' value='"+date+"' id='getdate"+id+"'></input> </td>"+
			            "<td style='display: none;'><input type='hidden' name='porefno' value='"+poref+"' id='getporefno"+id+"'></input> </td>"+
							"<td style='display: none;'><input type='hidden' name='' value='"+idd+"' id='getid'"+id+"'></input> </td>"+
							"<td style='right: 5px; position: relative;'>&nbsp;"+ 
							"<input type='text' style='width: 60px' name='' id='sr"+id+"' value='"+id+"' class='form-control' readonly/></td>"+
							"<td style='left: 2px; position: relative; width: 150px'>&nbsp;"+
							"<input readonly type='text' value='"+partno+"' name='particulee1'style='overflow: auto; border-radius: 3px; width: 223px;'id='partno"+id+"' class='form-control'/></td>"+
							"<td style='width: 250px'>&nbsp; <input readonly name='description' id='description"+id+"' class='form-control' style='text-align: center;width: 238px;' value='"+dis+"' ></input></td>"+
							"<td style='right: 7px; position: relative;'>&nbsp; <input readonly type='text' style='text-align: center;' name='tpinjpy' id='tpinjpy"+id+"' value='"+tpn+"' class='form-control' /></td>"+
							"<td align='center' style='right: 4px; position: relative;'>&nbsp;<input readonly type='text' style='text-align: center;' name='qty' id='qty"+id+"' class='form-control' value='"+qty+"' /></td>"+
							"<td align='center'>&nbsp; <input readonly type='text' style='text-align: center;' name='totaljpy' id='totaljpy"+id+"' value='"+totjpy+"' class='form-control'  /></td>"+
							"<td align='center'>&nbsp;<input readonly type='text' style='text-align: center;width: 132px;' onkeyup='this.value=value.toUpperCase();' name='customerporefe' id='customerporefe"+id+"' value='"+custpo+"' class='form-control'/>"+
							"</td>"+
							"<td style='display: none;'><input type='hidden' name='grandtotal' value='' id='grandtotal"+id+"'></input> </td>"+"<td style='display: none;'><input type='hidden' name='date' value='"+date+"' id='getdate"+id+"'></input> </td>"+
							"<td><input type='hidden' style='text-align:center;' name='unitcost' id='' value='split' class='form-control'  ></td>"+
							"<td><a class='glyphicon glyphicon-pencil' href='#' onclick='editfields("+(id)+")'></a> | <a class='glyphicon glyphicon-remove' href='#' onclick='deletethisrow("+(id)+")' id="+(id)+"></a></td>"+
							"</tr>";
			            $("#addprolisttbody").append(markup);
			            //id++;
			            $('#sr').val(id+1);
			            
			            var d;
						var d1;
						var d2=0;
						 var id=$('#addprolisttbody').children('tr').length;
						for(var i=1;i<=id;i++){
						d=$('#totaljpy'+i).val();
						
						d1=parseInt((d), 10);
						d2=parseInt((d1), 10)+parseInt((d2), 10);
						}
						$('#tjpy1').val(d2);
					var d=$('#tjpy1').val();
					$('#grandtotal1').val(d);
			        });
			 });
			
			 
			 $('#datepicker').change(function(){
				 alert('fffff');
				var id=$('#addprolisttbody').children('tr').length+1;
				 var date= $('#datepicker').val();
				 alert(date+"     "+id);
				 for(var i=0;i<=id ; i=i+1){
					 
					 $('#getdate'+i).val(date);
					 alert(i);
				 }
			 });
			function deletethisrow(id){
				
					 $("#"+id).parents("tr").remove();
				id=$('#addprolisttbody').children('tr').length;
				 $('#sr').val(id+1);
				 for (i=0;i<id ; i++){
					 
				 }
			}
			
			
			$("#savedata445").bind("click", function() {
				  var AddressesDataJSON = $("#quotprodtable").find('input').serializeArray();
				  console.log(AddressesDataJSON);
				  alert(JSON.stringify(AddressesDataJSON));
				  
				  
				 $.ajax({
						url: "savedatadb",
						type: "POST",
						
						  data :JSON.stringify(AddressesDataJSON),
						  cache:false,
					        beforeSend: function(xhr) {  
					            xhr.setRequestHeader("Accept", "application/json");  
					            xhr.setRequestHeader("Content-Type", "application/json");  
					        },
						     success: function(resposeJsonObject){
						    	 
						    	 //location.reload();
						    	 alert('saved!!!');
					    }
					}); 
				});
			
			
				function editfields(id){
					var d=$('#totaljpy'+id).val();
					$('#partno'+id).attr("readonly", false);
					$('#qty'+id).attr("readonly", false); 
					$('#customerporefe'+id).attr("readonly", false); 
					
					
					
					
					$('#qty'+id).keyup(function(){
						
						var d1=$('#tjpy1').val();
						$('#tjpy1').val(parseInt((d1), 10)-parseInt((d), 10));
						var qty=$('#qty'+id).val();
						var unit=$('#unitcostx').val();
						var jpy=$('#tpinjpy'+id).val();
						var total=parseInt(qty) * parseInt(jpy);
						$('#totaljpy'+id).val(total);
						var d2=$('#totaljpy'+id).val();
						var d3=$('#tjpy1').val();
						$('#tjpy1').val(parseInt((d3), 10)+parseInt((d2), 10));
					var grandtotl=	$('#tjpy1').val();
						$('#grandtotal1').val(grandtotl);
					});
					
					$('#partno'+id).click(function(){
						var word=$('#partno'+id).val();
						$.ajax({
							url: "getpartno?word="+word, 
							success: function(result){
								search1(result);
								
					    }});
						
					});
					
					function search1(result){
						var currencies =jQuery.parseJSON(result);
					$('#partno'+id).autocomplete({
					    lookup: currencies,
					    onSelect: function (suggestion) {
					    var pro= suggestion.value;
					      $.ajax({
								url: "getpartdetail?pro="+pro, 
								success: function(result){
									for(i=0;i<result.length;i++){
										var data=result.replace('"','');
										data=data.replace('"','');
									}
								var	productdescription=data.split(',')[0]
								var cost=data.split(',')[1];
								var unitcostx=data.split(',')[2];	
									$('#description'+id).val(productdescription);
									$('#tpinjpy'+id).val(cost);
									$('#unitcostx'+id).val(unitcostx)
						    }});
					      
					      
					    }
					  });
					}
					
				}
			
				
		
</script>


