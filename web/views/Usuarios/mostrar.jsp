<%-- 
    Document   : mostrar
    Created on : 12-02-2018, 04:15:51 PM
    Author     : Franklin Alexis
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Listado Usuarios</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                    <br/>
                    <a class="btn btn-primary" href="usuarios?action=listarFK&estado=habilitado">Nuevo registro</a>
                    <br>
                    <table id="cat1" class="table table-striped table-bordered">
                        <thead class="alert-info">
                        <th>ID</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>Usuario</th>
                        <th>Password</th>
                        <th>Nivel</th>
                        <th></th>
                        </thead>
                        <tbody>
                            <c:forEach items="${listar}" var="ver">
                                <tr>
                                    <td>${ver.idUsuario}</td>
                                    <td>${ver.nombres}</td>
                                    <td>${ver.apellidos}</td>
                                    <td>${ver.usuario}</td>
                                    <td>${ver.password}</td>
                                    <td>${ver.nivel}</td>
                                    <td><a class="btn btn-outline-warning" href="usuarios?action=buscarId&idUsuario=${ver.idUsuario}&estado=habilitado"</a>Editar</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    ${mensaje}
            </div>
        </div>
<!-- /.box-body -->
<!-- /.box -->
</section>
<!-- /.content -->
</div>
<jsp:include page="../../footer.jsp"/>

