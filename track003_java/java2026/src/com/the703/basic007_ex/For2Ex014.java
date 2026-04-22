package com.the703.basic007_ex;

public class For2Ex014 {
	public static void main(String[] args) {
		
		int dan=0;
	
		for(int i=1; i<=9; i++) {
			if(dan%4==0) {										
			for(int dan=2; dan<=9; dan++) {
				System.out.print( dan+"*"+i+"="+(dan*i)+"\t");					
					System.out.println();					
					if(i%9==0) {
						System.out.println();
					}
//				else {
//					System.out.println();					
//				}
					
			}
			}
			System.out.println();
		}	

	}
}
/*
구구단 가로본능
다중 for를 이용하여 구구단 2~4단을 다음과 같이 출력하시요. 

2*1=2		3*1=3		4*1=4
2*2=4		3*2=6		4*2=8
2*3=6		3*3=9		4*3=12

5*1=2		6*1=6		7*1=7
5*2=4		6*2=12		7*2=14
5*3=6		6*3=18		7*3=21

8*1=2		9*1=9		
8*2=4		9*2=18		
2*3=6		9*3=27		

*/