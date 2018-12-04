<%-- 
    Document   : agregarHorarios
    Created on : 11-29-2018, 06:13:16 PM
    Author     : Franklin Alexis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Agregar Horarios</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="col-8">
                    <form action="horarios?action=insertar" method="POST">
                        <label>Hora Inicio</label>
                        <input class="form-control col-3" name="horaInicio" required="">
                        <label>Hora Fin</label>
                        <input class="form-control col-3" name="horaFin" required=""><br/>
                        <label>Categoria Animal</label>
                        <select class="custom-select col-3" name="idCatTratamiento">
                            <c:forEach items="${registros}" var="list">
                                <option value="${list.idCatTratamiento}">${list.catTratamiento}</option>
                            </c:forEach>
                        </select>
                        <button class="btn btn-primary">Agregar</button>
                    </form>
                    ${mensaje}<br/><br/>
                    <form action="servicios?action=mostrar" method="POST">
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

