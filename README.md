# "한 달 살기" 웹 사이트

## 프로젝트 기간
2021년 학교 팀프로젝트1 전공 수업내에서 진행한 팀 프로젝트
2021.03.15 ~ 2021.06.10

## 프로젝트 소개
 저희 팀은 최근 이슈인 여행지에서 한 달 살기에 대해 사람들의 생각이 어떤지 설문지를 통해 조사 해보았고 그 결과 사람들이 국내 다른 지역에서 장기간 살아보는 여행을 희망하는 사람들의 수가 상당히 많다는 것을 알게 되었습니다. "에어비앤비", "야놀자"와 같은 숙박 예약과 숙박 업소의 평점, 리뷰를 볼 수 있는 어플리케이션이 존재하지만 단기 여행이 아닌 여행지를 장기간으로 여행하는 것이 목적인 사람들은 더 많은 여행지에 대한 정보와 의견 공유가 필요하므로 이들이 사용하기에는 적합하지 않다는 것을 파악하였고 한 달 살기를 목적으로 하는 어플리케이션이 필요하다는 것을 깨달았습니다.
 
 그리하여 저희 팀은 타지역에서 한 달 살기를 희망하는 사람들에게 여행지의 정보를 제공, 여행지에 대한 여행 후기를 작성하고 다른 사용자의 후기 또한 볼 수 있는 기능, 여행 기간 동안 일과를 작성하고 하루 동안 소비한 금액을 기록할 수 있는 스케줄 기능, 사람들과 여행지에 대해 서로 정보를 공유하고 소통 가능한 커뮤니케이션 기능을 갖는 웹 어플리케이션을 구현해보자는 목표를 갖고 프로젝트를 진행하였습니다.

## 주요 기능
1. city
city는 국내 여행지 6곳인 제주도, 서울, 강릉, 부산, 여수, 경주에 대한 정보를 제공합니다. 여행지들에 대한 지역 정보(볼거리, 음식)을 제공하고 정류장과 노선의 개수를 이용하여 교통 점수를 산출하는 알고리즘을 통해 교통 편의성을 제공해주며 전년도 기온 정보를 통해 대략적인 기온 추정값을 제공합니다.
  
2. schedule
schedule은 한달 살기를 계획하고 기록하는 스케줄 기능입니다. 스케줄 등록 시 일정과 비용 또한 기록할 수 있으며 한달 총 지출 비용을 계산할 수 있습니다. 그리고 스케줄을 공개여부 설정에서 공개로 할 경우 다른 사용자가 타인의 스케줄을 확인할 수 있고 좋아요, 댓글 달기가 가능합니다. 다른 사람들의 스케줄을 필터(지역, 나이, 성별) 기능에 따라 선별하여 자신이 원하는 주제에 따라 스케줄을 확인할 수 있습니다.
 
3. review
review는 여행지에 대해 사람들이 정보를 공유하는 커뮤니티 기능입니다. 여행지를 다녀온 사람들이 의미 있었던 활동과 경험을 공유하기 위해 게시글을 작성하는 곳입니다. 주제별, 도시별 게시글 작성이 가능하며 게시글에 대한 좋아요, 댓글 달기가 가능합니다.

4. mypage
mypage는 자신이 작성한 게시글 확인, 1:1 문의 내역 확인, 프로필 관리가 가능한 기능입니다. 로그인 시 네이버와 연동하여 네이버 회원으로 로그인할 수 있고 일반 회원으로 회원가입하여 로그인이 가능합니다. 프로필 사진 등록과 수정이 자유롭게 가능하며 회원 정보 수정과 탈퇴가 가능합니다.
 
## 내가 구현한 기능
* schedule
- 다른 사용자들의 스케줄을 리스트로 확인
스케줄의 공개 여부가 public으로 되어 있는 이용자들의 스케줄을 가져와 출력합니다.
 
- 다른 사람들의 스케줄을 필터(장소, 나이, 성별) 기능과 정렬(최신순, 좋아요순) 기능을 적용
필터 기능을 적용하기 위해 Mybatis 동적 쿼리를 적용하였습니다.

- 다른 사람의 스케줄의 실제 정보를 이미지처럼 가져와 리스트에 함께 출력
자신의 스케줄을 상세히 보여주는 페이지인 schedule.jsp을 include jsp 태그를 이용하여 리스트 내에 "스케줄" 컬럼에 사이즈에 맞춰 출력되게 끔 구현하였습니다.

* 네이버 로그인 연동
"네이버 아이디로 로그인 하기" API를 이용하였고 네이버 회원의 개인 정보를 JSON 토큰으로 제공받아 회원가입과 로그인 진행이 가능하도록 하였습니다.

* 네이버 회원 정보로 회원 가입
"네이버 아이디로 로그인 하기"를 통해 회원 가입을 진행한 사용자가 회원 가입 시 거쳐야 하는 페이지인 "개인정보 제공 동의 항목 체크하기"에서 해당 사용자가 일정 항목을 체크하지
않은 경우 체크한 항목은 신규 회원 정보에 입력하고 체크하지 않은 항목에 대해서 정보 입력을 요구하여 신규 회원 정보 입력을 완성하는 회원가입 절차 기능을 구현하였습니다.
