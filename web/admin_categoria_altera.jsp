<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
                <br />
                <!-- Formulario -->
                <div class="formulario">
                    <div class="cl">&nbsp;</div>
                    <h1>Alterar categoria</h1>&nbsp;&nbsp;
                   <br /><br />
                    
                    <form form action="ControladoraCategoria?action=alterar&id=${categoria.idCategoria}" id="demo-form" method="post">
                        <table>
                            <tr>
                                <td for="nome_cat" >Nome:</td>
                                <td><input type="text" class="field m " name="nome_cat" id="nome_cat" data-required="true" value="${categoria.nome}"/></td>
                            </tr>
                        </table>
                        <br />
                        <input type="submit" class="search-submit" value="Alterar" />

                    </form>	
                    <br /><br /><br /><br />
                </div>				

            </div>
            <!-- End Content -->

            <!-- Sidebar -->
            <div id="sidebar">

                <!-- Login -->
                <jsp:include page = "funcionalidades/login.jsp" /> 
                <!-- End Login -->

                <div class="box ">
                    <h2>Cadastrar Nova Categoria<span></span></h2>
                    <div class="box-content"> 					
                        <a href="admin_categoria_novo.jsp"><input type="button" class="search-submit" value="Nova" /></a>
                    </div>
                </div>	

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