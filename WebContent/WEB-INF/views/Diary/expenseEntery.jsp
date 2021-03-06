<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />

<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
 <script src="resources/bootstrap-3.3.6/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="resources/css/displaytag.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/messagebox.css" />

<link rel="stylesheet" type="text/css" href="resources/css/autocom.css" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<% 
java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
java.util.Date date = new java.util.Date();
System.out.println();
%>
<% Integer iduser=(Integer)session.getAttribute("userid"); %>


<style>
input {
text-align: center;
}
</style>
<div class="row" style="margin-top: 15px">
	<br>
	<div align="center">
		<input type="hidden" name="profile" value="0" />
	</div>
</div>

<input type="hidden" id="sessionid" value="<%=iduser %>"/>

<div class="row">
	<div class="page-heading col-sm-11" id=""
		style="background-color: #3C8DBC; left: 10px">
		<span class="fa fa-money"></span> Expense Entry
	</div>
</div>
<div style="border: 1px solid #CCCCCC; padding: 7px; width: 93%">
	<div class="row form-group">
		<div class="col-sm-3 form-level">
			Customer name<font color="#FF0000">*</font>
		</div>
		<div class="col-sm-3">
			<input  type='text' value="" name='particulee1' 
				style='overflow: auto; text-align: left;' id="autocomplete" class='form-control' required/>
				<span style="color: red" id="msg1">*This field is required.</span>
		</div>
		<div class="col-sm-2 form-level">
			Creation Date<font color="#FF0000">*</font>
		</div>
		<div class="col-sm-2">
			<span> <input type="text" class="form-control"
				name="dateTodate" id="creationdate" style='text-align: left;'
				value="<%=dateFormat.format(date) %>" ReadOnly></input></span>
				<span style="color: red" id="msg2">*This field is required.</span>
		</div>
	</div>
	<div class="row form-group">
		<div class="col-sm-3 form-level">
			Address
		</div>
		<div class="col-sm-9">
			<textarea rows="4" cols="77" name="address"
				style="border-radius: 5px; background-color: #f2f2f2; text-align: left;"  id="addr" ReadOnly> </textarea>
		</div>
	</div>

<hr style="color: black">
<div class="row form-group">
	<div class="col-sm-7"></div>
</div>
<table style="width: 100%; bottom: 15px; position: relative;" border="0" id="quotprodtable">
	
	<thead id=hidethisthird1>
		<tr bgcolor="#3C8DBC">
		<td style="display: none;"><label>id</label> </td>
			<td align="center">&nbsp;<font size="2" style="width: 65px"
				color="white"><label>S.No.</label></font></td>
			<td align="center">&nbsp;<font size="2" style="width: 65px"
				color="white"><label>Date</label></font></td>
				
			<td align="center">&nbsp;<font size="2" style="width: 65px"
				color="white"><label>Expense Head</label><font
					color="#FF0000">*</font></font></td>
			<td align="center">&nbsp;<font size="2" style="width: 65px"
				color="white"><label>Description</label></font></td>

			<td align="center">&nbsp;<font size="2" style="width: 80px"
				color="white"><label id="">Rates</label><font
					color="#FF0000">*</font></font></td>
			<td align="center">&nbsp;<font size="2" style="width: 80px"
				color="white"><label>Qty</label><font
					color="#FF0000">*</font></font></td>
			<td align="center">&nbsp;<font size="2" style="width: 80px"
				color="white"><label id="">Total</label></font></td>

		</tr>
	</thead>
	<tbody id="addprolisttbody">
	
	</tbody>
</table>


