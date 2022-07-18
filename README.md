# "한 달 살기" 웹 프로젝트 
![image](https://user-images.githubusercontent.com/62202364/179443166-0583ac56-1d8f-442d-baa4-d70ff01ad27f.png)
<br><br>

**한달 살기를 꿈꾸는 사용자들을 위한 웹 사이트** <br>
<br>

## 프로젝트 기간
2021.03.15 ~ 2021.06.10 <br>

<br>

## 프로젝트 소개
 저희 팀은 최근 이슈인 여행지에서 한 달 살기에 대해 사람들의 생각이 어떤지 설문지를 통해 조사 해보았고 그 결과 사람들이 국내 다른 지역에서 장기간 살아보는 여행을 희망하는 사람들의 수가 상당히 많아졌지만 이에 적합한 어플리케이션이 시장에 없다는 것을 파악하였습니다. 그리하여 저희 팀은 타지역에서 한 달 살기를 희망하는 사람들에게 여행지의 정보를 제공, 여행지에 대한 여행 후기를 작성하고 다른 사용자의 후기 또한 볼 수 있는 기능, 여행 기간 동안 일과를 작성하고 하루 동안 소비한 금액을 기록할 수 있는 스케줄 기능, 사람들과 여행지에 대해 서로 정보를 공유하고 소통 가능한 커뮤니케이션 기능을 갖는 웹 어플리케이션을 구현해보자는 목표를 갖고 프로젝트를 진행하였습니다. <br>
 
 <br>

## 팀원
[김경현](https://github.com/KimKyungHyunn) <br>
[이규연](https://github.com/Leeky0615) <br>
[정석우](https://github.com/seokwoo-jeong) <br>
[함정원](https://github.com/HamJeongWon) <br>

<br>

## 프로젝트 이슈 추적

[프로젝트 이슈 관리 산출물.pdf](https://github.com/KimKyungHyunn/LiveAmonth/files/9129404/1-3.ALM.pdf)

## 개발 환경
![image](https://user-images.githubusercontent.com/62202364/179441978-3eea6f5b-c8bb-464e-82c6-ebf93b778999.png)
<br>

## 디자인 패턴
![image](https://user-images.githubusercontent.com/62202364/179442075-b6eb88c9-fdb9-4d10-ad56-4789076bafdf.png)
<br>

## 데이터베이스
![image](https://user-images.githubusercontent.com/62202364/179442132-d4edf6f8-3bf6-4e1e-95ea-751403af1916.png)
<br>

## 서버
![image](https://user-images.githubusercontent.com/62202364/179442576-a722e0d3-628c-4c91-bead-306f63da0daf.png)
<br>

![image](https://user-images.githubusercontent.com/62202364/179442589-aebfd892-a7a2-43a9-989e-49164f6cf6a9.png)
<br>

![image](https://user-images.githubusercontent.com/62202364/179442601-da90c8f6-3e4c-4c39-89fc-0cd47c7005b4.png)
<br>

![image](https://user-images.githubusercontent.com/62202364/179442620-dde11116-20d2-4110-af69-200f804947bc.png)
<br>

## 주요 기능
![image](https://user-images.githubusercontent.com/62202364/179442658-1c0cd078-7b05-4f6e-ba17-b6187c47b116.png)
<br>

![image](https://user-images.githubusercontent.com/62202364/179442665-a2481044-2304-4d75-9719-7cc9924abc25.png)
<br>

![image](https://user-images.githubusercontent.com/62202364/179442678-d85844a3-6484-4cd1-ac77-982fa6d42060.png)
<br>

![image](https://user-images.githubusercontent.com/62202364/179442708-5efb454d-edbb-4344-a6e3-96d728785b28.png)
<br>
 
<br>

## 기여한 부분
**1. SCHEDULE**
- 스케줄 공개 여부 public인 사용자들의 스케줄 리스트로 확인
- 스케줄을 필터(장소, 나이, 성별) 기능과 정렬(최신순, 좋아요순) 기능을 적용 (Mybatis 동적 쿼리 사용)
- 다른 사람의 스케줄 상세 정보들 이미지처럼 가져와 리스트로 출력 (include jsp 태그 사용) <br>

**2. 네이버 로그인 연동과 회원 가입**
- "네이버 아이디로 로그인 하기" API로 네이버 회원의 개인 정보를 JSON 토큰으로 제공받아 회원가입과 로그인 진행
- 네이버 아이디로 회원 가입 시 개인 정보 항목 체크 여부에 따라 필요 정보 추가 입력하는 회원가입 절차 진행 <br>

<br>

## 코드
![image](https://user-images.githubusercontent.com/62202364/179443048-7be9d590-043a-4e29-9b24-48d556f8d19c.png)
<br>

![image](https://user-images.githubusercontent.com/62202364/179442932-8861f06f-191d-49f4-aae1-d106f83bd2a1.png)
<br>

![image](https://user-images.githubusercontent.com/62202364/179442949-942fc5f8-2822-4bab-87f8-cbfe327d0a1a.png)
<br>

![image](https://user-images.githubusercontent.com/62202364/179442960-23cff180-bae9-422b-8484-449d5db738b7.png)
<br>

## 시연 화면 캡쳐
![image](https://user-images.githubusercontent.com/62202364/179452828-07b58e75-f12a-43a6-a766-28442daacd3a.png)
<br>

![image](https://user-images.githubusercontent.com/62202364/179452847-0dfebc9f-2caa-4703-9b46-3d79a9d63d6b.png)
<br>

![image](https://user-images.githubusercontent.com/62202364/179452877-7b0a53ba-bc8e-446f-8c24-de0e137bcac7.png)

![image](https://user-images.githubusercontent.com/62202364/179452932-c7f84ccb-3d04-4b98-bd16-799c1b11b57b.png)

<br>





