package br.com.Seguradora.web.command;

import br.com.Seguradora.core.fachada.Resultado;
import br.com.Seguradora.dominio.EntidadeDominio;
import java.util.List;

/**
 *
 * @author hisak
 */
public class FiltrarCommand extends AbstractCommand{
        
    @Override
    	public Resultado execute(EntidadeDominio entidade) {
		
		return fachada.listarfiltro(entidade);
	}
    
}
