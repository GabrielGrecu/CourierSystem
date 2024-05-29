<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container mt-2 mb-3"
	style="position: relative; min-height: 100vh" ; align="center">
	
	
	
	<!--  Registration Page for User -->
	<section class="register col-md-6 offset-md-4">
		<div class="card shadow ">
			<div class="card-body ">
				<h5 class="card-title text-center">
					<i class="	fa fa-user-plus" style="font-size: 50px;"></i><br>
					My Profile
				</h5>
				<sf:form method="post"
					action="${pageContext.request.contextPath}/home/login/myprofile"
					modelAttribute="form">
					<br />
					<b class="text-center" style="font-size: 20px;"><%@ include file="businessMessage.jsp"%></b>
					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">

								<s:bind path="firstName">
									<label for="exampleInputEmail1">First Name</label>
									<sf:input path="${status.expression}"
										placeholder="Enter First Name" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">

								<s:bind path="lastName">
									<label for="exampleInputEmail1">Last Name</label>
									<sf:input path="${status.expression}"
										placeholder="Enter last Name" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">

								<s:bind path="login">
									<label for="exampleInputEmail1">Email address</label>
									<sf:input path="${status.expression}" placeholder="Enter Email"
										class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">

								<s:bind path="mobileNo">
									<label for="exampleInputEmail1">Phone Number</label>
									<sf:input type="text" path="${status.expression}"
										placeholder="Enter Mobile No." class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">

								<s:bind path="password">
									<label for="exampleInputPassword1">Password</label>
									<sf:input type="password" path="${status.expression}"
										placeholder="Enter Password" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">
								<s:bind path="gender">
									<label for="exampleInputPassword1">Gender</label>
									<sf:select class="form-control" path="${status.expression}">
										<sf:option value="" label="---Select---" />
										<sf:options items="${gender}" />
									</sf:select>
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
					</div>

					<div class="row">

						<div class="col-lg-12">
							<div class="form-group">
								<s:bind path="dob">
									<label for="exampleInputPassword1">DOB</label>
									<sf:input path="${status.expression}"
										placeholder="Enter Date of Birth in MM/DD/YYYY" class="form-control"
										id="datepicker" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
					</div>




					<div class="container text-center">
						<input type="submit" class="btn btn-dark " value="Save"
							name="operation"> <input type="submit"
							class="btn btn-dark " value="Reset" name="operation">
					</div>

				</sf:form>
			</div>
		</div>

	</section>
</div>