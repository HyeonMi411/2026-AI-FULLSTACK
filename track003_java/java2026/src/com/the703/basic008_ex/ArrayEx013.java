package com.the703.basic008_ex;

public class ArrayEx013 {

	public static void main(String[] args) {
		
		int [] datas = {1,3,1,1,4,4,3,1,4,1,2} ;		
		int [] stars = new int[4];
		int cnt=0;
				
		for(int i=1; i<datas.length; i++) {		
			if(i = datas[i]) {
				stars[i]++;				
			}
//			stars[i] += datas[i];					
			System.out.println("별누적 : "+stars[i]);			
		}


	}

}
//Arr1Ex010.java 별누적 