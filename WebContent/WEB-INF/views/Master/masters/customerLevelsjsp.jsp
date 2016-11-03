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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
			 Customer Levels
			 
			
  
 
    
			 
			 
			 
			</div>	
			</div>	
			
			<div class="row" style="margin-top: 15px">
			<br>
			<div align="center">
				<i>
					<h3></h3>
				</i> <input type="hidden" name="profile" value="0" />
			</div>
		</div>
		
		<form:form method="POST" action="savepodetails" commandName="command"> 
					<table style="width: 100%; bottom: 15px; position: relative;" border="0" id="responstable">
					<tr>
					
							<td  style="width: 10px" align="center">&nbsp;<font size="2" >
							<form:label path="">S.No.</form:label></font></td>
							
							<td style="width: 150px" align="center">&nbsp;<font size="2" >
							<form:label path="status">Status</form:label></font></td>	
								
							<td align="center" style="width: 150px">&nbsp;<font size="2" >
							<form:label path="level">Level</form:label></font></td>	
								
							
								
						</tr>	
					
					
				 <c:if test="${!empty customerLevelsList}">
					<c:forEach items="${customerLevelsList}" var="view" varStatus="loop">
					
					<tr>
					
					<td><c:out value="${loop.index+1}"></c:out></td>
					
					<td><c:out value="${view.status}"></c:out></td>
					<td><c:out value="${view.level}"></c:out></td>
					
					</tr>
					
			
					</c:forEach>
					</c:if> 
					</table>
        </form:form> 