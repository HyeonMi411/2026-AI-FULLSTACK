package com.the703.basic007_ex;

public class For2Ex013 {
	public static void main(String[] args) {

		System.out.println("이중 for\n");
		for(int dan=2; dan<=4; dan++) {
			for(int i=1; i<=9; i++) {
				System.out.println(dan+"*"+i+"="+(dan*i));			
			}
			System.out.println();
		}
		
		System.out.println("이중 while\n");
		int dan=2;
		while( dan<=4 ) {
			int i=1;
			while( i<=9 ) {
				System.out.println(dan+"*"+i+"="+(dan*i));			
				i++;
			}
			System.out.println();
			dan++;
		}
		
		System.out.println("이중 do while\n");
		int dan1=2;
		do{
			int i=1;
			do{
				System.out.println(dan1+"*"+i+"="+(dan1*i));			
				i++;
			}while( i<=9 );
			System.out.println();
			dan1++;
		}while( dan1<=4 );

	}
}
/*
구구단2~4단
이중 for, 이중 while, 이중 do while 세가지 버젼으로 구구단2~4단을 출력하시오. 
2단
2*1=2
2*2=4
...중간생략...
3단
3*1=3
3*2=6
...중간생략...
4단
4*1=4
4*2=8
...중간생략...
*/