package br.com.Seguradora.dominio;

/**
 *
 * @author viniciusamorim
 */
public class Grafico extends EntidadeDominio{
    
    private String dataInicial;
    private String dataFinal;
    private Integer quantidade;
    private Integer aprovado;
    private Integer recusado;
    private Integer aguardando;
    

    /**
     * @return the dataInicial
     */
    public String getDataInicial() {
        return dataInicial;
    }

    /**
     * @param dataInicial the dataInicial to set
     */
    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    /**
     * @return the dataFinal
     */
    public String getDataFinal() {
        return dataFinal;
    }

    /**
     * @param dataFinal the dataFinal to set
     */
    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    /**
     * @return the quantidaed
     */
    public Integer getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidaed to set
     */
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the aprovado
     */
    public Integer getAprovado() {
        return aprovado;
    }

    /**
     * @param aprovado the aprovado to set
     */
    public void setAprovado(Integer aprovado) {
        this.aprovado = aprovado;
    }

    /**
     * @return the recusado
     */
    public Integer getRecusado() {
        return recusado;
    }

    /**
     * @param recusado the recusado to set
     */
    public void setRecusado(Integer recusado) {
        this.recusado = recusado;
    }

    /**
     * @return the aguardando
     */
    public Integer getAguardando() {
        return aguardando;
    }

    /**
     * @param aguardando the aguardando to set
     */
    public void setAguardando(Integer aguardando) {
        this.aguardando = aguardando;
    }

    
    
    
}
