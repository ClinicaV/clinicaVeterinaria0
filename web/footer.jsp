<%-- 
    Document   : footer
    Created on : 11-22-2018, 10:23:27 PM
    Author     : Carlos Solis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>

<footer class="main-footer">
    <div class="pull-right hidden-xs">
        <b>Version</b> 1.0.0
    </div>
    <strong>Copyright &copy; Clinica Veterinaria</strong> Derechos Reservados.
</footer>
</div>
<!-- ./wrapper -->
<!-- jQuery 3 -->
<script src="libs/assets/template/jquery/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="libs/assets/template/bootstrap/js/bootstrap.min.js"></script>
<script src="libs/assets/template/jquery-ui/jquery-ui.js"></script>
<!-- SlimScroll -->
<script src="libs/assets/template/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- DataTables -->
<script src="libs/assets/template/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="libs/assets/template/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- FastClick -->
<script src="libs/assets/template/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="libs/assets/template/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="libs/assets/template/dist/js/demo.js"></script>
<script type="text/javascript" language="javascript">

    $("#cat1").DataTable({
        "language": {
            "lengthMenu": "Mostrar _MENU_ registros por pagina",
            "zeroRecords": "No se encontraron resultados en su busqueda",
            "searchPlaceholder": "Buscar registros",
            "info": "Mostrando registros de _START_ al _END_ de un total de  _TOTAL_ registros",
            "infoEmpty": "No existen registros",
            "infoFiltered": "(filtrado de un total de _MAX_ registros)",
            "search": "Buscar:",
            "paginate": {
                "first": "Primero",
                "last": "Último",
                "next": "Siguiente",
                "previous": "Anterior"
            }
        }
    });
    $('.sidebar-menu').tree();

    $(document).on("click", ".btn-check", function () {
        cliente = $(this).val();
        infocliente = cliente.split("*");
        $("#idcliente").val(infocliente[0]);
        $("#cliente").val(infocliente[1] + " " + infocliente[2]);
        $("#modal-default").modal("hide");
    })

    $(document).on("click", ".btn-check2", function () {
        raza = $(this).val();
        inforaza = raza.split("*");
        $("#idraza").val(inforaza[0]);
        $("#raza").val(inforaza[1]);
        $("#modal-raza").modal("hide");
    })
    
    $(document).on("click", ".btn-servicio", function () {
        servicio = $(this).val();
        infoservicio = servicio.split("*");
        $("#idCatTratamiento").val(infoservicio[0]);
        $("#catTratamiento").val(infoservicio[1]);
        $("#modal-servicio").modal("hide");
    })
</script>
</body>
</html>
