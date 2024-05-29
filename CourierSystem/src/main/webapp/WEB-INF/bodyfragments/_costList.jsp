<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>



<c:url var="addUrl" value="/home/login/branch" />

<c:url var="addSearch" value="/home/login/branch/search" />

<c:url var="editUrl" value="/home/login/branch?id=" />


<br>
<div class="container mt-2 mb-3"
	style="position: relative; min-height: 100vh">
	<section class="register">

		<!-- <div class="card shadow">
			<div class="card-body">-->
				          
				<sf:form method="post"
					action="${pageContext.request.contextPath}/home/login/viewcost"
					modelAttribute="form">
					<br />
					<b><%@ include file="businessMessage.jsp"%></b>
					
					<div class="container fw-bold">
						<h1 class="text-center">Pricing</h1>
					</div>
					<br/>
					<sf:input type="hidden" path="pageNo" />
					<sf:input type="hidden" path="pageSize" />

					<sf:input type="hidden" path="listsize" />
					<sf:input type="hidden" path="total" />
					<sf:input type="hidden" path="pagenosize" />
					<c:if test="${bean.getCost1()==null || bean.getCost2()==null }">
					<table class="table  rounded table-bordered table-hover table-striped" >
						<thead class="bg-nav text-white">
						<tr>
							<td class="">Weight</td>
							<td class="">Cost</td>
						</tr>	
						</thead>
						<tbody>
							
						<tr>
							<td class=""> <= 100 Kg</td>
							<td class="">10 RON  /kg</td>
						</tr>
						<tr>
							<td class=""> > 100 Kg</td>
							<td class="">10 RON  /kg</td>
						</tr>
						</tbody>
					</table>
					</c:if>
					<c:if test="${bean.getCost1()>0 || bean.getCost2()>0 }">
					<table class="table  rounded table-bordered table-hover table-striped">
					  <thead class="bg-nav text-white">
						<tr>
							<td class="">Weight</td>
							<td class="">Cost</td>
						</tr>
					  </thead>	
						<tr>
							<td class=""> <= 100 Kg</td>
							<td class="">${bean.getCost1() } RON  /kg</td>
						</tr>
						<tr>
							<td class=""> > 100 Kg</td>
							<td class="">${bean.getCost2() } RON  /kg</td>
						</tr>
					</table>
				</c:if>
					


				</sf:form>
		<!-- 	</div>
		</div> -->
	</section>
</div>