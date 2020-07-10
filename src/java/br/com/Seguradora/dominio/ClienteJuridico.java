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
public class ClienteJuridico extends Pessoa {

    private String cnpj;
    private String email;
    private String pessoaResponsavel;
    private String infoAdicional;
    private String teste;

    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the pessoaResponsavel
     */
    public String getPessoaResponsavel() {
        return pessoaResponsavel;
    }

    /**
     * @param pessoaResponsavel the pessoaResponsavel to set
     */
    public void setPessoaResponsavel(String pessoaResponsavel) {
        this.pessoaResponsavel = pessoaResponsavel;
    }

    /**
     * @return the infoAdicional
     */
    public String getInfoAdicional() {
        return infoAdicional;
    }

    /**
     * @param infoAdicional the infoAdicional to set
     */
    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }    

    /**
     * @return the teste
     */
    public String getTeste() {
        return teste;
    }

    /**
     * @param teste the teste to set
     */
    public void setTeste(String teste) {
        this.teste = teste;
    }    

 

    
    
}
