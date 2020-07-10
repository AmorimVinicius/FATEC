package br.com.Seguradora.web.command;

import br.com.Seguradora.core.fachada.Fachada;
import br.com.Seguradora.core.fachada.IFachada;

public abstract class AbstractCommand implements ICommand{
    
    protected IFachada fachada = new Fachada();

}
