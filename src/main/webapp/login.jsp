<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style type="text/css">
        body {
            margin: 0;
            padding: 0;
        }
        .div1 {
            text-align: center;
            width: 100%; 
            background-color: aqua;
            padding: 0;
        }
        h1 {
            margin: 0; 
        }
        form {
            align-items: center;
        }
    </style>
</head>
<body>
    <div class="div1">
        <h1>LOGIN</h1>
    </div>
    <form action="loginservlet" method="post">
        <table>
            <tr><td>Username</td><td><input type="text" name="txtname"></td></tr>
            <tr><td>password</td><td><input type="password" name="txtpassword"></td></tr>
            <tr><td><input type="submit" value="submit"></td><td><input type="reset"></td></tr>
        </table>
    </form>
</body>
</html>
    