<%-- 
    Document   : login
    Created on : 06-dic-2018, 14:41:06
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Login</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  
  <!-- base_url() = http://localhost/ventas_ci/-->

  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="libs/assets/template/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="libs/assets/template/font-awesome/css/font-awesome.min.css">

  <!-- Theme style -->
  <link rel="stylesheet" href="libs/assets/template/dist/css/AdminLTE.min.css">
  <link rel="stylesheet" href="libs/assets/template/bootstrap/css/style.css">
<style type="text/css">
  .img-bg-mine{
    background: url("libs/img/ok2.jpg") no-repeat center center fixed; background-size: cover;
  }
</style>
</head>
<body class="hold-transition login-page img-bg-mine">
    <div class="login-box">
        <div class="login-logo">
            <h2>Clinica Veterinaria</h2>
        </div>
        <!-- /.login-logo -->
        <div class="">
            <p class="login-box-msg">Introduzca sus datos de ingreso</p>
              <div class="alert alert-danger">
                <p>${msg}</p>
              </div>
            <form action="usuarios?action=login" method="POST">
                <div class="inputBox">
                    <input type="text" class="form-control" name="usu" required=""><label>Usuario</label>
                    <span class="glyphicon glyphicon-user form-control-feedback"></span>
                </div>
                <div class="inputBox">
                    <input type="password" class="form-control" name="pass" required=""><label>Contraseña</label>
                    <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
                    </div>
                    <!-- /.col -->
                </div>
            </form>

        </div>
        <!-- /.login-box-body -->
    </div>
    <!-- /.login-box -->

<!-- jQuery 3 -->
<script src="libs/assets/template/jquery/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="libs/assets/template/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>

