<%-- 
    Document   : editarUnidades
    Created on : 18-nov-2018, 11:44:44
    Author     : chris
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Editar Unidad de Medicion</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Editar Unidad de Medicion</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="form-group col-md-5">
                    <form action="unidades?action=actualizar" method="POST">
                        <c:forEach items="${registros}" var="ver">
                            <label>ID:</label>
                            <input class="form-control" name="id" readonly="" value="${ver.idUnidadMedicion}">
                            <label>Unidad de Medicion</label>
                            <input class="form-control" name="unidad" required="" value="${ver.unidadMedicion}"><br/>
                            <button class="btn btn-warning" name="estado" value="${ver.estadoUnidad}">Actualizar</button>
                        </c:forEach>
                    </form>
                   <br/> <button class="btn btn-danger" onclick="history.back()" >Cancelar</button>
                </div>
            </div>
        </div>
</section>
</div>
<jsp:include page="../../footer.jsp"/>