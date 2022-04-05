package ru.spbstu.telematics.java;

import java.util.Random;

public class Pass implements Runnable {

    private final Controller controller;
    private String numOfPass;
    private int number = 0;
    private int maxNumberOfPeople;

    public Pass(Controller controller, String pass, int maxNumber) {
        this.controller = controller;
        numOfPass = pass;
        maxNumberOfPeople = maxNumber; // used to regulate the number of people waiting for a pass
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < maxNumberOfPeople; i++) {
            try {
                System.out.println("Pass is waiting");
                Thread.sleep(random.nextInt(1000));
                System.out.println("Pass not waiting");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String fullNumber = number + numOfPass;
            Person person = new Person(fullNumber);
            number++;
            System.out.println("New person entered PASS");
            controller.addIntoQueue(person);
            System.out.println("New person entered the QUEUE");

        }
    }
}