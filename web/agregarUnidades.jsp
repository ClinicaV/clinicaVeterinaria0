<%-- 
    Document   : agregarUnidades
    Created on : 17-nov-2018, 23:02:35
    Author     : chris
--%>

<jsp:include page="header.jsp"/>
<title>Agregar Unidad de Medicion</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>

            <small>Agregar Unidad de Medicion</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="form-group col-md-5">
                    <form action="unidades?action=insertar" method="POST">
                        <label>Unidad de Medicion</label>
                        <input class="form-control" name="unidad" required=""><br/>
                        <select class="form-control" name="estado">
                            <option value="1">Habilitado</option>
                            <option value="0">Deshabilitado</option>
                        </select><br/>
                        <button class="btn btn-primary">Agregar</button>
                    </form>
                    ${mensaje}<br/><br/>
                    <a class="btn btn-success" href="unidades?action=mostrar&estado=habilitado">Mostrar Registros</a>
                </div>               
            </div>
        </div>
    </section>
</div>
<jsp:include page="footer.jsp"/>