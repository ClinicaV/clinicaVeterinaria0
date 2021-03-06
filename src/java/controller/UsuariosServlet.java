package controller;

import dao.Conexion;
import dao.EmpleadosDao;
import dao.NivelesDao;
import dao.UsuariosDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EmpleadosBean;
import model.UsuariosBean;
import model.NivelesBean;

/**
 *
 * @author Franklin Alexis
 */
public class UsuariosServlet extends HttpServlet {

    HttpSession session;

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
                case "listarFK":
                    listarFK(request, response);
                    break;
                case "login":
                    login(request, response);
                    break;
                case "logout":
                    logout(request, response);
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
        UsuariosDao udao = new UsuariosDao(conn);
        List<UsuariosBean> listar = udao.mostrar(estado);
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("views/Usuarios/mostrar.jsp").forward(request, response);
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        int nivel = Integer.parseInt(request.getParameter("idNivel"));
        int empleado = Integer.parseInt(request.getParameter("codEmpleado"));
        int est = 1;
        Conexion conn = new Conexion();
        UsuariosDao udao = new UsuariosDao(conn);
        UsuariosBean ubean = new UsuariosBean(0);
        ubean.setUsuario(usuario);
        ubean.setPassword(password);
        ubean.setIdNivel(nivel);
        ubean.setCodEmpleado(empleado);
        ubean.setEstadoUsuario(est);
        boolean respuesta = udao.insertar(ubean);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro guardado";
        } else {
            mensaje = "Error al guardar registro";
        }
        String estado = "habilitado";
        EmpleadosDao edao = new EmpleadosDao(conn);
        NivelesDao ndao = new NivelesDao(conn);
        List<EmpleadosBean> registrosEmp = edao.mostrar();
        List<NivelesBean> registrosNiv = ndao.mostrar(estado);
        request.setAttribute("registrosEmp", registrosEmp);
        request.setAttribute("registrosNiv", registrosNiv);
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("agregarUsuarios.jsp").forward(request, response);
    }

    protected void buscarId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int usu = Integer.parseInt(request.getParameter("idUsuario"));
        String estado = request.getParameter("estado");
        Conexion conn = new Conexion();
        UsuariosDao udao = new UsuariosDao(conn);
        List<UsuariosBean> listar = udao.buscarId(usu);

        EmpleadosDao edao = new EmpleadosDao(conn);
        NivelesDao ndao = new NivelesDao(conn);
        List<EmpleadosBean> registrosEmp = edao.mostrar();
        List<NivelesBean> registrosNiv = ndao.mostrar(estado);
        request.setAttribute("registrosEmp", registrosEmp);
        request.setAttribute("registrosNiv", registrosNiv);
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("views/Usuarios/editar.jsp").forward(request, response);
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int usu = Integer.parseInt(request.getParameter("idUsuario"));
        String password = request.getParameter("password");
        Conexion conn = new Conexion();
        int nivel = Integer.parseInt(request.getParameter("idNivel"));
        int empleado = Integer.parseInt(request.getParameter("codEmpleado"));

        UsuariosDao udao = new UsuariosDao(conn);
        UsuariosBean ubean = new UsuariosBean(usu);
        ubean.setPassword(password);
        ubean.setIdNivel(nivel);
        ubean.setCodEmpleado(empleado);

        boolean respuesta = udao.actualizar(ubean);
        String mensaje;
        if (respuesta) {
            mensaje = "Exito al Actualizar";
        } else {
            mensaje = "Error al Actualizar";
        }
        List<UsuariosBean> listar = udao.mostrar("habilitado");
        request.setAttribute("listar", listar);
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("views/Usuarios/mostrar.jsp").forward(request, response);
    }

    protected void listarFK(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String estado = request.getParameter("estado");
        Conexion conn = new Conexion();
        EmpleadosDao edao = new EmpleadosDao(conn);
        NivelesDao ndao = new NivelesDao(conn);
        List<EmpleadosBean> registrosEmp = edao.mostrar();
        List<NivelesBean> registrosNiv = ndao.mostrar(estado);
        request.setAttribute("registrosEmp", registrosEmp);
        request.setAttribute("registrosNiv", registrosNiv);
        request.getRequestDispatcher("agregarUsuarios.jsp").forward(request, response);
    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usu = request.getParameter("usu");
        String pass = request.getParameter("pass");
        Conexion conn = new Conexion();
        UsuariosDao udao = new UsuariosDao(conn);
        UsuariosBean ubean = new UsuariosBean(0);
        ubean = udao.login(usu, pass);
        String msg;
        RequestDispatcher rd;
        session = request.getSession();
        if (ubean.getIdUsuario() > 0) {

            rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);

        } else {
            msg = "Error de credenciales";
            request.setAttribute("msg", msg);

            rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
        request.setAttribute("usu", usu);
        rd = request.getRequestDispatcher("header.jsp");
        rd.forward(request, response);
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();

        if (session != null) {
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
    }

}