<table>
<thead id=hidethisthird>
		<tr bgcolor="#3C8DBC">
		<td style="display: none;"><label>id</label> </td>
			<td align="center">&nbsp;<font size="2" style="width: 65px"
				color="white"><label>S.No.</label></font></td>
			
			<td align="center">&nbsp;<font size="2" style="width: 65px"
				color="white"><label>Date</label></font></td>	
				
			<td align="center">&nbsp;<font size="2" style="width: 65px"
				color="white"><label>Expense Head</label><font
					color="#FF0000">*</font></font></td>
			<td align="center">&nbsp;<font size="2" style="width: 65px"
				color="white"><label>Description</label></font></td>

			<td align="center">&nbsp;<font size="2" style="width: 80px"
				color="white"><label id="">Rates</label><font
					color="#FF0000">*</font></font></td>
			<td align="center">&nbsp;<font size="2" style="width: 80px"
				color="white"><label>Qty</label><font
					color="#FF0000">*</font></font></td>
			<td align="center">&nbsp;<font size="2" style="width: 80px"
				color="white"><label id=""> Total </label></font></td>

		</tr>
	</thead>
	<tr>
	<td style="display: none;"><input type="hidden" value="" id="getid1" required></input> </td>
	
	<td style="right: 5px; position: relative;">&nbsp; 
					<input type='text' style='width: 60px' name='posrno' id='date'
								value="" class='form-control'/></td>
				<td style="right: 5px; position: relative;">&nbsp; 
					<input type='text' style='width: 60px' name='' id='exdate'
								value="<%=dateFormat.format(date) %>" class='form-control'/></td>				
								<td style="left: 2px; position: relative; width: 150px">&nbsp;
								<input type='text' value="" name='particulee1'
								style='overflow: auto; border-radius: 3px; width: 223px;'
								id='expenseauto' class='form-control'
								/><span style="color: red" id="msg3">*This field is required.</span>
							</td>
							
			<td style="width: 250px">&nbsp; <input name='description'
									id='description' class='form-control'
									style="text-align: center;width: 238px; text-transform: capitalize;' " value="" ></input></td>				
			
		
		
	 <td style="right: 7px; position: relative;">&nbsp;<input type='text' style='text-align: center;' name='' id='unittype' value="" class='form-control' /></td> 					
		<td align="center" style="right: 4px; position: relative;">&nbsp; <input  type='text' style='text-align: center;' name='' onkeypress='return event.charCode >= 48 && event.charCode <= 57' id='mul' class='form-control' value="" />
		<span style="color: red" id="msg5">*This field is required.</span>
		</td>		 
		<td style="width: 250px">&nbsp; <input name='description' id='total' class='form-control'style="text-align: center;width: 238px; text-transform: uppercase;" value="" readonly></input></td>			 
		
		<td align="center">&nbsp; <input type="button" value='+'
							 id='addmorepro12' class='btn btn-info pull-right' data-toggle='tooltip'
								title='Add More Expense'/>
		

		
		


	</tr>
</table>

<div class="row form-group" style="top: 10px; position: relative;"
					onclick="">
					<div class="col-sm-10 form-level" align="right">
						Total:<font color="#FF0000"></font>
					</div>
					<div align="right">
						<input type="text" name="gtotal" id="gtotal" class="form-control"

							value="${total}" style="width: 15%;" readonly>

							

					</div>
				</div>

<hr align="left" size="" width="100%" style="background-color: #3C8DBC;height: 1px; " />
<div align="center">
<table>
	<tr>
	 <td>&nbsp;&nbsp;</td>
	 <td><button type="button" value="Save" onClick="" class="btn btn-success pull-center" id="save" style="background-color: #3C8DBC;">Save</button></td>
	 <td>&nbsp;&nbsp;</td>
	 <td><button type="button" value="close" onClick="window.close()" class="btn btn-success pull-center" id="close" style="background-color: #3C8DBC;">Close</button></td>
	 </tr>
</table>
</div>
</div>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/messagebox.js"></script>
<script type="text/javascript" src="resources/js/messagebox.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript"
	src="resources/js/jquery.autocomplete.min.js"></script>

<script>

$(document).ready(function(){
	var table = document.getElementById("quotprodtable");
	var len=table.rows.length-1;
	$('#date').val('');
	$('#date').val(len);
	
});

