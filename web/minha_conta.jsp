<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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

                <!-- Who -->
                <c:choose>
                    <c:when test="${sessionScope.user == null}">
                        <h1>Você não possui cadastro</h1>				
                    </c:when>
                    <c:otherwise>
                        <div class="cliente">
                            <h1>Minha conta</h1>				
                            <div class="tb_cli">

                                <table >
                                    <form action="ControladoraCliente?action=atualizar" method="post">
                                    <tr>
                                        <td  ><h2>Nome:</h2> </td>
                                        <td ><h2><input name="campoNome" value="${sessionScope.user.nome}" /></h2></td>
                                    </tr>
                                    <tr >
                                        <td  ><h2>CPF:</h2> </td>
                                        <td  ><h2><input name="campoCpf" value="${sessionScope.user.cpf}" /></h2></td>
                                    </tr>

                                    <tr >
                                        <td  ><h2>E-mail:</h2> </td>
                                        <td  ><h2><input name="campoEmail" value="${sessionScope.user.email}" /></h2></td>
                                    </tr>
                                    <tr >
                                        <td ><h2>CEP</h2></td>
                                        <td ><h2><input name="campoCep" value="${sessionScope.user.cep}" /></h2></td>
                                    </tr>
                                    <tr>
                                        <td><h2>Endereço:</h2></td>
                                        <td><input name="campoEndereco" value="${sessionScope.user.endereco}" /></td>
                                    </tr>                                        
                                    <tr>   

                                        <c:if test="${sessionScope.user.news == true}">
                                            <td><h2>Noticias</h2></td><td><input type="checkbox" class="field m " name="campoNews" value="s" checked id="news" cols="2" /></td>
                                        </c:if>
                                        <c:if test="${sessionScope.user.news != true}">
                                        <td><h2>Noticias</h2></td><td><input type="checkbox" class="field m " name="campoNews" value="s" id="news" cols="2" /></td>
                                        </c:if>                                       
                                    </tr>
                                    <tr><td><input type="submit" class="search-submit" value="Alterar" onclick="alert('Alterado com sucesso!')"/></td></tr>
                                    </form>

                                </table>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
                <!-- End Who -->

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