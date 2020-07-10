
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
        <link rel="stylesheet" href="/Seguradora/style/css/bootstrap.min.css">
        <title>Seguradora</title>
    </head>
    <body>
        <br>    <br>    <br>    <br>
        <div class="container">
            <div class="row">
                <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                    <div class="card card-signin my-5">
                        <div class="card-body">
                            <h5 class="card-title text-center">Acesso ao Sistema</h5>
                            <form class="form-signin" method="POST" action="/Seguradora/AutenticarUsuario">
                                <div class="form-label-group">
                                    <input type="email" id="inputEmail" class="form-control" placeholder="E-mail " required autofocus name="email">
                                </div>
                                <br>
                                <div class="form-label-group">
                                    <input type="password" id="inputPassword" class="form-control" placeholder="Senha" required name="senha">
                                </div>

                                <div class="custom-control custom-checkbox mb-3">
                                    <input type="checkbox" class="custom-control-input" id="customCheck1">
                                    <label class="custom-control-label" for="customCheck1">Lembra senha</label>
                                </div>
                               <!-- <input type="hidden" name="operacao" value="AUTENTICAR"> -->
                                <input type='submit' class="btn btn-primary" name='acessar' value='Acessar' />
                                <br>
                                <br>
                                <a href="../login/novoLogin.jsp">Novo Login</a>

                                <c:if test="${mensagem != null}">
                                    <br/>
                                    <p>${mensagem}</p>
                                </c:if>
                                <br>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!-- Bootstrap core JavaScript -->
        <script src="/Seguradora/style/js/jquery-3.3.1.min.js"></script>
        <script src="/Seguradora/style/js/popper.min.js"></script>
        <script src="/Seguradora/style/js/bootstrap.min.js"></script>
    </body>
</html>

