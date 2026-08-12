package com.the703.basic006_ex;

public class ForEx004 {

	public static void main(String[] args) {
				
		//ver-1 만약 1이 3의 배수라면 갯수 세기
		//ver-2 if(1이 3의 배수라면){ 갯수 세기}
		//ver-3 if(1%3==0){ count++;}
		//ver-3 if(2%3==0){ count++;}	
		//ver-3 if(3%3==0){ count++;}		
		
		int count=0;

		for(int i=1; i<=10; i++) {
			if(i%3==0) {
				count++;
			}				
		}			
		System.out.println("갯수 : "+count+"개");					

	}
}
/*
연습문제4)  
패키지명 : com.company.java005_ex
클래스명 :  ForEx004
출력내용 :   for 이용
1~10까지 3의 배수 갯수를 출력   

upgrade)  시간나면 도전!
3의배수 : 3,6,9    
갯수 : 3개
*/