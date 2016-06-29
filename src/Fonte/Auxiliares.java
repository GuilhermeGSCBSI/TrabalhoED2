package Fonte;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import Fonte.RBTree;

public class Auxiliares {

    static public BinaryTree RetornaArvorePorArquivo(String caminhoDicionario) {

        ArrayList<String> palavras = new ArrayList<>();
        BinaryTree Arvore = new BinaryTree();
        try {

            File diretorio = new File(caminhoDicionario);
            File fList[] = diretorio.listFiles();

            for (int i = 0; i < fList.length; i++) {

                FileReader arq = new FileReader(fList[i].getAbsolutePath() );
                BufferedReader lerArq = new BufferedReader(arq);
                String linha = lerArq.readLine();
                while (linha != null) {
                    palavras.add(linha);
                    Arvore.inserir(linha);
                    linha = lerArq.readLine();
                }

                arq.close();
            }

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
                    no = dicionario.busca(Palavra);
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

    static public ArrayList<String> PalavrasNaoEncontradasDicionarioRB(RBTree dicionario, String caminhoLivro) {

        ArrayList<String> palavras = new ArrayList<>();
        String[] listaPalavras;

        try {

            FileReader arq = new FileReader(caminhoLivro);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();

            while (linha != null) {
                listaPalavras = linha.split(" ");
                for (String Palavra : listaPalavras) {
                    if (!dicionario.search(Palavra)) {
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
    
    static public RBTree RetornaArvoreVPPorArquivo(String caminhoDicionario) {

        ArrayList<String> palavras = new ArrayList<>();
       RBTree Arvore = new RBTree("-1");
        try {

            File diretorio = new File(caminhoDicionario);
            File fList[] = diretorio.listFiles();

            for (int i = 0; i < fList.length; i++) {

                FileReader arq = new FileReader(fList[i].getAbsolutePath() );
                BufferedReader lerArq = new BufferedReader(arq);
                String linha = lerArq.readLine();
                while (linha != null) {
                    palavras.add(linha);
                    Arvore.insert(linha);
                    linha = lerArq.readLine();
                }

                arq.close();
            }

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        return Arvore;
    }
}
