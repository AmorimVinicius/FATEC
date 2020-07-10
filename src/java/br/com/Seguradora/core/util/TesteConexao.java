package br.com.Seguradora.core.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;


import java.sql.*;

public class TesteConexao {
	public static void main(String[] args) {
		Connection conn;
		String sql;
		ResultSet rs;
		Statement st;
		try {
			conn = Conexao.getConnection();
			st = conn.createStatement();
			//sql = "INSERT INTO CLIENTE_JURIDICO(razaoSocial, cnpj, email, telefoneComercial, telefoneCelular, pessoaResponsavel, infoAdicional) values ('3','3','3','3','3','3','3')";
			sql = "INSERT INTO VEICULO(marca, modelo, placa, chassi, anoFabricacao, anoModelo, documentoCliente, numeroFrota, numeroApolice, status) VALUES ('3','3','3','3','3','3','3','3','3','0')";
                        
                        // sql = "UPDATE clienteJuridico SET razaoSocial=33, email=33, cnpj=33, telefoneComercial=33, telefoneCelular=33, pessoaResponsavel=33, infoAdicional=33 WHERE id=5";
                        
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
