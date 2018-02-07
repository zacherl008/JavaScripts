/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zacherl008_linkedlist;

/**
 *
 * @author zacherl008
 */
public interface MyList<E> extends java.lang.Iterable {
    
    //make a data structure hierarchy, 3 main interfaces, list interface with all commands, 
    //map interface, set interface, list different data structures that fit into each
    //list any extra function thats extended with, stack has 2 extension functions: push and pop
    //example of where each data type would be used, vector, deck, dq
    //stack used for last in first out, 
    //queue used for first in first out, a line of things trying to access program
    
    public void add(E e); //adds a new element at the end of the list
    
    public void add (int index, E e); //adds element at specified index
    
    public void clear(); //clear the list
    
    public boolean contains(E e); 
    //returns true if the list contains element e
    
    public E get (int index); //returns the elements of index: index
    //returns the index of the first matching element and returns -1 if not match
    
    public int indexOf(E e); //returns the first matching element adn -1 if no match
    
    public boolean isEmpty(); //returns true if list contains no elements
    
    public int lastIndexOf(E e); //returns the index of the last matching element and returns -1 if no match
    
    public boolean remove (E e);
    //removes the first occurence of the element e in the list
    //shifts shifts any subsequence elemtn to th left
    //returns true if the element that is removed
    
    //removes the occurence of the element e in the list at index: index
    //shifts any subsequent elemeents to the left
    //returns the element that was removed
    public E remove(int index);
    
    public Object set(int index, E e); //replace the element at the specified index with given element
  
    public int size(); //returns the number of elements in the list
        
   
}
