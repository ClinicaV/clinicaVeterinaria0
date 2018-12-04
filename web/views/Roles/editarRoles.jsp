<%-- 
    Document   : editarRoles
    Created on : 23-nov-2018, 16:16:37
    Author     : chris
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Editar Rol</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Editar Rol</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="form-group col-md-5">
                    <form action="roles?action=actualizar" method="POST">
                        <c:forEach items="${registros}" var="ver">
                            <label>ID:</label>
                            <input class="form-control" name="id" readonly="" value="${ver.idRol}">
                            <label>Rol</label>
                            <input class="form-control" name="rol" required="" value="${ver.rol}"><br/>
                            <button class="btn btn-warning col-3" name="estado" value="${ver.estadoRol}">Actualizar</button>
                        </c:forEach>
                    </form>
                   <br/> <button class="btn btn-danger col-3" onclick="history.back()" >Cancelar</button>
                </div>
            </div>
        </div>
</section>
</div>
<jsp:include page="../../footer.jsp"/>
