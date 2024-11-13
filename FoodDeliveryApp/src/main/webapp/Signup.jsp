<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup Page</title>
<link rel="icon" href="signup.png">

<style>
    body {
        font-family: Arial, sans-serif;
        background-image:url("image.jpg");
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100vh;
        margin: 0;
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center;
    }
    form {
        background-color:rgba(255, 255, 255, 0.8);
        padding: 20px 40px;
        border-radius: 8px;
        box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
        width: 100%;
        max-width: 400px;
    }
    h1 {
        text-align: center;
        color: #ffffff;
        background-color: black;
        font-size: 24px;
        margin-bottom: 20px;
        padding: 10px;
        border-radius: 5px;
    }
    table {
        width: 100%;
        border-spacing: 0;
        border-collapse: collapse;
    }
    label {
        font-weight: bold;
        color: #333333;
    }
    td {
        padding: 10px 0;
    }
    input[type="text"], input[type="tel"], input[type="password"], textarea {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        font-size: 14px;
    }
    input[type="text"]:focus, input[type="tel"]:focus, input[type="password"]:focus, textarea:focus {
        border-color: #007bff;
        outline: none;
    }
    textarea {
        resize: vertical;
    }
    .show-password {
        font-size: 14px;
        color: #333;
        display: flex;
        align-items: center;
        margin-top: 5px;
    }
    .show-password input {
        margin-right: 5px;
    }
    input[type="submit"]{
    border-radius: 4px;
    }
    input[type="submit"]:hover {
        background-color: Red;
        color: white;
        box-shadow: 10px 7px 5px black;
    }
</style>
</head>
<body>
    <form action="Signup">
        <h1>Signup</h1>
        <table>
            <tr>
                <td><label for="username">Name</label></td>
                <td><input type="text" name="username" placeholder="Enter your Name" required></td>
            </tr>
            <tr>
                <td><label for="email">Email</label></td>
                <td><input type="text" name="email" placeholder="Enter your Email" required></td>
            </tr>
            <tr>
                <td><label for="password">Password</label></td>
                <td>
                    <input type="password" id="password" name="password" placeholder="Set Password" required pattern="^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$">
                    <!-- Show/Hide Password Checkbox -->
                    <div class="show-password">
                        <input type="checkbox" id="showPassword" onclick="togglePassword()">
                        <label for="showPassword">Show Password</label>
                    </div>
                </td>
            </tr>
            <tr>
                <td><label for="mobile">Mobile</label></td>
                <td><input type="tel" name="mobile" placeholder="Enter your Mobile Number" pattern="[6-9][0-9]{9}"></td>
            </tr>
            <tr>
                <td><label for="role">Role</label></td>
                <td><input type="text" name="role" placeholder="Enter your Role" required></td>
            </tr>
            <tr>
                <td><label for="address">Address</label></td>
                <td><input type="text" name="address" placeholder="Enter correct Address" required>
            </tr>
        </table>
        <center><input style="background-color:violet;color:black;width:80px;height:40px;" type="submit" value="Submit"></center>
    </form>

    <script>
        function togglePassword() {
            const passwordField = document.getElementById("password");
            const showPasswordCheckbox = document.getElementById("showPassword");

            if (showPasswordCheckbox.checked) {
                passwordField.type = "text";
            } else {
                passwordField.type = "password";
            }
        }
    </script>
</body>
</html>
