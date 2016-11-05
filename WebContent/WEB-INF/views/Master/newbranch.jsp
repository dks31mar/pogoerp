<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


 
 <script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<!-- call region -->
<link rel="stylesheet" type="text/css"
	href="resources/css/table.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/branch.css">
<script src="resources/js/branch.js" type="text/javascript"></script>
<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
<title>Branches details</title>

</head>


<div class="container">
  <h2></h2>
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>

  <!-- Modal -->

  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Add Employee</h4>
        </div>
        <div class="modal-body">
		<form>
    
<table>
     <tr>  <td> Region Name:</td>  <td><input type="text" name="first"></td></tr>
    
     <tr><td> Phone No: </td><td><input type="text" name="last"> </td></tr>
           <tr><td>Fax No: </td>
       
        <td><input type="text" name="first"> </td></tr>
		<tr><td>EmailId: </td><td><input type="text" name="first"> </td>     </tr>
        
           
       
        
        <tr>
		<td>Region Head Name</td>
		<td>
            <select>
               <option value="affiliate">Select Affiliate</option>
               <option value="x">x</option>
               <option value="y">y</option>
            </select>
         </td></tr>
         <tr>
         		<td>Region Address</td>
		<td><input type="text"></td>
		</tr>
		
</table>
		</form>
         
        </div>
        <div class="modal-footer">
		 <button type="button" class="btn btn-default" data-dismiss="modal">Save</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>


<tbody>
<body>
<TABLE WIDTH="375" BORDER="0" CELLSPACING="1" CELLPADDING="0" ALIGN="center">
    <FORM NAME="RegionList" METHOD="post" ACTION="RegionMain.jsp?operation=ADDNEW">
         	</tbale>
         	<center>
 </CENTER>
        
        
       <table class="responstable">
  
  <tbody align='center'>
 <div="wrapper">

  <tr id="ftr">
    <th>S.N.</th>
    <th data-th="Driver details"><span>Branch</span></th>
    <th>Phone No</th>
    <th>Fax No</th>
    <th>Head Name</th>
    <th>Edit</th>
    <th>Delete</th>
  </tr>
  
  <tr id="str">
    <td>1</td>
   <td id="branch_name1"><a href="#">Bhopal</a></td>
   <td id="phone_no1" ></td>
   <td id="fax_no1" ></td>
    <td id="product_no1" '></td>
   <td><input type="button" id="edit_button1" value="Edit" class="edit" onclick="edit_row('1')">
   <input type="button" id="save_button1" value="Save" class="save" onclick="save_row('1')"></td>
    <td><a href="#" title="Delete"><span class="glyphicon glyphicon-trash"></span></a></td>
  </tr>
  
  <tr id="3tr">
    <td>2</td>
    
    <td id="branch_name"><a href="#">Gwalear</a></td>
    <td id="phone_no"></td>
    <td id="fax_no"></td>
    <td id="product_no"></td>
    <td><a href="#" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a></td>
    <td><a href="#" title="Delete"><span class="glyphicon glyphicon-trash"></span></a></td>
  </tr>
  </tr id="ftr">
  
  <tr>
    <td>3</td>
    <td id="branch_name"><a href="#">Delhi</a></td>
    <td  id="phone_no"></td>
    <td id="fax_no"></td>
    <td id="product_no"></td>
  <td><a href="#" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a></td>
    <td><a href="#" title="Delete"><span class="glyphicon glyphicon-trash"></span></a></td>
  </tr>
  </tr id="5tr">
  
    <td>4</td>
    <td id="branch_name"><a href="#">gurgaon</a></td>
    <td id="phone_no"></td>
    <td id="fax_no"></td>
    <td id="product_no"></td>
  <td><a href="#" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a></td>
    <td><a href="#" title="Delete"><span class="glyphicon glyphicon-trash"></span></a></td>
  </tr>

  <tr id="str">
    <td>5</td>
    <td id="branch_name"><a href="#">Branches</a></td>
    <td id="phone_no"></td>
     <td id="fax_no"></td>
    <td id="product_no"></td>
   <td><a href="#" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a></td>
    <td><a href="#" title="Delete"><span class="glyphicon glyphicon-trash"></span></a></td>
  </tr>

  
</tbody></table>      
</FORM>
 <script>
 function edit_row(no)
 {
  document.getElementById("edit_button"+no).style.display="none";
  document.getElementById("save_button"+no).style.display="block";
 	
  //var branch=document.getElementById("branch_name"+no);
  var phoneno=document.getElementById("phone_no"+no);
  var faxno=document.getElementById("fax_no"+no);
  var product=document.getElementById("product_no"+no);
 	
 // var branch_data=branch.innerHTML;
  var phone_data=phoneno.innerHTML;
  var fax_data=faxno.innerHTML;
  var product_data=product.innerHTML;
  
  //branch.innerHTML="<input type='text' id='branch_text"+no+"' value='"+branch_data+"'>";
  phoneno.innerHTML="<input type='text' id='phone_text"+no+"' value='"+phone_data+"'>";
  faxno.innerHTML="<input type='text' id='fax_text"+no+"' value='"+fax_data+"'>";
  product.innerHTML="<input type='text' id='product_text"+no+"' value='"+product_data+"'>";
 }

 function save_row(no)
 {
	 //var branch_val=document.getElementById("branch_text"+no).value;
	  var phoneno_val=document.getElementById("phone_text"+no).value;
	  var faxno_val=document.getElementById("fax_text"+no).value;
	  var product_val=document.getElementById("product_text"+no).value;

  //document.getElementById("branch_name"+no).innerHTML=branch_val;
  document.getElementById("phone_no"+no).innerHTML=phoneno_val;
  document.getElementById("fax_no"+no).innerHTML=faxno_val;
  document.getElementById("product_no"+no).innerHTML=product_val;
  
  document.getElementById("edit_button"+no).style.display="block";
  document.getElementById("save_button"+no).style.display="none";
 }
/*
 function delete_row(no)
 {
  document.getElementById("row"+no+"").outerHTML="";
 }

 function add_row()
 {
  var new_name=document.getElementById("new_name").value;
  var new_country=document.getElementById("new_country").value;
  var new_age=document.getElementById("new_age").value;
 	
  var table=document.getElementById("data_table");
  var table_len=(table.rows.length)-1;
  var row = table.insertRow(table_len).outerHTML="<tr id='row"+table_len+"'><td id='name_row"+table_len+"'>"+new_name+"</td><td id='country_row"+table_len+"'>"+new_country+"</td><td id='age_row"+table_len+"'>"+new_age+"</td><td><input type='button' id='edit_button"+table_len+"' value='Edit' class='edit' onclick='edit_row("+table_len+")'> <input type='button' id='save_button"+table_len+"' value='Save' class='save' onclick='save_row("+table_len+")'> <input type='button' value='Delete' class='delete' onclick='delete_row("+table_len+")'></td></tr>";

  document.getElementById("new_name").value="";
  document.getElementById("new_country").value="";
  document.getElementById("new_age").value="";
 }
 */
 /*
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}*/

</script>
  
</body>
</html>
