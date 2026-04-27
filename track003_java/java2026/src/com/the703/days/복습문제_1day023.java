package com.the703.days;

class A11 {
	int a; // (1)
	
	A11() { }
	
	A11(int a) { this.a = a; } // (2)
	
	//(3) void show()
	void show() { 
		this.a = 11; 
		System.out.println(this.a); 
	}
	
	//(4) static void classMethod()
	static void classMethod() { this.a = 12; }
	
	//(5) int showZ()
	int showZ() { 
		int a; 
		return a; 
	}
}

public class 복습문제_1day023 {
	public static void main(String[] args) {
		int a;
		System.out.println(a);

	}
}
