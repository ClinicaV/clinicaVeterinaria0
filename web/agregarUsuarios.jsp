<%-- 
    Document   : agregarUsuarios
    Created on : 12-02-2018, 04:04:17 PM
    Author     : Franklin Alexis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Agregar Usuario</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="col-8">
                    <form action="usuarios?action=insertar" method="POST">
                        <label>Usuario</label>
                        <input class="form-control col-3" name="usuario" required=""><br/>
                        
                        <label>Clave de acceso</label>
                        <input class="form-control col-3" type="password" name="password" required=""><br/>
                        
                        <label>Empleado</label><br/>
                        <select class="custom-select col-3" name="codEmpleado" required="">
                            <c:forEach items="${registrosEmp}" var="list">
                                <option value="${list.codEmpleado}">${list.nombres}</option>
                            </c:forEach>
                        </select><br/><br/>
                        
                        <label>Nivel</label><br/>
                        <select class="custom-select col-3" name="idNivel" required="">
                            <c:forEach items="${registrosNiv}" var="list">
                                <option value="${list.idNivel}">${list.nivel}</option>
                            </c:forEach>
                        </select><br/><br/>
                        
                        <button class="btn btn-primary">Agregar</button>
                    </form>
                    ${mensaje}<br/><br/>
                    <form action="usuarios?action=mostrar" method="POST">
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

