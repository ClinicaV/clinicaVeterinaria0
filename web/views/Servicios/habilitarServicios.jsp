<%-- 
    Document   : habilitarServicios
    Created on : 22-nov-2018, 23:30:30
    Author     : chris
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Servicios Deshabilitados</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>

            <small>Servicios Deshabilitados</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <br/>
                <a class="btn btn-primary" href="servicios?action=mostrar&estado=habilitado">Registros Generales</a>
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
                                <td><a class="btn btn-success" href="servicios?action=deshabilitar&idCatTratamiento=${ver.idCatTratamiento}&estado=habilitar">Habilitar</a></td>
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