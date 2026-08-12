//package com.the703.basic014_ex;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Map.Entry;
//
//import com.the703.basic014.UserDto;
//
//import java.util.Objects;
//import java.util.Scanner;
//
//class BookDTO{
//	private String title;
//	private String author;
//	public BookDTO() { super(); }
//	public BookDTO(String title, String author) { super(); this.title = title; this.author = author; }
//	@Override public String toString() { return "BookDTO [title=" + title + ", author=" + author + "]"; }
//	@Override public int hashCode() { return Objects.hash(author, title); }
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		BookDTO other = (BookDTO) obj;
//		return Objects.equals(author, other.author) && Objects.equals(title, other.title);
//	}
//	public String getTitle() { return title; }
//	public void setTitle(String title) { this.title = title; }
//	public String getAuthor() { return author; }
//	public void setAuthor(String author) { this.author = author; }
//	
//}
//
//public class MapEx002_1 {
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		Map<String, BookDTO> map = new HashMap<>();
//		map.put("978-11111" , new BookDTO("자바의 완성" , "가길동"));
//		map.put("978-22222" , new BookDTO("파이썬 기초" , "홍길동"));
//		map.put("978-33333" , new BookDTO("자료구조와 알고리즘" , "이순신"));
////		map.put(978-11111, new BookDTO("자바의 완성" , "가길동"));
////		map.put(978-22222, new BookDTO("파이썬 기초" , "홍길동"));
////		map.put(978-33333, new BookDTO("자료구조와 알고리즘" , "이순신"));
//				
//		System.out.print("도서 정보를 제공중입니다\nISBN을 입력하세요> "); String isbn = scanner.next();
//		
////		for( Entry<String, BookDTO> m : map.entrySet()) {
//			System.out.printf("📖 선택한 도서 정보: %s / 저자: %s", isbn, map.get(isbn));
////			switch(isbn) {
////				case 0:							
////					break; 
////				case 1:							 
////					System.out.printf("📖 선택한 도서 정보: %s / 저자: %s", m.getKey(), m.getValue());
////					break; 
////				case 2:							
////					System.out.printf("📖 선택한 도서 정보: %s / 저자: %s", m.getKey(), m.getValue());
////					break;
////				default: System.out.println("isbn을 0,1,2 중에 입력해주세요.");
////			}
////		}		
//		
////		for( Entry<String, BookDTO> u : map.entrySet()) {
////			
////			
////			System.out.printf("📖 선택한 도서 정보: %s / 저자: %s", key, value.getAuthor());			
////			
////			isbn = 
////			String key = u.getKey();
////			BookDTO value = u.getValue();
////		}
//		
//		
//		
//
//	}
//}
//
///*
//연습문제2)  Collection  Framework
//패키지명 : com.the703.basic014_ex
//클래스명 : MapEx002
//1. MAP 만들기
//KEY         VALUE
//978-11111   new BookDto("자바의 완성" , "가길동")
//---------------------
//978-22222   new BookDto("파이썬 기초" , "홍길동")
//---------------------
//978-33333   new BookDto("자료구조와 알고리즘" , "이순신")
//
//Map<String, BookDTO> map = new HashMap<>();
//
//
//2 다음과 같이 문제풀기
//2-1. BookDto 만들기   {    private String title;  private String author;}
//2-2. 다음과 같이 출력
//2-3. 사용자에게 KING의 이름을 입력받아 해당하는 값 출력
//==============================
//ISBN        TITLE        AUTHOR
//==============================
//978-11111 | 자바의 완성 | 가길동
//------------------------------
//978-22222 | 파이썬 기초 | 홍길동 
//------------------------------
//978-33333 | 자료구조와 알고리즘 | 이순신 
//------------------------------
//도서 정보를 제공중입니다
//ISBN을 입력하세요> 978-22222
//
//📖 선택한 도서 정보: 파이썬 기초 / 저자: 홍길동
//
//*/