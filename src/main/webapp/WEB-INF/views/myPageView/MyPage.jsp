<%@ page import="com.liveamonth.liveamonth.entity.vo.UserVO" %>
<%@ page import="org.springframework.ui.Model" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>

    <title>한달 살기</title>
</head>

<body>
 	<jsp:include page="/incl/Header.jsp" />
    <center>
        <a href="reCheckUserPW">회원 정보 수정</a>
        <a href="dropUser" >회원 탈퇴</a>
    </center>

    <jsp:include page="/incl/Footer.jsp" />
</body>

</html>