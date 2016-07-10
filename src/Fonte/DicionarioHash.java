package Fonte;

public class DicionarioHash {

    static String[] dicionario;
    static int tamanhoTabela;

    public DicionarioHash(String caminho, int tamanhoTabela) {
        dicionario = new String[tamanhoTabela];
        dicionario = Auxiliares.RetornaHashPorArquivo(caminho, tamanhoTabela);
    }

    DicionarioHash(int tamanhoTabela) {
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
        int h = 0;
        for (int i = 0; i < s.length(); i++) {
            h = (31 * h + s.charAt(i)) % tamanhoTabela;
        }
        return h;
    }

    public static void insere(String valor) {
        int i = hash(valor);
        int cont = 0;
        while (!dicionario[i].equals("")) {
            if (dicionario[i] == valor) {
                return;//valor já existe na tabela
            }
            if (++cont == dicionario.length) {
                return;//tabela cheia
            }
            if (++i == dicionario.length) {
                i = 0;//tabela circular
            }
        }
        dicionario[i] = valor;
        return;
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
