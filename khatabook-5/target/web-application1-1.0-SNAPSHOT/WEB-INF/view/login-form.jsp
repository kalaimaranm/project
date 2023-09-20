<%-- 
    Document   : login-form
    Created on : 14-Jun-2023, 2:10:09 am
    Author     : bas200193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <style>
            {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                -webkit-font-smoothing: antialiased;
            }

            body {
                background: #C5C4BB;
                /*background: #e35869;*/
                font-family: 'Rubik', sans-serif;
            }

            .login-form {
                background: #fff;
                width: 500px;
                margin: 65px auto;
                display: -webkit-box;
                display: flex;
                -webkit-box-orient: vertical;
                -webkit-box-direction: normal;
                flex-direction: column;
                border-radius: 4px;
                box-shadow: 0 2px 25px rgba(0, 0, 0, 0.2);
            }
            .login-form h1 {
                padding: 35px 35px 0 35px;
                font-weight: 300;
            }
            .login-form .content {
                padding: 35px;
                text-align: center;
            }
            .login-form .input-field {
                padding: 12px 5px;
            }
            .login-form .input-field input {
                font-size: 16px;
                display: block;
                font-family: 'Rubik', sans-serif;
                width: 100%;
                padding: 10px 1px;
                border: 0;
                border-bottom: 1px solid #747474;
                outline: none;
                -webkit-transition: all .2s;
                transition: all .2s;
            }
            .login-form .input-field input::-webkit-input-placeholder {
                text-transform: uppercase;
            }
        </style>
    </head>
    <body>
        <h1 align = "center">khatabook</h1>

    <body>

        <div class="login-form">
            <form action = "home-page" method = "post" onsubmit="mySubmit()" name = "login" id = "login">
                <h1>Login</h1>
                <div class="content">
                    <div class="input-field">
                        <input type="text" placeholder="username" name = "userid" required />
                    </div>
                    <div class="input-field">
                        <input id = "password" type="password" placeholder="Password" name ="password" autocomplete="new-password" required >
                    </div>
                    <a href="#" class="link">Forgot Your Password?</a>
                </div>
                <div class="action" align = "center">
                    <button><a href = "signup">Register</a></button>
                    <input type = "submit" value = "Sign in" />
                </div>
            </form>
        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>
        <script>
                function mySubmit() {
                    console.log(`inside mysubmit`);

                    console.log(document.login.password.value = CryptoJS.MD5(document.login.password.value));

                }

        </script>


    </body>
</html>