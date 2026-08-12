 APPUSER
 ┌───────────────────────────────────────────────┐
 │ APP_USER_ID (PK)                              │
 │ EMAIL (NOT NULL, UNIQUE with PROVIDER)        │
 │ PASSWORD                                      │
 │ MBTI_TYPE_ID                                  │
 │ CREATED_AT                                    │
 │ UFILE                                         │
 │ MOBILE                                        │
 │ NICKNAME                                      │
 │ PROVIDER (NOT NULL)                           │
 │ PROVIDER_ID                                   │
 └───────────────────────────────────────────────┘
                ▲
                │  (FK: APP_USER_ID)
                │
 AUTHORITIES
 ┌───────────────────────────────────────────────┐
 │ AUTH_ID (PK)                                  │
 │ EMAIL                                         │
 │ AUTH (NOT NULL, UNIQUE with APP_USER_ID)      │
 │ APP_USER_ID (FK → APPUSER.APP_USER_ID)        │
 └───────────────────────────────────────────────┘
````

SQL> desc appuser;
Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
APP_USER_ID                               NOT NULL NUMBER(5)
EMAIL                                     NOT NULL VARCHAR2(100)
PASSWORD                                           VARCHAR2(100)
MBTI_TYPE_ID                                       NUMBER(3)
CREATED_AT                                         DATE
UFILE                                              VARCHAR2(255)
MOBILE                                             VARCHAR2(50)
NICKNAME                                           VARCHAR2(50)
PROVIDER                                  NOT NULL VARCHAR2(50)
PROVIDER_ID                                        VARCHAR2(100)

SQL> desc authorities;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 AUTH_ID                                   NOT NULL NUMBER(5)
 EMAIL                                              VARCHAR2(255)
 AUTH                                      NOT NULL VARCHAR2(255)
 APP_USER_ID                                        NUMBER(5)

SQL>

commit;







































































CREATE TABLE APPUSER (
    APP_USER_ID   NUMBER(5)       CONSTRAINT PK_APPUSER PRIMARY KEY,
    EMAIL         VARCHAR2(100)   CONSTRAINT NN_APPUSER_EMAIL NOT NULL,
    PASSWORD      VARCHAR2(100),
    MBTI_TYPE_ID  NUMBER(3),
    CREATED_AT    DATE,
    UFILE         VARCHAR2(255),
    MOBILE        VARCHAR2(50),
    NICKNAME      VARCHAR2(50),
    PROVIDER      VARCHAR2(50)    CONSTRAINT NN_APPUSER_PROVIDER NOT NULL,
    PROVIDER_ID   VARCHAR2(100)
);
create sequence appuser_seq;

  
CREATE TABLE AUTHORITIES (
    AUTH_ID      NUMBER(5)        CONSTRAINT PK_AUTHORITIES PRIMARY KEY,
    EMAIL        VARCHAR2(255),
    AUTH         VARCHAR2(255)    CONSTRAINT NN_AUTHORITIES_AUTH NOT NULL,
    APP_USER_ID  NUMBER(5)
);
create sequence authorities_seq;


--1) 회원가입
insert into  appuser 
(APP_USER_ID ,EMAIL , PASSWORD , MBTI_TYPE_ID , CREATED_AT , UFILE  , MOBILE, NICKNAME , PROVIDER , PROVIDER_ID)
values   
(  appuser_seq.nextval, 'first@gmail.com' , '111', 1,sysdate , '1.png' , '0101111111'  , 'first' , 'the703', 't7-1');

--2) 로그인 - 이메일로 이메일, 비밀번호, 권한
select   u.email ,  u.password, a.auth
from     appuser u  left join  authorities a  on   u.email = a.email
where    u.email = 'first@gmail.com'; 

--3) 이메일로 유저찾기
select * from   appuser  where  email='first@gmail.com'; 

--4) 이메일로 중복검사
select count(*) from   appuser  where  email='first@gmail.com'; 

--5) 회원수정
update  appuser
set     password='2222',  
mbti_type_id=2 ,
ufile  = '2.png' ,
nickname='second',
mobile='0102222222',
provider='naver',
provider_id='n-1'
where  app_user_id=2;    -- 있는번호

--6) 회원삭제
delete from appuser  where   app_user_id=2; 

--7) 권한삽입
insert into authorities ( AUTH_ID , EMAIL,  AUTH)
values                  ( authorities_seq.nextval , 'first@gmail.com' , 'ROLE_MEMBER');
--8) 권한삭제 
delete from   authorities  where email = 'first@gmail.com';















