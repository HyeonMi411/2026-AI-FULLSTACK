package com.the703.basic010;

public class Score_1{    // com.the703.basic010 패키지에 설정해주세요
	private String name;
	private int kor, eng, math , total;
	private double aver;
	private String p  , s  , rank;
	public Score_1() { super();  }
	public Score_1(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	@Override
	public String toString() {
		return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", total=" + total
				+ ", aver=" + aver + ", p=" + p + ", s=" + s + ", rank=" + rank + "]";
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getKor() { return kor; }
	public void setKor(int kor) { this.kor = kor; }
	public int getEng() { return eng; }
	public void setEng(int eng) { this.eng = eng; }
	public int getMath() { return math; }
	public void setMath(int math) { this.math = math; }
	public int getTotal() { return total; }
	public void setTotal(int total) { this.total = total; }
	public double getAver() { return aver; }
	public void setAver(double aver) { this.aver = aver; }
	public String getP() { return p; }
	public void setP(String p) { this.p = p; }
	public String getS() { return s; }
	public void setS(String s) { this.s = s; }
	public String getRank() { return rank; }
	public void setRank(String rank) { this.rank = rank; }
} 
