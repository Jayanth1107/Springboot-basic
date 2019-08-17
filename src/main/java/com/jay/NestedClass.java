package com.jay;

public class NestedClass {

	int a=10;
	static int b = 20;
	public static void main(String[] args) {
		
		E e = new D();
		System.out.println(e.a());
		D d = new D();
		D de = (D) e;
		System.out.println(d.a());
		System.out.println(de.a());
		
		class B{
			int a=2;
			
			String getBandA() {
				
				return a + "" + b;
			}

		}
		
		B b = new B();
		System.out.println(b.getBandA());
		
			
	}
	static class A{
		int c=3;
		
		String getBandA() {
			NestedClass nC = new NestedClass();
			
			return nC.a + "" + b;
		}
	}

}

interface E{
	static int k=10;
	default int a() {
		return 2;
	}
}
class D implements E {
	@Override
	public int a() {
		return 9;
	}
}