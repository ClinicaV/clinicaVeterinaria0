<%-- 
    Document   : agregarProductos
    Created on : 11-29-2018, 10:25:41 PM
    Author     : Franklin Alexis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<div class="content-wrapper">
    <section class="content-header">
        <h1>

            <small>Agregar Productos</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="col-8">
                    <form action="productos?action=insertar" method="POST">

                        <label>Producto</label>
                        <input class="form-control col-3" name="producto" required=""><br/>

                        <label>Categoria Producto</label><br/>
                        <div class="input-group">
                            <input type="hidden" name="idCatProducto" id="idCatProducto">
                            <input type="text" class="form-control" disabled="disabled" id="categoriaProducto">
                            <span class="input-group-btn">
                                <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#modal-catproducto" ><span class="fa fa-search"></span> Buscar</button>
                            </span>
                        </div>

                        <label>Unidad de medicion</label><br/>
                        <div class="input-group">
                            <input type="hidden" name="idUnidadMedicion" id="idUnidadMedicion">
                            <input type="text" class="form-control" disabled="disabled" id="unidadMedicion">
                            <span class="input-group-btn">
                                <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#modal-unidad" ><span class="fa fa-search"></span> Buscar</button>
                            </span>
                        </div>

                        <label>Stock</label>
                        <input class="form-control col-3" name="stock" required=""><br/>

                        <button class="btn btn-primary">Agregar</button>
                    </form>
                    ${mensaje}<br/><br/>
                    <form action="productos?action=mostrar" method="POST">
                        <button class="btn btn-success col-6" name="estado" value="habilitado">Mostrar Registros</button>
                    </form>
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
<jsp:include page="footer.jsp"/>
