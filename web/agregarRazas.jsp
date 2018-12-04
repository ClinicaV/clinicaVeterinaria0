<%-- 
    Document   : agregarRazas
    Created on : 11-28-2018, 02:44:14 PM
    Author     : Carlos Solis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<title>Agregar Raza</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Agregar Razas Animales</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="form-group col-md-5">
                    <form action="razas?action=insertar" method="POST">
                        <label>Raza</label>
                        <input class="form-control " name="raza" required="">
                        <label>Descripcion</label>
                        <input class="form-control " name="descripcion" required=""><br/>
                        <label>Categoria Animal</label>
                        <select class="form-control" name="categoria">
                            <c:forEach items="${registros}" var="list">
                                <option value="${list.idCatAnimal}">${list.catAnimal}</option>
                            </c:forEach>
                        </select><br/>
                        <button class="btn btn-primary">Agregar</button>
                    </form>
                    ${mensaje}<br/><br/>
                    <a class="btn btn-success" href="razas?action=mostrar&estado=habilitado">Mostrar Registros</a>
                </div>               
            </div>
        </div>
<!-- /.box-body -->
<!-- /.box -->
</section>
<!-- /.content -->
</div>
<jsp:include page="footer.jsp"/>
