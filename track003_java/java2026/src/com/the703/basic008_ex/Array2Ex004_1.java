package com.the703.basic008_ex;

public class Array2Ex004_1 {
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
		int ch=0, kan=0; 
		
		
//		result[0][4]=datas[0][0]+datas[0][1]+datas[0][2]+datas[0][3];
//		result[1][4]=datas[1][0]+datas[1][1]+datas[1][2]+datas[1][3];
//		result[2][4]=datas[2][0]+datas[2][1]+datas[2][2]+datas[2][3];
		
		for(ch=0; ch<datas.length+1; ch++) {
			for(kan=0; kan<datas[ch].length+1; kan++) {
					 if(kan==4) { result[ch][kan]+=datas[ch][kan]; }
				else if(kan!=4) { result[ch][kan]=datas[ch][kan]; }				
			}
			System.out.printf("%d\t" , result[ch][kan]);			
			System.out.println();
		}
//		System.out.printf("%d\n" , result[0][4]);			
		
//		for(int ch=0; ch<datas.length; ch++) {
//			for(int kan=0; kan<datas[ch].length+1; kan++) {
//				result[3][kan]+=datas[ch][kan];
//			}
//		}
		
		
		/*
		
		for(int ch=0; ch<datas.length; ch++) {
			for(int kan=0; kan<datas[0].length; kan++) {
				result[ch][4]+=datas[ch][kan];
			}
//			System.out.printf("%d\n" , result[0][4]);			
		}
				
		for(int ch=0; ch<datas.length; ch++) {
			for(int kan=0; kan<datas[0].length+1; kan++) {
				result[3][kan]+=datas[ch][kan];
			}			
		}
//		System.out.print(result[3][4]);			
//		System.out.printf("%d\t" , result[3][0]);			
		
		for(int ch=0; ch<datas.length+1; ch++) {
			for(int kan=0; kan<datas[ch].length+1; kan++) {				
				System.out.printf("%d\t" , result[ch][kan]);			
			}			
		}
//		System.out.print(result[3][4]);			
		
				
		
		for(int ch=0; ch<datas.length; ch++){	
			for(int kan=0; kan< datas[ch].length+1; kan++){
				total+=datas[ch][kan-1];
				result[ch][4] = total;
			}
			System.out.printf("%d\t" , result[ch][5]);		
			
			System.out.println();			
		}
		
//		System.out.println(total);
		
		
		
		for(int ch=0; ch<datas.length+1; ch++){	
			for(int kan=0; kan< datas[ch].length+1; kan++)	
			{	result[ch][5] = datas[kan];		}
			
			System.out.println();			
		}
		
		for(int ch=0; ch<datas.length+1; ch++){	
			for(int kan=0; kan< datas[ch].length+1; kan++)	
			{	result[ch][kan] = total[ch];		}
			
			System.out.println();			
		}		
		
		for(int ch=0; ch<datas.length+1; ch++){	
			for(int kan=0; kan< datas[ch].length+1; kan++)
			{	System.out.print(result[ch][kan]+"\t");	}
			
			System.out.println();			
		}		
		
		avg = total/12.0;
		System.out.printf("%f" , avg);

	*/	
		
		
		
//		for(int ch=0; ch<datas.length+1; ch++){	
//			for(int kan=0; kan< datas[ch].length+1; kan++){
//				total+=datas[ch][kan];
//			}
//			
//			System.out.println();			
//		}
		
//		System.out.printf("총점은 : %d\n" , total);
//		System.out.printf("평균은 : %.1f" , avg);
		
//		double [] arr = new double[5];
//		double data=1.1;
//		//arr[0] = 1.1;  
//		//		arr[0] = data;   /* 1.1넣고*/ data+=0.1;  /* 0.1증가*/
//		//		arr[1] = data;   /* 1.2넣고*/ data+=0.1;  /* 0.1증가*/
//		//		arr[2] = data;   /* 1.3넣고*/ data+=0.1;  /* 0.1증가*/
//		//		arr[3] = data;   /* 1.4넣고*/ data+=0.1;  /* 0.1증가*/
//		//		arr[4] = data;   /* 1.5넣고*/ data+=0.1;  /* 0.1증가*/
//		
//		for(int i=0; i<arr.length; i++) {  arr[i] = data;    data+=0.1;         }
//		for(int i=0; i<arr.length; i++) { System.out.printf("%.1f\t" , arr[i] );}				
		
		
//		int[][] arr = {
//				{ 1, 1, 1,},
//				{ 2, 2, 2,},
//				{ 3, 3, 3,},
//				{ 4, 4, 4,},
//		};
//		int total=0;  double avg=0.0;
//		

//				
//		for(int ch=0; ch<arr.length; ch++){	
//			for(int kan=0; kan< arr[ch].length; kan++){
//				total+=arr[ch][kan];
//			}
//			
//			System.out.println();			
//		}
//		for(int ch=0; ch<arr.length; ch++){	
//			for(int kan=0; kan< arr[ch].length; kan++){
//				total+=arr[ch][kan];
//			}
//			
//			System.out.println();			
//		}
//		avg = total/12.0;
//		System.out.printf("총점은 : %d\n" , total);
//		System.out.printf("평균은 : %.1f" , avg);		
		

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