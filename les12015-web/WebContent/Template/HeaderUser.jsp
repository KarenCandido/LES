<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Hope for Pets</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Select2 -->
<link rel="stylesheet"
	href="../Bootstrap/bower_components/select2/dist/css/select2.min.css">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="../Bootstrap/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="../Bootstrap/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="../Bootstrap/bower_components/Ionicons/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="../Bootstrap/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="../Bootstrap/dist/css/skins/_all-skins.min.css">
<link rel="stylesheet" href="../custom-css/check-box.css">
<!-- daterange picker -->
<link rel="stylesheet"
	href="../Bootstrap/bower_components/bootstrap-daterangepicker/daterangepicker.css">
<!-- daterange picker -->
<link rel="stylesheet"
	href="../Bootstrap/bower_components/bootstrap-daterangepicker/daterangepicker.css">

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>

</head>
<!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->
<body class="hold-transition skin-green layout-top-nav">
	${applicationScope.resultado} ${applicationScope.pet}
	${applicationScope.cliente} ${applicationScope.pets}


	<div class="wrapper">

		<header class="main-header">
			<nav class="navbar navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<a href="" class="navbar-brand"><b>Hope for Pets</b></a>
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar-collapse">
							<i class="fa fa-bars"></i>
						</button>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse pull-left"
						id="navbar-collapse">
						<ul class="nav navbar-nav">
							<li><a href="Pedido?&operacao=MEUSPEDIDOS">Minhas
									Adoções</a></li>
							<li><a href="SalvarPet?&operacao=CONSULTAR">Pets</a></li>
						</ul>
						<!-- search form (Optional) -->
						<form action="SalvarPet" method="post"
							class="navbar-form navbar-left" role="search">
							<div class="form-group">
								<input type="text" id="navbar-search-input" name="nome_pet"
									class="form-control" placeholder="Pesquisar...">
								<button type="submit" name="operacao" id="operacao"
									value="CONSULTAR" class="btn btn-default">
									<i class="fa fa-search"></i>
								</button>
							</div>
						</form>
						<!-- /.search form -->

					</div>
					<!-- /.navbar-collapse -->
					<!-- Navbar Right Menu -->
					<div class="navbar-custom-menu">
						<ul class="nav navbar-nav">


							<!-- User Account Menu -->
							<li class="dropdown user user-menu">
								<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <!-- The user image in the navbar-->
									<img src="../Bootstrap/dist/img/user2-160x160.jpg"
									class="user-image" alt="User Image"> <span
									class="hidden-xs">${cliente.nome}</span>
							</a>
								<ul class="dropdown-menu">
									<!-- The user image in the menu -->
									<li class="user-header"><img
										src="../Bootstrap/dist/img/user2-160x160.jpg"
										class="img-circle" alt="User Image">

										<p>${cliente.nome}</p></li>
									<!-- Menu Footer-->
									<li class="user-footer">
										<div class="pull-left">
											<a href="#" class="btn btn-default btn-flat">Perfil</a>
										</div>
										<div class="pull-right">
											<a href="logout.jsp" class="btn btn-default btn-flat">Sair</a>
										</div>
									</li>
								</ul>
							</li>
						</ul>
					</div>
					<!-- /.navbar-custom-menu -->
				</div>
				<!-- /.container-fluid -->
			</nav>
		</header>