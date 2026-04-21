

 복습문제

■1. 자바스크립트 빈칸채우기
1. 자바스크립트의 출력   
( document.write("문자열") ,
  console.log("문자열") )
2. 변수    ( var 전역변수  , let 지역변수 , const 상수 )
3. 변수차이   
( var 전역변수 다시 선언시 덮어씀 , let 지역변수 변수 중복선언 불가 , , const 상수 변경 불가 )
4. 변수는 모든자료형을 담을수 있다.  자료형확인은 ( typeof )

5. 알림창 종류  - ( alert , prompt , confirm )
6. 이벤트  - 이벤트대상(div),    이벤트(click),  이벤트 핸들러(alert('haha'))
   다음 div 태그를 클릭했을때 알림창 haha를 출력하는 코드를 작성하시오.
    <div onclick = "alert("haha")">test</div>

7. 다음에 해당하는하는 스크립트 코드를 작성하시오.    
    0. 스크립트가 document어느위치에서든지 동작가능하게
    1. 아이디가 test인것을  getElementById 이용해 선택
    2. 클릭시 prompt이용해서 당신이 좋아하는 1~5사이의 숫자 물어보고
    3. alert이용해서 알림창띄우기  
   <input type="button"  value="addEventListener"  title="버튼4"  id="test"    class="btn btn-outline-primary"  />  
   <script>  
   </script>  

	window.addEventListener( "load" , function(){
		document.getElementById( "test" ).onclick = function(){
			let num = prompt( "1~5 사이의 좋아하는 숫자? " );
			alert( "당신이 좋아하는 숫자는 " + num );
		};
	});



■2. 자바
1.    OOP?
  객체     지향     프로그래밍
Object Oriented Programming
   틀       기반      프로그램
부품객체(클래스)조립 와성된 프로그램을 만드는 기법

2.  OOP특징 ★ 
캡슐화	: 외부접근제한
다형성	: 한가지의 타입으로 여러타입을 관리, 확장성 
상속		: 클래스의 재사용
추상화	: 핵심기능 추출해서 만든 모델링

3.  클래스는  ( 상태(멤버변수) )와  ( 행위(멤버함수) )를 갖는다 

4.  클래스와 인스턴스 구분
- 클래스는  ( 설계도 )
- 인스턴스는  ( 실제로 만들어진 객체 )


■ Javascript
1. js 선택자 
1-1. id 선택자 사용시      document.
1-2. 태그 선택자 사용시    document.getElementsByTagName
1-3. css 표현 선택자 사용시      document.querySelcetor

2. 다음에 해당하는 코드를 한줄한줄  적으시오.
2-1. 스크립트가 document어느위치에서든지 동작가능하게     window.addEventListener("load" , function(){})
2-2. 아이디가 test인것을  querySelector 이용해 선택    let test = document.querySelector("#test");
2-3. 클릭시 prompt이용해서 당신의 이름묻기              test.onclick = function(){  let name = prompt("이름?");   alert(name);    }
2-4. alert이용해서 이름 알림창띄우기   
2-5. 아래 스크립트를 채우세요.
<input type="button"  value="addEventListener"  title="버튼4"  id="test"    class="btn btn-outline-primary"  />  
<script>   
//////////
window.addEventListener("load" , function(){
   let test = document.querySelector("#test");
   test.onclick = function(){
      let name = prompt("이름?");   
      alert(name);    
   };  
})
</script>  



■ OOP
1.  생성자   - new 연산자에 의해 호출 [       ] 담당

2. 기본생성자( 디폴트생성자 )
- 모든클래스에 생성자가 반드시 존재
- 생성자선언을 생략시 컴파일러가 자동으로 기본생성자를 추가
- 개발자가 선언시 컴파일러가 자동생성  (        )

3. 생성자형식
class A{
   public    A(                 ){}   //기본생성자(디폴트생성자)
   public    A(String name){}   //파라미터, 알규먼트가 있는 생성자.
}
1)  리턴값  (       )
2)  클래스명과  (      ) 
