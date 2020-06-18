<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<div class="login-box">
    <form action="loginProcess" method="get">
        <div style="font-family: Arial;font-size:25px;font-weight: 700;text-align: center;padding: 10px">
            Employee Login Form
        </div>
        <div>
            <input type="text" name="name" placeholder="Enter Username" required>
        </div>
        <div>
            <input type="password" name="password" placeholder="Enter Password" required>
        </div>
        <div>
            <input type="submit" name="submit" value="Login">
        </div>
        <div style="font-family: Arial;font-size:12px;font-weight: 700;text-align: center;padding: 30px">
            <a href="register">Registration</a>
        </div>
    </form>
</div>
</body>
</html>