$("#mul").keyup(function () {
	 /*  $('#unit/expense').keyup(function(){ */
		 // alert("hello");
	        
	       var qty = parseInt($('#mul').val()) || 0;
			//var unitexpense=$('#mul').val();
			//alert(unitexpense);
			//var unit=$('#unitcostx').val();
			var unittype =$('#unittype').val();
			
			//alert(unittype);
			var total=parseInt(qty) * parseInt(unittype);
			//alert(total1);
			$('#total').val(total);
			
			//alert(total1);
		});
		$('#qty').keyup(function(){
			//var qty=$('#qty').val();
			var qty = parseInt($('#qty').val()) || 0;
			var unit=$('#unitcostx').val();
			var jpy=$('#tpinjpy').val();
			var total=parseInt(qty) * parseInt(jpy);
			$('#totaljpy').val(total);
			
			//alert(qty);
		});
		
		
		
		/* $('#gtotal').keyup(function(){
			//var qty=$('#qty').val();
			//var gtotal = 0;
			var total = $('#total').val();
			var gtotal=$('#gtotal').val();
			
			var total1 = parseInt((total), 10)+parseInt((gtotal), 10);
			$('#totaljpy').val(total1);
			
			//alert(qty);
		}); */
		

$( function() {
    $( "#creationdate" ).datepicker({dateFormat: 'dd/mm/yy'});
  } );	
  
  
$( function() {
    $( "#exdate" ).datepicker({dateFormat: 'dd/mm/yy'});
  } ); 
 
$( function() {
    $( "#exdate+id+" ).datepicker({dateFormat: 'dd/mm/yy'});
  } );	 
	
