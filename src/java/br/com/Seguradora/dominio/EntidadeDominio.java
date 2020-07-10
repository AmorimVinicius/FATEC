package br.com.Seguradora.dominio;

import java.util.Date;

public class EntidadeDominio implements IEntidade{
	
    private Integer id;
    private Date dtCadastro;
    private Integer status; 
    private String operacao;
    private String operacaoDAO;
        
	
    public Integer getId() {
	return id;
    }
    public void setId(Integer id) {
	this.id = id;
    }
    
    public Date getDtCadastro() {
    	return dtCadastro;
    }
    public void setDtCadastro(Date dtCadastro) {
    	this.dtCadastro = dtCadastro;
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the operacao
     */
    public String getOperacao() {
        return operacao;
    }

    /**
     * @param operacao the operacao to set
     */
    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    /**
     * @return the operacaoDAO
     */
    public String getOperacaoDAO() {
        return operacaoDAO;
    }

    /**
     * @param operacaoDAO the operacaoDAO to set
     */
    public void setOperacaoDAO(String operacaoDAO) {
        this.operacaoDAO = operacaoDAO;
    }

    
}
