<%-- 
    Document   : editar
    Created on : 12-02-2018, 04:15:37 PM
    Author     : Franklin Alexis
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content-wrapper">
    <section class="content-header">
        <h1>

            <small>Editar</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="col-8">
                    <form action="usuarios?action=actualizar" method="POST">
                        <c:forEach items="${listar}" var="list">

                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Codigo</label>
                                        <input class="form-control col-3" name="codEmpleado" readonly="" value="${list.codEmpleado}">
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Nombres</label>
                                        <input class="form-control col-3" name="nombres" readonly="" value="${list.nombres}">
                                    </div>
                                </div>
                            </div>
                                 
                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Apellidos</label>
                                        <input class="form-control col-3" name="apellidos" readonly="" value="${list.apellidos}">
                                    </div>
                                </div>
                            </div>
                                    
                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Usuario</label>
                                        <input class="form-control col-3" name="usuario" value="${list.usuario}">
                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Password</label>
                                        <input class="form-control col-3" name="password" required="" value="${list.password}">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <select class="form-control" name="idNivel">
                                            <c:forEach items="${registrosNiv}" var="ver">
                                                <c:choose>
                                                    <c:when test="${ver.idNivel == list.idNivel}"> 
                                                        <option value="${ver.idNivel}" selected>${ver.nivel}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${ver.idNivel}" select>${ver.nivel}</option>
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

