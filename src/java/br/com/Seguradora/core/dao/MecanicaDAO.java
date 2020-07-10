
package br.com.Seguradora.core.dao;

import br.com.Seguradora.core.negocio.DadosObrigatoriosClienteTerceiro;
import br.com.Seguradora.core.negocio.DadosObrigatoriosCorretor;
import br.com.Seguradora.core.util.Conexao;
import br.com.Seguradora.dominio.Cliente;
import br.com.Seguradora.dominio.ClienteJuridico;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Mecanica;
import br.com.Seguradora.dominio.Pessoa;
import br.com.Seguradora.dominio.Sinistro;
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

public class MecanicaDAO implements IDAO{
    
    PreparedStatement pst;
    Connection conexao;
    Mecanica mecanica;
    Veiculo veiculo;
    Sinistro sinistro;
    Cliente cliente;
    Pessoa pessoa;

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        Sinistro s = (Sinistro) entidade;   
        s.setStatus(1);
                
        try {
             // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO INFO_SINISTRO(sinistro_id)");
            sql.append("VALUES(?)");
                
            pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
                
            pst.setInt(1, s.getId());   
            pst.execute();
            
                        
            ResultSet rs = pst.getGeneratedKeys();
            //int id = 0;
            //if(rs.next()){
            //    id = rs.getInt(1);
            //    s.setId(id);
            //}
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
        Mecanica mecanica = (Mecanica) entidade;
        
        mecanica.setStatus(1);
        
        try {
            conexao = Conexao.getConnection();            
            StringBuilder sql = new StringBuilder();
            
            if (mecanica.getOperacaoDAO().equals("ENTRADA")){
                sql.append("UPDATE INFO_SINISTRO SET dataEntrada=?, status=? WHERE sinistro_id=?");
                
                pst = conexao.prepareStatement(sql.toString());
                pst.setString(1, mecanica.getDataEntrada());               
                pst.setInt(2, mecanica.getStatus());
                pst.setInt(3, mecanica.getSinistro().getId());
                
                pst.execute();
                
            }else if (mecanica.getOperacaoDAO().equals("SAIDA")){
                sql.append("UPDATE INFO_SINISTRO SET dataSaida=?, status=? WHERE sinistro_id=?");
                
                pst = conexao.prepareStatement(sql.toString());
                pst.setString(1, mecanica.getDataSaida());               
                pst.setInt(2, 0);
                pst.setInt(3, mecanica.getSinistro().getId());
                
                pst.execute();
            }
                        
            
            
            
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
        List<EntidadeDominio> mecanicas = null;
        Mecanica mecanica = (Mecanica) entidade;
        cliente = new Cliente();    
        sinistro = new Sinistro();
        veiculo = new Veiculo();
        try {

            // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM MECANICA WHERE id=?");
            
            pst = conexao.prepareStatement(sql.toString());
            pst.setInt(1, mecanica.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                mecanica.setId(rs.getInt("id"));
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
         
        //veiculo.setCliente(cliente);
        mecanicas = new ArrayList<>();
        mecanicas.add(mecanica);
        return mecanicas;
    }

    @Override
    public int salvarId(EntidadeDominio entidade) throws SQLException {
        Sinistro s = (Sinistro) entidade;
        try {
            // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();

            StringBuilder sql = new StringBuilder();
            
                sql.append("INSERT INTO MECANICA(nome, telefone, documento, sinistro_id)");
                sql.append(" VALUES(?, ?, ?, ?)");
                pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

                pst.setString(1, s.getMecanica().getPessoa().getNome());
                pst.setString(2, s.getMecanica().getPessoa().getTelefoneComercial());
                pst.setString(3, s.getMecanica().getPessoa().getDocumento());   
                pst.setInt(4, s.getId());
                pst.execute();
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (null != generatedKeys && generatedKeys.next()) {
                s.getMecanica().setId(generatedKeys.getInt(1));
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
        return s.getMecanica().getId();

    }

    /**
     *
     * @param entidade
     * @return
     * @throws SQLException
     */
    @Override
    public List<EntidadeDominio> filtrar(EntidadeDominio entidade) throws SQLException {
        PreparedStatement pst = null;
        Mecanica mecanica = (Mecanica)entidade;
        List<EntidadeDominio> mecanicas = null;
        String sql = null;
        
        if (mecanica.getPessoa().getDocumento()!= null && !"".equals(mecanica.getPessoa().getDocumento())){
            sql = "SELECT * FROM VEICULO v " +
                  "JOIN SINISTRO s ON s.veiculo_id=v.id " +
                  "JOIN MECANICA m ON s.id=m.sinistro_id " +
                  "JOIN CLIENTE c ON s.cliente_id=c.id " +
                  "JOIN INFO_SINISTRO i ON i.sinistro_id=s.id " +
                  "WHERE c.documento='"+mecanica.getPessoa().getDocumento()+"'";
        }
        
        try {
            conexao = Conexao.getConnection();
            pst = conexao.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            mecanicas = new ArrayList<>();
            while(rs.next()){
                Mecanica m = new Mecanica();
                pessoa = new Pessoa();                
                veiculo = new Veiculo();
                cliente = new Cliente();
                sinistro = new Sinistro();
                veiculo.setId(rs.getInt(1));
                veiculo.setMarca(rs.getString(2));
                veiculo.setModelo(rs.getString(3));
                veiculo.setPlaca(rs.getString(4));
                veiculo.setChassi(rs.getString(5));
                veiculo.setAnoFabricacao(rs.getString(6));
                veiculo.setAnoModelo(rs.getString(7));
                veiculo.setNumeroFrota(rs.getString(8));
                veiculo.setStatus(rs.getInt(9)); 
                sinistro.setId(rs.getInt(11));
                sinistro.setTipo((rs.getString(12)));
                sinistro.setDescricao((rs.getString(17)));
                pessoa.setId(rs.getInt(35));
                pessoa.setNome(rs.getString(36));
                pessoa.setTelefoneCelular(rs.getString(43));
                m.setDataEntrada(rs.getString(50));
                m.setDataSaida(rs.getString(51));
                m.setVeiculo(veiculo);
                m.setSinistro(sinistro);
                m.setPessoa(pessoa);
                mecanicas.add(m);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mecanicas;
    }

    @Override
    public List<ClienteJuridico> consultarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadeDominio> continuar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static boolean statusMecanica (int id){
        
        try {                     
            Connection conexao = Conexao.getConnection();
            String instrucaoSQL = "SELECT * FROM INFO_SINISTRO WHERE status=1 and sinistro_id="+id;
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
