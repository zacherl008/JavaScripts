/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zacherl008_hashmapexample;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author kzacherl
 */
public interface MyMap<K, V>{

    public int size();

    public boolean isEmpty();

    public boolean containsKey(K key);
    
    public boolean containsValue(V value);

    public V get(K key);

    public V put(K key, V value);

    public void remove(K key);

    public void putAll(MyMap<? extends K, ? extends V> map);

    public void clear();

    public java.util.Set<K> keySet();

    public java.util.Set<V> values();

    public java.util.Set<Entry<K, V>> entrySet();
    
    public static class Entry<K, V>{
        K key;
        V value;
        
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
        
        public K getKey(){
            return key;
        }
        
        public V getValue(){
            return value;
        }
        
        @Override
        public String toString(){
            return "[" + key + ", " + value + "]";
        }
    }
}
