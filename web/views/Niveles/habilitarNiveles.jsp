<%-- 
    Document   : habilitarNiveles
    Created on : 23-nov-2018, 17:04:07
    Author     : chris
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Niveles deshabilitados</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>

            <small>Niveles Deshabilitados</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                    <br/>
                    <a class="btn btn-primary" href="niveles?action=mostrar&estado=habilitado">Registros Generales</a>
                    <br/><br/>
                    <table id="cat1" class="table table-striped">
                        <thead class="alert-info">
                        <th>ID</th>
                        <th>Nivel</th>
                        <th></th>
                        <th></th>
                        </thead>
                        <tbody>
                            <c:forEach items="${registros}" var="ver">
                                <tr>
                                    <td>${ver.idNivel}</td>
                                    <td>${ver.nivel}</td>
                                    <td><a class="btn btn-warning" href="niveles?action=buscarId&idNivel=${ver.idNivel}"</a>Editar</td>
                                    <td><a class="btn btn-success" href="niveles?action=deshabilitar&idNivel=${ver.idNivel}&estado=habilitar">Habilitar</a> </td>
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
