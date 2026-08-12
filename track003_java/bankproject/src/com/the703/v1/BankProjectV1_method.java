package com.the703.v1;

import java.util.Arrays;
import java.util.Scanner;

public class BankProjectV1_method {
	
	public static void main(String[] args) {
//		- Bank ver3 :  method 메서드
	

//		※ 옵션
//		변수                          		0   1    2
		String []id=new String[3];       //  one two three
		String []pass = new String[3];   // 1111 2222 3333
		double []balance = new double[3];// 0 0 0   
		int menu = -1;  
		int find = -1;
//		int id = -1, pass = -1, balance = -1;
		Scanner scanner = new Scanner(System.in);	
				
		// 입력 // 처리 // 출력
		// for( ;menu!=9; ) {
		while (menu != 9) {	
	        System.out.println(   Arrays.toString(id)   );  // 현재상태확인
	        System.out.println(   Arrays.toString(balance)   ); 			
			System.out.print("\n\n🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n" + "[1] ➕ 계좌 추가\n" + "[2] 🔍 계좌 조회\n"
					+ "[3] 💵 입금하기\n" + "[4] 💸 출금하기\n" + "[5] 🗑️ 계좌 삭제\n" + "[9] ⊙ 종료\r\n" + "👉 번호를 선택하세요: \n");
			menu = scanner.nextInt();

			// 처리 + 출력

			if (menu == 9) { // [9] ⊙ 종료
				bank_end();
				break;
			} else if (menu == 1) {				
				bank_add();				
			} else if (menu >= 2 && menu <= 5) {
//			 	2-1. 사용자가 맞는지 여부
				String tempid = "", temppass = "";
				System.out.print("ID 입력 > \n");
				tempid = scanner.next();
				System.out.print("PASS 입력 > \n");
				temppass = scanner.next();
				
				// id[0]이 입력받은 tempid랑 다르거나 pass[0]이 입력받은 temppass랑 다르면 정보확인해주세요 출력후 한번 skip 함
				// if(id[0]이 입력받은 tempid랑 다르거나 pass[0]이 입력받은 temppass랑 다르면){ 정보확인해주세요 출력}후 한번 skip 함
				// if(   !(id[0]이 입력받은 tempid랑 같아야하고 pass[0]이 입력받은 temppass랑 같으면)  ){ 정보확인해주세요 출력}후 한번 skip 함
				// if(   !(id[0]이 입력받은 tempid랑 같아야하고 pass[0]이 입력받은 temppass랑 같으면)  ){ 정보확인해주세요 출력}후 한번 skip 함
				
//				for(int i=0; i<id.length; i++) {
					if (!(id[find].equals(tempid) && pass[find].equals(temppass)) ) {
//						if (!id[find].equals(tempid) || !pass[find].equals(temppass) ) {
						System.out.println("정보확인해주세요.");
						continue;
					} // 아이디 다르거나 비번이 다르다면					

//					2-2. 조회면 조회기능, 입력이면 사용자에게 입력받아서 입금, 출금이면 출금금액받아서 출금, 계좌삭제라면 y,n 입력받아서 계좌삭제

					switch (menu) {
					case 2:
						bank_che();
						break;
					case 3:
						bank_dep();
						break;
					case 4:
						bank_wit();
						break;
					case 5:
						bank_del();
						break;
					} // end switch				
//				} // end for 
			} // end  else if
		} // end while		
	}	
	
	public static void bank_add(String id, double balance) {		
		System.out.println("[1] ➕ 계좌 추가 \n");
		
		for(int i=0; i<id.length; i++){
			if(balance [i]==0){ find=i; break; } 
		} 
		if(find == -1) { System.out.println("가입불가!"); continue; }				    	
		
		System.out.print("ID 입력 > \n"); id[find] = scanner.next();
		System.out.print("PASS 입력 > \n"); pass[find] = scanner.next();
		System.out.print("금액 입력 > \n"); balance[find] = scanner.nextDouble();		
	}
	
	public static void bank_che(String[] args) {
		System.out.printf("ID : %s\nPASS: %s\nBALANCE: %f\n", id[find], pass[find], balance[find]);		
	}
	
