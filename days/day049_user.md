#1. spring003_mvc 안전한 복사해서 ex03 번만들기
#2. 테이블 users

mysql> desc users;
+----------+--------------+------+-----+-------------------+-------------------+
| Field    | Type         | Null | Key | Default           | Extra             |
+----------+--------------+------+-----+-------------------+-------------------+
| uno      | int          | NO   | PRI | NULL              | auto_increment    |
| nickname | varchar(20)  | NO   |     | NULL              |                   |
| bpass    | varchar(50)  | NO   |     | NULL              |                   |
| email    | varchar(100) | NO   |     | NULL              |                   |
| mobile   | varchar(50)  | NO   |     | NULL              |                   |
| udate    | timestamp    | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| bip      | varchar(50)  | NO   |     | NULL              |                   |
+----------+--------------+------+-----+-------------------+-------------------+
7 rows in set (0.01 sec)
mysql>

■ model
1) Dto - UserDto
2) Dao - UserMapper   user-mapper.xml
         join / login / mypage  / 아이디 중복검사 (해당 sql 찾기)

create  : 
    insert into users (nickname , bpass, email , mobile, bip ) 
    values            ( #{nickname} , #{bpass}, #{email} , #{mobile}, #{bip} )

read    : 
    select count(*) from users where email=#{email}  and  bpass=#{bpass}
    select       *  from users where uno=#{uno}
    select    email from users where email=#{email} 

mysql> desc users;
+----------+--------------+------+-----+-------------------+-------------------+
| Field    | Type         | Null | Key | Default           | Extra             |
+----------+--------------+------+-----+-------------------+-------------------+
| uno      | int          | NO   | PRI | NULL              | auto_increment    |
| nickname | varchar(20)  | NO   |     | NULL              |                   |
| bpass    | varchar(50)  | NO   |     | NULL              |                   |
| email    | varchar(100) | NO   |     | NULL              |                   |
| mobile   | varchar(50)  | NO   |     | NULL              |                   |
| udate    | timestamp    | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
| bip      | varchar(50)  | NO   |     | NULL              |                   |
+----------+--------------+------+-----+-------------------+-------------------+
7 rows in set (0.01 sec)

3) Service  테스트

■ controller
1) UserController

■ view
1) 회원가입 join
2) 로그인  login
3) 마이페이지 mypage 
4) 아이디 중복검사 (ajax)





###  db 셋팅

(1) mysql

#################################################
# Chatset Setting
#################################################
[client]
default-character-set=utf8mb4

[mysqld]
character-set-server=utf8mb4
collation-server=utf8mb4_unicode_ci
init_connect='SET NAMES utf8mb4 COLLATE utf8mb4_unicode_ci'

[mysqldump]
default-character-set=utf8mb4

[mysql]
default-character-set=utf8mb4
#################################################
