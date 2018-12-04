<%-- 
    Document   : mostrarConsultorios
    Created on : 23-nov-2018, 17:43:20
    Author     : chris
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Registros Consultorios</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Listado Consultorios</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                    <br/>
                    <a class="btn btn-primary" href="agregarConsultorios.jsp">Nuevo registro</a>
                    <a class="btn btn-warning" href="consultorios?action=mostrar&estado=deshabilitado">Registros Deshabilitados</a>
                    <br/><br/>
                    <table id="cat1" class="table table-striped">
                        <thead class="alert-info">
                        <th>ID</th>
                        <th>Consultorio</th>
                        <th></th>
                        <th></th>
                        </thead>
                        <tbody>
                            <c:forEach items="${registros}" var="ver">
                                <tr>
                                    <td>${ver.idConsultorio}</td>
                                    <td>${ver.consultorio}</td>
                                    <td><a class="btn btn-warning" href="consultorios?action=buscarId&idConsultorio=${ver.idConsultorio}"</a>Editar</td>
                                    <td><a class="btn btn-danger" href="consultorios?action=deshabilitar&idConsultorio=${ver.idConsultorio}&estado=deshabilitar">Deshabilitar</a></td>
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
