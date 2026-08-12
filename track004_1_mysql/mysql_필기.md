#### 1. Mysql?
> 1. mysql why?
1. DBMS
-  Database Management System
-  데이터베이스를 관리해주는 시스템

2. Database?
- Data + Base
- Data  1.데이터(수집된 사실, 값)   2. 정보(의미 부여)
- Data(의미를 제공하는 데이터) + Base( 체계와 규격을 가진 집합)

Q1. 다음 빈칸을 채우시오
      1.     (#1 데이터 )는  수집된 사실이나 값을 의미하고
      2.     (#2 정보   )는  데이터들 중에서 의미를 제공하는 데이터를 의미

3. Database 종류
- Oracle , Mysql , MSSql,,,,,,


> 2. mysql Setting
1. MYSQL 다운로드
       https://dev.mysql.com/
       -Download
       - MySQL Community Server

2. MYSQL 설치
3. MYSQL 환경설정 (1) path
4. MYSQL 환경설정 (2) utf-8


#### 2. RDBMS

> 1. RDBMS (Relational Datase Management System)
- 관계형 데이터베이스  관리 시스템
- 테이블들의 관계

> 2. RDBMS 구성요소
- 개체 (Entity : Table)
- 관계 (Relationship)
- 속성 (Attribute : 필드)

  ※ 스키마 - 데이터베이스 구조와 제약조건을 명세정의
     외부스키마 = 사용자뷰
     개념스키마 = 전체적인뷰
     내부스키마 = 저장스키마

  ※ 데이터베이스 설계단계
   #1. 개념적설계 - 요구사항분석 후 개념적 설계 ERD  
       (집을어떻게? 방몇개, 주방어디,,, 거실은 얼마나크게)
   #2. 논리적설계 - ERD를 이용하여 데이터베이스 스키마를 설계
       (방 = 테이블 , 사람 = 엔티티 , 관계 = 외래키)
   #3. 물리적설계 - 테이블 저장구조 설계 ( mysql,oracle,,,,)
       (실제건축자재로 만들기 - mysql, oracle)

> 3. 데이터베이스 언어
1. 정의어 (DDL) DDL = Data Definition Language
    CREATE, ALTER, DROP     → CAD
2. 조작어 (DML) DML = Data Manipulation Language
    INSERT, SELECT, UPDATE, DELETE     → CRUD
3. 제어어 (DCL) DCL = Data Control Language      
    GRANT ,  REVOKE

> 4. [실습] Database 만들기

1. 만들기      :  create database db명
2. 확인       :  show   databases
3. 삭제(복구x) :  drop   database  db명
4. DB사용      : use    db명
 
1) 접속 
mysql -uroot -p
1234

2) mysql 
show  databases;
create database  db1;      --  데이터베이스 만들기
drop database  db1;    -- 데이터베이스 삭제 (복구 안됨)


> 5. [연습] 
1. db명 : test , mbasic , db703 3개 db만들기
2. db만들어진것 확인
3. db703 삭제
```mysql
create database  test;
create database  mbasic;
create dadtabase db703;

show databases;

drop database db703;
```



#### 3. 테이블

1. RDBMS (Relational Data Management System)
- 관계형 데이터베이스 
- 테이블의 관계
- 속성(필드) 연결

2. 테이블 만들기 (집안의 방, 가방 안의 분류표)
DDL (정의:create, alter, drop) , DML(조작:) , DCL(제어:)
-----------------------------------
CREATE TABLE table명 (
    필드1 자료형 옵션,
    필드2 자료형 옵션
);
-----------------------------------
자료형 : 
    1. 숫자 : int( 정수, 1,2,3,) ,  double(실수,1.23)
    2. 문자 : char(고정, 남/여)   ,  varchar(가변, abc, abcd,abcde)
    3. 날짜 : date, datetime
옵션 : 
    필수입력 - not null
    숫자자동증가 - auto_increment
    기본키 - primary key    

[실습1]
create table t1(
    name varchar(100)   not null,
    age  int
);
show tables;    -- 테이블목록확인
desc t1;        -- 구조확인

create table t11(
    no    int         not null,
    name  varchar(30) not null
);

create table t12(
    bookid  int            not null,    -- not(안돼) null(빈거)
    title   varchar(100)   not null     -- 필수입력
);

show tables;
desc t12;


※ ERROR 1046 (3D000): No database selected
use db명

mysql> show databases;
mysql> use mbasic;
mysql> status           -- 상태확인

