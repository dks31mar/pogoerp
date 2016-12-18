<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- jvectormap -->
<link rel="stylesheet"
	href="resources/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<!-- Theme style -->
<link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
<!-- pupup window style sheet= -->

<link rel="stylesheet" href="resources/css/popupwindow.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="resources/dist/css/skins/_all-skins.min.css">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>

<script
	src="http://maps.googleapis.com/maps/api/js?key=YOUR_APIKEY&sensor=false">
</script>
<link href="resources/bootstrap-3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/main.css" rel="stylesheet" type="text/css" />
<script src="resources/bootstrap-3.3.6/js/jquery.min.js"></script>
<script language="JavaScript"
	src="resources/script/dhtmlgoodies_calendar.js?random=20060118"></script>
<link type="text/css" rel="stylesheet"
	href="resources/script/dhtmlgoodies_calendar.css?random=20051112"
	media="screen"></LINK>

<script type="text/javascript"
	src="resources/js/ajaxtags-1.2-beta2_easytool.js"></script>


<link rel="stylesheet" type="text/css"
	href="resources/css/ajaxtags_easytool.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/displaytag.css" />
<title>Insert title here</title>
<style>
hr {
	display: block;
	margin-top: 0.5em;
	margin-bottom: 0.5em;
	margin-left: auto;
	margin-right: auto;
	border-style: inset;
	border-width: 1px;
}
</style>
</head>
<body>
	<div class="container">
		<header class="main-header"> <!-- Logo --> <a href="homepage"
			class="logo"> <!-- mini logo for sidebar mini 50x50 pixels --> <span
			class="logo-mini"><b>E</b>RP</span> <!-- logo for regular state and mobile devices -->
			<span class="logo-lg"><b>POGO</b>ERP</span>
		</a> <!-- Header Navbar: style can be found in header.less --> <nav
			class="navbar navbar-static-top"> <!-- Sidebar toggle button-->
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
			role="button"> <span class="sr-only">Toggle navigation</span>
		</a> <!-- Navbar Right Menu -->
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<!-- Messages: style can be found in dropdown.less-->
				<li class="dropdown messages-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="fa fa-envelope-o"></i> <span class="label label-success">4</span>
				</a>
					<ul class="dropdown-menu">
						<li class="header">You have 4 messages</li>
						<li>
							<!-- inner menu: contains the actual data -->
							<ul class="menu">
								<li>
									<!-- start message --> <a href="#">
										<div class="pull-left">
											<img src="resources/dist/img/user2-160x160.jpg"
												class="img-circle" alt="User Image">
										</div>
										<h4>
											Support Team <small><i class="fa fa-clock-o"></i> 5
												mins</small>
										</h4>
										<p>Why not buy a new awesome theme?</p>
								</a>
								</li>
								<!-- end message -->
								<li><a href="#">
										<div class="pull-left">
											<img src="resources/dist/img/user3-128x128.jpg"
												class="img-circle" alt="User Image">
										</div>
										<h4>
											AdminLTE Design Team <small><i class="fa fa-clock-o"></i>
												2 hours</small>
										</h4>
										<p>Why not buy a new awesome theme?</p>
								</a></li>
								<li><a href="#">
										<div class="pull-left">
											<img src="resources/dist/img/user4-128x128.jpg"
												class="img-circle" alt="User Image">
										</div>
										<h4>
											Developers <small><i class="fa fa-clock-o"></i> Today</small>
										</h4>
										<p>Why not buy a new awesome theme?</p>
								</a></li>
								<li><a href="#">
										<div class="pull-left">
											<img src="resources/dist/img/user3-128x128.jpg"
												class="img-circle" alt="User Image">
										</div>
										<h4>
											Sales Department <small><i class="fa fa-clock-o"></i>
												Yesterday</small>
										</h4>
										<p>Why not buy a new awesome theme?</p>
								</a></li>
								<li><a href="#">
										<div class="pull-left">
											<img src="resources/dist/img/user4-128x128.jpg"
												class="img-circle" alt="User Image">
										</div>
										<h4>
											Reviewers <small><i class="fa fa-clock-o"></i> 2 days</small>
										</h4>
										<p>Why not buy a new awesome theme?</p>
								</a></li>
							</ul>
						</li>
						<li class="footer"><a href="#">See All Messages</a></li>
					</ul></li>
				<!-- Notifications: style can be found in dropdown.less -->
				<li class="dropdown notifications-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <i
						class="fa fa-bell-o"></i> <span class="label label-warning">10</span>
				</a>
					<ul class="dropdown-menu">
						<li class="header">You have 10 notifications</li>
						<li>
							<!-- inner menu: contains the actual data -->
							<ul class="menu">
								<li><a href="#"> <i class="fa fa-users text-aqua"></i>
										5 new members joined today
								</a></li>
								<li><a href="#"> <i class="fa fa-warning text-yellow"></i>
										Very long description here that may not fit into the page and
										may cause design problems
								</a></li>
								<li><a href="#"> <i class="fa fa-users text-red"></i> 5
										new members joined
								</a></li>
								<li><a href="#"> <i
										class="fa fa-shopping-cart text-green"></i> 25 sales made
								</a></li>
								<li><a href="#"> <i class="fa fa-user text-red"></i>
										You changed your username
								</a></li>
							</ul>
						</li>
						<li class="footer"><a href="#">View all</a></li>
					</ul></li>
				<!-- Tasks: style can be found in dropdown.less -->
				<li class=""><a href="homepage"><span
						class="glyphicon glyphicon-home" style="color:"></span></a> <!-- <a href="homepage" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-flag-o"></i>
              <span class="glyphicon glyphicon-home"></span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 9 tasks</li>
              <li>
                inner menu: contains the actual data
                <ul class="menu">
                  <li>Task item
                    <a href="#">
                      <h3>
                        Design some buttons
                        <small class="pull-right">20%</small>
                      </h3>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">20% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  end task item
                  <li>Task item
                    <a href="#">
                      <h3>
                        Create a nice theme
                        <small class="pull-right">40%</small>
                      </h3>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-green" style="width: 40%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">40% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  end task item
                  <li>Task item
                    <a href="#">
                      <h3>
                        Some task I need to do
                        <small class="pull-right">60%</small>
                      </h3>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-red" style="width: 60%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">60% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  end task item
                  <li>Task item
                    <a href="#">
                      <h3>
                        Make beautiful transitions
                        <small class="pull-right">80%</small>
                      </h3>
                      <div class="progress xs">
                        <div class="progress-bar progress-bar-yellow" style="width: 80%" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                          <span class="sr-only">80% Complete</span>
                        </div>
                      </div>
                    </a>
                  </li>
                  end task item
                </ul>
              </li>
              <li class="footer">
                <a href="#">View all tasks</a>
              </li>
            </ul> --></li>
				<!-- User Account: style can be found in dropdown.less -->
				<li class="dropdown user user-menu"><a href="#"
					class="dropdown-toggle" data-toggle="dropdown"> <img
						src="resources/dist/img/user2-160x160.jpg" class="user-image"
						alt="User Image"> <span class="hidden-xs">Deepak</span>
				</a>
					<ul class="dropdown-menu">
						<!-- User image -->
						<li class="user-header"><img
							src="resources/dist/img/user2-160x160.jpg" class="img-circle"
							alt="User Image">

							<p>
								Deepak- Web Developer <small>Member since Nov. 2012</small>
								<!-- <a href="homepage"> <span class="glyphicon glyphicon-home"
									style="color: black"></span></a> <a href="logout"> <span
									class="glyphicon glyphicon-log-out" style="color: black"></span>
								</a> -->
							</p></li>
						<!-- Menu Body -->
						<!-- <li class="user-body">
							<div class="row">
								<div class="col-xs-4 text-center">
									<a href="#">Followers</a>
								</div>
								<div class="col-xs-4 text-center">
									<a href="#">Sales</a>
								</div>
								<div class="col-xs-4 text-center">
									<a href="#">Friends</a>
								</div>
							</div> /.row
						</li> -->
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="homepage" class="btn btn-default btn-flat"
									style="color: #3C8DBC;">Home</a>
							</div>
							<div class="pull-right">
								<a href="logout" class="btn btn-default btn-flat"
									style="color: #3C8DBC;">Sign out</a>
							</div>
						</li>
					</ul></li>
				<!-- Control Sidebar Toggle Button -->
				<li><a href="#" data-toggle="control-sidebar"><i
						class="fa fa-gears"></i></a></li>
			</ul>
		</div>

		</nav> </header>
		<FORM NAME="ChallanEntryForm" METHOD="post">
			<div class="row" style="margin-top: 15px">
				<div class="page-heading col-sm-11"></div>
				<br>
				<div align="center">
					<i>
						<h3></h3>
					</i> <input type="hidden" name="profile" value="0" />
				</div>
			</div>


			<div class="row">
				<div class="page-heading col-sm-11">
					<span class="glyphicon glyphicon-copy"></span> Add Collection
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


				</div>
			</div>


			<div class="row">
				<div class="page-heading col-sm-11">
					<span class="glyphicon glyphicon-copy"></span> Edit PO
				</div>
			</div>






			<div style="border: 1px solid #CCCCCC; padding: 7px; width: 93%">
				<div class="row form-group">

					<div class="col-sm-3 form-level">
						Invoice No:<font color="#FF0000">*</font>
					</div>
					<div class="col-sm-4">
						<input type="text" name="porefno" placeholder="Invoice No."
							onkeyup="myFunction()" id="porefno" size="150" value=""
							class="form-control" />
					</div>
					<div class="col-sm-1 form-level">
						Date:<font color="#FF0000">*</font>
					</div>
					<div class="col-sm-2">
						<span> <input type="text" class="form-control" name="date"
							onClick="displayCalendar(document.getElementById('date'),'dd/mm/yyyy',this,0); return false;"
							onchange="autoAdjustDate('start',this); return false;" value=""
							style="height: 35px; width: 140px; color: #000;" id="date"
							ReadOnly> <img src='/images/icons/calender.gif'
							style="margin: -26px 0px 0px 118px"
							onmouseover="displayCalendar(document.getElementById('date'),'dd/mm/yyyy',this,0); return false;"
							border='0' id='imgdate'>
						</span>

					</div>
					<!--              <div class="col-sm-1 form-level">ROE:<font color="#FF0000">*</font></div>               
                <div class="col-sm-2">
                    <input type="text" id="roe" name="roe" placeholder="roe" value="" class="form-control" style="width:95%"> 
                </div>-->
				</div>


			</div>

			<div>
				<div>

					<div class="row form-group">
						<!--               <div class="col-sm-3 form-level">Select Product<font color="#FF0000">*</font></div>-->
						<div class="col-sm-7">


							<input type="hidden" id="pro" value='' /> <input type="hidden"
								id="cost" value='' />

							<!--
                         <SELECT NAME="particular" id='particular' CLASS="form-control">                            
                                   
                                    <OPTION VALUE="" ></OPTION> 
                                    
                                   
                          </SELECT>  -->
						</div>



					</div>

					<table id="quotprodtable"
						style="width: 100%; bottom: 15px; position: relative;" border="0">
						<tr bgcolor="#145A32">

							<td class="col-sm-1 form-level" style="width: 10px">&nbsp;<font
								size="2" color="white">S.No.</font></td>
							<td class="col-sm-3 form-level" style="width: 80px"
								align="center">&nbsp;<font size="2" color="white">Part
									No</font></td>
							<td align="center" class="col-sm-1 form-level"
								style="width: 80px">&nbsp;&nbsp;&nbsp;<font size="2"
								color="white">Description</font></td>
							<td align="center">&nbsp;<font size="2" style="width: 80px"
								color="white">TP In JPY</font></td>
							<td align="center">&nbsp;<font size="2" style="width: 80px"
								color="white">QTY</font></td>
							<td align="center">&nbsp;<font size="2" style="width: 80px"
								color="white">Total JPY</font></td>
							<td align="center">&nbsp;<font size="2" style="width: 65px"
								color="white">Customer PO Reference</font> <!--               <td align="center"> &nbsp;<font size="2" style="width: 80px" color="white">Total INR</font> -->
						</tr>


						<tr onclick="getindex(this);">
							<!--                                     <td align="center">&nbsp;</td>-->
							<td style="right: 5px; position: relative;">&nbsp;<input
								type="text" class="form-control" id="" name="posrno"
								style="width: 65px; text-align: center;" value=""
								readonly="true"></td>
							<td style="left: 2px; position: relative; width: 150px">&nbsp;<input
								type="text" style="text-align: center;" name="particulee1"
								id="particulee1" class="form-control" value=""
								onkeyup="getcustomer1(this,event);" autocomplete="off"></td>

							<!--                               <td><select  name="challannoarray" style="width:180px;top:9px;position:relative;"  onchange="getdescription1(this)" id="particular" class="form-control">
                                   
                                    
                                   </select></td>-->
							<td style="width: 250px">&nbsp;<textarea rows="2" cols="35"
									style="top: 14px; left: 5px; position: relative; font-size: 12px; border-radius: 5px; background-color: #f2f2f2;"
									id="description" name="description" readonly="true"
									onfocus='closeDiv();'></textarea></td>
							<td style="right: 7px; position: relative;">&nbsp;<input
								type="text" style="text-align: center;" name="tpinjpy"
								id="tpinjpy" class="form-control" value="" readonly="true"></td>
							<td align="center" style="right: 4px; position: relative;">&nbsp;<input
								type="text" style="text-align: center;" name="qty" id="qty"
								onblur="cal(this)" onkeyup="cal(this)"
								onkeypress="return CheckIsNumeric(event)" class="form-control"
								value="" onfocus='closeDiv();'></td>
							<td align="center">&nbsp;<input type="text"
								style="text-align: center;" name="totaljpy" id="totaljpy"
								class="form-control" value="" onfocus='closeDiv();'
								readonly="true"></td>
							<!--                               <td style="width: 150px" >&nbsp;<input type="text" id="totalinr" name="totalinr" class="form-control" value=""></td>-->
							<td align="center">&nbsp;<input type="text"
								id="customerporefe" name="customerporefe" class="form-control"
								onkeyup="this.value=value.toUpperCase();" value=""></td>
							<td><input type="hidden" style="text-align: center;"
								name="particular" id="particular" value="" class="form-control"
								readonly="true"></td>

						</tr>


						<tr>
							<td></td>
						</tr>

					</table>

				</div>
				<div class="row form-group" style="top: 10px; position: relative;"
					onclick="closeDiv();">
					<div class="col-sm-10 form-level" align="right">
						<b>Total:</b><font color="#FF0000"></font>
					</div>
					<div align="right">
						<input type="text" name="tjpy1" id="tjpy1" class="form-control"
							value="" style="width: 15%;" readonly="true">
					</div>
				</div>

				<hr align="left" size="1" width="100%"
					style="background-color: #000000" />

				<div align="center" onclick="closeDiv();">



					<table>

						<tr>
							<td colspan="3">
								<p align="center">
									<button type="button"
										style="margin-left: auto; margin-right: auto; display: block; margin-top: 22%; margin-bottom: 0%">
										<a href="#" onClick="window.close();return false">Close</a>
									</button>
								</p>
							</td>
						</tr>

						<tr>
							<td align="center">
								<button type="button" value="update" onClick="updatebutton('');"
									class="btn btn-success pull-center">Update</button>
							</td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<td>
								<button style="width: 80px; height: 34px" type="button"
									value="Print" onClick="printbutton('');"
									class="btn btn-success pull-center">Print</button>
							</td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<td>
								<button style="width: 80px; height: 34px" type="button"
									value="PDF" onClick="pdfbutton('');"
									class="btn btn-success pull-center">PDF</button>
							</td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<td>
								<button style="width: 80px; height: 34px" type="button"
									value="Back" onClick="window.close();return false"
									class="btn btn-success pull-center">Back</button>
							</td>


						</tr>


					</table>


					<button type="button" value="Save" onClick="savebutton()"
						class="btn btn-success pull-center">Save</button>
					<button type="button" value="AddMore" onClick="productdetail();"
						class="btn btn-success pull-right">Add More</button>


				</div>

			</div>
			<div>
				<select name="pro" id="pro"
					style="width: 150; position: absolute; left: 180; top: 350; height: 200px; display: none;"
					multiple ondblclick="trackOnDoubleclick(this,event);"
					onclick="trackOnDoubleclick(this,event);"
					onkeypress="trackEnterKeyPress(this,event);">
				</select>
			</div>
			<div
				style="display: none; font-size: 12px; margin-left: 30px; margin-top: 0px; color: #000; background-color: #e3e3e3; position: absolute; width: 600; height: 450; border-radius: 10px 10px 10px 10px; solid #000; padding: 5px; top: 100px; left: 350px"
				id="additinal">
				<center>PDF Inputs</center>
				Kind Attn.:<input type="text" name="person" id="person"
					class="form-control"><br> Header :<input type="text"
					name="header1" id="header1" value="" class="form-control"><br>
				<textarea name="inst1" id="inst1" class="form-control"></textarea>
				<textarea name="inst2" id="inst2" class="form-control"></textarea>
				<textarea name="inst3" id="inst3" class="form-control"></textarea>
				<textarea name="inst4" id="inst4" class="form-control"></textarea>
				<textarea name="inst5" id="inst5" class="form-control"></textarea>

				<br>
				<center>
					<button type="button" value="Generate PDF"
						class="btn btn-success pull-center" onclick="pdfbutton1('');">Generate
						PDF</button>
					<button type="button" value="Close"
						class="btn btn-success pull-center" onclick="closeDivPDF();">Close</button>
				</center>
			</div>

		</FORM>
	</div>
	<!-- jQuery 2.2.0 -->
	<script src="resources/plugins/jQuery/jQuery-2.2.0.min.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script src="resources/plugins/fastclick/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="resources/dist/js/app.min.js"></script>
	<!-- Sparkline -->
	<script src="resources/plugins/sparkline/jquery.sparkline.min.js"></script>
	<!-- jvectormap -->
	<script
		src="resources/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script
		src="resources/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<!-- SlimScroll 1.3.0 -->
	<script src="resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<!-- ChartJS 1.0.1 -->
	<script src="resources/plugins/chartjs/Chart.min.js"></script>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="resources/dist/js/pages/dashboard2.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="resources/dist/js/demo.js"></script>
</body>
</html>