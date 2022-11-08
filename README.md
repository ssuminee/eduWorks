# 🏢 PROJECT - EDUWORKS
***
# Contents <br>
1. [개요](#star-개요)  
2. [팀 소개 및 주요 기능](#star-팀-소개-및-주요-기능)
3. [구현 기능](#star-구현-기능)
    - [메인페이지](#pushpin-메인페이지)
    - [내 캘린더](#pushpin-내-캘린더-카테고리)
    - [관심 캘린더](#pushpin-관심-캘린더)   
    - [캘린더 일정 등록](#pushpin-캘린더-일정-등록)   
    - [캘린더 일정 조회](#pushpin-캘린더-일정-조회)   
    - [홍보물 게시글 목록 조회](#pushpin-홍보물-게시글-목록-조회)  
    - [홍보물 게시글 등록/상세 조회/수정/삭제](#pushpin-홍보물-게시글-등록상세-조회수정삭제)
    - [상담 일정 예약 등록/조회/수정/삭제](#pushpin-상담-일정-예약-등록조회수정삭제)
    - [상담 내역 조회 / 상담 진행/삭제](#pushpin-상담-내역-조회--상담-진행삭제)
3. [Document](#star-document)

***

# :star: 개요
- 프로젝트명 : EDUWORKS <br>

- 보고서 : [관리하조_프로젝트 보고서.pdf](https://github.com/yoonahyoung/eduWorks/files/9641313/_.pdf) <br>

- 기획 의도  <br>
  - 재택근무 증가로 인한 업무 플랫폼 도입 필요성 <br>
  - 사용과 접근이 용이하여 업무의 효율성 증가 <br>
  - 직관적이고 사용자 친화적인 그룹웨어 개발 필요 <br>
  - 협업을 위한 하나의 플랫폼 사이트 제작 <br>

- 개발 환경 <br><br>
![image](https://user-images.githubusercontent.com/103404357/194379532-305a4a73-8329-4dfd-85ca-890c3bfeaf4c.png) <br>

***

# :star: 팀 소개 및 주요 기능
![image](https://user-images.githubusercontent.com/103404357/192155698-c3bbcec1-de4d-42ef-bcce-9afc2e874f42.png)



***
# :star: 구현 기능


## :pushpin: 메인페이지
![메인페이지](https://user-images.githubusercontent.com/103404357/194943634-4debdc7d-e155-4e81-b354-7260ff92791c.gif) <br>
- 구현 기능 설명
  - 출퇴근 기록
  - 전사 공지 / 받은 메일함 / 달력 / 부서 게시판 / 전사 주소록 / 추천, 핫게시판 조회 
<br>  


## 💻 캘린더 MVC 코드 페이지 이동
- [Model](https://github.com/ssuminee/eduWorks/tree/main/src/main/java/com/finalProject/eduWorks/schedule/model)
- [View](https://github.com/ssuminee/eduWorks/tree/main/src/main/webapp/WEB-INF/views/schedule)
- [Controller](https://github.com/ssuminee/eduWorks/blob/main/src/main/java/com/finalProject/eduWorks/schedule/controller/ScheduleController.java)
- [Mapper](https://github.com/ssuminee/eduWorks/blob/main/src/main/resources/mappers/schedule-mapper.xml)

## :pushpin: 내 캘린더 (카테고리)
![내 캘린더](https://user-images.githubusercontent.com/102542087/200232434-8ac60f9b-99da-4649-95a8-f1906fdb7bab.gif) <br>
- 구현 기능 설명
    - 내 캘린더 추가/수정/삭제
    - 내 캘린더 색상 변경
    
## :pushpin: 관심 캘린더
![관심 캘린더](https://user-images.githubusercontent.com/102542087/200235646-0c9afd69-535d-42ab-8c44-0aa5fdb44b3e.gif) <br>
- 구현 기능 설명
    - 관심 캘린더 추가/삭제 (타 사원 일정 조회 기능)
    - 전사 일정 조회 (일정 등록시 전사 일정으로 등록된 일정 조회)
    - 참석자 일정 조회 (로그인한 회원이 참석자로 포함된 일정 조회)
    
## :pushpin: 캘린더 일정 등록
![일정 등록](https://user-images.githubusercontent.com/102542087/200237226-0bdced4e-96c8-4127-8553-a0e4e2f59dec.gif) <br>
- 구현 기능 설명
    - 비공개/전사일정 조건 체크
    - 기간/내 캘린더 설정
    - 참석자 추가 (자신을 제외한 전 사원 리스트에서 선택 가능)
    - 참석자 검색 (이름/직책 키워드로 검색)

## :pushpin: 캘린더 일정 조회
![일정 조회](https://user-images.githubusercontent.com/102542087/200239833-501e89fb-2228-489f-a9b6-fbde9f6018d6.gif) <br>
- 구현 기능 설명
    - 등록된 일정 조회
    - 일정을 등록한 사원만 일정 수정/삭제 가능
    - 일정을 조회할 수 있는 사원끼리 댓글/대댓글 작성/수정/삭제 가능


## 💻 홍보물 게시판 MVC 코드 페이지 이동
- [Model](https://github.com/ssuminee/eduWorks/tree/main/src/main/java/com/finalProject/eduWorks/promotion/model)
- [View](https://github.com/ssuminee/eduWorks/tree/main/src/main/webapp/WEB-INF/views/promotion)
- [Controller](https://github.com/ssuminee/eduWorks/blob/main/src/main/java/com/finalProject/eduWorks/promotion/controller/PromotionController.java)
- [Mapper](https://github.com/ssuminee/eduWorks/blob/main/src/main/resources/mappers/promotion-mapper.xml)


## :pushpin: 홍보물 게시글 목록 조회
![홍보물 목록](https://user-images.githubusercontent.com/102542087/200492941-a2013d15-586d-45c7-a663-35284b0b2b01.gif) <br>
- 구현 기능 설명
    - 게시글 검색 (제목/작성자/직책 키워드로 검색)
    - 홍보물의 종류(전체/배너/블로그/포스터/SNS)별로 분류하여 조회 가능
    - 목록에서의 삭제 기능은 팀장과 대표에게만 부여
    - 페이징 처리

## :pushpin: 홍보물 게시글 등록/상세 조회/수정/삭제
![홍보물 게시글](https://user-images.githubusercontent.com/102542087/200494766-f2f44c6e-9de3-404d-909a-209f0eef10d9.gif) <br>
- 구현 기능 설명
    - 첨부파일 드래그/선택으로 등록 가능
    - 게시글 별 댓글/대댓글 등록/수정/가능


## 💻 학생 상담 MVC 코드 페이지 이동
- [Model](https://github.com/ssuminee/eduWorks/tree/main/src/main/java/com/finalProject/eduWorks/cnsln/model)
- [View](https://github.com/ssuminee/eduWorks/tree/main/src/main/webapp/WEB-INF/views/cnsln)
- [Controller](https://github.com/ssuminee/eduWorks/blob/main/src/main/java/com/finalProject/eduWorks/cnsln/controller/CnslnController.java)
- [Mapper](https://github.com/ssuminee/eduWorks/blob/main/src/main/resources/mappers/cnsln-mapper.xml)

    
## :pushpin: 상담 일정 예약 등록/조회/수정/삭제
![상담 일정](https://user-images.githubusercontent.com/102542087/200501454-b55ad877-9b66-4c67-bad3-5a4c5d106981.gif) <br>
- 구현 기능 설명
    - 상담 일정 예약(등록)/조회/수정/삭제 가능
    - 학생 조회/신규 학생 등록 가능
    - 담당자 추가 (자신을 제외한 홍보부 사원 리스트 + 대표님에서 선택 가능)
    - 담당자 검색 (이름/직책 키워드로 검색)
    - 작성자/담당자 모두 일정을 수정/삭제 가능
    - 게시글 별 댓글 대댓글 등록/수정/삭제

## :pushpin: 상담 내역 조회 / 상담 진행/삭제 
![상담 내역](https://user-images.githubusercontent.com/102542087/200502986-755906a4-2bf7-44d3-bfd1-fdbe0acf0845.gif) <br>
- 구현 기능 설명
    - 예약된 상담 내역 목록 조회 가능
    - 상담 내역 검색/상태별(상담 신청/완료/취소) 분류 가능
    - 페이징 처리
    - 예약된 상담 진행(수정)/삭제 가능
    - 게시글 별 댓글 대댓글 등록/수정/삭제
    
</details>



***
# :star: Document

## 개발 일정 <br><br>
![image](https://user-images.githubusercontent.com/103404357/192147566-f71dfaa7-e9fb-4769-a4bb-6949e0477551.png) <br>


## 유스케이스 <br><br>
![image](https://user-images.githubusercontent.com/103404357/192147596-51b35781-2924-4283-9af0-71c210189955.png) <br>
![image](https://user-images.githubusercontent.com/103404357/192147269-a4c47f8a-b30f-49b9-a09f-34f436374036.png) <br>
![image](https://user-images.githubusercontent.com/103404357/192147280-b1c9b5ee-8ac8-4f0f-80f7-502131e33dd5.png) <br>

## DB 설계 <br><br>
![image](https://user-images.githubusercontent.com/103404357/192155679-bf400093-e486-4748-88b0-d4843031e5cc.png) <br>

 
