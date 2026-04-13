package com.the703.basic008_ex;

import java.util.Arrays;

public class ArrayNewEx001 {

	public static void main(String[] args) {
		
		double [] arr = new double[5];	// new 공간빌리기 int 형태의 자료형 몇개	★ new 값 X
		double data = 1.1;
		arr[0] = data;		/* 1.1넣고	*/ data+=0.1;	/* 0.1증가	*/
		for(int i=0; i<arr.length; i++){
			data+=0.1;
			System.out.printf("%.1f\t" , arr[i]);				
		}	
		
//		double [] arr= new double[5];
//		double data=1.1;
		//arr[0] = 1.1;
//		arr[0] = data;		/* 1.1넣고	*/ data+=0.1;	/* 0.1증가	*/
		
//		for(int i=0; i<arr.length; i++){
//			data+=0.1;
//			System.out.printf("%.1f\t" , arr[i]);				
//		}	

		

		
	}

}
/*
연습문제6)  array
패키지명 : com.company.java007_ex
클래스명 :  ArrayNewEx001
    new 연산자 이용해서 배열만들기
    1. 배열명 : arr     
    2. 값 넣기 : 1.1  , 1.2  , 1.3  , 1.4  , 1.5    
       for+length 이용해보기
    3. for + length 로 출력

*/
