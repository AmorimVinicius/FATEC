package br.com.Seguradora.core.dao;

import br.com.Seguradora.core.util.BancoDadosPostgres;
import br.com.Seguradora.core.util.Conexao;
import br.com.Seguradora.dominio.ClienteJuridico;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Produto;
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

public class ClienteJuridicoDAO implements IDAO{

    
    PreparedStatement pst;
    Connection conexao;
    ClienteJuridico clienteJuridico;
    
    @Override
    public void salvar(EntidadeDominio entidade){
        
        clienteJuridico = new ClienteJuridico();
        ClienteJuridico clienteJuridico = (ClienteJuridico) entidade;
        clienteJuridico.setStatus(0);
        
        try {
             // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
                StringBuilder sql = new StringBuilder();
                //sql.append("INSERT INTO juridico(nome, cnpj, email, fixo, celular, responsavel, observacao)");
		//sql.append("VALUES(?, ?, ?, ?, ?, ?, ?)");
                
                sql.append("INSERT INTO CLIENTE_JURIDICO(razaoSocial, cnpj, email, telefoneComercial, telefoneCelular, pessoaResponsavel, infoAdicional, status)");
		sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
                
                //PreparedStatement pst = conexao.prepareStatement(sql.toString());
                pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
            
            
            pst.setString(1, clienteJuridico.getNome());
            pst.setString(2, clienteJuridico.getCnpj());
            pst.setString(3, clienteJuridico.getEmail());
            pst.setString(4, clienteJuridico.getTelefoneComercial());
            pst.setString(5, clienteJuridico.getTelefoneCelular());
            pst.setString(6, clienteJuridico.getPessoaResponsavel());
            pst.setString(7, clienteJuridico.getInfoAdicional());
            pst.setInt(8, clienteJuridico.getStatus());
                        
            pst.executeUpdate();
            
            ResultSet rs = pst.getGeneratedKeys();
            int id = 0;
            if(rs.next()){
                id = rs.getInt(1);
                clienteJuridico.setId(id);
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
        ClienteJuridico clienteJuridico = (ClienteJuridico) entidade;
        
        clienteJuridico.setStatus(0);
        
        try {
            conexao = Conexao.getConnection();
            conexao.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE CLIENTE_JURIDICO SET razaoSocial=?, cnpj=?, email=?, telefoneComercial=?, telefoneCelular=?, pessoaResponsavel=?, infoAdicional=?, status=? ");
            sql.append("WHERE id=?");
                
            pst = conexao.prepareStatement(sql.toString());
            pst.setString(1, clienteJuridico.getNome());
            pst.setString(2, clienteJuridico.getCnpj());
            pst.setString(3, clienteJuridico.getEmail());
            pst.setString(4, clienteJuridico.getTelefoneComercial());
            pst.setString(5, clienteJuridico.getTelefoneCelular());
            pst.setString(6, clienteJuridico.getPessoaResponsavel());
            pst.setString(7, clienteJuridico.getInfoAdicional());
            pst.setInt(8, clienteJuridico.getStatus());
            pst.setInt(9, clienteJuridico.getId());
            
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
        ClienteJuridico clienteJuridico = (ClienteJuridico) entidade;
        
        clienteJuridico.setStatus(1);
        
        try {
            conexao = Conexao.getConnection();
            conexao.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE CLIENTE_JURIDICO SET status=? ");
            sql.append("WHERE id=?");
                
            pst = conexao.prepareStatement(sql.toString());
            pst.setInt(1, clienteJuridico.getStatus());
            pst.setInt(2, clienteJuridico.getId());
            
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
        
        List<EntidadeDominio> clientesJuridicos = null;
        ClienteJuridico clienteJuridico = (ClienteJuridico) entidade;
        System.out.println("cliente dao" + clienteJuridico.getId());
        
        try {

            // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM CLIENTE_JURIDICO WHERE id=?");
            pst = conexao.prepareStatement(sql.toString());
            pst.setInt(1, clienteJuridico.getId());
            ResultSet rs = pst.executeQuery();
             System.out.println("clientexx" + clienteJuridico.getId());
            while (rs.next()) {
                clienteJuridico.setNome(rs.getString("razaoSocial"));
                clienteJuridico.setCnpj(rs.getString("cnpj"));
                clienteJuridico.setEmail(rs.getString("email"));
                clienteJuridico.setTelefoneComercial(rs.getString("telefoneComercial"));
                clienteJuridico.setTelefoneCelular(rs.getString("telefoneCelular"));
                clienteJuridico.setPessoaResponsavel(rs.getString("pessoaResponsavel"));
                clienteJuridico.setInfoAdicional(rs.getString("infoAdicional"));
            }
            System.out.println("cliente" + clienteJuridico.getNome());
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
        clientesJuridicos = new ArrayList<>();
        clientesJuridicos.add(clienteJuridico);
        return clientesJuridicos;
        
    }

    @Override
    public int salvarId(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadeDominio> filtrar(EntidadeDominio entidade) throws SQLException {
        List<EntidadeDominio> clientes = null;
        ClienteJuridico filtro = (ClienteJuridico) entidade;
        
        StringBuilder sql = new StringBuilder();
            sql.append("SELECT cj.id,cj.razaoSocial as razaoSocial,cj.cnpj,cj.email,cj.telefoneComercial,cj.telefoneCelular,cj.pessoaResponsavel,cj.infoAdicional ");
            sql.append("FROM CLIENTE_JURIDICO ");
            sql.append("WHERE cj.status=? ");
            
            if (filtro.getNome() != null && !filtro.getNome().equals("")) {
                sql.append("AND unaccent(cj.razaoSocial) ILIKE unaccent('%' || ? || '%') ");
            }
            
            if (filtro.getCnpj()!= null && !filtro.getCnpj().equals("")) {
                sql.append("AND  unaccent(cj.cnpj) ILIKE  unaccent('%' || ? || '%') ");
            }
            
            if (filtro.getEmail()!= null && !filtro.getEmail().equals("")) {
                sql.append("AND  unaccent(cj.email) ILIKE  unaccent('%' || ? || '%') ");
            }
            
            if (filtro.getTelefoneComercial()!= null && !filtro.getTelefoneComercial().equals("")) {
                sql.append("AND  unaccent(cj.telefoneComercial) ILIKE  unaccent('%' || ? || '%') ");
            }
            
            if (filtro.getTelefoneCelular()!= null && !filtro.getTelefoneCelular().equals("")) {
                sql.append("AND  unaccent(cj.telefoneCelular) ILIKE  unaccent('%' || ? || '%') ");
            }
            
            if (filtro.getPessoaResponsavel()!= null && !filtro.getPessoaResponsavel().equals("")) {
                sql.append("AND  unaccent(cj.pessoaResponsavel) ILIKE  unaccent('%' || ? || '%') ");
            }
            
            if (filtro.getInfoAdicional()!= null && !filtro.getInfoAdicional().equals("")) {
                sql.append("AND  unaccent(cj.infoAdicional) ILIKE  unaccent('%' || ? || '%') ");
            }
                     
        try {

            // Abre uma conexao com o banco.
            conexao = Conexao.getConnection();
            
           int i =2;
            
            pst = conexao.prepareStatement(sql.toString());
            pst.setInt(1, filtro.getStatus());
            
            if (filtro.getNome() != null && !filtro.getNome().equals("")) {
                pst.setString(i, filtro.getNome());
                i++;
            }
           
            if (filtro.getCnpj()!= null && !filtro.getCnpj().equals("")) {
                pst.setString(i, filtro.getCnpj());
                  i++;
            }
            
            if (filtro.getEmail()!= null && !filtro.getEmail().equals("")) {
                pst.setString(i, filtro.getEmail());
                  i++;
            }
            
            if (filtro.getTelefoneComercial()!= null && !filtro.getTelefoneComercial().equals("")) {
                pst.setString(i, filtro.getTelefoneComercial());
                  i++;
            }
            
            if (filtro.getTelefoneCelular()!= null && !filtro.getTelefoneCelular().equals("")) {
                pst.setString(i, filtro.getTelefoneCelular());
                  i++;
            }
            
            
            if (filtro.getPessoaResponsavel()!= null && !filtro.getPessoaResponsavel().equals("")) {
                pst.setString(i, filtro.getPessoaResponsavel());
                  i++;
            }
            
            if (filtro.getInfoAdicional()!= null && !filtro.getInfoAdicional().equals("")) {
                pst.setString(i, filtro.getInfoAdicional());
                  i++;
            }
            
            ResultSet rs = pst.executeQuery();
            clientes = new ArrayList<>();
            while (rs.next()) {
                ClienteJuridico cj = new ClienteJuridico();
                                
                cj.setId(rs.getInt(1));
                cj.setNome(rs.getString(2));
                cj.setCnpj(rs.getString(3));
                cj.setEmail(rs.getString(4));
                cj.setTelefoneComercial(rs.getString(5));
                cj.setTelefoneCelular(rs.getString(6));
                cj.setPessoaResponsavel(rs.getString(7));
                cj.setInfoAdicional(rs.getString(8));
                
                clientes.add(cj);
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
        
        return clientes;
    }

    @Override
    public List<ClienteJuridico> consultarTodos() throws SQLException {
        List<ClienteJuridico> clientesJuridicos = null;
        
        int status = 0;
        
        try {
            // Abre uma conexao com o banco.
            //Connection conexao = BancoDadosPostgres.getConexao();
            
            Connection conexao = Conexao.getConnection();
            
            String instrucaoSQL = "SELECT id, razaoSocial, cnpj, email, telefoneComercial, telefoneCelular, pessoaResponsavel, infoAdicional FROM CLIENTE_JURIDICO WHERE status="+status;
            //String instrucaoSQL = "SELECT id, nome, cnpj, email, fixo, celular, responsavel, observacao FROM juridico";
            
            PreparedStatement declaracao = conexao.prepareStatement(instrucaoSQL);
            clientesJuridicos = new ArrayList<>();
            ResultSet resultado = declaracao.executeQuery();
            while(resultado.next()){
                ClienteJuridico cj = new ClienteJuridico();
                cj.setId(resultado.getInt("id"));
                cj.setNome(resultado.getString("razaoSocial"));
                cj.setCnpj(resultado.getString("cnpj"));
                cj.setEmail(resultado.getString("email"));
                cj.setTelefoneComercial(resultado.getString("telefoneComercial"));
                cj.setTelefoneCelular(resultado.getString("telefoneCelular"));
                cj.setPessoaResponsavel(resultado.getString("pessoaResponsavel"));
                cj.setInfoAdicional(resultado.getString("infoAdicional"));
                
                clientesJuridicos.add(cj);
            }
                conexao.close();
        }
        catch (ClassNotFoundException erro){
            erro.printStackTrace();
            throw new SQLException("Houve erro com o banco");
        }catch(SQLException erro){
            erro.printStackTrace();
            throw new SQLException("Erro bd");
        }
        return clientesJuridicos;
}
    
    public String verificarDocExistente(String doc) throws SQLException{
        
        //List<ClienteJuridico> clientesJuridicos = null;
        Veiculo veiculo = new Veiculo();
        
        try {
            // Abre uma conexao com o banco.
            //Connection conexao = BancoDadosPostgres.getConexao();
            
            Connection conexao = Conexao.getConnection();
            
            String instrucaoSQL = "SELECT cnpj FROM CLIENTE_JURIDICO WHERE cnpj='"+doc+"'";
            //String instrucaoSQL = "SELECT id, nome, cnpj, email, fixo, celular, responsavel, observacao FROM juridico";
            
            PreparedStatement declaracao = conexao.prepareStatement(instrucaoSQL);
            //clientesJuridicos = new ArrayList<>();
            ResultSet resultado = declaracao.executeQuery();
            while(resultado.next()){    
                veiculo.setRetornoConsultaDoc("ok");
            }
                conexao.close();
        }
        catch (ClassNotFoundException erro){
            erro.printStackTrace();
            throw new SQLException("Houve erro com o banco");
        }catch(SQLException erro){
            erro.printStackTrace();
            throw new SQLException("Erro bd");
        }
        return veiculo.getRetornoConsultaDoc();
    
}

    @Override
    public List<EntidadeDominio> continuar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
