package com.the703.basic006_ex;

public class RepeatEx002 {
	public static void main(String[] args) {
		//Q for		: 1~10까지 3의 배수의 합 : 18 , 갯수세기 : 3
		//ver-1	말로 풀어서 쓰기
		//1이 3의 배수라면 누적합 , 카운트
		//2이 3의 배수라면 누적합 , 카운트
		//3이 3의 배수라면 누적합 , 카운트
		
		//ver-2) 구조
		//if( 1이  3의 배수라면 ){ 누적합, 카운트 }
		//if( 2가  3의 배수라면 ){ 누적합, 카운트 }
		//if( 3이  3의 배수라면 ){ 누적합, 카운트 }
		
		//ver-3) 코드
		//if( 1%3==0 ){ hap += 1; cnt++;}
		//if( 2%3==0 ){ hap += 2; cnt++;}
		//if( 3%3==0 ){ hap += 3; cnt++;}		
		int hap=0, cnt=0;
		for(int i=1; i<=10; i++) { if(i%3==0) { hap += i;	cnt++; } }
		System.out.print("1~10까지 3의 배수의 누적합 : " + hap + " , 갯수 : " + cnt + "\n\n");
		
		//Q while	: 1~10까지 3의 배수의 합 : 18 
		int hap1=0;
		int i=1;
		while( i<=10 ) {
			if(i%3==0) { 
				hap1=hap1+i;
			}			
			i++;
		}
		System.out.print(hap1+"\n\n");		

		//Q do while: 1~10까지 3의 배수의 합 : 18 
		int hap2=0;
		int i1=1;
		do{
			if(i1%3==0) { 
				hap2=hap2+i1;
			}			
			i1++;
		}while( i1<=10 ); 
		System.out.print(hap2+"\n\n");		
		
//		** 시간이 남으면 도전!
//		[번외]FOR를 이용하여 다음과 같이 출력하시오.
//		1~10까지 3의 배수의 합 : 3+6+9=18
 		
		int hap3=0;
		for(int i2=1; i2<=10; i2++) {
			if(i2%3==0) { 
				hap3=hap3+i2;
//				System.out.print(i2+"+");
				System.out.print( (i2==3 ? "":"+")+i2);
			}			
		}
		System.out.print("="+hap3+"\n\n");
		
	}
}
/*
연습문제2)  for/while/do while
패키지명 : com.the703.basic006_ex;
클래스명 :  RepeatEx002
for , while , do while 3가지 버젼으로 
// Q 1~10사이에서 3의 배수의 누적합 : 18

힌트)
ver-1) 말로 풀어쓰기
	만약 1이  3의 배수의  누적합
	만약 2가  3의 배수의  누적합
	만약 3이  3의 배수의  누적합
ver-2) 구조로 바꾸기 - 제어,반복
	if(만약 1이  3의 배수의){ 누적합 }
	if(만약 2가  3의 배수의){ 누적합 }
	if(만약 3이  3의 배수의){ 누적합 }
ver-3) 코드로 풀기
	int hap=0;
	if(1%3==0){ hap+=1; }
	if(2%3==0){ hap+=2; }
	if(3%3==0){ hap+=3; }
	
** 시간이 남으면 도전!
[번외]FOR를 이용하여 다음과 같이 출력하시오.
1~10까지 3의 배수의 합 : 3+6+9=18	
*/