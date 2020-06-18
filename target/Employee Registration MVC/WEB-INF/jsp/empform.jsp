<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="US-ASCII">
    <title>Login Form</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>

<form method="post">
    <div class="form-input">
        <input type="text" name="name" placeholder="enter the name" class="form-input-text">
    </div>
    <br>

    <div class="form-input">
        <input type="text" name="email" placeholder="enter the email" class="form-input-text">
    </div>
    <br>

    <div class="form-input">
        <input type="text" name="address" placeholder="enter the address" class="form-input-text">
    </div>
    <br>

    <div class="form-input">
        <input type="tel" name="mobileNo" placeholder="enter the mobile no." class="form-input-text">
    </div>
    <br>

    <div class="form-input">
        <input type="number" name="salary" placeholder="enter the salary" class="form-input-text">
    </div>
    <br>

    <div class="form-input">
        <input type="text" name="position" placeholder="enter the position" class="form-input-text">
    </div>
    <br>

    <br>
    <button type="submit" value="save" class="form-primary">Save Data</button>
</form>
</body>
</html>