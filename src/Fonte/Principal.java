package Fonte;

import java.util.ArrayList;

public class Principal {

    
    public static void main(String[] args) {
     
        DicionarioRB dicionario = new DicionarioRB("C:\\Dicionario");
       System.out.println("Teste");
        ArrayList<String> palavras = Auxiliares.PalavrasNaoEncontradasDicionarioRB(dicionario.getDicionarioRB(), "C:\\livro1.txt");
           System.out.println("Teste");    
    }
    
}
