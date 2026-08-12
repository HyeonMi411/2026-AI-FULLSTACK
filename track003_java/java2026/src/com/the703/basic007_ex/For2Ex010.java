package com.the703.basic007_ex;

public class For2Ex010 {
	public static void main(String[] args) {

		// 이중 for
		for(char ch2='Z'; ch2>='A'; ch2--) {
			for(char ch='A'; ch<=ch2; ch++) { System.out.print(ch); } 
			System.out.println();
		}		
		
		// 이중 while
		System.out.println();
		char ch2='Z';
		while( ch2>='A' ) {
			char ch='A';
			while( ch<=ch2 ) { System.out.print(ch); ch++; } 
			System.out.println();
			ch2--;
		}		
				
		// 이중 do while
		System.out.println();
		char ch3='Z';
		do{
			char ch='A';
			do{ System.out.print(ch); ch++; }while( ch<=ch3 ); 
			System.out.println();
			ch3--;
		}while( ch3>='A' );			

	}
}
/*
알파벳 역삼각형 
이중 for, 이중 while, 이중 do while 세가지 버젼으로 다음과 같이 출력하시오. 
ABCDEFGHIJKLMNOPQRSTUVWXYZ
ABCDEFGHIJKLMNOPQRSTUVWXY
ABCDEFGHIJKLMNOPQRSTUVWX
... 중간 생략 ...
ABC
AB 
A
*/