package com.the703.basic008_ex;

import java.util.Arrays;

public class ArrayNewEx001_1 {

	public static void main(String[] args) {
		
		int [] arr = new int[4];	// new 공간빌리기 int 형태의 자료형 몇개	★ new 값 X
		
		int data = 0;
		for(int i=0; i<arr.length; i++){arr[2] = data;		data+=0.1;}
		for(int i=0; i<arr.length; i++){	System.out.print( arr[0] + "\t" );	}
		
//		for(int i=0; i<arr.length; i++){	System.out.print( arr[i] + "\t" );	}

		
	
//		int [] arr= {1,2,3};	//arr 주소담을수 있어!		
//		int [] arr2 = new int[3];	// new 공간빌리기 int 형태의 자료형 몇개	★ new 값 X
//		System.out.println(arr2);
//		System.out.println(Arrays.toString(arr2));
					
		// for + length 대입		
		//ver-1 arr2[0] = 0;		arr2[1] = 10;		arr2[2] = 20;
		//ver-2
//		int data = 0;
//		arr2[0] = data;	/* 0넣고 */		data+=10;	/* 10증가 */
//		arr2[1] = data; /* 10넣고 */		data+=10;	/* 10증가 */
//		arr2[2] = data;	/* 20넣고 */		data+=10;	/* 10증가 */
		// ver-3		
//		int data = 0;
//		for(int i=0; i<arr2.length; i++){arr2[2] = data;		data+=10;}
//		for(int i=0; i<arr2.length; i++){	System.out.print( arr2[0] + "\t" );	}		
		
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
