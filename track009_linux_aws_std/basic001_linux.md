## CI/CD
1. CI (Continuous Integration, 지속적 통합)
- 개발자들이 작성한 코드를 정기적으로 중앙저장소에 병합하고 
- 자동으로 빌드 및 테스트 하는 과정

2. CD (Continuous Delivery / Continuous Deployment, 지속적 전달 및 배포)
- CI과정을 거친 코드를 프로덕션(실서비스) 환경에 배포할수 있도록 준비, 배포단계

## Part001. Linux
### 진행사항
1. Ubuntu 24.04 컨테이너 실행 방법
2. linux 사용자
3. 기본명령어
4. 파일
5. 유저
6. job + 쉘스크립트

####  1. Ubuntu 24.04 컨테이너 실행 방법
- 도커 : 컨테이너기반의 가상화플랫폼

1. 이미지 다운로드 (pull)
```bash
docker pull ubuntu:24.04
```

2. 컨테이너 실행 (run)
```bash
docker run -it  --name  myubuntu  ubuntu:24.04  bash
```
1) -it : -i(표준입력 Interactive), -t(터미널 Pseudo-TTY)
2) --name myubuntu : 컨테이너 이름 지정
3) ubuntu:24.04 : 이미지 이름 및 태그(버전)
4) bash : 컨테이너 내부에서 실행할 쉘 전달 및 배포)

3. 컨테이너 내부에서 패키지업데이트 및 필수 패키지 일괄설치
※ 도커 컨테이너 환경에서 설치가 중간에 멈추는 것을 방지하는 핵심 설정
```bash
apt update && apt upgrade -y && DEBIAN_FRONTEND=noninteractive apt install -y vim man-db net-tools iproute2 adduser sudo
```
1) apt update: 설치 가능한 패키지 목록을 최신 상태로 업데이트합니다.
2) &&: 앞의 명령어가 성공적으로 끝나면 뒤의 명령어를 연속해서 실행합니다.
3) apt upgrade -y: 설치되어 있는 모든 프로그램을 최신 버전으로 업그레이드합니다. (-y는 확인 질문에 자동으로 Yes 응답)
4) DEBIAN_FRONTEND=noninteractive: 패키지 설치 중 대국민 설문 형태(시간대 설정 등)의 키보드 입력을 요구하는 팝업 창을 띄우지 않고 기본값으로 자동 진행하게 만듭니다. (도커 컨테이너 환경에서 설치가 중간에 멈추는 것을 방지하는 핵심 설정)
4) apt install -y ...: 지정한 패키지들을 자동으로 설치합니다.


4. 컨테이너 종료 후 다시 실행 ( ps 상태확인 / start 실행)
```bash
docker ps -a
```
```bash  
docker start -ai  myubuntu
```
-a : 터미널 실시간 화면 보이기
-i : 키보드 입력

## ■정리 1) docker  ( prps )
1) 이미지 다운로드 - docker pull
2) 이미지 컨테이너만들고 실행 - docker run
3) 도커확인 - docker ps
4) 다시 실행 - docker start


####  2. linux 사용자
1.  # :  root 사용자  ( 최고 관리자 )
2.  $ :  일반  사용자  ( 일반계정 관리자 )  
    ※ AWS EC2에서 sudo 명령을 붙여서 실행

####  3. 기본명령어
```
#1. 날짜 확인
date

#2. 출력
echo hello

#3. 명령어 위치확인
which date

#4. 명령어 설명서 (매뉴얼)
man date
```

```bash
#man 명령어가 작동하지 않거나 최소화된 매뉴얼 복원
apt update       # 패키지 최신상태
apt install -y  man-db   manpages    # 설치 , 조회도구, 기본명령어 매뉴얼
yes | unminimize     # 자동으로 yes , 일반문서 상태
```
```bash
man date
↑  ↓  q (빠져나오기)

date  
date  "+%Y-%m-%d"
```

