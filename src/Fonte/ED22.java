package Fonte;

import java.io.IOException;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class ED22 {

    public static void main(String[] args) throws IOException {

        //pasta Dicionario.
        String pathDicionario = "Dicionarios";
        //Pasta Livro
        String pathLivro = "Livros";

        operacoesArvoreVP(pathDicionario, pathLivro);
        System.out.println("--------------------------------------------");
        operacoesHashing(pathDicionario, pathLivro);

    }

    public static void operacoesArvoreVP(String pathDicionario, String pathLivro) throws IOException {
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

        //Saida palavras não encontradas
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("palavras não encontradas: " + df.format(palavras.size()));
        Auxiliares.gravaTxt(palavras, "SaidaVP.txt");
        System.out.println("Arquivo de saida Gravado com Sucesso!!!");
    }

    public static void operacoesHashing(String pathDicionario, String pathLivro) throws IOException {
        hashing(pathDicionario, pathLivro);
        System.out.println("--------------------------------------------");
        hashing2(pathDicionario, pathLivro);
        System.out.println("--------------------------------------------");
        hashing3(pathDicionario, pathLivro);
    }

    private static void hashing(String pathDicionario, String pathLivro) throws IOException {
        long tempoInicial;
        long tempoFinal;

        System.out.println("Resumo das operações na estrutura de Hashing:");

        // Criação do Dicionario
        tempoInicial = System.currentTimeMillis();
        DicionarioHash dicionario = new DicionarioHash(pathDicionario, 900001);
        tempoFinal = System.currentTimeMillis();
        System.out.printf("Inserção: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);

        //Busca do livro no Dicionario
        tempoInicial = System.currentTimeMillis();
        ArrayList<String> palavras = Auxiliares.PalavrasNaoEncontradasDicionarioHash(dicionario, pathLivro);
        tempoFinal = System.currentTimeMillis();
        System.out.printf("Busca: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);

        //Saida palavras não encontradas
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("palavras não encontradas: " + df.format(palavras.size()));
        Auxiliares.gravaTxt(palavras, "SaidaHash.txt");
        System.out.println("Arquivo de saida Gravado com Sucesso!!!");
    }
    
    private static void hashing2(String pathDicionario, String pathLivro) throws IOException {
        long tempoInicial;
        long tempoFinal;

        System.out.println("Resumo das operações na estrutura de Hashing2:");

        // Criação do Dicionario
        tempoInicial = System.currentTimeMillis();
        DicionarioHash2 dicionario = new DicionarioHash2(pathDicionario, 900001);
        tempoFinal = System.currentTimeMillis();
        System.out.printf("Inserção: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);

        //Busca do livro no Dicionario
        tempoInicial = System.currentTimeMillis();
        ArrayList<String> palavras = Auxiliares.PalavrasNaoEncontradasDicionarioHash2(dicionario, pathLivro);
        tempoFinal = System.currentTimeMillis();
        System.out.printf("Busca: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);

        //Saida palavras não encontradas
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("palavras não encontradas: " + df.format(palavras.size()));
        Auxiliares.gravaTxt(palavras, "SaidaHash2.txt");
        System.out.println("Arquivo de saida Gravado com Sucesso!!!");
    }
    
     private static void hashing3(String pathDicionario, String pathLivro) throws IOException {
        long tempoInicial;
        long tempoFinal;

        System.out.println("Resumo das operações na estrutura de Hashing3:");

        // Criação do Dicionario
        tempoInicial = System.currentTimeMillis();
        DicionarioHash3 dicionario = new DicionarioHash3(pathDicionario, 900001);
        tempoFinal = System.currentTimeMillis();
        System.out.printf("Inserção: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);

        //Busca do livro no Dicionario
        tempoInicial = System.currentTimeMillis();
        ArrayList<String> palavras = Auxiliares.PalavrasNaoEncontradasDicionarioHash3(dicionario, pathLivro);
        tempoFinal = System.currentTimeMillis();
        System.out.printf("Busca: %.3f ms%n", (tempoFinal - tempoInicial) / 1000d);

        //Saida palavras não encontradas
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("palavras não encontradas: " + df.format(palavras.size()));
        Auxiliares.gravaTxt(palavras, "SaidaHash3.txt");
        System.out.println("Arquivo de saida Gravado com Sucesso!!!");
    }

}
