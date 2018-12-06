<%-- 
    Document   : agregarHorarios
    Created on : 11-29-2018, 06:13:16 PM
    Author     : Franklin Alexis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<title>Agregar Horario</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Agregar Horarios</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="form-group col-md-5">
                    <form action="horarios?action=insertar" method="POST">
                        <label>Hora Inicio</label>
                        <input class="form-control" name="horaInicio" required="">
                        <label>Hora Fin</label>
                        <input class="form-control" name="horaFin" required=""><br/>
                        <label>Categoria Animal</label>
                        <div class="input-group">
                                    <input type="hidden" name="idCatTratamiento" id="idCatTratamiento">
                                    <input type="text" class="form-control" disabled="disabled" id="catTratamiento">
                                    <span class="input-group-btn">
                                        <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#modal-servicio" ><span class="fa fa-search"></span> Buscar</button>
                                    </span>
                        </div><!-- /input-group -->
                        <button class="btn btn-primary">Agregar</button>
                    </form>
                    ${mensaje}<br/><br/>
                    <a class="btn btn-success" href="horarios?action=mostrar&estado=habilitado">Mostrar Registros</a>
                   
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
<jsp:include page="footer.jsp"/>

