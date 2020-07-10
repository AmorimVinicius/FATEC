package br.com.Seguradora.dominio;

public class Estado extends EntidadeDominio{
    private String estado;
    private String estadoSec;
    private Cidade cidade;
    private Cidade cidadeSec;

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cidade getCidade() {
        return cidade;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estadoSec
     */
    public String getEstadoSec() {
        return estadoSec;
    }

    /**
     * @param estadoSec the estadoSec to set
     */
    public void setEstadoSec(String estadoSec) {
        this.estadoSec = estadoSec;
    }

    /**
     * @return the cidadeSec
     */
    public Cidade getCidadeSec() {
        return cidadeSec;
    }

    /**
     * @param cidadeSec the cidadeSec to set
     */
    public void setCidadeSec(Cidade cidadeSec) {
        this.cidadeSec = cidadeSec;
    }
    
    
    
    
}
