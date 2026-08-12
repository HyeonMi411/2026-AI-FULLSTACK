package com.the703.basic014_ex;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Objects;

public class BookDto{
	private String title;
	private String author;
	
	public BookDto() { super(); }
	public BookDto(String title, String author) { super(); this.title = title; this.author = author; }
	@Override public String toString() { return "BookDto [title=" + title + ", author=" + author + "]"; }
	
	@Override public int hashCode() { return Objects.hash(author, title); }
	@Override public boolean equals(Object obj) { if (this == obj) return true; if (obj == null) return false; if (getClass() != obj.getClass()) return false; BookDto other = (BookDto) obj; return Objects.equals(author, other.author) && Objects.equals(title, other.title); }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }
		
}

public class MapEx003 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Map<String, BookDto>> library = new HashMap<>();  
//		- 첫 번째 Key : 도서관 지점 이름 (예: "서울점", "부산점")  
//		- 두 번째 Key : ISBN  
//		- Value : BookDTO 객체  
//		- 다음의 데이터 이용할것
		String[][] data = {
				{"서울점", "978-11111", "자바의 완성", "가길동"},
				{"서울점", "978-22222", "파이썬 기초", "홍길동"},
				{"부산점", "978-33333", "자료구조와 알고리즘", "이순신"},
				{"부산점", "978-44444", "파이썬 심화", "홍길동"}
		};
		
		System.out.println("		### 📌 실행 예시 \r\n"
				+ "=== 도서관 전체 목록 ===\r\n");
		
		for(Entry<String, Map<String, BookDto>> e :  library.entrySet()) {
			if(e.getKey().equals(data)) {
				System.out.printf(
						"📚 %s\r\n" 
								+ "%s | %s | %s\r\n"								
								+ "---------------------\r\n", e.getKey(), e.getKey(), e.getValue().getTitle(), e.getValue().getAuthor());				
			}		
		}
		
		System.out.println("지점 이름 입력 > "); String name = scanner.next();
		System.out.println("ISBN 입력 > "); String isbn = scanner.next();
				
		System.out.println( library.containsKey(isbn)? 
				"📖 선택한 도서 정보: "  + library.get(isbn).getTitle()+" / 저자: "  + library.get(isbn).getAuthor()  : "ISBN 확인바람");		

	}
}

/*
## 📘 연습문제3) Collection Framework + 중첩 HashMap
패키지명 : com.company.basic014_ex
클래스명 : MapEx003

### 요구사항
1. 중첩 Map 구조 만들기  
   - Map<String, Map<String, BookDTO>> library = new HashMap<>();  
   - 첫 번째 Key : 도서관 지점 이름 (예: "서울점", "부산점")  
   - 두 번째 Key : ISBN  
   - Value : BookDTO 객체  
   - 다음의 데이터 이용할것
    String[][] data = {
        {"서울점", "978-11111", "자바의 완성", "가길동"},
        {"서울점", "978-22222", "파이썬 기초", "홍길동"},
        {"부산점", "978-33333", "자료구조와 알고리즘", "이순신"},
        {"부산점", "978-44444", "파이썬 심화", "홍길동"}
    };


2. DTO 클래스  
   java
   class BookDTO {
       private String title;
       private String author;
       // 생성자, getter/setter, toString()
   }
   

3. 출력하기  
   - 각 지점별 도서 목록 출력  

4. 사용자 입력받기  
   - 지점 이름과 ISBN을 입력받아 해당 도서 정보 출력  

### 📌 실행 예시 
=== 도서관 전체 목록 ===
📚 서울점
978-11111 | 자바의 완성 | 가길동
978-22222 | 파이썬 기초 | 홍길동
---------------------
📚 부산점
978-33333 | 자료구조와 알고리즘 | 이순신
978-44444 | 파이썬 심화 | 홍길동
---------------------
지점 이름 입력> 서울점
ISBN 입력> 978-22222

📖 선택한 도서 정보: 파이썬 기초 / 저자: 홍길동

*/