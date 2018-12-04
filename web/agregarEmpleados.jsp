<%-- 
    Document   : agregarEmpleados
    Created on : 11-29-2018, 03:27:11 PM
    Author     : Franklin Alexis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
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
                <div class="col-8">
                    <form action="empleados?action=insertar" method="POST">
                        <label>Nombres</label>
                        <input class="form-control col-3" name="nombres" required="">
                        <label>Apellidos</label>
                        <input class="form-control col-3" name="apellidos" required="">
                        <label>Telefono</label>
                        <input class="form-control col-3" name="telefono" required="">
                        <label>Genero</label><br/>
                        <select class="custom-select col-3" name="genero">
                                <option value="Masculino">Masculino</option>
                                <option value="Femenino">Femenino</option>
                        </select><br/>
                        <label>NIT</label>
                        <input class="form-control col-3" name="nit" required="">
                        <label>DUI</label>
                        <input class="form-control col-3" name="dui" required=""><br/>
                        <label>Rol</label>
                        <select class="custom-select col-3" name="idRol">
                            <c:forEach items="${registros}" var="list">
                                <option value="${list.idRol}">${list.rol}</option>
                            </c:forEach>
                        </select>
                        <button class="btn btn-primary">Agregar</button>
                    </form>
                    ${mensaje}<br/><br/>
                    <form action="empleados?action=mostrar" method="POST">
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