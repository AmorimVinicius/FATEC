
package br.com.Seguradora.core.negocio;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class ValidarIdadeCliente {
    
    public boolean validarIdade (String dataNascimento) throws ParseException{
        
        DateFormat df = DateFormat.getDateInstance();
        Date date = df.parse(dataNascimento);
        int idade;
        idade = (int) ((new Date().getTime() - date.getTime()) / (31536000000L));
        
        if (idade >= 18)
            return true;
        else 
            return false;
    }
    
    
}
