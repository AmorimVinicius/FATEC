function regraCalculo(el){
                    var valorVeiculo = "34500";
                    var habilitados = document.getElementsByName('habilitados')[0].value;
                    var premio = 0;
                    var franquia = 0;
                    var porcentagem = 0;

                    if (el.value === 'Colisao'){
                        porcentagem = 0.1;
                        if (habilitados > 2){
                            porcentagem = porcentagem + 0.1;
                            premio = (valorVeiculo*porcentagem);
                            franquia = premio/2;
                            premio = parseFloat(premio.toFixed(2));
                            document.getElementsByName('premio')[0].value = premio;
                            document.getElementsByName('valorApolice')[0].value = franquia;
                        }else{
                            premio = (valorVeiculo*porcentagem);
                            franquia = premio/2;
                            document.getElementsByName('premio')[0].value = premio;
                            document.getElementsByName('valorApolice')[0].value = franquia;
                        }
                    }else if (el.value === 'Terceiros'){
                        porcentagem = 0.15;
                        if (habilitados > 2){
                            porcentagem = porcentagem + 0.1;
                            premio = (valorVeiculo*porcentagem);
                            franquia = premio/2;
                            document.getElementById('premio').value = premio;
                            document.getElementById('valorApolice').value = franquia;
                        }else{
                            premio = (valorVeiculo*porcentagem);
                            franquia = premio/2;
                            document.getElementsByName('premio')[0].value = premio;
                            document.getElementsByName('valorApolice')[0].value = franquia;
                        }
                    }else if (el.value === 'FurtoRoubo'){
                        porcentagem = 0.07;
                        if (habilitados > 2){
                            porcentagem = porcentagem + 0.1;
                            premio = (valorVeiculo*porcentagem);
                            franquia = premio/2;
                            document.getElementById('premio').value = premio;
                            document.getElementById('valorApolice').value = franquia;
                        }else{
                            premio = (valorVeiculo*porcentagem);
                            franquia = premio/2;
                            document.getElementsByName('premio')[0].value = premio;
                            document.getElementsByName('valorApolice')[0].value = franquia;
                        }
                    }else if (el.value === 'Incendio'){
                        porcentagem = 0.035;
                        if (habilitados > 2){
                            porcentagem = porcentagem + 0.1;
                            premio = (valorVeiculo*porcentagem);
                            franquia = premio/2;
                            document.getElementById('premio').value = premio;
                            document.getElementById('valorApolice').value = franquia;
                        }else{
                            premio = (valorVeiculo*porcentagem);
                            franquia = premio/2;
                            document.getElementsByName('premio')[0].value = premio;
                            document.getElementsByName('valorApolice')[0].value = franquia;
                        }
                    }else if (el.value === 'CausasNaturais'){
                        porcentagem = 0.035;
                        if (habilitados > 2){
                            porcentagem = porcentagem + 0.1;
                            premio = (valorVeiculo*porcentagem);
                            franquia = premio/2;
                            document.getElementById('premio').value = premio;
                            document.getElementById('valorApolice').value = franquia;
                        }else{
                            premio = (valorVeiculo*porcentagem);
                            franquia = premio/2;
                            document.getElementsByName('premio')[0].value = premio;
                            document.getElementsByName('valorApolice')[0].value = franquia;
                        }
                    }else if (el.value === 'Compreensivo'){
                        porcentagem = 0.3;
                        if (habilitados > 2){
                            porcentagem = porcentagem + 0.1;
                            premio = (valorVeiculo*porcentagem);
                            franquia = premio/2;
                            document.getElementById('premio').value = premio;
                            document.getElementById('valorApolice').value = franquia;
                        }else{
                            premio = (valorVeiculo*porcentagem);
                            franquia = premio/2;
                            document.getElementsByName('premio')[0].value = premio;
                            document.getElementsByName('valorApolice')[0].value = franquia;
                        }
                    }
                }