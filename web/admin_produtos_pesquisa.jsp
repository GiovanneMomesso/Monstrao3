<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="interceptador.jsp" />
<jsp:useBean id="categoriaDao" class="dao.CategoriaDAO"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:include page = "layout/head.html" />  
<script src="js/arquivo_javascript.js" type="text/javascript"></script>

<body>

    <!-- Shell -->	
    <div class="shell">

        <!-- Header -->	
        <div id="header">
            <jsp:include page = "layout/header.html" /> 	

            <!-- Navigation -->
            <jsp:include page = "layout/menu_adm.html" /> 
            <!-- End Navigation -->
        </div>
        <!-- End Header -->

        <!-- Main -->
        <div id="main">
            <div class="cl">&nbsp;</div>

            <!-- Content -->
            <div id="content">
                <br />		


                <!-- Busca -->
                <h1>Busca</h1>&nbsp;&nbsp;
                <form method="post" action="ControladoraProduto?action=pesquisar">
                    <label>Entre com nome ou descri&ccedil;&atilde;o do produto desejado:</label>
                    <textarea class="field" name="campoPesquisa" id="campoPesquisa" cols="100" rows="1"></textarea>
                    <input type="submit" class="search-submit" value="Pesquisar" />
                </form>
                <!-- End Busca -->	

                <br/><br/>

                <!-- Products -->                        
                <div class="products">
                    <div class="cl">&nbsp;</div>
                    <c:choose>
                        <c:when test="${produtos == null}"><div class="product-info"><c:out value="Nenhum produto encontrado"/></div> </c:when>
                    <c:otherwise>
                    <c:forEach var="prod" items="${produtos}">
                        <ul>
                            <li>
                                <a href="detalhes_prod.html"><img src="${prod.img}"/></a>
                                <div class="product-info">
                                    <h3>${prod.categoria} | ${prod.descricaoBasica}</h3>
                                    <div class="product-desc">
                                        <p>${prod.nome}</p>
                                        <strong class="price"><fmt:formatNumber value="${prod.valor}" type="currency"/></strong>
                                        <table class='ex1'>
                                            <tr>                                                
                                                <td><a href="ControladoraProduto?action=select&idproduto=${prod.idProduto}" class='search-submit'>Alterar</a>
                                                <a href="ControladoraProduto?action=deletar&idproduto=${prod.idProduto}" 
                                                             onclick="return confirm('Você tem certeza que deseja deletar este produto');"
                                                             class='search-submit'>Deletar</a></td>
                                                                      
                                            </tr>
                                        </table>	
                                    </div>
                                </div>
                            </li>
                        </ul>
                        </c:forEach>
                            </c:otherwise>
                        </c:choose>
                        <div class="cl">&nbsp;</div>

                </div>
                <!-- End Products -->	



            </div>
            <!-- End Content -->

            <!-- Sidebar -->
            <div id="sidebar">

                <!-- Login -->
                <jsp:include page = "funcionalidades/login.jsp" /> 
                <!-- End Login -->

                <div class="box ">
                    <h2>Cadastrar Novo Produto<span></span></h2>
                    <div class="box-content"> 					
                        <a href="admin_produto_novo.html"><input type="button" class="search-submit" value="Novo" /></a>
                    </div>
                </div>	

            </div>
            <!-- End Sidebar -->

            <div class="cl">&nbsp;</div>
        </div>
        <!-- End Main -->


        <!-- Footer -->
        <jsp:include page = "layout/footer_adm.html" /> 
        <!-- End Footer -->	

    </div>	
    <!-- End Shell -->


</body>
</html>