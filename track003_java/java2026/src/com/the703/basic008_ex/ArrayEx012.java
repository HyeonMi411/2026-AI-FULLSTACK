package com.the703.basic008_ex;

public class ArrayEx012 {

	public static void main(String[] args) {
		
		int [] arr = {10, 20, 30, 40, 50} ;		
		int box=0;
		
		for(int i=0; i<arr.length; i++) {			
				box+=arr[i];					
			
		}
		System.out.println("누적합 : "+box);			
		

	}

}
//Arr1Ex009.java 누적합 