<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
    
    <link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />

<link href="resources/css/table.css" rel="stylesheet" type="text/css" />

<link rel="stylesheet" type="text/css"
	href="resources/css/jquery.dialogbox.css" />
	<link rel="stylesheet" type="text/css"
	href="resources/css/tableview.css" />
<script src="resources/plugins/jQuery/jquery-1.9.1.min.js"
	type="text/javascript"></script>
<script src="resources/js/jquery.dialogBox.js" type="text/javascript"></script>
<link href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/themes/blitzer/jquery-ui.css"
    rel="stylesheet" type="text/css" />


<div class="row" style="margin-top: 15px">
	<br>
	<div align="center">
		<i>
			<h3></h3>
		</i> <input type="hidden" name="profile" value="0" />
	</div>
</div>


<div class="row">

	<div class="page-heading col-md-11.5"
		style="background-color: #3C8DBD; left: 20px;  height: 41px;">
		<span class=""></span> Product
		<label
			 style="margin-left: 250px;margin-top: 8px;">
			 <a href="getaddproductpage"
			class="btn btn-primary" style="margin-bottom: -25px;margin-top: -22px;HEIGHT: 28px;margin-left:361px;"> Add New Product </a>
     </label> 
     <!-- <div class="input-group" style="margin-left: 865px; width: 230px; top: -28px;
			 width: 230px;"><input type="text"  
			placeholder="Search by product name or code"  class="form-control" oninput="searchPro(this.value)" id="inputvalueinsearch" style="width: 245px"><span class="input-group-addon">
        <i class="fa fa-search"></i>
    </span></div> -->
      
			
</div>

</div>

<br>
<div id="pop" style="display: none;"></div>
<div id="searchedRecord"></div>
<div id="body">
	<table class="responstable" id="producttableid">

		<thead>
			<tr>
				<th>S.No.</th>
				<th data-th="Driver details"><span>Product Code</span></th>
				<th>Product Name</th>
				<th>Input Cost</th>
				<th>Price To Sale</th>
				<th style="width: 60px;">Edit</th>
				<th style="width: 60px;"> Delete</th>
			</tr>
			</thead>
			<tbody>
			<c:if test="${!empty prodetail}">
				<c:forEach items="${prodetail}" var="cur" varStatus="loop">
			
			<tr>
						
								<td>${loop.index+1}</td>
								<td>${cur.productcode}</td>
								<td>${cur.productname}</td>
								<td>${cur.costprice}</td>
								<td>${cur.sellingprice}</td>
							
						
								<td><a href="editproductdata?id=${cur.productid}" title="Edit" align="center" >
								<span class="glyphicon glyphicon-pencil"></span></a></td>
								
						<td style="margin"><a href="deleteprodet?id=${cur.productid}"><span
								class="glyphicon glyphicon-trash" style="margin-left: 19px;"></span></a></td>
					</tr>
</c:forEach>
</c:if>
				


		</tbody>
	</table>
</div>
<div class="row form-group">
	<div class="col-sm-7"></div>
</div>



<!-- <script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script> -->
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.9/jquery-ui.js" type="text/javascript"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" />
<script>

function searchPro(wordinsrch) {
	//alert("hi");
	//alert(loginname);
	$("#searchedRecord").empty();
	$("#body").show();
	$
			.ajax({

				type : "POST",
				url : 'searchproduct',
				data : {
					'proname' : wordinsrch,
				},
				success : function(data) {
					
					var obj = JSON.parse(data);
				
					var ind=0;
					var content = '<table class="responstable" style="margin-top: 5px;margin-left: 22px; border-radius: 5px;"><thead><tr>'
						+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">S.No.</label></th>'
						+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">Product Code</label></th>'
						+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">Product Name</label></th>'
						+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">Cost price</label></th>'
						+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">Selling price</label></th>'
						+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">Edit</label></th>'
						+ '<th class="corg_th" style="font-size: 13px;"><label for="laborg">Delete</label></th>'
						
					if (obj.length == 0) 
					{
						content += '<tr><td colspan="8"><font color="red" size="3">No record found.</font></td></tr>';
					} 
					else
					{
						$
						.each(
								obj,
								function(key, value) {
									content += '<tr height="30">';
									content += '<td style="font-size: 13px; color:black;" class="corg_th">'
											+ ++ind
											+ '</td>';
									content += '<td style="font-size: 13px; color:black;" class="corg_th">'
											+ value.productcode + '</td>';
									content += '<td style="font-size: 13px; color:black;" class="corg_th">'
											+ value.productname
											+ '</td>';
									content += '<td style="font-size: 13px; color:black;" class="corg_th">'
											+ value.costprice
											+ '</td>';
									content += '<td style="font-size: 13px; color:black;" class="corg_th">'
											+ value.sellingprice
											+ '</td>';
									content += '<td style="font-size: 13px; color:black;width: 60px;" class="corg_th"><a href="editproductdata?id='+value.productid+'" title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>'
											+ '</td>';		
									content += '<td style="font-size: 13px; color:black;width: 60px;"" class="corg_th"><a title="Delete" href="#" onclick="deletSearchPro('+value.productid+')"><span class="glyphicon glyphicon-trash"></span></a>'
										+ '</td></tr>';		

											
								});
				content += '</tbody></table>';
						}
					$("#body").hide();
				$("#searchedRecord").append(content);
				
			},
			error : function(e) {
				
			}
		});

}	  
    
    function deletSearchPro(searchid){
    	alert("ddd");
    var wordinsearch=	$('#inputvalueinsearch').val();
    	$.ajax({
    		url: "deletesearchprodet?id="+searchid,
    		type: "GET",
    		     success: function(resposeJsonObject){
    		    	 searchPro(wordinsearch);
    		    	 // $('#openModal').hide();
    		    	 //window.location.currency;
    		    	// window.location.reload();
    	     
    	    }});
    }

    $(document).ready(function() {
        $('#producttableid').DataTable( {
            "order": [[0, "desc" ]]
        } );
    } ); 
</script>