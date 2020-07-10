package br.com.Seguradora.core.dao;


import br.com.Seguradora.core.dao.EnderecoDAO;
import br.com.Seguradora.core.dao.IDAO;
import br.com.Seguradora.core.negocio.DadosObrigatoriosLogin;
import br.com.Seguradora.core.negocio.DadosObrigatoriosVeiculo;
import br.com.Seguradora.core.util.Conexao;
import br.com.Seguradora.dominio.Cliente;
import br.com.Seguradora.dominio.ClienteJuridico;
import br.com.Seguradora.dominio.Endereco;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Veiculo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO implements IDAO{
    
    Endereco endereco;
    EnderecoDAO endDAO;
    PreparedStatement pst;
    Connection conexao;
    Cliente cli;
    Veiculo veiculo;

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        Cliente cliente = (Cliente) entidade;
     
        try {
             // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
                StringBuilder sql = new StringBuilder();                
                sql.append("INSERT INTO CLIENTE(nome, documento, email, sexo, estadoCivil, dataNascimento, telefoneComercial, telefoneCelular, infoAdicional, status)");
                sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                
                //PreparedStatement pst = conexao.prepareStatement(sql.toString());
                pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            
            
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getDocumento());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getSexo());
            pst.setString(5, cliente.getEstadoCivil());
            pst.setString(6, cliente.getDataNascimento());
            pst.setString(7, cliente.getTelefoneComercial());
            pst.setString(8, cliente.getTelefoneCelular());
            pst.setString(9, cliente.getInfoAdicional());
            pst.setInt(10, 1);
                        
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
                cliente.setId(id);
            }
          // Fecha a conexao.
            conexao.close();
            
            //Salvando endereco
            endereco = cliente.getEndereco();
            endDAO = new EnderecoDAO();
            int idEnd = 0;
            String classe = "CLIENTE";
            endDAO.salvarEndereco(endereco, cliente.getId(), classe);
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
        Cliente cliente = (Cliente) entidade;
        
        //Alterando endereco
        endereco = cliente.getEndereco();
        endDAO = new EnderecoDAO();
        endDAO.alterar(endereco);
        
        cliente.setStatus(0);
        
        try {
            conexao = Conexao.getConnection();
            //conexao.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE c ");
            sql.append("SET c.nome=?, c.documento=?, c.email=?, c.estadoCivil=?, c.dataNascimento=?, ");
            sql.append("c.telefoneComercial=?, c.telefoneCelular=?, c.infoAdicional=?, sexo=? ");
            sql.append("FROM CLIENTE c ");
            sql.append("INNER JOIN ENDERECO e ON c.endereco_id=e.id WHERE c.id=?");
            
            pst = conexao.prepareStatement(sql.toString());
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getDocumento());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getEstadoCivil());
            pst.setString(5, cliente.getDataNascimento());
            pst.setString(6, cliente.getTelefoneComercial());
            pst.setString(7, cliente.getTelefoneCelular());
            pst.setString(8, cliente.getInfoAdicional());
            pst.setString(9, cliente.getSexo());
            pst.setInt(10, cliente.getId());
            
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
        Cliente cliente = (Cliente) entidade;
        cliente.setStatus(0);
        if (cliente.getId() != 0) {
            try {
                // Abre uma conexao com o banco.
                conexao = Conexao.getConnection();
                
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE CLIENTE SET status=? WHERE id=?");
                
                pst = conexao.prepareStatement(sql.toString());
                pst.setInt(1, cliente.getStatus());
                pst.setInt(2, cliente.getId());
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
        List<EntidadeDominio> clientes = null;
        Cliente cliente = (Cliente) entidade;
        endereco = new Endereco();
        System.out.println("cliente dao" + cliente.getId());
        
        try {

            // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM CLIENTE WHERE id=?");
            //SELECT * FROM CLIENTE c JOIN ENDERECO e ON c.endereco_id=e.id
            pst = conexao.prepareStatement(sql.toString());
            pst.setInt(1, cliente.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cliente.setNome(rs.getString("nome"));
                cliente.setDocumento(rs.getString("documento"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setEstadoCivil(rs.getString("estadoCivil"));
                cliente.setDataNascimento(rs.getString("dataNascimento"));
                cliente.setTelefoneComercial(rs.getString("telefoneComercial"));
                cliente.setTelefoneCelular(rs.getString("telefoneCelular"));
                cliente.setInfoAdicional(rs.getString("infoAdicional"));
                endereco.setCep(rs.getString("cep"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setBairro(rs.getString("bairro"));
             //   endereco.setCidade(rs.getString("cidade"));
             //   endereco.setEstado(rs.getString("estado"));
                endereco.setId(rs.getInt("endereco_id"));
                cliente.setEndereco(endereco);
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
         
        cliente.setEndereco(endereco);
        clientes = new ArrayList<>();
        clientes.add(cliente);
    return clientes;
    }

    @Override
    public int salvarId(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<EntidadeDominio> filtrar(EntidadeDominio entidade) throws SQLException {
        PreparedStatement pst = null;
        Cliente cliente = (Cliente)entidade;
        List<EntidadeDominio> clientes = null;
        String sql = null;
        
        //if (cliente.getNome()!= null && !"".equals(cliente.getNome())){
            sql = "SELECT * FROM CLIENTE WHERE nome='"+cliente.getNome()+"' AND status=1";
            //SELECT * FROM CLIENTE c JOIN ENDERECO e ON c.endereco_id=e.id;
       // }else if(cliente.getDocumento()!= null && !"".equals(cliente.getDocumento())){ 
        //    sql = "SELECT * FROM CLIENTE c JOIN ENDERECO e ON c.endereco_id=e.id WHERE c.documento='"+cliente.getDocumento()+"' AND c.status=1";
        //}
        
          try {
            conexao = Conexao.getConnection();
            pst = conexao.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            clientes = new ArrayList<>();
            while(rs.next()){
                Cliente cli = new Cliente();
                endereco = new Endereco();
                cli.setId(rs.getInt(1));
                cli.setNome(rs.getString(2));
                cli.setDocumento(rs.getString(3));
                cli.setEmail(rs.getString(4));
                cli.setSexo(rs.getString(5));
                cli.setEstadoCivil(rs.getString(6));
                cli.setDataNascimento(rs.getString(7));
                cli.setTelefoneComercial(rs.getString(8));
                cli.setTelefoneCelular(rs.getString(9));
                cli.setInfoAdicional(rs.getString(10));
                cli.setStatus(rs.getInt(11));
                endereco.setCep(rs.getString((14)));
                cli.setEndereco(endereco);
                clientes.add(cli);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientes;
    }
    

    @Override
    public List<ClienteJuridico> consultarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public static boolean isExisteCPF (String cpf){
        // VERIFICAR SE CNPJ ESTA CADASTRADO
        
        try {                     
            try (Connection conexao = Conexao.getConnection()) {
                String instrucaoSQL = "SELECT documento FROM CLIENTE WHERE documento='"+cpf+"' AND status=1";
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
    
    public int insereVeiculo(String documento) throws ClassNotFoundException, SQLException{
        int id = 0;
        try {
                // Abre uma conexao com o banco.
                conexao = Conexao.getConnection();
                
                StringBuilder sql = new StringBuilder();
                String instrucaoSQL = "SELECT * FROM CLIENTE WHERE documento='"+documento+"' AND status=1";
                PreparedStatement declaracao = conexao.prepareStatement(instrucaoSQL);
                //clientesJuridicos = new ArrayList<>();
                ResultSet resultado = declaracao.executeQuery();
                if(resultado.next()){                     
                    id = (resultado.getInt(1));
                }
                
            } catch (ClassNotFoundException erro) {
                erro.printStackTrace();
           
            } catch (SQLException erro) {
                erro.printStackTrace();
          
            } finally {
                try {
                    //pst.close();
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return id;
    }

    @Override
    public List<EntidadeDominio> continuar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void updateCorretor(EntidadeDominio entidade, String documento, int id) throws SQLException {
        Cliente cliente = (Cliente) entidade;
        try {
            conexao = Conexao.getConnection();
            //conexao.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE c ");
            sql.append("SET c.corretor_id=? ");
            sql.append("FROM CLIENTE c ");
            sql.append("WHERE c.documento=?");
                      
            pst = conexao.prepareStatement(sql.toString());
            
            pst = conexao.prepareStatement(sql.toString());
            pst.setInt(1, id);            
            pst.setString(2, cliente.getDocumento());
            
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
    
    public static boolean existeEmail (String email){
        // VERIFICAR SE PLACA JA EXISTE ESTA CADASTRADO
        try {                     
            Connection conexao = Conexao.getConnection();
            String instrucaoSQL = "SELECT * FROM CLIENTE WHERE email='"+email+"'";
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
                    Logger.getLogger(DadosObrigatoriosLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                }catch(SQLException erro){
                    erro.printStackTrace();
                    try {
                        throw new SQLException("Erro bd");
                    } catch (SQLException ex) {
                        Logger.getLogger(DadosObrigatoriosLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  
                }
        return false;
    }

    public Cliente autenticar (Cliente cliente){
        Cliente encontrado = null;
        
        try {
            Connection conexao = Conexao.getConnection();
            String instrucaoSQL = "SELECT * FROM login WHERE email=?";
            
            PreparedStatement declaracao = conexao.prepareStatement(instrucaoSQL);
            declaracao.setString(1, cliente.getEmail());
            ResultSet resultado = declaracao.executeQuery();
            
            if (resultado.next()){
                if (cliente.getSenha().equals(resultado.getString("senha"))){
                    encontrado = new Cliente();
                    encontrado.setId(resultado.getInt("id"));
                    encontrado.setEmail(resultado.getString("email"));
                    encontrado.setSenha(resultado.getString("senha"));
                    encontrado.setPapel(resultado.getString("papel"));
                }
            }
            conexao.close();
            }
                catch (ClassNotFoundException erro){
                erro.printStackTrace();
                try {
                    throw new SQLException("Houve erro com o banco");
                } catch (SQLException ex) {
                    Logger.getLogger(DadosObrigatoriosLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                }catch(SQLException erro){
                    erro.printStackTrace();
                    try {
                        throw new SQLException("Erro bd");
                    } catch (SQLException ex) {
                        Logger.getLogger(DadosObrigatoriosLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  
                }
        return encontrado;
        
    }
        
}
