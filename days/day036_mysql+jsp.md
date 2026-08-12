######  복습문제 확인 및 깃허브

DDL (정의)  CREATE, ALTER, DROP → CAD
DML (조작)  INSERT, SELECT, UPDATE, DELETE → CRUD

복습문제1) 
1. 다음과 같이 테이블을 작성하는 코드를 적으시오.
-- mysql> desc userinfo;
-- +-------+--------------+------+-----+---------+----------------+
-- | Field | Type         | Null | Key | Default | Extra          |
-- +-------+--------------+------+-----+---------+----------------+
-- | no    | int          | NO   | PRI | NULL    | auto_increment |
-- | name  | varchar(100) | NO   |     | NULL    |                |
-- | age   | int          | NO   |     | NULL    |                |
-- +-------+--------------+------+-----+---------+----------------+
-- 3 rows in set (0.00 sec)

CREATE TABLE userinfo (
    no             int not null  auto_increment primary key,
    name varchar(100)  not null ,
    age           int  not null
);


2. 마지막에 5, five, 50을  insert하는 코드를 작성하시오.  (insert)
inset into userinfo                 values (5, 'fifth' , 50);
inset into userinfo (name, age)     values ( 'fifth' , 50);
inset into userinfo (no, name, age) values (5, 'fifth' , 50);

3. no가 5인 데이터의 5, five, 55로  수정하는 코드를 작성하시오.   (update)
update  userinfo set     age=55 where   no=5;

4. no가 5인 데이터를 삭제하는 코드를 작성하시오. (delete)
delete from userinfo where no=5;

5. 다음과 같이 나이를 오름차순으로 정렬하는 코드를 작성하시오.  (select)
-- mysql> select * from userinfo_re1;
-- +----+--------+-----+
-- | no | name   | age |
-- +----+--------+-----+
-- |  1 | first  |  11 |
-- |  2 | second |  22 |
-- |  3 | third  |  33 |
-- |  4 | fourth |  44 |
-- +----+--------+-----+

select   *
from     userinfo
order by age asc;

복습문제2)  
1.  jdbc 연동을 하려고한다.   드라이버로딩시 사용되는 코드는?
    Class.forName(  "com.mysql.cj.jdbc.Driver"  );

2.  DriverManager를 이용해서 url, root, pass를 이용해서 Connection을 만들려고할때 사용되는 코드는?   DriverManager.getConnection
    Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/mabasic","root","1234");

3.  PreparedStatement를 이용해서 sql을 실행하려고할때  insert, update, delete 에서 사용되는 코드는?
execute?

4.  PreparedStatement를 이용해서 sql을 실행하려고할때  select   에서 사용되는 코드는?
executeQuery()?

5.  jdbc의 주의사항은? 항상  (   close  )를 해야한다.
