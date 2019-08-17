package com.jay;

public class Threads {
	static int i=1;

	public static void main(String[] args) {
		Thread t11 = new Thread(new T11());
		
		try{
		t11.start();
		}
		catch(Exception e) {
			System.out.println("Main call: "+e.getMessage());
		}
		
		for(int i=100;i<200;i++) {
			try{Thread.sleep(1);}catch(Exception e) {System.out.println(e.getMessage());}
			Threads.i=i;
			System.out.println("["+Threads.i+"]");
		}
		

		A3 a31 = new A3(123);
		A3<Long> a32 = new A3(12345L);
		
		System.out.println(a31.ob.toString()+" "+a32.ob.toString());
		System.out.println(a31.getVal()+" "+a32.getVal());
		
		System.out.println(T12.createAndStart("twist"));
		
		
		T13 t13 = new T13();
		t13.start();
	}

}
class T11 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<100;i++) {

			Thread.currentThread().interrupt();
			Thread.currentThread().checkAccess();
			if(i==10)
				Thread.currentThread().stop();
			System.out.println(Thread.interrupted());
			try{Thread.sleep(100);}catch(Exception e) {System.out.println(e.getMessage());}
			Threads.i=i;
			System.out.print("{"+Threads.i+"}");
			
			
		}
	}
	
}
class A1 {}
class T12 extends Thread implements Runnable {
	
	Thread thrd;
	
	T12(String name){
		thrd = new Thread(this, name);
	}
	
	public static String createAndStart(String name) {
		T12 t12 = new T12(name);
		t12.thrd.start();
		return t12.thrd.getName();
	}
	
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			try{Thread.sleep(100);}catch(Exception e) {System.out.println(e.getMessage());}
			System.out.println(++i +" ");
		}
	}
}

class T13 extends Thread{

	public void run() {
		try{Thread.sleep(10000);}catch(Exception e) {System.out.println(e.getMessage());}
		System.out.println("Inside the t13 thread");
	}
		
}

class A3<T> {
	T ob;
	A3(T o){
		ob=o;
	}
	int getVal() {
		return 1234;
	}
}