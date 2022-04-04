package ru.spbstu.telematics.java;


import java.util.Scanner;

public class Run 
{
    public static void main( String[] args )
    {
    Scanner sc= new Scanner(System.in);	
    int value = sc.nextInt();
    while (value<0){ 
    	System.out.println("Negative value, try again:");
    	value = sc.nextInt();
    }
	double maxMultiplier = Math.sqrt(value);
	int multiplier = 2;
	while (value > 1 && multiplier <= maxMultiplier){
		if (value % multiplier == 0){
			System.out.print(multiplier + " ");
			value /= multiplier;
		}
		else if (multiplier == 2){
			multiplier++;
		}
		else{
			multiplier += 2;
		}
		}
		if (value != 1){
			System.out.print(value);
		}
    }
}
