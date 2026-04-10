package com.the703.basic007_ex;

public class For2Ex007 {

	public static void main(String[] args) {
		//ver-1 작은단위로 눈에 보이는 그대로
		System.out.print(4); System.out.print(4); System.out.print(4); System.out.print(4); System.out.println();
		System.out.print(3); System.out.print(3); System.out.print(3); System.out.println();
		System.out.print(2); System.out.print(2); System.out.println();
		System.out.print(1); System.out.println();

		//ver-2 칸정리
		System.out.println();
		for(int i=1; i<=4; i++) { System.out.print(4); } System.out.println();
		for(int i=1; i<=3; i++) { System.out.print(3); } System.out.println();
		for(int i=1; i<=2; i++) { System.out.print(2); } System.out.println();
		for(int i=1; i<=1; i++) { System.out.print(1); } System.out.println();
		
		//ver-3 층정리
		System.out.println();
		for(int ch=4; ch>=1; ch--) {
			for(int i=ch; i>=1; i--) { System.out.print(ch); } System.out.println();			
		}
		
	}
}
/*

패키지명 : ccom.the703.basic007
클래스명 :  For2Ex007   (이중for 이용)

4444
333
22
1

*/