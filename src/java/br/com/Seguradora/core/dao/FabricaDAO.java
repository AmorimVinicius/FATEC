package br.com.Seguradora.core.dao;

import br.com.Seguradora.core.util.BancoDadosPostgres;
import br.com.Seguradora.core.util.Conexao;

public class FabricaDAO {
    
    public static IDAO getIDAO(){
        try {
            BancoDadosPostgres.getConexao().close();
            return new ClienteJuridicoDAO();
        } catch (Exception e) {
            return null;
        }
    }
    
    public static IDAO getConexaoSQL(){
        try {
            Conexao.getConnection().close();
            return new ClienteJuridicoDAO();
        } catch (Exception e) {
            return null;
        }
    }
    
}
