<%@ page import="com.liveamonth.liveamonth.entity.vo.UserVO" %>
<%@ page import="org.springframework.ui.Model" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<tiles:insertAttribute name="header"/>
<%
    UserVO userVO = (UserVO) request.getAttribute("userVO");
//    boolean checkUser = (boolean) request.getAttribute("checkUser");
    String pagefile = request.getParameter("page");
    if (pagefile == null) {
                pagefile = "ReCheckUserPW.jsp";
    }
%>
<tiles:insertAttribute name="profile"/>
<section class="blog-section spad">
    <div class="container">
        <div class="row">
            <tiles:insertAttribute name="sideBar"/>
            <div class="col-lg-10">
                <jsp:include page='<%="/WEB-INF/views/myPageView/"+pagefile%>'/>
            </div>
        </div>
    </div>
</section>
<tiles:insertAttribute name="footer"/>
