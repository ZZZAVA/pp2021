package ru.spbstu.telematics.java;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.junit.Assert.*;
/**
 * Unit test for simple App.
 */
public class AppTest{

	@org.junit.Test
		public void Result(){
		Calc calc = new Calc();
		String actual = calc.Result(1004);
		String exp = "2 2 251";
		//assertTrue(exp.equals(actual));
		assertEquals(exp, actual);
		
		System.out.println("1004\n"+actual+"\n");
		//return "";
	}
	
	@org.junit.Test
		public void Result1(){
		Calc calc = new Calc();
		String actual = calc.Result(256);
		String exp = "2 2 2 2 2 2 2 2";
		//assertTrue(exp.equals(actual));
		assertEquals(exp, actual);
		System.out.println("256\n"+actual+"\n");
	}
	
	@org.junit.Test
		public void Result2(){
		Calc calc = new Calc();
		String actual = calc.Result(17);
		String exp = "17";
		//assertTrue(exp.equals(actual));
		assertEquals(exp, actual);
		System.out.println("17\n"+actual+"\n");
	}
	
	@org.junit.Test
		public void Result3(){
		Calc calc = new Calc();
		String actual = calc.Result(501);
		String exp = "3 167";
		//assertTrue(exp.equals(actual));
		assertEquals(exp, actual);
		System.out.println("501\n"+actual+"\n");
	}
	
	@org.junit.Test
		public void Result4(){
		Calc calc = new Calc();
		String actual = calc.Result(819);
		String exp = "3 3 7 13";
		//assertTrue(exp.equals(actual));
		assertEquals(exp, actual);
		System.out.println("819\n"+actual+"\n");
	}
    
}
