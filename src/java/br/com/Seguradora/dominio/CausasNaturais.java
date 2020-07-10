/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.dominio;

/**
 *
 * @author viniciusamorim
 */
public class CausasNaturais extends EntidadeDominio{
    
    private String descricao;
    private Cliente cliente;
    private Veiculo veiculo;
    private Sinistro sinistro;
    private Apolice apolice;
    private String atualizacao;
    private Mecanica mecanica;
    private Pessoa pessoa;
    private Endereco endereco;
    private Cidade cidade;
    private Estado estado;

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

    /**
     * @return the mecanica
     */
    public Mecanica getMecanica() {
        return mecanica;
    }

    /**
     * @param mecanica the mecanica to set
     */
    public void setMecanica(Mecanica mecanica) {
        this.mecanica = mecanica;
    }

    /**
     * @return the pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    /**
     * @return the endereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
    
    
    
}
