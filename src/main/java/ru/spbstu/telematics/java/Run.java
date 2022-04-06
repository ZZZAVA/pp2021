package ru.spbstu.telematics.java;


import java.util.Scanner;

public class Run{

	public static void main( String[] args ){
		Scanner sc= new Scanner(System.in);
		int value = sc.nextInt();
		while (value<0){
			System.out.println("Negative value, try again:");
			value = sc.nextInt();
		}
		//Calc calc = new Calc();
		//calc.Result(value);
}


}

