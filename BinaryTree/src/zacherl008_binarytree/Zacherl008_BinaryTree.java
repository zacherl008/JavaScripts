/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zacherl008_binarytree;

/**
 *
 * @author kzacherl
 */
public class Zacherl008_BinaryTree{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree myTree = new BinaryTree();
        
        myTree.insert(1);
        myTree.insert(5);
        myTree.insert(3);
        myTree.insert(2);
        myTree.insert(9);
        
        myTree.printTree();
        //myTree.inOrder();
        //System.out.println("");
        //myTree.preOrder();
        //System.out.println("");
        //myTree.postOrder();
        //System.out.println("");
        //System.out.println(myTree.size());
        System.out.println(myTree.contains(2));
    }
    
    
}
