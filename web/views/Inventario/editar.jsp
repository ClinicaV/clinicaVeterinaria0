<%-- 
    Document   : editar
    Created on : 11-29-2018, 11:49:19 PM
    Author     : Franklin Alexis
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Editar Inventario</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>

            <small>Editar Inventario</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="col-8">
                    <form action="inventario?action=actualizar" method="POST">
                        <c:forEach items="${listar}" var="list">

                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>ID</label>
                                        <input class="form-control col-3" name="id" readonly="" value="${list.idProducto}">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Producto</label>
                                        <input class="form-control col-3" name="producto" readonly="" value="${list.producto}">
                                    </div>
                                </div>
                            </div>
                                    
                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Cantidad</label>
                                        <input class="form-control col-3" name="cantidad" required="" value="${list.cantidad}">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Costo Unitario</label>
                                        <input class="form-control" name="costoUnitario" required="" value="${list.costoUnitario}"><br/>
                                    </div>
                                </div>
                            </div>

                            
                        </c:forEach>
                        <button class="btn btn-warning ">Actualizar</button>
                    </form>
                    <br/> <button class="btn btn-danger " onclick="history.back()" >Cancelar</button>
                </div>
            </div>
        </div>
    </section>
</div>
<jsp:include page="../../footer.jsp"/>

