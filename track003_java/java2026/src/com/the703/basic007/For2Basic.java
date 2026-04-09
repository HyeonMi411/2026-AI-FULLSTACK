package com.the703.basic007;

		//	123
		//	123
public class For2Basic {	
	public static void main(String[] args) {
		//ver-1
		System.out.println(1 + "층");
		System.out.print(1); System.out.print(2); System.out.print(3); System.out.println();
		
		
		System.out.println(2 + "층");
		System.out.print(1); System.out.print(2); System.out.print(3); System.out.println();
		
		//ver-2 각칸정리 for 정리	{영역}	{변수}	for(시작;종료;변화)
		System.out.println();
		System.out.println(1 + "층");
		for(int kan=1; kan<=3; kan++){ System.out.print(kan); } System.out.println();
		
		System.out.println(2 + "층");
		for(int kan=1; kan<=3; kan++){ System.out.print(kan); } System.out.println();		
		
		//ver-2 각층정리 for 정리
		for(int ch=1; ch<=2; ch++)
		{
			System.out.println(ch + "층");
			for(int kan=1; kan<=3; kan++){ System.out.print(kan); } System.out.println();			
		}
		
		//================================================================================
		
		System.out.println();
		System.out.println("1234");
		System.out.println("1234");
		System.out.println("1234");
		System.out.println("1234");
		System.out.println();	
		
		for(int a=1;a<=4;a++) {
			for(int i=1;i<=4;i++) {
				System.out.print(i); 
			}
			System.out.println();			
		}
		System.out.println();
		
		int a=1;		
		while(a<=4) {
			int i=1;
			while(i<=4) {
				System.out.print(i);
				i++;
			}
			System.out.println();
			a++;
		}
		System.out.println();
		
		int a1=1;		
		do{
			int i=1;
			do{
				System.out.print(i); 
				i++;
			}while(i<=4);
			System.out.println();
			a1++;
		}while(a1<=4);
		
	}
}
/*
1234
1234
1234
1234
*/