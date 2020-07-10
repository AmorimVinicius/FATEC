package br.com.Seguradora.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public static Connection getConnection() 
			throws ClassNotFoundException, 
		SQLException{
		/*String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/Fatec";
		String user = "postgres";
		String password = "admin";
                */
                String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                String url = "jdbc:sqlserver://localhost:1433";
                String database = "databaseName=Fatec";
                String user = "fatec";
                String password = "fatec@01";
                
                String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Fatec;user=fatec;password=fatec@01";
               
		Class.forName( driver );
		Connection conn = DriverManager.getConnection(connectionUrl);
                
		//Connection conn =	 DriverManager.getConnection( url, user, password);
                /*Class.forName( driver );
		Connection conn = DriverManager.getConnection(url, user, password);*/
		return conn;
                
                //"jdbc:sqlserver//sqlserver01.BASE_DADOS.com.br;databaseName=NOME;user=USER;"
            //+ "password=PASS;";
                
	}
            
}
