
package br.com.Seguradora.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDadosSQL {
    
    public static Connection getConexao() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        Connection conexao;
        return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Fatec;user=fatec;password=fatec@01");
        
       
               
    }
    
    
}
