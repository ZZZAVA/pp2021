package ru.spbstu.telematics.java;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestRun {
    @Test
    public void Run() {
        Controller controller = new Controller();
        Trolley trolley = new Trolley(controller);
        Pass p1 = new Pass(controller,"a",10);
        Pass p2 = new Pass(controller,"b",30);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(p1);
        executorService.submit(p2);
        executorService.submit(trolley);
    }
}