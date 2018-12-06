<%-- 
    Document   : agregarEmpleados
    Created on : 11-29-2018, 03:27:11 PM
    Author     : Franklin Alexis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<title>Agregar Empleados</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Agregar Empleados</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="form-group col-md-5">
                    <form action="empleados?action=insertar" method="POST">
                        <label>Nombres</label>
                        <input class="form-control" name="nombres" required="">
                        <label>Apellidos</label>
                        <input class="form-control" name="apellidos" required="">
                        <label>Telefono</label>
                        <input class="form-control" name="telefono" required="">
                        <label>Genero</label><br/>
                        <select class="form-control" name="genero">
                                <option value="Masculino">Masculino</option>
                                <option value="Femenino">Femenino</option>
                        </select><br/>
                        <label>NIT</label>
                        <input class="form-control " name="nit" required="">
                        <label>DUI</label>
                        <input class="form-control" name="dui" required=""><br/>
                        <label>Rol</label>
                        <select class="form-control" name="idRol">
                            <c:forEach items="${registros}" var="list">
                                <option value="${list.idRol}">${list.rol}</option>
                            </c:forEach>
                        </select><br/>
                        <button class="btn btn-primary">Agregar</button>
                    </form>
                    ${mensaje}<br/><br/>
                    <a class=" btn btn-success" href="empleados?action=mostrar&estado">Mostrar Registros</a>
                   
                </div>               
            </div>
        </div>
<!-- /.box-body -->
<!-- /.box -->
</section>
<!-- /.content -->
</div>
<jsp:include page="footer.jsp"/>