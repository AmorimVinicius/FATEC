/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.core.negocio;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;



/**
 *
 * @author viniciusamorim
 */
public class Substring {
  public static void main(String[] args) throws ParseException {
     
        Timestamp dataHoje = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
        Date agora = new Date(); 
        
        String novaData = df.format(dataHoje);
        
        System.out.println(novaData);
        
        System.out.println(df.format(agora));
        System.out.println(df.format(dataHoje));
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String string  = dateFormat.format(new Date());
        System.out.println(string);
       /* int diasTrabalhados;

        diasTrabalhados = (int) ((dataAtual.getTime() - dataAdmissao.getTime()) / 86400000L);
      */
      
      
      
}
  
 
  
}
