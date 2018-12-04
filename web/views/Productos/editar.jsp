<%-- 
    Document   : editar
    Created on : 11-29-2018, 10:25:01 PM
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
                    <form action="productos?action=actualizar" method="POST">
                        <c:forEach items="${listar}" var="list">

                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>ID:</label>
                                        <input class="form-control col-3" name="id" readonly="" value="${list.idProducto}">
                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Producto</label>
                                        <input class="form-control col-3" name="producto" required="" value="${list.producto}">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <select class="form-control" name="categoria">
                                            <c:forEach items="${registrosCat}" var="ver">
                                                <c:choose>
                                                    <c:when test="${ver.idCatProducto == list.idCategoria}"> 
                                                        <option value="${ver.idCatProducto}" selected>${ver.categoriaProducto}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${ver.idCatProducto}" select>${ver.categoriaProducto}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select><br/>
                                    </div> 
                                </div>
                            </div>
                                    
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <select class="form-control" name="unidad">
                                            <c:forEach items="${registrosUni}" var="ver">
                                                <c:choose>
                                                    <c:when test="${ver.idUnidadMedicion == list.idUnidad}"> 
                                                        <option value="${ver.idUnidadMedicion}" selected>${ver.unidadMedicion}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${ver.idUnidadMedicion}" select>${ver.unidadMedicion}</option>
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
                                        <label>Stock</label>
                                        <input class="form-control" name="stock" required="" value="${list.stock}"><br/>
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
