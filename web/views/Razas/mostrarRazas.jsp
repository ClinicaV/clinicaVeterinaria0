<%-- 
    Document   : mostrar
    Created on : 11-28-2018, 02:54:38 PM
    Author     : Carlos Solis
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Registros Razas</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Listado Razas Animales</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                    <br/>
                    <a class="btn btn-primary" href="razas?action=listarCategorias&estado=habilitado">Nuevo registro</a>
                    <br/><br/>
                    <table id="cat1" class="table table-striped table-bordered">
                        <thead class="alert-info">
                        <th>ID</th>
                        <th>Raza</th>
                        <th>Descripcion</th>
                        <th>Categoria</th>
                        <th></th>
                        </thead>
                        <tbody>
                            <c:forEach items="${listar}" var="ver">
                                <tr>
                                    <td>${ver.idRaza}</td>
                                    <td>${ver.raza}</td>
                                    <td>${ver.descripcion}</td>
                                    <td>${ver.categoria}</td>
                                    <td><a class="btn btn-warning" href="razas?action=buscarId&id=${ver.idRaza}&estado=habilitado"</a>Editar</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    ${mensaje}
            </div>
        </div>
<!-- /.box-body -->
<!-- /.box -->
</section>
<!-- /.content -->
</div>
<jsp:include page="../../footer.jsp"/>
