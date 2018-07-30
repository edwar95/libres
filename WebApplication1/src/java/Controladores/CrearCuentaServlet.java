/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import controlador.Consultas;
import enviomail.javamail.Mail;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gonzalo
 */
@WebServlet(name = "CrearCuenta", urlPatterns = {"/CrearCuenta"})
public class CrearCuentaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
       
        CrearCuentaa cuenta= new CrearCuentaa();
        cuenta.setNombre(request.getParameter("name"));
        cuenta.setApellido(request.getParameter("apellido"));
        cuenta.setCedula(request.getParameter("cedula"));
        cuenta.setCorreo(request.getParameter("correo"));
        cuenta.setPassword(request.getParameter("contrasena"));
        String confPassword=request.getParameter("confContrasena");
        
        
        System.out.print(""+request.getParameter("name"));
        System.out.print(""+cuenta.getNombre()+ cuenta.getApellido()+cuenta.getCedula()+cuenta.getCorreo()+cuenta.getPassword());
        
        
        Consultas con = new Consultas();
        Consultas con2=new Consultas();
        if(con.ingresarCuenta(cuenta.getNombre(), cuenta.getApellido(), cuenta.getCedula(), cuenta.getCorreo(), cuenta.getPassword()) && con2.registrarLogin(cuenta.getCedula(),cuenta.getPassword())){
            response.sendRedirect("iniciarSesion.xhtml");
            System.out.print("ingresa");
        }else{
            response.sendRedirect("crearCuenta.xhtml");
            System.out.print("no ingresa");
        }
        /*Mail mail=new Mail();
        mail.sendEmail(cuenta.getCorreo(),"Acceso al sistema", "Usuario: "+cuenta.getCedula()+"\nPassword: "+cuenta.getPassword());
        response.sendRedirect("iniciarSesion.xhtml");
        */
        
    }
     
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
