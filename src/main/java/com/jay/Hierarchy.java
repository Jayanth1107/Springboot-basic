package com.jay;

public class Hierarchy {

	public static void main(String[] args) {
		
		A a = new A(1);
		B b = new B(2);
		C c = new C(3);
		
		A a2 = new B(4);
		System.out.println(a2.a);
		
		A a3 = new C(5);
		System.out.println(a3.a);
	}

}

class A {
	int a;
	A(int i){
		a = i;
	}
}

class B extends A {
	B(int i) {
		super(i);
		b=i;
	}
	int b;
}
class C extends B {

	int c;
	C(int i) {
		super(i);
		c = i;
	}
}