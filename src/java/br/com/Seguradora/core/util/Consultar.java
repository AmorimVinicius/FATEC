package br.com.Seguradora.core.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;


import java.sql.*;

public class Consultar {
	public static void main(String[] args) {
            
            String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url = "jdbc:sqlserver://localhost:1433";
            String database = "databaseName=Fatec";
            String user = "fatec";
            String password = "fatec@01";
              
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Fatec;user=fatec;password=fatec@01";
               
		
		// Connect to database
        /*String hostName = "your_server.database.windows.net"; // update me
        String dbName = "your_database"; // update me
        String user = "your_username"; // update me
        String password = "your_password"; // update me
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);*/
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(connectionUrl);
            //String schema = connection.getSchema();
            //System.out.println("Successful connection - Schema: " + schema);

            System.out.println("Query data example:");
            System.out.println("=========================================");

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT * FROM CLIENTE_JURIDICO";

            try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql)) {

                // Print results from select statement
                System.out.println("Retorno");
                while (resultSet.next())
                {
                    System.out.println(
                          resultSet.getString(1) + " "
                        + resultSet.getString(2) + " "
                        + resultSet.getString(3) + " "
                        + resultSet.getString(4) + " "
                        + resultSet.getString(5) + " "
                        + resultSet.getString(6) + " "
                        + resultSet.getString(7) + " ");
                }
                connection.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}

}
