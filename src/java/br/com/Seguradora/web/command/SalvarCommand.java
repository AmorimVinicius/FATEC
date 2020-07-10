package br.com.Seguradora.web.command;

import br.com.Seguradora.core.fachada.Resultado;
import br.com.Seguradora.dominio.EntidadeDominio;

public class SalvarCommand extends AbstractCommand{

    @Override
    public Resultado execute(EntidadeDominio entidade) {
        return fachada.salvar(entidade);
    }
    
    
    
}
