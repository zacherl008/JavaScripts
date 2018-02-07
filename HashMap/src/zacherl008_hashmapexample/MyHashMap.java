/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zacherl008_hashmapexample;

import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author kzacherl
 */
public class MyHashMap<K, V> implements MyMap<K, V>{
    
    //Define a default hashtable size, must be a power of 2 
    private static int DEFAULT_INITIAL_CAPACITY = 4;
    
    //Define maximum hashtable size. 1 << 30 (one with bitwise operator moving 30 spots) is the same as 2^30
    private static int MAXIMUM_CAPACITY = 1 << 30;
    
    //Current hashtable capacity. capacity must be a power of 2
    private int capacity;
    
    //Define a load factor. How big of an array list it is allowed to grow
    private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;
    
    //specify load factor used in the hash table
    private float loadFactorThreshold;
    
    //current size of hash table, number of entries in map
    private int size = 0;

    //hashtable is an array with each cell being a linked list of entries
    //array of linked list of map entries
    LinkedList<MyMap.Entry<K,V>>[] table;
    
    public MyHashMap(){
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }
    
    public MyHashMap(int initialCapacity){
        this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
    }
    
    public MyHashMap(int initialCapacity, float loadFactorThreshold){
        if(initialCapacity > MAXIMUM_CAPACITY){
            this.capacity = MAXIMUM_CAPACITY;
        }
        else{
            this.capacity = trimToPowerOf2(initialCapacity);
        }
        this.loadFactorThreshold = loadFactorThreshold;
        table = new LinkedList[capacity];
    }
    
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        //return true if size = 0
        return size == 0;
    }

    @Override
    public boolean containsKey(K key) {
        if(get(key) != null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean containsValue(V value) {
        for(int i = 0; i < capacity; i++){
            if(table[i] != null){
                LinkedList<MyMap.Entry<K, V>> bucket = table[i];
                for(MyMap.Entry<K, V> entry : bucket){
                    if(entry.value.equals(value)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V put(K key, V value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(K key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(MyMap<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        size = 0;
        removeEntries();
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<V> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int trimToPowerOf2(int initialCapacity) {
        int capacity = 1;
        while(capacity < initialCapacity)
            capacity <<= 1; //same as capacity *= 2, raising it to an extra power

        return capacity;
    }

    private void removeEntries() {
        for(int i = 0; i < capacity; i++){
            //table[i] refers to the linked list
            if(table[i] != null){
                table[i].clear();
            }
        }
    }
    
}
