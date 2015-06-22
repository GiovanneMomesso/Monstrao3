<%-- 
    Document   : detalhes_cliente
    Created on : 24/04/2014, 23:39:22
    Author     : Tiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="cliDao" class="dao.ClienteDAO"/>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="interceptador.jsp" />

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

                <!-- Who -->
                <div class="cliente">
                    <h1>Alterar Cliente</h1><br/><br/>				
                     <form form id="demo-form" action="ControladoraCliente?action=alterar&id=${cliente.idUsuario}" method="post">
                        <table>
                            <tr>
                                <td for="nome_pessoa" >Nome Completo:</td>
                                <td><input type="text" class="field m " name="nome" id="nome" data-required="true" value="${cliente.nome}"/></td>
                            </tr>
                            <tr>
                                <td for="CPF">CPF</td>
                                <td><input type="text" class="field m " name="campoCpf" id="campoCpf" data-required="true" value="${cliente.cpf}" /></td>
                            </tr>
                            <tr>
                                <td for="email">Email</td>
                                <td><input type="text" class="field m " name="email" id="email" data-required="true" value="${cliente.email}" /></td>
                            </tr>
                            <tr>
                                <td for="cep">CEP</td>
                                <td><input type="text" class="field m " name="campoCep" id="campoCep" data-required="true" value="${cliente.cep}" /></td>
                            </tr>                          
                            <tr>
                                <td for="endereco">Endereço:</td>
                                <td><input class="field" name="end" id="end" cols="85" rows="1" data-required="true" value="${cliente.endereco}"/></td>
                            </tr>
                            <tr>
                                 <td for="news" >Desejo receber e-mails promocionais</td>
                                 <td>
                                     <c:if test="${cliente.news == true}">
                                         <input type="checkbox" class="field m " name="news" value="s" checked id="news" cols="2" /></td>
                                     </c:if>
                                    <c:if test="${cliente.news != true}">
                                         <input type="checkbox" class="field m " name="news" value="s" id="news" cols="2" /></td></c:if>
                            </tr>                            
                        </table>
                        <br />
                        <br />
                        <input type="submit" class="search-submit" value="Alterar" onclick="alert('Alterado com sucesso!')"/>
                    </form>	
                </div>
                <!-- End Who -->

            </div>
            <!-- End Content -->


            <!-- Sidebar -->
            <div id="sidebar">

                <!-- Login -->
                <jsp:include page = "funcionalidades/logout.jsp" /> 
                <!-- End Login -->                	

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
