<%-- 
    Document   : agregarProveedores
    Created on : 20-nov-2018, 13:40:24
    Author     : chris
--%>

<jsp:include page="header.jsp"/>
<title>Agregar Proveedor</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>

            <small>Agregar Proveedor</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="form-group col-md-5">
                    <form action="proveedores?action=insertar" method="POST">
                        <label>Proveedor</label>
                        <input class="form-control" name="proveedor" required="">
                        <label>Telefono</label>
                        <input class="form-control" name="telefono" required="">
                        <label>Email</label>
                        <input class="form-control" name="email" required="">
                        <label>Direccion</label>
                        <input class="form-control" name="direccion" required="">
                        <label>Contacto</label>
                        <input class="form-control" name="contacto" required=""><br/>
                        <select class="form-control" name="estado">
                            <option value="1">Habilitado</option>
                            <option value="0">Deshabilitado</option>
                        </select><br/>
                        <button class="btn btn-primary ">Guardar</button>
                    </form>
                    ${mensaje}<br/><br/>
                    <a class="btn btn-success" href="proveedores?action=mostrar&estado=habilitado">Mostrar Registros</a>
                </div>
            </div>
        </div>
    </section>
</div>
<jsp:include page="footer.jsp"/>