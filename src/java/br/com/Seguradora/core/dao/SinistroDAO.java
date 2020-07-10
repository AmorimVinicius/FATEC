
package br.com.Seguradora.core.dao;

import br.com.Seguradora.core.negocio.DadosObrigatoriosVeiculo;
import br.com.Seguradora.core.util.Conexao;
import br.com.Seguradora.core.util.ConverteDate;
import br.com.Seguradora.dominio.Apolice;
import br.com.Seguradora.dominio.CausasNaturais;
import br.com.Seguradora.dominio.Cidade;
import br.com.Seguradora.dominio.Cliente;
import br.com.Seguradora.dominio.ClienteJuridico;
import br.com.Seguradora.dominio.ClienteTerceiro;
import br.com.Seguradora.dominio.Endereco;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Estado;
import br.com.Seguradora.dominio.FurtoRoubo;
import br.com.Seguradora.dominio.Mecanica;
import br.com.Seguradora.dominio.Sinistro;
import br.com.Seguradora.dominio.Veiculo;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
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
public class SinistroDAO implements IDAO{
    
    PreparedStatement pst;
    Connection conexao;
    Veiculo veiculo;
    Cliente cliente;
    ClienteDAO clienteDAO;
    Apolice apolice;
    Sinistro sinistro;
    FurtoRoubo furtoRoubo;
    FurtoRouboDAO furtoRouboDAO;
    IncendioDAO incendioDAO;
    CausasNaturaisDAO causasNaturaisDAO;
    ClienteTerceiroDAO clienteTerceiroDAO;
    ClienteTerceiro clienteTerceiro;
    ColisaoDAO colisaoDAO;
    MecanicaDAO mecanicaDAO;
    Mecanica mecanica;
    Endereco endereco;
    EnderecoDAO enderecoDAO;

    /**
     *
     * @param entidade
     * @throws SQLException
     */
    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        sinistro = new Sinistro();        
        Sinistro s = (Sinistro) entidade;   
        s.setStatus(1);        
        s.setAceite("Aguardando");      
                      
        try {
             // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO SINISTRO(tipo, dataInsercao, cliente_id, veiculo_id, status, breveDescricao, apolice_id, ");
            sql.append("img_documento, img_endereco, img_crvl, img_habilitacao, img_boletimOcorrencia, aceite)");
            sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                
            pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            
            Timestamp dataAgora = new Timestamp(System.currentTimeMillis());
            ConverteDate converte = new ConverteDate();
            String data = converte.converteData(dataAgora);
            
            pst.setString(1, s.getTipo());
            //pst.setDate(2, new java.sql.Date(System.currentTimeMillis()));  
            pst.setString(2, data);  
            //Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
            pst.setInt(3, s.getCliente().getId());
            pst.setInt(4, s.getVeiculo().getId());
            pst.setInt(5, s.getStatus());
            pst.setString(6, s.getDescricao());
            pst.setInt(7, s.getApolice().getId());
            pst.setString(8, s.getComprovanteDocumento());
            pst.setString(9, s.getComprovanteEndereco());
            pst.setString(10, s.getComprovanteCRVL());
            pst.setString(11, s.getComprovanteCNH());
            pst.setString(12, s.getComprovanteBO());
            pst.setString(13, s.getAceite());
            pst.execute();
            
                        
            ResultSet rs = pst.getGeneratedKeys();
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
                s.setId(id);
            }
          // Fecha a conexao.
            conexao.close();     
            
            // SALVANDO CLIENTE TERCEIRO
            if (s.getClienteTerceiro().getNome() == null || s.getClienteTerceiro().getNome().equals("")){                
            }else {
                int clienteTerceiroId;
                clienteTerceiroDAO = new ClienteTerceiroDAO();
                clienteTerceiroId = clienteTerceiroDAO.salvarId(s);  
            }              

