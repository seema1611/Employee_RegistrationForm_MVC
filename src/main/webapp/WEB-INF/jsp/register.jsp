<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">

</head>
<body>
<div class="login-box">
    <form action="registerProcess" method="get">
        <div style="font-family: Arial;font-size:25px;font-weight:700;text-align: center;padding:10px">
            Employee Registration Form
        </div>

        <div>
            <input type="text" name="name" placeholder="Enter name" required>
        </div>

        <div>
            <input type="text" name="email" placeholder="Enter email" required>
        </div>

        <div>
            <input type="text" name="address" placeholder="Enter address" required>
        </div>

        <div>
            <input type="number" name="salary" placeholder="Enter salary" required>
        </div>

        <div class = "dropdown_container">
            <select class = "my_dropdown" name="position" placeholder="Enter position" id="my_dropdown">
                <option value="1"></option>
                <option value="2">Chennai</option>
                <option value="3">Mumbai</option>
                <option value="4">Pune</option>
                <option value="5">Hyderabad</option>
                <option value="6">Banglore</option>
                <option value="7">Other</option>
            </select>
        </div>

        <div>
            <input type="password" name="password" placeholder="Enter password" required>
        </div>

        <div>
            <input type="submit" name="submit" value="Register">
        </div>

        <div style="font-family: Arial;font-size:12px;font-weight: 700;text-align: center;padding: 30px">
            <a href="login">Login</a>
        </div>

    </form>
</div>
</body>
</html>