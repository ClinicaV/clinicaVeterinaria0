package controller;

import dao.ProductosDao;
import dao.Conexion;
import dao.InventarioDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProductosBean;
import model.InventarioBean;

/**
 *
 * @author Franklin Alexis
 */
public class InventarioServlet extends HttpServlet {

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
                case "listarProductos":
                    listarProductos(request, response);
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
        InventarioDao idao = new InventarioDao(conn);
        List<InventarioBean> listar = idao.mostrar();
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("views/Inventario/mostrar.jsp").forward(request, response);
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int prod = Integer.parseInt(request.getParameter("idProducto"));
        double cantidad = Double.parseDouble(request.getParameter("cantidad"));
        double cunitario = Double.parseDouble(request.getParameter("costoUnitario"));
        double ctotal = cantidad*cunitario;
        Conexion conn = new Conexion();
        InventarioDao idao = new InventarioDao(conn);
        InventarioBean ibean = new InventarioBean(prod);
        ibean.setCantidad(cantidad);
        ibean.setCostoUnitario(cunitario);
        ibean.setCostoTotal(ctotal);
        boolean respuesta = idao.insertar(ibean);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro guardado";
        } else {
            mensaje = "Error al guardar registro";
        }
        String estado = "habilitado";
        ProductosDao pdao = new ProductosDao(conn);
        List<ProductosBean> registros = pdao.mostrar(estado);
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("agregarInventario.jsp").forward(request, response);
    }

    protected void buscarId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String estado = request.getParameter("estado");
        Conexion conn = new Conexion();
        InventarioDao idao = new InventarioDao(conn);
        List<InventarioBean> listar = idao.buscarId(id);
        //listado de categorias animales
        ProductosDao pdao = new ProductosDao(conn);
        //List<ProductosBean> registros = pdao.mostrar(estado);
       // request.setAttribute("registros", registros);
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("views/Inventario/editar.jsp").forward(request, response);
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        double cantidad = Double.parseDouble(request.getParameter("cantidad"));
        double cunitario = Double.parseDouble(request.getParameter("costoUnitario"));
        double ctotal = cantidad*cunitario;
        Conexion conn = new Conexion();
        InventarioDao idao = new InventarioDao(conn);
        InventarioBean ibean = new InventarioBean(id);
        ibean.setCantidad(cantidad);
        ibean.setCostoUnitario(cunitario);
        ibean.setCostoTotal(ctotal);
        boolean respuesta = idao.actualizar(ibean);
        String mensaje;
        if (respuesta) {
            mensaje = "Exito al Actualizar";
        } else {
            mensaje = "Error al Actualizar";
        }
        List<InventarioBean> listar = idao.mostrar();
        request.setAttribute("listar", listar);
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("views/Inventario/mostrar.jsp").forward(request, response);
    }

    protected void listarProductos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String estado = request.getParameter("estado");
        Conexion conn = new Conexion();
        ProductosDao pdao = new ProductosDao(conn);
        List<ProductosBean> registros = pdao.mostrar(estado);
        request.setAttribute("registros", registros);
        request.getRequestDispatcher("agregarInventario.jsp").forward(request, response);
    }
    
    
}
