package br.com.Seguradora.core.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;


import java.sql.*;

public class TesteConexaoProduto {
	public static void main(String[] args) {
		Connection conn;
		String sql;
		ResultSet rs;
		Statement st;
		try {
			conn = Conexao.getConnection();
			st = conn.createStatement();
			sql = "UPDATE VEICULO SET marca=2011, modelo=2011, chassi=2, anoFabricacao=2, anoModelo=2011, documentoCliente=2, numeroFrota=2, numeroApolice=2, status=2 WHERE id=1";
                        /*
                        UPDATE nome_tabela
                        SET CAMPO = "novo_valor"
                        WHERE CONDIÇÃO
                        sql.append("UPDATE VEICULO SET marca=?, modelo=?, placa=?, chassi=?, anoFabricacao=?, AnoModelo=?, documentoCliente=?, numeroFrota=?, numeroApolice=?, status=?");
            sql.append("WHERE id=?");
                        */
			st.executeUpdate(sql);
			//while (rs.next()) {
			//	System.out.print("Resposta: " + rs.getString(1));
			//}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
