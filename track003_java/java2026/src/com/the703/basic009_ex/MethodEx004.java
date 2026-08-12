package com.the703.basic009_ex;

import java.util.Scanner;

public class MethodEx004 {

	public static void main(String[] args) {

		/////////////////////(1)  변수
		String name  = ""; 
		int kor, eng, math, total ;
		float avg = 0.0f; 
		String pass = "";
		String jang = "";
		String star= "";  
		Scanner scanner = new Scanner(System.in);
		
		/////////////////////(2) 입력 : 이름, 국어, 영어, 수학점수를 입력받으시오.

		System.out.print("  이름 입력  > "); name = scanner.next();
		System.out.print("국어점수 입력 > "); kor = scanner.nextInt();		
		System.out.print("영어점수 입력 > "); eng = scanner.nextInt();
		System.out.print("수학점수 입력 > "); math = scanner.nextInt();
//		name = "NAME";
//		kor = 100;
//		eng = 100;
//		math =99;		
//		
		/////////////////////(3) 처리 : 
		total = process_total(kor , eng, math);    // 1. 총점처리
		
		
		avg = process_avg(total);    //2.  평균처리
		
		
		////////3.  합격  평균이60이상이고, 각각 국어, 영어, 수학40이상/불합격/재시험-각각 40미만인게 있다면  
		pass = process_pass(avg , kor, eng, math);  
		
		
		//////// 4. 평균이 95점이상이면 장학생
		jang = process_scholar(  avg  ); 
		
		
		//////// 5. 평균점수대로 별표 붙이기 , 예) 70점대이면 별7개, 80점대이면 별8개, 90점대이면 별9개 , 100점이면 별10개 
		star = process_star(avg);  
		
		
//		System.out.print(star);
		
//		::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
//			이름      국어   영어   수학   총점  평균    합격여부   장학생   랭킹
//			--------------------------------------------------------------------------------------------
//			아이언맨   100   100   100   300    100.0    합격      장학생   **********
//			--------------------------------------------------------------------------------------------
		
		/////////////////////(4) 출력
		process_show(name, kor, eng, math, total, avg, pass, jang, star);
		


		

	}
	
		public static int process_total(int kor , int eng , int math) {			
			return kor+eng+math; 
		} 
	
		public static float process_avg(int total) {			
			return total/3.0f; 
		}
	
		////////3.  합격  평균이60이상이고, 각각 국어, 영어, 수학40이상/불합격/재시험-각각 40미만인게 있다면  
		public static String process_pass(double avg , int kor , int eng , int math) {
			     if(avg>=60 && kor>=40 && eng>=40 && math>=40) { return "합격";  }
			else if(kor<40 || eng<40 || math<40)			   { return "재시험"; }
			else											   { return "불합격"; }			 
		} 
	
		public static String process_scholar(double avg) {			
			if(avg>=95) { return "장학생"; }
			else	    { return "";      }			
		} 
	
		//////// 5. 평균점수대로 별표 붙이기 , 예) 70점대이면 별7개, 80점대이면 별8개, 90점대이면 별9개 , 100점이면 별10개 
		public static String process_star(double avg) {
			String result="";
			
			for(int i=0; i<avg/10; i++) {result+="*";}
	
			return result;
		} 
	
		/*void 메서드명(name, kor, eng, math, total, avg, pass, jang, star){
		//		::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
		//			이름      국어   영어   수학   총점  평균    합격여부   장학생   랭킹
		//			--------------------------------------------------------------------------------------------
		//			아이언맨   100   100   100   300    100.0    합격      장학생   **********
		//			--------------------------------------------------------------------------------------------
}*/
		public static void process_show
		(String name, int kor, int eng, int math, int total, double avg, String pass, String jang, String star) {
			
			
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: ");
			System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹");
			System.out.println("--------------------------------------------------------------------------------------------");			
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s\n"
							  , name, kor, eng, math, total, avg, pass, jang, star);
			System.out.println("--------------------------------------------------------------------------------------------");			
		} 
	

	
	
}
/*
연습문제4)  method
패키지명 : com.the703.basic009_ex
클래스명 :  MethodEx004

public class MethodEx004{ 
   public static void main(String[] args) {
   /////////////////////(1)  변수
      String name  = ""; 
      int kor, eng, math, total ;
      float avg = 0.0f; 
      String pass = "";
      String jang = "";
      String star= "";  
      Scanner scanner = new Scanner(System.in);
      
      /////////////////////(2) 입력 : 이름, 국어, 영어, 수학점수를 입력받으시오.
   
      /////////////////////(3) 처리 : 
      total = process_total(kor , eng, math);    // 1. 총점처리
      
      avg = process_avg(total);    //2.  평균처리
      
      ////////3.  합격  평균이60이상이고, 각각 국어, 영어, 수학40이상/불합격/재시험-각각 40미만인게 있다면  
      pass = process_pass(avg , kor, eng, math);  
      
      //////// 4. 평균이 95점이상이면 장학생
      jang = process_scholar(  avg  ); 
      
      //////// 5. 평균점수대로 별표 붙이기 , 예) 70점대이면 별7개, 80점대이면 별8개, 90점대이면 별9개 , 100점이면 별10개 
      star = process_star(avg);  
      
      
      /////////////////////(4) 출력
      process_show(name, kor, eng, math, total, avg, pass, jang, star);
    
      
   }// end main
 
   
}// end class

 
      ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: 
      이름      국어   영어   수학   총점  평균    합격여부   장학생   랭킹
      --------------------------------------------------------------------------------------------
      아이언맨   100   100   100   300    100.0    합격      장학생   **********
      --------------------------------------------------------------------------------------------


*/