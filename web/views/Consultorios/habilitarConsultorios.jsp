<%-- 
    Document   : habilitarConsultorios
    Created on : 23-nov-2018, 17:46:41
    Author     : chris
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Consultorios Deshabilitados</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>

            <small>Consultorios Deshabilitados</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <br/>
                <a class="btn btn-primary" href="consultorios?action=mostrar&estado=habilitado">Registros Generales</a>
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
                                <td><a class="btn btn-success" href="consultorios?action=deshabilitar&idConsultorio=${ver.idConsultorio}&estado=habilitar">Habilitar</a></td>
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
