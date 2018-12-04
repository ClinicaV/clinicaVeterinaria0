package controller;

import dao.ServiciosDao;
import dao.Conexion;
import dao.TratamientosDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ServiciosBean;
import model.TratamientosBean;

/**
 *
 * @author Franklin Alexis
 */
public class TratamientosServlet extends HttpServlet {

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
                case "listarServicios":
                    listarServicios(request, response);
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
        TratamientosDao tdao = new TratamientosDao(conn);
        List<TratamientosBean> listar = tdao.mostrar();
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("views/Tratamientos/mostrar.jsp").forward(request, response);
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tratamiento = request.getParameter("tratamiento");
        int servicio = Integer.parseInt(request.getParameter("idCatTratamiento"));
        double precio = Double.parseDouble(request.getParameter("precio"));
        Conexion conn = new Conexion();
        TratamientosDao tdao = new TratamientosDao(conn);
        TratamientosBean tbean = new TratamientosBean(0);
        tbean.setTratamiento(tratamiento);
        tbean.setIdCatTratamiento(servicio);
        tbean.setPrecio(precio);
        boolean respuesta = tdao.insertar(tbean);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro guardado";
        } else {
            mensaje = "Error al guardar registro";
        }
        String estado = "habilitado";
        ServiciosDao sdao = new ServiciosDao(conn);
        List<ServiciosBean> registros = sdao.mostrar(estado);
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("agregarTratamientos.jsp").forward(request, response);
    }

    protected void buscarId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String estado = request.getParameter("estado");
        Conexion conn = new Conexion();
        TratamientosDao tdao = new TratamientosDao(conn);
        List<TratamientosBean> listar = tdao.buscarId(id);
        //listado de categorias animales
        ServiciosDao sdao = new ServiciosDao(conn);
        List<ServiciosBean> registros = sdao.mostrar(estado);
        request.setAttribute("registros", registros);
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("views/Tratamientos/editar.jsp").forward(request, response);
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tratamiento = request.getParameter("tratamiento");
        int servicio = Integer.parseInt(request.getParameter("idCatTratamiento"));
        double precio = Double.parseDouble(request.getParameter("precio"));
        Conexion conn = new Conexion();
        TratamientosDao tdao = new TratamientosDao(conn);
        TratamientosBean tbean = new TratamientosBean(id);
        tbean.setTratamiento(tratamiento);
        tbean.setIdCatTratamiento(servicio);
        tbean.setPrecio(precio);
        boolean respuesta = tdao.actualizar(tbean);
        String mensaje;
        if (respuesta) {
            mensaje = "Exito al Actualizar";
        } else {
            mensaje = "Error al Actualizar";
        }
        List<TratamientosBean> listar = tdao.mostrar();
        request.setAttribute("listar", listar);
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("views/Tratamientos/mostrar.jsp").forward(request, response);
    }

    protected void listarServicios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String estado = request.getParameter("estado");
        Conexion conn = new Conexion();
        ServiciosDao sdao = new ServiciosDao(conn);
        List<ServiciosBean> registros = sdao.mostrar(estado);
        request.setAttribute("registros2", registros);
        request.getRequestDispatcher("agregarTratamientos.jsp").forward(request, response);
    }
    
}

