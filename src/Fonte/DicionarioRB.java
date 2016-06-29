
package Fonte;

public class DicionarioRB {
    
    private RBTree Arvore;
 
     DicionarioRB(){ Arvore = new RBTree(); }
    
     DicionarioRB(String caminho){
        Arvore = Auxiliares.RetornaArvoreVPPorArquivo(caminho);
    }
    
     public RBTree getDicionarioRB(){
         return this.Arvore;
     }
    
}
