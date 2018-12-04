<%-- 
    Document   : habilitarPersonas
    Created on : 23-nov-2018, 21:18:03
    Author     : chris
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Clientes Deshabilitados</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>

            <small>Clientes Deshabilitados</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                    <br/>
                    <a class="btn btn-primary" href="personas?action=mostrar&estado=habilitado">Registros Generales</a>
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
                                    <td><a class="btn btn-danger" href="personas?action=deshabilitar&idPersona=${ver.idPersona}&estado=habilitar">Habilitar</a></td>
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
