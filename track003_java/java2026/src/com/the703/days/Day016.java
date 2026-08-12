package com.the703.days;

public class Day016 {
	public static void main(String[] args) {

		//		1. new 연산자 이용하여 다차원배열만들기
		//		2. for + length 이용해서 대입   
		//		3. for + length 이용해서 출력 
		//		   101   102   103
		//		   104   105   106
		
		int[][] arr2 = new int[2][3];
		int data=101;
		
		for(int ch=0; ch<arr2.length; ch++) {
			for(int kan=0; kan<arr2[ch].length; kan++) {
				arr2[ch][kan] = data++;						
			}			
		}
		
		for(int ch=0; ch<arr2.length; ch++) {
			for(int kan=0; kan<arr2[ch].length; kan++) {				
				System.out.printf("%d\t" , arr2[ch][kan]);
			}			
			System.out.println();
		}
		
	}
}
/*
■2. java (5분)

1. new 연산자 이용하여 다차원배열만들기
2. for + length 이용해서 대입   
3. for + length 이용해서 출력 
   101   102   103
   104   105   106
*/