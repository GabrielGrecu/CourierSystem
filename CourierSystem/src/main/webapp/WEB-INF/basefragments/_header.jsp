<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-nav "
	>

	<a class="navbar-brand" href="#"> <b
		class="text-white ml-3 font-weight-bold">
			Courier Management</b>
	</a>

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="ml-auto nav justify-content-end">

			</ul>

		</div>

	</div>
</nav>

<nav class="navbar navbar-expand-md navbar-light text-dark fw-bold bg-light" >
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				style="color: black;" href="<c:url value="/home"/>">Home <span
					class="sr-only">(current)</span></a></li>


			<c:if test="${sessionScope.user != null}">
				<c:if test="${sessionScope.user.roleId == 1}">
<li class="nav-item"><a class="nav-link" style="color: black;"
						href="<c:url value="/home/login/branch"/>">Branch </a></li>
						<li class="nav-item"><a class="nav-link" style="color: black;"
						href="<c:url value="/home/login/branch/search"/>">Branch List </a></li>
					<li class="nav-item "><a class="nav-link "
						style="color: black;" href="<c:url value="/home/login/addcost"/>">Update Pricing</a></li>
					<li class="nav-item "><a class="nav-link "
						style="color: black;"
						href="<c:url value="/home/login/viewcost"/>">View
							Pricing</a></li>
					<li class="nav-item "><a class="nav-link "
						style="color: black;"
						href="<c:url value="/home/login/staff"/>">Add Staff</a></li>
					<li class="nav-item"><a class="nav-link" style="color: black;"
						href="<c:url value="/home/login/staff/search"/>">Staff
							List </a></li>
					<li class="nav-item "><a class="nav-link "
						style="color: black;"
						href="<c:url value="/home/login/courier/search"/>">View Courier</a></li>		

				</c:if>
				<c:if test="${sessionScope.user.roleId == 2}">
					<li class="nav-item "><a class="nav-link "
						style="color: black;"
						href="<c:url value="/home/login/viewcost"/>">
							Pricing</a></li>
					<li class="nav-item "><a class="nav-link "
						style="color: black;"
						href="<c:url value="/home/login/courier"/>">Add Courier</a></li>
					<li class="nav-item "><a class="nav-link "
						style="color: black;"
						href="<c:url value="/home/login/courier/search"/>">Track Courier</a></li>
						
				</c:if>
				
				<c:if test="${sessionScope.user.roleId == 3}">
					<li class="nav-item "><a class="nav-link "
						style="color: black;"
						href="<c:url value="/home/login/courier/search"/>">
							View Courier</a></li>
						
				</c:if>

			</c:if>
		</ul>


	</div>

	<ul class="navbar-nav justify-content-end">
		<c:if test="${sessionScope.user != null}">

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
				role="button" data-bs-toggle="dropdown" aria-expanded="false"
				style="color: black;"> Hello,${sessionScope.user.firstName}
					(${sessionScope.user.roleName }) </a>
				<ul class="dropdown-menu">

					<li><a class="dropdown-item"
						href="<c:url value="/home/login/myprofile"/>">My Profile</a></li>
					<li><a class="dropdown-item"
						href="<c:url value="/home/login/changepassword"/>">Change
							Password</a></li>

				</ul></li>
			<li class="nav-item "><a class="nav-link"
				style="padding: 6px; color: black;"
				href="<c:url value="/home/login"/>">Logout</a></li>
		</c:if>
		<c:if test="${sessionScope.user == null}">
			<li class="nav-item"><a class="nav-link" style="color: black;"
				href="<c:url value="/home/login"/>"><i class="fa fa-sign-in">
						Login</i></a></li>
			<li class="nav-item"><a class="nav-link" style="color: black;"
				href="<c:url value="/home/register"/>"><i
					class="fa fa-user-plus"> Register </i></a></li>
					
		</c:if>
	</ul>

</nav>
