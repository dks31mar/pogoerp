<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<!-- <script src="resources/bootstrap-3.3.6/js/jquery.min.js"></script> -->
<link rel="stylesheet" type="text/css" href="resources/css/displaytag.css" />
<link rel="stylesheet" type="text/css" href="resources/css/messagebox.css" />
	
<link rel="stylesheet" type="text/css" href="resources/css/autocom.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<% 
java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
java.util.Date date = new java.util.Date();
System.out.println();
%>
<div class="row" style="margin-top: 15px">
<br><div align="center"><input type="hidden" name="profile" value="0" /></div>
</div>
<div class="row">
<div class="page-heading col-sm-11" id="" style="background-color: #3C8DBC; left: 10px"><span class="fa fa-money"></span> Expense Entry 	
</div>
</div>				
<div style="border: 1px solid #CCCCCC; padding: 7px; width: 93%">
<div class="row form-group">
<div class="col-sm-3 form-level">Customer name :<font color="#FF0000">*</font></div>
<div class="col-sm-3"><input type='text' value="" name='particulee1' id = "autocomplete" class='form-control'/>  </div>	
<div class="col-sm-2 form-level"> Creation Date:<font color="#FF0000">*</font></div>				
<div class="col-sm-2"><span> <input type="text" class="form-control" name="dateTodate" id="creationdate" value="<%=dateFormat.format(date) %>" ReadOnly></input></span></div>			
</div>	
<div class="row form-group">
<div class="col-sm-3 form-level">Address:<font color="#FF0000">*</font></div>			
<div class="col-sm-9"><textarea rows="4" cols="77" name="address" style="border-radius: 5px; background-color: #f2f2f2;"  id="addresstextarea"> </textarea>	</div>			
</div>					
</div>					
<hr style="color: black"><div class="row form-group"><div class="col-sm-7"></div></div>		
<table style="width: 100%; bottom: 15px; position: relative;" border="0" id="quotprodtable">
 <thead>
	<tr bgcolor="#3C8DBC">
	  <td align="center">&nbsp;<font size="2" style="width: 65px"color="white"><label >Date</label></font></td>
	  <td align="center">&nbsp;<font size="2" style="width: 65px"color="white"><label >Nature of Expense</label><font color="#FF0000">*</font></font></td>
	  <td align="center">&nbsp;<font size="2" style="width: 65px"color="white"><label >Description</label></font></td>
								
	  <td align="center">&nbsp;<font size="2" style="width: 80px"color="white"><label id="tpinchangelable">Unit Type</label><font color="#FF0000">*</font></font></td>						
	  <td align="center">&nbsp;<font size="2" style="width: 80px"color="white"><label >Units/Expenses</label><font color="#FF0000">*</font></font></td>								
	  <td align="center">&nbsp;<font size="2" style="width: 80px"color="white"><label id="total"> Total </label></font></td>							
	  
    </tr>
  </thead>																
</tbody>
</table>								
               
               
       <table>
		<tr>
		<div id = addrow>
		<td><input type="" class="form-control" name="dateTodate" id="date" value="<%=dateFormat.format(date) %>" ReadOnly></input></td></div>
		<!-- <td style="left: 2px; position: relative; width: 150px">&nbsp;<input type='text' value="" name='' style='overflow: auto; border-radius: 3px; width: 223px;' id='' class='form-control'/></td>	
		<td style="width: 250px">&nbsp; <input name='description'id='description' class='form-control'style="text-align: center;width: 238px;" value="" ></input></td>			 -->			
	 <%-- <td style="right: 7px; position: relative;">&nbsp;<input type='text' style='text-align: center;' name='tpinjpy' id='tpinjpy' value="" class='form-control' /></td> 					
		<td align="center" style="right: 4px; position: relative;">&nbsp; <input  type='text' style='text-align: center;' name='qty' onkeypress='return event.charCode >= 48 && event.charCode <= 57' id='qty' class='form-control' value=""/></td>		 --%>			
		<td align="center">&nbsp; <input  type='button' style='text-align: center;' name='totaljpy' id='add' value="+" class='form-control'  /></td>					 
		
								
		</tr>					
	</table>								
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/messagebox.js"></script>
<script type="text/javascript" src="resources/js/messagebox.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript"src="resources/js/jquery.autocomplete.min.js"></script>

<script>
$( function() {
    $( "#date" ).datepicker({dateFormat: 'dd/mm/yy'});
  } );	
  


$( function() {
    $( "#creationdate" ).datepicker({dateFormat: 'dd/mm/yy'});
  } );	
  
  
  var count = 1;
  $("#add").click (function(){
	  alert("hello");
	  var html="<div id='div"+count+"'><input type='text'></input><button onclick=foo('"+count+"')>Remove</button></div>";
	    
	  $("#addrow").append();
	  count++;
	  
  });
  
  $('#autocomplete').on("click",function(){
		var word=$('#autocomplete').val();

//alert($(e.target).val() );	
	$.ajax({
		url: "getorganisation?word="+word, 
		success: function(result){
			console.log(result);
			search(result);
			
  }});
	
});
  
  function search(result){
		var organisation =jQuery.parseJSON(result);
		/* alert(currencies); */
		$('#autocomplete').autocomplete({
		    lookup: organisation,
		    onSelect: function (suggestion) {
		    var pro= suggestion.value;
		      $.ajax({
					url: "getorganisation?pro="+pro, 
					success: function(result){
						for(i=0;i<result.length;i++){
							var data=result.replace('"','');
							data=data.replace('"','');
						}
					
			    }});
		      
		      
		    }
		  });
		}
</script>				
					
						
				

				
					
				
				
					
						
						
					

				
			




			
				 
			
		
	