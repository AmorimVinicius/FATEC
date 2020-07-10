package br.com.Seguradora.dominio;

public class Veiculo extends EntidadeDominio{
    
    private String marca;
    private String modelo;
    private String placa;
    private String chassi;
    private String anoFabricacao;
    private String anoModelo;
    private String documentoCliente;
    private String numeroFrota;
    private String numeroApolice;
    private String tipoDocCliente;
    private String retornoConsultaDoc;
    private ModeloVeiculo modeloVeiculo;
    private Cliente cliente;
    private Apolice apolice;
    private Object studentImage;
    private Byte image_data;
    private String valorVeiculo;
    
    
    
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }
    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
    
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getAnoFabricacao() {
        return anoFabricacao;
    }
    public void setAnoFabricacao(String anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getAnoModelo() {
        return anoModelo;
    }
    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }
    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public String getNumeroFrota() {
        return numeroFrota;
    }
    public void setNumeroFrota(String numeroFrota) {
        this.numeroFrota = numeroFrota;
    }
    
    public String getNumeroApolice() {
        return numeroApolice;
    }
    public void setNumeroApolice(String numeroApolice) {
        this.numeroApolice = numeroApolice;
    }

    public String getTipoDocCliente() {
        return tipoDocCliente;
    }
    public void setTipoDocCliente(String tipoDocCliente) {
        this.tipoDocCliente = tipoDocCliente;
    }

    /**
     * @return the retornoConsultaDoc
     */
    public String getRetornoConsultaDoc() {
        return retornoConsultaDoc;
    }

    /**
     * @param retornoConsultaDoc the retornoConsultaDoc to set
     */
    public void setRetornoConsultaDoc(String retornoConsultaDoc) {
        this.retornoConsultaDoc = retornoConsultaDoc;
    }

    /**
     * @return the modeloVeiculo
     */
    
    public ModeloVeiculo getModeloVeiculo() {
        return modeloVeiculo;
    }

    /**
     * @param modeloVeiculo the modeloVeiculo to set
     */
    public void setModeloVeiculo(ModeloVeiculo modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
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
     * @return the studentImage
     */
    public Object getStudentImage() {
        return studentImage;
    }

    /**
     * @param studentImage the studentImage to set
     */
    public void setStudentImage(Object studentImage) {
        this.studentImage = studentImage;
    } 

    /**
     * @return the image_data
     */
    public Byte getImage_data() {
        return image_data;
    }

    /**
     * @param image_data the image_data to set
     */
    public void setImage_data(Byte image_data) {
        this.image_data = image_data;
    }

    /**
     * @return the valorVeiculo
     */
    public String getValorVeiculo() {
        return valorVeiculo;
    }

    /**
     * @param valorVeiculo the valorVeiculo to set
     */
    public void setValorVeiculo(String valorVeiculo) {
        this.valorVeiculo = valorVeiculo;
    }

    
   
}
