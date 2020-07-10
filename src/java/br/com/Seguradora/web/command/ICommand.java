package br.com.Seguradora.web.command;

import br.com.Seguradora.core.fachada.Resultado;
import br.com.Seguradora.dominio.EntidadeDominio;

public interface ICommand {
    
    public Resultado execute(EntidadeDominio entidade);
    
}
