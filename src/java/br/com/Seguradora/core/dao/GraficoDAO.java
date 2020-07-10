/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.core.dao;

import br.com.Seguradora.core.negocio.DadosObrigatoriosClienteTerceiro;
import br.com.Seguradora.core.negocio.DadosObrigatoriosCorretor;
import br.com.Seguradora.core.util.Conexao;
import br.com.Seguradora.dominio.ClienteJuridico;
import br.com.Seguradora.dominio.EntidadeDominio;
import br.com.Seguradora.dominio.Grafico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viniciusamorim
 */
public class GraficoDAO implements IDAO{
    
    PreparedStatement pst;
    Connection conexao;    
    Grafico grafico;

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public int salvarId(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadeDominio> filtrar(EntidadeDominio entidade) throws SQLException {
        PreparedStatement pst = null;
        Grafico grafico = (Grafico)entidade;
        List<EntidadeDominio> graficos = null;
                
        String sql = null;
        
        /*sql = "SELECT (s.dataInsercao) as 'Dia', count(s.dataInsercao) as 'quantidade' " +
              "FROM sinistro s " +
             "WHERE s.dataInsercao BETWEEN '"+grafico.getDataInicial()+"' and '"+grafico.getDataFinal()+"' " +
              "GROUP BY s.dataInsercao";
        */
        sql =  "SELECT * " +
               "FROM ( " +
               "SELECT " +
               "(s.dataInsercao) as dataInicial, count(s.dataInsercao) as qtde, " +
               "(s.aceite) as solicitacao, count(s.aceite) as quantidade " +
               "FROM sinistro s " +
               "WHERE s.dataInsercao BETWEEN " +
               "cast('"+grafico.getDataInicial()+" 00:00:00.000' as datetime) AND " +
               "cast('"+grafico.getDataFinal()+" 00:00:00.000' as datetime) " + 
               "GROUP BY s.aceite, s.dataInsercao) em_linha " +
               "PIVOT (sum(qtde) for solicitacao in ([aprovado], [reprovado], [aguardando])) em_colunas " +
               "ORDER BY CONVERT(datetime, dataInicial, 103) ASC";
        
        try {
            conexao = Conexao.getConnection();
            pst = conexao.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            graficos = new ArrayList<>();
            while(rs.next()){
                grafico = new Grafico();
                grafico.setDataInicial((rs.getString(1)));
                grafico.setQuantidade(rs.getInt(2));    
                grafico.setAprovado(rs.getInt(3));
                grafico.setRecusado(rs.getInt(4));
                grafico.setAguardando(rs.getInt(5));
                graficos.add(grafico);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return graficos;
    }

    @Override
    public List<ClienteJuridico> consultarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EntidadeDominio> continuar(EntidadeDominio entidade) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public static boolean verificaIntervalo (String dataInicial, String dataFinal){
        
        try {                     
            Connection conexao = Conexao.getConnection();
            String instrucaoSQL = "SELECT * FROM SINISTRO WHERE dataInsercao BETWEEN " +
                    "'"+dataInicial+"' AND '"+dataFinal+"'";
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
