<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>



<c:url var="addUrl" value="/home/login/courier" />

<c:url var="addSearch" value="/home/login/courier/search" />

<c:url var="editUrl" value="/home/login/courier?id=" />

<c:url var="ViewUrl" value="/home/login/view-courier?id=" />


<br>
<div class="container "
	style="position: relative; min-height: 100vh">
	<section class="register">

				          
				<sf:form method="post"
					action="${pageContext.request.contextPath}/home/login/courier/search"
					modelAttribute="form">
					<br />
					<b><%@ include file="businessMessage.jsp"%></b>
					
					<div class="container fw-bold">
						<h1 class="text-center">Courier List</h1>
					</div>
					<br/>
					<sf:input type="hidden" path="pageNo" />
					<sf:input type="hidden" path="pageSize" />

					<sf:input type="hidden" path="listsize" />
					<sf:input type="hidden" path="total" />
					<sf:input type="hidden" path="pagenosize" />
					<table class="table  table-borderless">
					<tr>
					<td>
						<div class="col-lg-12">
							<div class="form-group">

								<s:bind path="trackingNo">
									<label for="exampleInputPassword1">Tracking Number</label>
									<sf:input path="${status.expression}"
										placeholder="Enter Tracking Number" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
							</div>
							</td>
					<td>
						<div class="col-lg-12">
							<div class="form-group">
								<s:bind path="status">
									<label for="exampleInputPassword1">Track Status</label>
									<sf:select class="form-control" path="${status.expression}">
										<sf:option value="" label="---Select---" />
										<sf:options items="${cstatus}" />
									</sf:select>
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
							</td>		
							
					</tr>
					</table>
					<div class="container text-center mt-2">
						<input type="submit" class="btn btn-dark " value="Search"
							name="operation"> <input type="submit"
							class="btn btn-dark " value="Reset" name="operation">
					</div>
					<table class="table  rounded table-bordered table-hover table-striped mt-2" >
						<thead class="bg-nav text-white">
							<tr>
								<c:if test="${sessionScope.user.roleId == 1}">
									<th scope="col">Select
										Record</th>
								</c:if>
								<th scope="col">#</th>
								<th scope="col">Tracking No.</th>
								<th scope="col">Sender Name</th>
								<th scope="col">Sender Address</th>
								<th scope="col">Receiver Name</th>
								<th scope="col">Receiver Address</th>
								<th scope="col">Courier Time</th>
								<c:if test="${sessionScope.user.roleId == 1 || sessionScope.user.roleId == 3}">
								<th scope="col">Actions</th>
								</c:if>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="c" varStatus="courier">
							<c:if test="${c.createdBy eq sessionScope.user.login || sessionScope.user.roleId == 1 || sessionScope.user.id == c.staffId}">
								<tr>
									<c:if test="${sessionScope.user.roleId == 1}">
										<td><input type="checkbox" class="case" name="ids"
											value="${c.id}"></td>
									</c:if>
									<td scope="row">${courier.index+1}</td>
									
									<td scope="row"><a class="fw-bold text-danger" style="color: black; font-weight: bold;" href="${ViewUrl}${c.id}"><u>${c.trackingNo}</u></a></td>
									
									<td scope="row">${c.senderName}</td>
									<td scope="row">${c.senderAddress}</td>
									<td scope="row">${c.receiverName}</td>
									<td scope="row">${c.receiverAddress}</td>
									<td scope="row">${c.createdDatetime}</td>
									<c:if test="${sessionScope.user.roleId == 1}">
									<td><a  href="${editUrl}${c.id}"
									class="btn btn-dark bg-nav fw-bold">Assign Staff</a></td></c:if>
									<c:if test="${sessionScope.user.roleId == 3}">
									<td><a  href="${editUrl}${c.id}"
									class="btn btn-dark bg-nav fw-bold">Update Status</a></td></c:if>
								</tr>
								</c:if>
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