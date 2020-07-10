package br.com.Seguradora.dominio;

public class Cidade extends EntidadeDominio{
    
    private String cidade;
    private String cidadeSec;

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the cidadeSec
     */
    public String getCidadeSec() {
        return cidadeSec;
    }

    /**
     * @param cidadeSec the cidadeSec to set
     */
    public void setCidadeSec(String cidadeSec) {
        this.cidadeSec = cidadeSec;
    }
    
}
