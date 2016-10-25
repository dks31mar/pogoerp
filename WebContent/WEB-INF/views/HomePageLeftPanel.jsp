<%@page import="com.pogo.model.User"%>
<%@page import="com.pogo.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "com.pogo.bean.UserBean"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
    a, a:visited, a:focus, a:active, :visited, :focus, :active, .btn:focus, .btn:active:focus, .btn.active:focus, .btn.focus, .btn:active.focus, .btn.active.focus {
        outline: 0;
        text-decoration: none;
    }
    .left-panel{
            width: 100%;
            padding: 0;
            min-height:1050px;
            background-color: #016E3B !important;
        }  
        .profile_pic {
        width: 30%;
        float: left;
    }
    .img-circle.profile_img {
        width: 50%;
        background: #fff;
        margin-left: 10%;
        z-index: 1000;
        position: inherit;
        margin-top: 20px;
        border: 1px solid rgba(52, 73, 94, 0.44);
        padding: 4px;
    }
    .img-circle {
        border-radius: 50%;
    }
    img {
        vertical-align: middle;
    }
    .profile_info {
        padding: 10px 10px 10px;
        width: 60%;
        float: left;
    }
    .profile_info span {
        font-size: 10px;
        line-height: 20px;
        color: #BAB8B8;
    }
    .profile_info h2 {
        font-size: 14px;
        color: #ECF0F1;
        margin: 0;
        font-weight: 300;
    }
    .menu-items{
        width:230px;
        color:#FFFFFF;
        padding-left: 0;
        margin-bottom: 0;
        list-style: none;
        margin-top:10px;
        margin-left:10px;
    }
    .menuTD{
        width:100%;
        background:#94ce95;
    }
    .menuTD:hover{
        width:100%;
        background:#FFFFFF;
        color:#454545;
    }
    .menu-link{
        text-decoration: none;
        color:#000000 !important;
        cursor:pointer;
        font-weight: 100;
        font-size:14px;
        padding:10px 0px 10px 5px;
        border-bottom:1px solid #F7F7F7;
        display:block;
        width:100%;
    }
    .menu-link:hover{color:#454545;text-decoration: none;}
    .menu-item{
        padding:8px 0 8px 0;
    }
    .left-fix{
        width:300px;
        height:30px;
        position:fixed;
        bottom:0;
        left:0;
        background-color: #3A584A ;
        opacity:.7;
    }
    .left-fix a{float:right;padding:8px;cursor:pointer;color:#FFFFFF;}
    #CalendarPickerControl tab
    le.calframe {margin-left: 25%;margin-top:100px;}

.dropbtn {
    background-color: #4CAF50;
    color: white;
    padding: 10px;
    font-size: 16px;
    width:200px;
    border: none;
    cursor: pointer;
}

.dropbtn:hover, .dropbtn:focus {
    background-color: #3e8e41;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    overflow: auto;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown a:hover {background-color: #f1f1f1}

.show {display:block;}
</style>
<script>
/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
	  $.ajax({
	        url:'getleftmenu',
	      	type: 'get',
	        contentType: 'application/x-www-form-urlencoded',
	        
	        success: function(){
	        	var dropdowns = document.getElementsByClassName("dropdown-content");
	            var i;
	            for (i = 0; i < dropdowns.length; i++) {
	              var openDropdown = dropdowns[i];
	              if (openDropdown.classList.contains('show')) {
	                openDropdown.classList.remove('show');
	              }
	            }
	        },
	        error: function(data){
	            console.log("error" );
	        }
	    }); 
    
  }
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name=(String)session.getAttribute("username");
if(name==null){
	response.sendRedirect("LoginPage.jsp");
}
%>
<div class="left-panel">
    <div class="userprofile">
        <div class="profile_pic">
          <img src="resources/image/profile-image.jpg" alt="..." class="img-circle profile_img">
          
        </div>
         
        <div class="profile_info">
          <span>Welcome,</span>
          <h2><%=name %></h2>
          <h2><label title="dks31mar"></label></h2>
          <h2><span class="glyphicon glyphicon-earphone"></span> :87463874</h2>
           <h2>Designation : DEV</h2>
           
          
           
          <!--<input type="text" id="DPC_calendar1b_DD-MM-YYYY" name="calendar1b" size="1" style="visibility: hidden; width:12px;height:12;vertical-align:top;margin:0;float:top;margin-left:100px;"/>-->
        </div>
           <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" style="border-top:1px solid #F7F7F7;"  >
 
    

                                                 <tr>
						    
    <td class="menuTD">
	<%-- <a class="menu-link" onclick ="javascript:refreshSubMenu();></a> --%>
       <!--  <form action="getleftmenu" method="get"> -->
         
    <c:if test="${not empty lists}">

		<ul>
			<c:forEach var="listValue" items="${lists}">
				<a class="menu-link" href="#">
				<li>${listValue}</li>
				</a>
			</c:forEach>
		</ul>

	</c:if>
<!-- <button class="dropbtn" type="submit">Menu</button> -->
 
</div>
	<!-- </form>         -->                                                                                                                                                                <!--   Vineet 10 October 2008 purpose to match condition for highlighting selected menu     -->
    </td>
    </tr>

  
								
				

  
</table>
    </div>
    <div style="clear:both"></div>
    <label style="padding-top: 200px;"></label>
    
    
    

    
</div>
</body>
</html>