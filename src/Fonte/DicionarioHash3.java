package Fonte;

public class DicionarioHash3 {

    static String[] dicionario;
    static int tamanhoTabela;

    public DicionarioHash3(String caminho, int tamanhoTabela) {
        dicionario = new String[tamanhoTabela];
        dicionario = Auxiliares.RetornaHash3PorArquivo(caminho, tamanhoTabela);
    }

    DicionarioHash3(int tamanhoTabela) {
        dicionario = new String[tamanhoTabela];
        this.tamanhoTabela = tamanhoTabela;
        for (int i = 0; i < tamanhoTabela; i++) {
            dicionario[i] = "";
        }
    }

    public String[] getDicionario() {
        return this.dicionario;
    }

    public static int hash(String s) {
        return Math.abs(s.hashCode() % tamanhoTabela);
    }

    public static int insere(String valor) {
        int i = hash(valor);
        int cont = 0;
        while (!dicionario[i].equals("")) {
            if (dicionario[i].equals(valor)) {
                return cont;//valor já existe na tabela
            }
            if (++cont == dicionario.length) {
                return cont;//tabela cheia
            }
            if (++i == dicionario.length) {
                i = 0;//tabela circular
            }
        }
        dicionario[i] = valor;
        return cont;
    }

    public static boolean contido(String s) {
        int i = hash(s);
        int cont = 0;
        while (!dicionario[i].equals(s)) {
            if (dicionario[i].equals("")) {//não achou s pois há uma posição vazia.
                return false;
            }
            if (++cont == dicionario.length) {//tabela cheia.
                return false;
            }
            if (++i == dicionario.length) {//tabela circular.
                i = 0;
            }
        }
        return true;

    }
}