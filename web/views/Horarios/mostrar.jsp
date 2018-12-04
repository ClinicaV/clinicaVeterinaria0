<%-- 
    Document   : mostrar
    Created on : 11-29-2018, 06:14:00 PM
    Author     : Franklin Alexis
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Listado Horarios</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                    <br/>
                    <a class="btn btn-primary" href="horarios?action=listarServicios&estado=habilitado">Nuevo registro</a>
                    <br>
                    <table id="cat1" class="table table-striped table-bordered">
                        <thead class="alert-info">
                        <th>ID</th>
                        <th>Hora Inicio</th>
                        <th>Hora Fin</th>
                        <th>Servicio</th>
                        <th></th>
                        </thead>
                        <tbody>
                            <c:forEach items="${listar}" var="ver">
                                <tr>
                                    <td>${ver.idHorario}</td>
                                    <td>${ver.horaInicio}</td>
                                    <td>${ver.horaFin}</td>
                                    <td>${ver.catTratamiento}</td>
                                    <td><a class="btn btn-outline-warning" href="horarios?action=buscarId&id=${ver.idHorario}&estado=habilitado"</a>Editar</td>
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

