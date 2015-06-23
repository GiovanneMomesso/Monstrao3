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
                                <p>A equipe GameOn é composta por 3 sócios da área de Análise e Desenvolvimento de Sistemas. Tudo começou pela paixao pelos 3 por jogos e essa paixao fez com que abrissem uma rede online de compras dos mesmos. Aqui você consegue percorrer livremente por entre as páginas, ver informações dos jogos desejados e adicioná-los a seu carrinho de compra. Basta se cadastrar e desfrutar. Não deixe de, no ato de inscrição, preencher a oção 'Desejo receber noticias promocionais' para ficar sempre por dentro do melhor que temos a oferecer.</p>
                                <br/><br/>
                                <img src="http://4.bp.blogspot.com/-xWEsaqnAva8/UsJjniG3xLI/AAAAAAAAHBk/zt36Q8HWKbo/s1600/games.png" width="700px" height="400px" ></img>
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