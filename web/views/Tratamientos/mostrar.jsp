<%-- 
    Document   : mostrar
    Created on : 12-02-2018, 01:06:59 AM
    Author     : Franklin Alexis
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Listado Razas Animales</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                    <br/>
                    <a class="btn btn-primary" href="tratamientos?action=listarServicios&estado=habilitado">Nuevo registro</a>
                    <br>
                    <table id="cat1" class="table table-striped table-bordered">
                        <thead class="alert-info">
                        <th>ID</th>
                        <th>Tratamiento</th>
                        <th>Servicio</th>
                        <th>Precio</th>
                        <th></th>
                        </thead>
                        <tbody>
                            <c:forEach items="${listar}" var="ver">
                                <tr>
                                    <td>${ver.idTratamiento}</td>
                                    <td>${ver.tratamiento}</td>
                                    <td>${ver.catTratamiento}</td>
                                    <td>${ver.precio}</td>
                                    <td><a class="btn btn-outline-warning" href="tratamientos?action=buscarId&id=${ver.idTratamiento}&estado=habilitado"</a>Editar</td>
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

