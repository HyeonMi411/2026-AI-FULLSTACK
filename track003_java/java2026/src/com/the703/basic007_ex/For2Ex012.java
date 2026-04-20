package com.the703.basic007_ex;

public class For2Ex012 {
	public static void main(String[] args) {
		
//		1~10, 11~20 누적합
//		이중 for, 이중 while, 이중 do while 세가지 버젼으로 다음과 같이 출력하시오. 
//		1+2+3+4+5+6+7+8+9+10 = 55
//		1+2+3+4+5+6+7+8+9+10+11+12+13+14+15+16+17+18+19+20 = 210
//		... 중간생략 
//		1+2+3+4+5+6+7+8+9+10+11+12+13+14+15+16+17+18+19...중간생략+100 = 5050
		
//		(1*1)+2+3+4+5+6+7+8+9+(1*10) = 55
//		(2*1)+2+3+4+5+6+7+8+9+10+11+12+13+14+15+16+17+18+19+(2*10) = 210
//		... 중간생략 
//		(10*1)+2+3+4+5+6+7+8+9+10+11+12+13+14+15+16+17+18+19...중간생략+(10*10) = 5050
		
		// 이중 for		
		int hap=0;
		
		for(int ch=1; ch<=10; ch++) {
			for(int i=1; i<=(10*ch); i++) {
				System.out.print( (i==1 ? "" :"+") + i);
				hap+=i;
			}
			System.out.println("="+hap);	
			hap=0;
		}
		
		// 이중 while	
		System.out.println();
		int hap1=0;
		
		int ch=1;
		while( ch<=10 ) {
			int i=1;
			while( i<=(10*ch) ) {
				System.out.print( (i==1 ? "" :"+") + i);
				hap1+=i;
				i++;
			}
			System.out.println("="+hap1);	
			hap1=0;
			ch++;
		}

		// 이중 while	
		System.out.println();
		int hap2=0;
		
		int ch1=1;
		do{
			int i=1;
			do{
				System.out.print( (i==1 ? "" :"+") + i);
				hap2+=i;
				i++;
			}while( i<=(10*ch1) );
			System.out.println("="+hap2);	
			hap2=0;
			ch1++;
		}while( ch1<=10 );
	
	}
}

//			for(int i=1; i<=(10*2); i++) {
//				System.out.print( (i==1 ? "" :"+") + i);
//				hap+=i;
//			}
//			System.out.println("="+hap);