            // atualizar primeira informação no sinistro
            atualizarTipoSinistro(s);     
           
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
        Sinistro sinistro = (Sinistro) entidade;
        sinistro.setStatus(0);
        if (sinistro.getId() != 0) {

            
            if (!sinistro.getOperacaoDAO().equals("CADASTRARMECANICA")){
                
            }else{
                // DADOS MECANICA
                mecanica = sinistro.getMecanica();
                int mecanicaId;
                mecanicaDAO = new MecanicaDAO();
                mecanicaId = mecanicaDAO.salvarId(sinistro);
                sinistro.getMecanica().setId(mecanicaId);
                
                mecanicaDAO = new MecanicaDAO();
                mecanicaDAO.salvar(sinistro);

                // DADOS ENDERECO
                endereco = mecanica.getEndereco();
                enderecoDAO = new EnderecoDAO();
                int enderecoId = 0;
                String classe = "MECANICA";
                enderecoDAO.salvarEndereco(endereco, mecanica.getId(), classe);
            }
            
            
            
            try {

                // Abre uma conexao com o banco.
                conexao = Conexao.getConnection();
                
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE SINISTRO SET aceite=?, observacao=?, dataAceiteRecusa=? WHERE id=?");
                
                pst = conexao.prepareStatement(sql.toString());
                pst.setString(1, sinistro.getAceite());
                pst.setString(2, sinistro.getDescricao());
                pst.setTimestamp(3, new Timestamp(System.currentTimeMillis())); 
              //  pst.setInt(4, sinistro.getMecanica().getId());
                pst.setInt(4, sinistro.getId());
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
    public void excluir(EntidadeDominio entidade) throws SQLException {
        Sinistro sinistro = (Sinistro) entidade;
        sinistro.setStatus(0);
        if (sinistro.getId() != 0) {
            try {
                // Abre uma conexao com o banco.
                conexao = Conexao.getConnection();
                
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE SINISTRO SET status=?, dataFim=? WHERE id=?");
                
                pst = conexao.prepareStatement(sql.toString());
                pst.setInt(1, sinistro.getStatus());
                pst.setTimestamp(2, new Timestamp(System.currentTimeMillis()));  
                pst.setInt(3, sinistro.getId());
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
            
            // encerrar tipo de sinistro
            encerrarSinistro(sinistro);
            
        }
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
        List<EntidadeDominio> sinistros = null;
        Sinistro sinistro = (Sinistro) entidade;
        cliente = new Cliente(); 
        veiculo = new Veiculo();
        try {

            // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM SINISTRO WHERE id=?");
            
            pst = conexao.prepareStatement(sql.toString());
            pst.setInt(1, sinistro.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                sinistro.setTipo(rs.getString("tipo"));
                /*apolice.setDataFim(rs.getString("dataFim"));
                apolice.setPremio(rs.getString("premio"));
                apolice.setValorApolice(rs.getString("valorApolice"));
                apolice.setTipoApolice(rs.getString("tipoApolice"));*/
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
         
        //apolice.setVeiculo(veiculo);
        sinistros = new ArrayList<>();
        sinistros.add(sinistro);
        return sinistros;
    }

    @Override
    public int salvarId(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadeDominio> filtrar(EntidadeDominio entidade) throws SQLException {
        PreparedStatement pst = null;
        Sinistro sinistro = (Sinistro)entidade;
        List<EntidadeDominio> sinistros = null;
        String sql = null;
        
        if (sinistro.getVeiculo().getPlaca()!= null && !"".equals(sinistro.getVeiculo().getPlaca())){
            sql = "SELECT * FROM CLIENTE c " +
                  "JOIN VEICULO v ON c.id=v.cliente_id " +
                  "JOIN SINISTRO s ON c.id=s.cliente_id WHERE v.placa='"+sinistro.getVeiculo().getPlaca()+"' AND s.status=1 AND s.aceite='Aguardando'";
        }
        
        else if (sinistro.getCliente().getDocumento()!= null && !"".equals(sinistro.getCliente().getDocumento())){
            sql = "SELECT * FROM CLIENTE c " +
                  "JOIN VEICULO v ON c.id=v.cliente_id " +
                  "JOIN SINISTRO s ON c.id=s.cliente_id WHERE c.documento='"+sinistro.getCliente().getDocumento()+"' AND s.status=1 AND s.aceite='Aguardando'";
        }
        
        sql = "SELECT * FROM CLIENTE c " +
              "JOIN VEICULO v ON c.id=v.cliente_id " +
              "JOIN SINISTRO s ON c.id=s.cliente_id WHERE s.status=1";
        
        
        try {
            conexao = Conexao.getConnection();
            pst = conexao.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            sinistros = new ArrayList<>();
            while(rs.next()){
                Sinistro s = new Sinistro();
                cliente = new Cliente();
                veiculo = new Veiculo();
                cliente.setId(rs.getInt(1));
                cliente.setNome(rs.getString(2));
                cliente.setDocumento(rs.getString(3));
                cliente.setEmail(rs.getString(4));      
                cliente.setTelefoneCelular(rs.getString(9));          
                veiculo.setId(rs.getInt(15));
                veiculo.setModelo(rs.getString(17));
                veiculo.setPlaca(rs.getString(18));
                s.setId(rs.getInt(25));
                s.setTipo(rs.getString(26));
                s.setComprovanteDocumento(rs.getString(34));
                s.setComprovanteEndereco(rs.getString(35));
                s.setComprovanteCRVL(rs.getString(36));
                s.setComprovanteCNH(rs.getString(37));
                s.setComprovanteBO(rs.getString(38));
                s.setAceite(rs.getString(39));
                s.setDescricao(rs.getString(40));
                s.setDataAceiteRecusa(rs.getString(41));
                s.setCliente(cliente);
                s.setVeiculo(veiculo);
                sinistros.add(s);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sinistros;
    }

    @Override
    public List<ClienteJuridico> consultarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadeDominio> continuar(EntidadeDominio entidade) throws SQLException {
        PreparedStatement pst = null;
        Sinistro sinistro = (Sinistro)entidade;
        List<EntidadeDominio> sinistros = null;
        String sql = null;
        
            sql = "SELECT * FROM CLIENTE c "
            + "JOIN VEICULO v ON c.id=v.cliente_id "
            + "JOIN APOLICE a ON c.id=a.cliente_id "
            + "WHERE c.documento='"+sinistro.getCliente().getDocumento()+"'";                       
               
        try {
            conexao = Conexao.getConnection();
            pst = conexao.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            sinistros = new ArrayList<>();
            while(rs.next()){
                Sinistro s = new Sinistro();
                veiculo = new Veiculo();
                cliente = new Cliente();
                apolice = new Apolice();
                              
                cliente.setId(rs.getInt(1));       
                cliente.setNome(rs.getString(2));                
                veiculo.setId(rs.getInt(15));
                veiculo.setModelo(rs.getString(17));
                veiculo.setPlaca(rs.getString(18));  
                apolice.setId(rs.getInt(25));
                s.setApolice(apolice);
                s.setVeiculo(veiculo);
                s.setCliente(cliente);
                
                sinistros.add(s);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sinistros;
    }
    
    public static boolean isSinistroAtivo (Integer id){
        // VERIFICAR SE PLACA JA EXISTE ESTA CADASTRADO
        try {                     
            Connection conexao = Conexao.getConnection();
            String instrucaoSQL = "SELECT status FROM SINISTRO WHERE veiculo_id='"+id+"' AND status=1";
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
    
    public static boolean verificarTipoApolice (String tipo, Integer id){
         
        try {                     
            try (Connection conexao = Conexao.getConnection()) {
                
                String instrucaoSQL = "SELECT * FROM APOLICE WHERE tipoApolice='"+tipo+"' AND veiculo_id='"+id+"'AND status=1";
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
    
    
   
    
    public static boolean verificarSinistroEncerrado (Integer id){      
        try {                     
            try (Connection conexao = Conexao.getConnection()) {
                
                String instrucaoSQL = "SELECT * FROM SINISTRO WHERE veiculo_id='"+id+"' AND status=0";
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
    
    public void atualizarTipoSinistro(EntidadeDominio entidade) throws SQLException {
        
        Sinistro s = (Sinistro) entidade;
        
        switch (s.getTipo()) {
            case "FurtoRoubo":
                //Salvando FurtoRoubo
                furtoRouboDAO = new FurtoRouboDAO();
                furtoRouboDAO.salvarPrimeiraAtualizacao(s);
                break;
            case "Incendio":
                //Salvando Incendio
                incendioDAO = new IncendioDAO();
                incendioDAO.salvarPrimeiraAtualizacao(s);
                break;
            case "CausasNaturais":
                //Salvando CausasNaturais
                causasNaturaisDAO = new CausasNaturaisDAO();
                causasNaturaisDAO.salvarPrimeiraAtualizacao(s);
                break;
            case "Terceiros":
                //Salvando Terceiros
                clienteTerceiroDAO = new ClienteTerceiroDAO();
                clienteTerceiroDAO.salvarPrimeiraAtualizacao(s);
                break;
            case "Colisao":
                //Salvando Terceiros
                colisaoDAO = new ColisaoDAO();
                colisaoDAO.salvarPrimeiraAtualizacao(s);
                break;    
            
            default:
                break;
        }
        
    }
    
    
    public void encerrarSinistro(EntidadeDominio entidade) throws SQLException {
        
        Sinistro s = (Sinistro) entidade;
        
        switch (s.getTipo()) {
            case "FurtoRoubo":
                //Salvando FurtoRoubo
                furtoRouboDAO = new FurtoRouboDAO();
                furtoRouboDAO.excluir(s);
                break;
            case "Incendio":
                //Salvando Incendio
                incendioDAO = new IncendioDAO();
                incendioDAO.excluir(s);
                break;
            case "CausasNaturais":
                //Salvando CausasNaturais
                causasNaturaisDAO = new CausasNaturaisDAO();
                causasNaturaisDAO.excluir(s);
                break;
            case "Terceiros":
                //Salvando Terceiros
                clienteTerceiroDAO = new ClienteTerceiroDAO();
                clienteTerceiroDAO.excluir(s);
                break;
            case "Colisao":
                //Salvando Terceiros
                colisaoDAO = new ColisaoDAO();
                colisaoDAO.excluir(s);
                break;    
            
            default:
                break;
        }
        
    }
    
    public static boolean existeSinistro (String placa){
        // VERIFICAR SE PLACA JA EXISTE ESTA CADASTRADO
        try {                     
            Connection conexao = Conexao.getConnection();
            String instrucaoSQL = "SELECT * FROM SINISTRO s " +
                                  "JOIN VEICULO v ON v.id=s.veiculo_id " +
                                  "WHERE v.placa='"+placa+"' AND s.status=1";
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
    
    
    public static boolean verificarSinistroAberto (Integer id){
         
        try {                     
            try (Connection conexao = Conexao.getConnection()) {
                
                String instrucaoSQL = "SELECT * FROM SINISTRO WHERE veiculo_id='"+id+"'AND status=1";
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
    
    
}
