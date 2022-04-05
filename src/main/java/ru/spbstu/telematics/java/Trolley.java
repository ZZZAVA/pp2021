package ru.spbstu.telematics.java;

import java.util.ArrayList;
import java.util.Random;

public class Trolley implements Runnable {
    private final Controller controller;
    private ArrayList<Person> peopleInTrolley;
    private int trolleySize = 10;

    Trolley(Controller controller) {
        this.controller = controller;
        peopleInTrolley = new ArrayList<>();
    }

    public int getTrolleySize() {
        return trolleySize;
    }

    public void rideTrolley() {
        try {
            System.out.println("\n _______ATTENTION_______"+"\n"+"All people in trolley " + peopleInTrolley+"\n========================\n");
            Thread.sleep(1000 + new Random().nextInt(1000));
            System.out.println("Trolley arrived............");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void freeTrolley() {
        peopleInTrolley.clear();
    }

    public void addPeopleInTrolley() {
        for (int i = 0; i < trolleySize; i++) {
            System.out.println("Waiting for next person");
            peopleInTrolley.add(controller.letInCart());
            System.out.println("----Next person entered trolley" + "\n" + "Curent = "+peopleInTrolley);
        }
    }

    @Override
    public void run() {
        while (true) {
            addPeopleInTrolley();
            rideTrolley();
            freeTrolley();
            // System.out.println("hi"); //Отладка на завершение поездки
        }
    }
}