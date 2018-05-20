<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>E-commerce</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="../Bootstrap/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="../Bootstrap/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="../Bootstrap/bower_components/Ionicons/css/ionicons.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="../Bootstrap/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
<!-- daterange picker -->
<link rel="stylesheet"
	href="../Bootstrap/bower_components/bootstrap-daterangepicker/daterangepicker.css">
<!-- bootstrap datepicker -->
<link rel="stylesheet"
	href="../Bootstrap/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
<!-- iCheck for checkboxes and radio inputs -->
<link rel="stylesheet" href="../Bootstrap/plugins/iCheck/all.css">
<!-- Bootstrap Color Picker -->
<link rel="stylesheet"
	href="../Bootstrap/bower_components/bootstrap-colorpicker/dist/css/bootstrap-colorpicker.min.css">
<!-- Bootstrap time Picker -->
<link rel="stylesheet"
	href="../Bootstrap/plugins/timepicker/bootstrap-timepicker.min.css">
<!-- Select2 -->
<link rel="stylesheet"
	href="../Bootstrap/bower_components/select2/dist/css/select2.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="../Bootstrap/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="../Bootstrap/dist/css/skins/_all-skins.min.css">

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-green sidebar-mini">
	${applicationScope.resultado} ${applicationScope.livro}
	${applicationScope.mensagem} ${applicationScope.categorias}
	${applicationScope.editoras} ${applicationScope.grupos}
	${applicationScope.autores}
	<div class="wrapper">

		<header class="main-header">
			<!-- Logo -->
			<a href="Pedido?&operacao=HOME" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini"><i class="fa fa-fw fa-book"></i></span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg"><b>E-commerce</b></span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="push-menu"
					role="button"> <span class="sr-only">Toggle navigation</span>
				</a>
				<!-- Navbar Right Menu -->
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">

						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="../Bootstrap/dist/img/user2-160x160.jpg" class="user-image"
								alt="User Image"> <span class="hidden-xs"></span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><img
									src="../Bootstrap/dist/img/user2-160x160.jpg"
									class="img-circle" alt="User Image">

									<p></p></li>
								<!-- Menu Body -->

								<!-- Menu Footer-->
								<li class="user-footer">

									<div class="pull-right">
										<a href="../Login/logout.jsp" class="btn btn-default btn-flat">Sair</a>
									</div>
								</li>
							</ul></li>
						<!-- Control Sidebar Toggle Button -->

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
						<img src="../Bootstrap/dist/img/user2-160x160.jpg"
							class="img-circle" alt="User Image">
					</div>
					<div class="pull-left info">
						<p></p>
					</div>
				</div>
				<!-- search form -->
				<!-- /.search form -->
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu" data-widget="tree">
					<li class="header">MENU</li>
					<li class="treeview"><a href="#"><i
							class="fa fa-fw fa-book "></i> <span>Livro</span> <i
							class="fa fa-angle-left pull-right"></i></a>
						<ul class="treeview-menu">
							<li><a href="CRUDLivro?&operacao=GETALLBOOKS">Lista</a></li>
						</ul></li>
					<li class="treeview"><a href="#"><i
							class="fa fa-fw fa-male "></i> <span>Cliente</span> <i
							class="fa fa-angle-left pull-right"></i></a>
						<ul class="treeview-menu">
							<li><a href="CRUDCliente?&operacao=GETALLCLIENTS">Lista</a></li>
						</ul></li>
				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>
</body>
</html>