<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="interceptador.jsp" />
<jsp:useBean id="clienteDao" class="dao.ClienteDAO"/>
<jsp:include page = "layout/head.html" />  
<body>
	
<!-- Shell -->	
<div class="shell">
	
	<!-- Header -->	
        <div id="header">
		<jsp:include page = "layout/header.html" /> 	
		
		<!-- Navigation -->
                    <jsp:include page = "layout/menu_adm.html" /> o
		<!-- End Navigation -->
	</div>
	<!-- End Header -->
	
	<!-- Main -->
	<div id="main">
		<div class="cl">&nbsp;</div>
		
		<!-- Content -->
		<div id="content">
                <!-- Envia Email-->

                <h1>E-mail </h1>&nbsp;&nbsp;
                <form id="demo-form" method="post" action="">
                    <label>Digite o corpo de mensagem para enviar junto ao e-mail promocional para os clientes contidos na lista abaixo:</label>
                    <textarea class="field" name="envia_email" id="envia_email" cols="120" rows="1"></textarea>
                    <input type="submit" onclick="alert('Emails para a lista de contato enviado com sucesso!')" class="search-submit" value="Enviar" />
                </form>
                <!-- End Envia Email  -->		
	
		<br/><br/>
		
			<!-- Pedidos Admin -->		
			<div class="ped_admin">
			<h1>Lista de Clientes que desejam receber e-mails</h1> &nbsp;&nbsp;
			<br/><br/><br/><br/>
			<table class="estilo1">
				<tr class="estilo1">
					<th class="estilo1">Nome</th>
					<th class="estilo1">E-mail</th>

				</tr>
                                <c:forEach var="cliente" items="${clienteDao.listar_promo()}">
				<tr class='estilo1'>
					<td class='estilo1'>${cliente.nome}</td>
					<td class='estilo1'>${cliente.email}</td>
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