Q1. hi 출력
Q2. man이용해서 echo확인

```
root@f86e724c30eb:/# echo hi
hi
root@f86e724c30eb:/# man echo
ECHO(1)                            User Commands
ECHO(1)
q    # 빠져나오기
```


## ■정리 2) 기본
1) 날짜 date
2) 출력 echo
3) 위치 which
4) 매뉴얼 man

####  4. 파일

1) 파일 및 디렉토리 생성 / 삭제
```bash
mkdir  디렉토리명     #  디렉토리 만들기
mkdir  -p  경로/하위경로    # 중간디렉토리 생성
touch  파일명   # 빈파일생성

rm      파일명      # 파일삭제
rm  -r  디렉토리명   # 디렉토리 삭제
```

2) 파일 확인 및 경로이동
```bash
ls -al      # 목록보기 
pwd         # 현재경로
cd  디렉토리명    # 디렉토리로 이동
cd  ..          # 상위경로
```

```bash

root@f86e724c30eb:/# pwd 
/
root@f86e724c30eb:/# ls 
root@f86e724c30eb:/# ls -al
root@f86e724c30eb:/# cd  ~ 
root@f86e724c30eb:~# pwd
/root
root@f86e724c30eb:~#

root@f86e724c30eb:~# mkdir basic1
root@f86e724c30eb:~# ls -al 
drwxr-xr-x 2 root root 4096 Sep  1 02:17 basic1
root@f86e724c30eb:~# mkdir -p basic2/a/b/c
root@f86e724c30eb:~# ls -al 
 
root@f86e724c30eb:~# rm  basic2         # 하위폴더 있으면 삭제 안됨.
root@f86e724c30eb:~# rm  -r   basic2    # 하위폴더 삭제
root@f86e724c30eb:~# ls  
```

Q1. test 폴더만들기
Q2. 폴더안에  test1.txt 파일만들기
Q3. 파일확인 - 디렉토리인지, 폴더인지까지 구분



3) 파일 쓰기  > (덮어쓰기)  , >> (이어쓰기)
```
echo  "first"  >  file1.txt       
cat   file1.txt
echo   "hi"     >  file1.txt     # 덮어쓰기
echo   "abc"    >>  file1.txt    # 이어쓰기
```

Q1. test폴더로 이동
Q2. test1.txt 파일에 apple 글쓰기
Q3. test1.txt 파일에 banana, coconut 이어서 쓰기

4) 복사해서 옮기기
```bash
#mv  [경로/원본파일]  [이동할폴더/새파일명]

mv  test/test1.txt    basic1/fruits.txt
```
Q1. basic1 폴더의  fruits.txt 파일 을 복사해서 
Q2. test   폴더의  eat.txt 파일명으로 옮기기


5) vi 에디터
```
1. sudo vi file1.txt 실행     ($ 일반사용자 - sudo)
2. vi 안에서 [Esc] 눌러 명령 모드로 전환   
3. [i] 눌러 입력 모드로 전환 → 새 설정 붙여넣기  , 편집
4. [Esc] → :wq! → 저장 후 종료   
```
> ■vi문제
Q1.  test 폴더안에  num.txt 파일만들기
Q2.  num.txt vi에디터이용해서
one-1
two-2
three-3 
Q3. 파일확인

```bash
cd  ~   이동
cd  test  폴더이동
vi num.txt
esc , i(편집)
파일편집
esc   :wq!
```


