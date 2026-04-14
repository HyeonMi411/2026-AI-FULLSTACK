package com.the703.basic007_ex;

public class For2Ex011 {
	public static void main(String[] args) {
		
		// 이중 for
		int i=0, ch=0;
		int hap=0, hap2=0;
//		for(ch=1; ch<=10; ch++) {
			for(i=1; i<=10; i++) {			
				System.out.print( (i==1 ? "":"+") + i );
				hap+=i;
			}
			System.out.print( "=" + hap );
			System.out.println();
			
			for(i=1; i<=10; i++) {			
				System.out.print( (i==1 ? "":"+") + i );
				hap+=i;
			}
			System.out.print( "=" + hap );
			System.out.println();
			

//			i+=10;			
//		}		

	}
}
/*
1~10, 11~20 누적합
이중 for, 이중 while, 이중 do while 세가지 버젼으로 다음과 같이 출력하시오. 
1 + ... + 10 = 55
11 + ... + 20 = 155
21 + ... + 30 = 255
31 + ... + 40 = 355
41 + ... + 50 = 455
51 + ... + 60 = 555
61 + ... + 70 = 655
71 + ... + 80 = 755
81 + ... + 90 = 855
91 + ... + 100 = 955
*/