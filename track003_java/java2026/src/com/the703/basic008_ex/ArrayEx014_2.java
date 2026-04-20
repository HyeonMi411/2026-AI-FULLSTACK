package com.the703.basic008_ex;

public class ArrayEx014_2 {

	public static void main(String[] args) {

		String[] name={"아이언맨","헐크","캡틴","토르","호크아이"};	
		int[] kor={100,20,90,70,35};	
		int[] eng={100,50,95,80,100};	
		int[] mat={100,30,90,60,100};
		int[] avg=new int[5];	
		int[] rank=new int[5];
		String[] pass=new String[5];
		String[] jang=new String[5];		
		int[] stars=new int[5];	
		String[] result=new String[5];		// ■
		
		// 평균 구하기 
		for(int i=0; i<name.length; i++) {
			avg[i] = (kor[i]+eng[i]+mat[i])/3;			
//			System.out.printf("%d\n" , avg[i] );
		}
		
		// 등수 구하기
		for(int ch=0; ch<name.length; ch++) {
			for(int i=0; i<name.length; i++) {			
				if(avg[ch]<avg[i]) { rank[ch]++; }			
			}			
//			System.out.printf("%d\n" , (rank[ch]+1) );
		}
		
		// 합격여부 구하기  
		for(int i=0; i<name.length; i++) {			
			pass[i] = avg[i] > 60 ? "합격" : "불합격";			
//			System.out.printf("%s\n" , pass[i] );
		}
		
		// 장학생 구하기 
		for(int i=0; i<name.length; i++) {			
			jang[i] = avg[i] > 95 ? "장학생" : "";			
//			System.out.printf("%s\n" , jang[i] );
		}
		
		// 랭킹 구하기
//		public static String process_star(double avg) {
//		String result="";
//		
//		for(int i=0; i<avg/10; i++) {result+="*";}
//		
//		
//		return result;
//		} 	
		
		for(int i=0; i<avg/10; i++) {
			result[i]+="★";
//			System.out.printf("%s\n" , result[i] );
		}
		
		
		
		
		
		//========================================================================================
		
		// 랭킹 구하기 		
//		for(int i=0; i<name.length; i++) {
//			stars[i] = avg[i]/10;	
//			System.out.printf("%d\n" , stars[i]);					
//		}
//		
//		
//		for(int ch=0; ch<name.length; ch++) {
//			for(int i=0; i<stars[ch]; i++) {
//				System.out.printf("%s" , '★');
//			}			
//			System.out.println();				
//		}
//		
//				
//		System.out.println("이름\t국어\t영어\t수학\t평균\t등수\t합격여부\t장학생\t랭킹");
//		for(int i=0; i<name.length; i++) {
//			System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%s\t%s\t%s\n"
//					,name[i],kor[i],eng[i],mat[i],avg[i],rank[i]+1,pass[i],jang[i],
//					
//					'★'
//							
//							
//							);			
//		}
		
	}
}
/*
이름		국어		영어		수학		평균		등수		합격여부	장학생	랭킹
아이언맨	100		100		100		100		1		합격		장학생	★★★★★★★★★★		
헐크		20		50		30		33		5		불합격			★★★
캡틴		90		95		90		91		2		합격				★★★★★★★★★
토르		70		80		60		70		4		합격				★★★★★★★
호크아이	35		100		100		78		3		합격				★★★★★★★
*/