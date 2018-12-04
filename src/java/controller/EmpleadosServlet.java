package controller;

import dao.Conexion;
import dao.EmpleadosDao;
import dao.RolesDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EmpleadosBean;
import model.RolesBean;

/**
 *
 * @author Franklin Alexis
 */
public class EmpleadosServlet extends HttpServlet {

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
                case "actualizar":
                    actualizar(request, response);
                    break;
                case "listarRoles":
                    listarRoles(request, response);
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
        Conexion conn = new Conexion();
        EmpleadosDao empd = new EmpleadosDao(conn);
        List<EmpleadosBean> listar = empd.mostrar();
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("views/Empleados/mostrar.jsp").forward(request, response);
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");
        String genero = request.getParameter("genero");
        int rol = Integer.parseInt(request.getParameter("idRol"));
        String nit = request.getParameter("nit");
        String dui = request.getParameter("dui");
        Conexion conn = new Conexion();
        EmpleadosDao empd = new EmpleadosDao(conn);
        EmpleadosBean empb = new EmpleadosBean(0);
        empb.setIdPersona(0);
        empb.setNombres(nombres);
        empb.setApellidos(apellidos);
        empb.setTelefono(telefono);
        empb.setGenero(genero);
        empb.setIdRol(rol);
        empb.setEstadoPersona(1);
        empb.setEstadoEmpleado(1);
        empb.setTipo(1);
        empb.setNit(nit);
        empb.setDui(dui);
        boolean respuesta = empd.insertar(empb);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro guardado";
        } else {
            mensaje = "Error al guardar registro";
        }
        String estado = "habilitado";
        RolesDao rolesd = new RolesDao(conn);
        List<RolesBean> registros = rolesd.mostrar(estado);
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("agregarEmpleados.jsp").forward(request, response);
    }

    protected void buscarId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String estado = request.getParameter("estado");
        Conexion conn = new Conexion();
        EmpleadosDao empd = new EmpleadosDao(conn);
        List<EmpleadosBean> listar = empd.buscarId(id);
        //listado de categorias animales
        RolesDao rdao = new RolesDao(conn);
        List<RolesBean> registros = rdao.mostrar(estado);
        request.setAttribute("registros", registros);
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("views/Empleados/editar.jsp").forward(request, response);
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String telefono = request.getParameter("telefono");
        String genero = request.getParameter("genero");
        int rol = Integer.parseInt(request.getParameter("idRol"));
        String nit = request.getParameter("nit");
        String dui = request.getParameter("dui");
        Conexion conn = new Conexion();
        EmpleadosDao empd = new EmpleadosDao(conn);
        EmpleadosBean empb = new EmpleadosBean(id);
        
        empb.setNombres(nombres);
        empb.setApellidos(apellidos);
        empb.setTelefono(telefono);
        empb.setGenero(genero);
        empb.setIdRol(rol);
        empb.setNit(nit);
        empb.setDui(dui);
        boolean respuesta = empd.actualizar(empb);
        String mensaje;
        if (respuesta) {
            mensaje = "Exito al Actualizar";
        } else {
            mensaje = "Error al Actualizar";
        }
        List<EmpleadosBean> listar = empd.mostrar();
        request.setAttribute("listar", listar);
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("views/Empleados/mostrar.jsp").forward(request, response);
    }

    protected void listarRoles(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String estado = request.getParameter("estado");
        Conexion conn = new Conexion();
        RolesDao rdao = new RolesDao(conn);
        List<RolesBean> registros = rdao.mostrar(estado);
        request.setAttribute("registros", registros);
        request.getRequestDispatcher("agregarEmpleados.jsp").forward(request, response);
    }
    
}
