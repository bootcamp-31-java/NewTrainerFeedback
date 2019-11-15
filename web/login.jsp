<%-- 
    Document   : login
    Created on : Nov 12, 2019, 2:06:10 PM
    Author     : G551VW
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Login</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

        <!--Sweet Alert-->
        <script src="js/sweetalert2@8.js" type="text/javascript"></script>
        <script src="sweetalert2.all.min.js"></script>

        <!-- Optional: include a polyfill for ES6 Promises for IE11 and Android browser -->
        <script src="js/promise-polyfill.js" type="text/javascript"></script>

    </head>

    <body class="bg-gradient-secondary">

        <div class="container">

            <!-- Outer Row -->
            <div class="row justify-content-center">

                <div class="col-xl-10 col-lg-12 col-md-9">

                    <div class="card o-hidden border-0 shadow-lg my-5">
                        <div class="card-body p-0">
                            <!-- Nested Row within Card Body -->
                            <div class="row">
                                <div class="col-lg-6 d-none d-lg-block">
                                    <img src="https://icon-library.net/images/customer-survey-icon/customer-survey-icon-19.jpg  " width="500" height="500" alt=""/>
                                </div>

                                <div class="col-lg-6">
                                    <div class="p-5">
                                        <div class="text-center">
                                            <h1 class="h4 text-gray-900 mb-4">WELCOME ! <br>╰( ･ ᗜ ･ )╯</h1>
                                        </div>
                                        <form action="/TrainerFeedbacktest/accountServlet" method="POST" class="user">
                                            <div class="form-group">
                                                <input type="email" name="username" id="txtUsername" class="form-control form-control-user" placeholder="Email" autofocus="">
                                            </div>
                                            <div class="form-group">
                                                <input type="password" name="password" id="txtPassword" class="form-control form-control-user" placeholder="Password">
                                            </div>

                                            <input id="btnLogin" type="submit" class="btn btn-primary btn-user btn-block" value="Login">
                                            <!--                                            <hr>
                                                                                        <a href="/Setok/barangServlet" target="_Blank">Barang</a><br>
                                                                                        <a href="/Setok/lapinServlet" target="_Blank">Laporan Masuk</a><br>
                                                                                        <a href="/Setok/lapoutServlet" target="_Blank">Laporan Keluar</a>-->

                                        </form>
                                        <!--<hr>-->

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>


    </body>
    <script>
        $(document).ready(function () {
            $('#btnLogin').click(function (e) {
                var Username = $('#txtUsername').val();
                var Password = $('#txtPassword').val();

                if (Username == "" || Password == "") {
                    Swal.fire({
                        title: 'Failed',
                        type: 'error',
                        text: 'Incorrect Username or Password',
                        showConfirmButton: false,
                        timer: 2000
                    })
                    return false;
                }
            });
        });
    </script>
    <script>
        (function (global) {

            if (typeof (global) === "undefined") {
                throw new Error("window is undefined");
            }

            var _hash = "!";
            var noBackPlease = function () {
                global.location.href += "#";

                // making sure we have the fruit available for juice (^__^)
                global.setTimeout(function () {
                    global.location.href += "!";
                }, 50);
            };

            global.onhashchange = function () {
                if (global.location.hash !== _hash) {
                    global.location.hash = _hash;
                }
            };

            global.onload = function () {
                noBackPlease();

                // disables backspace on page except on input fields and textarea..
                document.body.onkeydown = function (e) {
                    var elm = e.target.nodeName.toLowerCase();
                    if (e.which === 8 && (elm !== 'input' && elm !== 'textarea')) {
                        e.preventDefault();
                    }
                    // stopping event bubbling up the DOM tree..
                    e.stopPropagation();
                };
            }

        })(window);
    </script>

</html>
