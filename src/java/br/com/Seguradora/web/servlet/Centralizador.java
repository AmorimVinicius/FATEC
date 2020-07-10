/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.web.servlet;

import br.com.Seguradora.core.dao.FabricaDAO;
import br.com.Seguradora.core.dao.IDAO;
import br.com.Seguradora.dominio.ClienteJuridico;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viniciusamorim
 */
public class Centralizador extends HttpServlet {

   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response) 
           throws ServletException, IOException{
       
       ClienteJuridico clienteTemp = new ClienteJuridico();
       List<ClienteJuridico> clientesJuridicos;
       try {
           IDAO idao = FabricaDAO.getConexaoSQL();
           clientesJuridicos = idao.consultarTodos();
           request.setAttribute("todosClientesJuridicos", clientesJuridicos);
           request.getRequestDispatcher("/clienteJuridico/filtrarClienteJuridico.jsp").forward(request, response);
       } catch (IOException | SQLException | ServletException e) {
       }
       
   }

}
