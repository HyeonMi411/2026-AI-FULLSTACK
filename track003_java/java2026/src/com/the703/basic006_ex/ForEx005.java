package com.the703.basic006_ex;

public class ForEx005 {
	public static void main(String[] args) {
		
		int count=0;	
		
		// a가 모음이라면 count 
		// b가 모음이라면 count 
		// c가 모음이라면 count 
		// d가 모음이라면 count 
		// e가 모음이라면 count 
		
		char ch = '\u0000';

		for(ch='a'; ch<='z'; ch++) {
			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				count++;
			}				
		}			
		System.out.println("소문자 a~z까지 모음의 갯수 : \n"+count+"개");		

	}
}

/*
연습문제5)  
패키지명 : com.company.java005_ex
클래스명 :  ForEx005
출력내용 :   for 이용
소문자 a~z까지 모음의 갯수를 출력하시오. 
*/
