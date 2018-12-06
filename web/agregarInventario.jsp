<%-- 
    Document   : agregarInventario
    Created on : 11-29-2018, 11:48:07 PM
    Author     : Franklin Alexis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<title>Agregar Inventario</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>

            <small>Agregar inventario</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="form-group col-md-5">
                    <form action="inventario?action=insertar" method="POST">

                        <label>Producto</label><br/>
                        <div class="input-group">
                            <input type="hidden" name="idProducto" id="idProducto">
                            <input type="text" class="form-control" disabled="disabled" id="producto">
                            <span class="input-group-btn">
                                <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#modal-producto" ><span class="fa fa-search"></span> Buscar</button>
                            </span>
                        </div>

                        <label>Cantidad</label>
                        <input class="form-control " name="cantidad" required="">
                        <label>Costo Unitario</label>
                        <input class="form-control " name="costoUnitario" required=""><br/>

                        <button class="btn btn-primary">Agregar</button>
                    </form>
                    ${mensaje}<br/><br/>
                    <a class="btn btn-success" href="inventario?action=mostrar&estado=habilitado">Mostrar Registros</a>
                    
                </div>               
            </div>
        </div>
        <!-- /.box-body -->
        <!-- /.box -->
    </section>
    <!-- /.content -->
</div>

<div class="modal fade" id="modal-producto">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Lista de Productos</h4>
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
                                <td>${reg2.idProducto}</td>
                                <td>${reg2.producto}</td>
                                <c:set var="dataproducto" value="${reg2.idProducto}*${reg2.producto}">

                                </c:set>
                                <td>
                                    <button type="button" class="btn btn-success btn-producto" value="<c:out value = "${dataproducto}"/>"><span class="fa fa-check"></span></button>
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

