package Fonte;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.lang.*;

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
                        if (!dicionario.contains(palavraFormatada)) {
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

    static String RetiraCaracterEspecial(String texto) {

        String textoAux = texto.replace(",", "");

        textoAux = textoAux.replace(" ", "");
        textoAux = textoAux.replace(":", "");
        textoAux = textoAux.replace("]", "");
        textoAux = textoAux.replace("[", "");
        textoAux = textoAux.replace("(", "");
        textoAux = textoAux.replace(")", "");
        textoAux = textoAux.replace("*", "");
        textoAux = textoAux.replace("&", "");
        textoAux = textoAux.replace("%", "");
        textoAux = textoAux.replace("$", "");
        textoAux = textoAux.replace("#", "");
        textoAux = textoAux.replace("@", "");
        textoAux = textoAux.replace("!", "");
        textoAux = textoAux.replace("'", "");
        textoAux = textoAux.replace("+", "");
        textoAux = textoAux.replace("´", "");
        textoAux = textoAux.replace("`", "");
        textoAux = textoAux.replace("{", "");
        textoAux = textoAux.replace("}", "");
        textoAux = textoAux.replace("?", "");
        textoAux = textoAux.replace("/", "");
        textoAux = textoAux.replace("°", "");
        textoAux = textoAux.replace(";", "");
        textoAux = textoAux.replace("<", "");
        textoAux = textoAux.replace(">", "");
        textoAux = textoAux.replace("|", "");
        textoAux = textoAux.replace(",", "");
        textoAux = textoAux.replace(".", "");
        return textoAux;

    }

}
