/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.ClienteDAO;
import entity.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tiago
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException{
        String action = request.getParameter("action");
        if (action.equals("login")) {
            String login = request.getParameter("campoLogin");
            String senha = request.getParameter("campoSenha");
            ClienteDAO daocliente = new ClienteDAO();
            Cliente cliente = new Cliente();
            cliente = daocliente.login(login, senha);                        
            if (login.equals(cliente.getLogin()) && senha.equals(cliente.getSenha())) {
//                cliente.setPedido();                   
//                cliente.setProdutos();
                HttpSession session = request.getSession();
                session.setAttribute("user", cliente);
                //request.setAttribute("sessao", session);
                if("admin".equals(cliente.getTipo())) {
                    cliente.setPedido();
                    int ped = cliente.getPedido();
                    if(ped != 0) cliente.setProdutos();
                    RequestDispatcher rd1 = request.getServletContext().getRequestDispatcher("/adm.jsp");
                    rd1.forward(request, response);
                }
                else if("user".equals(cliente.getTipo())){
                    cliente.setPedido();
                    int ped = cliente.getPedido();
                    if(ped != 0) cliente.setProdutos();
                    RequestDispatcher rd2 = request.getServletContext().getRequestDispatcher("/index.jsp");
                    rd2.forward(request, response);
                }                
            } else {
                RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/cadastro.jsp");
                rd.forward(request, response);
            }
        } else if (action.equals("logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
