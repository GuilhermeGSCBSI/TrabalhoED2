package Fonte;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Auxiliares {

    static public BinaryTree RetornaArvorePorArquivo(String caminhoDicionario) {

        ArrayList<String> palavras = new ArrayList<>();
        BinaryTree Arvore = new BinaryTree();
        try {

            FileReader arq = new FileReader(caminhoDicionario);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            while (linha != null) {
                palavras.add(linha);
                //System.out.println(linha);
                Arvore.inserir(linha);
                linha = lerArq.readLine();
            }

            arq.close();

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        return Arvore;
    }

    static public ArrayList<String> PalavrasNaoEncontradasDicionarioABB(BinaryTree dicionario, String caminhoLivro) {

        ArrayList<String> palavras = new ArrayList<>();
        Node no;
        String[] listaPalavras;

        try {

            FileReader arq = new FileReader(caminhoLivro);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();

            while (linha != null) {
                listaPalavras = linha.split(" ");
                for (String Palavra : listaPalavras) {
                    no = dicionario.busca(linha);
                    if (no == null) {
                        palavras.add(Palavra);
                    }
                }

                linha = lerArq.readLine();
            }

            arq.close();

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        return palavras;
    }

}
