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
                        <select class="custom-select col-3" name="categoria">
                            <c:forEach items="${registrosCat}" var="list">
                                <option value="${list.idCatProducto}">${list.categoriaProducto}</option>
                            </c:forEach>
                        </select><br/><br/>
                        
                        <label>Unidad de medicion</label><br/>
                        <select class="custom-select col-3" name="unidad">
                            <c:forEach items="${registrosUni}" var="list">
                                <option value="${list.idUnidadMedicion}">${list.unidadMedicion}</option>
                            </c:forEach>
                        </select><br/><br/>
                        
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
<!-- /.box-body -->
<!-- /.box -->
</section>
<!-- /.content -->
</div>
<jsp:include page="footer.jsp"/>
