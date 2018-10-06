/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.agenda.controller;

import br.senac.agenda.model.Contato;
import br.senac.agenda.model.ContatoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sala304b
 */
public class ListarContatoServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
            ContatoDao contatoDao = new ContatoDao();

            List<Contato> contatos = contatoDao.listar();
                       
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Agenda de Contatos</title>");            
            out.println("</head>");
            out.println("<body>");
            
               
            out.println("<h1>Lista de Contatos</h1>");
            
            out.println("<fieldset>");
            out.println("<a href='NovoCotatoServlet'>Cadastrar novo contato</a>");
            out.println("</fieldset>");
            
            
            out.println("<fieldset>");
            if(!contatos.isEmpty()){
                
                out.println("<table border='1' width='100%'>");
                out.println("<thead><tr><th width='50'>ID</th><th width='300'>Nome</th><th width='100'>Telefone</th><th width='60' colspan='2'></th></tr></thead>");
                
                    
                    for(Contato c: contatos){
                    out.println("<tbody>"
                            + "<tr><td>"
                            + c.getId() 
                            + "</td><td>" 
                            + c.getNome() 
                            + "</td><td>" 
                            + c.getTelefone() 
                            + "</td>"
                            + "<td><a href='EditarContatoServlet?contatoId='" +c.getId()+"</a> | <a href='EditarContatoServlet?contatoId='" +c.getId()+"</a></td>"
                            + "</tr></tbody>");
                }
                out.println("</table>");
                
            } else {
                out.println("<p>Lista vazia</p>");
            }
            
            out.println("</fieldset>");
            out.println("</body>");
            out.println("</html>");
        }
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
