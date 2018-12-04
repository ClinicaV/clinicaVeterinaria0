<%-- 
    Document   : mostrarUnidades
    Created on : 18-nov-2018, 11:03:24
    Author     : chris
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Registros Unidades Medicion</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Unidades de Medicion</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                    <br/>
                    <a class="btn btn-primary" href="agregarUnidades.jsp">Nuevo registro</a>
                    <a class="btn btn-warning" href="unidades?action=mostrar&estado=deshabilitado">Registros Deshabilitados</a>
                   <br/><br/>
                </div>
                <div class="col-10">
                    <table id="cat1" class="table table-striped">
                        <thead class="alert-info">
                        <th>ID</th>
                        <th>Unidad de Medicion</th>
                        <th></th>
                        <th></th>
                        </thead>
                        <tbody>
                            <c:forEach items="${registros}" var="ver">
                                <tr>
                                    <td>${ver.idUnidadMedicion}</td>
                                    <td>${ver.unidadMedicion}</td>
                                    <td><a class="btn btn-warning" href="unidades?action=buscarId&idUnidadMedicion=${ver.idUnidadMedicion}"</a>Editar</td>
                                    <td><a class="btn btn-danger" href="unidades?action=deshabilitar&idUnidadMedicion=${ver.idUnidadMedicion}&estado=deshabilitar">Deshabilitar</a></td>
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
