package com.the703.basic008_ex;

public class ArrayEx014_1 {

	public static void main(String[] args) {

		String[] name={"아이언맨","헐크","캡틴","토르","호크아이"};	
		int[] kor={100,20,90,70,35};	
		int[] eng={100,50,95,80,100};	
		int[] mat={100,30,90,60,100};
		int[] avg=new int[5];			
		String[] pass= {"불합격","불합격","불합격","불합격","불합격"};
//		String[] pass=new String[5];
		String[] jang=new String[5];		
		
		
		
//		System.out.println("이름\t국어\t영어\t수학\t평균\t등수\t합격여부\t장학생\t랭킹");
//		System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%s\t%s\t%s"
//							,name[],kor[],eng[],mat[],avg[],rank[],pass[],jang[],stars[]);


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