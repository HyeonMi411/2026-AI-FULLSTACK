//package com.the703.basic014_ex;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//import java.util.Scanner;
//
//class KingDto{
//	private String king;
//	private String name;
//	public KingDto() { super(); }
//	public KingDto(String king, String name) { super(); this.king = king; this.name = name; }
//	@Override public String toString() { return "KingDto [king=" + king + ", name=" + name + "]"; }
//	@Override public int hashCode() { return Objects.hash(king, name); }
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		KingDto other = (KingDto) obj;
//		return Objects.equals(king, other.king) && Objects.equals(name, other.name);
//	}
//	public String getKing() { return king; }
//	public void setKing(String king) { this.king = king; }
//	public String getName() { return name; }
//	public void setName(String name) { this.name = name; }
//		
//}
//
//
//public class MapEx001_1 {
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		
//		Map<String, String> map = new HashMap<>();
//		map.put("피구왕", "통키");
//		map.put("제빵왕", "김탁구");
//		map.put("요리왕", "비룡");
////		map.put("피구왕", new KingDto("통키"));
////		map.put("제빵왕", new KingDto("김탁구"));
////		map.put("요리왕", new KingDto("비룡"));
//		
//		System.out.println();
//		
//		
//		
//		
//		
//		System.out.print("KING의 정보를 제공중입니다\n이름을 입력하세요 > "); String name = scanner.next();
//		
//		System.out.printf("ㅁ%s : %s", name, map.get(name));
//
//	}
//}
///*
//연습문제1)  Collection  Framework
//패키지명 : com.the703.basic014_ex
//클래스명 : MapEx001
//1. MAP 만들기
//KEY   VALUE
//피구왕   통키
//---------------------
//제빵왕   김탁구
//---------------------
//요리왕   비룡
//
//Map<String, String> map = new HashMap<>();
//
//2 다음과 같이 문제풀기
//2-1. 다음과 같이 출력
//2-2. 사용자에게 KING의 이름을 입력받아 해당하는 값 출력
//==============================
//KING   NAME
//==============================
//피구왕   통키
//---------------------
//제빵왕   김탁구
//---------------------
//요리왕   비룡
//---------------------
//KING의 정보를 제공중입니다
//이름을 입력하세요> 제빵왕
//
//ㅁ제빵왕 : 김탁구
//*/