/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.core.dao;

import br.com.Seguradora.core.util.Conexao;
import br.com.Seguradora.dominio.Cidade;
import br.com.Seguradora.dominio.ClienteJuridico;
import br.com.Seguradora.dominio.Endereco;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author viniciusamorim
 */
public class EnderecoDAO implements IDAO{

    PreparedStatement pst;
    Connection conexao;
    Endereco endereco;
    Cidade cidade;
    Estado estado;
    
    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        endereco = new Endereco();
        cidade = new Cidade();
        estado = new Estado();
        Endereco end = (Endereco) entidade;
        int status = 1;
        try {
             // Abre uma conexao com o banco.
            
            conexao = Conexao.getConnection();
            
                StringBuilder sql = new StringBuilder();
                
                sql.append("INSERT INTO ENDERECO(cep, logradouro, numero, complemento, bairro, cidade, estado)");
		sql.append("VALUES(?, ?, ?, ?, ?, ?, ?)");
                
                PreparedStatement pst = conexao.prepareStatement(sql.toString());
                //pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            
            
            pst.setString(1, end.getCep());
            pst.setString(2, end.getLogradouro());
            pst.setString(3, end.getNumero());
            pst.setString(4, end.getComplemento());
            pst.setString(5, end.getNumero());
            pst.setString(6, end.getBairro());
            pst.setString(7, end.getCidade().getCidade());            
            pst.setString(8, end.getEstado().getEstado());            
            pst.executeUpdate();
            
            ResultSet rs = pst.getGeneratedKeys();
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
                end.setId(id);
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
       Endereco endereco = (Endereco) entidade;
                
        try {
            conexao = Conexao.getConnection();
            //conexao.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            
            sql.append("UPDATE ENDERECO SET cep=?, logradouro=?, complemento=?, numero=?, ");
            sql.append("bairro=?, cidade=?, estado=? WHERE id=?");
            
            /*sql.append("UPDATE e ");
            sql.append("SET e.cep=?, e.logradouro=?, e.complemento=? ");
            sql.append("e.bairro=?, e.cidade=?, e.estado=? ");
            sql.append("FROM ENDERECO e ");
            sql.append("WHERE e.id=?");*/
            //INNER JOIN ENDERECO e ON c.endereco_id=e.id 
            
            pst = conexao.prepareStatement(sql.toString());
            pst.setString(1, endereco.getCep());
            pst.setString(2, endereco.getLogradouro());
            pst.setString(3, endereco.getComplemento());
            pst.setString(4, endereco.getNumero());
            pst.setString(5, endereco.getBairro());
            pst.setString(6, endereco.getCidade().getCidade());
            pst.setString(7, endereco.getEstado().getEstado());
            pst.setInt(8, endereco.getId());
            
            pst.execute();
            //conexao.commit();
            
            
        } catch (Exception e) {
            try {
                conexao.rollback();
            } catch (Exception el) {
                el.printStackTrace();
            }
            e.printStackTrace();
        }finally{
            try {
                pst.close();
                conexao.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
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
    public List<EntidadeDominio> filtrar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ClienteJuridico> consultarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
    @Override
    public int salvarId(EntidadeDominio entidade) throws SQLException {
        Endereco endereco = (Endereco) entidade;
        try {
            // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();

            StringBuilder sql = new StringBuilder();
            
                sql.append("INSERT INTO ENDERECO(cep, logradouro, numero, complemento, bairro, cidade, estado)");
                sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
                pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

                pst.setString(1, endereco.getCep());
                pst.setString(2, endereco.getLogradouro());
                pst.setString(3, endereco.getNumero());
                pst.setString(4, endereco.getComplemento());
                pst.setString(5, endereco.getBairro());
                pst.setString(6, endereco.getCidade().getCidade());
                pst.setString(7, endereco.getEstado().getEstado()) ;            
             
                pst.execute();
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (null != generatedKeys && generatedKeys.next()) {
                endereco.setId(generatedKeys.getInt(1));
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
        return endereco.getId();
    }
    
    
    public int salvarIdSec(EntidadeDominio entidade) throws SQLException {
        Endereco endereco = (Endereco) entidade;
        try {
            // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();

            StringBuilder sql = new StringBuilder();
            
                sql.append("INSERT INTO ENDERECO(cep, logradouro, numero, complemento, bairro, cidade, estado)");
                sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?)");
                pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

                pst.setString(1, endereco.getCepSec());
                pst.setString(2, endereco.getLogradouroSec());
                pst.setString(3, endereco.getNumeroSec());
                pst.setString(4, endereco.getComplementoSec());
                pst.setString(5, endereco.getBairroSec());
                pst.setString(6, endereco.getCidadeSec().getCidade());
                pst.setString(7, endereco.getEstadoSec().getEstado()) ;            
             
                pst.execute();
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (null != generatedKeys && generatedKeys.next()) {
                endereco.setIdPernoite(generatedKeys.getInt(1));
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
        return endereco.getIdPernoite();
    }

    @Override
    public List<EntidadeDominio> continuar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void salvarEndereco(EntidadeDominio entidade, int id, String classe) throws SQLException {
        Endereco endereco = (Endereco) entidade;
        try {
            // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
            StringBuilder sql = new StringBuilder();
            if (classe.equals("CLIENTE")){
                sql.append("INSERT INTO ENDERECO(cep, logradouro, numero, complemento, bairro, cidade, estado, cliente_id)");
            }else if(classe.equals("CORRETOR")){
                sql.append("INSERT INTO ENDERECO(cep, logradouro, numero, complemento, bairro, cidade, estado, corretor_id)");
            }else if(classe.equals("MECANICA")){
                sql.append("INSERT INTO ENDERECO(cep, logradouro, numero, complemento, bairro, cidade, estado, mecanica_id)");
            }
            sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            
            pst.setString(1, endereco.getCep());
            pst.setString(2, endereco.getLogradouro());
            pst.setString(3, endereco.getNumero());
            pst.setString(4, endereco.getComplemento());
            pst.setString(5, endereco.getBairro());
            pst.setString(6, endereco.getCidade().getCidade());
            pst.setString(7, endereco.getEstado().getEstado()) ; 
            pst.setInt(8, id);
            pst.execute();
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (null != generatedKeys && generatedKeys.next()) {
                endereco.setId(generatedKeys.getInt(1));
            }
            // Fecha a conexao.
            conexao.close();
            
            // SEGUNDO ENDERECO
            if (endereco.getCepSec() != null && !endereco.getCepSec().trim().equals("")){
                // Abre uma conexao com o banco.
                conexao = Conexao.getConnection();

                StringBuilder sql2 = new StringBuilder();
                if (classe.equals("CLIENTE")){
                    sql.append("INSERT INTO ENDERECO(cep, logradouro, numero, complemento, bairro, cidade, estado, cliente_id)");
                }else if(classe.equals("CORRETOR")){
                    sql.append("INSERT INTO ENDERECO(cep, logradouro, numero, complemento, bairro, cidade, estado, corretor_id)");
                }
                pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

                pst.setString(1, endereco.getCepSec());
                pst.setString(2, endereco.getLogradouroSec());
                pst.setString(3, endereco.getNumeroSec());
                pst.setString(4, endereco.getComplementoSec());
                pst.setString(5, endereco.getBairroSec());
                pst.setString(6, endereco.getCidadeSec().getCidade());
                pst.setString(7, endereco.getEstadoSec().getEstado()) ; 
                pst.setInt(8, id);
                pst.execute();
                ResultSet generatedKeys2 = pst.getGeneratedKeys();
                if (null != generatedKeys2 && generatedKeys2.next()) {
                    endereco.setId(generatedKeys2.getInt(1));
                }
                // Fecha a conexao.
                conexao.close();
            }
                        
            
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
    
    public void atualizarEndereco(Integer idEndereco, Integer idCliente){
        PreparedStatement pst = null;
        //Endereco endereco = (Endereco) entidade;
        
        //endereco.setStatus(1);
        
        try {
            conexao = Conexao.getConnection();
            conexao.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE ENDERECO SET cliente_id=? ");
            sql.append("WHERE id=?");
                
            pst = conexao.prepareStatement(sql.toString());
            pst.setInt(1, idCliente);
            pst.setInt(2, idEndereco);
            
            pst.executeUpdate();
            conexao.commit();
            
            
        } catch (Exception e) {
            try {
                conexao.rollback();
            } catch (Exception el) {
                el.printStackTrace();
            }
            e.printStackTrace();
        }finally{
            try {
                pst.close();
                conexao.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
}
