package com.the703.basic006_ex;

public class RepeatEx004 {

	public static void main(String[] args) {
//		for 버젼으로 
		int cnt=0;
		for(char a = 'A'; a<='Z'; a++) {
			if(cnt%5==0) {
				System.out.print("\n");				
			}
			cnt++;
			System.out.print(a);
		}
		System.out.println();
		
//		while 버젼으로 
		int cnt1=0;
		char a = 'A';
		while( a<='Z' ) {
			if(cnt1%5==0) {
				System.out.print("\n");				
			}
			cnt1++;
			System.out.print(a);
			a++;
		}
		System.out.println();
		
//		do while 버젼으로 
		int cnt2=0;
		char a1 = 'A';
		do{
			if(cnt2%5==0) {
				System.out.print("\n");				
			}
			cnt2++;
			System.out.print(a1);
			a1++;
		}while( a1<='Z' );
		System.out.println();
		
	}
}
/*
## RepeatEx004번으로 작성해주세요~~!  for/while/do while 버젼으로 
A~Z까지 다음과 같이 출력하시오.

*힌트1)
System.out.println('A');//1
System.out.println('B');//2
System.out.println('C');//3
System.out.println('D');//4
System.out.println('E');//5 번째마다 줄바꿈
System.out.println();

*힌트2)
for(char a= 'A';a<='Z';a++){
// 5번째 마다 줄바꿈
}

*/