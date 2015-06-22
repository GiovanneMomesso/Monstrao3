lo<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="interceptador.jsp" />
<jsp:useBean id="categoriaDao" class="dao.CategoriaDAO"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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


                <!-- Busca -->

                <h1>Busca</h1>&nbsp;&nbsp;
                <form form id="demo-form" method="post" action="ControladoraCategoria?action=pesquisar">
                    <label>Entre com nome parte do nome da categoria desejada:</label>
                    <textarea class="field" name="busca_cat" id="busca_cat" cols="100" rows="1"></textarea>
                    <input type="submit" class="search-submit" value="Buscar" />
                </form>
                <!-- End Busca -->	

                <br/><br/>

                <!-- Tabela resultado busca cat -->	


                    <c:choose>
                        <c:when test="${categoria == null}"><div class="categoria-info">
                                <c:out value="Nenhuma categoria encontrada"/></div>
                        </c:when>
                    <c:otherwise>
                    
                <table class='estilo1'>

                    <tr class='estilo1'>

                        <th class='estilo1'>Nome Categoria</th>
                        <th class='estilo1'></th>
                        <th class='estilo1'></th>
                    </tr>
                    <c:forEach var="categoria" items="${categoria}">
                        <tr class='estilo1'>
                            <td class='estilo1'>${categoria.nome}</td>
                            <td class='estilo1'><a href="ControladoraCategoria?action=mostraralterar&id=${categoria.idCategoria}" class='search-submit'>Alterar</a></td>
                            <td class='estilo1'><a href="ControladoraCategoria?action=deletar&id=${categoria.idCategoria}" class='search-submit'>Deletar</a></td>
                        </tr>	
                        </c:forEach>
                            </c:otherwise>
                        </c:choose>
                </table>



                <!-- End tabela resultado busca cat -->



            </div>
            <!-- End Content -->

            <!-- Sidebar -->
            <div id="sidebar">

                <!-- Login -->
                <jsp:include page = "funcionalidades/login.jsp" /> 
                <!-- End Login -->

                <div class="box ">
                    <h2>Cadastrar Nova Categoria<span></span></h2>
                    <div class="box-content"> 					
                        <a href="admin_categoria_novo.jsp"><input type="button" class="search-submit" value="Nova" /></a>
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