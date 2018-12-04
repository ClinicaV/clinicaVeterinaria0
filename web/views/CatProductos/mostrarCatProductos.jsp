<%-- 
    Document   : mostrarCatProductos
    Created on : 23-nov-2018, 22:53:26
    Author     : chris
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Registros Categorias Productos</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Listado Categorias Productos</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                    <br/>
                    <a class="btn btn-primary  " href="agregarCatProductos.jsp">Nuevo registro</a>
                    <a class="btn btn-warning" href="catproductos?action=mostrar&estado=deshabilitado">Registros Deshabilitados</a>
                    <br/><br/>
                    <table id="cat1" class="table table-striped">
                        <thead class="alert-info">
                        <th>ID</th>
                        <th>Categoria Producto</th>
                        <th>Descripcion</th>
                        <th></th>
                        <th></th>
                        </thead>
                        <tbody>
                            <c:forEach items="${registros}" var="ver">
                                <tr>
                                    <td>${ver.idCatProducto}</td>
                                    <td>${ver.categoriaProducto}</td>
                                    <td>${ver.descripcion}</td>
                                    <td><a class="btn btn-warning" href="catproductos?action=buscarId&idCatProducto=${ver.idCatProducto}"</a>Editar</td>
                                    <td><a class="btn btn-danger" href="catproductos?action=deshabilitar&idCatProducto=${ver.idCatProducto}&estado=deshabilitar">Deshabilitar</a> </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    ${mensaje}
                </div>
            </div>
    </section>
</div>
                <jsp:include page="../../footer.jsp"/>

