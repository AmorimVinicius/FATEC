package br.com.Seguradora.core.negocio;

import br.com.Seguradora.core.dao.ClienteTerceiroDAO;
import br.com.Seguradora.core.dao.SinistroDAO;
import br.com.Seguradora.dominio.ClienteTerceiro;
import br.com.Seguradora.dominio.EntidadeDominio;

/**
 *
 * @author viniciusamorim
 */
public class DadosObrigatoriosClienteTerceiro implements IStrategy{

    @Override
    public String processar(EntidadeDominio entidade) {
        if(entidade instanceof ClienteTerceiro){
            ClienteTerceiro ct = (ClienteTerceiro)entidade;
                
                // VERIFICAR STATUS SINISTRO
                if (ct.getOperacao().equals("SALVAR")){
                    boolean statusSinistro = ClienteTerceiroDAO.statusSinistro(ct.getSinistro().getId());
                    if(statusSinistro == true){
                        return "O sinistro ainda está para aprovação! Entre em contato com a seguradora para maiores informações!";
                    }
                }
                
                // VERIFICAR STATUS SINISTRO
                if (ct.getOperacao().equals("LISTARFILTRO")){
                    boolean existeSinistro = SinistroDAO.existeSinistro(ct.getVeiculo().getPlaca());
                    if(existeSinistro == false){
                        return "A placa informada não existe ou não temos sinistros abertos para a mesma";
                    }
                }
                
        }else{
            return "Dado não pode ser validado, pois entidade não é um Cliente Jurídico!";
        }
        return null;
    }
}
