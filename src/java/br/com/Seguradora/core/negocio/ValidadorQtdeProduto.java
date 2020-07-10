package br.com.Seguradora.core.negocio;

import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Produto;

public class ValidadorQtdeProduto implements IStrategy{

    @Override
	public String processar(EntidadeDominio entidade) {
		
		if(entidade instanceof Produto){
			Produto c = (Produto)entidade;
			
			if(c.getDescricao()== null || c.getDescricao().trim().equals("")){
				return "Campo obrigatório em branco. Descrição.";
			}
                        
                        if(Integer.toString(c.getQuantidade())== null){
				return "Campo obrigatório em branco. Quantidade.";
			}
			
		}else{
			return "Quantidade nao pode ser validado, pois entidade nao eh um produto!";
		}
		
		
		return null;
	}
    
    
}
