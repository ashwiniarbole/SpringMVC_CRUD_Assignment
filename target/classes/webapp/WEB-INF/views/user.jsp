<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" isELIgnored="false" %>

<html>
<head>
	<title>Person Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	User Details
</h1>

<c:url var="addAction" value="/save" ></c:url>

<form:form action="${addAction}" commandName="user">
<table>
	<c:if test="${!empty user.fname}">
	<tr>
		<td>
			<form:label path="userId">
				<spring:message text="userId"/>
			</form:label>
		</td>
		<td>
			<form:input path="userId" readonly="true" size="8"  disabled="true" />
			<form:hidden path="userId" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="fname">
				<spring:message text="First Name :"/>
			</form:label>
		</td>
		<td>
			<form:input path="fname" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="lname">
				<spring:message text="last Name :"/>
			</form:label>
		</td>
		<td>
			<form:input path="lname" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="uAddress">
				<spring:message text="Address :"/>
			</form:label>
		</td>
		<td>
			<form:input path="uAddress" />
		</td>
	</tr>
		<tr>
		<td>
			<form:label path="userPhone">
				<spring:message text="Phone :"/>
			</form:label>
		</td>
		<td>
			<form:input path="userPhone" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty user.fname}">
				<input type="submit"
					value="<spring:message text="Edit User"/>" />
			</c:if>
			<c:if test="${empty user.fname}">
				<input type="submit"
					value="<spring:message text="Add User"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Users List</h3>
<c:if test="${!empty listUsers}">
	<table class="tg">
	<tr>
		<th width="80">User ID</th>
		<th width="120">First Name</th>
		<th width="120">Last Name</th>
		<th width="120">User Address</th>
		<th width="120">User Phone</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listUsers}" var="user">
		<tr>
			<td>${user.userId}</td>
			<td>${user.fname}</td>
			<td>${user.lname}</td>
			<td>${user.uAddress}</td>
			<td>${user.userPhone}</td>
			<td><a href="<c:url value='/edit/${user.userId}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${user.userId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
