package br.com.Seguradora.core.dao;

import br.com.Seguradora.core.negocio.DadosObrigatoriosCorretor;
import br.com.Seguradora.core.negocio.DadosObrigatoriosLogin;
import br.com.Seguradora.core.negocio.DadosObrigatoriosVeiculo;
import br.com.Seguradora.core.util.Conexao;
import br.com.Seguradora.dominio.Cliente;
import br.com.Seguradora.dominio.ClienteJuridico;
import br.com.Seguradora.dominio.Corretor;
import br.com.Seguradora.dominio.Endereco;
import br.com.Seguradora.dominio.EntidadeDominio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CorretorDAO implements IDAO{
    
    Endereco endereco;
    PreparedStatement pst;
    EnderecoDAO endDAO;
    Connection conexao;
    Corretor corr;
    Cliente cliente;
    ClienteDAO cliDAO;

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        Corretor corretor = (Corretor) entidade;       
       
        try {
             // Abre uma conexao com o banco.
             
            conexao = Conexao.getConnection();
            
            StringBuilder sql = new StringBuilder();  
                
                sql.append("INSERT INTO CORRETOR(nome, razaoSocial, email, documento, telefoneComercial, telefoneCelular, pessoaResponsavel, infoAdicional, status)");
                sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
                
                pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            
            pst.setString(1, corretor.getNome());
            pst.setString(2, corretor.getRazaoSocial());
            pst.setString(3, corretor.getEmail());
            pst.setString(4, corretor.getDocumento());
            pst.setString(5, corretor.getTelefoneComercial());
            pst.setString(6, corretor.getTelefoneCelular());
            pst.setString(7, corretor.getPessoaResponsavel());
            pst.setString(8, corretor.getInfoAdicional());
            //pst.setInt(9, 1);
            pst.setInt(9, 1);
                        
            pst.executeUpdate();            
            ResultSet rs = pst.getGeneratedKeys();
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
                corretor.setId(id);
            }
            
          // Fecha a conexao.
            conexao.close();
            
            //Salvando cliente
            cliente = corretor.getCliente();
            cliDAO = new ClienteDAO();
            cliDAO.updateCorretor(cliente, corretor.getCliente().getDocumento(), corretor.getId());
            
            //Salvando endereco
            endereco = corretor.getEndereco();
            endDAO = new EnderecoDAO();
            int idEnd = 0;
            String classe = "CORRETOR";
            endDAO.salvarEndereco(endereco, corretor.getId(), classe);
            
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
        Corretor corretor = (Corretor) entidade;
        
        //Alterando endereco
        endereco = corretor.getEndereco();
        endDAO = new EnderecoDAO();
        endDAO.alterar(endereco);
        
        try {
            conexao = Conexao.getConnection();
            //conexao.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE c ");
            sql.append("SET c.nome=?, c.razaoSocial=?, c.email=?, c.documento=?, c.telefoneComercial=?, ");
            sql.append("c.telefoneCelular=?, c.pessoaResponsavel=?, c.infoAdicional=? ");
            sql.append("FROM CORRETOR c ");
            sql.append("WHERE c.id=?");
            //INNER JOIN ENDERECO e ON c.endereco_id=e.id 
            
            pst = conexao.prepareStatement(sql.toString());
            pst.setString(1, corretor.getNome());
            pst.setString(2, corretor.getRazaoSocial());
            pst.setString(3, corretor.getEmail());
            pst.setString(4, corretor.getDocumento());
            pst.setString(5, corretor.getTelefoneComercial());
            pst.setString(6, corretor.getTelefoneCelular());
            pst.setString(7, corretor.getPessoaResponsavel());
            pst.setString(8, corretor.getInfoAdicional());
            pst.setInt(9, corretor.getId());
            
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
        Corretor corretor = (Corretor) entidade;
        corretor.setStatus(0);
        if (corretor.getId() != 0) {
            try {
                // Abre uma conexao com o banco.
                conexao = Conexao.getConnection();
                
                StringBuilder sql = new StringBuilder();
                sql.append("UPDATE CORRETOR SET status=? WHERE id=?");
                
                pst = conexao.prepareStatement(sql.toString());
                pst.setInt(1, corretor.getStatus());
                pst.setInt(2, corretor.getId());
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
        List<EntidadeDominio> corretores = null;
        Corretor corretor = (Corretor) entidade;
        endereco = new Endereco();
        
        try {

            // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM CORRETOR WHERE id=?");
            pst = conexao.prepareStatement(sql.toString());
            pst.setInt(1, corretor.getId());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                corretor.setNome(rs.getString("nome"));
                corretor.setRazaoSocial(rs.getString("razaoSocial"));
                corretor.setEmail(rs.getString("email"));
                corretor.setDocumento(rs.getString("documento"));               
                corretor.setTelefoneComercial(rs.getString("telefoneComercial"));
                corretor.setTelefoneCelular(rs.getString("telefoneCelular"));
                corretor.setPessoaResponsavel(rs.getString("pessoaResponsavel"));
                corretor.setInfoAdicional(rs.getString("infoAdicional"));
                //endereco.setCep(rs.getString("cep"));
               // endereco.setLogradouro(rs.getString("logradouro"));
                //endereco.setNumero(rs.getString("numero"));
                //endereco.setComplemento(rs.getString("complemento"));
                //endereco.setBairro(rs.getString("bairro"));
                //endereco.setCidade(rs.getString("cidade"));
               // endereco.setEstado(rs.getString("estado"));
                //endereco.setId(rs.getInt("endereco_id"));
                //corretor.setEndereco(endereco);
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
         
        //corretor.setEndereco(endereco);
        corretores = new ArrayList<>();
        corretores.add(corretor);
    return corretores;
    }

    @Override
    public int salvarId(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadeDominio> filtrar(EntidadeDominio entidade) throws SQLException {
        PreparedStatement pst = null;
        Corretor corretor = (Corretor)entidade;
        List<EntidadeDominio> corretores = null;
        String sql = null;
       
        if (corretor.getNome()!= null && !"".equals(corretor.getNome())){
            sql = "SELECT * FROM CORRETOR c JOIN ENDERECO e ON e.corretor_id=c.id WHERE c.nome='"+corretor.getNome()+"' AND c.status=1";
            //     SELECT * FROM CORRETOR c JOIN ENDERECO e ON e.corretor_id=c.id WHERE c.documento='30.286.840/0001-23' AND c.status=1
        }
        else if (corretor.getRazaoSocial()!= null && !"".equals(corretor.getRazaoSocial())){
            sql = "SELECT * FROM CORRETOR c JOIN ENDERECO e ON e.corretor_id=c.id WHERE c.razaoSocial='"+corretor.getRazaoSocial()+"' AND c.status=1";
        }
        else if (corretor.getDocumento()!= null && !"".equals(corretor.getDocumento())){
            sql = "SELECT * FROM CORRETOR c JOIN ENDERECO e ON e.corretor_id=c.id WHERE c.documento='"+corretor.getDocumento()+"' AND c.status=1";
        }
        
          try {
            conexao = Conexao.getConnection();
            pst = conexao.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            corretores = new ArrayList<>();
            while(rs.next()){
                Corretor cor = new Corretor();
                endereco = new Endereco();
                cor.setId(rs.getInt(1));
                cor.setNome(rs.getString(2));
                cor.setRazaoSocial(rs.getString(3));
                cor.setEmail(rs.getString(4));
                cor.setDocumento(rs.getString(5));
                cor.setTelefoneComercial(rs.getString(6));
                cor.setTelefoneCelular(rs.getString(7));
                cor.setPessoaResponsavel(rs.getString(8));
                cor.setInfoAdicional(rs.getString(9));
                endereco.setCep(rs.getString(13));
                //endereco.setLogradouro(rs.getString(14));
                //endereco.setNumero(rs.getString(15));
               // endereco.setComplemento(rs.getString(16));
               // endereco.setBairro(rs.getString(17));
               // endereco.setCidade(rs.getString(18));
               // endereco.setEstado(rs.getString(19));
                cor.setEndereco(endereco);
                corretores.add(cor);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return corretores;
    }

    @Override
    public List<ClienteJuridico> consultarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static boolean isExisteCNPJ (String cnpj){
        // VERIFICAR SE CNPJ ESTA CADASTRADO
        
        try {                     
            Connection conexao = Conexao.getConnection();
            String instrucaoSQL = "SELECT documento FROM CORRETOR WHERE documento='"+cnpj+"' AND status=1";
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
                    Logger.getLogger(DadosObrigatoriosVeiculo.class.getName()).log(Level.SEVERE, null, ex);
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

    @Override
    public List<EntidadeDominio> continuar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static boolean existeEmail (String email){
        // VERIFICAR SE PLACA JA EXISTE ESTA CADASTRADO
        try {                     
            Connection conexao = Conexao.getConnection();
            String instrucaoSQL = "SELECT * FROM CORRETOR WHERE email='"+email+"'";
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

    
}
