package com.the703.basic011_ex;

//1. 클래스는 부품객체
//2. 부품객체 (상태 와 행위)
//3. static(행위), final(하지마), public(접근) 
//4. 부품객체 재사용( extends , 오버로딩, 오버라이딩 , 다형성)
/*
Object
 ↑
Papa	{int brain /		   sing(이문세 - 붉은 노을) }	※ 생성자 : default, field
 ↑
Son		{int money / @Override sing(빅뱅  - 붉은 노을) }
*/
class Papa extends Object{
	int brain;
	void sing() { System.out.println("이문세 - 붉은 노을"); }
	
	public Papa() { super();  }
	public Papa(int brain) { super(); this.brain = brain; }  //Papa	
} // end Papa

class Son  extends Papa{
	int momey;
	// 오버라이딩( 상속시 자식에게 맞게 수정해서 사용)
	@Override void sing() {
		System.out.println("빅뱅  - 붉은 노을");
		System.out.println("IQ > " + brain );		
		System.out.println("Money > " + momey );		
	}
	// 생성자 오버로딩
	public Son() { super(); }
	public Son(int brain) { super(brain); }
//	public Son(int momey) { this.momey = momey; } 바로위에 파라미터 int brain 자료형 같음
	public Son(int brain , int momey) {
		super(brain);
		this.momey = momey;
	}					
}
///////////////////////////////////////////////////
public class ExtendsEx003 {
	public static void main(String[] args) {
		Son myson = new Son( 148 , 100 ); myson.sing();
	}
}
/*
Son myson = new Son( 148, 100  ); →  Papa(brain)	this.money = money;
-------------------------------------------------------------
[method]  ExtendsEx003.class  Papa.class  Son.class	
-------------------------------------------------------------
[heap]                  				           [stack]
	  #3. Object()		 {				  } #4. 	
	  #2. Papa(148)  	 {brain=148/sing  } #5. 
[1번지]#1. Son(148,100)   {momey=100/@sing } #6.  ← myson[1번지] 
										           main
*/




