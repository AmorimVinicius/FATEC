package br.com.Seguradora.core.dao;

import br.com.Seguradora.core.negocio.DadosObrigatoriosApolice;
import br.com.Seguradora.core.negocio.DadosObrigatoriosVeiculo;
import br.com.Seguradora.core.util.Conexao;
import br.com.Seguradora.dominio.Apolice;
import br.com.Seguradora.dominio.Cidade;
import br.com.Seguradora.dominio.Cliente;
import br.com.Seguradora.dominio.ClienteJuridico;
import br.com.Seguradora.dominio.Endereco;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Estado;
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

public class ApoliceDAO implements IDAO{

    PreparedStatement pst;
    Connection conexao;
    Veiculo veiculo;
    Cliente cliente;
    ClienteDAO clienteDAO;
    Endereco endereco;
    EnderecoDAO endDAO;
    Cidade cidade;
    Estado estado;
        
    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        Apolice apolice = (Apolice) entidade;
        apolice.setStatus(1);
        
        //Salvando endereco principal
        /*
        if (apolice.getStatusEnderecoPrincipal().equals("ATIVO")){
            endereco = apolice.getEndereco();
            endDAO = new EnderecoDAO();
            int idEnd;
            idEnd = endDAO.salvarId(endereco);
            apolice.getEndereco().setId(idEnd);
            endDAO.atualizarEndereco(idEnd, apolice.getCliente().getId());
        }
        //Salvando endereco pernoite
        if (apolice.getStatusEnderecoSecundario().equals("ATIVO")){
            endereco = apolice.getEndereco();
            endDAO = new EnderecoDAO();
            int idEndPernoite;
            idEndPernoite = endDAO.salvarIdSec(endereco);
            apolice.getEndereco().setIdPernoite(idEndPernoite);
            endDAO.atualizarEndereco(idEndPernoite, apolice.getCliente().getId());
        }*/
        
