<%-- 
    Document   : editarPersonas
    Created on : 23-nov-2018, 21:26:57
    Author     : chris
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Editar Cliente</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Editar Cliente</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="form-group col-md-5">
                    <form action="personas?action=actualizar" method="POST">
                        <c:forEach items="${registros}" var="ver">
                            <label>ID:</label>
                            <input class="form-control" name="id" readonly="" value="${ver.idPersona}">
                            <label>Nombres</label>
                            <input class="form-control" name="nombres" required="" value="${ver.nombres}">
                            <label>Apellidos</label>
                            <input class="form-control" name="apellidos" required="" value="${ver.apellidos}">
                            <label>Telefono</label>
                            <input class="form-control" name="telefono" required="" value="${ver.telefono}">
                            <label>Genero</label>
                            <input class="form-control" name="genero" required="" value="${ver.genero}"><br/>
                            <button class="btn btn-warning" name="estado" value="${ver.estadoPersona}">Actualizar</button>
                        </c:forEach>
                    </form>
                    <br/> <button class="btn btn-danger" onclick="history.back()" >Cancelar</button>
                </div>
            </div>
        </div>
</section>
</div>
<jsp:include page="../../footer.jsp"/>
