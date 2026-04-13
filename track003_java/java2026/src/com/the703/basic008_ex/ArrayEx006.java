package com.the703.basic008_ex;

public class ArrayEx006 {

	public static void main(String[] args) {
		
//		String [] alpha = new String[51];	// 52 : 0~51		
		String [] strArr = new String[52];
		int cnt=0;
		
		for(int i=0; i<strArr.length; i++) {
			if(strArr[i]=='a' || strArr[i]=='e' || strArr[i]=='i' || strArr[i]=='o' || strArr[i]=='u' 
					|| strArr[i]=='A' || strArr[i]=='E' || strArr[i]=='I' || strArr[i]=='O' || strArr[i]=='U') {
				cnt++;
				
			}
			System.out.println(strArr[i]);
			
//			strArr[] = i % 2 == 0 ? strArr[i].toLowerCase() : strArr[i].toLowerCase();

		}
		
		
//		char [] ch = {'B' , 'a' , 'n' , 'a', 'n' , 'a'} ;
//		String str = new String(ch);
//				
//		for(int i=0; i<ch.length; i++) {
//			if(ch[i]>='A' && ch[i]<='Z' ) {
//				ch[i] += 32;				
//			}else if(ch[i]>='a' && ch[i]<='z' ) {
//				ch[i] -= 32;								
//			}			
//			System.out.print(ch[i]+"\t");
//		}		

	}
}
/*
Arr1Ex003.java 모음의 갯수

*/