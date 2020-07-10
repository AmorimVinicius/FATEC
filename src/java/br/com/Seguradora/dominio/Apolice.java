package br.com.Seguradora.dominio;

public class Apolice extends EntidadeDominio{
    
    private String dataInicio;
    private String dataFim;
    private String premio;
    private String valorApolice;
    private String tipoApolice;
    private Cliente cliente;
    private Veiculo veiculo;
    private Endereco endereco;
    private String numeroApolice;
    private String habilitados;
    private Cidade cidade;
    private Estado estado;
    private String statusEnderecoPrincipal;
    private String statusEnderecoSecundario;
        
    /**
     * @return the dataInicio
     */
    public String getDataInicio() {
        return dataInicio;
    }

    /**
     * @param dataInicio the dataInicio to set
     */
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
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

    /**
     * @return the premio
     */
    public String getPremio() {
        return premio;
    }

    /**
     * @param premio the premio to set
     */
    public void setPremio(String premio) {
        this.premio = premio;
    }

    /**
     * @return the valorApolice
     */
    public String getValorApolice() {
        return valorApolice;
    }

    /**
     * @param valorApolice the valorApolice to set
     */
    public void setValorApolice(String valorApolice) {
        this.valorApolice = valorApolice;
    }

    /**
     * @return the tipoApolice
     */
    public String getTipoApolice() {
        return tipoApolice;
    }

    /**
     * @param tipoApolice the tipoApolice to set
     */
    public void setTipoApolice(String tipoApolice) {
        this.tipoApolice = tipoApolice;
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
     * @return the numeroApolice
     */
    public String getNumeroApolice() {
        return numeroApolice;
    }

    /**
     * @param numeroApolice the numeroApolice to set
     */
    public void setNumeroApolice(String numeroApolice) {
        this.numeroApolice = numeroApolice;
    }

    /**
     * @return the habilitados
     */
    public String getHabilitados() {
        return habilitados;
    }

    /**
     * @param habilitados the habilitados to set
     */
    public void setHabilitados(String habilitados) {
        this.habilitados = habilitados;
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

    /**
     * @return the statusEnderecoPrincipal
     */
    public String getStatusEnderecoPrincipal() {
        return statusEnderecoPrincipal;
    }

    /**
     * @param statusEnderecoPrincipal the statusEnderecoPrincipal to set
     */
    public void setStatusEnderecoPrincipal(String statusEnderecoPrincipal) {
        this.statusEnderecoPrincipal = statusEnderecoPrincipal;
    }

    /**
     * @return the statusEnderecoSecundario
     */
    public String getStatusEnderecoSecundario() {
        return statusEnderecoSecundario;
    }

    /**
     * @param statusEnderecoSecundario the statusEnderecoSecundario to set
     */
    public void setStatusEnderecoSecundario(String statusEnderecoSecundario) {
        this.statusEnderecoSecundario = statusEnderecoSecundario;
    }
    
    
    
}
