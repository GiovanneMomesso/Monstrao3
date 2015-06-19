<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="interceptador.jsp" />
<jsp:useBean id="clienteDao" class="dao.ClienteDAO"/>
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

                <!-- Busca Cliente-->

                <h1>Busca </h1>&nbsp;&nbsp;
                <form id="demo-form" method="post" action="ControladoraCliente?action=pesquisar">
                    <label>Entre com nome, ou parte do nome, do cliente desejado:</label>
                    <textarea class="field" name="busca_cliente" id="busca_cliente" cols="120" rows="1"></textarea>
                    <input type="submit" class="search-submit" value="OK" />
                </form>
                <!-- End Busca Cliente  -->			
                <br/><br/>

                <!-- Pedidos Admin -->		
                <div class="ped_admin">
                    <h1>Lista de Clientes</h1> &nbsp;&nbsp;
                    <br/><br/><br/><br/>
                    <table class="estilo1">
                        <tr class="estilo1">
                            <th class="estilo1">Nome</th>
                            <th class="estilo1">E-mail</th>
                            <th class="estilo1"></th>
                            <th class="estilo1"></th>
                        </tr>
                        <c:forEach var="cliente" items="${clienteDao.listar()}">
                        <tr class='estilo1'>
                            <td class='estilo1'>${cliente.nome}</td>
                            <td class='estilo1'>${cliente.email}</td>
                            <td class='estilo1'><a href="ControladoraCliente?action=visualizar&id=${cliente.idUsuario}" class='search-submit'>Alterar</a></td>
                            <td class='estilo1'><a href="ControladoraCliente?action=deletar&id=${cliente.idUsuario}" onclick="return confirm('Você tem certeza que deseja deletar este Cliente?');" class='search-submit'>Deletar</a></td>
                        </tr>	

                        </c:forEach>
                    </table>
                </div>
                <!-- End Pedidos Admin -->	



            </div>
            <!-- End Content -->

            <!-- Sidebar -->
            <div id="sidebar">

                <!-- Login -->
                <jsp:include page = "funcionalidades/login.jsp" /> 
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