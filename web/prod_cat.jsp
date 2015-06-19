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
			
			<!-- Content Slider -->
			<div id="slider" class="box">
				<div id="slider-holder">
					<ul>
					    <li><a href="detalhes_prod.html"><img src="css/images/slide1.jpg" alt="" /></a></li>
					    <li><a href="detalhes_prod.html"><img src="css/images/slide1.jpg" alt="" /></a></li>
					    <li><a href="detalhes_prod.html"><img src="css/images/slide1.jpg" alt="" /></a></li>
					    <li><a href="detalhes_prod.html"><img src="css/images/slide1.jpg" alt="" /></a></li>
					</ul>
				</div>
				<div id="slider-nav">
					<a href="#" class="active">1</a>
					<a href="#">2</a>
					<a href="#">3</a>
					<a href="#">4</a>
				</div>
			</div>
			<!-- End Content Slider -->
			
			<!-- Products -->
			<div class="products">
				<div class="cl">&nbsp;</div>
				<ul>
				    <li>
				    	<a href="detalhes_prod.html"><img src="css/images/big1.jpg" alt="" /></a>
				    	<div class="product-info">
				    		<h3>Nintendo DS</h3>
				    		<div class="product-desc">
								<p>Mario Party<br />DS</p>
				    			<strong class="price">R$99.90</strong>
				    		</div>
				    	</div>
			    	</li>
				</ul>
				<div class="cl">&nbsp;</div>
			</div>
			<!-- End Products -->
			
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