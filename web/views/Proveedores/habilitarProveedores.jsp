<%-- 
    Document   : habilitarProveedores
    Created on : 22-nov-2018, 21:08:56
    Author     : chris
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Proveedores Deshabilitados</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>

            <small>Proveedores Deshabilitados</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <br/>
                <a class="btn btn-primary" href="proveedores?action=mostrar&estado=habilitado">Registros Generales</a>
                <br/><br/>
                <table id="cat1" class="table table-striped">
                    <thead class="alert-info">
                    <th>ID</th>
                    <th>Proveedor</th>
                    <th>Telefono</th>
                    <th>Email</th>
                    <th>Direccion</th>
                    <th>Persona de Contacto</th> 
                    <th></th> 
                    <th></th> 
                    </thead>
                    <tbody>
                        <c:forEach items="${registros}" var="ver">
                            <tr>
                                <td>${ver.idProveedor}</td>
                                <td>${ver.proveedor}</td>
                                <td>${ver.telefono}</td>
                                <td>${ver.email}</td>
                                <td>${ver.direccion}</td>
                                <td>${ver.personaContacto}</td>
                                <td><a class="btn btn-warning" href="proveedores?action=buscarId&idProveedor=${ver.idProveedor}"</a>Editar</td>
                                <td><a class="btn btn-success" href="proveedores?action=deshabilitar&idProveedor=${ver.idProveedor}&estado=habilitar">Habilitar</a> </td>
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
