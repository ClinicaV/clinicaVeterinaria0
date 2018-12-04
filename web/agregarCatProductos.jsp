<%-- 
    Document   : agregarCatProductos
    Created on : 23-nov-2018, 22:53:05
    Author     : chris
--%>

<jsp:include page="header.jsp"/>
<title>Agregar Categoria Producto</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>

            <small>Agregar Categoria Producto</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="form-group col-md-5">
                    <form action="catproductos?action=insertar" method="POST">
                        <label>Categoria de Producto</label>
                        <input class="form-control" name="catpro" required="">
                        <label>Descripcion</label>
                        <input class="form-control" name="descripcion" required=""><br/>
                        <select class="form-control" name="estado">
                            <option value="1">Habilitado</option>
                            <option value="0">Deshabilitado</option>
                        </select><br/>
                        <button class="btn btn-primary">Agregar</button>
                    </form>
                    ${mensaje}<br/><br/>
                    <a class="btn btn-success" href="catproductos?action=mostrar&estado=habilitado">Mostrar Registros</a>
                </div>               
            </div>
        </div>
        <!-- /.box-body -->
        <!-- /.box -->
    </section>
    <!-- /.content -->
</div>
<jsp:include page="footer.jsp"/>
