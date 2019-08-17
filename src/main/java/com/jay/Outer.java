package com.jay;

import com.jay.InnerClassDemo.Inner;

class InnerClassDemo {
	
		 int outer_x = 100;
		 static String s = "";
		 void test() {
			 Inner inner = new Inner();
			 inner.display();
		 }
		 // this is an inner class
		static class Inner {
		 void display() {
			 System.out.println("display: outer_x = " + s);
		 }
	 }
}
public class Outer {
	 public static void main(String args[]) {
		 InnerClassDemo outer = new InnerClassDemo();
		 System.out.println();
		 
	 outer.test();
	 }
	 
}
