<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
    <title>한달 살기</title>
</head>
<body>
<tiles:insertAttribute name="header"/>
<tiles:insertAttribute name="cityInfoSlide"/>
<tiles:insertAttribute name="cityInfoGrid"/>
<tiles:insertAttribute name="footer"/>
</body>
</html>
