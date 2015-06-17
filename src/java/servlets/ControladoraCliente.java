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
import java.util.List;
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
@WebServlet(name = "ControladoraCliente", urlPatterns = {"/ControladoraCliente"})
public class ControladoraCliente extends HttpServlet {

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
            throws ServletException, IOException, SQLException {

        String action = request.getParameter("action");

        if (action.equals("inserir")) {

            ClienteDAO dao = new ClienteDAO();

            String login = request.getParameter("login");
            boolean ok = dao.verificaLogin(login);

            if (ok) {
                String nome = request.getParameter("nome");
                String cpf = request.getParameter("campoCpf");
                String email = request.getParameter("email");
                String campoCep = request.getParameter("campoCep");
                String senha = request.getParameter("senha");
                String endereco = request.getParameter("end");
                String news = (request.getParameter("news") == null) ? "n" : "s";

                Cliente cliente = new Cliente();
                cliente.setNome(nome);
                cliente.setCpf(cpf);
                cliente.setEmail(email);
                cliente.setCep(campoCep);
                cliente.setLogin(login);
                cliente.setSenha(senha);
                cliente.setEndereco(endereco);
                cliente.setNews(news.equals("s"));

                dao.insere(cliente);
            }

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);

        } else if (action.equals("alterar")) {

            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("campoCpf");
            String email = request.getParameter("email");
            String campoCep = request.getParameter("campoCep");
            String endereco = request.getParameter("end");
            String news = (request.getParameter("news") == null) ? "n" : "s";

            int num = 0;
            num = Integer.parseInt(id);
            Cliente cliente = new Cliente();
            cliente.setIdUsuario(num);
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setEmail(email);
            cliente.setCep(campoCep);
            cliente.setEndereco(endereco);
            cliente.setNews(news.equals("s"));
            ClienteDAO dao = new ClienteDAO();
            dao.altera(cliente);
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/admin_clientes.jsp");
            rd.forward(request, response);

        } else if (action.equals("visualizar")) {

            String id = request.getParameter("id");
            int num = 0;
            num = Integer.parseInt(id);
            Cliente cliente = new Cliente();
            ClienteDAO dao = new ClienteDAO();
            cliente = dao.buscar_cliente(num);
            request.setAttribute("cliente", cliente);
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/detalhes_cliente.jsp");
            rd.forward(request, response);

        } else if (action.equals("deletar")) {
            int id = Integer.parseInt(request.getParameter("id"));

            Cliente cliente = new Cliente();
            cliente.setIdUsuario(id);

            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.excluir(cliente);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin_clientes.jsp");
            rd.forward(request, response);

        } else if (action.equals("pesquisar")) {
            String pesquisa = request.getParameter("busca_cliente");
            ClienteDAO daocliente = new ClienteDAO();
            List<Cliente> cliente = daocliente.procurar(pesquisa);
            request.setAttribute("cliente", cliente);
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/admin_cliente_pesquisa.jsp");
            rd.forward(request, response);
        } 
        else if (action.equals("atualizar")) {
            
            HttpSession session = request.getSession();
            Cliente client = new Cliente();
            client = (Cliente)session.getAttribute("user");
             int id = client.getIdUsuario();
            String nome = request.getParameter("campoNome");
            String cpf = request.getParameter("campoCpf");
            String email = request.getParameter("campoEmail");
            String campoCep = request.getParameter("campoCep");
            String endereco = request.getParameter("campoEndereco");
            String news = (request.getParameter("campoNews")== null) ? "n" : "s";            
             
           
            Cliente cliente = new Cliente();
            cliente.setIdUsuario(id);
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setEmail(email);
            cliente.setCep(campoCep);
            cliente.setEndereco(endereco);
            cliente.setNews(news.equals("s"));
            ClienteDAO dao = new ClienteDAO();
            dao.altera(cliente);
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);            
            
        }   else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/adm.jsp");
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
            Logger.getLogger(ControladoraProduto.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControladoraProduto.class.getName()).log(Level.SEVERE, null, ex);
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
