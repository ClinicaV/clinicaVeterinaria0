<%-- 
    Document   : editarCatAnimales
    Created on : 24-nov-2018, 18:14:22
    Author     : chris
--%>

<jsp:include page="../../header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Editar Categoria Animal</title>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            
            <small>Editar Categoria Animal</small>
        </h1>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Default box -->
        <div class="box box-solid">
            <div class="box-body">
                <div class="form-group col-md-5">
                    <form action="catanimales?action=actualizar" method="POST">
                        <c:forEach items="${registros}" var="ver">
                            <label>ID:</label>
                            <input class="form-control" name="id" readonly="" value="${ver.idCatAnimal}">
                            <label>Categoria de Animal</label>
                            <input class="form-control" name="catani" required="" value="${ver.catAnimal}">
                            <label>Descripcion</label>
                            <input class="form-control" name="descripcion" required="" value="${ver.descripcion}"><br/>
                            <button class="btn btn-warning" name="estado" value="${ver.estadoCatAnimal}">Actualizar</button>
                        </c:forEach>
                    </form>
                    <br/> <button class="btn btn-danger" onclick="history.back()" >Cancelar</button>
                </div>
            </div>
        </div>
</section>
</div>
<jsp:include page="../../footer.jsp"/>
