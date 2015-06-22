<%@page import="entity.Cliente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="carDao" class="dao.CarrinhoDAO" />

<jsp:useBean id="usuario" class="entity.Cliente" scope="session"/>
<jsp:setProperty name="usuario" property="*" />

<c:set var="valor" value="0" />
<jsp:include page = "layout/head.html" />  

<body>

    <!-- Shell -->	
    <div class="shell">

        <!-- Header -->	
        <div id="header">
            <jsp:include page = "layout/header.html" /> 	

            <!-- Cart -->
            <jsp:include page = "funcionalidades/carrinho.jsp" /> 
            <!-- End Cart -->

            <!-- Navigation -->
            <jsp:include page = "layout/menu_cliente.html" /> 
            <!-- End Navigation -->
        </div>
        <!-- End Header -->




        <!-- Main -->
        <div id="main">
            <div class="cl">&nbsp;</div>

            <!-- Content -->
            <div id="content">		


                <!-- Formulario -->
                <div class="formulario">
                    <div class="cl">&nbsp;</div>
                    <h1>Meu carrinho </h1>&nbsp;&nbsp;                    

                    <form form id="demo-form" method="post" action="ControladoraCarrinho?action=salvar">
                        <table class='estilo1'>                            
                            <tr class='estilo1'>

                                <th class='estilo1'>Produto</th>
                                <th class='estilo1'>Quantidade</th>
                                <th class='estilo1'>Valor Unitário</th>
                                <th class='estilo1'>Deletar Produto</th>
                            </tr>
                            <c:forEach var="produto" items="${user.produtos}">
                                <tr>                                
                                    <td class='estilo1'>${produto.nome}</td>
                                    <td class='estilo1'><input type="text" value="${produto.quantidade}" name="${produto.idProduto}"/></td>                                
                                    <td class='estilo1'>${produto.valor}</td>
                                    <td class='estilo1'><a href="ControladoraCarrinho?action=deletar&idproduto=${produto.idProduto}&idpedido=${user.pedido}" class='search-submit'>Deletar</a></td>
                                    
                                </tr>
                                    
                            </c:forEach>
                        </table>
                        Valor ${user.valor_pedido}

                        <br />
                        <a href="index.jsp"><input type="button" class="search-submit" value="Continuar Comprando" /></a>
                        <a href="ControladoraCarrinho?action=finalizar"><input type="button" class="search-submit" value="Finalizar Compra" onclick="alert(Pedido finalizado)"/></a>
                        <input type="submit" class="search-submit" value="Atualizar Carrinho"/> <c:out value="ATUALIZE SEU CARRINHO APÓS CADA MODIFICAÇÃO!!!"/> 
                    </form>	
                    <br /><br /><br /><br />
                </div>				
                <!-- End Formulario -->

            </div>
            <!-- End Content -->

            <!-- Sidebar -->
            <div id="sidebar">

                <!-- Login -->
                <jsp:include page = "funcionalidades/login.jsp" />
                <!-- End Login -->		

                <!-- Search -->
                <jsp:include page = "funcionalidades/search.jsp" />
                <!-- End Search -->

                <!-- Categories -->
                <jsp:include page = "funcionalidades/categorias.jsp" /> 
                <!-- End Categories -->

            </div>
            <!-- End Sidebar -->

            <div class="cl">&nbsp;</div>
        </div>
        <!-- End Main -->



        <!-- Side Full -->
        <jsp:include page = "layout/sidefull.html" /> 
        <!-- End Side Full -->

        <!-- Footer -->
        <jsp:include page = "layout/footer.html" />
        <!-- End Footer -->

    </div>	
    <!-- End Shell -->


</body>
</html>