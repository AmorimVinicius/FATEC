package br.com.Seguradora.core.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDadosPostgres {
    
    public static Connection getConexao() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        
        Connection conexao;
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Fatec","postgres","admin");
    }
    
}
