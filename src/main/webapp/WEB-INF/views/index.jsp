<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="links.jsp"%>
</head>
<body>
	<header>
		<div>
			<h1>Online - Compiler</h1>
		</div>
		<ul>
			<li><a href="${contextPath}/register">Register Here</a></li>
		</ul>
	</header>


	<section class='row d-flex flex-row justify-content-center h-80'>
		<section class='col-sm-8'></section>
		<section id="login" class='col-sm-4 align-self-center'>

			<form class='form col-sm-8 offset-sm-2'>
				<div class='d-flex justify-content-center'>
					<h1>Login</h1>
				</div>
				<div class='form-group'>
					<label for='username'>Username</label> <input type='text'
						name='username' class='form-control'>
				</div>
				<div class='form-group'>
					<label for='password'>Password</label> <input type='password'
						name='password' class='form-control'>
				</div>
				<div class='d-flex justify-content-center'>
					<input type="submit" class="btn btn-primary" />
				</div>

			</form>

		</section>
	</section>

</body>
</html>