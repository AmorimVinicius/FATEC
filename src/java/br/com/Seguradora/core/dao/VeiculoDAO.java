package br.com.Seguradora.core.dao;

import br.com.Seguradora.core.negocio.DadosObrigatoriosVeiculo;
import br.com.Seguradora.core.util.Conexao;
import br.com.Seguradora.dominio.Cliente;
import br.com.Seguradora.dominio.ClienteJuridico;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VeiculoDAO implements IDAO{
    
    PreparedStatement pst;
    Connection conexao;
    Veiculo veiculo;
    Cliente cliente;
    ClienteDAO clienteDAO;

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        
        veiculo = new Veiculo();
        Veiculo v = (Veiculo) entidade;        
        
        try {
            clienteDAO = new ClienteDAO();
            int idCliente = clienteDAO.insereVeiculo(v.getCliente().getDocumento());
             // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO VEICULO(marca, modelo, placa, chassi, anoFabricacao, anoModelo, numeroFrota, status, cliente_id)");
            sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
                
            pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            pst.setString(1, v.getMarca());
            pst.setString(2, v.getModelo());
            pst.setString(3, v.getPlaca());
            pst.setString(4, v.getChassi());
            pst.setString(5, v.getAnoFabricacao());
            pst.setString(6, v.getAnoModelo());
            pst.setString(7, v.getNumeroFrota()); 
            pst.setInt(8, 1);
            pst.setInt(9, idCliente); 
            pst.execute();
            
                        
            ResultSet rs = pst.getGeneratedKeys();
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
                v.setId(id);
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
        PreparedStatement pst = null;
        Veiculo veiculo = (Veiculo) entidade;
        
        veiculo.setStatus(1);
        
        try {
            conexao = Conexao.getConnection();
            conexao.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE VEICULO SET marca=?, modelo=?, placa=?, chassi=?, anoFabricacao=?, anoModelo=?,numeroFrota=?, status=? ");
            sql.append("WHERE id=?");
                
            pst = conexao.prepareStatement(sql.toString());
            pst.setString(1, veiculo.getMarca());
            pst.setString(2, veiculo.getModelo());
            pst.setString(3, veiculo.getPlaca());
            pst.setString(4, veiculo.getChassi());
            pst.setString(5, veiculo.getAnoFabricacao());
            pst.setString(6, veiculo.getAnoModelo());
            pst.setString(7, veiculo.getNumeroFrota());
            pst.setInt(8, veiculo.getStatus());
            pst.setInt(9, veiculo.getId());
            
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

    @Override
    public void excluir(EntidadeDominio entidade) throws SQLException {
        PreparedStatement pst = null;
        Veiculo veiculo = (Veiculo) entidade;
        
        veiculo.setStatus(0);
        
        try {
            conexao = Conexao.getConnection();
            conexao.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE VEICULO SET status=? ");
            sql.append("WHERE id=?");
                
            pst = conexao.prepareStatement(sql.toString());
            pst.setInt(1, veiculo.getStatus());
            pst.setInt(2, veiculo.getId());
            
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

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
        List<EntidadeDominio> veiculos = null;
        Veiculo veiculo = (Veiculo) entidade;
        cliente = new Cliente();        
        try {

            // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM VEICULO WHERE id=?");
            
            pst = conexao.prepareStatement(sql.toString());
            pst.setInt(1, veiculo.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setChassi(rs.getString("chassi"));
                veiculo.setAnoFabricacao(rs.getString("anoFabricacao"));
                veiculo.setAnoModelo(rs.getString("anoModelo"));
                veiculo.setNumeroFrota(rs.getString("numeroFrota"));
                //veiculo.setStatus(rs.getInt(1));
                //veiculo.setCliente(cliente);
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
         
        veiculo.setCliente(cliente);
        veiculos = new ArrayList<>();
        veiculos.add(veiculo);
        return veiculos;
    }
    
    @Override
    public int salvarId(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadeDominio> filtrar(EntidadeDominio entidade) throws SQLException {
        PreparedStatement pst = null;
        Veiculo veiculo = (Veiculo)entidade;
        List<EntidadeDominio> veiculos = null;
        String sql = null;
        
        if (veiculo.getPlaca()!= null && !"".equals(veiculo.getPlaca())){
            sql = "SELECT * FROM VEICULO WHERE placa='"+veiculo.getPlaca()+"' AND status=1";
        }
        
        try {
            conexao = Conexao.getConnection();
            pst = conexao.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            veiculos = new ArrayList<>();
            while(rs.next()){
                Veiculo v = new Veiculo();
                v.setId(rs.getInt(1));
                v.setMarca(rs.getString(2));
                v.setModelo(rs.getString(3));
                v.setPlaca(rs.getString(4));
                v.setChassi(rs.getString(5));
                v.setAnoFabricacao(rs.getString(6));
                v.setAnoModelo(rs.getString(7));
                v.setNumeroFrota(rs.getString(8));
                v.setStatus(rs.getInt(9)); 
                veiculos.add(v);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return veiculos;
    }

    @Override
    public List<ClienteJuridico> consultarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static boolean isExistePlaca (String placa){
        // VERIFICAR SE PLACA JA EXISTE ESTA CADASTRADO
        try {                     
            Connection conexao = Conexao.getConnection();
            String instrucaoSQL = "SELECT placa FROM VEICULO WHERE placa='"+placa+"'";
            PreparedStatement declaracao = conexao.prepareStatement(instrucaoSQL);
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
                    Logger.getLogger(DadosObrigatoriosVeiculo.class.getName()).log(Level.SEVERE, null, ex);
                }
                }catch(SQLException erro){
                    erro.printStackTrace();
                    try {
                        throw new SQLException("Erro bd");
                    } catch (SQLException ex) {
                        Logger.getLogger(DadosObrigatoriosVeiculo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  
                }
        return false;
    }
    
    
    public static boolean isExisteChassi (String chassi){
        // VERIFICAR SE PLACA JA EXISTE ESTA CADASTRADO
        try {                     
            Connection conexao = Conexao.getConnection();
            String instrucaoSQL = "SELECT chassi FROM VEICULO WHERE placa='"+chassi+"'";
            PreparedStatement declaracao = conexao.prepareStatement(instrucaoSQL);
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
                    Logger.getLogger(DadosObrigatoriosVeiculo.class.getName()).log(Level.SEVERE, null, ex);
                }
                }catch(SQLException erro){
                    erro.printStackTrace();
                    try {
                        throw new SQLException("Erro bd");
                    } catch (SQLException ex) {
                        Logger.getLogger(DadosObrigatoriosVeiculo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  
                }
        return false;
    }

    @Override
    public List<EntidadeDominio> continuar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
