<%-- 
    Document   : editar
    Created on : 12-02-2018, 01:06:48 AM
    Author     : Franklin Alexis
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Editar Tratamiento</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            <small>Editar Tratamiento</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="col-8">
                    <form action="tratamientos?action=actualizar" method="POST">
                        <c:forEach items="${listar}" var="list">

                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>ID:</label>
                                        <input class="form-control " name="id" readonly="" value="${list.idTratamiento}">
                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Tratamiento</label>
                                        <input class="form-control " name="tratamiento" required="" value="${list.tratamiento}">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <select class="form-control" name="idCatTratamiento">
                                            <c:forEach items="${registros}" var="ver">
                                                <c:choose>
                                                    <c:when test="${ver.idCatTratamiento == list.idCatTratamiento}"> 
                                                        <option value="${ver.idCatTratamiento}" selected>${ver.catTratamiento}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${ver.idCatTratamiento}" select>${ver.catTratamiento}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select><br/>
                                    </div> 
                                </div>
                            </div>
                                    
                             <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Precio</label>
                                        <input class="form-control" name="precio" required="" value="${list.precio}"><br/>
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

