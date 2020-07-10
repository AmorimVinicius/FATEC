package br.com.Seguradora.core.negocio;

import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Mecanica;

public class DadosObrigatoriosMecanica implements IStrategy{

    @Override
    public String processar(EntidadeDominio entidade) {
        if(entidade instanceof Mecanica){
            Mecanica m = (Mecanica)entidade;
            
            
        }else{
            return "Dado não pode ser validado, pois entidade não é um Cliente Jurídico!";
        }
        return null;
    }   
    
}
