
package Fonte;

public class DicionarioABB {
    
    private BinaryTree Arvore;
 
     DicionarioABB(){ Arvore = new BinaryTree(); }
    
     DicionarioABB(String caminho){
        Arvore = Auxiliares.RetornaArvorePorArquivo(caminho);
    }
    
}
