
package Fonte;


public class Node {


    String valor;
    private Node noEsquerda;
    private Node noDireita;  

    public Node() { }

   public Node(String valor) {
        super();
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Node getNoEsquerda() {
        return noEsquerda;
    }

    public void setNoEsquerda(Node noEsquerda) {
        this.noEsquerda = noEsquerda;
    }

  public Node getNoDireita() {
        return noDireita;
    }

    public void setNoDireita(Node noDireita) {
        this.noDireita = noDireita;
    }

    @Override

    public String toString() {
        return "Node [valor=" + valor + "]";
    }    
}