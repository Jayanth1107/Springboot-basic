package com.jay;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class RunnableLambda {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {

				for(int i= 0; i< 100; i++) {
					 System.out.println("Thread "+Thread.currentThread().getName()+" completed");
				}
				
			}
		};
		
		Thread t = new Thread(runnable);
		t.start();
		t.join();

		
		Runnable runnableLambda = () -> {
			for(int i= 0; i< 100; i++) {
				 System.out.println("Thread "+Thread.currentThread().getName()+" completed");
			}
		};
		
		Thread t2 = new Thread(runnableLambda);
		t2.start();
		t2.join();
		
		Comparator<String> comparator = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(),o2.length());
			}
		}; 
		
		List<String> list = Arrays.asList("*","**","***","****","******","*******","*****","********");
		Collections.sort(list, comparator);
		
		for(String s: list) {
			System.out.println(s);
		}
		
		Comparator<String> comparator2 = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());
		
		List<String> list2 = Arrays.asList("*","**","***","****","******","*******","*****","********");
		Collections.sort(list2, comparator2);
		
		for(String s: list2) {
			System.out.println(s);
		}
		
		Consumer<String> consumer = s -> System.out.println(s);
		
		consumer.accept("test1");
		
		Consumer<String> consumer2 = System.out::println;
		consumer2.accept("test2");
		
		System.out.println(consumer2.equals(consumer));
		
		Comparator<Integer> c1 =  (s1,s2) -> Integer.compare(s1, s2);
		Comparator<Integer> c2 = Integer::compare;
		
		System.out.println(c1.compare(1, 2));
		System.out.println(c2.compare(2, 1));
	}

}
/*@FunctionalInterface
interface MyFunctionalInterface{
	public String doSomething(String input);
	//public int doSomeOtherThing(int integer);
	public boolean equals(Object obj);
}
*/