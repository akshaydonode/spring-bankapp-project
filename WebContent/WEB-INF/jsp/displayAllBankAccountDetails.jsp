<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>All Account Details</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Account Id</th>
				<th>Account Holder Name</th>
				<th>Account Type</th>
				<th>Account Balance</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="account" items="${accountsList}">
				<tr>
					<td><c:out value="${account.accountId }" /></td>
					<td><c:out value="${account.accountHolderName }" /></td>
					<td><c:out value="${account.accountType }" /></td>
					<td><c:out value="${account.accountBalance }" /></td>
				</tr>	
			</c:forEach>
		</tbody>
	</table>

</body>
</html>