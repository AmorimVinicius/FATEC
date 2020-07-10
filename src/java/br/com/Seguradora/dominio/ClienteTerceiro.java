package br.com.Seguradora.dominio;

public class ClienteTerceiro extends Cliente{
    
    private Veiculo veiculo;
    private String descricao;
    private Cliente cliente;
    private Sinistro sinistro;
    private Apolice apolice;
    private String atualizacao;

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the veiculo
     */
    public Veiculo getVeiculo() {
        return veiculo;
    }

    /**
     * @param veiculo the veiculo to set
     */
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    /**
     * @return the sinistro
     */
    public Sinistro getSinistro() {
        return sinistro;
    }

    /**
     * @param sinistro the sinistro to set
     */
    public void setSinistro(Sinistro sinistro) {
        this.sinistro = sinistro;
    }

    /**
     * @return the apolice
     */
    public Apolice getApolice() {
        return apolice;
    }

    /**
     * @param apolice the apolice to set
     */
    public void setApolice(Apolice apolice) {
        this.apolice = apolice;
    }

    /**
     * @return the atualizacao
     */
    public String getAtualizacao() {
        return atualizacao;
    }

    /**
     * @param atualizacao the atualizacao to set
     */
    public void setAtualizacao(String atualizacao) {
        this.atualizacao = atualizacao;
    }
    
}
