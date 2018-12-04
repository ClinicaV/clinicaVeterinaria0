package controller;

import dao.Conexion;
import dao.UnidadesDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UnidadesBean;

/**
 *
 * @author chris
 */
public class UnidadesServlet extends HttpServlet {

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
        UnidadesDao udao = new UnidadesDao(conn);
        RequestDispatcher rd;
        List<UnidadesBean> registros = udao.mostrar(estado);
        request.setAttribute("registros", registros);

        if (estado.equals("habilitado")) {
            rd = request.getRequestDispatcher("views/UnidadesMedicion/mostrarUnidades.jsp");
        } else {
            rd = request.getRequestDispatcher("views/UnidadesMedicion/habilitarUnidades.jsp");
        }
        rd.forward(request, response);

    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String unidad = request.getParameter("unidad");
        int estado = Integer.parseInt(request.getParameter("estado"));
        Conexion conn = new Conexion();
        UnidadesDao udao = new UnidadesDao(conn);
        UnidadesBean ubean = new UnidadesBean(0);
        ubean.setUnidadMedicion(unidad);
        ubean.setEstadoUnidad(estado);
        boolean respuesta = udao.insertar(ubean);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro guardado";
        } else {
            mensaje = "Error al guardar registro";
        }
        RequestDispatcher rd;
        request.setAttribute("mensaje", mensaje);
        rd = request.getRequestDispatcher("agregarUnidades.jsp");
        rd.forward(request, response);

    }

    protected void buscarId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idUnidadMedicion"));
        Conexion conn = new Conexion();
        UnidadesDao udao = new UnidadesDao(conn);
        List<UnidadesBean> registros = udao.buscarId(id);
        RequestDispatcher rd;
        request.setAttribute("registros", registros);
        rd = request.getRequestDispatcher("views/UnidadesMedicion/editarUnidades.jsp");
        rd.forward(request, response);
    }

    protected void deshabilitar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String estado = request.getParameter("estado");
        int id = Integer.parseInt(request.getParameter("idUnidadMedicion"));
        Conexion conn = new Conexion();
        UnidadesDao udao = new UnidadesDao(conn);
        boolean respuesta = udao.deshabilitar(id, estado);
        String mensaje;
        List<UnidadesBean> registros;
        RequestDispatcher rd;
        if (estado.equals("habilitar")) {
            if (respuesta) {
                mensaje = "Registro habilitado";
            } else {
                mensaje = "Error al habilitar registro";
            }
            registros = udao.mostrar("deshabilitado");
            rd = request.getRequestDispatcher("views/UnidadesMedicion/habilitarUnidades.jsp");
        } else {
            if (respuesta) {
                mensaje = "Registro deshabilitado";
            } else {
                mensaje = "Error al deshabilitar registro";
            }
            registros = udao.mostrar("habilitado");
            rd = request.getRequestDispatcher("views/UnidadesMedicion/mostrarUnidades.jsp");
        }
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);
        rd.forward(request, response);

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int estado = Integer.parseInt(request.getParameter("estado"));
        int id = Integer.parseInt(request.getParameter("id"));
        String unidad = request.getParameter("unidad");
        Conexion conn = new Conexion();
        UnidadesDao udao = new UnidadesDao(conn);
        UnidadesBean ubean = new UnidadesBean(id);
        ubean.setUnidadMedicion(unidad);
        boolean respuesta = udao.actualizar(ubean);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro actualizado";
        } else {
            mensaje = "Error al actualizar registro";
        }
        RequestDispatcher rd;
        List<UnidadesBean> registros;

        if (estado == 1) {
            registros = udao.mostrar("habilitado");
            rd = request.getRequestDispatcher("views/UnidadesMedicion/mostrarUnidades.jsp");
        } else {
            registros = udao.mostrar("deshabilitado");
            rd = request.getRequestDispatcher("views/UnidadesMedicion/habilitarUnidades.jsp");
        }
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);
        rd.forward(request, response);
    }
}
