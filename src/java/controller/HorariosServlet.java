package controller;

import java.io.IOException;
import java.io.PrintWriter;
import dao.Conexion;
import dao.HorariosDao;
import dao.ServiciosDao;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HorariosBean;
import model.ServiciosBean;

/**
 *
 * @author Franklin Alexis
 */
public class HorariosServlet extends HttpServlet {

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
        HorariosDao hdao = new HorariosDao(conn);
        List<HorariosBean> listar = hdao.mostrar();
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("views/Horarios/mostrar.jsp").forward(request, response);
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String hinicio = request.getParameter("horaInicio");
        String hfin = request.getParameter("horaFin");
        int tratamiento = Integer.parseInt(request.getParameter("idCatTratamiento"));
        Conexion conn = new Conexion();
        HorariosDao hdao = new HorariosDao(conn);
        HorariosBean hbean = new HorariosBean(0);
        hbean.setHoraInicio(hinicio);
        hbean.setHoraFin(hfin);
        hbean.setIdCatTratamiento(tratamiento);
        boolean respuesta = hdao.insertar(hbean);
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
        request.getRequestDispatcher("agregarHorarios.jsp").forward(request, response);
    }

    protected void buscarId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String estado = request.getParameter("estado");
        Conexion conn = new Conexion();
        HorariosDao hdao = new HorariosDao(conn);
        List<HorariosBean> listar = hdao.buscarId(id);
        //listado de categorias animales
        ServiciosDao sdao = new ServiciosDao(conn);
        List<ServiciosBean> registros = sdao.mostrar(estado);
        request.setAttribute("registros", registros);
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("views/Horarios/editar.jsp").forward(request, response);
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idHorario"));
        String horai = request.getParameter("horaInicio");
        String horaf = request.getParameter("horaFin");
        int categoria = Integer.parseInt(request.getParameter("idCatTratamiento"));
        Conexion conn = new Conexion();
        HorariosDao hdao = new HorariosDao(conn);
        HorariosBean hbean = new HorariosBean(id);
        hbean.setHoraInicio(horai);
        hbean.setHoraFin(horaf);
        hbean.setIdCatTratamiento(categoria);
        boolean respuesta = hdao.actualizar(hbean);
        String mensaje;
        if (respuesta) {
            mensaje = "Exito al Actualizar";
        } else {
            mensaje = "Error al Actualizar";
        }
        List<HorariosBean> listar = hdao.mostrar();
        request.setAttribute("listar", listar);
        request.setAttribute("mensaje", mensaje);
        request.getRequestDispatcher("views/Horarios/mostrar.jsp").forward(request, response);
    }

    protected void listarServicios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String estado = request.getParameter("estado");
        Conexion conn = new Conexion();
        ServiciosDao sdao = new ServiciosDao(conn);
        List<ServiciosBean> registros = sdao.mostrar(estado);
        request.setAttribute("registros", registros);
        request.getRequestDispatcher("agregarHorarios.jsp").forward(request, response);
    }
    
}
