/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zacherl008_linkedlist;

import java.util.Iterator;

/**
 *
 * @author kzacherl
 */
public class MyLinkedList<E> extends MyAbstractList<E>{ 
    
    private Node <E> head;
    private Node <E> tail;
    
    public MyLinkedList(){}
    
    public MyLinkedList(E[] elements){
        super(elements);
    }
    
    public E getFirst(){
        if(size == 0){
            return null;
        }
        else{
            return head.element;
        }
    }
    
    @Override
    public void add(int index, E e) {
        //if list is empty
        if(size == 0){
            addFirst(e);
        }
        else if(index >= size){
            addLast(e);
        }
        else{
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++){
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<E>(e);
            (current.next).next = temp;
            size ++;
        }
    }
    public void clear() {
        head = null; 
        tail = null;
        size = 0;
    }

    @Override
    public boolean remove(E e){
        Node <E> temp = head;
        if (temp.element.equals(e)){
            head = temp.next;
            size --;
            return true;
        }
      
        while (temp.next != null){
            if(temp.next.element.equals(e)){
                temp.next = temp.next.next;
                size --;
                return true;
            }    
            temp = temp.next;
        } 
        return false;
    }
   
    @Override
    public boolean contains(E e) {
        Node <E> temp = head;
        for(int i = 0; i < size; i++){
            if(temp.element.equals(e)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index > size || index < 0){
            return null;
        }
        Node <E> temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp.element;
    }

    @Override
    public int indexOf(E e) {
        Node <E> temp = head;
        for(int i = 0; i < size; i++){
            if(temp.element.equals(e)){
               return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        Node <E> temp = head;
        int lastMatching = -1;
        for(int i = 0; i < size; i++){
            if(temp.element.equals(e)){
               lastMatching = i;
            }
            temp = temp.next;
        }
        if(lastMatching == -1){
            return -1;
        }
        return lastMatching;
    }

    @Override
    public E remove(int index) {
        if(isEmpty()){
            return null;
        }
        else if (index < 0 || index > size - 1){
            return null;
        }
        Node <E> temp = head;
        E dataToRemove;
        if(index == 0){
            dataToRemove = temp.element;
            head = temp.next;
        }
        else{
            for (int i = 0; i < index - 1 ; i++){
                temp = temp.next;
            }
            dataToRemove = temp.element;
            temp.next = (temp.next).next;        
            
        }
        size --;
        return dataToRemove;
    }

    @Override
    public Object set(int index, E e) {
        if(isEmpty()){
            return null;
        }
        if (index > size || index < 0){
            return null;
        }
        Node <E> temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        temp.element = e;
        return temp.element;
    }

    private void addFirst(E e) {
        if(size == 0){
            head = new Node<E>(e);
            tail = head;
        }else{
            Node <E> temp = head;
            head = new Node<E>(e);
            head.next = temp;   
        }
        size ++;
    }

    private void addLast(E e) {
        tail.next = new Node<E>(e);
        tail = tail.next;
        size ++;
    }
    
    public java.util.Iterator<E> iterator(){
        return new MyLinkedListIterator();
    }
    private class MyLinkedListIterator implements Iterator<E>{         
        private Node<E> current = head; //current index
        
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E element = current.element;
            current = current.next;
            return element;
        }
        
        @Override
        public void remove(){
            //taking next from next and removing reference to previous node
            //using a reference for its next and then getting rid of the previous reference
            current.next = (current.next).next;
        }
    
    }
    
    //This class is only for MyLinkedList
    //This class doesn't need to access members/attributes of MyLinkedList so it is static
    private static class Node <E>{
        public E element;
        public Node <E> next;

        public Node(E element){
            this.element = element;
        }
    }    
    
    //remove this in final version 
    public void printList(){
        Node <E> current = head;
        for(int i = 0; i < size; i++){
            h.ps("The element at node " + i + " ");
            h.ps("is " + current.element + "| ");
            current = current.next;
        }
        h.pl("");
    }
}
