package com.the703.v1;

import java.util.Scanner;

public class BankProjectV1_4 {
	public static void main(String[] args) {
		// 변수
		int num = -1; 
		int id = -1, pass=-1, balance=-1;
		Scanner scanner = new Scanner(System.in);
		// 입력
		

		
		for (;;) {			
			System.out.print("🌟💰 WELCOME TO BANK SYSTEM 💰🌟\n"
					+ "[1] ➕ 계좌 추가\n"
					+ "[2] 🔍 계좌 조회\n"
					+ "[3] 💵 입금하기\n"
					+ "[4] 💸 출금하기\n"
					+ "[5] 🗑️ 계좌 삭제\n"
					+ "[9] ⊙ 종료\n"					
					+ "👉 번호를 선택하세요: \n");
			num = scanner.nextInt();

//			System.out.println("나이 입력 : ");
//			age = scanner.nextInt();			

			// 처리 + 출력
			
			if (num == 9) { // [9] ⊙ 종료
				System.out.println("종료합니다.\n");
				break;				
			}
			if (num == 1) {
				System.out.println("추가기능입니다.\n");

				System.out.print("ID 입력 > \n"); id = scanner.nextInt();
				System.out.print("PASS 입력 > \n"); pass = scanner.nextInt();
				System.out.print("금액 입력 > \n"); balance = scanner.nextInt();
				

				
				System.out.println();				

				System.out.printf("ID는 %d, PASS는 %d, 잔액은, %d 입니다.\n",id, pass, balance);
				System.out.println();
				
			} else if (num == 2) {
				System.out.println("조회기능입니다.\n");
				// 변수
				int tid=-1, tpass=-1;

				System.out.print("ID 입력 > \n"); tid = scanner.nextInt();
				System.out.print("PASS 입력 > \n"); tpass = scanner.nextInt();
//				if ( id != tid && pass != tpass ) {System.out.println("비밀번호를 확인해주세요!"); continue;}
				// 처리 + 출력
				
				System.out.println();				

				if ( id == tid && pass == tpass ) {System.out.printf("금액은 %d 입니다.\n", balance);}
				else		   					  {System.out.println("비밀번호를 확인해주세요!");}
				System.out.println();

			} else if (num == 3) {
				System.out.println("입금기능입니다.\n");
				
				int tid = -1, tpass = -1, tbalance = -1;
				System.out.print("ID 입력 > \n"); tid = scanner.nextInt();
				System.out.print("PASS 입력 > \n"); tpass = scanner.nextInt();
				System.out.print("금액 입력 > \n"); tbalance = scanner.nextInt();
				
				balance += tbalance; 
				
				
				System.out.println();				

				if ( id == tid && pass == tpass ) {System.out.printf("ID는 %d, PASS는 %d, 금액은 %d 입니다.\n", id, pass, balance);}
				else		   					  {System.out.println("비밀번호를 확인해주세요!");}
				System.out.println();
				
			} else if (num == 4) {
				System.out.println("출금기능입니다.\n");
				
				int tid = -1, tpass = -1, tbalance = -1;
				System.out.print("ID 입력 > \n"); tid = scanner.nextInt();
				System.out.print("PASS 입력 > \n"); tpass = scanner.nextInt();
				System.out.print("금액 입력 > \n"); tbalance = scanner.nextInt();
				

				balance -= tbalance; 
				

				
				System.out.println();				

					 if	( balance<=0 )			  	   {System.out.println("잔액이 부족합니다!");}
				else if ( id == tid && pass == tpass ) {System.out.printf("ID는 %d, PASS는 %d, 금액은 %d 입니다.\n", id, pass, balance);}
				else		   					  {System.out.println("비밀번호를 확인해주세요!");}					 
				
				System.out.println();
								
			} else if (num == 5) {
				System.out.println("삭제기능입니다.\n");				

				int tid = -1, tpass = -1, tbalance = -1;
				System.out.print("ID 입력 > \n"); tid = scanner.nextInt();
				System.out.print("PASS 입력 > \n"); tpass = scanner.nextInt();

				
				System.out.println();				

				if ( id == tid && pass == tpass ) {System.out.printf("ID와 PASS를 삭제합니다.\n");}
				else		    		  	      {System.out.println("비밀번호를 확인해주세요!"); }
				
				System.out.println();
			}
		}
		
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