        try {
             // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO APOLICE(dataInicio, dataFim, premio, valorApolice, tipoApolice, cliente_id, veiculo_id, endereco_principal_id, endereco_pernoite_id, status, habilitados, dataCadastro, valorVeiculo)");
            sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                
            //PreparedStatement pst = conexao.prepareStatement(sql.toString());
            pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            
            pst.setString(1, apolice.getDataInicio());
            pst.setString(2, apolice.getDataFim());
            pst.setString(3, apolice.getPremio());
            pst.setString(4, apolice.getValorApolice());
            pst.setString(5, apolice.getTipoApolice());
            pst.setInt(6, apolice.getCliente().getId());
            pst.setInt(7, apolice.getVeiculo().getId());
            pst.setInt(8, apolice.getEndereco().getId());
            pst.setInt(9, apolice.getEndereco().getIdPernoite());        
            pst.setInt(10, apolice.getStatus());
            pst.setString(11, apolice.getHabilitados());
            pst.setTimestamp(12, new Timestamp(System.currentTimeMillis()));
            pst.setString(13, apolice.getVeiculo().getValorVeiculo());            
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
                apolice.setId(id);
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
        Apolice apolice = (Apolice) entidade;
        
        //Alterando endereco
        //endereco = cliente.getEndereco();
        //endDAO = new EnderecoDAO();
        //endDAO.alterar(endereco);
        
        apolice.setStatus(0);
        
        try {
            conexao = Conexao.getConnection();
            //conexao.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE a ");
            sql.append("SET a.dataInicio=?, a.dataFim=?, a.premio=?, a.valorApolice=?, a.tipoApolice=? ");            
            sql.append("FROM APOLICE a WHERE a.id=? ");
            
            pst = conexao.prepareStatement(sql.toString());
            pst.setString(1, apolice.getDataInicio());
            pst.setString(2, apolice.getDataFim());
            pst.setString(3, apolice.getPremio());
            pst.setString(4, apolice.getValorApolice());
            pst.setString(5, apolice.getTipoApolice());
            pst.setInt(6, apolice.getId());
            
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
        Apolice apolice = (Apolice) entidade;
        apolice.setStatus(0);
        if (apolice.getId() != 0) {
            try {
                // Abre uma conexao com o banco.
                conexao = Conexao.getConnection();
                
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE APOLICE SET status=? WHERE id=?");
                
                pst = conexao.prepareStatement(sql.toString());
                pst.setInt(1, apolice.getStatus());
                pst.setInt(2, apolice.getId());
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
        List<EntidadeDominio> apolices = null;
        Apolice apolice = (Apolice) entidade;
        cliente = new Cliente(); 
        veiculo = new Veiculo();
        endereco = new Endereco();
        Cidade cidade = new Cidade();
        Estado estado = new Estado();
        try {

            // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
            StringBuilder sql = new StringBuilder();
           /* sql.append("SELECT * FROM APOLICE a ");
            sql.append("JOIN VEICULO v ON a.veiculo_id=v.id WHERE a.id=?");*/
            
            sql.append("SELECT * FROM APOLICE a ");
            sql.append("JOIN VEICULO v ON a.veiculo_id=v.id ");
            sql.append("JOIN CLIENTE c ON a.cliente_id=c.id ");
            sql.append("JOIN ENDERECO ep ON a.endereco_principal_id=ep.id ");
            sql.append("JOIN ENDERECO epp ON a.endereco_pernoite_id=epp.id ");
            sql.append("WHERE a.id=?");
            
            
            pst = conexao.prepareStatement(sql.toString());
            pst.setInt(1, apolice.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                apolice.setDataInicio(rs.getString("dataInicio"));
                apolice.setDataFim(rs.getString("dataFim"));
                apolice.setPremio(rs.getString("premio"));
                apolice.setValorApolice(rs.getString("valorApolice"));
                apolice.setTipoApolice(rs.getString("tipoApolice"));
                veiculo.setId(rs.getInt("id"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setPlaca(rs.getString("placa"));
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setDocumento(rs.getString("documento"));
                endereco.setId(rs.getInt("id"));
                endereco.setCep(rs.getString("cep"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setBairro(rs.getString("bairro"));
                //cidade.setCidade(rs.getString("cidade"));
                //estado.setEstado(rs.getString("estado"));
                endereco.setIdPernoite(rs.getInt("id"));
                endereco.setCepSec(rs.getString("cep"));
                endereco.setLogradouroSec(rs.getString("logradouro"));
                endereco.setNumeroSec(rs.getString("numero"));
                endereco.setComplementoSec(rs.getString("complemento"));
                endereco.setBairroSec(rs.getString("bairro"));
                cidade.setCidadeSec(rs.getString("cidade"));
                estado.setEstadoSec(rs.getString("estado"));
                apolice.setCidade(cidade);
                apolice.setEstado(estado);
                apolice.setVeiculo(veiculo);
                apolice.setCliente(cliente);
                apolice.setEndereco(endereco);
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
         
        apolice.setVeiculo(veiculo);
        apolices = new ArrayList<>();
        apolices.add(apolice);
        return apolices;
    }

    @Override
    public int salvarId(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadeDominio> filtrar(EntidadeDominio entidade) throws SQLException {
        PreparedStatement pst = null;
        Apolice apolice = (Apolice)entidade;
        List<EntidadeDominio> apolices = null;
        String sql = null;
        
        if (apolice.getCliente().getDocumento()!= null && !"".equals(apolice.getCliente().getDocumento())){ 
            sql = "SELECT * FROM APOLICE a " +
                  "JOIN VEICULO v ON a.veiculo_id=v.id " +
                  "JOIN CLIENTE c ON a.cliente_id=c.id " +
                  "JOIN ENDERECO ep ON a.endereco_principal_id=ep.id " +
                  "JOIN ENDERECO epp ON a.endereco_pernoite_id=epp.id " + 
                  "WHERE c.documento='"+apolice.getCliente().getDocumento()+"'";
            
        }else if (apolice.getVeiculo().getPlaca()!= null && !"".equals(apolice.getVeiculo().getPlaca())){ 
            sql = "SELECT * FROM APOLICE a " +
                  "JOIN VEICULO v ON a.veiculo_id=v.id " +
                  "JOIN CLIENTE c ON a.cliente_id=c.id " +
                  "JOIN ENDERECO ep ON a.endereco_principal_id=ep.id " +
                  "JOIN ENDERECO epp ON a.endereco_pernoite_id=epp.id " + 
                  "WHERE v.placa='"+apolice.getVeiculo().getPlaca()+"'";
        }
       
        
        try {
            conexao = Conexao.getConnection();
            pst = conexao.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            apolices = new ArrayList<>();
            while(rs.next()){
                Apolice a = new Apolice();
                cliente = new Cliente();
                veiculo = new Veiculo();
                endereco = new Endereco();
                cidade = new Cidade();
                estado = new Estado();
                a.setId(rs.getInt(1));
                a.setDataInicio(rs.getString(2));
                a.setDataFim(rs.getString(3));
                a.setPremio(rs.getString(4));
                a.setValorApolice(rs.getString(5));
                a.setTipoApolice(rs.getString(6));
                a.setHabilitados(rs.getString(12));
                veiculo.setId(rs.getInt(16));
                veiculo.setMarca(rs.getString(17));
                veiculo.setModelo(rs.getString(18));
                veiculo.setPlaca(rs.getString(19));
                cliente.setId(rs.getInt(26));
                cliente.setNome(rs.getString(27));
                cliente.setDocumento(rs.getString(28));
                endereco.setId(rs.getInt(40));
                endereco.setCep(rs.getString(41));
                endereco.setLogradouro(rs.getString(42));
                endereco.setComplemento(rs.getString(43));
                endereco.setNumero(rs.getString(44));
                endereco.setBairro(rs.getString(45));
                cidade.setCidade(rs.getString(46));
                estado.setEstado(rs.getString(47));
                endereco.setIdPernoite(rs.getInt(52));
                endereco.setCepSec(rs.getString(53));
                endereco.setLogradouroSec(rs.getString(54));
                endereco.setComplementoSec(rs.getString(55));
                endereco.setNumeroSec(rs.getString(56));
                endereco.setBairroSec(rs.getString(57));
                cidade.setCidadeSec(rs.getString(58));
                estado.setEstadoSec(rs.getString(59));
                a.setVeiculo(veiculo);
                a.setCidade(cidade);
                a.setCliente(cliente);
                a.setEstado(estado);
                a.setEndereco(endereco);
                apolices.add(a);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apolices;
    }

    @Override
    public List<ClienteJuridico> consultarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadeDominio> continuar(EntidadeDominio entidade) throws SQLException {
        PreparedStatement pst = null;
        Apolice apolice = (Apolice)entidade;
        List<EntidadeDominio> apolices = null;
        String sql = null;
        
        //if (apolice.getCliente().getDocumento()!= null && !"".equals(apolice.getCliente().getDocumento())){ 
            //sql = "SELECT * FROM ENDERECO e JOIN CLIENTE c ON v.cliente_id=c.id WHERE c.documento='"+apolice.getCliente().getDocumento()+"'";
        /*
            SELECT * FROM ENDERECO e
JOIN CLIENTE c ON e.cliente_id=c.id
JOIN VEICULO v ON v.cliente_id=c.id WHERE v.placa='AAA-3333';
          */  
            sql = "SELECT * FROM ENDERECO e "
            + "JOIN CLIENTE c ON e.cliente_id=c.id "
            + "JOIN VEICULO v ON v.cliente_id=c.id "
            + "WHERE v.placa='"+apolice.getVeiculo().getPlaca()+"'";
            
            
        
        
        try {
            conexao = Conexao.getConnection();
            pst = conexao.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            apolices = new ArrayList<>();
            while(rs.next()){
                Apolice a = new Apolice();
                veiculo = new Veiculo();
                cliente = new Cliente();
                endereco = new Endereco();
                cidade = new Cidade();
                estado = new Estado();
                
                endereco.setId(rs.getInt(1));
                endereco.setCep(rs.getString(2));
                endereco.setLogradouro(rs.getString(3));
                endereco.setNumero(rs.getString(4));
                endereco.setBairro(rs.getString(5));
                endereco.setComplemento(rs.getString(6));
                cidade.setCidade(rs.getString(7));
                estado.setEstado(rs.getString(8));
                cliente.setId(rs.getInt(13));                
                veiculo.setId(rs.getInt(27));
                a.setEndereco(endereco);
                a.getEndereco().setCidade(cidade);
                a.getEndereco().setEstado(estado);
                a.setVeiculo(veiculo);
                a.setCliente(cliente);
                /*a.setId(rs.getInt(1));
                a.setDataInicio(rs.getString(2));
                a.setDataFim(rs.getString(3));
                a.setPremio(rs.getString(4));
                a.setValorApolice(rs.getString(5));
                a.setTipoApolice(rs.getString(6));  */
                
                apolices.add(a);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apolices;
    }
    
    public static boolean isExisteApolice (Integer id){
        // VERIFICAR SE CNPJ ESTA CADASTRADO
        
        try {                     
            try (Connection conexao = Conexao.getConnection()) {
                
                String instrucaoSQL = "SELECT * FROM APOLICE WHERE veiculo_id='"+id+"' AND status=1";
                PreparedStatement declaracao = conexao.prepareStatement(instrucaoSQL);
                //clientesJuridicos = new ArrayList<>();
                ResultSet resultado = declaracao.executeQuery();
                if(resultado.next()){
                    return true; 
                }
            }
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
  
    public String compararData(EntidadeDominio entidade, int id) throws SQLException {
        Apolice apolice = (Apolice)entidade;
         try {                     
            try (Connection conexao = Conexao.getConnection()) {
                
                String instrucaoSQL = "SELECT dataInicio FROM APOLICE WHERE id='"+id+"' AND status=1";
                PreparedStatement declaracao = conexao.prepareStatement(instrucaoSQL);
                //clientesJuridicos = new ArrayList<>();
                ResultSet resultado = declaracao.executeQuery();
                if(resultado.next()){
                    return apolice.getDataInicio(); 
                }
            }
        }
            catch (ClassNotFoundException erro){
                erro.printStackTrace();
                try {
                    throw new SQLException("Houve erro com o banco");
                } catch (SQLException ex) {
                    Logger.getLogger(DadosObrigatoriosApolice.class.getName()).log(Level.SEVERE, null, ex);
                }
            }catch(SQLException erro){
                erro.printStackTrace();
                try {
                    throw new SQLException("Erro bd");
                } catch (SQLException ex) {
                    Logger.getLogger(DadosObrigatoriosApolice.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        return apolice.getDataInicio();
    }
    
    public boolean verificarSeClienteExiste(String documento){
         try {                     
            try (Connection conexao = Conexao.getConnection()) {
                
                String instrucaoSQL = "SELECT documento FROM CLIENTE WHERE documento='"+documento+"' AND status=1";
                PreparedStatement declaracao = conexao.prepareStatement(instrucaoSQL);
                //clientesJuridicos = new ArrayList<>();
                ResultSet resultado = declaracao.executeQuery();
                if(resultado.next()){
                    return true; 
                }
            }
        }
            catch (ClassNotFoundException erro){
                erro.printStackTrace();
                try {
                    throw new SQLException("Houve erro com o banco");
                } catch (SQLException ex) {
                    Logger.getLogger(DadosObrigatoriosApolice.class.getName()).log(Level.SEVERE, null, ex);
                }
            }catch(SQLException erro){
                erro.printStackTrace();
                try {
                    throw new SQLException("Erro bd");
                } catch (SQLException ex) {
                    Logger.getLogger(DadosObrigatoriosApolice.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        return false;
    }
    
}
