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
			
				<sf:form method="post"
					action="${pageContext.request.contextPath}/home/login/courier"
					modelAttribute="form">
					<br />
					<c:if test="${form.id > 0}">
				<h5 class="card-title text-center">
					<i class="	fa fa-user-plus" style="font-size: 50px;"></i><br>Assign Staff
				</h5>
			</c:if>
			<c:if test="${form.id == 0 }">
				<h5 class="card-title text-center">
					<i class="	fa fa-truck" style="font-size: 50px;"></i><br>Add Courier
				</h5>
			</c:if>	
					<sf:hidden path="id"/>
					<b class="text-center" style="font-size: 20px;"><%@ include file="businessMessage.jsp"%></b>
					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">

								<s:bind path="senderName">
									<label for="exampleInputEmail1">Sender Name</label>
									<sf:input path="${status.expression}"
										placeholder="Enter Sender Name" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">

								<s:bind path="senderAddress">
									<label for="exampleInputEmail1">Sender Address</label>
									<sf:input path="${status.expression}"
										placeholder="Enter Sender Address" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">

								<s:bind path="SenderNo">
									<label for="exampleInputEmail1">Sender Number</label>
									<sf:input path="${status.expression}" placeholder="Enter Sender Number"
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

								<s:bind path="receiverName">
									<label for="exampleInputEmail1">Receiver Name</label>
									<sf:input type="text" path="${status.expression}"
										placeholder="Enter Receiver Name" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">

								<s:bind path="receiverAddress">
									<label for="exampleInputPassword1">Receiver Address</label>
									<sf:input path="${status.expression}"
										placeholder="Enter Receiver Address" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">

								<s:bind path="receiverNo">
									<label for="exampleInputPassword1">Receiver No.</label>
									<sf:input path="${status.expression}"
										placeholder="Enter Receiver Number" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">
								<s:bind path="branchId">
									<label for="exampleInputPassword1">Select Branch</label>
									<sf:select class="form-control" path="${status.expression}">
										
								<sf:option value="-1" label="---Select---" />			
							
							
								<sf:options itemLabel="fullBranchName" itemValue="id"
									items="${searchList}" />
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
								<s:bind path="weight">
									<label for="exampleInputPassword1">Weight</label>
									<sf:input path="${status.expression}"
										placeholder="Enter Weight" class="form-control"
										 />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
					</div>
					
					<c:if test="${form.id > 0 }">
					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">
								<s:bind path="staffId">
									<label for="exampleInputPassword1">Assign Staff</label>
									<sf:select class="form-control" path="${status.expression}">
										
								<sf:option value="-1" label="---Select---" />			
							
							
								<sf:options itemLabel="firstName" itemValue="id"
									items="${staffList}" />
									</sf:select>
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
					</div>
						<c:if test="${sessionScope.user.roleId == 3 }">
							<div class="row">
						<div class="col-lg-12">
							<div class="form-group">
								<s:bind path="status">
									<label for="exampleInputPassword1">Update Status</label>
									<sf:select class="form-control" path="${status.expression}">
										<sf:option value="" label="---Select---" />
										<sf:options items="${cstatus}" />
									</sf:select>
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
					</div>
						</c:if>
					</c:if>




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