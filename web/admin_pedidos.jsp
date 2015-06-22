<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		
			<!-- Pedidos Admin -->		
			<div class="ped_admin">
			<h1>Pedidos</h1> &nbsp;&nbsp;
			<br/><br/><br/><br/>
			<table class="estilo1">
				<tr class="estilo1">
					<th class="estilo1">N&uacute;mero Pedido</th>
					<th class="estilo1">Data</th>
					<th class="estilo1">Valor Total</th>
					<th class="estilo1">Status</th>
					<th class="estilo1"></th>
				</tr>
			 
				<tr class='estilo1'>
					<td class='estilo1'>1</td>
					<td class='estilo1'>19/07/2013</td>
					<td class='estilo1'>R$ 199,90</td>
					<td class='estilo1'>AGUARDANDO PAGAMENTO</td>
					<td class='ped'><a href="#" class='search-submit2 ped'>Confirmar Pagamento</a></td>
				</tr>
				
				<tr class='estilo1'>
					<td class='estilo1'>2</td>
					<td class='estilo1'>12/11/2013</td>
					<td class='estilo1'>R$ 560,90</td>
					<td class='estilo1'>AGUARDANDO PAGAMENTO</td>
					<td class='ped'><a href="#" class='search-submit2 ped'>Confirmar Pagamento</a></td>
				</tr>

				<tr class='estilo1'>
					<td class='estilo1'>3</td>
					<td class='estilo1'>04/02/2014</td>
					<td class='estilo1'>R$ 120,00</td>
					<td class='estilo1'>AGUARDANDO PAGAMENTO</td>
					<td class='ped'><a href="#" class='search-submit2 ped'>Confirmar Pagamento</a></td>
				</tr>				
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