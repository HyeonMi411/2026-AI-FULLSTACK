package com.the703.basic008_ex;

public class Array2Ex004 {
	public static void main(String[] args) {

		int[][] datas = {  {  10, 10, 10 ,10},             
				{  20, 20, 20 ,20},     
				{  30, 30, 30 ,30},     
		};  // 3층 4칸                                  

		int[][] result = new int[datas.length+1][datas[0].length+1];    

		// #1. result 에 datas데이터 복사하기
		// #2. 가로방향누적데이터
		// #3. 세로방향데이터누적
		
		for(int ch=0; ch<datas.length; ch++) {
			for(int kan=0; kan<datas[0].length+1; kan++) {
				if(kan<datas[0].length) {
					result[ch][kan] = datas[ch][kan];
					result[ch][datas[ch].length] += result[ch][kan];					
				}
				result[datas.length][kan] += result[ch][kan];

			}			
			System.out.println();
		}		
				
		// #4. 총합
		
		for(int ch=0; ch<datas.length+1; ch++) {
			for(int kan=0; kan<datas[0].length+1; kan++) {
				System.out.printf( "%d\t" , result[ch][kan] );		
			}			
			System.out.println();
		}	

	}
}
/*
연습문제4)  array
패키지명 : ccom.the703.basic008_ex
클래스명 :  Array2Ex004
배열을 이용하여 다음의 프로그램을 작성하시오.   
1. 다음의 주어진조건을 이용하여 총점과 평균을 구하시오.

int[][] datas = {  {  10, 10, 10 ,10},             
                  {  20, 20, 20 ,20},     
                  {  30, 30, 30 ,30},     
};  // 3층 4칸                                  
                               
int[][] result = new int[datas.length+1][datas[0].length+1];    

#1. result 에 datas데이터 복사하기
#2. 가로방향누적데이터
#3. 세로방향데이터누적
#4. 총합

출력내용:
10   10   10   10   40   
20   20   20   20   80   
30   30   30   30   120   
60   60   60   60   240   

*/