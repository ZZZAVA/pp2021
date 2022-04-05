package ru.spbstu.telematics.java;

import java.util.LinkedList;

public class Controller {
    private int maxPeopleInQueue = 3;
    private LinkedList<Person> peopleInQueue = new LinkedList<>();

    public synchronized void addIntoQueue(Person person) {
        while (peopleInQueue.size() == maxPeopleInQueue) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        peopleInQueue.add(person);
        notifyAll();

    }

    synchronized public Person letInCart() {
        Person firstPerson = null;


        while (peopleInQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        firstPerson = peopleInQueue.removeFirst();
        notifyAll();

        return firstPerson;
    }


}
