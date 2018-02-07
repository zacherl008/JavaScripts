/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zacherl008_linkedlist;

import java.util.Iterator;

/**
 *
 * @author zacherl008
 */
public class MyArrayList<E> extends MyAbstractList<E> {

    public static final int INITIAL_CAPACITY = 16;
    private E[] data = (E[]) new Object[INITIAL_CAPACITY];
    
    public MyArrayList(){
        //default constructor
    }
    
    public MyArrayList(E[] objects){
        for(int i = 0; i < objects.length; i++){
            add(objects[i]); 
            //warning, do not use super objects
        }
    }
    
    @Override
    public void add(int index, E e) {
        ensureCapacity();
        
        for(int i = size - 1; i >= index; i--){
            data[i+1] = data[i];
            //going through array backwards
        }
        data[index] = e;
        size++;
    }

    @Override
    public void clear() {
        data = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean contains(E e) {
        for(int i = 0; i <size; i++){
            if(e.equals(data[i])){
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public int indexOf(E e) {
        for(int i = 0; i <size; i++){
            if(e.equals(data)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        for(int i = size - 1; i >= 0; i--){
            if(e.equals(data)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E e = data[index];
        //for loop from add function
        //move everything to left but going to right
        for(int i = index; i < size -1; i++){
            data[i] = data[i+1];
            //moving to left
        }
        data[size - 1] = null;
        size--;
        return e;
    }

    @Override
    public E set(int index, E e) {
        checkIndex(index);
        E old = data[index];
        //saving what is currently at data index
        data[index] = e;
        return old;
    }

    @Override //overrides iterator() defined in Iterable
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) result.append(", ");
        }
        return result.toString() + "]";
    }
    
     /** Trims the capacity to current size */
    public void trimToSize() {
        if (size != data.length) {
            E[] newData = (E[])(new Object[size]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        } // If size == capacity, no need to trim
    }
    
    private void ensureCapacity() {
        if(size >= data.length){
            //if this is true there is no room left in array
            E[] newData = (E[]) (new Object[size * 2 + 1]);
            System.arraycopy(data, 0, newData, 0, size);
            //object to copy, start from, to, start from
            data = newData;
            //change pointer from data to new data
        }
    }
    
    private void checkIndex(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException
                ("index " + index + " out of bounds");
        }
    } 

    private class ArrayListIterator implements java.util.Iterator<E> { 
        private int current = 0; // Current index 
        
        @Override
        public boolean hasNext() { 
            return (current < size);
        }
        
        @Override
        public E next() {
            return data[current++];
        }
        
        @Override
        public void remove() {
            MyArrayList.this.remove(current);
        }
    } 
    
}
