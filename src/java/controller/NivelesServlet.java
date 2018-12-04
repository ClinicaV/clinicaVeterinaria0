package controller;

import dao.Conexion;
import dao.NivelesDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.NivelesBean;

/**
 *
 * @author chris
 */
public class NivelesServlet extends HttpServlet {

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
        NivelesDao ndao = new NivelesDao(conn);
        RequestDispatcher rd;
        List<NivelesBean> registros = ndao.mostrar(estado);
        request.setAttribute("registros", registros);

        if (estado.equals("habilitado")) {
            rd = request.getRequestDispatcher("views/Niveles/mostrarNiveles.jsp");
        } else {
            rd = request.getRequestDispatcher("views/Niveles/habilitarNiveles.jsp");
        }
        rd.forward(request, response);
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nivel = request.getParameter("nivel");
        int estado = Integer.parseInt(request.getParameter("estado"));
        Conexion conn = new Conexion();
        NivelesDao ndao = new NivelesDao(conn);
        NivelesBean nbean = new NivelesBean(0);
        nbean.setNivel(nivel);
        nbean.setEstadoNivel(estado);
        boolean respuesta = ndao.insertar(nbean);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro guardado";
        } else {
            mensaje = "Error al guardar registro";
        }
        RequestDispatcher rd;
        request.setAttribute("mensaje", mensaje);
        rd = request.getRequestDispatcher("agregarNiveles.jsp");
        rd.forward(request, response);
    }

    protected void buscarId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idNivel"));
        Conexion conn = new Conexion();
        NivelesDao ndao = new NivelesDao(conn);
        List<NivelesBean> registros = ndao.buscarId(id);
        RequestDispatcher rd;
        request.setAttribute("registros", registros);
        rd = request.getRequestDispatcher("views/Niveles/editarNiveles.jsp");
        rd.forward(request, response);
    }

    protected void deshabilitar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String estado = request.getParameter("estado");
        int id = Integer.parseInt(request.getParameter("idNivel"));
        Conexion conn = new Conexion();
        NivelesDao ndao = new NivelesDao(conn);
        boolean respuesta = ndao.deshabilitar(id, estado);
        String mensaje;
        List<NivelesBean> registros;
        RequestDispatcher rd;
        if (estado.equals("habilitar")) {
            if (respuesta) {
                mensaje = "Registro habilitado";
            } else {
                mensaje = "Error al habilitar registro";
            }
            registros = ndao.mostrar("deshabilitado");
            rd = request.getRequestDispatcher("views/Niveles/habilitarNiveles.jsp");
        } else {
            if (respuesta) {
                mensaje = "Registro deshabilitado";
            } else {
                mensaje = "Error al deshabilitar registro";
            }
            registros = ndao.mostrar("habilitado");
            rd = request.getRequestDispatcher("views/Niveles/mostrarNiveles.jsp");
        }
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);
        rd.forward(request, response);

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int estado = Integer.parseInt(request.getParameter("estado"));
        int id = Integer.parseInt(request.getParameter("id"));
        String nivel = request.getParameter("nivel");
        Conexion conn = new Conexion();
        NivelesDao ndao = new NivelesDao(conn);
        NivelesBean nbean = new NivelesBean(id);
        nbean.setNivel(nivel);
        boolean respuesta = ndao.actualizar(nbean);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro actualizado";
        } else {
            mensaje = "Error al actualizar registro";
        }
        RequestDispatcher rd;
        List<NivelesBean> registros;

        if (estado == 1) {
            registros = ndao.mostrar("habilitado");
            rd = request.getRequestDispatcher("views/Niveles/mostrarNiveles.jsp");
        } else {
            registros = ndao.mostrar("deshabilitado");
            rd = request.getRequestDispatcher("views/Niveles/habilitarNiveles.jsp");
        }
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);
        rd.forward(request, response);
    }

}
