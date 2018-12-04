<%-- 
    Document   : editarCatProductos
    Created on : 23-nov-2018, 22:53:47
    Author     : chris
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Editar Categoria Producto</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Editar Categoria Producto</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="form-group col-md-5">
                    <form action="catproductos?action=actualizar" method="POST">
                        <c:forEach items="${registros}" var="ver">
                            <label>ID:</label>
                            <input class="form-control" name="id" readonly="" value="${ver.idCatProducto}">
                            <label>Categoria de Producto</label>
                            <input class="form-control" name="catpro" required="" value="${ver.categoriaProducto}">
                            <label>Descripcion</label>
                            <input class="form-control" name="descripcion" required="" value="${ver.descripcion}"><br/>
                            <button class="btn btn-warning" name="estado" value="${ver.estadoCatProducto}">Actualizar</button>
                        </c:forEach>
                    </form>
                    <br/> <button class="btn btn-danger" onclick="history.back()" >Cancelar</button>
                </div>
            </div>
        </div>
</section>
</div>
<jsp:include page="../../footer.jsp"/>
