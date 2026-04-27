package com.the703.days;

class Parent7  extends Object{
	int x = 100;
	public Parent7() { super(); }
	void method() { System.out.println("Parent Method"); }
} 
class Child7 extends Parent7 {
	int x = 200;
	public Child7() { super(); }
	@Override  void method() { System.out.println("Child Method"); }
}
/*
		Object
		  ↑
		Parent7 {x=100 , method()}  Parent
		  ↑
		Child7  {x=200 , method()}  Child
 */

public class 복습문제_2day023 {
	public static void main(String[] args) {

		Parent7 p = new Child7();     //부모  = 자식 (업캐스팅)
		// 7-3.    Parent7 p   보장하는 범위  
		// 7-4.    인스턴스화 했을때 사용가능한 범위 : new Child7()   
		Child7 c = new Child7();  
		
		System.out.println("p.x = " + p.x);  // 7-5 출력되는 내용  	
		p.method();  //7-6 출력되는 내용    							
		
		System.out.println("c.x = " + c.x);   // 7-7  출력되는 내용 	
		c.method();   //7-8. 출력되는 내용     						
				
	}
}
