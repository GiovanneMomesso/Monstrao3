<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- Intercepador do admin -->


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