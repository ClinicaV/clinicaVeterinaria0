package controller;

import dao.ServiciosDao;
import dao.Conexion;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ServiciosBean;

/**
 *
 * @author Carlos Solis
 */
public class ServiciosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        try {
            switch (action) {
                case "insertar":
                    insertar(request, response);
                    break;
                case "mostrar":
                    mostrar(request, response);
                    break;
                case "buscarId":
                    buscarId(request, response);
                    break;
                case "deshabilitar":
                    deshabilitar(request, response);
                    break;
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
        ServiciosDao sdao = new ServiciosDao(conn);
        List<ServiciosBean> registros = sdao.mostrar(estado);
        request.setAttribute("registros", registros);
        RequestDispatcher rd;

        if (estado.equals("habilitado")) {
            rd = request.getRequestDispatcher("views/Servicios/mostrarServicios.jsp");
        } else {
            rd = request.getRequestDispatcher("views/Servicios/habilitarServicios.jsp");
        }
        rd.forward(request, response);

    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String catTratamiento = request.getParameter("catTratamiento");
        String descripcion = request.getParameter("descripcion");
        int estado = Integer.parseInt(request.getParameter("estado"));
        Conexion conn = new Conexion();
        ServiciosDao sdao = new ServiciosDao(conn);
        ServiciosBean sbean = new ServiciosBean(0);
        sbean.setCatTratamiento(catTratamiento);
        sbean.setDescripcion(descripcion);
        sbean.setEstadoServicios(estado);
        boolean respuesta = sdao.insertar(sbean);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro guardado";
        } else {
            mensaje = "Error al guardar registro";
        }

        RequestDispatcher rd;
        request.setAttribute("mensaje", mensaje);
        rd = request.getRequestDispatcher("agregarServicios.jsp");
        rd.forward(request, response);
    }

    protected void buscarId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idCatTratamiento"));
        Conexion conn = new Conexion();
        ServiciosDao sdao = new ServiciosDao(conn);
        List<ServiciosBean> registros = sdao.buscarId(id);
        RequestDispatcher rd;
        request.setAttribute("registros", registros);
        rd = request.getRequestDispatcher("/views/Servicios/editarServicios.jsp");
        rd.forward(request, response);
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int estado = Integer.parseInt(request.getParameter("estado"));
        int id = Integer.parseInt(request.getParameter("id"));
        String catTratamiento = request.getParameter("catTratamiento");
        String descripcion = request.getParameter("descripcion");
        ServiciosBean sbean = new ServiciosBean(id);
        Conexion conn = new Conexion();
        ServiciosDao sdao = new ServiciosDao(conn);
        sbean.setCatTratamiento(catTratamiento);
        sbean.setDescripcion(descripcion);
        boolean res = sdao.actualizar(sbean);
        String mensaje;
        if (res) {
            mensaje = "Registro actualizado";
        } else {
            mensaje = "Error al actualizar registro";
        }
        RequestDispatcher rd;
        List<ServiciosBean> registros;

        if (estado == 1) {
            registros = sdao.mostrar("habilitado");
            rd = request.getRequestDispatcher("views/Servicios/mostrarServicios.jsp");
        } else {
            registros = sdao.mostrar("deshabilitado");
            rd = request.getRequestDispatcher("views/Servicios/habilitarServicios.jsp");
        }
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);
        rd.forward(request, response);
    }

    protected void deshabilitar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String estado = request.getParameter("estado");
        int id = Integer.parseInt(request.getParameter("idCatTratamiento"));
        Conexion conn = new Conexion();
        ServiciosDao sdao = new ServiciosDao(conn);
        boolean res = sdao.deshabilitar(id, estado);
        String mensaje;
        List<ServiciosBean> registros;
        RequestDispatcher rd;
        if (estado.equals("habilitar")) {
            if (res) {
                mensaje = "Registro habilitado";
            } else {
                mensaje = "Error al habilitar registro";
            }
            registros = sdao.mostrar("deshabilitado");
            rd = request.getRequestDispatcher("views/Servicios/habilitarServicios.jsp");

        } else {
            if (res) {
                mensaje = "Registro deshabilitado";
            } else {
                mensaje = "Error al deshabilitar registro";
            }
            registros = sdao.mostrar("habilitado");
            rd = request.getRequestDispatcher("views/Servicios/mostrarServicios.jsp");
        }
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);

        rd.forward(request, response);
    }

}
