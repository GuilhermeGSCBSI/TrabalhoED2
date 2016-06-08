package Fonte;

import java.util.ArrayList;

public class Principal {

    
    public static void main(String[] args) {
     
        DicionarioABB dicionario = new DicionarioABB("C:\\dicionario.txt");
        ArrayList<String> palavras = Auxiliares.PalavrasNaoEncontradasDicionarioABB(dicionario.getDicionarioABB(),"C:\\livro1.txt");
        
           
    }
    
}
