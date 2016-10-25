<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <script src="resources/bootstrap-3.3.6/js/jquery.min.js"></script>
    <script src="resources/bootstrap-3.3.6/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="resources/font-awesome-4.6.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/amcharts/style.css" type="text/css">
    <script src="resources/amcharts/amcharts.js" type="text/javascript"></script>
    <script src="resources/amcharts/serial.js" type="text/javascript"></script>
    <script src="resources/amcharts/pie.js" type="text/javascript"></script>
    <script src="resources/amcharts/funnel.js" type="text/javascript"></script>
    <script src="resources/amcharts/dashboard_charts.js" type="text/javascript"></script>
<style media="print">
					#test1div, #test2div{
						display: none;
					}
					#framediv2222{
						display: display;
						width:80% !important;
					}
				</style>
				<script>
					getObj("test2div").style.height = screen.availHeight -260;
				</script>
				
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<BODY LEFTMARGIN="0" TOPMARGIN="0" MARGINWIDTH="0" MARGINHEIGHT="0" BGCOLOR="#FFFFFF">

<%
String name1=(String)session.getAttribute("username");
if(name1==null){
	response.sendRedirect("LoginPage.jsp");
}

%>
                            <div class="row" style="margin-right:0px;">
				<div id="test1div" class="col-sm-12"><%@include file ="top.jsp"%></div>
				<div class="row" style="margin-right:0px;">
				
				<div align="left" id="test2div" class="col-sm-2" style="height:400px;display:inline;border-right: 1px solid #CCC;z-index=2;"><%@include file ="HomePageLeftPanel.jsp"%></div>
			
		
</body>
</html> --%>