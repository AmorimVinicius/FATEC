package br.com.Seguradora.core.dao;

import br.com.Seguradora.core.util.Conexao;
import br.com.Seguradora.dominio.ClienteJuridico;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ProdutoDAO implements IDAO{
    
    PreparedStatement pst;
    Connection conexao;
    Produto produto;
    
    @Override
    public void salvar(EntidadeDominio entidade){
        
        produto = new Produto();
        Produto produto = (Produto) entidade;
        
        try {
             // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
                StringBuilder sql = new StringBuilder();
                sql.append("INSERT INTO produto(produto, quantidade)");
		sql.append("VALUES(?, ?)");
                //PreparedStatement pst = conexao.prepareStatement(sql.toString());
                pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            
            pst.setString(1, produto.getDescricao());
            pst.setInt(2, produto.getQuantidade());
            
            pst.execute();
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (null != generatedKeys && generatedKeys.next()) {
                produto.setId(generatedKeys.getInt(1));
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
        produto = new Produto();
        produto = (Produto) entidade;
        
        try {
             // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE produto SET quantidade=90000 WHERE id=?");
			
                //sql.append("VALUES(?, ?)");
                //PreparedStatement pst = conexao.prepareStatement(sql.toString());
                pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            
                pst.setInt(1, produto.getId());
            
                pst.execute();
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (null != generatedKeys && generatedKeys.next()) {
                produto.setId(generatedKeys.getInt(1));
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
