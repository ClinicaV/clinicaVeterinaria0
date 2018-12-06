<%-- 
    Document   : mostrar
    Created on : 11-29-2018, 03:43:19 PM
    Author     : Franklin Alexis
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Registros Empleados</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Listado Empleados</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                    <br/>
                    <a class="btn btn-primary" href="empleados?action=listarRoles&estado=habilitado">Nuevo registro</a>
                    <br/> <br/>
                    <table id="cat1" class="table table-striped table-bordered">
                        <thead class="alert-info">
                        <th>ID</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>Telefono</th>
                        <th>Genero</th>
                        <th>NIT</th>
                        <th>DUI</th>
                        <th>Rol</th>
                        <th></th>
                        </thead>
                        <tbody>
                            <c:forEach items="${listar}" var="ver">
                                <tr>
                                    <td>${ver.codEmpleado}</td>
                                    <td>${ver.nombres}</td>
                                    <td>${ver.apellidos}</td>
                                    <td>${ver.telefono}</td>
                                    <td>${ver.genero}</td>
                                    <td>${ver.nit}</td>
                                    <td>${ver.dui}</td>
                                    <td>${ver.rol}</td>
                                    <td><a class="btn btn-warning" href="empleados?action=buscarId&id=${ver.codEmpleado}&estado=habilitado"</a>Editar</td>
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
