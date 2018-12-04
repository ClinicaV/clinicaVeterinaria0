<%-- 
    Document   : editarComprobantes
    Created on : 23-nov-2018, 18:40:34
    Author     : chris
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Editar Comprobante</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Editar Comprobante</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="form-group col-md-5">
                    <form action="comprobantes?action=actualizar" method="POST">
                        <c:forEach items="${registros}" var="ver">
                            <label>ID:</label>
                            <input class="form-control" name="id" readonly="" value="${ver.idComprobante}">
                            <label>Comprobante</label>
                            <input class="form-control" name="comprobante" required="" value="${ver.comprobante}"><br/>
                            <button class="btn btn-warning" name="estado" value="${ver.estadoComprobante}">Actualizar</button>
                        </c:forEach>
                    </form>
                   <br/> <button class="btn btn-danger" onclick="history.back()" >Cancelar</button>
                </div>
            </div>
        </div>
        </div>
</section>
</div>
<jsp:include page="../../footer.jsp"/>
