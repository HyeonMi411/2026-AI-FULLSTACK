package com.the703.basic007;

public class For2Ex002 {

	public static void main(String[] args) {
		//ver-1 눈에 보이는 그대로 
		System.out.print('@'); System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.println();
		System.out.print('#'); System.out.print('@'); System.out.print('#'); System.out.print('#'); System.out.println();
		System.out.print('#'); System.out.print('#'); System.out.print('@'); System.out.print('#'); System.out.println();
		System.out.print('#'); System.out.print('#'); System.out.print('#'); System.out.print('@'); System.out.println();
		
		//ver-2 각칸정리
		System.out.println();	//	4번출력 - 첫번째 자리에 오면 @
		for(int kan=1; kan<=4; kan++) { System.out.print( kan==1 ? '@':"#" );  }	//System.out.println();
		System.out.println();	//	4번출력 - 2번째 자리에 오면 @
		for(int kan=1; kan<=4; kan++) { System.out.print( kan==2 ? '@':"#" );  }	//System.out.println();
		System.out.println();	//	4번출력 - 3번째 자리에 오면 @
		for(int kan=1; kan<=4; kan++) { System.out.print( kan==3 ? '@':"#" );  }	//System.out.println();
		System.out.println();	//	4번출력 - 4번째 자리에 오면 @
		for(int kan=1; kan<=4; kan++) { System.out.print( kan==4 ? '@':"#" );  }	System.out.println();
		
		//ver-3 각층정리		
		System.out.println();
		for(int ch=1; ch<=4; ch++) {
			for(int kan=1; kan<=4; kan++) { System.out.print( kan==ch ? '@':"#" );  }	System.out.println();			
		}		
		
	}
}
/*

패키지명 : ccom.the703.basic007
클래스명 :  For2Ex002   (이중for 이용)

@###
#@##
##@#
###@

*/