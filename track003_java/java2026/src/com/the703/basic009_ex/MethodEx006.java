package com.the703.basic009_ex;

import java.util.Scanner;

public class MethodEx006 {

	public static void main(String[] args) {
		
		int a=0, b=0, c=0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자1>"); a = scanner.nextInt();
		System.out.println("숫자2>"); b = scanner.nextInt();
		System.out.println("숫자3>"); c = scanner.nextInt();
		int res3=max(a,b,c);
		System.out.println("최대값"+res3);

	}
	
	public static int max(int a, int b, int c) {
		//a랑 b랑 비교 해서 큰 값을 c랑 비교한다.
		int max=-99999;
		if(a<b) { max = b;}
		if(max<c){ max = c;}
		return max;
		
//		int [] su = {-3, -5, -1, -9, -7} ;		
//		int max=-99999, min=99999;
//		
//		for(int i=0; i<su.length; i++) {
//			if(max<su[i]) {
//				max = su[i];				
//			}
//			if(min>su[i]) {
//				min = su[i];				
//			}			
//		}
//		System.out.println("최대값 : "+max);			
//		System.out.println("최소값 : "+min);			
		
		
	}

}
//