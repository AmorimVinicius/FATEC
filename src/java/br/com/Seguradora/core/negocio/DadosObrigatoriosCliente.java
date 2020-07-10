package br.com.Seguradora.core.negocio;

import br.com.Seguradora.core.dao.ClienteDAO;
import br.com.Seguradora.dominio.Cliente;
import br.com.Seguradora.dominio.ClienteJuridico;
import br.com.Seguradora.dominio.Endereco;
import br.com.Seguradora.dominio.EntidadeDominio;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viniciusamorim
 */
public class DadosObrigatoriosCliente implements IStrategy{

    @Override
    public String processar(EntidadeDominio entidade) {
        
            if(entidade instanceof Cliente){
                Cliente c = (Cliente)entidade;
                
                // VALIDAR CPF
                boolean cpf = ValidarCPF.iscpf(c.getDocumento());
                if (cpf == false){
                    return "O CPF inserido é inválido. Por favor verifique!";
                }
                
                // VERIFICAR EXISTENCIA DE CPF
                if(c.getOperacao().equals("SALVAR")){
                    boolean cpfExiste = ClienteDAO.isExisteCPF(c.getDocumento());
                    if (cpfExiste == true){
                        return "O CPF já existe em nossa base de dados!";
                    }
                }
                                
                // VALIDAR DATA VALIDA
                ValidarDataNascimento vdn = new ValidarDataNascimento();
                boolean dataValida = vdn.dataValida(c.getDataNascimento());
                if (dataValida == false){
                    return "A data inserida é inválida. Por favor verifique!";
                }
                
                // VALIDAR IDADE
                ValidarIdadeCliente vic = new ValidarIdadeCliente();
                try {
                    boolean idadeCliente = vic.validarIdade(c.getDataNascimento());
                    if (idadeCliente == false)
                        return "O cliente deve ter idade igual ou superior a 18 anos!";
                } catch (ParseException ex) {
                    Logger.getLogger(DadosObrigatoriosCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                // VALIDAR QUANTIDADE DE CARACTERES CEP
                String cep = c.getEndereco().getCep();
                if (cep.length()<8){
                    return "O CEP inserido é inválido. Verifique a quantidade de caracteres!";
                }       
                        
            }else{
                return "Dado não pode ser validado, pois entidade não é um Cliente Jurídico!";
            }
    return null;
	}   
}