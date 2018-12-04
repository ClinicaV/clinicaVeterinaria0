package controller;

import dao.Conexion;
import dao.RolesDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RolesBean;

/**
 *
 * @author chris
 */
public class RolesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {

                case "mostrar":
                    mostrar(request, response);
                    break;
                case "insertar":
                    insertar(request, response);
                    break;
                case "buscarId":
                    buscarId(request, response);
                    break;
                case "deshabilitar":
                    deshabilitar(request, response);
                case "actualizar":
                    actualizar(request, response);
                    break;

            }
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void mostrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String estado = request.getParameter("estado");
        Conexion conn = new Conexion();
        RolesDao rdao = new RolesDao(conn);
        RequestDispatcher rd;
        List<RolesBean> registros = rdao.mostrar(estado);
        request.setAttribute("registros", registros);

        if (estado.equals("habilitado")) {
            rd = request.getRequestDispatcher("views/Roles/mostrarRoles.jsp");
        } else {
            rd = request.getRequestDispatcher("views/Roles/habilitarRoles.jsp");
        }
        rd.forward(request, response);

    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rol = request.getParameter("rol");
        int estado = Integer.parseInt(request.getParameter("estado"));
        Conexion conn = new Conexion();
        RolesDao rdao = new RolesDao(conn);
        RolesBean rbean = new RolesBean(0);
        rbean.setRol(rol);
        rbean.setEstadoRol(estado);
        boolean respuesta = rdao.insertar(rbean);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro guardado";
        } else {
            mensaje = "Error al guardar registro";
        }
        RequestDispatcher rd;
        request.setAttribute("mensaje", mensaje);
        rd = request.getRequestDispatcher("agregarRoles.jsp");
        rd.forward(request, response);

    }

    protected void buscarId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idRol"));
        Conexion conn = new Conexion();
        RolesDao rdao = new RolesDao(conn);
        List<RolesBean> registros = rdao.buscarId(id);
        RequestDispatcher rd;
        request.setAttribute("registros", registros);
        rd = request.getRequestDispatcher("views/Roles/editarRoles.jsp");
        rd.forward(request, response);
    }

    protected void deshabilitar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String estado = request.getParameter("estado");
        int id = Integer.parseInt(request.getParameter("idRol"));
        Conexion conn = new Conexion();
        RolesDao rdao = new RolesDao(conn);
        boolean respuesta = rdao.deshabilitar(id, estado);
        String mensaje;
        List<RolesBean> registros;
        RequestDispatcher rd;
        if (estado.equals("habilitar")) {
            if (respuesta) {
                mensaje = "Registro habilitado";
            } else {
                mensaje = "Error al habilitar registro";
            }
            registros = rdao.mostrar("deshabilitado");
            rd = request.getRequestDispatcher("views/Roles/habilitarRoles.jsp");
        } else {
            if (respuesta) {
                mensaje = "Registro deshabilitado";
            } else {
                mensaje = "Error al deshabilitar registro";
            }
            registros = rdao.mostrar("habilitado");
            rd = request.getRequestDispatcher("views/Roles/mostrarRoles.jsp");
        }
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);
        rd.forward(request, response);

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int estado = Integer.parseInt(request.getParameter("estado"));
        int id = Integer.parseInt(request.getParameter("id"));
        String rol = request.getParameter("rol");
        Conexion conn = new Conexion();
        RolesDao rdao = new RolesDao(conn);
        RolesBean rbean = new RolesBean(id);
        rbean.setRol(rol);
        boolean respuesta = rdao.actualizar(rbean);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro actualizado";
        } else {
            mensaje = "Error al actualizar registro";
        }
        RequestDispatcher rd;
        List<RolesBean> registros;

        if (estado == 1) {
            registros = rdao.mostrar("habilitado");
            rd = request.getRequestDispatcher("views/Roles/mostrarRoles.jsp");
        } else {
            registros = rdao.mostrar("deshabilitado");
            rd = request.getRequestDispatcher("views/Roles/habilitarRoles.jsp");
        }
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);
        rd.forward(request, response);
    }

}
