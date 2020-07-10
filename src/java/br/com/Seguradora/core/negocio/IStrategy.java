package br.com.Seguradora.core.negocio;

import br.com.Seguradora.dominio.EntidadeDominio;

public interface IStrategy {
    
    public String processar(EntidadeDominio entidade);
    
}
