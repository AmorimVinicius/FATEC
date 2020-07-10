package br.com.Seguradora.core.negocio;

import br.com.Seguradora.core.dao.ClienteJuridicoDAO;
import br.com.Seguradora.core.dao.VeiculoDAO;
import br.com.Seguradora.core.util.Conexao;
import br.com.Seguradora.dominio.ClienteJuridico;
import br.com.Seguradora.dominio.Endereco;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Veiculo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class DadosObrigatoriosVeiculo implements IStrategy{

    @Override
	public String processar(EntidadeDominio entidade) {
		
            if(entidade instanceof Veiculo){
                
                Veiculo veiculo = (Veiculo)entidade;
                                
                int anoAtual = 0; int anoSeguro = 0;
                GregorianCalendar calendar = new GregorianCalendar();
                anoAtual = calendar.get(calendar.YEAR);
                anoSeguro = anoAtual - 20;
                
         	
                // VALIDAR PLACA
		if(!veiculo.getPlaca().matches("[A-Z]{3}-[0-9]{4}")){
                    return "A placa informada está fora do padrão.";
                }
                // VERIFICAR SE PLACA JA EXISTE
                if (veiculo.getOperacao().equals("SALVAR")){
                    boolean placaExiste = VeiculoDAO.isExistePlaca(veiculo.getPlaca());
                    if(placaExiste == true){
                        return "A placa informada já está cadastrada em nossa base de dados!";
                    }
                }
                
                // VERIFICAR SE CHASSI JA EXISTE
                if (veiculo.getOperacao().equals("SALVAR")){
                    boolean chassiExiste = VeiculoDAO.isExisteChassi(veiculo.getChassi());
                    if(chassiExiste == true){
                        return "O chassi informado já está cadastrada em nossa base de dados!";
                    }
                }
                
                // VALIDAR ANO DE FABRICACAO
		if(Integer.parseInt(veiculo.getAnoFabricacao())<(anoSeguro)){
                    return "O ano de fabricação do veículo deve ser no máximo de até 20 anos";
                }
                
                // VALIDAR ANO DO MODELO
                if(Integer.parseInt(veiculo.getAnoModelo())<(anoSeguro+1)){
                    return "O ano de modelo do veículo deve ser no máximo de até 20 anos";
                }
                
                if(Integer.parseInt(veiculo.getAnoFabricacao())>(anoAtual)){
                    return "O ano de fabricação do veículo não deve ser maior que o ano atual";
                }
                if(Integer.parseInt(veiculo.getAnoModelo())>(anoAtual+1)){
                    return "O ano de fabricação do veículo não deve ser maior que o ano de "+(anoAtual+1);
                }
                
                
                
               
                // VERIFICAR SE CHASSI JA EXISTE ESTA CADASTRADO
                
            }else{
                return "Dado não pode ser validado, pois entidade não é um Veículo!";
            }
    return null;
	}   
}
