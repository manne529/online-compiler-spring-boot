<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Question</title>
<%@include file="links.jsp"%>
</head>
<body>
	<%@include file="trainerheader.jsp"%>

	<section class='container mt-5 mb-5'>
		<section class="row d-flex justify-content-center">
			<div>
				<h1>New Question</h1>
			</div>
		</section>
		<section class="row">
			<section class='col-sm-8 offset-sm-2'>

				<spring:form action="${contextPath}/trainer/question" method="POST"
					modelAttribute="question" enctype="multipart/form-data">
					<div class="form-group">
						<label for="questionTitle">Question Title</label>
						<spring:input path="questionTitle" name="questionTitle"
							class="form-control" />
					</div>
					<div class="form-group">
						<label for="question">Question</label>
						<spring:textarea path="questionContent" rows="25" cols="90"
							class="form-control" />
					</div>
					<div class="form-group">
						<input type="checkbox" name="testcasespresent"
							id="testcasespresent" onchange=testcaseDivToggle() /> <label
							for="testcases">Do want Add Test Cases</label>
					</div>
					<div id="testcasediv">
						<div class="form-group">
							<label for="testcasefile">Add Test Cases File</label>
							<spring:input type="file" path="testCasesFile"
								class="form-control" />
						</div>
						<div class="form-group">
							<label for="boilerplate">Boiler Plate</label>
							<spring:textarea path="boilerplate" name="boilerplate" rows="20"
								cols="90" class="form-control" />
						</div>
					</div>
					<div class="d-flex justify-content-center">
						<input type="submit" value="Add Question"
							class="btn btn-block btn-primary">
					</div>
				</spring:form>

			</section>
		</section>
	</section>

	<script type="text/javascript" src="/resources/js/addquestion.js"></script>
</body>
</html>