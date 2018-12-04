<%-- 
    Document   : mostrar
    Created on : 11-30-2018, 03:29:10 PM
    Author     : Carlos Solis
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Registros Mascotas</title>

<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Listados de Mascotas</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                    <br/>
                    <a class="btn btn-primary" href="mascota?action=listarPersonaRaza&estado=habilitado">Nuevo registro</a>
                    <br/><br/>
                    <table id="cat1" class="table table-striped">
                        <thead class="alert-info">
                        <th>ID</th>
                        <th>Mascota</th>
                        <th>Edad</th>
                        <th>Sexo</th>
                        <th>Raza</th>
                        <th>Tatto</th>
                        <th>Alergias</th>
                        <th>Dueño</th>
                        <th></th>
                        </thead>
                        <tbody>
                            <c:forEach items="${listar}" var="ver">
                                <tr>
                                    <td>${ver.idMascota}</td>
                                    <td>${ver.nombreMascota}</td>
                                    <td>${ver.edad}</td>
                                    <td>${ver.sexo}</td>
                                    <td>${ver.raza}</td>
                                    <td>${ver.identificacionTatoo}</td>
                                    <td>${ver.alergias}</td>
                                    <td>${ver.nombres}</td>
                                    <td><a class="btn btn-warning" href="#"</a>Editar</td>
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
