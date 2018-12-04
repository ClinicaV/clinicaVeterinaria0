<%-- 
    Document   : agregarInventario
    Created on : 11-29-2018, 11:48:07 PM
    Author     : Franklin Alexis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Agregar Razas Animales</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="col-8">
                    <form action="inventario?action=insertar" method="POST">
                        
                        <label>Producto</label><br/>
                        <select class="custom-select col-3" name="producto">
                            <c:forEach items="${registros}" var="list">
                                <option value="${list.idProducto}">${list.producto}</option>
                            </c:forEach>
                        </select><br/>
                        
                        <label>Cantidad</label>
                        <input class="form-control col-3" name="cantidad" required="">
                        <label>Costo Unitario</label>
                        <input class="form-control col-3" name="costoUnitario" required=""><br/>
                        
                        <button class="btn btn-primary">Agregar</button>
                    </form>
                    ${mensaje}<br/><br/>
                    <form action="inventario?action=mostrar" method="POST">
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

