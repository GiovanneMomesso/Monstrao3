/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.CategoriaDAO;
import entity.Categoria;
import java.io.IOException;
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

@WebServlet(name = "ControladoraCategoria", urlPatterns = {"/ControladoraCategoria"})
public class ControladoraCategoria extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        if (action.equals("incluir")) {

            String nome = request.getParameter("nome_cat");
            CategoriaDAO categoriaDAO = new CategoriaDAO();

            boolean ok = categoriaDAO.categoriaIgual(nome);

            if (ok) {
                Categoria categoria = new Categoria();
                categoria.setNome(nome);

                categoriaDAO.insere(categoria);
                
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin_categoria.jsp");
                rd.forward(request, response);
            } else {
                String msg = "Categoria já cadastrada!";
                request.setAttribute("erro", msg);
                request.getRequestDispatcher("/admin_categoria_nova.jsp").forward(request, response);
            }                        
            
            

        } else if (action.equals("mostraralterar")) {

            String id = request.getParameter("id");
            int num = 0;
            num = Integer.parseInt(id);
            Categoria categoria = new Categoria();
            CategoriaDAO dao = new CategoriaDAO();
            categoria = dao.buscaCat(num);
            request.setAttribute("categoria", categoria);
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/admin_categoria_altera.jsp");
            rd.forward(request, response);
        } else if (action.equals("alterar")) {
            String id = request.getParameter("id");
            String nome = request.getParameter("nome_cat");

            int num = 0;
            num = Integer.parseInt(id);
            Categoria categoria = new Categoria();
            categoria.setIdCategoria(num);
            categoria.setNome(nome);
            CategoriaDAO dao = new CategoriaDAO();
            dao.altera(categoria);
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/admin_categoria.jsp");
            rd.forward(request, response);

        } else if (action.equals("deletar")) {

            int idcat = Integer.parseInt(request.getParameter("id"));

            Categoria categoria = new Categoria();
            categoria.setIdCategoria(idcat);

            CategoriaDAO categoriaDAO = new CategoriaDAO();
            categoriaDAO.excluir(categoria);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin_categoria.jsp");
            rd.forward(request, response);
        } else if (action.equals("pesquisar")) {
            String pesquisa = request.getParameter("busca_cat");
            CategoriaDAO daocategoria = new CategoriaDAO();
            List<Categoria> categoria = daocategoria.procurar(pesquisa);
            request.setAttribute("categoria", categoria);
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/admin_categoria_pesquisa.jsp");
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
