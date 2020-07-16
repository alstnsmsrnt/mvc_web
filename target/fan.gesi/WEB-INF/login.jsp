<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Login</title>
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
    <link type="text/css" rel="stylesheet" href="css/froala_blocks.css">
    <style>
        .fdb-block {
            border-bottom: 1px solid var(--light);
        }
    </style>
</head>

<body>
    <style>
        <% request.setCharacterEncoding("UTF-8");

        %>#navigator {
            position: sticky;
            top: 0;
            z-index: 1000;
        }

        #navigator .navbar-toggler-icon {
            background-image: url("data:image/svg+xml;charset=utf8,%3Csvg viewBox='0 0 30 30' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath stroke='rgba(0, 0, 0, 0.5)' stroke-width='2' stroke-linecap='round' stroke-miterlimit='10' d='M4 7h22M4 15h22M4 23h22'/%3E%3C/svg%3E");
        }

        @media (max-width: 720px) {
            #navigator {
                border-bottom: 1px solid #ccc;
            }
        }

        #navigator a {
            font-size: 14px;
        }

        #navigator+section {
            padding: 250px 0;
        }
    </style>


    <script>
        var page = window.location.pathname.split('/')
        page = page[page.length - 1]

        var nav = document.querySelector('a[href="' + page + '"]')
        if (nav) {
            nav.classList.add('active')
        }

        function validateform() {
            var name = document.myform.userID.value;
            var password = document.myform.userPassword.value;

            if (name == null || name == "") {
                alert("アカウントを入力してください");
                return false;
            } else if (password.length < 6) {
                alert("パスワードを入力してください");
                return false;
            }
        }
    </script>



    <!-- Forms 7 -->
    <section class="fdb-block" style="background-image: url(imgs/hero/red.svg);">
        <div class="container">
            <input class="btn btn-outline-dark" type="button" value="アカウント作成" onclick="location.href='/join'" style="margin-left:80%; margin-top: -7em;">
            <div class="row justify-content-center">
                <div class="col-12 col-md-8 col-lg-7 col-xl-5 text-center">
                    <div class="fdb-box">
                        <div class="row">
                            <div class="col">
                                <h1>Log In</h1>
                            </div>
                        </div>

                        <form method="post" name="myform" onsubmit="return validateform()" action="loginAction">

                            <div class="row mt-4">
                                <div class="col">
                                    <input type="text" class="form-control" placeholder="アカウント" name="userID">
                                </div>
                            </div>

                            <div class="row mt-4">
                                <div class="col">
                                    <input type="password" class="form-control mb-1" placeholder="パスワード" name="userPassword">
                                </div>
                            </div>
                            <div class="row mt-4">
                                <div class="col">
                                    <button class="btn btn-outline-secondary" type="submit">ログイン</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>

</body>

</html>