package br.com.Seguradora.web.command;

import br.com.Seguradora.core.fachada.Resultado;
import br.com.Seguradora.dominio.EntidadeDominio;

/**
 *
 * @author viniciusamorim
 */
public class AlterarCommand extends AbstractCommand{

    @Override
    public Resultado execute(EntidadeDominio entidade) {
        return fachada.alterar(entidade);
    }
    
}
