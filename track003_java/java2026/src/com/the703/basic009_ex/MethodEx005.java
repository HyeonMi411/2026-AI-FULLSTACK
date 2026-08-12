package com.the703.basic009_ex;

import java.util.Scanner;

public class MethodEx005 {

	public static void main(String[] args) {
		
		int res1=0; 		
		Scanner scanner = new Scanner(System.in);
		System.out.print("절대값을 구하는 프로그램입니다.\n숫자를 입력하세요 > ");	res1 = abs(scanner.nextInt());
		
		System.out.println(res1);		
		
	}
	
	public static int abs(int res1) {
		     if( res1>0 ) { return res1; }
		else if( res1<0 ) { return -res1;}
		else              { return 0;    }		
	}

}
//숫자를 입력받아 절대값을 출력해주는 메서드를 작성하시오. 