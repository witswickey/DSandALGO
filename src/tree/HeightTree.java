package tree;

public class HeightTree {
	/* Driver program to test above functions */
    public static void main(String[] args)  
    { 
        BinaryTree tree = new BinaryTree(); 
   
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
   
        System.out.println("Height of tree is : " +  
                                      tree.maxDepth(tree.root));
        System.out.println("Height of tree is by recur : " +  
                tree.heigth(tree.root));
        System.out.println("Diameter of tree is : " +  
                tree.getdiameter(tree.root));
    } 
}
