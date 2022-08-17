# 이노베이션 캠프 3주차 과제
> 스프링 부트로 블로그 백엔드 서버 만들기.

스프링과 aws를 이용하여 웹 api서버를 만들고 배포를 해보았다.
<img src="https://images.velog.io/images/hanblueblue/post/c5ac9eb1-2004-4d5d-9688-9abc31da5438/OG-Spring.png"  height="300">

<br>

# 사용기술
- AWS - ec2,RDS
- JAVA
- spring boot
- mysql

<br>

## 구현기능
1. 전체 게시글 목록 조회 API
    - 제목, 작성자명, 작성 날짜를 조회하기
    - 작성 날짜 기준으로 내림차순 정렬하기
2. 게시글 작성 API
    - 제목, 작성자명, 비밀번호, 작성 내용을 입력하기
3. 게시글 조회 API
    - 제목, 작성자명, 작성 날짜, 작성 내용을 조회하기
4. 게시글 비밀번호 확인 API
    - 비밀번호를 입력 받아 해당 게시글의 비밀번호와 일치여부 판단하기
5. 게시글 수정 API
    - 제목, 작성자명, 비밀번호, 작성 내용을 수정되게 하기
6. 게시글 삭제 API
    - 글이 삭제되게 하기

<br>

## API명세서
|이름|Method|URl|
|:---|:---:|:---:|
|게시글 목록|GET|/api/memos|
|게시글 작성|POST|/api/memo|
|게시글 상세 조회|GET|/api/memo/{id}|
|게시글 비밀번호 확인|POST|/api/memo/{id}|
|게시글 수정|PUT|/api/memo/{id}|
|게시글 삭제|DELETE|/api/memo/{id}|





