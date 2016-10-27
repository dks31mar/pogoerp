<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="resources/css/displaytag.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="resources/css/messagebox.css" />
<link rel="stylesheet" type="text/css" href="resources/css/autocom.css" />
<link rel="stylesheet" type="text/css" href="resources/css/view.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">



<%
java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("MM/dd/yyyy");
java.util.Date date = new java.util.Date();
System.out.println();
%>

<div class="row" style="margin-top: 15px">
			<br>
			<div align="center">
				<i>
					<h3></h3>
				</i> <input type="hidden" name="profile" value="0" />
			</div>
		</div>
		
		<div class="row">
		<div class="page-heading col-sm-11" style="background-color: #3C8DBC; left: 10px">
			<span class="glyphicon glyphicon-user"></span> Acknowledge Supplier Po 	
			</div>	
			</div>

<div style="border: 1px solid #CCCCCC; padding: 7px; width: 93%">

            <div class="row form-group">

				<div class="col-sm-3 form-level">PO Reference No:<font color="#FF0000">*</font></div>
				
				<div class="col-sm-4"><input type="text" name="porefno" placeholder="PO Reference No." value="" id = "porefno"/></div>
				
				<div class="col-sm-1 form-level">Date:<font color="#FF0000">*</font></div>	
			    <div class="col-sm-2"><span> <input type="text" class="form-control" name="date"id="datepicker" value="<%=dateFormat.format(date) %>" ReadOnly></span></div>
                <div class="row form-group">
				<div class="col-sm-3 form-level">Principal Name:<font color="#FF0000">*</font></div>
				<div class="col-sm-9">
					<input type="text" name="principalname"
						placeholder="Principal Name" value=""
						class="form-control" style="display: inline-block;" ReadOnly>
				</div>
			</div>
			</div>
	
     </div>
					

<script>
$( function() {
    $( "#datepicker" ).datepicker();
  } );

</script>








   <script src="resources/bootstrap-3.3.6/js/jquery.min.js"></script>
   <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>	