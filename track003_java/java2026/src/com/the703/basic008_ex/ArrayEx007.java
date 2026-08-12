package com.the703.basic008_ex;

public class ArrayEx007 {

	public static void main(String[] args) {

		char [] ch = {'B' , 'a' , 'n' , 'a', 'n' , 'a'} ;
		String str = new String(ch);
				
		for(int i=0; i<ch.length; i++) {
			if(ch[i]>='A' && ch[i]<='Z' ) {
				ch[i] += 32;				
			}else if(ch[i]>='a' && ch[i]<='z' ) {
				ch[i] -= 32;								
			}			
			System.out.print(ch[i]+"\t");
		}
			
	}
}
//Arr1Ex004.java 대소문자 바꿔서 출력