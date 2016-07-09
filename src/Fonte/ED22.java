package Fonte;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class ED22 {

    public static void main(String[] args) {
        
        //pasta para leitura dos Dicionarios.
        String pathDicionario = "C:\\Dicionario";
        //livro com extensão .txt
        String pathLivro = "C:\\livro1.txt"; 
        
        operacoesArvoreVP(pathDicionario,pathLivro);
        
        operacoesHashing(pathDicionario,pathLivro);

    }
    
    public static void operacoesArvoreVP(String pathDicionario, String pathLivro){
        long tempoInicial;
        long tempoFinal;
        
         System.out.println("Resumo das operações na arvore vermelho e preta:");
        
        // Criação do Dicionario
        tempoInicial = System.currentTimeMillis();
        DicionarioRB dicionario = new DicionarioRB(pathDicionario);
        tempoFinal = System.currentTimeMillis();
        System.out.printf("Inserção: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);

        //Busca do livro no Dicionario
        tempoInicial = System.currentTimeMillis();
        ArrayList<String> palavras = Auxiliares.PalavrasNaoEncontradasDicionarioRB(dicionario.getDicionarioRB(), pathLivro);
        tempoFinal = System.currentTimeMillis();
        System.out.printf("Busca: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
        
        //Impressão palavras não encontradas
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("palavras não encontradas: " + df.format(palavras.size()));
    }
    
    public static void operacoesHashing(String pathDicionario, String pathLivro){
        
    }
    
}
