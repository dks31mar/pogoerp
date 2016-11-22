<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/table.css">
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<div class="row">
	<div class="page-heading col-sm-11"
		style="background-color: #3C8DBD; left: 20px; height: 44px; color: white; " >
		<span class="glyphicon glyphicon-user"></span> Sales Enquiry 
	</div>
	
</div>
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Customer Operation</h4>
        </div>
        <div class="modal-body">
          <div><a href="#"><strong>Edit</strong></a></div>
           <div><a href="#"><strong>Add Diary</strong></a></div>
            <div><a href="#"><strong> Create Quotation</strong></a></div>
             <div><a href="#"><strong> Add Followup</strong></a></div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default"  data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>

<table class="responstable">
       
  
  <tbody align='center'>
 <tr>
    <th>S.N.</th>
     <th>Creation Date</th>
    <th>Customer</th>
    <th>Address</th>
    <th>Contact Person</th>
    <th>Status</th>
    <th>A/c Manager</th>
    <th>Operation</th>
  </tr>
  
  <c:choose>
  <c:when test="${empty salesList}">
  <div style="color: red; text-align: center;">No Sales	Record in the List</div>
  </c:when>
  <c:otherwise>
 <c:if test="${!empty salesList}">
 <c:forEach items="${salesList}" var="salesdetails" varStatus="count">
 <tr>
  <td>${count.count}</td>
  <td>${salesdetails.creationDate}</td>
  <td>${salesdetails.organisation}</td>
  <td>${salesdetails.address}</td>
  <td>${salesdetails.contactPerson}</td>
  <td>${salesdetails.status}</td>
  <td>${salesdetails.acmanager}</td>
  <td><button type="button"  title="More Action" data-toggle="modal" data-target="#myModal"><i class="fa fa-th" aria-hidden="true"></i></button>

</td>
  </tr>
  </c:forEach>
  </c:if>
  </c:otherwise>
   </c:choose>




  </tbody>
  </table>
  