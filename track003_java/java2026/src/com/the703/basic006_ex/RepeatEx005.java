package com.the703.basic006_ex;

import java.util.Scanner;

public class RepeatEx005 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);		
		int num1=-1, num2=-1, hap=0;
		System.out.print("숫자1입력 : "); num1 = scanner.nextInt();
		System.out.print("숫자2입력 : "); num2 = scanner.nextInt();	
		
		for(;;) {
			int i=num1;			
			if( num1<num2 && i<=num2 ) {				
				hap += i;									
				System.out.print((i==num1 ? "":"+")+i);	
				i++;				 				
			}else if( num1>num2 && i>=num2 ) {				
				hap += i;
				System.out.print((i==num1 ? "":"+")+i);
				i--;											
			} break;
		} System.out.println("="+hap);			
		
		//===============================================
		
		
//			for(int i=num1; ) {
//				hap += i;
//				System.out.print((i==num1 ? "":"+")+i);				
//			}
//			System.out.println("="+hap);			
		
		
//		if( num1<num2 ) {
//			for(int i=num1; i<=num2;i++) {
//				hap += i;
//				System.out.print((i==num1 ? "":"+")+i);				
//			}
//			System.out.println("="+hap);			
//		}else if( num1>num2) {
//			for(int i=num1; i>=num2;i--) {
//				hap += i;
//				System.out.print((i==num1 ? "":"+")+i);				
//			}
//			System.out.println("="+hap);			
//		}
		
		
	}
}
/*
두개의 숫자를 입력받아 FOR문을 이용하여 다음과 같이 출력하시오. 
숫자1입력 : 2
숫자2입력 : 5
2+3+4+5=14

숫자1일력 : 5
숫자2입력 : 2
5+4+3+2=14
*/