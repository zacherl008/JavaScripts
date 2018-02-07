/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zacherl008_linkedlist;

/**
 *
 * @author kzacherl
 */
public class Zacherl008_LinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList();
        list.add("sticky");
        list.add("picky");
        list.add("3ew23");
        list.add("32423423532");
        list.add("adsad");
        list.add("sticky");
        list.printList();
        //list.set(5, "fdasf");
        //list.remove(4);
        //h.pl(list.lastIndexOf("stcky"));
        //h.pl(list.indexOf("ayusad"));
        //list.get(423);
        //h.pl(list.contains("stiky"));
        //list.remove("sticky");
        //list.add(3, "wm");
        //list.clear();
        list.printList();
        //h.pl(list.getFirst());
    }
    
}
