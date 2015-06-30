/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.ProdutoDAO;
import entity.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladoraProduto", urlPatterns = {"/ControladoraProduto"})
public class ControladoraProduto extends HttpServlet {

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

        if (action.equals("inserir")) {
            String nome = request.getParameter("campoProdutoNome");
            String valor = request.getParameter("campoValor");
            String dBasic = request.getParameter("campoDescricaoBasic");
            String dTal = request.getParameter("campoDescricaoDetal");
            String imagem = request.getParameter("campoImagem");
            String promo = (request.getParameter("promo") == null) ? "n" : "s";
            String categoria = request.getParameter("campoCategoria");
            Produto produto = new Produto();
            produto.setNome(nome);
            produto.setValor(Double.parseDouble(valor));
            produto.setDescricaoBasica(dBasic);
            produto.setDescricaoDetal(dTal);
            produto.setImg(imagem);
            produto.setIdCategoria(Integer.parseInt(categoria));
            produto.setPromocional(promo.equals("s"));

            ProdutoDAO daoproduto = new ProdutoDAO();
            daoproduto.insere(produto);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin_produtos.jsp");
            rd.forward(request, response);

        } else if (action.equals("select")) {

            String id = request.getParameter("idproduto");
            int num = 0;
            num = Integer.parseInt(id);
            Produto produto = new Produto();
            ProdutoDAO dao = new ProdutoDAO();
            produto = dao.buscaProd(num);
            request.setAttribute("produto", produto);
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/admin_produto_detalhes.jsp");
            rd.forward(request, response);

        } else if (action.equals("detalhes")) {

            String id = request.getParameter("idproduto");
            int num = 0;
            num = Integer.parseInt(id);
            Produto produto = new Produto();
            ProdutoDAO dao = new ProdutoDAO();
            produto = dao.buscaProd(num);
            request.setAttribute("produto", produto);
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/detalhes_prod.jsp");
            rd.forward(request, response);

        } else if (action.equals("update")) {
            String nome = request.getParameter("campoProdutoNome");
            String valor = request.getParameter("campoValor");
            String dBasic = request.getParameter("campoDescricaoBasic");
            String dTal = request.getParameter("campoDescricaoDetal");
            String imagem = request.getParameter("campoImagem");
            String categoria = request.getParameter("campoCategoria");
            String idProd = request.getParameter("idproduto");
            String promo = (request.getParameter("promo") == null) ? "n" : "s";

            Produto produto = new Produto();
            produto.setNome(nome);
            produto.setValor(Double.parseDouble(valor));
            produto.setDescricaoBasica(dBasic);
            produto.setDescricaoDetal(dTal);
            produto.setImg(imagem);
            produto.setIdCategoria(Integer.parseInt(categoria));
            produto.setIdProduto(Integer.parseInt(idProd));
            produto.setPromocional(promo.equals("s"));

            ProdutoDAO daoproduto = new ProdutoDAO();
            daoproduto.update(produto);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin_produtos.jsp");
            rd.forward(request, response);

        } else if (action.equals("deletar")) {
            String idProd = request.getParameter("idproduto");
            ProdutoDAO daoproduto = new ProdutoDAO();
            daoproduto.deletar(Integer.parseInt(idProd));
//            response.sendRedirect("/admin_produtos.jsp");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin_produtos.jsp");
            rd.forward(request, response);

        } else if (action.equals("pesquisarindex")) {
            String pesquisa = request.getParameter("campoPesquisa");
            ProdutoDAO daoproduto = new ProdutoDAO();
            List<Produto> produtos = daoproduto.procurar(pesquisa);
            request.setAttribute("produtos", produtos);
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/admin_produtos_pesquisa.jsp");
            rd.forward(request, response);
        } else if (action.equals("pesquisar")) {
            String pesquisa = request.getParameter("campoPesquisa");
            ProdutoDAO daoproduto = new ProdutoDAO();
            List<Produto> produtos = daoproduto.procurar(pesquisa);
            request.setAttribute("produtos", produtos);
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/admin_produtos_pesquisa.jsp");
            rd.forward(request, response);
        } else {
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
