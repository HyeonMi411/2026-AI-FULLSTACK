package com.the703.basic009_ex;

public class MethodEx003 {

	public static void main(String[] args) {

		System.out.println("1. 내가 좋아하는 숫자    : " + return_num());    // 1을 결과값으로 줌
		System.out.println("2. 10/3.0을 실수로 표현 : " + return_float());  // 3.3333을 결과값으로 줌
		System.out.println("3. BEST COLOR        : " + mycolor());      // PURPLE을 결과값으로 줌
		System.out.println("4. 장수돌침대 별이       : " + jangsu());        // ★★★★★을 결과값으로 줌  
		System.out.println("5. 10+20= " + myadd(10,20));       // 두숫자를 더한값을 결과값으로 줌
//		public static 리턴값 메서드명(재료){해야될일}
		System.out.println("6. 반(노랑조/주황조)= " + myban('B'));  // A이면 노랑조 ,  B이면 주황조

		System.out.println("7. 당신의 학번은? " + stdId(1111));   // G하고 넣어준 학번 나오게
//		public static String stdId(int num){ return  "G"+num;}
		System.out.println("8.당신의 평균은? " + stdAvg(88));    
		// 90점이상이면 A ,  80점이상이면 B ,  70점이상이면 C , 아니라면  D

	}
	
	public static int return_num() { return 1; }				// 1.
	public static double return_float() { return 3.3333; }		// 2.
	public static String mycolor() { return "PURPLE"; }			// 3.
	public static String jangsu() { return "★★★★★"; }			// 4.
	public static int myadd(int  a, int b) { return a+b; }		// 5.
	public static String myban(char ch) {						// 6.
			 if(ch=='A') { return "노랑조"; }
		else if(ch=='B') { return "주황조"; }
		else			 { return "";      }
	}		
		
	public static String stdId(int num){ return  "G"+num;}
//	public static int stdId(int hak) { return stdId2(), hak; }			// 7.
	public static char stdAvg(double avg) {						// 8.		
		     if(avg>=90) { return 'A'; }		  
		else if(avg>=80) { return 'B'; }
		else if(avg>=70) { return 'C'; }
		else 			 { return 'D'; }						
	}

}
/*
연습문제3)  method
패키지명 : com.the703.basic009_ex
클래스명 :  MethodEx003

System.out.println("1. 내가 좋아하는 숫자    :" + return_num());    // 1을 결과값으로 줌
System.out.println("2. 10/3.0을 실수로 표현 :" + return_float());  // 3.3333을 결과값으로 줌
System.out.println("3. BEST COLOR        :" + mycolor());      // PURPLE을 결과값으로 줌
System.out.println("4. 장수돌침대 별이       :" + jangsu());        // ★★★★★을 결과값으로 줌  
System.out.println("5. 10+20= " + myadd(10,20));       // 두숫자를 더한값을 결과값으로 줌  
System.out.println("6. 반(노랑조/주황조)=" + myban('B'));  // A이면 노랑조 ,  B이면 주황조
System.out.println("7. 당신의 학번은?" + stdId(1111));   // G하고 넣어준 학번 나오게
System.out.println("8.당신의 평균은?" + stdAvg(88));    
// 90점이상이면 A ,  80점이상이면 B ,  70점이상이면 C , 아니라면  D

출력결과 :
1. 내가 좋아하는 숫자    : 1
2. 10/3.0을 실수로 표현 : 3.3333
3. BEST COLOR        : PURPLE
4. 장수돌침대 별이       : ★★★★★
5. 10+20= 30
6. 반(노랑조/주황조)= 나는 노랑조
7. 당신의 학번은? G1111
8. 당신의 평균은? B
*/