/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zacherl008_binarytree;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author kzacherl
 *///
//deleting something requires to delete and move everything below it
//1) save reference to node to be deleted
//2) set it to null
//3) find left and right of the node to be deleted and call add function on them 
//
public class BinaryTree<E> extends MyAbstractList<E> {
    private Node root = null;
    public BinaryTree(){
        root = null;
    }
    
    public boolean isEmpty(){
        return root == null;
    }

    @Override
    public boolean contains(E data) {
        return contains(root, data);
    }
    
    private boolean contains(Node root, E data){
        if (root == null){
            return false;
        }
        else if(((Comparable)(data)).compareTo(((Comparable)(root.data))) < 0){
            return contains(root.left, data);
        }
        else if(((Comparable)(data)).compareTo(((Comparable)(root.data))) > 0){
            return contains(root.right, data);
        }
        else{
            return true;
        }
    }
    
    public Node find(int value){
        return find(root, value);
    }
    
    private Node find(Node root, int data){
        if(root == null || root.data == data){
            return root;
        }
        if(root.getData() > data){
            return find(root.left, data);
        }
        return find(root.right, data);
    }

    public int getBreadth(int b, Node node){
        int leftBreadth = 0;
        int rightBreadth = 0;
    
        if (node.left == null){
            if(b < leftBreadth){
               leftBreadth = b;
            }
        }
        else{
            b--;
            getBreadth(b, node.left);
        }
            
        if(node.right == null){
            if(b > rightBreadth){
                rightBreadth =  b;
            }
        }
        else{
            b++;
            getBreadth(b,node.right);
        }
        return b;
    }
  
    //increment down when going left and up when going right
    //lookLeft, if there is something there, look left again
    //if nothing, set leftbreadth = b, then look right and repeat
    //look right, if something look right again, if nothing set rightbreadth = b
    
    public void insert(int data){
        if(root == null){
           root = new Node(data); 
        }else{
           insert(root, data); 
        }
        
    }

    private Node insert(Node node, int data){
        if (node == null){
            node = new Node(data);
            return node;
        }
        else{
            if(data < node.data){
                if(node.left==null){
                   node.left = new Node(data);
                   return node.left;
                }else{
                   insert(node.left, data); 
                }
                
            }
            else if(data > node. data){
                if(node.right==null){
                    node.right = new Node(data);
                    return node.right;
                }else{
                    insert(node.right, data);
                }
                
            }
        }
        return node;
    }
    
    public void clear(){
        clear(root);
    }
    
    private void clear(Node node){
        node = null;
    }
    
    //root, left, right
    public void preOrder(){
        preOrder(root);
    }
    
    private void preOrder(Node node){
        if(node != null){
            System.out.print(node.data + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
    
    //left, root, right
    public void inOrder(){
        inOrder(root);
    }
    
    private void inOrder(Node node){
        if(node!= null){
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }
    
    // left, right, root
    public void postOrder(){
        postOrder(root);
    }
    
    private void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
    
    //Binary Tree Printer
    public void printTree(){
        System.out.print("maxLevel: " + getMaxLevel(root));
        
        int maxLevel = getMaxLevel(root);
        ArrayList<BinaryTree.Node<E>> nodes = new ArrayList();
        nodes.add(root);
        printLevel(nodes, 1, maxLevel);
    }
    
    private void printLevel(ArrayList<BinaryTree.Node<E>> nodes, int level, int maxLevel){
        if(nodes.isEmpty() || levelIsEmpty(nodes)){
            return;
        }
        
        int floor = maxLevel - level;
        int lines = (int)Math.pow(2, (Math.max(floor -1, 0)));
        int leadingSpaces = (int)Math.pow(2, floor) -1;
        int intervalSpaces = (int)Math.pow(2, (floor+1)) -1;
        
        String levelStr = getWhiteSpace(leadingSpaces);
        
        ArrayList<BinaryTree.Node<E>> nextLevel = new ArrayList<>();
        
        for(BinaryTree.Node<E> node : nodes){
            if(node != null){
                levelStr += node.data;
                nextLevel.add(node.left);
                nextLevel.add(node.right);
            }else{
                levelStr += " ";
                nextLevel.add(null);
                nextLevel.add(null);
            }
            
            levelStr += getWhiteSpace(intervalSpaces);
        }
        System.out.print(levelStr);
        System.out.print("\n");
        
        for(int i = 1; i <= lines; i++){
            for(int j = 0; j < nodes.size(); j++){
                levelStr = getWhiteSpace(leadingSpaces-i);
                BinaryTree.Node<E> parent = nodes.get(j);
                if(parent == null){
                    levelStr += getWhiteSpace((2*lines) + i + 1);
                    System.out.print(levelStr);
                    continue;
                }
                
                if(parent.left != null){
                    levelStr += "/";
                }else{
                    levelStr += getWhiteSpace(1);
                }
                
                levelStr += getWhiteSpace(i + i - 1);
                
                if(parent.right != null){
                    levelStr += "\\";
                }else{
                    levelStr += getWhiteSpace(1);
                }
                    levelStr += getWhiteSpace((2*lines) - i);
                    System.out.print(levelStr);
            }
            System.out.print("\n");
        }
        printLevel(nextLevel, level+1, maxLevel);
    }
    
    private String getWhiteSpace(int count){
        String spaces = "";
        for(int i = 0; i < count; i++){
            spaces += " ";
        }
        return spaces;
    }
    
    private int getMaxLevel(BinaryTree.Node<E> currentNode){
        
        if(currentNode == null){
            return 0;
        }
        return Math.max(getMaxLevel(currentNode.left), getMaxLevel(currentNode.right))+1;
    }
    
    private boolean levelIsEmpty(ArrayList<BinaryTree.Node<E>> nodes){
        for(int i = 0; i < nodes.size(); i++){
            if(nodes.get(i)!=null){
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int size(){
        return size(root);
    }
    
    private int size(Node node){
        if(node == null){
            return 0;
        }
        else{
            return(size(node.left) + 1 + size(node.right));
        }
            
    }       

    @Override
    public E get(int index) {
        //not used
        return null;
    }

    @Override
    public int indexOf(E e) {
        //not used
        return 0;
    }

    @Override
    public int lastIndexOf(E e) {
        //not used
        return 0;
    }

    @Override
    public E remove(int index) {
        //not used
        return null;
    }

    @Override
    public Iterator iterator() {
        //not used
        return null;
    }

    @Override
    public Object set(int index, E e) {
        //not used
        return null;
    }

    @Override
    public void add(int index, E e) {
        //not needed
    }

    static class Node<E>{
        private int data;
        private Node left, right;
        
        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }

        public int getData(){
            return data;
        }
        
        public void setData(int data){
            this.data = data;
        }
        
        public Node getLeft(){
            return left;
        }
        
        public void setLeft(Node left){
            this.left = left;
        }
        
        public Node getRight(){
            return right;
        }
        
        public void setRight(Node right){
            this.right = right;
        }
    }    
    
}
