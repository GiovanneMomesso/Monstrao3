<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="interceptador.jsp" />
<jsp:useBean id="catDao" class="dao.CategoriaDAO"/>
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
                    <h1>Gerar Relat&oacute;rio</h1>&nbsp;&nbsp;

                    <form form id="demo-form" method="post" action="GeradorRelatorio">
                        <table>                            
                            <tr>
                                <td><br />Selecione a Categoria</td>
                                <td>
                                    <select id="campoCategoria" name="campoCategoria">
                                        <c:forEach items="${catDao.listar()}" var="categoria">
                                            <option value="${categoria.idCategoria}">${categoria.nome}</option>
                                        </c:forEach>                           
                                    </select>
                                </td>
                            </tr>
                        </table>
                        <br />
                        <input type="submit" class="search-submit" value="Gerar Relatório" />                      
                    </form>	
                    <br /><br />
                </div>		

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