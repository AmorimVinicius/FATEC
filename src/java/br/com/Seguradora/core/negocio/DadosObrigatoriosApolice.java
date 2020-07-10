package br.com.Seguradora.core.negocio;

import br.com.Seguradora.core.dao.ApoliceDAO;
import br.com.Seguradora.core.dao.SinistroDAO;
import br.com.Seguradora.dominio.Apolice;
import br.com.Seguradora.dominio.EntidadeDominio;

public class DadosObrigatoriosApolice implements IStrategy{

    @Override
    public String processar(EntidadeDominio entidade) {
       
        if(entidade instanceof Apolice){
            Apolice a = (Apolice)entidade;
            ApoliceDAO apoliceDAO = new ApoliceDAO();
            
            // NAO PERMITIR ENCERRAR APOLICE ENQUANTO SINISTRO ESTIVER ABERTO
            if (a.getOperacao().equals("EXCLUIR")){
                boolean sinistroAtivo = SinistroDAO.isSinistroAtivo(a.getVeiculo().getId());
                if(sinistroAtivo == true){
                    return "Não é possível encerrar uma apólice, enquanto houver sinistro em aberto";
                }
            }
            
            // VERIFICAR SE JA EXISTE APOLICE ATIVA
            if (a.getOperacao().equals("SALVAR")){
                boolean apolice = apoliceDAO.isExisteApolice(a.getVeiculo().getId());
                if (apolice == true){
                    return "Já existe uma apólice ativa para esse veículo!";
                }
            }
            
            // VERIFICAR SE CLIENTE EXISTE
            if (a.getOperacao().equals("ALTERAR")){
                boolean documento = apoliceDAO.verificarSeClienteExiste(a.getCliente().getDocumento());
                if (documento == false){
                    return "O cliente informado não existe em nossa bases de dados!\n"
                            + "É necessário primeiramente realizar o cadastro";
                }
            }
            /*
            // VALIDAR DATA VALIDA
            ValidarDataNascimento dataInicio = new ValidarDataNascimento();
            boolean dataInicioValida = dataInicio.dataValida(a.getDataInicio());
            if (dataInicioValida == false){
                return "A data de início inserida é inválida. Por favor verifique!";
            }
            
            // VALIDAR DATA VALIDA
            ValidarDataNascimento dataFim = new ValidarDataNascimento();
            boolean dataFimValida = dataFim.dataValida(a.getDataInicio());
            if (dataFimValida == false){
                return "A data de fim inserida é inválida. Por favor verifique!";
            }
            */
            // VALIDAR SE JÁ EXISTE UMA APOLICE ATIVA PARA O CLIENTE
            
            
        }else{
            return "Dado não pode ser validado, pois entidade não é um Cliente Jurídico!";
        }
    return null;
    }   
}
