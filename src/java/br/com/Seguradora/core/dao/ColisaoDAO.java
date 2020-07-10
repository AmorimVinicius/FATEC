package br.com.Seguradora.core.dao;

import br.com.Seguradora.core.negocio.DadosObrigatoriosClienteTerceiro;
import br.com.Seguradora.core.negocio.DadosObrigatoriosCorretor;
import br.com.Seguradora.core.util.Conexao;
import br.com.Seguradora.dominio.Apolice;
import br.com.Seguradora.dominio.Cliente;
import br.com.Seguradora.dominio.ClienteJuridico;
import br.com.Seguradora.dominio.Colisao;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Sinistro;
import br.com.Seguradora.dominio.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ColisaoDAO implements IDAO{
    
    PreparedStatement pst;
    Connection conexao;
    Veiculo veiculo;
    Cliente cliente;
    ClienteDAO clienteDAO;
    Apolice apolice;
    Sinistro sinistro;

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        Colisao c = (Colisao) entidade;   
        c.setStatus(1);
                
        try {
             // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO COLISAO(dataAtualizacao, descricao, cliente_id, veiculo_id, sinistro_id)");
            sql.append("VALUES(?, ?, ?, ?, ?)");
                
            pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            
            pst.setTimestamp(1, new Timestamp(System.currentTimeMillis()));  
            pst.setString(2, c.getDescricao());
            pst.setInt(3, c.getCliente().getId());
            pst.setInt(4, c.getVeiculo().getId());
            pst.setInt(5, c.getSinistro().getId());
            pst.execute();
            
                        
            ResultSet rs = pst.getGeneratedKeys();
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
                c.setId(id);
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
        Sinistro sinistro = (Sinistro) entidade;
        sinistro.setStatus(0);
        if (sinistro.getId() != 0) {
            try {
                // Abre uma conexao com o banco.
                conexao = Conexao.getConnection();
                
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE COLISAO SET status=? WHERE sinistro_id=?");
                
                pst = conexao.prepareStatement(sql.toString());
                pst.setInt(1, sinistro.getStatus());
                pst.setInt(2, sinistro.getId());
                pst.execute();
                
            } catch (ClassNotFoundException erro) {
                erro.printStackTrace();
           
            } catch (SQLException erro) {
                erro.printStackTrace();
          
            } finally {
                try {
                    pst.close();
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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
        PreparedStatement pst = null;
        Colisao colisao = (Colisao)entidade;
        List<EntidadeDominio> colisoes = null;
                
        String sql = null;
        
        if (colisao.getVeiculo().getPlaca()!= null && !"".equals(colisao.getVeiculo().getPlaca())){
            sql = "SELECT * FROM COLISAO f " +
                  "JOIN CLIENTE c ON c.id=f.cliente_id " +
                  "JOIN VEICULO v ON v.id=f.veiculo_id " +
                  "JOIN SINISTRO s ON s.id=f.sinistro_id WHERE v.placa='"+colisao.getVeiculo().getPlaca()+"' AND s.status=1";
        }
        
        else if (colisao.getCliente().getDocumento()!= null && !"".equals(colisao.getCliente().getDocumento())){
            sql = "SELECT * FROM COLISAO f " +
                  "JOIN CLIENTE c ON c.id=f.cliente_id " +
                  "JOIN VEICULO v ON v.id=f.veiculo_id " +
                  "JOIN SINISTRO s ON s.id=f.sinistro_id WHERE c.documento='"+colisao.getCliente().getDocumento()+"' AND s.status=1";
        }
        
        try {
            conexao = Conexao.getConnection();
            pst = conexao.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            colisoes = new ArrayList<>();
            while(rs.next()){
                Colisao c = new Colisao();
                cliente = new Cliente();
                veiculo = new Veiculo();
                sinistro = new Sinistro();
                c.setId(rs.getInt(1));
                c.setAtualizacao(rs.getString(2));
                c.setDescricao(rs.getString(3));
                cliente.setId(rs.getInt(8));
                veiculo.setId(rs.getInt(22));
                sinistro.setId(rs.getInt(32));
                c.setCliente(cliente);
                c.setVeiculo(veiculo);
                c.setSinistro(sinistro);
                colisoes.add(c);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return colisoes;
    }

    @Override
    public List<ClienteJuridico> consultarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadeDominio> continuar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static boolean statusSinistro (int id){
        
        try {                     
            Connection conexao = Conexao.getConnection();
            String instrucaoSQL = "SELECT * FROM COLISAO at " +
                  "JOIN CLIENTE c ON c.id=at.cliente_id " +
                  "JOIN VEICULO v ON v.id=at.veiculo_id " +
                  "JOIN SINISTRO s ON s.id=at.sinistro_id WHERE s.id='"+id+"' AND s.status=1 AND s.aceite='Aguardando'";
            PreparedStatement declaracao = conexao.prepareStatement(instrucaoSQL);
            //clientesJuridicos = new ArrayList<>();
            ResultSet resultado = declaracao.executeQuery();
            if(resultado.next()){    
                return true; 
            }
                conexao.close();
        }
            catch (ClassNotFoundException erro){
                erro.printStackTrace();
                try {
                    throw new SQLException("Houve erro com o banco");
                } catch (SQLException ex) {
                    Logger.getLogger(DadosObrigatoriosClienteTerceiro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }catch(SQLException erro){
                erro.printStackTrace();
                try {
                    throw new SQLException("Erro bd");
                } catch (SQLException ex) {
                    Logger.getLogger(DadosObrigatoriosCorretor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        return false;    
    }
    
    public void salvarPrimeiraAtualizacao(EntidadeDominio entidade) throws SQLException {
        Sinistro s = (Sinistro) entidade;
        s.setStatus(1);
                
        try {
             // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO COLISAO(dataAtualizacao, descricao, cliente_id, veiculo_id, sinistro_id)");
            sql.append("VALUES(?, ?, ?, ?, ?)");
                
            pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            
            pst.setTimestamp(1, new Timestamp(System.currentTimeMillis()));  
            pst.setString(2, s.getDescricao());
            pst.setInt(3, s.getCliente().getId());
            pst.setInt(4, s.getVeiculo().getId());
            pst.setInt(5, s.getId());
            pst.execute();
            
                        
            ResultSet rs = pst.getGeneratedKeys();
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
                s.setId(id);
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
    
}
