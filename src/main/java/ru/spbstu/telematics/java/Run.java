package ru.spbstu.telematics.java;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class Run {
    public static void main( String[] args ) {
        MyLinkedHashMap<String, String>lhm=new MyLinkedHashMap<String, String>() ;
        lhm.add("1", "a");
        lhm.add("2","b");
        lhm.add("3", "c");
        Iterator<MyLinkedHashMap.MyNode<String,String>> iter=lhm.iterator();
        while(iter.hasNext())
        {
            System.out.printf(iter.next().toString()+"\n");
        }
        System.out.println("----------------");
        lhm.add("1", "d");
        lhm.add("3", "e");
        lhm.removeNode("3");
        lhm.add("4","f");
        iter=lhm.iterator();
        while(iter.hasNext())
        {
            System.out.printf(iter.next().toString()+" \n"); //CHECK
        }
        System.out.println("----------------");
        System.out.print(lhm.size());
        lhm.clear();

        System.out.print('\n');
        iter=lhm.iterator();
        System.out.print(lhm.size());
        while(iter.hasNext()) {
            System.out.printf(iter.next().toString());
        }

    }
}


