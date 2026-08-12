package com.the703.days;

import java.util.Scanner;

public class Day012 {

	public static void main(String[] args) {
		
//		1. if버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
//		정수를 하나 입력받아 다음 조건에 따라 성적을 출력하는 프로그램을 작성하시오.
//		90점 이상 → "A 학점"
//		80점 이상 → "B 학점"
//		70점 이상 → "C 학점"
//		그 외 → "F 학점"
		int avg=0;
		char grade ='\u0000';
		Scanner scanner = new Scanner(System.in);
		System.out.print("평균입력 > ");  avg = scanner.nextInt();
		
		if(avg>=90) {
			System.out.println("성적은 A 학점 입니다.\n");			
		}else if(avg>=80) {
			System.out.println("성적은 B 학점 입니다.\n");			
		}else if(avg>=70) {
			System.out.println("성적은 C 학점 입니다.\n");			
		}else {
			System.out.println("성적은 F 학점 입니다.\n");			
		}
		
//		grade = avg>=90 ? 'A' 
//				: avg>=80 ? 'B'
//				: avg>=70 ? 'C' : 'F';
//				
//				System.out.printf("성적은 %c 학점 입니다.\n\n",grade);

//				2. switch버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
//				위의 문제를 switch 로
//				
//				int avg=0;
//				Scanner scanner = new Scanner(System.in);
//				System.out.print("평균입력 > ");  avg = scanner.nextInt();
				switch(avg/10) {
				case 10 : case 9 : System.out.println("성적은 A 학점 입니다.\n"); break;
				case 8 : System.out.println("성적은 B 학점 입니다.\n"); break;
				case 7 : System.out.println("성적은 C 학점 입니다.\n"); break;
				default : System.out.println("성적은 F 학점 입니다.\n");				
				}
				
//				3. for, while, do while 버젼으로  문제를 풀으시오!  
//				1 2 3				
				for(int i=1; i<=3; i++) { System.out.print(i+"\t"); }			
		
				System.out.println();
				int i=1;
				while( i<=3 ) { System.out.print(i+"\t"); i++; }			

				System.out.println();
				int i1=1;
				do{ System.out.print(i1+"\t"); i1++; }while( i1<=3 );	
				
//				4. 이중 for를 이용해서 다음문제를 풀으시오.
//				★★★★
//				★★★★
//				★★★★
//				★★★★
				System.out.println();
				System.out.println();
				for(int ch=1; ch<=4; ch++) {
					for(int i2=1; i2<=4; i2++) { System.out.print("★");} System.out.println();					
				}
		
	}
}