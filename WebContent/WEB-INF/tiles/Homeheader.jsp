<div>
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

	<body class="hold-transition skin-blue sidebar-mini">
		<%
	String name=null;
	Integer iduser=null;
	String userImg=null;
	try{
		name=(String)session.getAttribute("username");
		iduser=(Integer)session.getAttribute("userid");
		userImg=(String)session.getAttribute("userProImg");
		userImg=userImg.split("resources")[1];
		session.setMaxInactiveInterval(1800);
		if(name==null || iduser==null || userImg==null){
			response.sendRedirect("LoginPage.jsp");
		}
	}catch(Exception e){
		
		if(name==null || iduser==null || userImg==null){
			response.sendRedirect("LoginPage.jsp");
		}
	}
if(name==null || iduser==null || userImg==null){
	response.sendRedirect("LoginPage.jsp");
}

%>
		<div class="wrapper">

			<header class="main-header">
				<!-- Logo -->
				<a href="homepage" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
					<span class="logo-mini"><b>E</b>RP</span> <!-- logo for regular state and mobile devices -->
					<span class="logo-lg"><b>POGO</b>ERP</span>
				</a>
				<!-- Header Navbar: style can be found in header.less -->
				<nav class="navbar navbar-static-top">
					<!-- Sidebar toggle button-->
					<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
						role="button"> <span class="sr-only">Toggle navigation</span>
					</a>
					<!-- Navbar Right Menu -->
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
														Support Team <small><i class="fa fa-clock-o"></i>
															5 mins</small>
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
														AdminLTE Design Team <small><i
															class="fa fa-clock-o"></i> 2 hours</small>
													</h4>
													<p>Why not buy a new awesome theme?</p>
											</a></li>
											<li><a href="#">
													<div class="pull-left">
														<img src="resources/dist/img/user4-128x128.jpg"
															class="img-circle" alt="User Image">
													</div>
													<h4>
														Developers <small><i class="fa fa-clock-o"></i>
															Today</small>
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
														Reviewers <small><i class="fa fa-clock-o"></i> 2
															days</small>
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
											<li><a href="#"> <i
													class="fa fa-warning text-yellow"></i> Very long
													description here that may not fit into the page and may
													cause design problems
											</a></li>
											<li><a href="#"> <i class="fa fa-users text-red"></i>
													5 new members joined
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
									class="glyphicon glyphicon-home" style="color:"></span></a></li>
							<!-- User Account: style can be found in dropdown.less -->
							<li class="dropdown user user-menu"><a href="#"
								class="dropdown-toggle" data-toggle="dropdown"> <img
									src="resources<%=userImg %>" class="user-image"
									alt="User Image"> <span class="hidden-xs"><%=name %></span>
							</a>
								<ul class="dropdown-menu">
									<!-- User image -->
									<li class="user-header"><img
										src="resources/dist/img/user2-160x160.jpg" class="img-circle"
										alt="User Image">

										<p>
											<%=name %>- Web Developer <small>Member since Nov.
												2012</small>
										</p></li>
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
				</nav>
			</header>
			<!-- Left side column. contains the logo and sidebar -->
			<aside class="main-sidebar">
				<!-- sidebar: style can be found in sidebar.less -->
				<section class="sidebar">
					<!-- Sidebar user panel -->
					<div class="user-panel">
						<div class="pull-left image">
							<img src="resources/dist/img/user2-160x160.jpg"
								class="img-circle" alt="User Image">
						</div>
						<div class="pull-left info">
							<p>Deepak</p>
							<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
						</div>
					</div>
					<!-- search form -->
					<form action="#" method="get" class="sidebar-form">
						<div class="input-group">
							<input type="text" name="q" class="form-control"
								placeholder="Search..."> <span class="input-group-btn">
								<button type="submit" name="search" id="search-btn"
									class="btn btn-flat">
									<i class="fa fa-search"></i>
								</button>
							</span>
						</div>
					</form>
		</div>