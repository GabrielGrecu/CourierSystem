<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<div class="container mt-2 mb-3"
	style="position: relative; min-height: 100vh" ; align="center">



	<!--  Courier Page for User -->
	<section class="">
		<div class="card shadow ">
			<div class="card-body ">
				<h5 class="card-title text-center">
					<i class="	fa fa-truck" style="font-size: 50px;"></i><br>
					View Courier Detail
				</h5>
				<sf:form method="post"
					action="${pageContext.request.contextPath}/home/login/view-courier"
					modelAttribute="form">
					<br />
					<b class="text-center" style="font-size: 20px;"><%@ include
							file="businessMessage.jsp"%></b>

					<table class="table ">
				<tr>
					<th class="border  px-4 py-2">Tracking No</th>
					<td class="border px-4 py-2">${form.trackingNo}</td>
					<th class="border  px-4 py-2">Status</th>
					<td class="border px-4 py-2 text-danger fw-bold" style="color: black; font-weight: bold;">${form.status}</td>
				</tr>
				<tr>
					<th class="border  px-4 py-2">Sender Name</th>
					<td class="border px-4 py-2">${form.senderName}</td>
					<th class="border  px-4 py-2">Receiver Name</th>
					<td class="border px-4 py-2">${form.receiverName}</td>
				</tr>
				<tr>
					<th class="border  px-4 py-2">Sender Address</th>
					<td class="border px-4 py-2">${form.senderAddress}</td>
					<th class="border  px-4 py-2">Receiver Address</th>
					<td class="border px-4 py-2">${form.receiverAddress}</td>
				</tr>
				<tr>
					<th class="border px-4 py-2">Sender No</th>
					<td class="border px-4 py-2">${form.senderNo }</td>
					<th class="border px-4 py-2">Receiver No</th>
					<td class="border px-4 py-2">${form.receiverNo}</td>
				</tr>
				<tr>
					<th class="border  px-4 py-2">Courier Weight</th>
					<td class="border px-4 py-2">${form.weight }
						Kg</td>
					<th class="border  px-4 py-2">Total Amount</th>
					<td class="border px-4 py-2">${form.totalCost}</td>
				</tr>
				<tr>
					<th class="border  px-4 py-2">Branch</th>
					<td class="border px-4 py-2">${form.branch.fullBranchName }</td>
					<th class="border  px-4 py-2">Staff Allocated(Name & MobileNo)</th>
					<td class="border px-4 py-2">${form.user.firstName} ${form.user.lastName} ${form.user.mobileNo}</td>
				</tr>
					</table>
				</sf:form>
			</div>
		</div>

	</section>
</div>