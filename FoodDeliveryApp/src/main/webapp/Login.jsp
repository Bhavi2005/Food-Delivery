<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Login</title>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<link rel="icon"href="user.png">
<style>
    /* Set up a flex container to split the page */
    body {
        display: flex;
        background-color:rgba(125,134,123,0.9);
        height: 100vh;
        margin: 0;
    }
    

    /* Left side: Background image */
    .left-side {
        flex: 1;
        background-image: url('1.jpg'); /* Replace with your image URL */
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
    }

    /* Right side: Login form */
    .right-side {
        flex: 1;
        display: flex;
        justify-content: center;
        align-items: center;
        background-color: rgba(255, 255, 255, 0.7); /* Slight white overlay for contrast */
        padding: 20px;
    }

    /* Form container */
    #formContainer {
        background-color: white;
        padding: 40px 40px;
        border: 2px solid black;
        border-radius: 8px;
        box-shadow: 8px 8px 8px red, 10px 7px 5px black;
        text-align: center;
        display: flex;
        flex-direction: column;
        align-items: center;
        gap: 10px;
        width: 100%;
        max-width: 400px;
    }

    h1,  label, input, button {
        margin: 5px 0;
    }

    form {
        background-color: black;
        color: white;
        padding-left: 40px;
        border-radius: 8px;
        box-shadow: 10px 4px 8px rgba(10, 120, 120, 0.2);
        width: 100%;
        max-width: 400px;
    }

    label {
        width: 200px;
        font-size: 22px;
    }
    input {
        width: 250px;
        height: 30px;
    }

    input[type="submit"] {
        color: white;
        background-color: blueviolet;
        padding: 8px 16px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    img {
        border-radius: 50%;
        width: 120px;
        height: 120px;
        border: 4px dotted black;
    }
    img:hover {
        border: 5px dotted red;
    }
    input[type="checkbox"] {
     width:20px;
     height:20px;
    
    }

    input[type="submit"]:hover {
        background-color: Red;
        color: white;
        box-shadow: 5px 7px 5px pink;
    }

    .signup-link {
        margin-top: 15px;
        font-size: 14px;
    }

    h2 {
        color: violet;
        margin-left:0px;
       
    }

    .signup-link a {
        color: blueviolet;
        text-decoration: none;
    }

    .signup-link a:hover {
        color: red;
        text-decoration: underline;
    }
</style>
<script>
    // JavaScript to toggle password visibility
    $(document).ready(function() {
        $('#showPassword').on('change', function() {
            let passwordField = $('input[name="password"]');
            if (this.checked) {
                passwordField.attr('type', 'text');
            } else {
                passwordField.attr('type', 'password');
            }
        });
    });
</script>
</head>
<body>

    <!-- Left side: Image background -->
    <div class="left-side"></div>

    <!-- Right side: Login form -->
    <div class="right-side">
        <div id="formContainer">
        <img src='delivery.jpg'>
            <form action="Login" method="post">
            <br>
                <center><h2 style="background-color:rgba(10,10,200,0.8);width:90%;">LOGIN</h2></center>
                <br>
                <table>
                    <tr>
                        <td><label for="email">Email</label></td>
                        <td><input type="email" placeholder="Enter your email" name="email" required></td>
                    </tr>
                    <tr>
                        <td><label for="password">Password</label></td>
                        <td><input type="password" placeholder="Enter your password" name="password" required></td>
                    </tr>
                    <tr>
                        
                        <td colspan="2"><input type="checkbox" id="showPassword" > Show Password</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="2">
                            <input type="submit" value="Sign in">
                        </td>
                    </tr>
                </table>
            </form>
            <div class="signup-link">
                <p>Don't have an account? <a href="Signup.jsp">Sign up here</a></p>
            </div>
        </div>
    </div>

</body>
</html>
