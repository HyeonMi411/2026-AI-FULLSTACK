package com.the703.basic008_ex;

public class ArrayEx006 {
	public static void main(String[] args) {

		char [] ch = new char[52];
		char data1='a', data2='A';
		int cnt=0;

		for(int i=0; i<=ch.length; i++) {
			if(i>=0 && i<=25) { ch[i] = data1++; }
			if(i>=26 && i<=51) { ch[i] = data2++; }
		}		
				
		for(int i=0; i<ch.length; i++){
			if(ch[i]=='a' || ch[i]=='e'|| ch[i]=='i'|| ch[i]=='o'|| ch[i]=='u'
					|| ch[i]=='A' || ch[i]=='E'|| ch[i]=='I'|| ch[i]=='O'|| ch[i]=='U') {
				cnt++;				
			}			
		}   
		System.out.print("모음의 갯수 : " + cnt);
	
	}
}
/*
Arr1Ex003.java 모음의 갯수
      char [] ch = new char[52];   // 0~25번까지 대문자    26~51번까지 소문자
      char data1='a', data2='A';
*/