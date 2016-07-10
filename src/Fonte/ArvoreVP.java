package Fonte;

import java.util.NoSuchElementException;

public class ArvoreVP {

    private static final boolean Vermelho = true;
    private static final boolean Preto = false;

    private No raiz;// Raiz da Arvore

    // Classe Nó da Arvore
    private class No {

        private String chave;        // chave
        private No esq, dir;         // Filho Esquerdo e Direito
        private boolean cor;         // cor, vermelho ou preto.
        private int tamanho;         // quantidade de subarvores.

        public No(String chave, boolean cor, int tamanho) {
            this.chave = chave;
            this.cor = cor;
            this.tamanho = tamanho;
        }
    }

   //Construtor vazio
    public ArvoreVP() {
    }
    
    // Retorna Nó Vermelho ou não, todo nó folha (null) é preto.
    private boolean vermelho(No x) {
        if (x == null) {
            return false;
        }
        return x.cor == Vermelho;
    }

    // Numero de Nós na subArvore de X.
    private int tamanho(No x) {
        if (x == null) {
            return 0;
        }
        return x.tamanho;
    }

    // Método publico retorna tamanho da Raiz.
    public int tamanho() {
        return tamanho(raiz);
    }

   // Retorna se arvore está vazia.
    public boolean vazia() {
        return raiz == null;
    }

    // Metedo publico Retorna chave buscada, caso exista.
    public String busca(String chave) {
        if (chave == null) {
            throw new NullPointerException("argument to get() is null");
        }
        return busca(raiz, chave);
    }

    // Metodo privado, retorna chave buscada, caso exista. 
    private String busca(No x, String chave) {
        while (x != null) {
            int cmp = chave.trim().compareToIgnoreCase(x.chave.trim());
            if (cmp < 0) {
                x = x.esq;
            } else if (cmp > 0) {
                x = x.dir;
            } else {
                return x.chave;
            }
        }
        return null;
    }

    // Método publico boleano, retorna se a chave está contida na arvore ou não.
    public boolean contido(String chave) {
        return busca(chave) != null;
    }

    // Insere nó na Arvore.
    public void insere(String chave) {
        if (chave == null) {
            throw new NullPointerException("first argument to put() is null");
        }
        raiz = insere(raiz, chave);
        raiz.cor = Preto;
        // assert check();
    }

    // Metodo Privado insere nó na Arvore.
    private No insere(No h, String chave) {
        if (h == null) {
            return new No(chave.trim() , Vermelho, 1);
        }

        int cmp = chave.trim().compareToIgnoreCase(h.chave.trim());
        if (cmp < 0) {
            h.esq = insere(h.esq, chave);
        } else if (cmp > 0) {
            h.dir = insere(h.dir, chave);
        } else {
            h.chave = chave;
        }

        // fix-up any right-leaning links
        if (vermelho(h.dir) && !vermelho(h.esq)) {
            h = rotacaoEsquerda(h);
        }
        if (vermelho(h.esq) && vermelho(h.esq.esq)) {
            h = rotacaoDireita(h);
        }
        if (vermelho(h.esq) && vermelho(h.dir)) {
            trocaCores(h);
        }
        h.tamanho = tamanho(h.esq) + tamanho(h.dir) + 1;

        return h;
    }
    
    //Rotação Direita
    private No rotacaoDireita(No h) {
        // assert (h != null) && isRed(h.left);
        No x = h.esq;
        h.esq = x.dir;
        x.dir = h;
        x.cor = x.dir.cor;
        x.dir.cor = Vermelho;
        x.tamanho = h.tamanho;
        h.tamanho = tamanho(h.esq) + tamanho(h.dir) + 1;
        return x;
    }

    // Rotação Esquerda
    private No rotacaoEsquerda(No h) {
        // assert (h != null) && isRed(h.right);
        No x = h.dir;
        h.dir = x.esq;
        x.esq = h;
        x.cor = x.esq.cor;
        x.esq.cor = Vermelho;
        x.tamanho = h.tamanho;
        h.tamanho = tamanho(h.esq) + tamanho(h.dir) + 1;
        return x;
    }

    // troca de cores dos nós para manter a propriedade VP.
    private void trocaCores(No h) {
        h.cor = !h.cor;
        h.esq.cor = !h.esq.cor;
        h.dir.cor = !h.dir.cor;
    }

}
