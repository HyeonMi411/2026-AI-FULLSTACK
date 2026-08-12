<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
   <div class="container card my-5">
      <h3 class="card-header"></h3>
       
   </div>
   
  <div class="card-body">
    <h4>STEP1. Ajax-text (fetch)</h4>
    <pre>
   1. fetch()로 로컬 텍스트 파일 가져오기 
         경로: ./write.jsp   
    2. 응답을 .text()로 받아서 줄 단위로 나누기
    3. 각 줄을 / 로 split하여 name, price 출력하기
    </pre>
    <p><input type="button" id="btnText" value="fetch-text" class="btn btn-outline-primary" onclick="showText()"/></p>
    <div id="resultText">
      <table class="table table-striped table-bordered">
        <thead><tr><th>NO</th><th>TITLE</th><th>WRITER</th><th>DATE</th><th>HIT</th></tr></thead>
        <tbody></tbody>
      </table>
    </div>
    <script>
        
        function showText(){
            fetch("./write.jsp")     // 경로
            .then(res=> res.text())     // 결과물
            .then(txt=> {                
                let lines = txt.split("\n");
                let result="";
                lines.forEach(  line =>{
                    let arr = line.split("/");
                    result += `<tr><td>${arr[0]}</td><td>${arr[1]}</td><td>${arr[2]}</td><td>${arr[3]}</td><td>${arr[3]}</td></tr>`;
                });
                document.querySelector("#resultText tbody").innerHTML = result;
            })     // 성공
            .catch(err=>{
                document.querySelector("#resultText tbody").innerHTML ="에러메시지 : " + err.message; 
                console.log(err.message);
            });    // 실패
        } 
    </script>
  </div>
     
</body>
</html>
