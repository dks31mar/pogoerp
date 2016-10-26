<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/pogoerpdemo/Resources/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="/pogoerpdemo/Resources/bootstrap-3.3.6/js/jquery.min.js"></script>
<script src="/pogoerpdemo/Resources/bootstrap-3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/pogoerpdemo/Resources/font-awesome-4.6.3/css/font-awesome.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="${js_url}/css/jquery.dialogbox.css">
<script src="${js_url}/plugins/jQuery/jquery-1.9.1.min.js"
	type="text/javascript" charset="utf-8"></script>
<script src="${js_url}/js/jquery.dialogBox.js" type="text/javascript"
	charset="utf-8"></script>
<title>Insert title here</title>
<style>
      /*

RESPONSTABLE 2.0 by jordyvanraaij
  Designed mobile first!

If you like this solution, you might also want to check out the 1.0 version:
  https://gist.github.com/jordyvanraaij/9069194

*/
.responstable {
  margin: 1em 0;
  width: 100%;
  overflow: hidden;
  background: #FFF;
  color: #024457;
  border-radius: 10px;
  border: 1px solid #167F92;
}
.responstable tr {
  border: 1px solid #D9E4E6;
}
.responstable tr:nth-child(odd) {
  background-color: #EAF3F3;
}
.responstable th {
  display: none;
  border: 1px solid #FFF;
  background-color: #167F92;
  color: #FFF;
  padding: 1em;
}
.responstable th:first-child {
  display: table-cell;
  text-align: center;
}
.responstable th:nth-child(2) {
  display: table-cell;
}
.responstable th:nth-child(2) span {
  display: none;
}
.responstable th:nth-child(2):after {
  content: attr(data-th);
}
@media (min-width: 480px) {
  .responstable th:nth-child(2) span {
    display: block;
  }
  .responstable th:nth-child(2):after {
    display: none;
  }
}
.responstable td {
  display: block;
  word-wrap: break-word;
  max-width: 7em;
}
.responstable td:first-child {
  display: table-cell;
  text-align: center;
  border-right: 1px solid #D9E4E6;
}
@media (min-width: 480px) {
  .responstable td {
    border: 1px solid #D9E4E6;
  }
}
.responstable th, .responstable td {
  text-align: left;
  margin: .5em 1em;
}
@media (min-width: 480px) {
  .responstable th, .responstable td {
    display: table-cell;
    padding: 1em;
  }
}

body {
  padding: 0 2em;
  font-family: Arial, sans-serif;
  color: #024457;
  background: #f2f2f2;
}

h1 {
  font-family: Verdana;
  font-weight: normal;
  color: #024457;
}
h1 span {
  color: #167F92;
}
/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 60%;
}

/* The Close Button */
.close {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}

    </style>
    
   

</head>
<tbody>

<h2>Modal Example</h2>

<!-- Trigger/Open The Modal -->
<button id="myBtn">Open Modal</button>

<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">×</span>
   <form>
  Region Name:<input type="text" name="firstname"><br>
  
  Phone No:<input type="text" name="phone"><br>
   
  Fax No:<input type="text" name="fax"><br>

  EmailId:<input type="text" name="fax"><br>

  
  Region Head Name:<input type="text" name="headname"><br>

  Region Address:<input type="text" name="headname"><br>
</form>
  </div>

</div>
</tbody>

<TABLE WIDTH="375" BORDER="0" CELLSPACING="1" CELLPADDING="0" ALIGN="center">
    <FORM NAME="RegionList" METHOD="post" ACTION="RegionMain.jsp?operation=ADDNEW">
         
        
        
	
 </CENTER>
        
        
       <table class="responstable">
  
  <tbody align='center'>
 <div="wrapper">

  <tr id="ftr">
    <th>S.N.</th>
    <th data-th="Driver details"><span>Branch</span></th>
    <th>Phone No</th>
    <th>Fax No</th>
    <th>Product Detail</th>
    <th>Edit</th>
    <th>Delete</th>
  </tr>
  
  <tr id="str">
    <td>1</td>
   <td id="branch_name"><a href="#">Bhopal</a></td>
   <td id="phone_no"></td>
   <td id="fax_no"></td>
    <td id="product_no"></td>
   <td><a href="#" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a></td>
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
 	
  var name=document.getElementById("name_row"+no);
  var country=document.getElementById("country_row"+no);
  var age=document.getElementById("age_row"+no);
 	
  var name_data=name.innerHTML;
  var country_data=country.innerHTML;
  var age_data=age.innerHTML;
 	
  name.innerHTML="<input type='text' id='name_text"+no+"' value='"+name_data+"'>";
  country.innerHTML="<input type='text' id='country_text"+no+"' value='"+country_data+"'>";
  age.innerHTML="<input type='text' id='age_text"+no+"' value='"+age_data+"'>";
 }

 function save_row(no)
 {
  var name_val=document.getElementById("name_text"+no).value;
  var country_val=document.getElementById("country_text"+no).value;
  var age_val=document.getElementById("age_text"+no).value;

  document.getElementById("name_row"+no).innerHTML=name_val;
  document.getElementById("country_row"+no).innerHTML=country_val;
  document.getElementById("age_row"+no).innerHTML=age_val;

  document.getElementById("edit_button"+no).style.display="block";
  document.getElementById("save_button"+no).style.display="none";
 }

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
 <!--
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
}
//-->
</script>
  
</body>
</html>
