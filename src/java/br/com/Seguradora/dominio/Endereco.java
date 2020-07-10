package br.com.Seguradora.dominio;

public class Endereco extends EntidadeDominio{

    private Integer idPernoite;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private Estado estado;       
    private Cidade cidade;
        
    private String cepSec;
    private String logradouroSec;
    private String numeroSec;
    private String complementoSec;
    private String bairroSec;
    private Estado estadoSec;
    private Cidade cidadeSec;

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * @return the cepSec
     */
    public String getCepSec() {
        return cepSec;
    }

    /**
     * @param cepSec the cepSec to set
     */
    public void setCepSec(String cepSec) {
        this.cepSec = cepSec;
    }

    /**
     * @return the logradouroSec
     */
    public String getLogradouroSec() {
        return logradouroSec;
    }

    /**
     * @param logradouroSec the logradouroSec to set
     */
    public void setLogradouroSec(String logradouroSec) {
        this.logradouroSec = logradouroSec;
    }

    /**
     * @return the numeroSec
     */
    public String getNumeroSec() {
        return numeroSec;
    }

    /**
     * @param numeroSec the numeroSec to set
     */
    public void setNumeroSec(String numeroSec) {
        this.numeroSec = numeroSec;
    }

    /**
     * @return the complementoSec
     */
    public String getComplementoSec() {
        return complementoSec;
    }

    /**
     * @param complementoSec the complementoSec to set
     */
    public void setComplementoSec(String complementoSec) {
        this.complementoSec = complementoSec;
    }

    /**
     * @return the bairroSec
     */
    public String getBairroSec() {
        return bairroSec;
    }

    /**
     * @param bairroSec the bairroSec to set
     */
    public void setBairroSec(String bairroSec) {
        this.bairroSec = bairroSec;
    }

    /**
     * @return the estadoSec
     */
    public Estado getEstadoSec() {
        return estadoSec;
    }

    /**
     * @param estadoSec the estadoSec to set
     */
    public void setEstadoSec(Estado estadoSec) {
        this.estadoSec = estadoSec;
    }

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
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
        
    /**
     * @return the idPernoite
     */
    public Integer getIdPernoite() {
        return idPernoite;
    }

    /**
     * @param idPernoite the idPernoite to set
     */
    public void setIdPernoite(Integer idPernoite) {
        this.idPernoite = idPernoite;
    }
	
}