※ 참고사항) not null 필수입력
mysql> insert into t1 (age) values (1);
ERROR 1364 (HY000): Field 'name' doesn't have a default value (값넣어!)

mysql> insert into t1 (name, age) values ('aaa', 1);
Query OK, 1 row affected (0.00 sec)

mysql> insert into t1 (name) values ('bbb');
Query OK, 1 row affected (0.00 sec)

mysql> select * from t1;
+------+------+
| name | age  |
+------+------+
| aaa  |    1 |
| bbb  | NULL |
+------+------+
2 rows in set (0.00 sec)

mysql>


[실습2]  auto_increment (숫자 자동증가) , primary key (기본키)
create table t2(
    jumin int          not null  auto_increment  primary key,
    name  varchar(100) not null,
    age   int
);

※ 참고사항)
insert into  t2 (name, age)  values ('aaa' , 1);   -- 숫자자동증가
insert into  t2 (name)  values ('bbb');            -- 숫자자동증가
insert into  t2 (jumin, name, age)  values (1 , 'ccc' , 1);  -- error 기본키
insert into  t2 (jumin, name, age)  values (3 , 'ccc' , 1);  

mysql> select * from t2;
+-------+------+------+
| jumin | name | age  |
+-------+------+------+
|     1 | aaa  |    1 |
|     2 | bbb  | NULL |
|     3 | aaa  |    1 |  <-- aaa, 1 / aaa,1 구분을 해줄수 있는 필드는  jumin  1,3  
+-------+------+------+
2 rows in set (0.00 sec)




------------------------------------------------------------
------------------------------------------------------------ [연습문제]
[001]  다음과 같이 DB와 테이블을 만드시오        >> coffee
커피번호 : cno    int           필수입력     primary key
커피이름 : cname  varchar(50)   필수입력
커피가격 : cprice   int          필수입력
+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| cno    | int(11)     | NO   | PRI | NULL    | auto_increment |    
| cname  | varchar(50) | NO   |     | NULL    |                |
| cprice | int(11)     | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+

mysql> use mbasic;

create table coffee(
    cno    int         not null primary key auto_increment,
    cname  varchar(50) not null,
    cprice int         not null
);

mysql> desc coffee;

[002] 다음과 같이 DB와 테이블을 만드시오           >> milk
우유번호 : mno      int           필수입력     primary key
우유이름 : mname    varchar(50)  필수입력
우유가격 : mprice   int          필수입력
우유갯수 : mnum     int         필수입력
우유총액 : mtotal   int         필수입력

+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| mno    | int(11)     | NO   | PRI | NULL    | auto_increment |
| mname  | varchar(50) | NO   |     | NULL    |                |
| mprice | int(11)     | NO   |     | NULL    |                |
| mnum   | int(11)     | NO   |     | NULL    |                |
| mtotal | int(11)     | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+

create table milk(
    mno    int         not null      primary key     auto_increment,
    mname  varchar(50) not null,
    mprice int         not null,
    mnum   int         not null,
    mtotal int         not null
);

mysql> desc milk;

[003] 다음과 같이 DB와 테이블을 만드시오    >> score
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| sno      | int(11)     | NO   | PRI | NULL    | auto_increment |
| sname    | varchar(20) | NO   |     | NULL    |                |
| sjava    | int(11)     | NO   |     | NULL    |                |
| sjsp     | int(11)     | NO   |     | NULL    |                |
| sspring  | int(11)     | NO   |     | NULL    |                |
| sproject | int(11)     | NO   |     | NULL    |                |
| sstotal  | int(11)     | YES  |     | NULL    |                |
| ssavg    | int(11)     | YES  |     | NULL    |                |
| semail   | varchar(50) | YES   |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+

create table score(
    sno int(11) not null    auto_increment primary key,
    sname varchar(50) not null,
    sjava int(11) not null,
    sjsp int(11) not null,
    sspring int(11) not null,
    sproject int(11) not null,
    sstotal int(11), 
    ssavg int(11), 
    semail varchar(50) 
);

mysql> desc score;

[004]  다음과 같이 DB와 테이블을 만드시오      >> emp
mysql> desc emp;
+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| empno    | int(11)     | NO   | PRI | NULL    | auto_increment |
| ename    | varchar(20) | YES  |     | NULL    |                |
| job      | varchar(20) | YES  |     | NULL    |                |
| mgr      | int(11)     | YES  |     | NULL    |                |
| hiredate | date        | YES  |     | NULL    |                |
| sal      | int(11)     | YES  |     | NULL    |                |
| comm     | int(11)     | YES  |     | NULL    |                |
| deptno   | int(11)     | YES  |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+
8 rows in set (0.01 sec)

