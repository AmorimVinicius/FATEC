
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
        <div class="container-fluid">   

            <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
                <a class="navbar-brand" href="#">Seguradora</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="../admin/index.jsp">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Corretor
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="cadastrarCorretor.jsp">Cadastrar Corretor</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="consultarCorretor.jsp">Consultar Corretor</a>
                            </div>
                        </li>                        
                    </ul>
                </div>
            </nav>
        </div>
        <br/> <br/> <br/> <br/> <br/>
        <div class="container">	
            <h2>Cadastrar Corretor</h2>
            <form action='salvar' method="POST" >
                
                <c:if test="${mensagem != null}">
                    <br/>
                    <p>${mensagem}</p>
                </c:if>
                <br/>
                
                <div class="form-group row">
                    <label for="razaoSocial" class="col-2 col-form-label">Razão Social:</label>
                    <div class="col-4">
                        <input class="form-control" type="text" id="razaoSocial" name="razaoSocial" required="true" maxlength="100">
                    </div>
                    <label for="nomeFantasia" class="col-2 col-form-label">Nome Fantasia:</label>
                    <div class="col-4">
                        <input class="form-control" type="text" id="nomeFantasia" name="nomeFantasia" required="true" maxlength="100">
                    </div>

                </div>
                
                <div class="form-group row">
                    <label for="documento" class="col-2 col-form-label">CNPJ:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="documento" name="documento" required="true" maxlength="14">
                    </div>
                    <label for="email" class="col-2 col-form-label">E-mail:</label>
                    <div class="col-5">
                        <input class="form-control" type="email" id="email" name="email" required="true" maxlength="60">
                    </div>
                </div>

                
                <div class="form-group row">

                    <label for="telefoneComercial" class="col-2 col-form-label">Telefone Comercial:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="telefoneComercial" name="telefoneComercial" maxlength="10">
                    </div>
                    <label for="telefoneCelular" class="col-2 col-form-label">Telefone Celular:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="telefoneCelular" name="telefoneCelular" required="true" maxlength="10"> 
                    </div>
                </div>
                
                <div class="form-group row">

                    <label for="pessoaResponsavel" class="col-2 col-form-label">Pessoa Responsável:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="pessoaResponsavel" name="pessoaResponsavel" maxlength="100" required>
                    </div>
                </div>
                
                <div class="form-group row">

                    <label for="infoAdicional" class="col-2 col-form-label">Info Adicional:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="infoAdicional" name="infoAdicional" maxlength="100">
                    </div>
                    
                    <label for="clienteAssociado" class="col-2 col-form-label">Cliente Associado:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="clienteAssociado" name="clienteAssociado" maxlength="100">
                    </div>
                    
                </div>
               
                <hr><br />
                
                <h2>Endereço Principal</h2>
                
                <div class="form-group row">

                    <label for="cep" class="col-2 col-form-label">CEP:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="cep" name="cep" required="true">
                    </div>
                </div>
                
                <div class="form-group row">

                    <label for="logradouro" class="col-2 col-form-label">Logradouro:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="logradouro" name="logradouro" required="true">
                    </div>
                    
                    <label for="numero" class="col-2 col-form-label">Número:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="numero" name="numero" required="true" maxlength="6">
                    </div>
                    
                </div>
              
                <div class="form-group row">

                    <label for="complemento" class="col-2 col-form-label">Complemento:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="complemento" name="complemento">
                    </div>
                    
                    <label for="bairro" class="col-2 col-form-label">Bairro:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="bairro" name="bairro" required="true">
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
                
                <hr><br />
                
                <h2>Endereço Secundário</h2>
                    
                <script language="javascript">
                    function endereco(){
                        if(document.getElementById('enderecoSec').checked == true){
                            document.getElementById('cepSec').disabled = false;  
                            document.getElementById('logradouroSec').disabled = false; 
                            document.getElementById('numeroSec').disabled = false; 
                            document.getElementById('complementoSec').disabled = false; 
                            document.getElementById('bairroSec').disabled = false; 
                            document.getElementById('cidadeSec').disabled = false; 
                            document.getElementById('estadoSec').disabled = false; 
                        }
                        if(document.getElementById('enderecoSec').checked == false){
                            document.getElementById('cepSec').disabled = true;
                            document.getElementById('logradouroSec').disabled = true; 
                            document.getElementById('numeroSec').disabled = true; 
                            document.getElementById('complementoSec').disabled = true; 
                            document.getElementById('bairroSec').disabled = true; 
                            document.getElementById('cidadeSec').disabled = true; 
                            document.getElementById('estadoSec').disabled = true; 
                        }
                    }
                </script>
              
                <input type="radio" id="enderecoSec" onClick="endereco()" name="enderecoSec" value="enderecoAtivo"/> Ativar   
                <input type="radio" id="enderecoSec" onClick="endereco()" name="enderecoSec" value="enderecoAtivo"/> Desativar
                
                <div class="form-group row">
                        
                    <label for="cepSec" class="col-2 col-form-label">CEP:</label>
                    <div class="col-2">
                        <input class="form-control" type="text" id="cepSec" name="cepSec" required="true" disabled>
                    </div>
                </div>
                
                <div class="form-group row">

                    <label for="logradouroSec" class="col-2 col-form-label">Logradouro:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="logradouroSec" name="logradouroSec" required="true" disabled>
                    </div>
                    
                    <label for="numeroSec" class="col-2 col-form-label">Número:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="numeroSec" name="numeroSec" required="true" disabled>
                    </div>
                    
                </div>
              
                <div class="form-group row">

                    <label for="complementoSec" class="col-2 col-form-label">Complemento:</label>
                    <div class="col-3">
                        <input class="form-control" type="text" id="complementoSec" name="complementoSec" disabled>
                    </div>
                    
                    <label for="bairroSec" class="col-2 col-form-label">Bairro:</label>
                    <div class="col-5">
                        <input class="form-control" type="text" id="bairroSec" name="bairroSec" required="true" disabled>
                    </div>
                    
                </div>
                
                <div class="form-group row">    
                    
                    <label for="estadoSec" class="col-2 col-form-label">Estado:</label>
                    <div class="col-4">
                        <select class="form-control" type="text" id="estadoSec" name="estadoSec" onchange="buscaCidades2(this.value)" required="true" disabled="true">
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
                        <select class="form-control" type="text" id="cidadeSec" name="cidadeSec" required="true" disabled="true">
                        </select>
                    </div>
                    
                </div> 
                <hr>
                <input type="hidden" name="operacao" value="SALVAR">
                <input type='submit' class="btn btn-primary" name='Salvar' value='Salvar' />
                <br/>
                
            </form>
            <br/>
            <br/>
        </div>    
                
        <!-- Bootstrap core JavaScript -->
        
        <script type="text/javascript">
            $("#telefoneCelular").mask("(00) 00000-0000");
            $("#telefoneComercial").mask("(00) 0000-0000");
            $("#documento").mask("00.000.000/0000-00");
            $("#cep").mask("00000-000");
            $("#clienteAssociado").mask("000.000.000-00");
        </script>
        
        <!-- Bootstrap core JavaScript -->
        <script src="../style/js/jquery-3.3.1.min.js"></script>
        <script src="../style/js/popper.min.js"></script>
        <script src="../style/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    
        
    </body>
</html>

