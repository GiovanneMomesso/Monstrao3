<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:include page = "layout/head.html" />  
<body>

    <!-- Shell -->	
    <div class="shell">

        <!-- Header -->	
        <div id="header">
            <jsp:include page = "layout/header.html" /> 	

            <!-- -->
            <script type="text/javascript">
                $(document).ready(function() {
                    $(".campoCpf").mask("999.999.999-99");
                    //Comment teste                
                });
            </script>
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
                    <h1>Cadastro</h1>&nbsp;&nbsp;

                    <form form id="demo-form" action="ControladoraCliente?action=inserir" method="post">
                        <table>
                            <tr>
                                <td for="nome_pessoa" >*Nome Completo:</td>
                                <td><input type="text" class="field m " name="nome" id="nome" data-required="true" /></td>
                            </tr>
                            <tr>
                                <td for="CPF">*CPF</td>
                                <td><input type="text" class="field m " name="campoCpf" id="campoCpf" data-required="true" /></td>
                            </tr>
                            <tr>
                                <td for="email">*Email</td>
                                <td><input type="text" class="field m " name="email" id="email" data-required="true" /></td>
                            </tr>
                            <tr>
                                <td for="cep">*CEP</td>
                                <td><input type="text" class="field m " name="campoCep" id="campoCep" data-required="true" /></td>
                            </tr>
                            <tr>
                                <td for="login">*Login</td>
                                <td><input type="text" class="field m " name="login" id="login" data-required="true" /></td>
                            </tr> 
                            <tr>
                                <td for="senha">*Senha</td>
                                <td><input type="password" class="field m " name="senha" id="senha" data-required="true" /></td>
                            </tr>                              

                            <tr>
                                <td for="endereco">*Endereço:</td>
                                <td><textarea class="field" name="end" id="end" cols="85" rows="1" data-required="true"></textarea></td>
                            </tr>
                            <tr>
                                <td for="news" >Desejo receber e-mails promocionais</td>
                                <td><input type="checkbox" class="field m " name="news" value="s" id="news" cols="2" data-required="true" /></td>
                            </tr>
                        </table>
                        <br />
                        <h4><b>*Campo de preenchimento obrigatório</b></h4>
                        <br />
                        <input type="submit" class="search-submit" value="Cadastrar" onclick="alert('Cadastrado com sucesso!')"/>
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