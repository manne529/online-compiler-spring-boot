<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
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
			<li><a href="${contextPath}/login">Login Here</a></li>
		</ul>
	</header>

	<section class='row d-flex flex-row justify-content-center mt-5'>
		<section class='col-sm-8'></section>
		<section id="register" class='col-sm-4 align-self-center'>


			<spring:form action="${contextPath}/register" method="post"
				modelAttribute="user" class='col-sm-8 offset-sm-2'>


				<div class='d-flex flex-row justify-content-center'>
					<h1>Register</h1>
				</div>


				<div class='form-group'>
					<label for='fullname'>Full Name</label>
					<spring:input path="fullname" type='text' name='fullname'
						class='form-control' />
					<spring:errors path="fullname" class='error-msgs'></spring:errors>
				</div>


				<div class='form-group'>
					<label for='email'>Email</label>
					<spring:input path="email" type='email' name='email'
						class='form-control' />
					<spring:errors path="email" class='error-msgs'></spring:errors>
				</div>



				<div class='form-group'>
					<label for='mobile'>Mobile</label>
					<spring:input path="mobile" type='tel' name='mobile'
						class='form-control' />
					<spring:errors path="mobile" class='error-msgs'></spring:errors>
				</div>


				<div class='form-group'>
					<label for='username'>Username</label> <input type='text'
						name='username' class='form-control' />
				</div>
				<div class='form-group'>
					<label for='role'>As a</label>
					<div class="d-flex justify-content-around">
						<div>
							<spring:radiobutton path="role" value="STUDENT" />
							<label for='student'>Student</label>
						</div>
						<div>
							<spring:radiobutton path="role" value="TRAINER" />
							<label for='trainer'>Trainer</label>
						</div>
					</div>
				</div>



				<div class='form-group'>
					<label for='password'>Password</label>
					<spring:input path="password" type='password' name='password'
						class='form-control' />
					<spring:errors path="password" class='error-msgs'></spring:errors>
				</div>


				<div class='form-group'>
					<label for='confirmPassword'>Confirm Password</label>
					<spring:input path="confirmPassword" type='password'
						name='confirmPassword' class='form-control' />
					<spring:errors path="confirmPassword" class='error-msgs'></spring:errors>
				</div>

				<div class='d-flex justify-content-center'>
					<input type="submit" class="btn btn-primary" />
				</div>

			</spring:form>

		</section>
	</section>

</body>
</html>