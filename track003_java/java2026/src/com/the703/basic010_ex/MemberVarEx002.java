package com.the703.basic010_ex;
//-- class Student 작성해주세요
//- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 )
//- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
//- 문제 3. 오류가 발생하는 이유를 설명하시오.
//- 문제 4. runtime data area 위치영역 그림그리기
//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
---------------------------------------------------------------------------------------------------
[METHOD:정보]		Student.class	MemberVarEx002.class#1)
	Student.studentCount = 0; Student.maxScore = 100; Student.showStudentCount() Student.showName()
---------------------------------------------------------------------------------------------------
[HEAP:동적]            														|  [STACK:지역]
2번지:Student{name=  null,kor= 0,eng= 0,getTotalScore(),showInfo()}			← s2 [2번지]
1번지:Student{name="홍길동",kor=90,eng=85,getTotalScore(),showInfo()}			← s1 [1번지]
																			main#2)
---------------------------------------------------------------------------------------------------
 */
//////////////////////////////////////////////////////
class Student {
	String name = "홍길동";			// 인스턴스변수 - new	- heap area	   - 생성자관련 - this
	int kor = 90;					// 인스턴스변수 - new	- heap area	   - 생성자관련 - this
	int eng = 85;					// 인스턴스변수 - new	- heap area	   - 생성자관련 - this
	static int studentCount = 0;			// 클래스변수  - static	- method area -  공용	  - 클래스명.변수
	
//	static int total = kor + eng;		// 클래스변수 = 인스턴스변수 -	static은 인스턴스 변수(this) 불가
	
	static int maxScore = 100;		// 클래스변수  - static	- method area -  공용	  - 클래스명.변수
	
	public Student() {			// 인스턴스메서드 (static x)
		studentCount++;             
	}
	
	public int getTotalScore() {			// 인스턴스메서드 (static x)
		return kor + eng;        
	}
	
	public static void showStudentCount() {			// 클래스메서드 (static o)
		System.out.println("전체 학생 수: " + studentCount);  
	}
	
	public static void showName() {			// 클래스메서드 (static o)
//		System.out.println(name);			// 인스턴스 변수 - this 사용불가
	}
	
	public void showInfo() {			// 인스턴스메서드 (static x)
		System.out.println("이름: " + name);            
		System.out.println("총점: " + getTotalScore());    
	}
}

public class MemberVarEx002 {
	public static void main(String[] args) {
		Student s1 = new Student();     
		Student s2 = new Student();     
		
		s1.showInfo();                  
		Student.showStudentCount();    
	}
}