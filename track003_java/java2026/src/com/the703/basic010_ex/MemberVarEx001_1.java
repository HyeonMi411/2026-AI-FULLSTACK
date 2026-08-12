package com.the703.basic010_ex;

class Sawon3{ 
	int pay      =10000;	
	 int su=10;     
	 int basicpay=pay;    
	 int basicpay2;    
	
	public  void showSu() {   System.out.println(su);  }          
	public  void showPay() {   System.out.println(this.pay);  }    
	
	public  void  showAll001() {   
		System.out.println(su);  
		System.out.println(this.pay);  
	} 
	public   void  showAll002() {   
		showAll001();    
		System.out.println(this.pay);
	} 
} 
public class MemberVarEx001_1{
	public static void main(String[] args) {
		Sawon3   sola = new Sawon3();  
		sola.showAll001();
	}
}     


/*
패키지명 : com.company.java010_ex
클래스명 :  MemberVarEx001
-- class Sawon3작성해주세요 
1. 인스턴스변수 = static X , 클래스변수 = static O, 지역변수 => 클래스변수? 를 구분하시오.
2. 인스턴스메서드 = static X , 클래스메서드 = static O 구분하시오.
3. 오류나는 이유는?
인스턴스 변수, 클래스 변수, 인스턴스메서드, 클래스메서드가 섞여 있어서 입니다?
*/