
package Fonte;

public class DicionarioRB {
    
    private ArvoreVP Arvore;
 
     DicionarioRB(){ Arvore = new ArvoreVP(); }
    
     DicionarioRB(String caminho){
        Arvore = Auxiliares.RetornaArvoreVPPorArquivo(caminho);
    }
    
     public ArvoreVP getDicionarioRB(){
         return this.Arvore;
     }
    
}
