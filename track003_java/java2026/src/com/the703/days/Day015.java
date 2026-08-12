package com.the703.days;

public class Day015 {
	public static void main(String[] args) {

//		1.  for, while , do while을 이용해서 문제를 풀으시오.
//		3   2   1
		
		for(int i=3; i>=1; i--) { System.out.printf("%d\t" , i ); }
		
		System.out.println();
		System.out.println();
		int i=3;
		while( i>=1 ) { System.out.printf("%d\t" , i ); i--; }
		
		System.out.println();
		System.out.println();
		int i1=3;
		do{ System.out.printf("%d\t" , i1 ); i1--; }while( i1>=1 );
		
//		2 이중 for 버전
//		다음과 같은 모양을 출력하는 프로그램을 작성하시오.
//		★★★
//		★★
//		★
		
		System.out.println();
		System.out.println();
		for(int ch=3; ch>=1; ch--) {
			for(int i2=1; i2<=ch; i2++) { System.out.printf("%s" , '★'); }
			System.out.println();
		}
		
//		3.  1차원배열      new 연산자 이용해서 배열만들기
//		1. 배열명 : arr     
//		2. 값 넣기 :   A B C        for+length 이용서 값 대입
//		3. for + length 로 출력 
		
		System.out.println();
		System.out.println();
		char [] arr = new char[3];
		char data = 'A';
		
		for(int i2=0; i2<arr.length; i2++) { arr[i2]=data++;}
		
		for(int i2=0; i2<arr.length; i2++) { System.out.printf("%c\t" , arr[i2]);}

	}
}
/*
1.  for, while , do while을 이용해서 문제를 풀으시오.
     3   2   1

2 이중 for 버전
다음과 같은 모양을 출력하는 프로그램을 작성하시오.
★★★
★★
★

3.  1차원배열      new 연산자 이용해서 배열만들기
    1. 배열명 : arr     
    2. 값 넣기 :   A B C        for+length 이용서 값 대입
    3. for + length 로 출력 
*/