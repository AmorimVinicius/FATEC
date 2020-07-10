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
public class Sinistro extends EntidadeDominio{
    
    private String tipo;
    private String descricao;
    private String recuperaTipo;
    private Veiculo veiculo;
    private Endereco endereco;
    private Corretor corretor;
    private Cliente cliente;
    private Apolice apolice;
    private String comprovanteDocumento;
    private String comprovanteEndereco;
    private String comprovanteCRVL;
    private String comprovanteCNH;
    private String comprovanteBO;
    private String aceite;
    private String dataAceiteRecusa;
    private ClienteTerceiro clienteTerceiro;
    private Mecanica mecanica;
    private String dataFim;
    

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
     * @return the corretor
     */
    public Corretor getCorretor() {
        return corretor;
    }

    /**
     * @param corretor the corretor to set
     */
    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
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
     * @return the recuperaTipo
     */
    public String getRecuperaTipo() {
        return recuperaTipo;
    }

    /**
     * @param recuperaTipo the recuperaTipo to set
     */
    public void setRecuperaTipo(String recuperaTipo) {
        this.recuperaTipo = recuperaTipo;
    }
    /**
     * @return the comprovanteDocumento
     */
    public String getComprovanteDocumento() {
        return comprovanteDocumento;
    }

    /**
     * @param comprovanteDocumento the comprovanteDocumento to set
     */
    public void setComprovanteDocumento(String comprovanteDocumento) {
        this.comprovanteDocumento = comprovanteDocumento;
    }

    /**
     * @return the comprovanteEndereco
     */
    public String getComprovanteEndereco() {
        return comprovanteEndereco;
    }

    /**
     * @param comprovanteEndereco the comprovanteEndereco to set
     */
    public void setComprovanteEndereco(String comprovanteEndereco) {
        this.comprovanteEndereco = comprovanteEndereco;
    }

    /**
     * @return the comprovanteCRVL
     */
    public String getComprovanteCRVL() {
        return comprovanteCRVL;
    }

    /**
     * @param comprovanteCRVL the comprovanteCRVL to set
     */
    public void setComprovanteCRVL(String comprovanteCRVL) {
        this.comprovanteCRVL = comprovanteCRVL;
    }

    /**
     * @return the comprovanteCNH
     */
    public String getComprovanteCNH() {
        return comprovanteCNH;
    }

    /**
     * @param comprovanteCNH the comprovanteCNH to set
     */
    public void setComprovanteCNH(String comprovanteCNH) {
        this.comprovanteCNH = comprovanteCNH;
    }

    /**
     * @return the comprovanteBO
     */
    public String getComprovanteBO() {
        return comprovanteBO;
    }

    /**
     * @param comprovanteBO the comprovanteBO to set
     */
    public void setComprovanteBO(String comprovanteBO) {
        this.comprovanteBO = comprovanteBO;
    }

    /**
     * @return the aceite
     */
    public String getAceite() {
        return aceite;
    }

    /**
     * @param aceite the aceite to set
     */
    public void setAceite(String aceite) {
        this.aceite = aceite;
    }

    /**
     * @return the dataAceiteRecusa
     */
    public String getDataAceiteRecusa() {
        return dataAceiteRecusa;
    }

    /**
     * @param dataAceiteRecusa the dataAceiteRecusa to set
     */
    public void setDataAceiteRecusa(String dataAceiteRecusa) {
        this.dataAceiteRecusa = dataAceiteRecusa;
    }

    /**
     * @return the clienteTerceiro
     */
    public ClienteTerceiro getClienteTerceiro() {
        return clienteTerceiro;
    }

    /**
     * @param clienteTerceiro the clienteTerceiro to set
     */
    public void setClienteTerceiro(ClienteTerceiro clienteTerceiro) {
        this.clienteTerceiro = clienteTerceiro;
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
     * @return the dataFim
     */
    public String getDataFim() {
        return dataFim;
    }

    /**
     * @param dataFim the dataFim to set
     */
    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
    
    
    
}
