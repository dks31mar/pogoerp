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



<tbody>
<body>

    <div id="pop" style="display: none;"></div>

<div id="body">
<div>
<div>
<div class="row" style="margin-top: 15px">
	<br>
	<div align="center">
		<i>
			<h3></h3>
		</i> <input type="hidden" name="profile" value="0" />
	</div>
</div>
<div class="row">

	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; color:white; left: 20px;  height: 64px;">
		<span class="glyphicon glyphicon-user"></span> States Details</b>
		 <label
			 style="margin-left: 250px;margin-top: 8px;"><a href="addstates"
			class="btn btn-primary">Add States</a>
			<button type="button" class="btn btn-warning" onclick="history.back();">Back <span class="glyphicon glyphicon-send"></span></button>
     </label>
  		
</div>

</div>
</div>      
       <table class="responstable">
  
  <tbody align='center'>
 <div="wrapper">

  <tr id="ftr">
    <th>S.N.</th>
    <th data-th="Driver details"><span>States</span></th>
     <th>Branches</th>
   <!--   <th>Phone No</th>
    <th>Fax No</th>
    <th>Head Name</th>*/
    -->
    <th>Edit</th>
    <th>Delete</th>
  </tr>
  
  <tr id="str">
    <td>1</td>
   <td id="branch_name1"><a href="#">Bhopal</a></td>
   <td><a href="NewBranch" target="_blank">Branches</a></td>
  <!--   <td id="phone_no1" ></td>
   <td id="fax_no1" ></td>
    <td id="product_no1" '></td>
  
   <td><input type="button" id="edit_button1" value="Edit" class="edit" onclick="edit_row('1')">
   <input type="button" id="save_button1" value="Save" class="save" onclick="save_row('1')"></td>
     -->
    <td><a href="#" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a></td>
    <td><a href="#" title="Delete"><span class="glyphicon glyphicon-trash"></span></a></td>
  </tr>
  
  <tr id="3tr">
    <td>2</td>
    
    <td id="branch_name"><a href="#">Gwalear</a></td>
     <td>Branches</td>
    <!--   <td id="phone_no1" ></td>
   <td id="fax_no1" ></td>
    <td id="product_no1" '></td>
    -->
    <td><a href="#" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a></td>
    <td><a href="#" title="Delete"><span class="glyphicon glyphicon-trash"></span></a></td>
  </tr>
  </tr id="ftr">
  
  <tr>
    <td>3</td>
    <td id="branch_name"><a href="#">Delhi</a></td>
    <td>Branches</td>
    <!--   <td id="phone_no1" ></td>
   <td id="fax_no1" ></td>
    <td id="product_no1" '></td>
    -->
  <td><a href="#" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a></td>
    <td><a href="#" title="Delete"><span class="glyphicon glyphicon-trash"></span></a></td>
  </tr>

</tbody>

</table>      
</FORM>


 <script>
 /*
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

 function delete_row(no)
 {
  document.getElementById("row"+no+"").outerHTML="";
 }
 */
/*
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
