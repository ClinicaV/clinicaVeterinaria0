<%-- 
    Document   : header
    Created on : 11-22-2018, 10:23:09 PM
    Author     : Carlos Solis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.7 -->
        
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
        
        <link rel="stylesheet" href="libs/assets/template/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="libs/assets/template/jquery-ui/jquery-ui.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="libs/assets/template/font-awesome/css/font-awesome.min.css">
        <!--datatables-->
        <link rel="stylesheet" href="libs/assets/template/datatables.net-bs/css/dataTables.bootstrap.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="libs/assets/template/dist/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
        folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="libs/assets/template/dist/css/skins/_all-skins.min.css">
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <!-- Site wrapper -->
        <div class="wrapper">
            <header class="main-header">
                <!-- Logo -->
                <a href="" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b>S</b>V</span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b>MENU</b></span>
                </a>
                <!-- Header Navbar: style can be found in header.less -->
                <nav class="navbar navbar-static-top">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            <!-- User Account: style can be found in dropdown.less -->
                            <li class="dropdown user user-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <img src="" class="user-image" alt="User Image">
                                    <span class="hidden-xs"></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="user-body">
                                        <div class="row">
                                            <div class="col-xs-12 text-center">
                                                <a href=""> Cerrar Sesión</a>
                                            </div>
                                        </div>
                                        <!-- /.row -->
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </nav>
            </header>

            <!-- =============================================== -->
            <!-- Left side column. contains the sidebar -->
            <aside class="main-sidebar">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">      
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu" data-widget="tree">
                        <li class="header">Menu Navegación</li>
                        <li>
                            <a href="index.jsp">
                                <i class="fa fa-home"></i> <span>Inicio</span>
                            </a>
                        </li>
                        
                        <li class="treeview">
                            <a href="#">
                                <i class="fas fa-gears"></i> <span> Mantenimieto Clinica</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="servicios?action=mostrar&estado=habilitado"><i class="fa fa-circle-o"></i>Servicios</a></li>
                                <li><a href="consultorios?action=mostrar&estado=habilitado"><i class="fa fa-circle-o"></i>Consultorios</a></li>
                                <li><a href="catanimales?action=mostrar&estado=habilitado"><i class="fa fa-circle-o"></i>Categorias Animales</a></li>
                                <li><a href="razas?action=mostrar"><i class="fa fa-circle-o"></i>Razas Animales</a></li>
                                <li><a href="horarios?action=mostrar&estado=habilitado"><i class="fa fa-circle-o"></i>Horarios</a></li>
                                <li><a href="tratamientos?action=mostrar&estado=habilitado"><i class="fa fa-circle-o"></i>Tratamientos</a></li>
                            </ul>
                        </li>
                        
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-paw"></i> <span>Mascotas</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="personas?action=mostrar&estado=habilitado"><i class="fa fa-circle-o"></i>Clientes</a></li>
                                <li><a href="mascota?action=mostrar&estado=habilitado"><i class="fa fa-circle-o"></i>Mascotas</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fas fa-clipboard-list"></i> <span>Inventario</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="catproductos?action=mostrar&estado=habilitado"><i class="fa fa-circle-o"></i>Categorias Productos</a></li>
                                <li><a href="proveedores?action=mostrar&estado=habilitado"><i class="fa fa-circle-o"></i>Proveedores</a></li>
                                <li><a href="productos?action=mostrar&estado=habilitado"><i class="fa fa-circle-o"></i>Productos</a></li>
                                <li><a href="comprobantes?action=mostrar&estado=habilitado"><i class="fa fa-circle-o"></i>Comprobantes</a></li>
                                <li><a href="unidades?action=mostrar&estado=habilitado"><i class="fa fa-circle-o"></i>Unidades de Medicion</a></li>
                                <li><a href="inventario?action=mostrar"><i class="fa fa-circle-o"></i>Inventario</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-male"></i> <span>Usuario</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="niveles?action=mostrar&estado=habilitado"><i class="fa fa-circle-o"></i>Niveles</a></li>
                                <li><a href="roles?action=mostrar&estado=habilitado"><i class="fa fa-circle-o"></i>Roles</a></li>
                                <li><a href="empleados?action=mostrar&estado=habilitado"><i class="fa fa-circle-o"></i>Empleados</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-user-circle-o"></i> <span>Administrador</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="#"><i class="fa fa-circle-o"></i> Tipo Documentos</a></li>
                                <li><a href="usuarios?action=mostrar&estado=habilitado"><i class="fa fa-circle-o"></i> Usuarios</a></li>
                            </ul>
                        </li>
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>
