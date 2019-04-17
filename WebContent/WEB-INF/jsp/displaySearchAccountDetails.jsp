<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Search Account Details</h1>
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
			<tr>
				<td>${accountDetails.accountId }</td>
				<td>${accountDetails.accountHolderName}</td>
				<td>${accountDetails.accountType}</td>
				<td>${accountDetails.accountBalance}</td>
			</tr>
		</tbody>
</body>

</html>