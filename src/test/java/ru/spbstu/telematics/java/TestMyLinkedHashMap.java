package ru.spbstu.telematics.java;

import java.util.Iterator;
import java.util.LinkedHashMap;

import org.junit.Assert;
import org.junit.Test;

import ru.spbstu.telematics.java.MyLinkedHashMap.MyNode;

public class TestMyLinkedHashMap
{
    MyLinkedHashMap<String,String> MyLHMap=new MyLinkedHashMap();
    LinkedHashMap<String,String> LHMap=new LinkedHashMap();
    @Test
    public void testadd()
    {
        MyLHMap.add("1", "1");
        MyLHMap.add("2", "2");
        MyLHMap.add("3", "3");
        LHMap.put("1","1");
        LHMap.put("2","2");
        LHMap.put("3","3");
    }
    @Test
    public void testsize()
    {
        MyLHMap.add("1", "1");
        MyLHMap.add("2", "2");
        MyLHMap.add("3", "3");

        LHMap.put("1","1");
        LHMap.put("3","3");
        LHMap.put("5","3");
        Assert.assertEquals(MyLHMap.size(), LHMap.size());
    }
    @Test
    public void testcontains()
    {
        MyLHMap.add("1", "1");
        LHMap.put("1","1");
        Assert.assertEquals(MyLHMap.contains("1"),LHMap.containsKey("1"));
        Assert.assertEquals(MyLHMap.contains("4"),LHMap.containsKey("4"));
    }
    @Test
    public void testget()
    {
        MyLHMap.add("1", "1");
        MyLHMap.add("2", "2");
        LHMap.put("1","1");
        LHMap.put("2","2");

        Assert.assertEquals(LHMap.get("1"),MyLHMap.get("1").getValue());
        Assert.assertEquals(LHMap.get("2"),MyLHMap.get("2").getValue());
    }
    @Test
    public void testIterator()
    {
        MyLHMap.add("1", "1");
        MyLHMap.add("2", "2");
        MyLHMap.add("3", "3");
        LHMap.put("1","1");
        LHMap.put("2","2");
        LHMap.put("3","3");
        Iterator<MyNode<String, String>>Myiter=MyLHMap.iterator();
        Iterator<?> iter = LHMap.entrySet().iterator();
        Assert.assertTrue(Myiter.hasNext());
        Assert.assertEquals(Myiter.next().toString(),iter.next().toString());
        Myiter.remove();
        iter.remove();
        Assert.assertEquals(MyLHMap.size(), LHMap.size());
    }

}