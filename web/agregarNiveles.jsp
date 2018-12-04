<%-- 
    Document   : agregarNiveles
    Created on : 23-nov-2018, 16:58:50
    Author     : chris
--%>

<jsp:include page="header.jsp"/>
<title>Agregar Niveles</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Agregar Niveles</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="form-group col-md-5">
                    <form action="niveles?action=insertar" method="POST">
                        <label>Nivel</label>
                        <input class="form-control" name="nivel" required=""><br/>
                        <select class="form-control" name="estado">
                            <option value="1">Habilitado</option>
                            <option value="0">Deshabilitado</option>
                        </select><br/>
                        <button class="btn btn-primary">Agregar</button>
                    </form>
                    ${mensaje}<br/><br/>
                    <a class="btn btn-success" href="niveles?action=mostrar&estado=habilitado">Mostrar Registros</a>
                </div>               
            </div>
        </div>
<!-- /.box-body -->
<!-- /.box -->
</section>
<!-- /.content -->
</div>
<jsp:include page="footer.jsp"/>
