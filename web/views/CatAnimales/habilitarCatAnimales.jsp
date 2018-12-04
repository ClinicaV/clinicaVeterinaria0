<%-- 
    Document   : habilitarCatAnimales
    Created on : 24-nov-2018, 18:14:10
    Author     : chris
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Categorias Animales Deshabilitados</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>

            <small>Categorias Animales Deshabilitados</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <br/>
                <a class="btn btn-primary" href="catanimales?action=mostrar&estado=habilitado">Registros Generales</a>
                <br/><br/>
                <table id="cat1" class="table table-striped">
                    <thead class="alert-info">
                    <th>ID</th>
                    <th>Categoria Animal</th>
                    <th>Descripcion</th>
                    <th></th>
                    <th></th>
                    </thead>
                    <tbody>
                        <c:forEach items="${registros}" var="ver">
                            <tr>
                                <td>${ver.idCatAnimal}</td>
                                <td>${ver.catAnimal}</td>
                                <td>${ver.descripcion}</td>
                                <td><a class="btn btn-warning" href="catanimales?action=buscarId&idCatAnimal=${ver.idCatAnimal}"</a>Editar</td>
                                <td><a class="btn btn-success" href="catanimales?action=deshabilitar&idCatAnimal=${ver.idCatAnimal}&estado=habilitar">Habilitar</a></td>
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
