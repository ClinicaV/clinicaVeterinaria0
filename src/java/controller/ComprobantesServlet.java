package controller;

import dao.ComprobantesDao;
import dao.Conexion;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ComprobantesBean;

/**
 *
 * @author chris
 */
public class ComprobantesServlet extends HttpServlet {

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
        ComprobantesDao cdao = new ComprobantesDao(conn);
        RequestDispatcher rd;
        List<ComprobantesBean> registros = cdao.mostrar(estado);
        request.setAttribute("registros", registros);

        if (estado.equals("habilitado")) {
            rd = request.getRequestDispatcher("views/Comprobantes/mostrarComprobantes.jsp");
        } else {
            rd = request.getRequestDispatcher("views/Comprobantes/habilitarComprobantes.jsp");
        }
        rd.forward(request, response);
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String comprobante = request.getParameter("comprobante");
        int estado = Integer.parseInt(request.getParameter("estado"));
        Conexion conn = new Conexion();
        ComprobantesDao cdao = new ComprobantesDao(conn);
        ComprobantesBean cbean = new ComprobantesBean(0);
        cbean.setComprobante(comprobante);
        cbean.setEstadoComprobante(estado);
        boolean respuesta = cdao.insertar(cbean);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro guardado";
        } else {
            mensaje = "Error al guardar registro";
        }
        RequestDispatcher rd;
        request.setAttribute("mensaje", mensaje);
        rd = request.getRequestDispatcher("agregarComprobantes.jsp");
        rd.forward(request, response);
    }

    protected void buscarId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idComprobante"));
        Conexion conn = new Conexion();
        ComprobantesDao cdao = new ComprobantesDao(conn);
        List<ComprobantesBean> registros = cdao.buscarId(id);
        RequestDispatcher rd;
        request.setAttribute("registros", registros);
        rd = request.getRequestDispatcher("views/Comprobantes/editarComprobantes.jsp");
        rd.forward(request, response);
    }

    protected void deshabilitar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String estado = request.getParameter("estado");
        int id = Integer.parseInt(request.getParameter("idComprobante"));
        Conexion conn = new Conexion();
        ComprobantesDao cdao = new ComprobantesDao(conn);
        boolean respuesta = cdao.deshabilitar(id, estado);
        String mensaje;
        List<ComprobantesBean> registros;
        RequestDispatcher rd;
        if (estado.equals("habilitar")) {
            if (respuesta) {
                mensaje = "Registro habilitado";
            } else {
                mensaje = "Error al habilitar registro";
            }
            registros = cdao.mostrar("deshabilitado");
            rd = request.getRequestDispatcher("views/Comprobantes/habilitarComprobantes.jsp");
        } else {
            if (respuesta) {
                mensaje = "Registro deshabilitado";
            } else {
                mensaje = "Error al deshabilitar registro";
            }
            registros = cdao.mostrar("habilitado");
            rd = request.getRequestDispatcher("views/Comprobantes/mostrarComprobantes.jsp");
        }
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);
        rd.forward(request, response);

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int estado = Integer.parseInt(request.getParameter("estado"));
        int id = Integer.parseInt(request.getParameter("id"));
        String comprobante = request.getParameter("comprobante");
        Conexion conn = new Conexion();
        ComprobantesDao cdao = new ComprobantesDao(conn);
        ComprobantesBean cbean = new ComprobantesBean(id);
        cbean.setComprobante(comprobante);
        boolean respuesta = cdao.actualizar(cbean);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro actualizado";
        } else {
            mensaje = "Error al actualizar registro";
        }
        RequestDispatcher rd;
        List<ComprobantesBean> registros;

        if (estado == 1) {
            registros = cdao.mostrar("habilitado");
            rd = request.getRequestDispatcher("views/Comprobantes/mostrarComprobantes.jsp");
        } else {
            registros = cdao.mostrar("deshabilitado");
            rd = request.getRequestDispatcher("views/Comprobantes/habilitarComprobantes.jsp");
        }
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);
        rd.forward(request, response);
    }
}
