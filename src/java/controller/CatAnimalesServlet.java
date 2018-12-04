package controller;

import dao.CatAnimalesDao;
import dao.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CatAnimalesBean;

/**
 *
 * @author chris
 */
public class CatAnimalesServlet extends HttpServlet {

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
        CatAnimalesDao cdao = new CatAnimalesDao(conn);
        List<CatAnimalesBean> registros = cdao.mostrar(estado);
        request.setAttribute("registros", registros);
        RequestDispatcher rd;

        if (estado.equals("habilitado")) {
            rd = request.getRequestDispatcher("views/CatAnimales/mostrarCatAnimales.jsp");
        } else {
            rd = request.getRequestDispatcher("views/CatAnimales/habilitarCatAnimales.jsp");
        }
        rd.forward(request, response);
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String catani = request.getParameter("catani");
        String descripcion = request.getParameter("descripcion");
        int estado = Integer.parseInt(request.getParameter("estado"));
        Conexion conn = new Conexion();
        CatAnimalesDao cdao = new CatAnimalesDao(conn);
        CatAnimalesBean cbean = new CatAnimalesBean(0);
        cbean.setCatAnimal(catani);
        cbean.setDescripcion(descripcion);
        cbean.setEstadoCatAnimal(estado);
        boolean respuesta = cdao.insertar(cbean);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro guardado";
        } else {
            mensaje = "Error al guardar registro";
        }

        RequestDispatcher rd;
        request.setAttribute("mensaje", mensaje);
        rd = request.getRequestDispatcher("agregarCatAnimales.jsp");
        rd.forward(request, response);
    }

    protected void buscarId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idCatAnimal"));
        Conexion conn = new Conexion();
        CatAnimalesDao cdao = new CatAnimalesDao(conn);
        List<CatAnimalesBean> registros = cdao.buscarId(id);
        RequestDispatcher rd;
        request.setAttribute("registros", registros);
        rd = request.getRequestDispatcher("/views/CatAnimales/editarCatAnimales.jsp");
        rd.forward(request, response);
    }

    protected void deshabilitar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String estado = request.getParameter("estado");
        int id = Integer.parseInt(request.getParameter("idCatAnimal"));
        Conexion conn = new Conexion();
        CatAnimalesDao cdao = new CatAnimalesDao(conn);
        boolean res = cdao.deshabilitar(id, estado);
        String mensaje;
        List<CatAnimalesBean> registros;
        RequestDispatcher rd;
        if (estado.equals("habilitar")) {
            if (res) {
                mensaje = "Registro habilitado";
            } else {
                mensaje = "Error al habilitar registro";
            }
            registros = cdao.mostrar("deshabilitado");
            rd = request.getRequestDispatcher("views/CatAnimales/habilitarCatAnimales.jsp");

        } else {
            if (res) {
                mensaje = "Registro deshabilitado";
            } else {
                mensaje = "Error al deshabilitar registro";
            }
            registros = cdao.mostrar("habilitado");
            rd = request.getRequestDispatcher("views/CatAnimales/mostrarCatAnimales.jsp");
        }
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);

        rd.forward(request, response);
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int estado = Integer.parseInt(request.getParameter("estado"));
        int id = Integer.parseInt(request.getParameter("id"));
        String catani = request.getParameter("catani");
        String descripcion = request.getParameter("descripcion");
        CatAnimalesBean cbean = new CatAnimalesBean(id);
        Conexion conn = new Conexion();
        CatAnimalesDao cdao = new CatAnimalesDao(conn);
        cbean.setCatAnimal(catani);
        cbean.setDescripcion(descripcion);
        boolean res = cdao.actualizar(cbean);
        String mensaje;
        if (res) {
            mensaje = "Registro actualizado";
        } else {
            mensaje = "Error al actualizar registro";
        }
        RequestDispatcher rd;
        List<CatAnimalesBean> registros;

        if (estado == 1) {
            registros = cdao.mostrar("habilitado");
            rd = request.getRequestDispatcher("views/CatAnimales/mostrarCatAnimales.jsp");
        } else {
            registros = cdao.mostrar("deshabilitado");
            rd = request.getRequestDispatcher("views/CatAnimales/habilitarCatAnimales.jsp");
        }
        request.setAttribute("registros", registros);
        request.setAttribute("mensaje", mensaje);
        rd.forward(request, response);
    }

}
