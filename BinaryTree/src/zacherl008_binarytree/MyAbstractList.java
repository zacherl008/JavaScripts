/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zacherl008_binarytree;

import java.util.Iterator;

/**
 *
 * @author zacherl008
 */ 
public abstract class MyAbstractList<E> implements MyList<E>{
    protected int size = 0; //size of the list
    
    protected MyAbstractList(){
    
    }
    
    protected MyAbstractList(E[] objects){
        for (int i = 0; i < objects.length; i++){
            add(objects[i]);
            //calls add function and adds each element to the end of the list
        }    
    }
    
    @Override
    public boolean remove(E e) {
        if(indexOf(e) >= 0){
            remove(indexOf(e));
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void add(E e) {
        add(size, e);    
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    
}
