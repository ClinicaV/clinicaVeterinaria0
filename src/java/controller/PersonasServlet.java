package controller;

import dao.Conexion;
import dao.PersonasDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PersonasBean;

/**
 *
 * @author chris
 */
public class PersonasServlet extends HttpServlet {

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
        PersonasDao pdao = new PersonasDao(conn);
        RequestDispatcher rd;
        List<PersonasBean> registros = pdao.mostrar(estado);
        request.setAttribute("registros", registros);

        if (estado.equals("habilitado")) {
            rd = request.getRequestDispatcher("views/Personas/mostrarPersonas.jsp");
        } else {
            rd = request.getRequestDispatcher("views/Personas/habilitarPersonas.jsp");
        }
        rd.forward(request, response);

    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");
        String genero = request.getParameter("genero");
        int estado = Integer.parseInt(request.getParameter("estado"));
        Conexion conn = new Conexion();
        PersonasDao pdao = new PersonasDao(conn);
        PersonasBean pbean = new PersonasBean(0);
        pbean.setNombres(nombres);
        pbean.setApellidos(apellidos);
        pbean.setTelefono(telefono);
        pbean.setGenero(genero);
        pbean.setEstadoPersona(estado);
        boolean respuesta = pdao.insertar(pbean);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro guardado";
        } else {
            mensaje = "Error al guardar registro";
        }
        RequestDispatcher rd;
        request.setAttribute("mensaje", mensaje);
        rd = request.getRequestDispatcher("agregarPersonas.jsp");
        rd.forward(request, response);
    }

    protected void buscarId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("idPersona"));
        Conexion conn = new Conexion();
        PersonasDao pdao = new PersonasDao(conn);
        List<PersonasBean> registros = pdao.buscarId(id);
        RequestDispatcher rd;
        request.setAttribute("registros", registros);
        rd = request.getRequestDispatcher("views/Personas/editarPersonas.jsp");
        rd.forward(request, response);
    }

    protected void deshabilitar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String estado = request.getParameter("estado");
        int id = Integer.parseInt(request.getParameter("idPersona"));
        Conexion conn = new Conexion();
        PersonasDao pdao = new PersonasDao(conn);
        boolean respuesta = pdao.deshabilitar(id, estado);
        String mensaje;
        List<PersonasBean> registros;
        RequestDispatcher rd;
        if (estado.equals("habilitar")) {
            if (respuesta) {
                mensaje = "Registro habilitado";
            } else {
                mensaje = "Error al habilitar registro";
            }
            registros = pdao.mostrar("deshabilitado");
            rd = request.getRequestDispatcher("views/Personas/habilitarPersonas.jsp");
        } else {
            if (respuesta) {
                mensaje = "Registro deshabilitado";
            } else {
                mensaje = "Error al deshabilitar registro";
            }
            registros = pdao.mostrar("habilitado");
            rd = request.getRequestDispatcher("views/Personas/mostrarPersonas.jsp");
        }
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);
        rd.forward(request, response);

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int estado = Integer.parseInt(request.getParameter("estado"));
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");
        String genero = request.getParameter("genero");
        Conexion conn = new Conexion();
        PersonasDao pdao = new PersonasDao(conn);
        PersonasBean pbean = new PersonasBean(id);
        pbean.setNombres(nombres);
        pbean.setApellidos(apellidos);
        pbean.setTelefono(telefono);
        pbean.setGenero(genero);
        boolean respuesta = pdao.actualizar(pbean);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro actualizado";
        } else {
            mensaje = "Error al actualizar registro";
        }
        RequestDispatcher rd;
        List<PersonasBean> registros;

        if (estado == 1) {
            registros = pdao.mostrar("habilitado");
            rd = request.getRequestDispatcher("views/Personas/mostrarPersonas.jsp");
        } else {
            registros = pdao.mostrar("deshabilitado");
            rd = request.getRequestDispatcher("views/Personas/habilitarPersonas.jsp");
        }
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);
        rd.forward(request, response);
    }
}
