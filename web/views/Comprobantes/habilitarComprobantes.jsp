<%-- 
    Document   : habilitarComprobantes
    Created on : 23-nov-2018, 18:38:09
    Author     : chris
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Comprobantes Deshabilitados</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>

            <small>Comprobantes Deshabilitados</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                    <br/>
                    <a class="btn btn-primary" href="comprobantes?action=mostrar&estado=habilitado">Registros Generales</a>
                    <br/><br/>
                    <table id="cat1" class="table table-striped">
                        <thead class="alert-info">
                        <th>ID</th>
                        <th>Comprobante</th>
                        <th></th>
                        <th></th>
                        </thead>
                        <tbody>
                            <c:forEach items="${registros}" var="ver">
                                <tr>
                                    <td>${ver.idComprobante}</td>
                                    <td>${ver.comprobante}</td>
                                    <td><a class="btn btn-warning" href="comprobantes?action=buscarId&idComprobante=${ver.idComprobante}"</a>Editar</td>
                                    <td><a class="btn btn-success" href="comprobantes?action=deshabilitar&idComprobante=${ver.idComprobante}&estado=habilitar">Habilitar</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    ${mensaje}
                </div>
            </div>
</section>
</div>
<jsp:include page="../../footer.jsp"/>
