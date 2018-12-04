<%-- 
    Document   : agregarPersonas
    Created on : 23-nov-2018, 21:07:10
    Author     : chris
--%>

<jsp:include page="header.jsp"/>
<title>Agregar Cliente</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Agregar Cliente</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="form-group col-md-5">
                    <form action="personas?action=insertar" method="POST">
                        <label>Nombres</label>
                        <input class="form-control" name="nombres" required="">
                        <label>Apellidos</label>
                        <input class="form-control" name="apellidos" required="">
                        <label>Telefono</label>
                        <input class="form-control" name="telefono" required="">
                        <label>Genero</label>
                        <input class="form-control" name="genero" required=""><br/>
                        <select class="form-control" name="estado">
                            <option value="1">Habilitado</option>
                            <option value="0">Deshabilitado</option>
                        </select><br/>
                        <button class="btn btn-primary ">Guardar</button>
                    </form>
                    ${mensaje}<br/><br/>
                    <a class="btn btn-success" href="personas?action=mostrar&estado=habilitado">Mostrar Registros</a>
                </div>
            </div>
        </div>
    </section>
</div>
                    <jsp:include page="footer.jsp"/>