> ■정리문제
Q1. 파일만들기   mylinux.txt      ``` vi mylinux.txt  ```
Q2. 파일안에 답채우기  예)         ``` esc, i(편집) , 수정  ,  :wq!
echo 
man  
touch 
mkdir -p
ls -al
cd ..
rm -r sub
cp 경로/file1.txt  경로/back.txt
mv 경로/back.txt   경로/test.txt   
....
Q3. vi이용해서 맨위에 작성자본인이름 추가
Q4~5. mylinux.txt 백업해서 ubuntu에 backup.txt로 
```
cd ~
mkdir ubuntu 
mv   test/mylinux.txt   ubuntu/backup.txt
```
Q6. 홈으로 이동 testdir 삭제
```
mkdir testdir
rm  -r  testdir
```

Q2) 번 문제
-    출력
-    사용서
-    파일생성
-    디렉토리만들기
-    목록보기
-    상위이동
-    파일,폴더삭제
-    file1.txt 을 back.txt으로 파일복사
-    back.txt를 test.txt로 이름변경


####  5. 유저
1. 유저 추가 및 삭제
```
sudo adduser  one
sudo passwd   1111
sudo deluser  one
```
```
root@ec717e053995:~# adduser one
New password:
Retype new password:    ← 입력해도 안보임
Is the information correct? [Y/n] y

root@ec717e053995:~# cd  /home
root@ec717e053995:/home# su -one
exit

su - one
mkdir folder1
ls -al
echo date > log.txt     #파일만들고 권한확인
```
one@ec717e053995:~$ ls -al
# d (폴더)  소유자 rwx  그룹  rwx   다른사람  r-x
# r   읽기: 4,    w 쓰기:2,   x 실행: 1     4+2+1 = 7       775
drwxrwxr-x 2 one  one  4096 Sep  1 05:43 folder1

# - (파일)  소유자 rw-      그룹 rw-    다른사람 r--        664
-rw-rw-r-- 1 one  one    29 Sep  1 05:53 log.txt

one@ec717e053995:~$

- root에서 유저만들기
Q1. `two` 유저 만들기 (비번: 2222)
Q2. `two`로 로그인(`su - two`) / `two` 홈 디렉토리 찾아가기
Q3. `two`로 접속해서 `/home/one` 찾아가는 거 가능한지 확인

```
adduser two
su - two
cd /home
cd one
```
two@ec717e053995:/home$ ls -al
total 20
drwxr-xr-x 1 root   root   4096 Sep  1 05:58 .
drwxr-xr-x 1 root   root   4096 Sep  1 01:08 ..
drwxr-x--- 3 one    one    4096 Sep  1 05:58 one    소유자rwx   그룹r-x     다른사람---
drwxr-x--- 2 two    two    4096 Sep  1 06:01 two
drwxr-x--- 2 ubuntu ubuntu 4096 Aug 10 14:55 ubuntu
two@ec717e053995:/home$
two@ec717e053995:/home$ cd one
bash: cd: one: Permission denied

two@ec717e053995:/home$ ls -al
total 20
drwxr-xr-x 1 root   root   4096 Sep  1 05:58 .
drwxr-xr-x 1 root   root   4096 Sep  1 01:08 ..
drwxr-x--- 3 one    one    4096 Sep  1 05:58 one    소유자rwx   그룹r-x     다른사람---
drwxr-x--- 2 two    two    4096 Sep  1 06:01 two
drwxr-x--- 2 ubuntu ubuntu 4096 Aug 10 14:55 ubuntu
two@ec717e053995:/home$
two@ec717e053995:/home$ cd one
bash: cd: one: Permission denied

```bash
# root 계정에서     소유자7 (r:4w:2:x:1)     그룹5 (r:4w:-x:1)      다른사람5(r:4w:-x:1)
chmod   755 /home/one
ls -al
```

Q two 다시 접속 , one폴더 접근가능한지 확인 
```bash
su - two
pwd     # 현재위치 확인
cd  /home/one
```

Q log.txt 파일읽기
```bash
ls -al
※ -rw-rw-r-- 1 one  one    29 Sep  1 05:53 log.txt

two@ec717e053995:/home/one$ echo 'haha' >> log.txt
-bash: log.txt: Permission denied

