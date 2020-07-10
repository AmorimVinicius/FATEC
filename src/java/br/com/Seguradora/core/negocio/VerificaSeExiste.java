package br.com.Seguradora.core.negocio;

import br.com.Seguradora.core.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author viniciusamorim
 */
public class VerificaSeExiste {
    
    public String verificaCNPJ(int cnpj) throws ClassNotFoundException, SQLException{
        
        Connection conexao = Conexao.getConnection();
        //Statement stm = conexao.createStatemente();
        String instrucaoSQL = "SELECT * FROM CLIENTE_JURIDICO WHERE cnpj="+cnpj;
                        
        PreparedStatement declaracao = conexao.prepareStatement(instrucaoSQL);
        //clientesJuridicos = new ArrayList<>();
            ResultSet resultado = declaracao.executeQuery();
            if(resultado.next()){                              
                return "Encontrou!";
                
            }else{
                return "Em branco!";
            }

    }
    
}
