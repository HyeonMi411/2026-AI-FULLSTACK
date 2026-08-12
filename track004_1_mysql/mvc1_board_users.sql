
#######################################################################################
-- mysql>
-- mysql> desc users;
-- +----------+--------------+------+-----+-------------------+-------------------+
-- | Field    | Type         | Null | Key | Default           | Extra             |
-- +----------+--------------+------+-----+-------------------+-------------------+
-- | uno      | int          | NO   | PRI | NULL              | auto_increment    |
-- | nickname | varchar(20)  | NO   |     | NULL              |                   |
-- | bpass    | varchar(50)  | NO   |     | NULL              |                   |
-- | email    | varchar(100) | NO   |     | NULL              |                   |
-- | mobile   | varchar(50)  | NO   |     | NULL              |                   |
-- | udate    | timestamp    | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
-- | bip      | varchar(50)  | NO   |     | NULL              |                   |
-- +----------+--------------+------+-----+-------------------+-------------------+
-- 7 rows in set (0.00 sec)

-- (1) users 라는 테이블 만들기   
-- (2) sql  -  회원가입 sql,  로그인 sql 찾기~!

-- insert
insert into users (nickname , bpass , email , mobile , bip)
values			  ('aaa' , '1111' , 'aaa@gmail.com' , '010-111-1111' , '127.0.0.1')

-- select (login, ,,,,)
select count(*) from users where bpass='1111' and email='aaa@gmail.com';
select 		 *  from users where bpass='1111' and email='aaa@gmail.com';


use mbasic;
show tables;
alter table users change no uno int;
alter table users change name nickname varchar(20);
alter table users change age bpass varchar(50);
alter table users add email varchar(100) not null;
alter table users add mobile varchar(50) not null;
alter table users add udate timestamp not null default current_timestamp;
alter table users add uip varchar(50) not null ;

alter table users modify nickname varchar(20) not null;
alter table users modify bpass varchar(50) not null;
alter table users modify uno int auto_increment;

desc users;
select * from users ;
