<%-- 
    Document   : editar
    Created on : 11-29-2018, 06:13:49 PM
    Author     : Franklin Alexis
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Editar Horario</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>

            <small>Editar Horario</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="col-8">
                    <form action="horarios?action=actualizar" method="POST">
                        <c:forEach items="${listar}" var="list">

                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>ID</label>
                                        <input class="form-control col-3" name="idHorario" readonly="" value="${list.idHorario}">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Hora Inicio</label>
                                        <input class="form-control col-3" name="horaInicio" required="" value="${list.horaInicio}">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Hora Fin</label>
                                        <input class="form-control" name="horaFin" required="" value="${list.horaFin}"><br/>
                                    </div>
                                </div>
                            </div>

                            <label>Servicio</label>
                            <div class="input-group">
                                <c:forEach items="${registros}" var="ver">
                                    <c:choose>
                                        <c:when test="${ver.idCatTratamiento == list.idCatTratamiento}"> 
                                            <input type="hidden" name="idCatTratamiento" id="idCatTratamiento" value="${ver.idCatTratamiento}">
                                            <input type="text" class="form-control" disabled="disabled" id="catTratamiento" value="${ver.catTratamiento}">
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#modal-servicio" ><span class="fa fa-search"></span> Buscar</button>
                                </span>
                            </div>
                        </c:forEach>

                        <button class="btn btn-warning col-3">Actualizar</button>
                    </form>
                    <br/> <button class="btn btn-danger col-3" onclick="history.back()" >Cancelar</button>
                </div>
            </div>
        </div>
    </section>
</div>
<div class="modal fade" id="modal-servicio">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Lista de Servicios</h4>
            </div>
            <div class="modal-body">
                <table id="cat1" class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Nombre</th>
                            <th>Opcion</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${registros}" var="reg2">
                            <tr>
                                <td>${reg2.idCatTratamiento}</td>
                                <td>${reg2.catTratamiento}</td>
                                <c:set var="dataservicio" value="${reg2.idCatTratamiento}*${reg2.catTratamiento}">

                                </c:set>
                                <td>
                                    <button type="button" class="btn btn-success btn-servicio" value="<c:out value = "${dataservicio}"/>"><span class="fa fa-check"></span></button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger pull-left" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../../footer.jsp"/>

