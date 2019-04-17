<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <title>Check-Balance</title>
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
          padding: 20px;
        }
        
        /* an underline appears at the bottom on hover of each link */
        nav ul li a:hover, nav ul li a:active{
          border-bottom: 2px solid #ccc;
          padding-bottom: 8px;
        }
        .header {
  padding: 10px 16px;
  background: #555;
  color: #f1f1f1;
  position: fixed;
  top: 0;
  width: 100%;
}
            </style>
</head>
<body>
    <div class="header">
        <center>
            <h1><a  href="index.html" style="color: azure"> AMD BANK</a></h1>
                </center>
            </div>
                <nav style="margin-top: 20px;">
                        <ul>
                          <li><a href="new_account.html">New Account</a></li>
                          <li><a href="withdraw.html">Withdraw</a></li>
                          <li><a href="deposite.html">Deposit</a></li>
                          <li><a href="fund_transfer.html">Fund Transfer</a></li>
                          <li><a href="check_balance.html">Check Balance</a></li>
                          <li><a href="display.html">Display All Account Details</a></li>
                        </ul>
                 </nav>
        <div class="container" style="margin-top:50px; margin-left:550px" >
                <form action="/bankappusingspringmvc/app/bank/updateAccount" method="post">
                        <div style="margin-top: 100px" >
                        <h1>Update Account Page</h1>
                        <div class="form-group">
                                <label for="exampleFormControlInput1">Account id</label>
                                <input type="Number" class="form-control" style="width: 270px" id="exampleFormControlInput1" name="account_id" placeholder="Enter Account Id " required>
                              </div>
                            

                              <div class="form-group" style="margin-left: 50px">
                                    &nbsp;&nbsp;&nbsp;<button>Get Details</button>
                                  </div>
                        </div>
                </form>
        </div>
    
</body>
</html>