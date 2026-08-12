package com.the703.days;

import java.util.Scanner;

public class Day011 {

	public static void main(String[] args) {
		char ch = '\u0000';
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("a,b,c 중에 입력 > ");
		ch = scanner.next().charAt(0);		

//		1. if버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
//	    문자를 한개 입력받아 a이면 apple , b이면 banana, c이면 coconut
		if( ch=='a' ) {
			System.out.println("apple");			
		}else if( ch=='b' ){
			System.out.println("banana");			
		}else if( ch=='c' ) {
			System.out.println("coconut");			
		}else {
			System.out.println("a,b,c 중에 입력 ");
		}

//		2. switch버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
//	    문자를 한개 입력받아 a이면 apple , b이면 banana, c이면 coconut	
		switch(ch) {
			case 'a' : System.out.println("apple"); break;
			case 'b' : System.out.println("banana");  break;
			case 'c' : System.out.println("coconut");  break;
			default : System.out.println("a,b,c 중에 입력 ");
		}
		
//		3. for, while, do while 버젼으로  문제를 풀으시오!  
//	     1  2  3  4  5		
		System.out.println();
		System.out.println();
		for(int i=1; i<=5; i++) {System.out.print(i);}
		System.out.println();
		System.out.println();
		int i=1;
		while( i<=5 ) {System.out.print(i); i++; }
		System.out.println();
		System.out.println();
		int i1=1;
		do{System.out.print(i1); i1++; }while( i1<=5 ) ;
		
	}

}