mysql>

create table emp(
    empno int(11) not null    auto_increment primary key,
    ename varchar(20),
    job varchar(20),
    mgr int(11),
    hiredate date,
    sal int(11),
    comm int(11), 
    deptno int(11)    
);

mysql> desc emp;



[005]  다음과 같이 DB와 테이블을 만드시오     >> dept
mysql> desc dept;
+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| deptno | int(11)     | NO   | PRI | NULL    | auto_increment |
| dname  | varchar(20) | NO   |     | NULL    |                |
| loc    | varchar(20) | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)


create table dept(
    deptno int(11) not null    auto_increment primary key,
    dname varchar(20) not null,
    loc varchar(20) not null    
);

mysql> desc dept;

[006]  다음과 같이 DB와 테이블을 만드시오    >> salagrade
mysql> desc salgrade;
+-------+---------+------+-----+---------+----------------+
| Field | Type    | Null | Key | Default | Extra          |
+-------+---------+------+-----+---------+----------------+
| grade | int(11) | NO   | PRI | NULL    | auto_increment |
| losal | int(11) | YES  |     | NULL    |                |
| hisal | int(11) | YES  |     | NULL    |                |
+-------+---------+------+-----+---------+----------------+
3 rows in set (0.02 sec)

mysql>

create table salagrade(
    grade int(11) not null    auto_increment primary key,
    losal int(11),
    hisal int(11)
);

mysql> desc salagrade;

mysql> show tables;

========================================================================

데이터베이스 언어
- DDL : CREATE,     ALTER   , DROP      → CAD
- 

1) alter 문법
https://dev.mysql.com/doc/refman/8.0/en/table.html

help alter
help alter table;


ALTER TABLE 테이블명    
    ADD         추가컬럼명  자료형  옵션 [FIRST | AFTER col_name]
    DROP        삭제필드명
    CHANGE      이전필드명  새로운필드명  자료형 옵션
    MODIFY      수정필드명  자료형  옵션
    RENAME      새로운테이블이름

#1) 필드추가
      alter table userinfo add  uno   int;
      alter table userinfo add  uno2  int    first;  -- 맨앞에
      alter table userinfo add  email varchar(100)  after name;  -- name 뒤에
mysql> desc userinfo;

#2) 필드삭제
      alter table userinfo drop uno;      
      alter table userinfo drop uno2;       ※  uno2 삭제
mysql> desc userinfo;

#3) 필드수정(CHANGE)  - 필드명 , 자료형 옵션  수정
 > alter table userinfo  change oldname newname 자료형 옵션
 alter table userinfo   change email    email2  varchar(50) ;
 alter table userinfo   change email2    email  varchar(50) ; ※ email2를 email로 바꾸기
mysql> desc userinfo;

#4) 필드수정(CHANGE)  - 자료형 옵션 수정    (   add, drop , change | modify )
 alter   table   userinfo    modify  email   varchar(20) not null;

 alter table userinfo drop email;
mysql> desc userinfo;

#5) 테이블명 수정    (   add, drop , change | modify )
 alter table userinfo  rename users;

mysql> desc users;




4. 실습1. 테이블 준비
-- 1. 태이블준비0
-- mysql> desc userinfo;
-- +-------+--------------+------+-----+---------+----------------+
-- | Field | Type         | Null | Key | Default | Extra          |
-- +-------+--------------+------+-----+---------+----------------+
-- | no    | int          | NO   | PRI | NULL    | auto_increment |
-- | name  | varchar(100) | NO   |     | NULL    |                |
-- | age   | int(11)      | NO   |     | NULL    |                |
-- +-------+--------------+------+-----+---------+----------------+
-- 3 rows in set (0.00 sec)

create table userinfo(
    no        int                not null   primary  key  auto_increment,
    name    varchar(100)   not null ,
    age      int                not null
);

mysql> desc userinfo;

ALTER TABLE 테이블명
     ADD        추가필드명   자료형    옵션
     DROP      삭제필드명
     CHANGE  수정할필드명   새로넣을필드명   자료형  옵션
     MODIFY   수정할필드명   자료형  옵션

     RENAME  새로운테이블명


