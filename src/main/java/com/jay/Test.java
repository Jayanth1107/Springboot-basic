package com.jay;

import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int rand = (int) (10.0*Math.random());
		System.out.println(rand);
		if(rand<1)
			main(new String[]{});
		else
			System.out.println("exit");
		
			ParentClass p = new ParentClass();
			Method[] m;
			m = p.getClass().getDeclaredMethods();
			System.out.println(m.length);
			System.out.println(m[0].getName());
			ParentClass.staticFunction();
			System.out.println(p.p1(new ParentClass()).toString());
			System.out.println(p.runn(2));
			System.out.println(p.runn(12, 2));
			System.out.println(p.runn(1, "fd"));
			try {
				int i=0;
				System.out.println(i/0);
			}
			catch(Exception e) {}
			finally {
				System.out.println("F'ed up");
			}
			
			
			T1 t1 = new T1("Jay");
			
			Thread newT = new Thread(t1);
			newT.start();
			
			char[] j = {'J','a','y','a','n','t','h',' ','R','e','d','d','y',' ','.',' ','P'};
			
			for(int i=0;i<50;i++) {
				try{Thread.sleep(100);
				System.out.print("|");}catch(Exception e) {}
				try{Thread.sleep(100);
				System.out.print("-");}catch(Exception e) {}
			}
			
			for(int i=0;i<j.length;i++) {
				try{Thread.sleep(100);
				System.out.print(j[i]);}catch(Exception e) {}
			}
		}

}

class ParentClass extends Object implements i,i2{
	static void staticFunction() {
		System.out.println("called");
	}
	
	ParentClass p1(ParentClass p2) {
		return p2;
	}

	@Override
	public void runn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int runn(int k) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int runn(int k, String d) {
		// TODO Auto-generated method stub
		return i.super.runn(k, d);
	}

	@Override
	public int runn(int k, int d) {
		// TODO Auto-generated method stub
		return i.super.runn(k, d);
	}
}
class Parentclass1 {
	
}
interface i{
	void runn();
	int runn(int k);
	default int runn(int k, int d) {
		return k+d;
	}
	default int runn(int k, String d) {
		return k;
	}
}
interface i2{
	void runn();
	int runn(int k);
	default int runn(int k, int d) {
		return k*d;
	}
	default int runn(int k, String d) {
		return k+1;
	}
}


class T1 implements Runnable{
	
	String name;
	
	T1(String name){
		this.name = name;
	}

	@Override
	public void run() {
		for(int i =0;i<10; i++) {
			try{Thread.sleep(200);
			System.out.println("-");}catch(Exception e) {}
		}
	}
}