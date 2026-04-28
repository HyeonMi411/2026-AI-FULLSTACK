




### ■1. 복습문제 

.... JAVA 복습문제 먼저 준비~!

■ OOP
class A11 {
    int a; // (1)   인스턴스변수 - heap area - new O - 생성자 - this 각각(생김?)

    A11() { }

    A11(int a) { this.a            = a;           } // (2) 생성자
    //           this.a 인스턴스변수 = a 지역변수 

    //(3) void show()    인스턴스메서드 -hea area - new O - 생성자 - this 각각
    void show() { 
        this.a = 11; 
        System.out.println(this.a); 
    }

    //(4) static void classMethod()  클래스 메서드 - method area - new x - 생성자 x - 공용
    static void classMethod() { this.a = 12; }  // Q2. static은 this.a  인스턴스사용불가

    //(5) int showZ()  인스턴스메서드
    int showZ() { 
        int a;   // Q2. 지역변수    int a = 0;      지역변수는 수동으로 초기화
        return a; 
    }
}

public class RepeatQ123 {
    public static void main(String []args) { 
        A11 a1 = new A11(); 
        (b) 
    }
} // end class

Q1. 위의 문제에서 (1),(2),(3),(4),(5)를 [ 클래스변수, 인스턴스변수, 지역변수, 클래스메서드, 인스턴스메서드 ]에서 고르시오.

> 클래스는 부품객체
> 상태(속성/멤버변수)와 		행위(기능/멤버함수)
 클래스변수, 인스턴스변수		클래스메서드, 인스턴스메서드 

Q2. 클래스 A11에서 오류나는 곳을 수정하고 그 이유를 적으시오.
     static void classMethod() { this.a = 12; }     static은 this 사용불가
    int showZ() { 
        int a;   // Q2. 지역변수    int a = 0;       지역변수는 수동으로 초기화
        return a; 
    }

Q3. (b)번 위치에서      A11 a1 = new A11(); 
메모리 빌려오고, 객체 생성하는 역할 : (  new  )
String은 null, int는 0으로 초기화하는 역할 : (  A11()   )	// 생성자 
new A11()한 주소를 갖고 있는 것은 : ( 참조변수  a1    )

Q4. 기본생성자를 반드시 선언해야하는 경우를 적으시오.
오버로딩 (다른생성자를 작성시, 개발자 수동으로 생성자 생성시 ) , 상속

	A11( ){ }
	A(int a){ this.a = a; }

Q5. 다음 중 오버로딩이 성립하기 위한 조건이 아닌 것은?  c,d
a. 메서드의 이름이 같아야 한다.   → 오버로딩조건o
b. 매개변수의 개수나 타입이 달라야 한다.   → 오버로딩조건o
c. 리턴타입이 달라야 한다.    → 오버로딩조건 X
d. 매개변수의 이름이 달라야 한다.   → 오버로딩조건X  A(int brain)  ,A( int money)
> 메서드이름이 같고 파라미터 타입과 갯수

Q6. 다형성이란? 하나의 타입(부모)으로 여러 형태(자식)를 사용할수 있는 성질

Q7. 다음코드에서 다음에 해당하는 부분을 작성하시오.

//7-1. 상속도
//7-2. 각 클래스에서 사용할수 있는 멤버변수, 멤버함수

package com.the703.basic012_ex;

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

public class PolyEx002 {
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

/*	 7-1	   7-2
	Object  #3{		}#4
  	   ↑
	Parent7 #2{ x=100 , method() }#5  Parent
	   ↑
	Child7 #1 { x=200 , @method() }#6  Child

	7-3	Parent7 p  (1번지)		=> { x=100, method() }
	7-4	new Child7()		=> { x=200, method() } - { x=100, method() }
	7-5	x=100
	7-6	Child Method
	7-7	x=200
	7-8	Child Mehtod 
*/

```

part1. 제어문-절차지향
part2. OOP  -객체지향 특징
2-1. 클래스사용 ( 클래스 VS 객체 )
2-2. 클래스 설정 (static, final, public■캡슐화)
2-3. 클래스 ■상속 ( 재활용 )
2-4. ■댜형성 (부모(한가지)타입으로 자식(여러)타입들 관리)
2-5. ■추상화 (공통적인 속성 뽑기 )


```


