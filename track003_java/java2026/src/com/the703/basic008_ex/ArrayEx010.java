package com.the703.basic008_ex;

public class ArrayEx010 {

	public static void main(String[] args) {

		int [] su = {-3, -5, -1, -9, -7} ;		
		int rank=1;
		
		for(int i=0; i<su.length; i++) {
			if(su[4]<su[i]) {	rank++;	}			
		}
		System.out.println("등수구하기 : "+rank);		
		
	}

}
//Arr1Ex007.java 등수구하기