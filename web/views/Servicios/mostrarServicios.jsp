<%-- 
    Document   : mostrarServicios
    Created on : 22-nov-2018, 23:30:17
    Author     : chris
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Registros Servicio</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>

            <small>Listado Servicios Clinicos</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <br/>
                <a class="btn btn-primary" href="agregarServicios.jsp">Nuevo registro</a>
                <a class="btn btn-warning" href="servicios?action=mostrar&estado=deshabilitado">Registros Deshabilitados</a>
                <br/><br/>
                <table id="cat1" class="table table-striped">
                    <thead class="alert-info">
                    <th>ID</th>
                    <th>Tratamiento</th>
                    <th>Descripcion</th>
                    <th></th>
                    <th></th>
                    </thead>
                    <tbody>
                        <c:forEach items="${registros}" var="ver">
                            <tr>
                                <td>${ver.idCatTratamiento}</td>
                                <td>${ver.catTratamiento}</td>
                                <td>${ver.descripcion}</td>
                                <td><a class="btn btn-warning" href="servicios?action=buscarId&idCatTratamiento=${ver.idCatTratamiento}"</a>Editar</td>
                                <td><a class="btn btn-danger" href="servicios?action=deshabilitar&idCatTratamiento=${ver.idCatTratamiento}&estado=deshabilitar">Deshabilitar</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                ${mensaje}
            </div>
        </div>
    </section>
</div>
<jsp:include page="../../footer.jsp"/>
