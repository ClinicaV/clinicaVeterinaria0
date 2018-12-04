<%-- 
    Document   : editarProveedores
    Created on : 22-nov-2018, 21:16:49
    Author     : chris
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Editar Proveedor</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Editar Proveedor</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="form-group col-md-5">
                    <form action="proveedores?action=actualizar" method="POST">
                        <c:forEach items="${registros}" var="ver">
                            <label>ID:</label>
                            <input class="form-control" name="id" readonly="" value="${ver.idProveedor}">
                            <label>Proveedor</label>
                            <input class="form-control" name="proveedor" required="" value="${ver.proveedor}">
                            <label>Telefono</label>
                            <input class="form-control" name="telefono" required="" value="${ver.telefono}">
                            <label>Email</label>
                            <input class="form-control" name="email" required="" value="${ver.email}">
                            <label>Direccion</label>
                            <input class="form-control" name="direccion" required="" value="${ver.direccion}">
                            <label>Contacto</label>
                            <input class="form-control" name="contacto" required="" value="${ver.personaContacto}"><br/>
                            <button class="btn btn-warning" name="estado" value="${ver.estadoProveedor}">Actualizar</button>
                        </c:forEach>
                    </form>
                    <br/> <button class="btn btn-danger" onclick="history.back()" >Cancelar</button>
                </div>
            </div>
        </div>
</section>
</div>
<jsp:include page="../../footer.jsp"/>
