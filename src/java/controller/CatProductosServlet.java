package controller;

import dao.CatProductosDao;
import dao.Conexion;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CatProductosBean;

/**
 *
 * @author chris
 */
public class CatProductosServlet extends HttpServlet {

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
        CatProductosDao cdao = new CatProductosDao(conn);
        List<CatProductosBean> registros = cdao.mostrar(estado);
        request.setAttribute("registros", registros);
        RequestDispatcher rd;

        if (estado.equals("habilitado")) {
            rd = request.getRequestDispatcher("views/CatProductos/mostrarCatProductos.jsp");
        } else {
            rd = request.getRequestDispatcher("views/CatProductos/habilitarCatProductos.jsp");
        }
        rd.forward(request, response);

    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String catpro = request.getParameter("catpro");
        String descripcion = request.getParameter("descripcion");
        int estado = Integer.parseInt(request.getParameter("estado"));
        Conexion conn = new Conexion();
        CatProductosDao cdao = new CatProductosDao(conn);
        CatProductosBean cbean = new CatProductosBean(0);
        cbean.setCategoriaProducto(catpro);
        cbean.setDescripcion(descripcion);
        cbean.setEstadoCatProducto(estado);
        boolean respuesta = cdao.insertar(cbean);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro guardado";
        } else {
            mensaje = "Error al guardar registro";
        }

        RequestDispatcher rd;
        request.setAttribute("mensaje", mensaje);
        rd = request.getRequestDispatcher("agregarCatProductos.jsp");
        rd.forward(request, response);
    }

    protected void buscarId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idCatProducto"));
        Conexion conn = new Conexion();
        CatProductosDao cdao = new CatProductosDao(conn);
        List<CatProductosBean> registros = cdao.buscarId(id);
        RequestDispatcher rd;
        request.setAttribute("registros", registros);
        rd = request.getRequestDispatcher("/views/CatProductos/editarCatProductos.jsp");
        rd.forward(request, response);
    }

    protected void deshabilitar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String estado = request.getParameter("estado");
        int id = Integer.parseInt(request.getParameter("idCatProducto"));
        Conexion conn = new Conexion();
        CatProductosDao cdao = new CatProductosDao(conn);
        boolean res = cdao.deshabilitar(id, estado);
        String mensaje;
        List<CatProductosBean> registros;
        RequestDispatcher rd;
        if (estado.equals("habilitar")) {
            if (res) {
                mensaje = "Registro habilitado";
            } else {
                mensaje = "Error al habilitar registro";
            }
            registros = cdao.mostrar("deshabilitado");
            rd = request.getRequestDispatcher("views/CatProductos/habilitarCatProductos.jsp");

        } else {
            if (res) {
                mensaje = "Registro deshabilitado";
            } else {
                mensaje = "Error al deshabilitar registro";
            }
            registros = cdao.mostrar("habilitado");
            rd = request.getRequestDispatcher("views/CatProductos/mostrarCatProductos.jsp");
        }
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);

        rd.forward(request, response);
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int estado = Integer.parseInt(request.getParameter("estado"));
        int id = Integer.parseInt(request.getParameter("id"));
        String catpro = request.getParameter("catpro");
        String descripcion = request.getParameter("descripcion");
        CatProductosBean cbean = new CatProductosBean(id);
        Conexion conn = new Conexion();
        CatProductosDao cdao = new CatProductosDao(conn);
        cbean.setCategoriaProducto(catpro);
        cbean.setDescripcion(descripcion);
        boolean res = cdao.actualizar(cbean);
        String mensaje;
        if (res) {
            mensaje = "Registro actualizado";
        } else {
            mensaje = "Error al actualizar registro";
        }
        RequestDispatcher rd;
        List<CatProductosBean> registros;

        if (estado == 1) {
            registros = cdao.mostrar("habilitado");
            rd = request.getRequestDispatcher("views/CatProductos/mostrarCatProductos.jsp");
        } else {
            registros = cdao.mostrar("deshabilitado");
            rd = request.getRequestDispatcher("views/CatProductos/habilitarCatProductos.jsp");
        }
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);
        rd.forward(request, response);
    }

}
