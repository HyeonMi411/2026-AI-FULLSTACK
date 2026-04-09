package com.the703.basic007;

public class For2Ex008 {

	public static void main(String[] args) {
		//ver-1 for 눈에 보이는 그대로
		System.out.println(1+"+"+5+"="+6);
		System.out.println(2+"+"+4+"="+6);
		System.out.println(3+"+"+3+"="+6);
		System.out.println(4+"+"+2+"="+6);
		System.out.println(5+"+"+1+"="+6);
		
		
		
		
		System.out.println();
		
		for(int ch=5; ch>=1; ch--) {
			for(int i=1; i<=5; i++) {
				if(i==i) {
					System.out.println(i+"+"+ch+"="+(i+ch));					
				}else if (i!=i){
					continue;					
				}
			}			
			System.out.println();
		}
		
		
		//ver-2 for 
//		System.out.println();
//		for(int j=5; j>=1; j--) {
//			for(int i=1; i<=5; i++) {
//				if(i==j) {
//				}
//				else if(i!=1) {
//					continue;				
//				}
//			}			
//		}
		
		
		
//		for(int j=5; j>=1; j--) {
//			for(int i=1; i<=5; i++) { System.out.println(i+"+"+i+"="+6); }			
//		}
		
//		System.out.println();
//		
//		for(int j=5; j>=1; j--) {
//			for(int i=1; i<=5; i++) { System.out.println(i+"+"+j+"="+(i+j)); }			
//		}

		



	}
}
/*
MISSION
주사위
두개의 주사위를 던졌을때 눈의 합이 6이 되는
모든 경우의 수를 출력하는 프로그램을 작성하시오.
이중 for, 이중 while, 이중 do while 세가지 버젼으로 작성하시요. 

1+5=6
2+4=6
3+3=6
4+2=6
5+1=6

ver-1: for
1+5=6
2+4=6
3+3=6
4+2=6
5+1=6

ver-2: while
1+5=6
2+4=6
3+3=6
4+2=6
5+1=6

ver-3: do while
1+5=6
2+4=6
3+3=6
4+2=6
5+1=6

*/