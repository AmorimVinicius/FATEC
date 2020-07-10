<%-- 
    Document   : cadastrarApolice
    Created on : 13/04/2019, 08:29:17
    Author     : viniciusamorim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seguradora</title>
        <link rel="stylesheet" href="../style/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
        <!--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        -->
        </head>
    <body>
        <div class="container">	
            <h2>Cadastrar Apólice</h2>
            <form action='filtrar' method="POST" >
                <div class="form-group row">
                    <label for="dataInicio" class="col-2 col-form-label">Inicio Apolice</label>
                    <div class="col-3">
                         <input class="form-control" type="text" id="dataInicio" name="dataInicio"  value="${resultado.get(0).veiculo.marca}">
                   </div>
                    <label for="dataFim" class="col-2 col-form-label">Fim Apólice:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="dataFim" name="dataFim" required="true" maxlength="10">
                    </div>
                </div>
                
                <div class="form-group row">
                    <label for="premio" class="col-2 col-form-label">Prêmio:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="premio" name="premio" required="true" maxlength="10">
                    </div>
                    <label for="valorApolice" class="col-2 col-form-label">Valor Apólice:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="valorApolice" name="valorApolice" required="true" maxlength="10">
                    </div>                    
                </div>
                
                <div class="form-group row">
                    <label for="tipoApolice" class="col-2 col-form-label">Tipo Apólice:</label>
                    <div class="col-3">
                        <select class="form-control" type="text" id="tipoApolice" name="tipoApolice" required="true" maxlength="10">
                            <option value="" selected> </option>
                            <option value="Compreensivo">Compreensivo</option>
                            <option value="FurtoRoubo">Furto/Roubo</option>
                            <option value="De Terceiros">De Terceiros</option>
                        </select>
                    </div>   
                </div>
                
                <hr>
                
                <h3>Dados Cliente</h3>
                
                <div class="form-group row">
                    <label for="documento" class="col-2 col-form-label">CPF/CNPJ:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="documento" name="documento" required="true" maxlength="15">
                    </div>
                </div>
                
                <input type="hidden" name="operacao" value="LISTARFILTRO">

                <input class="btn btn-primary" type="submit" value="Filtrar">
                <br/>
            
                <c:if test="${mensagem != null}">
                    <br/>
                    <p>${mensagem}</p>
                </c:if>


      
            <br/>
            <div class="row">
                <form> 
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Marca</th>
                            <th scope="col">Modelo</th>
                            <th scope="col">Placa</th>
                            <th scope="col">Chassi</th>
                            <th scope="col">Ano Fabricação</th>
                            <th scope="col">Ano Modelo</th>
                            <th scope="col">Documento</th>
                            <th scope="col">Apólice</th>
                            <th scope="col">Alterar</th>
                            <th scope="row">Excluir</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="apolice" items="${resultado}" >
                            <tr>
                                <td>${apolice.dataInicio}</td>
                                <td>${apolice.dataFim}</td>
                                <td>${apolice.premio}</td>
                                <td>${apolice.valorApolice}</td>
                                <td>${apolice.tipoApolice}</td>
                                <td><a href="preAtualizar?id=${apolice.id}&operacao=PREATUALIZAR"><input class="btn btn-secondary" type="button" value="Alterar"></a></td>
                                <td><a href="excluir?id=${apolice.id}&operacao=EXCLUIR"><input class="btn btn-danger" type="button" value="Excluir"></a></td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </form>
                
                <c:if test="${mensagem != null}">
                    <br/>
                    <p>${mensagem}</p>
                </c:if>
                
            </div>
    </body>
    
    <script type="text/javascript">
        $("#dataInicio").mask("00/00/0000");
        $("#dataFim").mask("00/00/0000");
    </script>
    
</html>
