package controller;

import dao.CatAnimalesDao;
import dao.Conexion;
import dao.RazasDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CatAnimalesBean;
import model.RazasBean;

/**
 *
 * @author Carlos Solis
 */
public class RazasServlet extends HttpServlet {

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
                case "listarCategorias":
                    listarCategorias(request, response);
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
        RazasDao razasd = new RazasDao(conn);
        List<RazasBean> listar = razasd.mostrar();
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("views/Razas/mostrarRazas.jsp").forward(request, response);
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String raza = request.getParameter("raza");
        String descripcion = request.getParameter("descripcion");
        int categoria = Integer.parseInt(request.getParameter("categoria"));
        Conexion conn = new Conexion();
        RazasDao razasd = new RazasDao(conn);
        RazasBean razasb = new RazasBean(0);
        razasb.setRaza(raza);
        razasb.setDescripcion(descripcion);
        razasb.setIdCatAnimal(categoria);
        boolean respuesta = razasd.insertar(razasb);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro guardado";
        } else {
            mensaje = "Error al guardar registro";
        }
        String estado = "habilitado";
        CatAnimalesDao cdao = new CatAnimalesDao(conn);
        List<CatAnimalesBean> registros = cdao.mostrar(estado);
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("agregarRazas.jsp").forward(request, response);
    }

    protected void buscarId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String estado = request.getParameter("estado");
        Conexion conn = new Conexion();
        RazasDao razasd = new RazasDao(conn);
        List<RazasBean> listar = razasd.buscarId(id);
        //listado de categorias animales
        CatAnimalesDao cdao = new CatAnimalesDao(conn);
        List<CatAnimalesBean> registros = cdao.mostrar(estado);
        request.setAttribute("registros", registros);
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("views/Razas/editarRazas.jsp").forward(request, response);
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String raza = request.getParameter("raza");
        String descripcion = request.getParameter("descripcion");
        int categoria = Integer.parseInt(request.getParameter("categoria"));
        Conexion conn = new Conexion();
        RazasDao razasd = new RazasDao(conn);
        RazasBean razasb = new RazasBean(id);
        razasb.setRaza(raza);
        razasb.setDescripcion(descripcion);
        razasb.setIdCatAnimal(categoria);
        boolean respuesta = razasd.actualizar(razasb);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro actualizado";
        } else {
            mensaje = "Error al Actualizar";
        }
        List<RazasBean> listar = razasd.mostrar();
        request.setAttribute("listar", listar);
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("views/Razas/mostrarRazas.jsp").forward(request, response);
    }

    protected void listarCategorias(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String estado = request.getParameter("estado");
        Conexion conn = new Conexion();
        CatAnimalesDao cdao = new CatAnimalesDao(conn);
        List<CatAnimalesBean> registros = cdao.mostrar(estado);
        request.setAttribute("registros", registros);
        request.getRequestDispatcher("agregarRazas.jsp").forward(request, response);
    }

}
