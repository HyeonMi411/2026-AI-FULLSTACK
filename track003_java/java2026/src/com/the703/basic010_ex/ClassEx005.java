package com.the703.basic010_ex;

import java.util.Scanner;

class Card{

	public Card() { super();  }
	
	public Card(int cardNum, boolean isMembership) {
		super();
		this.cardNum = cardNum;
		this.isMembership = isMembership;
	}

	@Override public String toString() { return "Card [cardNum="+cardNum+", isMembership="+isMembership+"]"; }
		
	int cardNum; boolean  isMembership;   
	void input(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("cardNum 입력 > "); cardNum = scanner.nextInt();
		System.out.println("Membership 입력 > "); isMembership = scanner.nextBoolean();
	}
	void show(){
		
//		System.out.printf("Card[cardNum=%d, isMembership=%b]", cardNum, isMembership);		
		
	}

}
public class ClassEx005{
	public static void main(String[] args) {
		Card  c1= new Card(); 
		System.out.println(c1);  
	}
}

//출력내용 :
//	Card[cardNum=0, isMembership=false]

/*
연습문제3)  class
패키지명 : com.the703.basic010_ex
클래스명 :  ClassEx005
-- 생성자 작성하시오.
class Card{
   //상태-멤버변수  : 채널/볼륨 int cardNum; boolean  isMembership;   
   //행위-멤버함수  : 채널, 볼륨 입력: input() / 출력 : show()
}
public class ClassEx005{
   public static void main(String[] args) {
   Card  c1= new Card(); 
   System.out.println(c1);  
   }
}

출력내용 :
Card[cardNum=0, isMembership=false]

*/