/* $('#gtotal').keyup(function(){
	var grandtotal = $("#gtotal").val();
	var total = $("#total").val();
	 if(isNaN(grandtotal)){
		 $('#gtotal').val(total);
	} 
	}); */
   
  
  $('#autocomplete').on("click",function(){
	 // alert("list");
		//var word=$('#autocomplete').val();

//alert($(e.target).val() );	
	$.ajax({
		url: "getCustomerRecords", 
		success: function(result){
			console.log(result);
			search(result);
			
  }});
	
});
  
  function search(result){
	 
		var organisation =jQuery.parseJSON(result);
		// alert(organisation); 
		$('#autocomplete').autocomplete({
		    lookup: organisation,
		    onSelect: function (suggestion) {
		    var org= suggestion.value;
		      $.ajax({
					url: "getcompanydatabyname?organization="+org, 
					success: function(result){
						var data=jQuery.parseJSON(result);
						console.log(data);
						// alert(data.address);
						var address = data.address;
						//alert("address");
						$('#addr').text(address);
			    }});
		      
		      
		    }
		  });
		}
  
  
   $('#expenseauto').on("click",function(){
	 // alert("listfor expense");
		//var word=$('#autocomplete').val();

//alert($(e.target).val() );	
	$.ajax({
		url: "getexpenseautolist", 
		
		success: function(result){
			console.log(result);
			searchexp(result);
			
  }});
	
});
  
  
  function searchexp(result){
		 
		var expense =jQuery.parseJSON(result);
		// alert(expense); 
		$('#expenseauto').autocomplete({
		    lookup: expense,
		    onSelect: function (suggestion) {
		    var org= suggestion.value;
		      $.ajax({
					url: "getunitbyexpensehead?expensehead="+org, 
					success: function(result){
						var data=jQuery.parseJSON(result);
						console.log(data);
						// alert(data.unit);
						var rates = data.rates;
						//alert("unit");
						$('#unittype').val(rates);
			    }});
		      
		      
		    }
		  });
		}
 
 
 
  
  

	/*  $('#save').click(function (){
		
		var orgname =$('#autocomplete').val();
		var credate =$('#creationdate').val();
		var orgaddress =$('#addr').val();
		var date =$('#date').val();
		var expname =$('#expenseauto').val();
		var discription =$('#description').val();
		var unit =$('#unittype').val();
		var unitexpense =$('#mul').val();
		var total =$('#total').val();
		var gtotal = $('#gtotal').val();
		if(orgname == '' ){
			$("#msg1").show();
		}
		else{
			var jsonObj={'orgnisation':orgname ,
					'crdate':credate,
					'orgAddress':orgaddress,
					'date':date,
					'expname':expname,
					'description':discription,
					'unit':unit,
					'unit_expense':unitexpense,
					'total':total,
					'grandtotal':gtotal,
					
					
			
			} ;
			
		$.ajax({
				url: "saveexpenseentry",
				type: "POST",
				
				  data :JSON.stringify(jsonObj),
				  cache:false,
			        beforeSend: function(xhr) {  
			            xhr.setRequestHeader("Accept", "application/json");  
			            xhr.setRequestHeader("Content-Type", "application/json");  
			        },
				     success: function(resposeJsonObject){
				    	 $('#openModal').hide();
				    	 //window.location.currency;
				    	 window.location.reload();
			     
			    }});
		}
		
	});
	
	  */
	$(document).ready(function(){
		 var id=$('#addprolisttbody').children('tr').length;
		 $('#date').val(id+1);
	        $("#addmorepro12").click(function(){
	        	
	        	$('#hidethisthird1').show();
	        	$('#hidethisthird').hide();
	        	//alert("in add");
	        	var id=$('#addprolisttbody').children('tr').length+1;
	        	var idd=$('#getid1').val();
	        	var address=$('#address').val();
	        	var temp=$("#total").text();
	        	var pname=$('#autocomplete').val();
	            var expdate = $('#exdate').val();
				var  dis	= $('#description').val();
				var  partno	=$('#expenseauto').val();
				var	 tpn	=$('#unittype').val();
				var	 qty	=$('#mul').val();
				var	 totjpy	=$('#total').val();
				var gtotal = $('#gtotal').val();
				//var	 custpo	=$('#customerporefe').val();
				//var poref=$('#porefno').val();
				var date=$('#creationdate').val();
				//var cur=temp.split(' ')[1];
			//	alert("**************111111111111111************");
				 if(address==''||pname==''){
					alert('Please Fill Customer Name!!!')
				}else{  
					
	            var markup = "<tr>"+
	            "<td style='display: none;'><input type='hidden' name='orgname' value='"+pname+"' id='getprinicipalname'"+id+"'></input> </td>"+
		         "<td style='display: none;'><input type='hidden' name='date' value='"+date+"' id='"+date+"'></input> </td>"+
		           
		          /*   "<td style='display: none;'><input type='hidden' name='cname' value='"+poref+"' id='"+id+"'></input> </td>"+ */
		            
		            
		            
		         /*  "<td style='display: none;'><input type='hidden' name='address' value='"+address+"' id='getadress'"+id+"'></input> </td>"+  */
		            
		           /*  "<td style='display: none;'><input type='hidden' name='currency' value='"+cur+"' id='getcurrencylable'"+id+"'></input> </td>"+ */
		           
		            "<td style='right: 5px; position: relative;'>&nbsp;"+ 
					"<input type='text' style='width: 60px' name='' id='date"+id+"' value='"+id+"' class='form-control' readonly/></td>"+
					
					"<td style = 'right: 5px; position: relative;'>&nbsp;"+"<input type='text' style='width: 60px' name='expdate' id='exdate"+id+"' value='"+expdate+"' class='form-control' readonly/></td>"+ 
					
					"<td style='left: 2px; position: relative; width: 150px'>&nbsp;"+
					"<input readonly type='text' value='"+partno+"' name='natureofexpense'style='overflow: auto; border-radius: 3px; width: 223px;'id='expenseauto"+id+"' class='form-control'/></td>"+
					
					"<td style='width: 250px'>&nbsp; <input readonly name='description' id='description"+id+"' class='form-control' style='text-align: center;width: 238px; text-transform: capitalize;' value='"+dis+"' ></input></td>"+
					
					"<td style='right: 7px; position: relative;'>&nbsp; <input readonly type='text' style='text-align: center;' name='rates' id='unittype"+id+"' value='"+tpn+"' class='form-control' /></td>"+
					
					"<td align='center' style='right: 4px; position: relative;'>&nbsp;<input readonly type='text' style='text-align: center;' name='qty' id='mul"+id+"' class='form-control' onkeypress='return event.charCode >= 48 && event.charCode <= 57' value='"+qty+"' /></td>"+
					
					"<td align='center'>&nbsp; <input readonly type='text' style='text-align: center;' name='total' id='total"+id+"' value='"+totjpy+"' class='form-control'  onchange='caltotalagain();  /></td>"+
					
					/* "<td align='center'>&nbsp; <input readonly type='text' style='text-align: center;' name='grandtotal' id='gtotal"+id+"' value='"+totjpy+"' class='form-control'   /></td>"+ */
					
					"<td style='display: none;'><input type='hidden' name='userid' value='<%=iduser %>' id=''></input> </td>"+
					
					
					/* "<td> <input type='button' value='-'  id=''  class='btn btn-info pull-right'  data-toggle='tooltip'title='Delete' onclick = 'deletethisrow(id)' id='+(id)+' /> </td>" */
					"<td style='display: none;'><input type='hidden' name='grandtotal' value='"+gtotal+"' id='grandtotal"+id+"'></input> </td>"+
						"<td><a class='glyphicon glyphicon-pencil' href='#' onclick='editfields("+(id)+")'></a> | <a class='glyphicon glyphicon-remove' href='#' onclick='deletethisrow("+(id)+")' id="+(id)+"></a></td>"+ 	
					 /*  "<td><a class='glyphicon glyphicon-pencil' href='#' onclick='editfields("+(id)+")'></a> | <a class='glyphicon glyphicon-remove' href='#' onclick='deletethisrow("+(id)+")' id="+(id)+"></a></td>"+  */
					/* "<td align='center'>&nbsp;<input readonly type='text' style='text-align: center;width: 132px;' onkeyup='this.value=value.toUpperCase();' name='customerporefe' id='customerporefe"+id+"' value='"+custpo+"' class='form-control'/>"+
					"</td>"+ */
					//alert("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@")
					
					  
					
					"</tr>";
	            $("#addprolisttbody").append(markup);
				//alert(markup)
	            //id++;
	            $('#date').val(id+1);
	            
	            var d;
				var d1;
				var d2=0;
				
				 var id=$('#addprolisttbody').children('tr').length;
				for(var i=1;i<=id;i++){
					var total = $("#total").val();
					if(total == ''){
						d=$('#total'+i).val();
						
						d1=parseInt((d), 10);
						d2=(parseInt((d1), 10)+parseInt((d2), 10));
						var d2 = parseInt($(this).val()) || 0;	
					}
				
					else{
						d=$('#total'+i).val();
						
						d1=parseInt((d), 10);
						d2=(parseInt((d1), 10)+parseInt((d2), 10));
					}
				
				
			
				
				}
				$('#gtotal').val(d2);
				var d=$('#gtotal').val();
				$('#grandtotal1').val(d);
			/* var d=$('#gtotal').val();
			$('#grandtotal1').val(d); */
			
			$('#expenseauto').val('');
			$('#description').val('');
			$('#unittype').val('');
			$('#mul').val('');
			$('#total').val('');
			
			
			
				}
	         }  );
	 });
	
	
	  
		
		
		
		function editfields(id){
			var d=$('#total'+id).val();
			$('#expenseauto'+id).attr("readonly", false);
			$('#mul'+id).attr("readonly", false); 
			//$('#customerporefe'+id).attr("readonly", false); 
			
			
			
			
			$('#mul'+id).keyup(function(){
				
				var d1=$('#gtotal').val();
				$('#gtotal').val(parseInt((d1), 10)-parseInt((d), 10));
				var qty=$('#mul'+id).val();
				//var unit=$('#unitcostx').val();
				var jpy=$('#unittype'+id).val();
				var total=parseInt(qty) * parseInt(jpy);
				$('#total'+id).val(total);
				var d2=$('#total'+id).val();
				var d3=$('#gtotal').val();
				$('#gtotal').val(parseInt((d3), 10)+parseInt((d2), 10));
				calculation();
			var grandtotl=	$('#gtotal').val();
				$('#grandtotal1').val(grandtotl);
				calculation();
			});
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			$('#expenseauto'+id).click(function(){
				var word=$('#expenseauto'+id).val();
				$.ajax({
					url: "getexpenseautolist",
					success: function(result){
						console.log(result);
						searchcopy(result);
						
			    }});
				
			});
		
		
			function searchcopy(result){
				alert(result);
				var expense =jQuery.parseJSON(result);
				alert(expense);
			$('#expenseauto'+id).autocomplete({
			    lookup: expense,
			    onSelect: function (suggestion) {
			    var org= suggestion.value;
			      $.ajax({
						url: "getunitbyexpensehead?expensehead="+org, 
						success: function(result){
							var data=jQuery.parseJSON(result);
							console.log(data);
							// alert(data.unit);
							var rates = data.rates;
							//alert("unit");
							$('#unittype'+id).val(rates);
				    }});
			      
			      
			    }
			  });
			}
			
		}
		
		
		
		
		
		
		
		/* $('#expenseauto'+id).click(function(){
			var word=$('#expenseauto'+id).val();
			alert("######################");
			$.ajax({
				url: "getexpenseautolist?expensehead="+word, 
						
				success: function(result){
					searchexp(result);
					alert("2222222222222");
				}});
			
		});
	 }  */
	 
	function deletethisrow(id){
		 
		alert("delete");
		 $("#"+id).parents("tr").remove();
	id=$('#addprolisttbody').children('tr').length;
	 $('#date').val(id+1);
	 for (i=0;i<id ; i++){
		 
	 }

	 

	 if(id==0){
		 $('#hidethisthird1').hide();
		 $('#hidethisthird').show();
	 }
	 //alert(id);

}
	
	 $('#hidethisthird1').hide();
	 $("#msg1").hide();
	 $("#msg2").hide();
	 $("#msg3").hide();
	 $("#msg4").hide();
	 $("#msg5").hide();
	 
	 $("#save").bind("click", function() {
		 var temp=$("#total").text();
			//alert(temp);
			
			/* var orgname =$('#autocomplete').val(); 
			 var credate =$('#creationdate').val();
			 var expname =$('#expenseauto').val();
			 var unit =$('#unittype').val();
		    var unitexpense =$('#mul').val();
		    if(orgname == ''){ 
		    	$("#msg1").show('fast');
		    }else if(credate == ''){
		    	$("#msg2").show('fast'); */
		    	

		    /* else if(expname == ''){
		    	$("#msg3").show('fast')
		    }else if (unit == ''){
		    	$("#msg4").show('fast')
		    }else if (unitexpense == ''){
		    	$("#msg5").show('fast')
		    } */
		    
		   
		    	
		    	
				  var AddressesDataJSON = $("#quotprodtable").find('input').serializeArray();
			 console.log(AddressesDataJSON);
			 alert(JSON.stringify(AddressesDataJSON));

				   //calculation();
			  $.ajax({
						url: "saveexpenseentry",
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
						    	// window.location.href = "getaddpo";
						    	 window.location.reload();
					    }

					});
		

					}); 

				
	 
	
	 /* $("#autocomplete,#creationdate,#expenseauto,#unittype,#mul").click(function(){
			
		
		 $("#msg1").hide();
		 $("#msg2").hide();
		 $("#msg3").hide();
		 $("#msg4").hide();
		 $("#msg5").hide();
		
		
	}); */
	 
	 
	 function calculation(){
			var id=$('#addprolisttbody').children('tr').length;
			//alert(id)
			var t1=0;
			for(var i=1;i<=id ; i=i+1){
				
				t1+= Number($('#total'+i).val());
				// alert(t1);
			 }
			$('#gtotal').val(t1);
			//alert(nan)
		}
	
	 function caltotalagain(){
			alert("d");
			calculation();
		}
		
</script>























