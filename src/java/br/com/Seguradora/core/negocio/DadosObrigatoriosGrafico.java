/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.core.negocio;

import br.com.Seguradora.core.dao.GraficoDAO;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Grafico;

/**
 *
 * @author viniciusamorim
 */
public class DadosObrigatoriosGrafico implements IStrategy{

    @Override
    public String processar(EntidadeDominio entidade) {
         if(entidade instanceof Grafico){
            Grafico g = (Grafico)entidade;
            GraficoDAO graficoDAO = new GraficoDAO();
          
         // VERIFICAR STATUS SINISTRO
            if (g.getOperacao().equals("LISTARFILTRO")){
                boolean verificaIntervalo = GraficoDAO.verificaIntervalo(g.getDataInicial(), g.getDataFinal());
                if(verificaIntervalo == false){
                    return "Não existem sinistros para o intervalo de datas informado.";
                }
            }   
            
        }else{
            return "Dado não pode ser validado, pois entidade não é um Cliente Jurídico!";
        }
    return null;
    }   
}
