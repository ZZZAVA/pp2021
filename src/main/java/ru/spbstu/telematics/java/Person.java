package ru.spbstu.telematics.java;

public class Person {
    private String number;

    Person(String num){
        number=num;
    }

    @Override
    public String toString() {
        return "Pos: " + number;
    }
}