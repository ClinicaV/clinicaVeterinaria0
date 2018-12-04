<%-- 
    Document   : agregarCatAnimales
    Created on : 24-nov-2018, 18:13:41
    Author     : chris
--%>

<jsp:include page="header.jsp"/>
<title>Agregar Categoria Animal</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Agregar Categorias Animales</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="form-group col-md-5">
                    <form action="catanimales?action=insertar" method="POST">
                        <label>Categoria de Animal</label>
                        <input class="form-control" name="catani" required="">
                        <label>Descripcion</label>
                        <input class="form-control" name="descripcion" required=""><br/>
                        <select class="form-control" name="estado">
                            <option value="1">Habilitado</option>
                            <option value="0">Deshabilitado</option>
                        </select><br/>
                        <button class="btn btn-primary">Agregar</button>
                    </form>
                    ${mensaje}<br/><br/>
                    <a class="btn btn-success" href="catanimales?action=mostrar&estado=habilitado">Mostrar Registros</a>
                </div>               
            </div>
        </div>
<!-- /.box-body -->
<!-- /.box -->
</section>
<!-- /.content -->
</div>
<jsp:include page="footer.jsp"/>
