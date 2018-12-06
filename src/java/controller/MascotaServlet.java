/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import dao.Conexion;
import dao.MascotaDao;
import dao.PersonasDao;
import dao.RazasDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MascotaBean;
import model.PersonasBean;
import model.RazasBean;

/**
 *
 * @author Carlos Solis
 */
public class MascotaServlet extends HttpServlet {

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
                case "actualizar":
                    actualizar(request, response);
                    break;
                case "listarPersonaRaza":
                    listarPersonaRaza(request, response);
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
        MascotaDao mascotad = new MascotaDao(conn);
        RequestDispatcher rd;
        List<MascotaBean> listar = mascotad.mostrar(estado);
        request.setAttribute("listar", listar);

        if (estado.equals("habilitado")) {
            rd = request.getRequestDispatcher("views/Mascotas/mostrarMascotas.jsp");
        } else {
            rd = request.getRequestDispatcher("views/Mascotas/habilitar.jsp");
        }
        rd.forward(request, response);
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idRaza = Integer.parseInt(request.getParameter("idraza"));
        String mascota = request.getParameter("nombre");
        String sexo = request.getParameter("sexo");
        int idCliente = Integer.parseInt(request.getParameter("idcliente"));
        int edad = Integer.parseInt(request.getParameter("edad"));
        String tatoo = request.getParameter("tatoo");
        String alergia = request.getParameter("alergias");
        Conexion conn = new Conexion();
        MascotaDao mascotad = new MascotaDao(conn);
        MascotaBean mascotab = new MascotaBean(0);
        mascotab.setIdRaza(idRaza);
        mascotab.setNombreMascota(mascota);
        mascotab.setSexo(sexo);
        mascotab.setIdPersona(idCliente);
        mascotab.setEdad(edad);
        mascotab.setIdentificacionTatoo(tatoo);
        mascotab.setAlergias(alergia);
        mascotab.setEstadoMascota(1);

        boolean respuesta = mascotad.insertar(mascotab);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro guardado";
        } else {
            mensaje = "Error al guardar registro";
        }
        RequestDispatcher rd;
        request.setAttribute("mensaje", mensaje);
        rd = request.getRequestDispatcher("agregarMascota.jsp");
        rd.forward(request, response);
    }

    protected void buscarId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String estado = request.getParameter("estado");
        int id = Integer.parseInt(request.getParameter("idMascota"));
        Conexion conn = new Conexion();
        MascotaDao md = new MascotaDao(conn);
        List<MascotaBean> mascota = md.buscarId(id);
        request.setAttribute("mascota", mascota);
        RazasDao rdao = new RazasDao(conn);
        List<RazasBean> registros2 = rdao.mostrar();
        request.setAttribute("registros2", registros2);
        PersonasDao perd = new PersonasDao(conn);
        List<PersonasBean> registros = perd.mostrar(estado);
        request.setAttribute("registros", registros);

        RequestDispatcher rd;

        rd = request.getRequestDispatcher("views/Mascotas/editarMascotas.jsp");
        rd.forward(request, response);
    }

    protected void deshabilitar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String estado = request.getParameter("estado");
//        int id = Integer.parseInt(request.getParameter("idNivel"));
//        Conexion conn = new Conexion();
//        NivelesDao ndao = new NivelesDao(conn);
//        boolean respuesta = ndao.deshabilitar(id, estado);
//        String mensaje;
//        List<NivelesBean> registros;
//        RequestDispatcher rd;
//        if (estado.equals("habilitar")) {
//            if (respuesta) {
//                mensaje = "Registro habilitado";
//            } else {
//                mensaje = "Error al habilitar registro";
//            }
//            registros = ndao.mostrar("deshabilitado");
//            rd = request.getRequestDispatcher("views/Niveles/habilitarNiveles.jsp");
//        } else {
//            if (respuesta) {
//                mensaje = "Registro deshabilitado";
//            } else {
//                mensaje = "Error al deshabilitar registro";
//            }
//            registros = ndao.mostrar("habilitado");
//            rd = request.getRequestDispatcher("views/Niveles/mostrarNiveles.jsp");
//        }
//        request.setAttribute("registros", registros);
//        request.setAttribute("mensaje", mensaje);
//        rd.forward(request, response);

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String estado = "hablitado";
        int id = Integer.parseInt(request.getParameter("id"));
        int idRaza = Integer.parseInt(request.getParameter("idraza"));
        String mascota = request.getParameter("nombre");
        String sexo = request.getParameter("sexo");
        int idCliente = Integer.parseInt(request.getParameter("idcliente"));
        int edad = Integer.parseInt(request.getParameter("edad"));
        String tatoo = request.getParameter("tatoo");
        String alergia = request.getParameter("alergias");
        Conexion conn = new Conexion();
        MascotaDao mascotad = new MascotaDao(conn);
        MascotaBean mascotab = new MascotaBean(id);
        mascotab.setIdRaza(idRaza);
        mascotab.setNombreMascota(mascota);
        mascotab.setSexo(sexo);
        mascotab.setIdPersona(idCliente);
        mascotab.setEdad(edad);
        mascotab.setIdentificacionTatoo(tatoo);
        mascotab.setAlergias(alergia);

        boolean respuesta = mascotad.actualizar(mascotab);
        String mensaje;
        if (respuesta) {
            mensaje = "Registro actualizado";
        } else {
            mensaje = "Error al actualizar registro";
        }
        List<MascotaBean> listar = mascotad.mostrar(estado);
        RequestDispatcher rd;
        request.setAttribute("listar", listar);
        request.setAttribute("mensaje", mensaje);
        rd = request.getRequestDispatcher("views/Mascotas/mostrarMascotas.jsp");
        rd.forward(request, response);
    }

    protected void listarRaza(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String estado = request.getParameter("estado");
        Conexion conn = new Conexion();
        RazasDao rd = new RazasDao(conn);
        List<RazasBean> registros = rd.mostrar();
        request.setAttribute("registros2", registros);
        request.getRequestDispatcher("agregarMascota.jsp").forward(request, response);
    }

    protected void listarPersonaRaza(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String estado = request.getParameter("estado");
        Conexion conn = new Conexion();
        RazasDao rd = new RazasDao(conn);
        PersonasDao perd = new PersonasDao(conn);
        List<PersonasBean> registros = perd.mostrar(estado);
        List<RazasBean> registros2 = rd.mostrar();
        request.setAttribute("registros2", registros2);
        request.setAttribute("registros", registros);
        request.getRequestDispatcher("agregarMascota.jsp").forward(request, response);
    }

}
