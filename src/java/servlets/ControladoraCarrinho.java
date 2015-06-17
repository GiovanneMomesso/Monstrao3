/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dao.CarrinhoDAO;
import dao.ClienteDAO;
import dao.ProdutoDAO;
import entity.Cliente;
import entity.Pedido;
import entity.Produto;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 * @author Rafael Kozar
 */
@WebServlet(name = "ControladoraCarrinho", urlPatterns = {"/ControladoraCarrinho"})
public class ControladoraCarrinho extends HttpServlet {

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
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ControladoraCarrinho</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ControladoraCarrinho at " + request.getContextPath() + "</h1>");

            String action = request.getParameter("action");
            String prodId = request.getParameter("produto");

            ProdutoDAO daoprod;
            Produto produto;
            ClienteDAO daocliente;
            Cliente cliente;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession session = request.getSession();
            cliente = (Cliente) session.getAttribute("user");
            CarrinhoDAO daocar = new CarrinhoDAO();

            if (action.equals("adicionar")) {
                //response.sendRedirect("carrinho.jsp");

                
                int idpedido = 0;
                
                if (cliente == null) {
                    res.sendRedirect("index.jsp");
                }

                

                idpedido = daocar.verificar(cliente.getIdUsuario());
//                out.println(idpedido);
                if (idpedido == 0) {
                    daocar.incluirPedido(cliente.getIdUsuario());
                    idpedido = daocar.verificar(cliente.getIdUsuario());
                }
                daocar.incluirProduto(idpedido, Integer.parseInt(prodId));
////                out.println("aqui");
                cliente.setPedido();
                cliente.setProdutos();
                response.sendRedirect("carrinho.jsp");

                

            }           
           else if (action.equals("deletar")) {
//               out.println("auqi");
                int idPedido = Integer.parseInt(request.getParameter("idpedido"));
                int idProduto = Integer.parseInt(request.getParameter("idproduto"));
                
                daocar.deletarItemPedido(idPedido, idProduto);
//                out.println("qai");
               // response.sendRedirect("/carrinho.jsp");
                cliente.setPedido();
                int ped = cliente.getPedido();
                cliente.setProdutos();
                RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/carrinho.jsp");
                rd.forward(request, response);
                
//                out.println("</body>");
//                out.println("</html>");

            }
           else if(action.equals("finalizar")){
               double valor = 0;
               List<Produto> produtos = new ArrayList();
               produtos.addAll(cliente.getProdutos());
               for(Produto prodCliente: produtos){
                   valor = valor + (prodCliente.getValor()*prodCliente.getQuantidade());                   
               }
               Pedido pedido = new Pedido();
               pedido.setValor(valor);
               pedido.setIdPedido(cliente.getPedido()); 
//               Date data = new Date(System.currentTimeMillis());    
//               SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");  
//               formatador.format(data);
//               pedido.setData_pedido((java.sql.Date) data);
               daocar.finalizarPedido(pedido);
               cliente.setPedido();
               cliente.setProdutos();
               response.sendRedirect("index.jsp");
           }
           else if(action.equals("salvar")){
////               ArrayList<String> quantidades = new ArrayList<>();
////               ArrayList<String> idsProdutos = new ArrayList<>();
////               ArrayList<Integer> quantidadesNUM = new ArrayLi<>();st<>();
               String quantidades;
               String idsprodutos;
               int quantidadesNUM = 0;
               int idsprodutosNUM = 0;
               
               double valor_novo = 0;
               if(daocar.verificar(cliente.getIdUsuario()) == 0) response.sendRedirect("carrinho.jsp");
               List<Produto> produtos = new ArrayList();
               produtos.addAll(cliente.getProdutos());
               List<Produto> produtosSetar = new ArrayList();
               produtos.addAll(cliente.getProdutos());
               for(Produto prodCliente: produtos){
                   quantidades = request.getParameter(Integer.toString(prodCliente.getIdProduto()));
                   quantidadesNUM = Integer.parseInt(quantidades);
                   prodCliente.setQuantidade(quantidadesNUM);
                   produtosSetar.add(prodCliente);
                   valor_novo = (prodCliente.getQuantidade()*prodCliente.getValor()) + valor_novo;                           
               }
               Pedido pedido = new Pedido();
               pedido.setIdPedido(cliente.getPedido());
               pedido.setIdCliente(cliente.getIdUsuario());
               pedido.setProdutos(produtos);
               pedido.setValor(valor_novo/2);
               daocar.setarQuantidade(pedido, produtos);
               daocar.setarValor(pedido);               
               cliente.setValor_pedido(pedido.getValor());
               response.sendRedirect("carrinho.jsp");
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
            Logger.getLogger(ControladoraCarrinho.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControladoraCarrinho.class.getName()).log(Level.SEVERE, null, ex);
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
