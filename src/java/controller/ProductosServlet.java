package controller;

import dao.CatProductosDao;
import dao.Conexion;
import dao.ProductosDao;
import dao.UnidadesDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CatProductosBean;
import model.ProductosBean;
import model.UnidadesBean;

/**
 *
 * @author Franklin Alexis
 */
public class ProductosServlet extends HttpServlet {

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
                    //listarUnidades(request, response);
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
        ProductosDao pdao = new ProductosDao(conn);
        List<ProductosBean> listar = pdao.mostrar(estado);
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("views/Productos/mostrar.jsp").forward(request, response);
    }

     protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String producto = request.getParameter("producto");
        int categoria = Integer.parseInt(request.getParameter("idCatProducto"));
        int unidad = Integer.parseInt(request.getParameter("idUnidadMedicion"));
        double stock = Double.parseDouble(request.getParameter("stock"));
        Conexion conn = new Conexion();
        ProductosDao pdao = new ProductosDao(conn);
        ProductosBean pbean = new ProductosBean(0);
        pbean.setProducto(producto);
        pbean.setIdCategoria(categoria);
        pbean.setIdUnidad(unidad);
        pbean.setStock(stock);
        pbean.setEstadoProducto(1);
        boolean respuesta = pdao.insertar(pbean);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro guardado";
        } else {
            mensaje = "Error al guardar registro";
        }
        String estado = "habilitado";
        UnidadesDao udao = new UnidadesDao(conn);
        CatProductosDao cpdao = new CatProductosDao(conn);
        List<UnidadesBean> registrosUni = udao.mostrar(estado);
        List<CatProductosBean> registrosCat = cpdao.mostrar(estado);
        request.setAttribute("registrosUni", registrosUni);
        request.setAttribute("registrosCat", registrosCat);
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("agregarProductos.jsp").forward(request, response);
    }

    protected void buscarId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String estado = request.getParameter("estado");
        Conexion conn = new Conexion();
        ProductosDao pdao = new ProductosDao(conn);
        List<ProductosBean> listar = pdao.buscarId(id);
        //listado de categorias animales
        UnidadesDao udao = new UnidadesDao(conn);
        CatProductosDao cpdao = new CatProductosDao(conn);
        List<UnidadesBean> registrosUni = udao.mostrar(estado);
        List<CatProductosBean> registrosCat = cpdao.mostrar(estado);
        request.setAttribute("registrosUni", registrosUni);
        request.setAttribute("registrosCat", registrosCat);
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("views/Productos/editar.jsp").forward(request, response);
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String producto = request.getParameter("producto");
        Conexion conn = new Conexion();
        int categoria = Integer.parseInt(request.getParameter("categoria"));
        int unidad = Integer.parseInt(request.getParameter("unidad"));
        double stock = Double.parseDouble(request.getParameter("stock"));
        ProductosDao pdao = new ProductosDao(conn);
        ProductosBean pbean = new ProductosBean(id);
        pbean.setProducto(producto);
        pbean.setIdCategoria(categoria);
        pbean.setIdUnidad(unidad);
        pbean.setStock(stock);
        boolean respuesta = pdao.actualizar(pbean);
        String mensaje;
        if (respuesta) {
            mensaje = "Exito al Actualizar";
        } else {
            mensaje = "Error al Actualizar";
        }
        List<ProductosBean> listar = pdao.mostrar("habilitado");
        request.setAttribute("listar", listar);
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("views/Productos/mostrar.jsp").forward(request, response);
    }

    protected void listarFK(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String estado = request.getParameter("estado");
        Conexion conn = new Conexion();
        CatProductosDao cpdao = new CatProductosDao(conn);
        UnidadesDao udao = new UnidadesDao(conn);
        List<UnidadesBean> registrosUni = udao.mostrar(estado);
        List<CatProductosBean> registrosCat = cpdao.mostrar(estado);
        request.setAttribute("registrosUni", registrosUni);
        request.setAttribute("registrosCat", registrosCat);
        request.getRequestDispatcher("agregarProductos.jsp").forward(request, response);
    }
    
}
