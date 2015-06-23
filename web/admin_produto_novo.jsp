<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="interceptador.jsp" />
<jsp:useBean id="catDao" class="dao.CategoriaDAO"/>
<jsp:include page = "layout/head.html" />  
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
                    <!-- Formulario -->
                    <div class="formulario">
                        <div class="cl">&nbsp;</div>
                        <h1>Cadastro de Novo Produto</h1>&nbsp;&nbsp;
                         
                        <form form id="demo-form" method="post" action="ControladoraProduto?action=inserir">
                            <table>
                                <tr>
                                    <td for="nome_prod" >Nome:</td>
                                    <td><input type="text" class="field m " name="campoProdutoNome" id="campoProdutoNome" data-required="true" /></td>
                                </tr>
                                <tr>
                                    <td>Categoria</td>
                                    <td>
                                        <select id="campoCategoria" name="campoCategoria">
                                            <c:forEach items="${catDao.listar()}" var="categoria">
                                                <option value="${categoria.idCategoria}">${categoria.nome}</option>
                                            </c:forEach>                           
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td for="valor" >Valor:</td>
                                    <td><input type="text" class="field p" name="campoValor" id="campoValor" data-required="true"/></td>
                                </tr>
                                <tr>
                                    <td for="desc_basica">Gênero:</td>
                                    <td><input type="text" class="field p" name="campoDescricaoBasic" id="campoDescricaoBasic" cols="85" rows="2" data-required="true"></textarea></td>
                                </tr>
                                <tr>
                                    <td for="desc_detalhada">Descri&ccedil;&atilde;o detalhada:</td>
                                    <td><textarea class="field" name="campoDescricaoDetal" id="campoDescricaoDetal" cols="85" rows="5" data-required="true"></textarea></td>
                                </tr>
                                <tr>
                                    <td for="imagem" >*Imagem: <br></td>
                                    <td><input type="text" class="field g" name="campoImagem" id="campoImagem" data-required="true" /></td>
                                </tr>
                                 <tr>
                                      <td for="promo" >Produto em promoção</td>
                                       <td><input type="checkbox" class="field m " name="promo" value="s" id="promo" cols="2" data-required="true" />
                                         </td>
                                 </tr>
                            </table>
                            <br />
                            <input type="submit" class="search-submit" value="Cadastrar" />
                        </form>	
                        <br /><br /><br /><br />
                    </div>		
                    <!-- End Formulario -->	
                </div>
                <!-- End Content -->

                <!-- Sidebar -->
                <div id="sidebar">
                    <h1>${$categoria.nome}</h1>
                    <!-- Login -->
                    <jsp:include page = "funcionalidades/login.jsp" /> 
                    <!-- End Login -->

                    <div class="box ">
                        <h2>Cadastrar Novo Produto<span></span></h2>
                        <div class="box-content"> 					
                            <a href="admin_produto_novo.jsp"><input type="button" class="search-submit" value="Novo" /></a>
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