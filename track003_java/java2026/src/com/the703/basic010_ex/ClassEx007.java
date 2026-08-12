package com.the703.basic010_ex;

import java.util.Scanner;

class Calc{

	public Calc() { super();  }

	public Calc(int num1, int num2, char op) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.op = op;		
	}

	@Override public String toString() { return "Calc []"; }
		
	int num1, num2;  char op;  double result;
	void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자1> "); num1 = scanner.nextInt();
		System.out.print("숫자2> "); num2 = scanner.nextInt();
		System.out.print("연산자(+,-,*,/) "); op = scanner.next().charAt(0);		
	}   // 입력받기
	double opcalc() {
			 if(op=='+') {  return num1+num2; }
		else if(op=='-') {  return num1-num2;  }
		else if(op=='*') {  return num1*num2;  }
		else if(op=='/') {  return (double)num1/num2;  }
		else 			 {	return -1;	}
	} // +더하기계산, -라면 -계산  , *라면 *계산 , /라면 /계산 
	void show() {
		System.out.printf("%d%c%d=%.2f\n", num1, op, num2, opcalc());
//		System.out.println(num1+""+op+""+num2+"="+opcalc());
		
		
	}    // 연산출력


}
public class ClassEx007{
	public static void main(String[] args) {
		Calc  c1= new Calc(10,3,'+');  
		c1.show();
		
		Calc  c2= new Calc();  
		c2.input();   
		c2.show(); 
		
	}
}
		
//		출력내용)
//10+3=3
//
//숫자1> 10
//숫자2> 3
//연산자> /
//10/3=3.33

/*
연습문제4)  class
패키지명 : com.the703.basic010_ex
클래스명 :  ClassEx007
-- 생성자 작성하시오.
class Calc{
   //상태-멤버변수  :  int num1, num2;  char op;  double result;
   //행위-멤버함수  :  void input()   입력받기
   //               void opcalc() +더하기계산, -라면 -계산  , *라면 *계산 , /라면 /계산 
   //                      void show()    연산출력   
}
public class ClassEx007{
   public static void main(String[] args) {
   Calc  c1= new Calc(10,3,'+');  
   c1.show();
   
   Calc  c2= new Calc();  
   c2.input();   
   c2.show(); 
    
   }
}

출력내용)
10+3=3

숫자1> 10
숫자2> 3
연산자> /
10/3=3.33
*/