package ru.spbstu.telematics.java;

public class Calc{

	String Result(int value){
		String str = new String();
		str = "";
		double maxMultiplier = Math.sqrt(value);
		int multiplier = 2;
		while (value > 1 && multiplier <= maxMultiplier){
			if (value % multiplier == 0){
			str = str+ multiplier+" ";
			//System.out.print(multiplier + " ");
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
		str = str+value+" ";
		//System.out.print(value);
		}
		return str.trim();
		//System.out.println(str.trim());
	}
}
