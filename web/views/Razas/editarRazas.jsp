    <%-- 
    Document   : editar
    Created on : 11-28-2018, 09:36:46 PM
    Author     : Carlos Solis
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Editar Raza</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>

            <small>Editar Raza</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="col-8">
                    <form action="razas?action=actualizar" method="POST">
                        <c:forEach items="${listar}" var="list">

                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>ID:</label>
                                        <input class="form-control col-3" name="id" readonly="" value="${list.idRaza}">
                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Raza</label>
                                        <input class="form-control col-3" name="raza" required="" value="${list.raza}">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Descripcion</label>
                                        <input class="form-control" name="descripcion" required="" value="${list.descripcion}"><br/>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <select class="form-control" name="categoria">
                                            <c:forEach items="${registros}" var="ver">
                                                <c:choose>
                                                    <c:when test="${ver.idCatAnimal == list.idCatAnimal}"> 
                                                        <option value="${ver.idCatAnimal}" selected>${ver.catAnimal}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${ver.idCatAnimal}" select>${ver.catAnimal}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select><br/>
                                    </div> 
                                </div>
                            </div>
                        </c:forEach>
                        <button class="btn btn-warning ">Actualizar</button>
                    </form>
                    <br/> <button class="btn btn-danger" onclick="history.back()" >Cancelar</button>
                </div>
            </div>
        </div>
    </section>
</div>
<jsp:include page="../../footer.jsp"/>
