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
					action="${pageContext.request.contextPath}/home/login/branch/search"
					modelAttribute="form">
					<br />
					<b><%@ include file="businessMessage.jsp"%></b>
					
					<div class="container fw-bold">
						<h1 class="text-center">Branch List</h1>
					</div>
					<br/>
					<sf:input type="hidden" path="pageNo" />
					<sf:input type="hidden" path="pageSize" />

					<sf:input type="hidden" path="listsize" />
					<sf:input type="hidden" path="total" />
					<sf:input type="hidden" path="pagenosize" />
					<table class="table  rounded table-bordered table-hover table-striped" >
						<thead class="bg-nav text-white">
							<tr>
								<c:if test="${sessionScope.user.roleId == 1}">
									<th scope="col">Select
										Record</th>
								</c:if>
								<th scope="col">#</th>
								<th scope="col">Street/Landmark</th>
								<th scope="col">City</th>
								<th scope="col">State</th>
								<th scope="col">Country</th>
								<th scope="col">Contact</th>
								<th scope="col">Zip Code</th>
								<th scope="col">Actions</th>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="b" varStatus="branch">
								<tr>
									<c:if test="${sessionScope.user.roleId == 1}">
										<td><input type="checkbox" class="case" name="ids"
											value="${b.id}"></td>
									</c:if>
									<td scope="row">${branch.index+1}</td>
									<td scope="row">${b.street}</td>
									<td scope="row">${b.city}</td>
									<td scope="row">${b.state}</td>
									<td scope="row">${b.country}</td>
									<td scope="row">${b.contact}</td>
									<td scope="row">${b.zipCode}</td>
									<td><a  href="${editUrl}${b.id}"
									class="btn btn-dark"><i class="fas fa-edit"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<div class="clearfix">
						
<c:if test="${sessionScope.user.roleId == 1}">
							<input type="submit" name="operation"
								class="btn btn-sm btn-danger float-start"
								<c:if test="${listsize == 0}">disabled="disabled"</c:if>
								value="Delete">
						</c:if>

						<nav aria-label="Page navigation example float-end">
							<ul class="pagination justify-content-end"
								style="font-size: 13px">
								<li class="page-item"><input type="submit" name="operation"
									class="page-link"
									<c:if test="${form.pageNo == 1}">disabled="disabled"</c:if>
									value="Previous"></li>
								<c:forEach var="i" begin="1" end="${(listsize/10)+1}">
									<c:if test="${i== pageNo}">
										<li class="page-item active"><a
											class="page-link activate" href="${addSearch}?pageNo=${i}">${i}</a></li>
									</c:if>
									<c:if test="${i != pageNo}">
										<li class="page-item"><a class="page-link"
											href="${addSearch}?pageNo=${i}">${i}</a></li>
									</c:if>
								</c:forEach>
								<li class="page-item"><input type="submit" name="operation"
									class="page-link"
									<c:if test="${total == pagenosize  || listsize < pageSize   }">disabled="disabled"</c:if>
									value="Next"></li>
							</ul>
						</nav>
					</div>


				</sf:form>
		<!-- 	</div>
		</div> -->
	</section>
</div>