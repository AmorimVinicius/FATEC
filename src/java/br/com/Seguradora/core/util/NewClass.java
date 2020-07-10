/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Seguradora.core.util;

/**
 *
 * @author viniciusamorim
 */
public class NewClass {
    public static void main(String[] args) {
    //    String teste = null;
    //    teste = "C:/Users/viniciusamorim/Desktop/Seguradora - 13.04.2019/web/imagens/Diagrama.png";
    //    teste = teste.replace("C:/Users/viniciusamorim/Desktop/Seguradora - 13.04.2019/web/","..");
    //    System.getProperty("user.dir");
    //    System.out.println(teste);
    String msg = null;
    String senhaforte = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    String nome = "Vinicius";
    boolean flag = nome.matches(senhaforte);
    if (flag == false) {
        msg = "Senha inválida.\nSenha deve ter 8 caracteres no mínimo, uma letra maiúscula e uma minúscula e um caracter especial(@#$%^&+=)";
    }
        System.out.println(msg);
    
    }
    
}