exit
```

Q  root계정에서 /home/one   폴더 다른사람이 못읽게처리      
   750 (소유자:  그룹: 다른사람:)
```bash
root@ec717e053995:/home# chmod 750 /home/one
root@ec717e053995:/home# ls -al
drwxr-x--- 3 one    one    4096 Sep  1 05:58 one
```

■ 정리
1. 유저만들기   adduser
2. 권한주기     chmod    750    /home/one       ( rwxr-x---)  소유자 그룹 다른사람


####  6. job + 쉘스크립트
1. 프로세스 상태확인
```
ps -ef
```
1) e : 모든 프로세스 표시
2) f : 풀포맷 자세하게 출력

2. 실시간 모니터링
```
top
ctrl + c  ← 빠져나오기
```

3. ip주소확인
```
ip a
```

4. hello world 출력 쉘스크립트 작성
```bash
vi    hello.sh

#!/bin/bash
echo "Hello World"
esc  :wq!
```

```bash
ls -al
```
-rw-r--r-- 1 root   root     32 Sep  1 06:53 hello.sh

```bash
chmodd +x  hello.sh
```
-rwxr-xr-x 1 root   root     32 Sep  1 06:53 hello.sh

```bash
./hello.sh
```
※ chmod -x  hello.sh   권한빼기

Q1. 현재시간출력 쉘스크립트 작성  > date_log.sh
#!/bin/bash
date
date > log.txt
echo  "log.txt done"

Q2. 권한확인 실행권한주기
Q3. 실행 및 확인

```
vi  date_log.sh
i
#!/bin/bash
date
date > log.txt
echo  "log.txt done"
esc  :wq!

ls -al

chmod +x  date_log.sh

./date_log.sh
```




## Part002. Aws
■ 0. 회워가입 / 로그인


1) 이력서- 사진
2) 3차 시연회  /  4차 ( 시연회 + 면접 )

.... ci/cd (포트폴리오올리기)
.... 이력서 (다음주부터 준비)
.... 포트폴리오 결과보고서 + 동영상 + 포트폴리오 준비






Q1. test 폴더만들기
root@ec717e053995:~# mkdir test
Q2. 폴더안에  test1.txt 파일만들기
root@ec717e053995:~# cd test
root@ec717e053995:~/test# touch test1.txt
Q3. 파일확인 - 디렉토리인지, 폴더인지까지 구분
root@ec717e053995:~/test# ls -al
total 8
drwxr-xr-x 2 root root 4096 Sep  1 02:48 .
drwx------ 1 root root 4096 Sep  1 02:48 ..
-rw-r--r-- 1 root root    0 Sep  1 02:48 test1.txt
root@ec717e053995:~/test#




Q1. test폴더로 이동
root@ec717e053995:~/basic1# cd ~
root@ec717e053995:~# cd test
Q2. test1.txt 파일에 apple 글쓰기
root@ec717e053995:~/test# echo apple > test1.txt
root@ec717e053995:~/test# cat test1.txt
apple
Q3. test1.txt 파일에 banana, coconut 이어서 쓰기
root@ec717e053995:~/test# echo banana >> test1.txt
root@ec717e053995:~/test# echo coconut >> test1.txt
root@ec717e053995:~/test# cat test1.txt
apple
banana
coconut
root@ec717e053995:~/test#

2. 권한구조 변경
```
ls -al
```
d             rwx                            r-x                         --- 2 sally sally 4096 Feb  3 15:04 .    
→  d 디렉토리  소유자(읽기:4/쓰기:2/실행:1)      그룹(읽기:4/쓰기:-/실행:1)     다른사람(읽기:-/쓰기:-/실행:-)
d             rwx                            r-x                         r-x 1 root  root  4096 Feb  3 14:59 ..
→  d 디렉토리  소유자(읽기:4/쓰기:2/실행:1)      그룹(읽기:4/쓰기:-/실행:1)     다른사람(읽기:-/쓰기:-/실행:-)


