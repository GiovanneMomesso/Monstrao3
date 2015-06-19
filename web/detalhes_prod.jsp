<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:import url="interceptador.jsp" />

<jsp:useBean id="catDao" class="dao.CategoriaDAO"/>
<jsp:include page = "layout/head.html" />  

<body>
    <script type="text/javascript">
        function teste(){
        alert("Coisa");
        //return nome;
    }
    
    function  verificar(){
        var sesnome = "${sessionScope.user.nome}";
        if(sesnome == null || sesnome == ""){
            alert("Você precisa primeiro realizar o login");
            return false;
        }
        else
            return true;
            
    }
    </script>
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

			
			<!-- Individual Products -->
                        
			<h1>${produto.nome}</h1>&nbsp;&nbsp;
			<div class="prod_ind">
				<img src="${produto.img}" alt="" />
			</div>
			<div class="product_info">
			<ul class="none"><br/>		
				<li></li>		
				<li><h2>Plataforma: ${produto.categoria}</h2></li>
                                <br/>
				<li><h2>Descrição:</h2></li>
                                <br/>
                                <li><h7>${produto.descricaoDetal}</h7></li>
				<br/>				    										
				<li><strong class="price"><fmt:formatNumber value="${produto.valor}" type="currency"/></strong></li>
                                <br/>
                                <c:url value="ControladoraCarrinho" var="url" >                                  
                                    <c:param name="action" value="adicionar" />
                                    <c:param name="produto" value="${produto.idProduto}" />
                                </c:url>
				<li><a href="ControladoraCarrinho?action=adicionar&produto=${produto.idProduto}" class='search-submit2' onclick="return verificar()">Adicionar ao Carrinho</a></li>				    						    				    				    			    	
			</ul>
			</div>
			<div class="cl">&nbsp;</div>
		</div>
			<!-- End Individual Products     -->
			
		
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