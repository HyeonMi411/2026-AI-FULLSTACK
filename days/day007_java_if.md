
### ■1. 복습문제 - 노트 준비 ~09:50

> 정리문제 (1) 
1. 웹페이지의 배경을 하늘색으로 바꾸고 싶다. 어떤 속성을 써야 할까?    ______background-color : blue______
2. 제목 글자를 초록색으로 바꾸려면?    ______color : green______
3. 본문 글자의 크기를 18px로 지정하려면?    ______font-size : 18px______
4. 메뉴 글자를 오른쪽으로 정렬하려면?    ______font-align : right______
5. 링크에 밑줄을 없애려면?    ______text-decoration : none______
6. 글꼴을 'Times New Roman'으로 바꾸려면?    ______fornt-family : 'Times New Roman'______
7. 강조하고 싶은 단어를 굵게 표시하려면?    ______font-weight : bold______
8. 이미지를 가로 400px로 줄이고 싶다. 어떤 속성?    ______width:400px______
9. 박스 바깥쪽에 20px 여백을 주려면?    ______margin : 20px______
10. 버튼 안쪽에 8px 여백을 주려면?    ______padding : 8px______
11. 카드 요소에 2px 점선 테두리를 주려면?    ______border : 2px dashed black______
12. 프로필 사진 모서리를 둥글게 50%로 만들려면?    ______border-radius : 50%______
13. 박스에 살짝 번지는 그림자 효과를 주려면?    ______box-shadow : 0 0 10px rgba(255, 0, 0, 0.5); gradiant______
14. 버튼에 마우스를 올렸을 때 부드럽게 색이 바뀌도록 하려면?    
______transition all 0.3s;______ 

> 정리문제 (2)
1. css 선택자 유일한 값 ? #id명
2. css 선택자 여러개 선택시? .class명
 
> 정리문제 (3)
1. 숫자를 한개입력받아
2. 1이면 1이다, 2이면 2이다, 3이면 3이다  if로 작성 

int num=0;
Scanner scanner = new Sanner(System.in);
System.out.println("숫자 입력 > ");
num = scanner.nextInt();

      if( num == 1 ){ System.out.println("1이다"); }
else if( num == 2 ){ System.out.println("2이다"); }
else if( num == 3 ){ System.out.println("3이다"); }
else 			 { System.out.println("1,2,3이 아니다");  }




---

제한시간 30분
1. markup  + validator
공지사항 

일반 공지
다음 주 월요일은 정기 점검이 있습니다.

긴급 공지
오늘 오후 서버 점검으로 서비스가 일시 중단됩니다.

2. css
- head태그안에 style 태그로 내부스타일시트를 적용해주세요~!

    *{ margin:0; padding:0; }

    /* Q1. body 글꼴 : Segoe UI, 배경색 : #f9f9f9 */ 

    /* Q2. h1 중앙정렬, 글자색상 : #333 */ 

    /* Q3. .notice 카드 너비 : 350px, 테두리 : 1px 실선 #ccc, 안쪽여백 : 15px, 여백 : 20px 중앙정렬 */ 
    /* Q4. .notice h2 글자크기 : 18px, 글자색상 : #444 */ 

    /* Q5. #urgent 배경색 : #ffe0e0 , 부드러운효과*/ 

    /* Q6.  #urgent  마우스 올렸을때 배경빨강, 글자 white */ 

    /* Q7. .notice img 너비/높이 : 80px, 모서리둥글게 */ 
