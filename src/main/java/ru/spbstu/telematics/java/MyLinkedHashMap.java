package ru.spbstu.telematics.java;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedHashMap<K, V> {
    static public class MyNode<K, V> {
        final int hash;
        final K key;
        V value;
        MyNode<K, V> next;
        MyNode<K, V> before;
        MyNode<K, V> after;

        MyNode(int hash, K key, V val, MyNode<K, V> next) {
            this.hash = hash;
            this.key = key;
            value = val;
            this.next = next;
            before = null;
            after = null;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }
    }

    int size;
    static int capacity = 16;
    MyNode<K, V> table[];
    MyNode<K, V> head;
    MyNode<K, V> tail;

    @SuppressWarnings("unchecked") // 消除警告
    MyLinkedHashMap() {
        table = (MyNode<K, V>[]) new MyNode[capacity];
        head = null;
        tail = null;
    }

    public void add(K key, V value) {
        addVal(hash(key), key, value);
    };

    public void addVal(int hash, K key, V value) {
        MyNode<K, V> newNode = new MyNode<K, V>(hash, key, value, null);
        MyNode<K, V> lin = table[(capacity - 1) & hash];
        if (lin == null)
            table[(capacity - 1) & hash] = newNode;
        else {
            if (lin.key == key) {
                lin.value = value;
                afterNodeAccess(lin);
                return;
            } else {
                while (lin.next != null) {
                    lin = lin.next;
                    if (lin.key == key) {
                        lin.value = value;
                        afterNodeAccess(lin);
                        return;
                    }
                }
            }

        }
        if (lin != null) {
            lin.next = newNode;
        }
        size++;
        afterNodeInsertion(newNode);
    }

    public int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public void removeNode(K key) {
        int h = hash(key);
        MyNode<K, V> lin = table[(capacity - 1) & h];
        if (lin == null)
            return;
        else {
            if (lin.key == key) {
                table[(capacity - 1) & h] = lin.next;
                size--;
                afterNodeRemoval(lin);
                return;
            } else {
                while (lin.next != null) {
                    if (lin.next.key == key) {
                        lin.next = lin.next.next;
                        size--;
                        afterNodeRemoval(lin.next);
                    }
                }
            }
        }
    };

    public MyNode<K, V> get(K key) {
        int h = hash(key);
        MyNode<K, V> lin = table[(capacity - 1) & h];
        while (lin != null) {
            if (lin.key == key)
                break;
            lin = lin.next;
        }
        return lin;
    };

    public int size() {
        return size;
    };

    public boolean contains(K key) {
        MyNode<K, V> lin = get(key);
        return (lin == null) ? false : true;
    };

    public void clear() {
        if(size>0)
        {
            size = 0;
            for(int i=0;i<table.length;i++)
            {
                table[i]=null;
            }
            head=tail=null;
        }

    }

    void afterNodeAccess(MyNode<K, V> p) {
        if (p != tail) {
            MyNode<K, V> b = p.before, a = p.after;
            p.after = null;
            if (b == null)
                head = a;
            else
                b.after = a;

            a.before = b;
            tail.after = p;
            p.before = tail;
            tail = p;
        }
    };

    void afterNodeInsertion(MyNode<K, V> p) {
        if (tail == null) {
            head = tail = p;
        } else {
            tail.after = p;
            p.before = tail;
            tail = p;
        }
    };

    void afterNodeRemoval(MyNode<K, V> p) {
        MyNode<K, V> b = p.before, a = p.after;
        if (b != null)
            b.after = a;
        else
            head = a;
        if (a != null)
            a.before = b;
        else
            tail = b;
    };


    public class LinkedHashIterator implements Iterator<MyLinkedHashMap.MyNode<K, V>>
    {
        MyLinkedHashMap.MyNode<K, V> next;
        MyLinkedHashMap.MyNode<K, V> current;
        LinkedHashIterator() {
            next = head;
            current = null;
        }
        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public MyLinkedHashMap.MyNode<K, V> next() {

            MyLinkedHashMap.MyNode<K, V> e = next;
            if (e == null)
                throw new NoSuchElementException();
            current = e;
            next = e.after;
            return e;
        }
        public final void remove() {
            MyLinkedHashMap.MyNode<K, V>  p = current;
            if (p == null)
                throw new IllegalStateException();
            current = null;
            removeNode(p.key);
        }
    }
    public Iterator<MyLinkedHashMap.MyNode<K, V>> iterator() {
        return new LinkedHashIterator();
    }

}
