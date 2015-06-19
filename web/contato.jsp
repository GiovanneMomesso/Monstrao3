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
			
			<!-- Formulario -->
		<div class="formulario">
				<div class="cl">&nbsp;</div>
				<h1>Fale Conosco</h1>&nbsp;&nbsp;
					
			<form form id="demo-form" method="post" action="index.jsp">
			<table>
  			<tr>
    		<td for="nome_cli" >Nome:</td>
    		<td><input type="text" class="field m " name="nome_cli" id="nome_cli" data-required="true" /></td>
    		</tr>    		
    		<tr>
    		<td for="assunto">Assunto:</td>
    		<td><textarea class="field" name="assunto" id="assunto" cols="85" rows="1" data-required="true"></textarea></td>
    		</tr>
    		<tr>
    		<td for="mensagem">Mensagem:</td>
    		<td><textarea class="field" name="mensagem" id="mensagem" cols="85" rows="5" data-required="true"></textarea></td>
    		</tr>
			</table>

			<br />
			<input type="submit" class="search-submit" onclick="alert('Mensagem enviada com sucesso!')" value="Enviar" />
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