>>>> 연습문제1)
[001]  다음과 같이 테이블을 준비하시오    >> alter_coffee
mysql> desc alter_coffee;
+--------+-------------+------+-----+---------+-------+
| Field  | Type        | Null | Key | Default | Extra |
+--------+-------------+------+-----+---------+-------+
| cno    | int(11)     | YES  |     | NULL    |       |
| cname  | varchar(20) | YES  |     | NULL    |       |
| cprice | int(11)     | YES  |     | NULL    |       |
+--------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)

mysql> use mbasic;
mysql> show tables;

create table alter_coffee(
    cno    int, 
    cname  varchar(20),
    cprice int
);

mysql> desc alter_coffee;

> DDL : CREATE , DROP , ALTER
> ALTER TABLE 테이블명
    (추가 : ADD, 삭제 : DROP , 수정 CHANGE:MODIFY,RENAME)

[002] 다음과 같이 DB와 테이블을 수정하시오  [TABLE명 : alter_coffee] -  ALTER TABLE
연습문제1) cno, cname,cprice 필드를 ( not null )으로 수정       (modify / change)
 ALTER TABLE alter_coffee   change cno      cno     int   not null ;
 ALTER TABLE alter_coffee   modify cname    varchar(20)   not null ;
 ALTER TABLE alter_coffee   modify cprice   int           not null ;
  
mysql> desc alter_coffee;
 
연습문제2) 쿠폰필드  cgift    문자열고정(10)  미필수로 추가        (add)
      ALTER TABLE alter_coffee add cgift  char(10) ;

mysql> desc alter_coffee;

연습문제3) 쿠폰필드  cgift를  ccoupon으로 바꾸기        (change)
 ALTER TABLE alter_coffee   change cgift    ccoupon  char(10) ;
 
mysql> desc alter_coffee;

연습문제4) 쿠폰필드 ccoupon삭제
      ALTER TABLE alter_coffee drop ccoupon;      

mysql> desc alter_coffee;

연습문제5) cno를 cprice뒤로이동
      ALTER TABLE alter_coffee modify cno         int not null    after cprice;
      ALTER TABLE alter_coffee change cno   cno   int not null    after cprice;
      
mysql> desc alter_coffee;

연습문제6) cno를 맨위로
      ALTER TABLE alter_coffee modify cno         int not null    first;
      ALTER TABLE alter_coffee change cno   cno   int not null    first;

mysql> desc alter_coffee;

연습문제7) cno를 primary key 추가  (add)
      ALTER TABLE alter_coffee modify cno         int not null    primary key;
      ALTER TABLE alter_coffee change cno   cno   int not null    primary key;
      ALTER TABLE alter_coffee add  primary key(cno) ;

      ALTER TABLE alter_coffee drop primary key;

mysql> help alter

mysql> desc alter_coffee;

연습문제8) alter_coffee테이블의 이름을 alter_coffee2로 바꾸기   (rename)
 ALTER TABLE alter_coffee  rename alter_coffee2;

mysql> desc alter_coffee2;

연습문제9) 다음과 같이 최종본으로 테이블만들기

mysql> desc alter_coffee2;
+--------+-------------+------+-----+---------+----------------+
| Field  | Type        | Null | Key | Default | Extra          |
+--------+-------------+------+-----+---------+----------------+
| cno    | int(11)     | NO   | PRI | NULL    | auto_increment |
| cname  | varchar(20) | NO   |     | NULL    |                |
| cprice | int(11)     | NO   |     | NULL    |                |
+--------+-------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)

      ALTER TABLE alter_coffee2     modify cno      int not null    auto_increment  primary key     first;
      
mysql> desc alter_coffee2;


