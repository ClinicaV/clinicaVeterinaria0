<%-- 
    Document   : mostrar
    Created on : 11-29-2018, 10:25:17 PM
    Author     : Franklin Alexis
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Registros Productos</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Listado Productos</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                    <br/>
                    <a class="btn btn-primary" href="productos?action=listarFK&estado=habilitado">Nuevo registro</a>
                    <br/> <br/>
                    <table id="cat1" class="table table-striped table-bordered">
                        <thead class="alert-info">
                        <th>ID</th>
                        <th>Producto</th>
                        <th>Categoria</th>
                        <th>Unidad de medicion</th>
                        <th>Stock</th>
                        <th></th>
                        </thead>
                        <tbody>
                            <c:forEach items="${listar}" var="ver">
                                <tr>
                                    <td>${ver.idProducto}</td>
                                    <td>${ver.producto}</td>
                                    <td>${ver.categoriaProducto}</td>
                                    <td>${ver.unidadMedicion}</td>
                                    <td>${ver.stock}</td>
                                    <td><a class="btn btn-warning" href="productos?action=buscarId&id=${ver.idProducto}&estado=habilitado"</a>Editar</td>
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
