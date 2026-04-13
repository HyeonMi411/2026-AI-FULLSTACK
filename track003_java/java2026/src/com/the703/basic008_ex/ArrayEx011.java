package com.the703.basic008_ex;

public class ArrayEx011 {

	public static void main(String[] args) {

		int [] su = {-3, -5, -1, -9, -7} ;		
		int max=-99999, min=99999;
		
		for(int i=0; i<su.length; i++) {
			if(max<su[i]) {
				max = su[i];				
			}
			if(min>su[i]) {
				min = su[i];				
			}			
		}
		System.out.println("최대값 : "+max);			
		System.out.println("최소값 : "+min);	

	}

}
//Arr1Ex008.java 최대값 최소값 구하기 