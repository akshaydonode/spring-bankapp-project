<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Update Account</h1>
	<form action="updateBankAccountDetails.do" method="post">
		<label>Account ID:</label>
		<input type="number" name="accountId" value="${data.accountId}" readonly="readonly"> 
			<br><br>
			
		<label>Customer Name:</label>
		<input type="text" name="name" value="${data.accountHolderName}">
		<br><br>
		
		 <label for="exampleFormControlSelect1">Account Type</label>
              <select class="form-control" id="exampleFormControlSelect1" name="account_type" value="${data.accountType }" style="width:270px">
                  <option>-Select-</option>
                  <option>Saving</option>
                  <option>Current</option>
                    
              </select>
           <br><br>
              
            <label>Account Balance:</label>
		<input type="text" name="account_balance" value="${data.accountBalance}" readonly="readonly">
		<br><br>
		<input type="submit" value="Update Details">

	</form>
</body>
</html>