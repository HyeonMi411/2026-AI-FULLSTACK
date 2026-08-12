package com.the703.basic008_ex;

public class ArrayEx009 {

	public static void main(String[] args) {

		int [] su = {-3, 5, -1, 9, -7, 2, -11} ;		
		int hap=0;
		
		for(int i=0; i<su.length; i++) {
			if(su[i]>0 && su[i] % 2 == 1 ) {
				hap+=su[i];					
			}		
		}
		System.out.println("양수중에서 홀수의 합 : "+hap);		

	}

}
//Arr1Ex006.java 양수중에서 홀수의 합