<%-- 
    Document   : mostrar
    Created on : 11-29-2018, 11:49:30 PM
    Author     : Franklin Alexis
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Inventario</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                    <br/>
                    <a class="btn btn-primary" href="inventario?action=listarProductos&estado=habilitado">Nuevo registro</a>
                    <br>
                    <table id="cat1" class="table table-striped table-bordered">
                        <thead class="alert-info">
                        <th>ID</th>
                        <th>Producto</th>
                        <th>Existencias</th>
                        <th>Costo Unitario</th>
                        <th>Costo Total</th>
                        <th></th>
                        </thead>
                        <tbody>
                            <c:forEach items="${listar}" var="ver">
                                <tr>
                                    <td>${ver.idProducto}</td>
                                    <td>${ver.producto}</td>
                                    <td>${ver.cantidad}</td>
                                    <td>${ver.costoUnitario}</td>
                                    <td>${ver.costoTotal}</td>
                                    <td><a class="btn btn-outline-warning" href="inventario?action=buscarId&id=${ver.idProducto}&estado=habilitado"</a>Editar</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    ${mensaje}
            </div>
        </div>
<!-- /.box-body -->
<!-- /.box -->
</section>
<!-- /.content -->
</div>
<jsp:include page="../../footer.jsp"/>