	public static void bank_dep(String[] args) {
		System.out.print("입금할 금액 > ");
		balance[find] += scanner.nextInt();		
	}
	
	public static void bank_wit(String[] args) {
		System.out.print("출금할 금액 > ");
		int tempbalance = scanner.nextInt();					
		System.out.print(tempbalance > balance[find] ? "잔액부족! 출금불가" : "출금완료! 현재잔액 : " + (balance[find] -= tempbalance));		
	}
	
	public static void bank_del(String[] args) {
		System.out.print("계좌삭제 (Y/N) > ");
		char again = scanner.next().charAt(0);
		if (again == 'Y' || again == 'y') {
			id[find] = "";
			pass[find] = "";
			;
			balance[find] = -1;
		}		
	}
	
	public static void bank_end() {
		System.out.println("프로그램을 종료합니다.\n");		
	}
		
}
/*
Q1. 메뉴판나오게 만들고 사용자가 메뉴 선택시
      1을 입력하면 추가기능입니다. 출력구문까지만
      2를 입력하면 조회기능입니다. 출력구문까지만
      3을 입력하면 입금기능입니다. 출력구문까지만
      4를 입력하면 출금기능입니다. 출력구문까지만
      5를 입력하면 삭제기능입니다. 출력구문까지만
      9를 입력하면 종료합니다.    출력구문까지만

Q2. 무한반복으로 메뉴나오게, 9 나오면 종료
   ■ 힌트
   for(;;) { 
      System.out.println("숫자1을 입력하세요.");
      int a = scanner.nextInt();
      if(a == 1) { break;}
   }

🌟💰 WELCOME TO BANK SYSTEM 💰🌟

[1] ➕ 계좌 추가
[2] 🔍 계좌 조회
[3] 💵 입금하기
[4] 💸 출금하기
[5] 🗑️ 계좌 삭제  

👉 번호를 선택하세요:   

* ver-1
-	조건문 : if , switch
-	반복문 : for(시작; 종료; 변화), while(조건), do while(한번은 무조건실행 맨끝에 조건) 

무한반복(종료 9){
	0. 메뉴판입력
	🌟💰 WELCOME TO BANK SYSTEM 💰🌟
	[1] ➕ 계좌 추가 [2] 🔍 계좌 조회 [3] 💵 입금하기 [4] 💸 출금하기 [5] 🗑️ 계좌 삭제
	👉 번호를 선택하세요:
	
	1. [1] ➕ 계좌 추가
	2. [2~5]
	 	2-1. 사용자가 맞는지 여부
	 	2-2. 조회면 조회기능, 입력이면 사용자에게 입력받아서 입금, 출금이면 출금금액받아서 출금, 계좌삭제라면 y,n 입력받아서 계좌삭제
	3. [9] 종료	
}

while( menu !=9 ){
	0. 메뉴판입력
	🌟💰 WELCOME TO BANK SYSTEM 💰🌟
	[1] ➕ 계좌 추가 [2] 🔍 계좌 조회 [3] 💵 입금하기 [4] 💸 출금하기 [5] 🗑️ 계좌 삭제
	👉 번호를 선택하세요:
	
		
	if(menu==9){ [9] 종료문구 }
	else if(menu==1){ [1] ➕ 계좌 추가 }
	else{ [2~5]
	 	2-1. 사용자가 맞는지 여부
	 	임시 아이디입력받기 > 
	 	임시 비밀번호 입력받기 >
	 	저장되어 있는 아이디와 임시 아이디가 같고 저장되어 있는 비번과 임시 비번이 같으면 아래 내용 처리
	 	2-2. 조회면 조회기능, 입력이면 사용자에게 입력받아서 입금, 출금이면 출금금액받아서 출금, 계좌삭제라면 y,n 입력받아서 계좌삭제
	 	switch( menu ){
	 		case 2 : 조회처리		break;
	 		case 3 : 입금받기 / 잔액에 입금받은돈 추가										break;
	 		case 4 : 출금받기 / 잔액에 출금받은돈 빼기 (마이너스 통장 x , 잔액없으면 출금안되게)	break;
	 		case 5 : 계좌삭제여부 ,Y, y를 입력받으면 계좌삭제	break;
	 	}	 
	}	
}
*/
