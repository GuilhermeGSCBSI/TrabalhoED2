package Fonte;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Auxiliares {

    static public ArrayList<String> PalavrasNaoEncontradasDicionarioRB(ArvoreVP dicionario, String caminhoLivro) {

        ArrayList<String> palavras = new ArrayList<>();
        String[] listaPalavras;

        try {

            FileReader arq = new FileReader(caminhoLivro);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();;
            String palavraFormatada = "";

            while (linha != null) {
                listaPalavras = linha.split(" ");
                for (String palavra : listaPalavras) {
                    palavraFormatada = palavra.replaceAll("[^a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]", "");
                    if (!palavraFormatada.equals("")) {
                        if (!dicionario.contido(palavraFormatada)) {
                            palavras.add(palavraFormatada);
                        }
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

    static public ArvoreVP RetornaArvoreVPPorArquivo(String caminhoDicionario) {

        ArvoreVP Arvore = new ArvoreVP();

        try {

            File diretorio = new File(caminhoDicionario);
            File fList[] = diretorio.listFiles();
            String[] listaPalavras;

            for (int i = 0; i < fList.length; i++) {

                FileReader arq = new FileReader(fList[i].getAbsolutePath());
                BufferedReader lerArq = new BufferedReader(arq);
                String linha = lerArq.readLine();
                String PalavraFormatada;
                while (linha != null) {
                    listaPalavras = linha.split(" ");
                    for (String Palavra : listaPalavras) {
                        if (Palavra != "") {
                            PalavraFormatada = Palavra.replaceAll("[^a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]", "");
                            Arvore.insere(PalavraFormatada);
                        }
                    }
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

    static void gravaTxt(ArrayList<String> palavras, String pathEscrita) throws IOException {
        FileWriter arquivo;
        arquivo = new FileWriter(pathEscrita);
        arquivo.write(palavras.toString());
        arquivo.close();
    }

    static String[] RetornaHashPorArquivo(String caminhoDicionario, int tamanhoTabela) {

        DicionarioHash tabela = new DicionarioHash(tamanhoTabela);

        try {

            File diretorio = new File(caminhoDicionario);
            File fList[] = diretorio.listFiles();
            String[] listaPalavras;

            for (int i = 0; i < fList.length; i++) {

                FileReader arq = new FileReader(fList[i].getAbsolutePath());
                BufferedReader lerArq = new BufferedReader(arq);
                String linha = lerArq.readLine();
                String PalavraFormatada;
                while (linha != null) {
                    listaPalavras = linha.split(" ");
                    for (String Palavra : listaPalavras) {
                        if (!Palavra.equals("")) {
                            PalavraFormatada = Palavra.replaceAll("[^a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]", "");
                            //tabela.insere(PalavraFormatada.toLowerCase());
                            tabela.insereDH(PalavraFormatada.toLowerCase());
                        }
                    }
                    linha = lerArq.readLine();
                }
                arq.close();
            }

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        return tabela.getDicionario();
    }

    static ArrayList<String> PalavrasNaoEncontradasDicionarioHash(DicionarioHash dicionario, String caminhoLivro) {
        ArrayList<String> palavras = new ArrayList<>();
        String[] listaPalavras;

        try {

            FileReader arq = new FileReader(caminhoLivro);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();;
            String palavraFormatada = "";

            while (linha != null) {
                listaPalavras = linha.split(" ");
                for (String palavra : listaPalavras) {
                    palavraFormatada = palavra.replaceAll("[^a-zA-ZáàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ]", "");
                    if (!palavraFormatada.equals("")) {
                        //if (!dicionario.contido(palavraFormatada.toLowerCase())) {
                        if (!dicionario.contidoDH(palavraFormatada.toLowerCase())) {
                            palavras.add(palavraFormatada);
                        }
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

    static boolean isPrime(int number) {

        if (number % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= number; i += 2) {

            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int getPreviousPrime(int maxNumberToCheck) {
        for (int i = maxNumberToCheck; true; i--) {
            if (isPrime(i)) {
                return i;
            }
        }
    }
}
