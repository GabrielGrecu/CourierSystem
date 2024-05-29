<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container mt-2"
	style="position: relative; min-height: 100vh" align="center">
	<section class="register col-md-6 offset-md-4">
		<div class="card shadow ">
			<div class="card-body ">
				<h5 class="card-title text-center">
					<i class="	fa fa-user" style="font-size: 50px;"></i><br>Change
					Password
				</h5>
				<sf:form method="post"
					action="${pageContext.request.contextPath}/home/login/changepassword"
					modelAttribute="form">
					<sf:hidden path="id"/>
					<br />
					<%
					String uri = (String) request.getAttribute("uri");
					%>
					<b><center><%@ include file="businessMessage.jsp"%></center></b>
					<div class="row">
						<div class="col-md-12 mb-4">
							<!-- Email input -->
							<div class="form-outline ">
								<s:bind path="oldPassword">
									<label for="inputEmail4" class="form-label">Old Password</label>
									<sf:input type="password" path="${status.expression}" placeholder="Enter Old Password"
										class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>

							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 mb-4">
							<!-- Password input -->
							<div class="form-outline ">
								<s:bind path="newPassword">
									<label for="inputEmail4" class="form-label">New Password</label>
									<sf:input  type="password" path="${status.expression}"
										placeholder="Enter New Password" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-12 mb-4">
							<!-- Password input -->
							<div class="form-outline ">
								<s:bind path="confirmPassword">
									<label for="inputEmail4" class="form-label">Confirm Password</label>
									<sf:input type="password" path="${status.expression}"
										placeholder="Enter Confirm Password" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
					</div>
					
					
					
					<div class="form-check d-flex justify-content-center mb-4 mt-2">
						<input type="submit" name="operation"
							class="btn btn-dark  pull-right" value="Save">
						&nbsp; <input type="submit" name="operation"
							class="btn btn-outline-dark  pull-right" value="Reset">
					</div>
				</sf:form>

			</div>
		</div>
	</section>
</div>