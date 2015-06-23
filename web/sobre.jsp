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
			<div class="none">
				<h1>Quem somos</h1>
                                <br/><br/>
                                <p>A Monstrão Suplementos é uma empresa de comercialização de suplementos alimentares que possui como objetivo melhorar a qualidade de vida de seus consumidores. Temos um grande comprometimento com a escolha dos produtos que serão vendidos. Trabalhamos apenas com produtos de qualidade assegurada. Acreditamos que sempre devemos ir além das expectativas de nossos clientes. Portanto, estamos sempre dispostos a auxiliar em qualquer tipo de dúvida e possuímos profissionais experientes para atendermos com eficiência e agilidade.</p>
                                <br/><br/>
                                <img src="http://www.criarbrasil.org.br/uploads/imagem/Boletim%20agosto%20-%2014/bodyNewFitness.png" width="700px" height="400px" ></img>
			</div>
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