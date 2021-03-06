<%-- 
    Document   : editarMascotas
    Created on : 12-06-2018, 09:07:07 AM
    Author     : Carlos Solis
--%>
<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Agregar Mascota</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>

            <small>Agregar Mascota</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="col-8">
                    <form action="mascota?action=actualizar" method="POST" class="form-horizontal">
                        <c:forEach items="${mascota}" var="m">

                            <div class="form-group">
                                <div class="col-md-4">
                                    <label>Id Mascota:</label>
                                    <input class="form-control col-3" name="id" readonly="" value="${m.idMascota}">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-4">
                                    <label for="">Nombre Mascota:</label>
                                    <input type="text" class="form-control" id="nombre" name="nombre" required="" value="${m.nombreMascota}">
                                </div>
                                <div class="col-md-3">
                                    <label for="">Raza:</label>
                                    <div class="input-group">
                                        <c:forEach items="${registros2}" var="reg">
                                            <c:choose>
                                                <c:when test="${reg.idRaza == m.idRaza}">
                                                    <input type="hidden" name="idraza" id="idraza" value="${reg.idRaza}">
                                                    <input type="text" class="form-control" disabled="disabled" id="raza" placeholder="Seleccionar raza..." required="" value="${reg.raza}">
                                                </c:when>
                                            </c:choose>
                                        </c:forEach>
                                        <span class="input-group-btn">
                                            <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#modal-raza" ><span class="fa fa-search"></span> Buscar</button>
                                        </span>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-2">
                                    <label for="edad">Edad:</label>
                                    <input type="text" class="form-control" id="edad" name="edad" required="" value="${m.edad}">
                                </div>
                                <div class="col-md-4">
                                    <label for="tatto">Sexo</label>
                                    <input type="text" class="form-control" id="sexo" name="sexo" required="" value="${m.sexo}">
                                </div>
                                <div class="col-md-5">
                                    <div class="input-group">
                                        <label for="alergias">Alergias:</label>
                                        <input type="text" class="form-control" name="alergias" id="alergias" required="" value="${m.alergias}">
                                    </div><!-- /input-group -->
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-4">
                                    <label for="tatto">Tatto:</label>
                                    <input type="text" class="form-control" id="tatto" name="tatoo" required="" value="${m.identificacionTatoo}">
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-md-6">
                                    <label for="">Cliente:</label>
                                    <div class="input-group">
                                        <c:forEach items="${registros}" var="ver">
                                            <c:choose>
                                                <c:when test="${ver.idPersona == m.idPersona}"> 
                                                    <input type="hidden" name="idcliente" id="idcliente" value="${ver.idPersona}">
                                                    <input type="text" class="form-control" disabled="disabled" id="cliente" placeholder="Seleccionar Cliente..." value="${ver.nombres} ${ver.apellidos}">
                                                </c:when>
                                            </c:choose>
                                        </c:forEach>

                                        <span class="input-group-btn">
                                            <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#modal-default" ><span class="fa fa-search"></span> Buscar</button>
                                        </span>
                                    </div>
                                </div>
                            </div>


                        </c:forEach>
                        <div class="form-group">
                            <div class="col-md-12">
                                <button class="btn btn-primary">Agregar</button>
                            </div>
                        </div>
                    </form>
                    ${mensaje}
                    <div class="row">
                        <div class="col-md-12">
                            <a class="btn btn-success" href="mascota?action=mostrar&estado=habilitado">Mostrar Registros</a>
                        </div>
                    </div>
                </div>   
            </div>
        </div>
    </section>
</div>
<div class="modal fade" id="modal-default">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Lista de Clientes</h4>
            </div>
            <div class="modal-body">
                <table id="cat1" class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Opcion</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${registros}" var="reg">
                            <tr>
                                <td>${reg.idPersona}</td>
                                <td>${reg.nombres} ${reg.apellidos}</td>
                                <c:set var="datacliente" value="${reg.idPersona}*${reg.nombres}*${reg.apellidos}">

                                </c:set>
                                <td>
                                    <button type="button" class="btn btn-success btn-check" value="<c:out value = "${datacliente}"/>"><span class="fa fa-check"></span></button>
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

<div class="modal fade" id="modal-raza">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Lista de Razas</h4>
            </div>
            <div class="modal-body">
                <table id="cat2" class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Descripcion</th>
                            <th>Opcion</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${registros2}" var="reg2">
                            <tr>
                                <td>${reg2.idRaza}</td>
                                <td>${reg2.raza}</td>
                                <td>${reg2.descripcion}</td>
                                <c:set var="dataraza" value="${reg2.idRaza}*${reg2.raza}*${reg2.descripcion}">

                                </c:set>
                                <td>
                                    <button type="button" class="btn btn-success btn-check2" value="<c:out value = "${dataraza}"/>"><span class="fa fa-check"></span></button>
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