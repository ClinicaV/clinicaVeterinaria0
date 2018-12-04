<%-- 
    Document   : agregarConsultorios
    Created on : 23-nov-2018, 17:41:23
    Author     : chris
--%>

<jsp:include page="header.jsp"/>
<title>Agregar Consultorio</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Agregar Consultorio</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="form-group col-md-5">
                    <form action="consultorios?action=insertar" method="POST">
                        <label>Consultorio</label>
                        <input class="form-control" name="consultorio" required=""><br/>
                        <select class="form-control" name="estado">
                            <option value="1">Habilitado</option>
                            <option value="0">Deshabilitado</option>
                        </select><br/>
                        <button class="btn btn-primary">Agregar</button>
                    </form>
                    ${mensaje}<br/><br/>
                    <a class="btn btn-success" href="consultorios?action=mostrar&estado=habilitado">Mostrar Registros</a>
                </div>               
            </div>
        </div>
<!-- /.box-body -->
<!-- /.box -->
</section>
<!-- /.content -->
</div>
<jsp:include page="footer.jsp"/>
