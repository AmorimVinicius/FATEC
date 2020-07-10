/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.web.command;

import br.com.Seguradora.core.fachada.Resultado;
import br.com.Seguradora.dominio.EntidadeDominio;

/**
 *
 * @author viniciusamorim
 */
public class AutenticarCommand extends AbstractCommand{
    
    @Override
    public Resultado execute(EntidadeDominio entidade) {
	return fachada.autenticar(entidade);
    }

}
