package controller;

import dao.Conexion;
import dao.ProveedoresDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProveedoresBean;

/**
 *
 * @author chris
 */
public class ProveedoresServlet extends HttpServlet {

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
        ProveedoresDao pdao = new ProveedoresDao(conn);
        List<ProveedoresBean> registros = pdao.mostrar(estado);
        RequestDispatcher rd;
        request.setAttribute("registros", registros);

        if (estado.equals("habilitado")) {
            rd = request.getRequestDispatcher("views/Proveedores/mostrarProveedores.jsp");
        } else {
            rd = request.getRequestDispatcher("views/Proveedores/habilitarProveedores.jsp");
        }
        rd.forward(request, response);
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String proveedor = request.getParameter("proveedor");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String direccion = request.getParameter("direccion");
        String contacto = request.getParameter("contacto");
        int estado = Integer.parseInt(request.getParameter("estado"));
        Conexion conn = new Conexion();
        ProveedoresDao pdao = new ProveedoresDao(conn);
        ProveedoresBean pbean = new ProveedoresBean(0);
        pbean.setProveedor(proveedor);
        pbean.setDireccion(direccion);
        pbean.setEmail(email);
        pbean.setTelefono(telefono);
        pbean.setPersonaContacto(contacto);
        pbean.setEstadoProveedor(estado);
        boolean respuesta = pdao.insetar(pbean);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro guardado";
        } else {
            mensaje = "Error al guardar registro";
        }
        RequestDispatcher rd;
        request.setAttribute("mensaje", mensaje);
        rd = request.getRequestDispatcher("agregarProveedores.jsp");
        rd.forward(request, response);

    }

    protected void buscarId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idProveedor"));
        Conexion conn = new Conexion();
        ProveedoresDao pdao = new ProveedoresDao(conn);
        List<ProveedoresBean> registros = pdao.buscarId(id);
        RequestDispatcher rd;
        request.setAttribute("registros", registros);
        rd = request.getRequestDispatcher("views/Proveedores/editarProveedores.jsp");
        rd.forward(request, response);

    }

    protected void deshabilitar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String estado = request.getParameter("estado");
        int id = Integer.parseInt(request.getParameter("idProveedor"));
        Conexion conn = new Conexion();
        ProveedoresDao pdao = new ProveedoresDao(conn);
        boolean respuesta = pdao.deshabilitar(id, estado);
        String mensaje;
        List<ProveedoresBean> registros;
        RequestDispatcher rd;
        if (estado.equals("habilitar")) {
            if (respuesta) {
                mensaje = "Registro habilitado";
            } else {
                mensaje = "Error al habilitar registro";
            }
            registros = pdao.mostrar("deshabilitado");
            rd = request.getRequestDispatcher("views/Proveedores/habilitarProveedores.jsp");

        } else {
            if (respuesta) {
                mensaje = "Registro deshabilitado";
            } else {
                mensaje = "Error al deshabilitar registro";
            }
            registros = pdao.mostrar("habilitado");
            rd = request.getRequestDispatcher("views/Proveedores/mostrarProveedores.jsp");

        }

        request.setAttribute("mensaje", mensaje);
        request.setAttribute("registros", registros);
        rd.forward(request, response);

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int estado = Integer.parseInt(request.getParameter("estado"));
        int id = Integer.parseInt(request.getParameter("id"));
        String proveedor = request.getParameter("proveedor");
        String telefono = request.getParameter("telefono");
        String email = request.getParameter("email");
        String direccion = request.getParameter("direccion");
        String contacto = request.getParameter("contacto");
        Conexion conn = new Conexion();
        ProveedoresDao pdao = new ProveedoresDao(conn);
        ProveedoresBean pbean = new ProveedoresBean(id);
        pbean.setProveedor(proveedor);
        pbean.setTelefono(telefono);
        pbean.setEmail(email);
        pbean.setDireccion(direccion);
        pbean.setPersonaContacto(contacto);
        boolean respuesta = pdao.actualizar(pbean);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro actualizado";
        } else {
            mensaje = "Error al actualizar registro";
        }
        List<ProveedoresBean> registros;
        RequestDispatcher rd;

        if (estado == 1) {
            registros = pdao.mostrar("habilitado");
            rd = request.getRequestDispatcher("views/Proveedores/mostrarProveedores.jsp");
        } else {
            registros = pdao.mostrar("deshabilitado");
            rd = request.getRequestDispatcher("views/Proveedores/habilitarProveedores.jsp");
        }
        request.setAttribute("mensaje", mensaje);
        request.setAttribute("registros", registros);
        rd.forward(request, response);
    }

}
