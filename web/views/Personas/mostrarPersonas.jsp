<%-- 
    Document   : mostrarPersonas
    Created on : 23-nov-2018, 21:11:45
    Author     : chris
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Registros Clientes</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Listado Clientes</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                    <br/>
                    <a class="btn btn-primary" href="agregarPersonas.jsp">Nuevo registro</a>
                    <a class="btn btn-warning" href="personas?action=mostrar&estado=deshabilitado">Registros Deshabilitados</a>
                    <br/><br/>
                    <table id="cat1" class="table table-striped">
                        <thead class="alert-info">
                        <th>ID</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>Telefono</th>
                        <th>Genero</th> 
                        <th></th>
                        <th></th>
                        </thead>
                        <tbody>
                            <c:forEach items="${registros}" var="ver">
                                <tr>
                                    <td>${ver.idPersona}</td>
                                    <td>${ver.nombres}</td>
                                    <td>${ver.apellidos}</td>
                                    <td>${ver.telefono}</td>
                                    <td>${ver.genero}</td>
                                    <td><a class="btn btn-warning" href="personas?action=buscarId&idPersona=${ver.idPersona}"</a>Editar</td>
                                    <td><a class="btn btn-danger" href="personas?action=deshabilitar&idPersona=${ver.idPersona}&estado=deshabilitar">Deshabilitar</a></td>
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
