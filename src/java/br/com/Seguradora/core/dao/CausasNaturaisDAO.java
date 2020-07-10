/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.core.dao;

import br.com.Seguradora.core.negocio.DadosObrigatoriosClienteTerceiro;
import br.com.Seguradora.core.negocio.DadosObrigatoriosCorretor;
import br.com.Seguradora.core.util.Conexao;
import br.com.Seguradora.dominio.Apolice;
import br.com.Seguradora.dominio.CausasNaturais;
import br.com.Seguradora.dominio.Cliente;
import br.com.Seguradora.dominio.ClienteJuridico;
import br.com.Seguradora.dominio.Endereco;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Mecanica;
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

/**
 *
 * @author viniciusamorim
 */
public class CausasNaturaisDAO implements IDAO{

    PreparedStatement pst;
    Connection conexao;
    Veiculo veiculo;
    Cliente cliente;
    ClienteDAO clienteDAO;
    Apolice apolice;
    Sinistro sinistro;
    Mecanica mecanica;
    Endereco endereco;
    
    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        CausasNaturais cn = (CausasNaturais) entidade;   
        cn.setStatus(1);
                
        try {
             // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO CAUSAS_NATURAIS(dataAtualizacao, descricao, cliente_id, veiculo_id, sinistro_id)");
            sql.append("VALUES(?, ?, ?, ?, ?)");
                
            pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            
            pst.setTimestamp(1, new Timestamp(System.currentTimeMillis()));  
            pst.setString(2, cn.getDescricao());
            pst.setInt(3, cn.getCliente().getId());
            pst.setInt(4, cn.getVeiculo().getId());
            pst.setInt(5, cn.getSinistro().getId());
            pst.execute();
            
                        
            ResultSet rs = pst.getGeneratedKeys();
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
                cn.setId(id);
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
                sql.append("UPDATE CAUSAS_NATURAIS SET status=? WHERE sinistro_id=?");
                
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
        CausasNaturais causasNaturais = (CausasNaturais)entidade;
        List<EntidadeDominio> listaCausasNaturais = null;
                
        String sql = null;
        
        if (causasNaturais.getVeiculo().getPlaca()!= null && !"".equals(causasNaturais.getVeiculo().getPlaca())){
            sql = "SELECT * FROM CAUSAS_NATURAIS f " +
                  "JOIN CLIENTE c ON c.id=f.cliente_id " +
                  "JOIN VEICULO v ON v.id=f.veiculo_id " +
                  "JOIN SINISTRO s ON s.id=f.sinistro_id " +
                  "JOIN MECANICA m ON m.id=s.mecanica_id " +
                  "JOIN ENDERECO e ON m.id=e.mecanica_id WHERE v.placa='"+causasNaturais.getVeiculo().getPlaca()+"' AND s.status=1";
        }
        
        else if (causasNaturais.getCliente().getDocumento()!= null && !"".equals(causasNaturais.getCliente().getDocumento())){
            sql = "SELECT * FROM CAUSAS_NATURAIS f " +
                  "JOIN CLIENTE c ON c.id=f.cliente_id " +
                  "JOIN VEICULO v ON v.id=f.veiculo_id " +
                  "JOIN SINISTRO s ON s.id=f.sinistro_id " +
                  "JOIN MECANICA m ON m.id=s.mecanica_id " + 
                  "JOIN ENDERECO e ON m.id=e.mecanica_id WHERE c.documento='"+causasNaturais.getCliente().getDocumento()+"' AND s.status=1";
        }
        
        try {
            conexao = Conexao.getConnection();
            pst = conexao.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            listaCausasNaturais = new ArrayList<>();
            while(rs.next()){
                CausasNaturais cn = new CausasNaturais();
                cliente = new Cliente();
                veiculo = new Veiculo();
                sinistro = new Sinistro();
                mecanica = new Mecanica();
                endereco = new Endereco();
                cn.setId(rs.getInt(1));
                cn.setAtualizacao(rs.getString(2));
                cn.setDescricao(rs.getString(3));
                cliente.setId(rs.getInt(8));
                veiculo.setId(rs.getInt(22));
                sinistro.setId(rs.getInt(32));
                mecanica.setId(51);
                mecanica.getPessoa().setNome(rs.getString(52));
                mecanica.getPessoa().setTelefoneComercial(rs.getString(53));
                endereco.setId(54);
                cn.setMecanica(mecanica);
                cn.setCliente(cliente);
                cn.setVeiculo(veiculo);
                cn.setSinistro(sinistro);
                listaCausasNaturais.add(cn);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaCausasNaturais;
    }

    @Override
    public List<ClienteJuridico> consultarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadeDominio> continuar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void salvarPrimeiraAtualizacao(EntidadeDominio entidade) throws SQLException {
        Sinistro s = (Sinistro) entidade;
        s.setStatus(1);
                
        try {
             // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO CAUSAS_NATURAIS(dataAtualizacao, descricao, cliente_id, veiculo_id, sinistro_id)");
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
    
    public static boolean statusSinistro (int id){
        
        try {                     
            Connection conexao = Conexao.getConnection();
            String instrucaoSQL = "SELECT * FROM CAUSAS_NATURAIS at " +
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
    
}
