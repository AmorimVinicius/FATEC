package br.com.Seguradora.core.fachada;

import br.com.Seguradora.dominio.EntidadeDominio;
import java.util.List;

public class Resultado {

    private String msg;
    private EntidadeDominio entidade;
    private List<EntidadeDominio> entidades;

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the entidade
     */
    public EntidadeDominio getEntidade() {
        return entidade;
    }

    /**
     * @param entidade the entidade to set
     */
    public void setEntidade(EntidadeDominio entidade) {
        this.entidade = entidade;
    }

    /**
     * @return the entidades
     */
    public List<EntidadeDominio> getEntidades() {
        return entidades;
    }

    /**
     * @param entidades the entidades to set
     */
    public void setEntidades(List<EntidadeDominio> entidades) {
        this.entidades = entidades;
    }
    
    
    
}
