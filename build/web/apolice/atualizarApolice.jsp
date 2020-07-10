
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Seguradora</title>
        <link rel="stylesheet" href="../style/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>  
        <script type="text/javascript" src="../style/js/estados-cidades.js"></script>
        <script type="text/javascript" src="../style/js/estados-cidades-2.js"></script>
        <!--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        -->
        </head>
    <body>
        <div class="container">	
            <h3>Alterar Apólice</h3>
            <hr>
            <form action='alterar' method="POST">
                
                <c:if test="${mensagem != null}">
                    <br/>
                    <p>${mensagem}</p>
                </c:if>
                
                <br/>
                <div class="form-group row">
                    <label for="dataInicio" class="col-2 col-form-label">Início Apólice:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="dataInicio" name="dataInicio" disabled maxlength="100"  value="${resultado.get(0).dataInicio}">
                    </div>
                    
                    <label for="dataFim" class="col-2 col-form-label">Fim Apólice:</label>  
                    <div class="col-3">
                        <select class="form-control" type="text" id="dataFim" name="dataFim" onchange='fimApolice(this);' required="true" maxlength="10">
                            <option value=" "> </option>
                            <option value="6meses">6 Meses</option>
                            <option value="12meses">12 Meses</option>
                            <option value="18meses">18 Meses</option>
                            <option value="24meses">24 Meses</option>
                        </select>
                    </div>
                </div>
                
                <div class="form-group row">
                    <label for="premio" class="col-2 col-form-label">Prêmio:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="premio" name="premio" required="true" maxlength="8" value="${resultado.get(0).premio}">
                    </div>
                    <label for="valorApolice" class="col-2 col-form-label">Valor:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="valorApolice" name="valorApolice" required="true" maxlength="17" value="${resultado.get(0).valorApolice}">
                    </div>
                </div>                               
                
                <div class="form-group row">
                    <label for="tipoApolice" class="col-2 col-form-label">Tipo Apólice:</label>
                    <div class="col-3">
                        <select class="form-control" type="text" id="tipoApolice" name="tipoApolice" required="true" maxlength="10">
                            <option value=""> </option>
                            <option value="Colisao">Colisão</option>
                            <option value="Terceiros">De Terceiros</option>
                            <option value="FurtoRoubo">Furto/Roubo</option>
                            <option value="Incendio">Incêndio</option>
                            <option value="CausasNaturais">Causas Naturais</option>
                            <option value="Compreensivo">Compreensivo</option>
                        </select>
                    </div>   
                </div>
                
                <div class="form-group row">
                    <label for="habilitados" class="col-2 col-form-label">Habilitados:</label>
                    <div class="col-1">
                        <select class="form-control" type="text" id="habilitados" name="habilitados" >
                            <option value="" selected> </option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                        </select>
                    </div>  
                </div>
                    <br />
                    <hr>
                    <h3>Dados Cliente</h3>
                    
                <div class="form-group row">                    
                    <label for="documento" class="col-2 col-form-label">Documento:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="documento" name="documento" required="true" maxlength="17" value="${resultado.get(0).cliente.documento}">
                    </div>
                </div> 
                  
                    <br/>                                  
                      <br/> 
                <hr>
                    <h3>Endereço Principal</h3>
                    
                <div class="form-group row">
                    <label for="cep" class="col-2 col-form-label">CEP:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="cep" name="cep" value="${resultado.get(0).endereco.cep}">
                    </div>                    
                </div>
                    
                <div class="form-group row">
                    <label for="logradouro" class="col-2 col-form-label">Logradouro:</label>
                    <div class="col-4">
                        <input class="form-control" type="text" id="logradouro" name="logradouro" required="true" maxlength="17" value="${resultado.get(0).endereco.logradouro}">
                    </div>
                    <label for="numero" class="col-2 col-form-label">Número:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="numero" name="numero" value="${resultado.get(0).endereco.numero}">
                    </div>                    
                </div>
                    
                <div class="form-group row">

                    <label for="complemento" class="col-2 col-form-label">Complemento:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="complemento" name="complemento" value="${resultado.get(0).endereco.complemento}">
                    </div>
                    
                    <label for="bairro" class="col-2 col-form-label">Bairro:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="bairro" name="bairro" required="true" value="${resultado.get(0).endereco.bairro}">
                    </div>
                </div>    
                    
                <div class="form-group row">
                    
                    <label for="estado" class="col-2 col-form-label">Estado:</label>
                    <div class="col-4">
                        <select class="form-control" type="text" id="estado" name="estado" onchange="buscaCidades(this.value)" required="true">
                            <option value="">Selecione o Estado</option>
                            <option value="AC">Acre</option>
                            <option value="AL">Alagoas</option>
                            <option value="AP">Amapá</option>
                            <option value="AM">Amazonas</option>
                            <option value="BA">Bahia</option>
                            <option value="CE">Ceará</option>
                            <option value="DF">Distrito Federal</option>
                            <option value="ES">Espírito Santo</option>
                            <option value="GO">Goiás</option>
                            <option value="MA">Maranhão</option>
                            <option value="MT">Mato Grosso</option>
                            <option value="MS">Mato Grosso do Sul</option>
                            <option value="MG">Minas Gerais</option>
                            <option value="PA">Pará</option>
                            <option value="PB">Paraíba</option>
                            <option value="PR">Paraná</option>
                            <option value="PE">Pernambuco</option>
                            <option value="PI">Piauí</option>
                            <option value="RJ">Rio de Janeiro</option>
                            <option value="RN">Rio Grande do Norte</option>
                            <option value="RS">Rio Grande do Sul</option>
                            <option value="RO">Rondônia</option>
                            <option value="RR">Roraima</option>
                            <option value="SC">Santa Catarina</option>
                            <option value="SP">São Paulo</option>
                            <option value="SE">Sergipe</option>
                            <option value="TO">Tocantins</option>
                        </select>
                    </div>
  
                   
                    <label for="cidade" class="col-2 col-form-label">Cidade:</label>
                    <div class="col-4">
                        <select class="form-control" type="text" id="cidade" name="cidade" required="true">
                        </select>
                    </div>
                             
                              
                </div>
                    
                    
                    <hr>
                    <h3>Endereço Secundário</h3>
                    <div class="form-group row">
                        
                    <label for="cepSec" class="col-2 col-form-label">CEP:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="cepSec" name="cepSec" required="true" value="${resultado.get(0).endereco.cepSec}">
                    </div>
                </div>
                
                <div class="form-group row">

                    <label for="logradouroSec" class="col-2 col-form-label">Logradouro:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="logradouroSec" name="logradouroSec" required="true" value="${resultado.get(0).endereco.logradouroSec}">
                    </div>
                    
                    <label for="numeroSec" class="col-2 col-form-label">Número:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="numeroSec" name="numeroSec" required="true" value="${resultado.get(0).endereco.numeroSec}">
                    </div>
                    
                </div>
              
                <div class="form-group row">

                    <label for="complementoSec" class="col-2 col-form-label">Complemento:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="complementoSec" name="complementoSec" value="${resultado.get(0).endereco.complementoSec}">
                    </div>
                    
                    <label for="bairroSec" class="col-2 col-form-label">Bairro:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="bairroSec" name="bairroSec" required="true" value="${resultado.get(0).endereco.bairroSec}">
                    </div>
                    
                </div>
                
                <div class="form-group row">    
                    
                    <label for="estadoSec" class="col-2 col-form-label">Estado:</label>
                    <div class="col-4">
                        <select class="form-control" type="text" id="estadoSec" name="estadoSec" onchange="buscaCidades2(this.value)" required="true">
                            <option value="">Selecione o Estado</option>
                            <option value="AC">Acre</option>
                            <option value="AL">Alagoas</option>
                            <option value="AP">Amapá</option>
                            <option value="AM">Amazonas</option>
                            <option value="BA">Bahia</option>
                            <option value="CE">Ceará</option>
                            <option value="DF">Distrito Federal</option>
                            <option value="ES">Espírito Santo</option>
                            <option value="GO">Goiás</option>
                            <option value="MA">Maranhão</option>
                            <option value="MT">Mato Grosso</option>
                            <option value="MS">Mato Grosso do Sul</option>
                            <option value="MG">Minas Gerais</option>
                            <option value="PA">Pará</option>
                            <option value="PB">Paraíba</option>
                            <option value="PR">Paraná</option>
                            <option value="PE">Pernambuco</option>
                            <option value="PI">Piauí</option>
                            <option value="RJ">Rio de Janeiro</option>
                            <option value="RN">Rio Grande do Norte</option>
                            <option value="RS">Rio Grande do Sul</option>
                            <option value="RO">Rondônia</option>
                            <option value="RR">Roraima</option>
                            <option value="SC">Santa Catarina</option>
                            <option value="SP">São Paulo</option>
                            <option value="SE">Sergipe</option>
                            <option value="TO">Tocantins</option>
                        </select>
                    </div>
  
                    <label for="cidadeSec" class="col-2 col-form-label">Cidade:</label>
                    <div class="col-4">
                        <select class="form-control" type="text" id="cidadeSec" name="cidadeSec" required="true">
                        </select>
                    </div>
                </div>    
                    
                <br/>
                
                <hr>                               
                               
                <br />
                    
                <input type="text" name="idEndereco" value="${resultado.get(0).endereco.id}"/>
                <input type="text" name="idVeiculo" value="${resultado.get(0).veiculo.id}"/>
                <input type="text" name="operacao" value="ALTERAR">
                <input type="text" name="idApolice" value="${resultado.get(0).id}"/>
                <input class="btn btn-primary" type="submit" value="alterar">
                <br/>
                
            </form>
            <br/>
            <br/>
        </div>    
                
        <!-- Bootstrap core JavaScript -->
        
        <script type="text/javascript">
            $("#placa").mask("AAA-0000");
            $("#anoFabricacao").mask("0000");
            $("#anoModelo").mask("0000");
            $("#chassi").mask("000000000000000000"); 
            $("#cep").mask("00000-000");  
            
            $(window).load(function(){
                var data = new Date();

                // Guarda cada pedaço em uma variável
                var dia = data.getDate();          // 1-31
                var mes = data.getMonth();         // 0-11 (zero=janeiro)
                mes++;
                var ano = data.getFullYear();       // 4 dígitos

                if (dia < 10){
                    dia = '0'+dia;
                }
                if (mes < 10){
                    mes = '0'+mes;
                }             
                dataAtual = dia+'/'+mes+'/'+ano;                
                document.getElementById('dataInicio').value = dataAtual;

            });
            
        </script>
        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    </body>
</html>
