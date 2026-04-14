package com.the703.basic007_ex;

public class For2Ex009_1 { // start class
	public static void main(String[] args) { // start main
		
		// 이중 for
		for(char ch2='A'; ch2<='Z'; ch2++) {
			for(char ch='A'; ch<=ch2; ch++) { System.out.print(ch<=ch2 ?ch:' '); } 
			System.out.println();
		}	
		
		// 이중 while
		System.out.println();
		char ch2='A';
		while( ch2<='Z' ) {
			char ch='A';
			while( ch<=ch2 ) { System.out.print(ch<=ch2 ?ch:' '); ch++; } 
			System.out.println();
			ch2++;
		}	
		
		// 이중 do while
		System.out.println();
		char ch3='A';
		do{
			char ch='A';
			do{ System.out.print(ch<=ch3 ?ch:' '); ch++; }while( ch<=ch3 ); 
			System.out.println();
			ch3++;
		}while( ch3<='Z' );	

	} // end main
} // end class
/*
알파벳 삼각형 
이중 for, 이중 while, 이중 do while 세가지 버젼으로 다음과 같이 출력하시오. 
A
AB 
ABC
... 중간 생략 ...
ABCDEFGHIJKLMNOPQRSTUVWX
ABCDEFGHIJKLMNOPQRSTUVWXY
ABCDEFGHIJKLMNOPQRSTUVWXYZ

*/