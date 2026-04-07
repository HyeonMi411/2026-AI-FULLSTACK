package com.the703.days;

import java.util.Scanner;

public class Day008 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int kor=-1, eng=-1, mat=-1, total=-1;
		String stdid="", pass="", level="", jang="";
		double avg=-1;
		
//		System.out.print("학번 입력 > "); stdid = scanner.next();
//		System.out.print("국어점수 입력 > "); kor = scanner.nextInt();
//		System.out.print("국어점수 입력 > "); eng = scanner.nextInt();
//		System.out.print("국어점수 입력 > "); mat = scanner.nextInt();
		
		/*============================================================*/
		
//		   국어점수는 0~100 사이만 입력받게
//		   영어점수는 0~100 사이만 입력받게
//		   수학점수는 0~100 사이만 입력받게
//
//		   학번 입력 > std111
//		   국어점수 입력 > 100
//		   수학점수 입력 > 100
//		   영어점수 입력 > 99		
		
		for(;;) {
//			if( kor>=0 && kor<=100 ) { System.out.print("국어점수 입력 > "); kor = scanner.nextInt(); }
//			else if( eng>=0 && eng<=100 ) { System.out.print("국어점수 입력 > "); eng = scanner.nextInt(); }
//			else if( mat<0 && mat>100 ) {}
			
			
			
			if( kor<0 && kor>100 && eng<0 && eng>100 && mat<0 && mat>100 ) {				
				 System.out.println("점수를 다시 입력해 주세요."); 			
			}
			else {
				System.out.print("학번 입력 > "); stdid = scanner.next();
				System.out.print("국어점수 입력 > "); kor = scanner.nextInt();
				System.out.print("영어점수 입력 > "); eng = scanner.nextInt();
				System.out.print("수학점수 입력 > "); mat = scanner.nextInt();				
				break;
			}
		}
		
		/*============================================================*/		
				
		total = kor + eng + mat;
		avg = total/3.0;
		
//		pass=avg<60"불합격"; ? avg <= 60	&&	kor >= 40	&&	eng >= 40 &&	mat >= 40 : pass="합격"; 
		
		if(avg >= 60	&&	kor >= 40	&&	eng >= 40 &&	mat >= 40	) 
			 { pass="합격";	}
		else { pass="불합격"; }
		
		jang = avg >=95 ? "장학생" : ""; 
		
//		if(avg >=95) { jang="장학생"; }
		
		level = avg >= 90 ? "수"
			:	avg >= 90 ? "우"
			:	avg >= 90 ? "미"
			:	avg >= 90 ? "양" : "가";			
		
		System.out.println("====================================================================");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생");
		System.out.println("====================================================================");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s"
				,stdid,kor,eng,mat,total,avg,pass,level,jang);		
		


//		   1. 총점 구하기
//		   2. 평균 구하기
//		   3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
//		   4. 평균이 95점이상이면 장학생
//		   5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 
//
//		   학번 입력 > std111
//		   국어점수 입력 > 100
//		   수학점수 입력 > 100
//		   영어점수 입력 > 99
//		   ======================================================== 
//		   학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생
//		   ======================================================== 
//		   std111   100   100   99   299   99.67   합격   수   장학생

	}

}
/*
3. 필수조건
q1-1 int형 변수 x가 60이상일때 조건식  
int x;
if( x>=60 ){}
q1-2 char형 변수 ch가 'a' 또는 'A'일때   true인 조건식
char ch;
if( ch == 'a' || ch == 'A' ){ System.out.println("true"); }     
q1-3 char형 변수 ch가 숫자('0'~'9')일때   조건식      
char ch;
if( ch >= '0' && ch <= '9' ){}
q1-4 char형 변수 ch가 영문자(대문자) 일때    조건식
char ch;
if ( ch >= 'A' && ch <= 'Z' ){} 


4.  eclipse 열어서 작성해주세요! [20분]
```
   패키지명 : com.the703.days
   클래스명 :  Day008
   출력내용 :  성적처리 프로그램입니다.
   1. 총점 구하기
   2. 평균 구하기
   3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
   4. 평균이 95점이상이면 장학생
   5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 

   학번 입력 > std111
   국어점수 입력 > 100
   수학점수 입력 > 100
   영어점수 입력 > 99
   ======================================================== 
   학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생
   ======================================================== 
   std111   100   100   99   299   99.67   합격   수   장학생

*/