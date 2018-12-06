<%-- 
    Document   : editar
    Created on : 11-29-2018, 10:25:01 PM
    Author     : Franklin Alexis
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Editar Producto</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>

            <small>Editar Producto</small>
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
                                        <input class="form-control" name="id" readonly="" value="${list.idProducto}">
                                    </div>
                                </div>
                            </div>


                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Producto</label>
                                        <input class="form-control" name="producto" required="" value="${list.producto}">
                                    </div>
                                </div>
                            </div>

                            <label>Categoria Producto</label><br/>
                            <div class="input-group">
                                <c:forEach items="${registrosCat}" var="ver">
                                    <c:choose>
                                        <c:when test="${ver.idCatProducto == list.idCategoria}"> 
                                            <input type="hidden" name="categoria" id="idCatProducto" value="${ver.idCatProducto}">
                                            <input type="text" class="form-control" disabled="disabled" id="categoriaProducto" value="${ver.categoriaProducto}">
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#modal-catproducto" ><span class="fa fa-search"></span> Buscar</button>
                                </span>
                            </div>

                            <label>Unidad de medicion</label><br/>
                            <div class="input-group">
                                <c:forEach items="${registrosUni}" var="ver">
                                    <c:choose>
                                        <c:when test="${ver.idUnidadMedicion == list.idUnidad}"> 
                                            <input type="hidden" name="unidad" id="idUnidadMedicion" value="${ver.idUnidadMedicion}">
                                            <input type="text" class="form-control" disabled="disabled" id="unidadMedicion" value="${ver.unidadMedicion}">
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#modal-unidad" ><span class="fa fa-search"></span> Buscar</button>
                                </span>
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
                        <button class="btn btn-warning ">Actualizar</button>
                    </form>
                    <br/> <button class="btn btn-danger" onclick="history.back()" >Cancelar</button>
                </div>
            </div>
        </div>
    </section>
</div>
<div class="modal fade" id="modal-unidad">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Lista de Unidades de Medicion</h4>
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
                        <c:forEach items="${registrosUni}" var="reg2">
                            <tr>
                                <td>${reg2.idUnidadMedicion}</td>
                                <td>${reg2.unidadMedicion}</td>
                                <c:set var="dataunidad" value="${reg2.idUnidadMedicion}*${reg2.unidadMedicion}">

                                </c:set>
                                <td>
                                    <button type="button" class="btn btn-success btn-unidad" value="<c:out value = "${dataunidad}"/>"><span class="fa fa-check"></span></button>
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

<div class="modal fade" id="modal-catproducto">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Lista de Categorias de Productos</h4>
            </div>
            <div class="modal-body">
                <table id="cat2" class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Nombre</th>
                            <th>Opcion</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${registrosCat}" var="reg2">
                            <tr>
                                <td>${reg2.idCatProducto}</td>
                                <td>${reg2.categoriaProducto}</td>
                                <c:set var="datacatproducto" value="${reg2.idCatProducto}*${reg2.categoriaProducto}">

                                </c:set>
                                <td>
                                    <button type="button" class="btn btn-success btn-catproducto" value="<c:out value = "${datacatproducto}"/>"><span class="fa fa-check"></span></button>
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
