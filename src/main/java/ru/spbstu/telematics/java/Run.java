package ru.spbstu.telematics.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Run {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Trolley trolley = new Trolley(controller);
        Pass p1 = new Pass(controller,"f",300); //first, check comment to maxNumber
        Pass p2 = new Pass(controller,"s",900); //second, check comment to maxNumber
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(p1);
        executorService.submit(p2);
        executorService.submit(trolley);
    }
}