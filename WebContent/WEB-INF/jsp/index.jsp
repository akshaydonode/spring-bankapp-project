<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <title>AMD BANK</title>
    <style>
    nav{
  position: fixed;
  left: 0px;
  margin: 0 auto;
  width: 100%;
  background-color: #222;
}

nav ul{
  list-style-type: none;
  text-align: center;
}

nav ul li{
  display: inline-block;
  text-align: center;
  padding: 20px;
  height: 2%;
}

nav ul li a{
  text-decoration: none;
  color: white;
  padding: 0px;
}

/* an underline appears at the bottom on hover of each link */
nav ul li a:hover, nav ul li a:active{
  border-bottom: 2px solid #ccc;
  padding-bottom: 8px;
}
.mySlides{
	
}

    </style>
</head>
<body>
    <div class="header"> 
    <center>
    <h1> AMD BANK</h1>
    </center>
</div>
    <nav>
            <ul>
              <li><a href="/bankappusingspringmvc/app/bank/new">New Account</a></li>
              <li><a href="/bankappusingspringmvc/app/bank/withdraw">Withdraw</a></li>
              <li><a href="/bankappusingspringmvc/app/bank/deposit">Deposit</a></li>
              <li><a href="/bankappusingspringmvc/app/bank/fundtransfer">Fund Transfer</a></li>
              <li><a href="/bankappusingspringmvc/app/bank/search">Search Account</a></li>
              <li><a href="/bankappusingspringmvc/app/bank/checkBalance">Check Balance</a></li>
              <li><a href="/bankappusingspringmvc/app/bank/displayAllAccountDetails" >Display All Account Details</a></li>
              <li><a href="/bankappusingspringmvc/app/bank/delete">Delete Account</a></li>
              <li><a href="/bankappusingspringmvc/app/bank/update">Update Account</a></li>
            </ul>
     </nav>
    
</body>
</html>