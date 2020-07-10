package br.com.Seguradora.core.dao;

import br.com.Seguradora.core.negocio.DadosObrigatoriosLogin;
import br.com.Seguradora.core.util.Conexao;
import br.com.Seguradora.dominio.ClienteJuridico;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viniciusamorim
 */
public class LoginDAO implements IDAO{
    
    PreparedStatement pst;
    Connection conexao;

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        Login l = (Login) entidade;   
        l.setStatus(1);
                
        try {
             // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO LOGIN(email, senha, confirmarSenha)");
            sql.append("VALUES(?, ?, ?)");
                
            pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
                       
            pst.setString(1, l.getLogin());
            pst.setString(2, l.getSenha());
            pst.setString(3, l.getConfirmarSenha());
            pst.execute();
            
                        
            ResultSet rs = pst.getGeneratedKeys();
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
                l.setId(id);
            }
          // Fecha a conexao.
            conexao.close();
           
            
        } catch (ClassNotFoundException erro) {
            erro.printStackTrace();
            //throw new ExcecaoAcessoDados("Houve um problema de configuração");
        } catch (SQLException erro) {
            erro.printStackTrace();
            //throw new ExcecaoAcessoDados("Houve um problema de conectividade");
        } finally {
            try {
                pst.close();
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void alterar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int salvarId(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadeDominio> filtrar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClienteJuridico> consultarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadeDominio> continuar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
