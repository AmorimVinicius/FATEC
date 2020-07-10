// CARREGAR VEICULOS CADASTRADOS PARA O CLIENTE
<script language="javascript">    
    var radios = document.body.querySelectorAll("input[id='veiculoSelecionado']");                        
    for(var x=0; x<radios.length; x++){
        radios[x].onclick = function(){
            clique(this.value);
        }
    }                                                
    
    function clique(i){
        document.getElementById('idVeiculo').value = i;
    } 
</script>    
    

<!-- CARREGAR SOMENTE IMAGENS -->
<script language="javascript">      
    function isImagem(i){   
        var img = i.value.split(".");
        var ext = "."+img.pop();

        if(!ext.match(/\.(jpeg|jpg|png|)$/i)){
            alert("Somente é permitido imagens .jpeg, .jpg ou .png");
            i.value = '';
            return;
            }
    }
</script>  


<!-- CARREGAR INFORMACOES QUANDO SINISTRO FOR DE TERCEIRO -->
<script language="javascript">   
    function mostraCampo(el){                     
        if (el.value === 'Terceiros'){ 
            document.getElementById('classeClienteTerceiro').style.display = "block";
            document.getElementById('classeVeiculoTerceiro').style.display = "block";
            document.getElementById('classeItemVeiculoTerceiro').style.display = "block";
        }
    }
</script>


<script type="text/javascript"> 
                    var data = new Date();
                    var dia = data.getDay();
                    var mes = data.getMonth(); mes++;
                    var ano = data.getYear();
                    document.getElementById('dataInicio').value = ano;
                    $(document).ready(function(){
                    alert("oi");
                    });
</script>


<script language="javascript">                      
                        var radios = document.body.querySelectorAll("input[id='enderecoPrincipal']");                        
                        for(var x=0; x<radios.length; x++){
                            radios[x].onclick = function(){
                                clique(this.value);
                            }
                        }
                        
                        var radios = document.body.querySelectorAll("input[id='enderecoPernoite']");
                        for(var x=0; x<radios.length; x++){
                            radios[x].onclick = function(){
                                clique2(this.value);
                            }
                        }
                        
                        function clique(i){
                           document.getElementById('idEndereco').value = i;
                           document.getElementById('cep').disabled = true;
                           document.getElementById('logradouro').disabled = true;
                           document.getElementById('numero').disabled = true;
                           document.getElementById('complemento').disabled = true;
                           document.getElementById('bairro').disabled = true;
                           document.getElementById('cidade').disabled = true;
                           document.getElementById('estado').disabled = true;
                        }                        
                        function clique2(i){
                           document.getElementById('idPernoite').value = i;
                           document.getElementById('cepSec').disabled = true;
                           document.getElementById('logradouroSec').disabled = true;
                           document.getElementById('numeroSec').disabled = true;
                           document.getElementById('complementoSec').disabled = true;
                           document.getElementById('bairroSec').disabled = true;
                           document.getElementById('cidadeSec').disabled = true;
                           document.getElementById('estadoSec').disabled = true;
                        }
                      
                                               
                    </script>

<script 
    