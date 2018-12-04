package controller;

import dao.Conexion;
import dao.ConsultoriosDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ConsultoriosBean;

/**
 *
 * @author chris
 */
public class ConsultoriosServlet extends HttpServlet {

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
        ConsultoriosDao cdao = new ConsultoriosDao(conn);
        RequestDispatcher rd;
        List<ConsultoriosBean> registros = cdao.mostrar(estado);
        request.setAttribute("registros", registros);

        if (estado.equals("habilitado")) {
            rd = request.getRequestDispatcher("views/Consultorios/mostrarConsultorios.jsp");
        } else {
            rd = request.getRequestDispatcher("views/Consultorios/habilitarConsultorios.jsp");
        }
        rd.forward(request, response);
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String consultorio = request.getParameter("consultorio");
        int estado = Integer.parseInt(request.getParameter("estado"));
        Conexion conn = new Conexion();
        ConsultoriosDao cdao = new ConsultoriosDao(conn);
        ConsultoriosBean cbean = new ConsultoriosBean(0);
        cbean.setConsultorio(consultorio);
        cbean.setEstadoConsultorio(estado);
        boolean respuesta = cdao.insertar(cbean);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro guardado";
        } else {
            mensaje = "Error al guardar registro";
        }
        RequestDispatcher rd;
        request.setAttribute("mensaje", mensaje);
        rd = request.getRequestDispatcher("agregarConsultorios.jsp");
        rd.forward(request, response);
    }

    protected void buscarId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idConsultorio"));
        Conexion conn = new Conexion();
        ConsultoriosDao cdao = new ConsultoriosDao(conn);
        List<ConsultoriosBean> registros = cdao.buscarId(id);
        RequestDispatcher rd;
        request.setAttribute("registros", registros);
        rd = request.getRequestDispatcher("views/Consultorios/editarConsultorios.jsp");
        rd.forward(request, response);
    }

    protected void deshabilitar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String estado = request.getParameter("estado");
        int id = Integer.parseInt(request.getParameter("idConsultorio"));
        Conexion conn = new Conexion();
        ConsultoriosDao cdao = new ConsultoriosDao(conn);
        boolean respuesta = cdao.deshabilitar(id, estado);
        String mensaje;
        List<ConsultoriosBean> registros;
        RequestDispatcher rd;
        if (estado.equals("habilitar")) {
            if (respuesta) {
                mensaje = "Registro habilitado";
            } else {
                mensaje = "Error al habilitar registro";
            }
            registros = cdao.mostrar("deshabilitado");
            rd = request.getRequestDispatcher("views/Consultorios/habilitarConsultorios.jsp");
        } else {
            if (respuesta) {
                mensaje = "Registro deshabilitado";
            } else {
                mensaje = "Error al deshabilitar registro";
            }
            registros = cdao.mostrar("habilitado");
            rd = request.getRequestDispatcher("views/Consultorios/mostrarConsultorios.jsp");
        }
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);
        rd.forward(request, response);
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int estado = Integer.parseInt(request.getParameter("estado"));
        int id = Integer.parseInt(request.getParameter("id"));
        String consultorio = request.getParameter("consultorio");
        Conexion conn = new Conexion();
        ConsultoriosDao cdao = new ConsultoriosDao(conn);
        ConsultoriosBean cbean = new ConsultoriosBean(id);
        cbean.setConsultorio(consultorio);
        boolean respuesta = cdao.actualizar(cbean);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro actualizado";
        } else {
            mensaje = "Error al actualizar registro";
        }
        RequestDispatcher rd;
        List<ConsultoriosBean> registros;

        if (estado == 1) {
            registros = cdao.mostrar("habilitado");
            rd = request.getRequestDispatcher("views/Consultorios/mostrarConsultorios.jsp");
        } else {
            registros = cdao.mostrar("deshabilitado");
            rd = request.getRequestDispatcher("views/Consultorios/habilitarConsultorios.jsp");
        }
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);
        rd.forward(request, response);
    }
}
