package Fonte;

 /* Class Node */
 class RedBlackNode
 {    
     RedBlackNode left, right;
     String element;
     int color;
 
     /* Constructor */
     public RedBlackNode(String theElement)
     {
         this( theElement, null, null );
     } 
     /* Constructor */
     public RedBlackNode(String theElement, RedBlackNode lt, RedBlackNode rt)
     {
         left = lt;
         right = rt;
         element = theElement;
         color = 1;
     }    
 }
 
 /* Class RBTree */
 public class RBTree
 {
     private RedBlackNode current;
     private RedBlackNode parent;
     private RedBlackNode grand;
     private RedBlackNode great;
     private RedBlackNode header;    
     private static RedBlackNode nullNode;
     /* static initializer for nullNode */
     static 
     {
         nullNode = new RedBlackNode("-1");
         nullNode.left = nullNode;
         nullNode.right = nullNode;
     }
     /* Black - 1  RED - 0 */
     static final int BLACK = 1;    
     static final int RED   = 0;
 
     /* Constructor */ 
     
     public RBTree(String negInf)
     {
         header = new RedBlackNode(negInf);
         header.left = nullNode;
         header.right = nullNode;
     }

    RBTree() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     /* Function to check if tree is empty */
     public boolean isEmpty()
     {
         return header.right == nullNode;
     }
     /* Make the tree logically empty */
     public void makeEmpty()
     {
         header.right = nullNode;
     }
     /* Function to insert item */
     public void insert(String item )
     {
         current = parent = grand = header;
         nullNode.element = item;
         while (current.element != item)
         {            
             great = grand; 
             grand = parent; 
             parent = current;
             current = item.compareTo(current.element) < 0 ? current.left : current.right;
             // Check if two red children and fix if so            
             if (current.left.color == RED && current.right.color == RED)
                 handleReorient( item );
         }
         // Insertion fails if already present
         if (current != nullNode)
             return;
         current = new RedBlackNode(item, nullNode, nullNode);
         // Attach to parent
         if (item.compareTo(parent.element) < 0)
             parent.left = current;
         else
             parent.right = current;        
         handleReorient( item );
     }
     private void handleReorient(String item)
     {
         // Do the color flip
         current.color = RED;
         current.left.color = BLACK;
         current.right.color = BLACK;
 
         if (parent.color == RED)   
         {
             // Have to rotate
             grand.color = RED;
             if (item.compareTo(grand.element) < 0 != item.compareTo(parent.element) < 0 )
                 parent = rotate( item, grand );  // Start dbl rotate
             current = rotate(item, great );
             current.color = BLACK;
         }
         // Make root black
         header.right.color = BLACK; 
     }      
     private RedBlackNode rotate(String item, RedBlackNode parent)
     {
         if(item.compareTo(parent.element) < 0)
             return parent.left = item.compareTo(parent.left.element) < 0 ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left) ;  
         else
             return parent.right = item.compareTo(parent.right.element) < 0 ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);  
     }
     /* Rotate binary tree node with left child */
     private RedBlackNode rotateWithLeftChild(RedBlackNode k2)
     {
         RedBlackNode k1 = k2.left;
         k2.left = k1.right;
         k1.right = k2;
         return k1;
     }
     /* Rotate binary tree node with right child */
     private RedBlackNode rotateWithRightChild(RedBlackNode k1)
     {
         RedBlackNode k2 = k1.right;
         k1.right = k2.left;
         k2.left = k1;
         return k2;
     }
     /* Functions to count number of nodes */
     public int countNodes()
     {
         return countNodes(header.right);
     }
     private int countNodes(RedBlackNode r)
     {
         if (r == nullNode)
             return 0;
         else
         {
             int l = 1;
             l += countNodes(r.left);
             l += countNodes(r.right);
             return l;
         }
     }
     /* Functions to search for an element */
     public boolean search(String val)
     {
         return search(header.right, val);
     }
     private boolean search(RedBlackNode r, String val)
     {
         boolean found = false;
         while ((r != nullNode) && !found)
         {
             String rval = r.element;
             if (val.compareTo(rval) < 0 )
                 r = r.left;
             else if (val.compareTo(rval) > 0)
                 r = r.right;
             else
             {
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;
     }
     /* Function for inorder traversal */ 
     public void inorder()
     {
         inorder(header.right);
     }
     private void inorder(RedBlackNode r)
     {
         if (r != nullNode)
         {
             inorder(r.left);
             char c = 'B';
             if (r.color == 0)
                 c = 'R';
             System.out.print(r.element +""+c+" ");
             inorder(r.right);
         }
     }
     /* Function for preorder traversal */
     public void preorder()
     {
         preorder(header.right);
     }
     private void preorder(RedBlackNode r)
     {
         if (r != nullNode)
         {
             char c = 'B';
             if (r.color == 0)
                 c = 'R';
             System.out.print(r.element +""+c+" ");
             preorder(r.left);             
             preorder(r.right);
         }
     }
     /* Function for postorder traversal */
     public void postorder()
     {
         postorder(header.right);
     }
     private void postorder(RedBlackNode r)
     {
         if (r != nullNode)
         {
             postorder(r.left);             
             postorder(r.right);
             char c = 'B';
             if (r.color == 0)
                 c = 'R';
             System.out.print(r.element +""+c+" ");
         }
     }     
 }
 
 