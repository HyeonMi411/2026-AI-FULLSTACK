package com.the703.basic008_ex;

public class ArrayEx013 {
	public static void main(String[] args) {
		
		int [] datas = {1,3,1,1,4,4,3,1,4,1,2} ;		
		int [] stars = new int[4];
//		int cnt1=0, cnt2=0, cnt3=0, cnt4=0;
		
		/*
		//1.해당하는 데이터가 1이라면 cnt1증가
		for(int i=0; i<datas.length; i++) {
				 if(datas[i]==1) { cnt1++; }
			else if(datas[i]==2) { cnt2++; }
			else if(datas[i]==3) { cnt3++; }
			else if(datas[i]==4) { cnt4++; }			
		}

		stars[0] = cnt1;
		stars[1] = cnt2;
		stars[2] = cnt3;
		stars[3] = cnt4;
		*/
		/*
		for(int i=0; i<datas.length; i++) {
			 if(datas[i]==1) { stars[0]++; }
		else if(datas[i]==2) { stars[1]++; }
		else if(datas[i]==3) { stars[2]++; }
		else if(datas[i]==4) { stars[3]++; }			
	}
*/
		
		for(int i=0; i<datas.length; i++) {
			 stars[datas[i]-1]++; 		
		}
		
		for(int ch=0; ch<stars.length; ch++) {
			for(int i=0; i<stars[ch]; i++) { System.out.print('★');}
			System.out.println();	
//			for(int i=0; i<stars[0]; i++) { System.out.print('★');}
//			System.out.println();	
//			for(int i=0; i<stars[1]; i++) { System.out.print('★');}
//			System.out.println();	
//			for(int i=0; i<stars[2]; i++) { System.out.print('★');}
//			System.out.println();	
//			for(int i=0; i<stars[3]; i++) { System.out.print('★');}
//			System.out.println();	
		}
		
//		for(int i=1; i<=stars[i]; i++) { System.out.print('★');}	//5
//		System.out.println();			
//		for(int i=1; i<=stars[i]; i++) { System.out.print('★');}	//1
//		System.out.println();
//		for(int i=1; i<=stars[i]; i++) { System.out.print('★');}	//2
//		System.out.println();
//		for(int i=1; i<=stars[i]; i++) { System.out.print('★');}	//3
//		System.out.println();
//		System.out.println();
//
//		for(int i=0; i<stars.length; i++) { System.out.printf("별누적 %d : %d\n" , (i+1), stars[i]); }

	}
}
//Arr1Ex010.java 별누적 