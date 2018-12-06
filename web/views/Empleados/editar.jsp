<%-- 
    Document   : editar
    Created on : 11-29-2018, 03:42:07 PM
    Author     : Franklin Alexis
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Editar Empleado</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>

            <small>Editar Empleado</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="col-8">
                    <form action="empleados?action=actualizar" method="POST">
                        <c:forEach items="${listar}" var="list">

                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>ID:</label>
                                        <input class="form-control col-3" name="id" readonly="" value="${list.codEmpleado}">
                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Nombres</label>
                                        <input class="form-control col-3" name="nombres" required="" value="${list.nombres}">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Apellidos</label>
                                        <input class="form-control" name="apellidos" required="" value="${list.apellidos}"><br/>
                                    </div>
                                </div>
                            </div>
                                    
                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Telefono</label>
                                        <input class="form-control" name="telefono" required="" value="${list.telefono}"><br/>
                                    </div>
                                </div>
                            </div>
                                    
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label>Genero</label>
                                        <select class="form-control" name="genero">
                                            <option value="Masculino" selected>Masculino</option>
                                            <option value="Femenino" selected>Femenino</option>
                                        </select><br/>
                                    </div> 
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>NIT</label>
                                        <input class="form-control" name="nit" required="" value="${list.nit}"><br/>
                                    </div>
                                </div>
                            </div>
                                    
                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>DUI</label>
                                        <input class="form-control" name="dui" required="" value="${list.dui}"><br/>
                                    </div>
                                </div>
                            </div>
                                    
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label>Rol</label>
                                        <select class="form-control" name="idRol">
                                            <c:forEach items="${registros}" var="ver">
                                                <c:choose>
                                                    <c:when test="${ver.idRol == list.idRol}"> 
                                                        <option value="${ver.idRol}" selected>${ver.rol}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${ver.idRol}" select>${ver.rol}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select><br/>
                                    </div> 
                                </div>
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
<jsp:include page="../../footer.jsp"/>
