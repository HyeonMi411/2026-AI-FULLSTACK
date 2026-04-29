package com.the703.days;
////////////////////////////////////////////////////////////////////////////////////////복습문제 (1)
//Q1. 다음의 상속도를 그리시오.
//Q2. 상속도에서  각각의 클래스에서 사용가능한 멤버변수/멤버함수를  적으시오.

/*
Abstract (is A) 일반클래스 + 설계 
고양이도 동물이다
개도    동물이다
<<abstract>>
Animal     {name / eat(), sleep(), poo()}
↑   ↑ 
Cat    Dog    {@eat(), @sleep(), @poo()}   

abstract : 공통 속성 뽑아서 일반화 설계 / 강제성 무조건 구현 

클래스 그냥 선언 순서 상관 없음

 */
//abstract class Animal{    
//	String name; 	//인스턴스변수 - heap area - new o - this 각각 // this.name 가능 
//	abstract void eat();   // 추상메서드 {} 구현부가 없음.
//	abstract void sleep(); // 추상메서드 추상클래스로 만들어줘야 함.
//	abstract void poo();  // 추상화, 일반화, 설계 : 공통의 속성, 구체적인 내용 없음
//}
//class Cat  extends Animal{  // 구현클래스 - 고양이는 동물이다
//	@Override void eat()   {  System.out.println(super.name + "고양이 냠냠!");  }
//	@Override void sleep() {  System.out.println(super.name + "고양이 수면!");  }
//	@Override void poo()   {  System.out.println(super.name + "고양이 시원");  }
//}
//class Dog  extends Animal{  // 구현클래스 - 강아지는 동물이다
//	@Override void eat()   {  System.out.println(super.name + "강아지 냠냠!");  }
//	@Override void sleep() {  System.out.println(super.name + "강아지 수면!");  }
//	@Override void poo()   {  System.out.println(super.name + "강아지 시원");  }
//}
//
//public class Day025_ {
//	public static void main(String[] args) {
//
//		//1. abstract  class : 일반클래스 + 설계
//		//Animal ani = new Animal();   Q3. 이코드에서 오류나는 이유는? 
//		// new 메모리빌리고 객체생성, Animal 초기화 {} 구현부가 없음  →  abstract void eat(); 없음 → 틀만 제공하고 실제동작 구현하는 부분은 하위클래스에서 구현 
//		
//		Animal ani = null;
//		ani = new Cat();   //Q4.    업캐스팅/다운캐스팅 ?
//		// 부모 = 자식, 업캐스팅
//		ani.name = "sally";   ani.eat();
//		
//		
//		//2. 사용목적
//		Animal [] arr = {new Cat() , new Cat() , new Dog() , new Dog() , };
//		int cnt=0;
//		//Q5.  다음이 출력되게 코드를 작성하시오.
//		/*ani1고양이 냠냠!
//				ani2고양이 냠냠!
//				ani3강아지 냠냠!
//				ani4강아지 냠냠!   */
//		for( Animal a    : arr   ) { a.name = "ani" + ++cnt;  a.eat();  }
//		// 각각 인스턴스에 이름 /  eat() 자식꺼 오버라이드 (최신기능)
//			
//	}
//}

////////////////////////////////////////////////////////////////////////////////////////복습문제 (2)

//Q6. 오류나는 부분을 주석달고 이유를 적으시오.

//class Papa{   int brain; }
//class Mama{   int brain; }
////class Son extends Papa, Mama{}	→ 단일상속 (자바에서의 상속은)		6-1
//
//interface Animal2{
//	String company="(주) thejoa";    //Q7.  interface에서의 멤버변수에 붙는 키워드는? 
//	//sf : static final(수정하지마세요/수정할때 오류)- 공용: Animal2.company (클래스변수) method area, new x,this 각각x
//	void eat();     //Q8.  interface에서의 멤버함수에 붙는 키워드는? 
//	//a:abstract	{} 구현부가 없어서 - 구현클래스에서 상세내용 
//}
//class Saram implements Animal2{ 
//	@Override public void eat() { 
//		//company="kakao";	→ 상수, 수정 x, 값 재할당 X 6-2  The final field Animal2.company cannot be assigned
//		//최종 필드 Animal2.company를 할당할 수 없습니다
//		System.out.println( Animal2.company  + " 랍스탑.... 냠냠 "   );
//	}
//} 
//
//public class Day025_ {
//	public static void main(String[] args) {
//	}
//}

//////////////////////////////////////////////////////////////////////////////////////////복습문제 (3)

//Q9.  Driver 클래스를 작성하시오.   
/*       
			Vehicle { run() }			←		Driver { drive(Vehicle v); }
			↑				↑
	MotorCycle				Car
	{ @run(/helmat()) }		{ @run() }
 */

interface Vehicle {  public void run();    } 
class MotorCycle implements Vehicle {
	@Override   public void run() {   System.out.println("오토바이가 달립니다.");   }
	public void helmat() {   System.out.println("헬멧을 착용합니다.");   }
}
class Car implements Vehicle {
	@Override  public void run() {     System.out.println("자동차가 달립니다.");   }
}

class Driver {
	void drive(Vehicle v) {    // Vehicle  v = car     , Vehicle v = mo 
		// 만약에 모터사이클이라면   helmet()  호출
		if(v instanceof MotorCycle) {   ((MotorCycle)v).helmat(); }  
		v.run();    // 기본 다형성동작 - override 된 자식메서드
	}
}
// 6 6-1/6-2  1점
// 9 성공~!    1점 
// 응원콘테스트  1점 
public class Day025_ {
	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Car car = new Car();
		MotorCycle mo = new MotorCycle();
		
		//리턴값       메서드명(파라미터){        }
		//                 car , mo 두개의 값을 다 담을수 있는 자료형   부모 = 자식   
		//void       drive(Vehicle v)      
		
		driver.drive(car);	//	리턴값         자동차가 달립니다.
		driver.drive(mo);	//         오토바이가 달립니다. 
	}
}

//>> 실행화면
//자동차가 달립니다.
//
//헬멧을 착용합니다.
//오토바이가 달립니다.     


