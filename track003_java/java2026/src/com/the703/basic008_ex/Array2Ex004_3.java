package com.the703.basic008_ex;

public class Array2Ex004_3 {
	public static void main(String[] args) {

//		#1. result 에 datas데이터 복사하기
//		#2. 가로방향누적데이터
//		#3. 세로방향데이터누적
//		#4. 총합
		
//		출력내용:
//			10   10   10   10   40   
//			20   20   20   20   80   
//			30   30   30   30   120   
//			60   60   60   60   240
		
		int[][] datas = {  {  10, 10, 10 ,10},             
						   {  20, 20, 20 ,20},     
						   {  30, 30, 30 ,30},     
		};  // 3층 4칸                                  
		
		int[][] result = new int[datas.length+1][datas[0].length+1];    
		int total=0;  double avg=0.0;
//		int ch=0, kan=0; 
				

		

		

		
		for(int ch=0; ch<datas.length+1; ch++) {
			for(int kan=0; kan<datas[ch].length+1; kan++) {							
				System.out.println(result[ch][kan]);
			}		
			System.out.println();
		}
		
				
		int [][] arr21 = new int[2][3];	

		int data=10;
		for(int ch=0; ch<arr21.length; ch++) {	//1) 배열명.length	몇층
			for (int kan = 0; kan < arr21[ch].length; kan++) {	//2) 배열명[0].length		아파트0층.칸
				arr21[ch][kan] = data;
				data += 10;
			}
			//3) 끝나고 해야할일
			System.out.println();
		}
				
		for(int ch=0; ch<arr21.length; ch++) {	// 배열의 층수 
			for(int kan=0; kan<arr21[ch].length; kan++) {	// 배열[층]의 칸수
				System.out.print(	arr21[ch][kan] + "\t");				
			}
			//2-3 한층이 끝나면 해야할일
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