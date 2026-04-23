package com.the703.basic010_ex;
//- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 )
//- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
//- 문제 3. 오류가 발생하는 이유를 설명하시오.
//- 문제 4. runtime data area 위치영역 그림그리기
//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------------------------------------------------------------------------
[METHOD:정보]		LunchTray.class	MemberVarEx003.class#1)
	LunchTray.trayCount = 0; LunchTray.maxRice = 100; LunchTray.showTrayCount() LunchTray.showOwner()
------------------------------------------------------------------------------------------------------
[HEAP:동적]            															|  [STACK:지역]
2번지:LunchTray{owner=null,rice = 0,soup = 0,getFoodAmount(),showTray()}			← tray2 [2번지]
1번지:LunchTray{owner=null,rice = 90,soup = 85,getFoodAmount(),showTray()}			← tray1 [1번지]
																				main#2)
------------------------------------------------------------------------------------------------------
*/
//////////////////////////////////////////////////////
//- 문제 5. 다음과 같이 출력되도록 코드를 작성하시오.
//:: 주인 이름: std-1
//총 음식량: 175
//전체 급식판 수: 1
//
//
//:: 주인 이름: std-2
//총 음식량: 175
//전체 급식판 수: 2

class LunchTray {
	String owner;			// 인스턴스변수 - new	- heap area	   - 생성자관련 - this        
	int rice = 90;			// 인스턴스변수 - new	- heap area	   - 생성자관련 - this               
	int soup = 85;			// 인스턴스변수 - new	- heap area	   - 생성자관련 - this               
	
	static int trayCount = 0;				// 클래스변수  - static	- method area -  공용	  - 클래스명.변수
	
//	static int totalFood = rice + soup;		// 클래스변수 = 인스턴스변수 -	static은 인스턴스 변수(this) 불가
	
	static int maxRice = 100;				// 클래스변수  - static	- method area -  공용	  - 클래스명.변수
	
	public int getFoodAmount() {				// 인스턴스메서드 (static x)
		return rice + soup;         
	}
	
	public static void showTrayCount() {						// 클래스메서드 (static o)
		System.out.println("전체 급식판 수: " + trayCount);   
	}
	
	 public static void showOwner() { 						// 클래스메서드 (static o) 
//		System.out.println(owner);							// 인스턴스 변수 - this 사용불가
	}
	
	public void showTray() {									// 인스턴스메서드 (static x)
		System.out.println("\n\n:: 주인 이름: std-" + ++trayCount);                
		System.out.println("총 음식량: " + getFoodAmount());     
	}
}

public class MemberVarEx003 {
	public static void main(String[] args) {
		LunchTray tray1 = new LunchTray();   
		tray1.showTray();                    
		LunchTray.showTrayCount();         
		
		LunchTray tray2 = new LunchTray();   
		tray2.showTray();                   
		LunchTray.showTrayCount();         
	}
} 