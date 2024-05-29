<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container mt-2 mb-3"
	style="position: relative; min-height: 100vh" ; align="center">



	<!--  Login Page for User -->
	<section class="register col-md-6 offset-md-4">
		<div class="card shadow ">
			<div class="card-body ">
				<h5 class="card-title text-center">
					<i class="	fa fa-money" style="font-size: 50px;"></i><br>
					Payment Page
				</h5>
				<sf:form method="post"
					action="${pageContext.request.contextPath}/home/login/payment"
					modelAttribute="form">
					<br />
					<b class="text-center" style="font-size: 20px;"><%@ include
							file="businessMessage.jsp"%></b>

	<sf:hidden path="id"/>
					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">

									<label for="exampleInputEmail1">Card Number</label>
									<sf:input path="${status.expression}" placeholder="Enter Card Number"
										class="form-control" required="required"/>
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="form-group">

									<label for="exampleInputPassword1">Expiry</label>
									<sf:input  path="${status.expression}"
										placeholder="MM/YYYY" class="form-control" required="required"/>
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								
							</div>
						</div>
						</div>
						<div class="row">
						<div class="col-lg-12">
							<div class="form-group">

									<label for="exampleInputPassword1">CVV</label>
									<sf:input type="password"  path="${status.expression}"
										placeholder="Enter CVV" class="form-control" required="required"/>
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								
							</div>
						</div>
						</div>
						<div class="row">
						<div class="col-lg-12">
							<div class="form-group">

									<label for="exampleInputPassword1">Total Price</label>
									<c:if test="${totalCost == null}">
									<sf:input  path="${status.expression}" value="PAID"
										 class="form-control readonly-field" readonly="readonly"  />
										</c:if>
								<c:if test="${totalCost != null}">
									<sf:input  path="${status.expression}" value="${totalCost}"
								 class="form-control readonly-field" readonly="readonly" />
										</c:if>		
									
								
							</div>
						</div>
					</div>

					<div class="container text-center">
						<input type="submit" class="btn btn-dark " value="Pay"
							name="operation"> 
					</div>

				</sf:form>
			</div>
		</div>

	</section>
</div>