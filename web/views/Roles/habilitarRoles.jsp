<%-- 
    Document   : habilitarRoles
    Created on : 23-nov-2018, 16:13:36
    Author     : chris
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Roles deshabilitados</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>

            <small>Roles Deshabilitados</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <br/>
                <a class="btn btn-primary" href="roles?action=mostrar&estado=habilitado">Registros Generales</a>
                <br/><br/>
                <table id="cat1" class="table table-striped">
                    <thead class="alert-info">
                    <th>ID</th>
                    <th>Rol</th>
                    <th></th>
                    <th></th>
                    </thead>
                    <tbody>
                        <c:forEach items="${registros}" var="ver">
                            <tr>
                                <td>${ver.idRol}</td>
                                <td>${ver.rol}</td>
                                <td><a class="btn btn-warning" href="roles?action=buscarId&idRol=${ver.idRol}"</a>Editar</td>
                                <td><a class="btn btn-success" href="roles?action=deshabilitar&idRol=${ver.idRol}&estado=habilitar">Habilitar</a></td>
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