========================================================================




  | ADD [COLUMN] col_name column_definition
        [FIRST | AFTER col_name]
  | ADD [COLUMN] (col_name column_definition,...)
  | ADD {INDEX | KEY} [index_name]
        [index_type] (key_part,...) [index_option] ...
  | ADD {FULLTEXT | SPATIAL} [INDEX | KEY] [index_name]
        (key_part,...) [index_option] ...
  | ADD [CONSTRAINT [symbol]] PRIMARY KEY
        [index_type] (key_part,...)
        [index_option] ...
  | ADD [CONSTRAINT [symbol]] UNIQUE [INDEX | KEY]
        [index_name] [index_type] (key_part,...)
        [index_option] ...
  | ADD [CONSTRAINT [symbol]] FOREIGN KEY
        [index_name] (col_name,...)
        reference_definition
  | ADD [CONSTRAINT [symbol]] CHECK (expr) [[NOT] ENFORCED]
  
  | DROP {CHECK | CONSTRAINT} symbol
  | ALTER {CHECK | CONSTRAINT} symbol [NOT] ENFORCED
  | ALGORITHM [=] {DEFAULT | INSTANT | INPLACE | COPY}
  | ALTER [COLUMN] col_name {
        SET DEFAULT {literal | (expr)}
      | SET {VISIBLE | INVISIBLE}
      | DROP DEFAULT
    }
  | ALTER INDEX index_name {VISIBLE | INVISIBLE}
  | CHANGE [COLUMN] old_col_name new_col_name column_definition
        [FIRST | AFTER col_name]
  | [DEFAULT] CHARACTER SET [=] charset_name [COLLATE [=] collation_name]
  | CONVERT TO CHARACTER SET charset_name [COLLATE collation_name]
  | {DISABLE | ENABLE} KEYS
  | {DISCARD | IMPORT} TABLESPACE
  | DROP [COLUMN] col_name
  | DROP {INDEX | KEY} index_name
  | DROP PRIMARY KEY
  | DROP FOREIGN KEY fk_symbol
  | FORCE
  | LOCK [=] {DEFAULT | NONE | SHARED | EXCLUSIVE}
  | MODIFY [COLUMN] col_name column_definition
        [FIRST | AFTER col_name]
  | ORDER BY col_name [, col_name] ...
  | RENAME COLUMN old_col_name TO new_col_name
  | RENAME {INDEX | KEY} old_index_name TO new_index_name
  | RENAME [TO | AS] new_tbl_name
  | {WITHOUT | WITH} VALIDATION
}

partition_options:
    partition_option [partition_option] ...

partition_option: {
    ADD PARTITION (partition_definition)
  | DROP PARTITION partition_names
  | DISCARD PARTITION {partition_names | ALL} TABLESPACE
  | IMPORT PARTITION {partition_names | ALL} TABLESPACE
  | TRUNCATE PARTITION {partition_names | ALL}
  | COALESCE PARTITION number
  | REORGANIZE PARTITION partition_names INTO (partition_definitions)
  | EXCHANGE PARTITION partition_name WITH TABLE tbl_name [{WITH | WITHOUT} VALIDATION]
  | ANALYZE PARTITION {partition_names | ALL}
  | CHECK PARTITION {partition_names | ALL}
  | OPTIMIZE PARTITION {partition_names | ALL}
  | REBUILD PARTITION {partition_names | ALL}
  | REPAIR PARTITION {partition_names | ALL}
  | REMOVE PARTITIONING
}

key_part: {col_name [(length)] | (expr)} [ASC | DESC]

index_type:
    USING {BTREE | HASH}

index_option: {
    KEY_BLOCK_SIZE [=] value
  | index_type
  | WITH PARSER parser_name
  | COMMENT 'string'
  | {VISIBLE | INVISIBLE}
}

table_options:
    table_option [[,] table_option] ...

table_option: {
    AUTOEXTEND_SIZE [=] value
  | AUTO_INCREMENT [=] value
  | AVG_ROW_LENGTH [=] value
  | [DEFAULT] CHARACTER SET [=] charset_name
  | CHECKSUM [=] {0 | 1}
  | [DEFAULT] COLLATE [=] collation_name
  | COMMENT [=] 'string'
  | COMPRESSION [=] {'ZLIB' | 'LZ4' | 'NONE'}
  | CONNECTION [=] 'connect_string'
  | {DATA | INDEX} DIRECTORY [=] 'absolute path to directory'
  | DELAY_KEY_WRITE [=] {0 | 1}
  | ENCRYPTION [=] {'Y' | 'N'}
  | ENGINE [=] engine_name
  | ENGINE_ATTRIBUTE [=] 'string'
  | INSERT_METHOD [=] { NO | FIRST | LAST }
  | KEY_BLOCK_SIZE [=] value
  | MAX_ROWS [=] value
  | MIN_ROWS [=] value
  | PACK_KEYS [=] {0 | 1 | DEFAULT}
  | PASSWORD [=] 'string'
  | ROW_FORMAT [=] {DEFAULT | DYNAMIC | FIXED | COMPRESSED | REDUNDANT | COMPACT}
  | SECONDARY_ENGINE_ATTRIBUTE [=] 'string'
  | STATS_AUTO_RECALC [=] {DEFAULT | 0 | 1}
  | STATS_PERSISTENT [=] {DEFAULT | 0 | 1}
  | STATS_SAMPLE_PAGES [=] value
  | TABLESPACE tablespace_name [STORAGE {DISK | MEMORY}]
  | UNION [=] (tbl_name[,tbl_name]...)
}




