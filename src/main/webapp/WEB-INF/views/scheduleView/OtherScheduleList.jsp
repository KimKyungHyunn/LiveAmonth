<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
</head>

<body>
   <jsp:include page="/incl/Header.jsp" />

   <!--  <div class="container">
      <div class="row">
         <div class="col-lg-12 p-0">  -->

   <!-- <div>
      <form action="/filteringScheduleList" class="filter-form">
         <h4>���� �˻�</h4>
         <label>����</label> <br> <select name="sex" id="sex"
            class="sm-width">
            <option value="0">�⺻</option>
            <option value="1">����</option>
            <option value="2">����</option>
         </select> <label>����</label> <br> <select name="age" id="age"
            class="sm-width">
            <option value="0">�⺻</option>
            <option value="20">20��</option>
            <option value="30">30��</option>
            <option value="40">40��</option>
            <option value="50">50��</option>
            <option value="60">60��</option>
         </select> <label>���</label> <br> <select name="place" id="place"
            class="sm-width">
            <option value="NULL">�⺻</option>
            <option value="SEOUL">����</option>
            <option value="JEJU">����</option>
         </select> <input type="submit" value="��ȸ">      
      </form>      
   </div> -->
   
      <form action="/filteringScheduleList" class="filter-form">
         <h4>���� �˻�</h4>
         <table>
            <thead>
               <tr>
                  <th><label>����</label></th>
                  <th><label>����</label></th>
                  <th><label>���</label></th>
                  <th></th>
               </tr>
            </thead>
            <tbody>
               <tr>
                  <td><select name="sex" id="sex" class="sm-width">
                        <option value="0">�⺻</option>
                        <option value="1">����</option>
                        <option value="2">����</option>
                  </select></td>
                  <td><select name="age" id="age" class="sm-width">
                        <option value="0">�⺻</option>
                        <option value="20">20��</option>
                        <option value="30">30��</option>
                        <option value="40">40��</option>
                        <option value="50">50��</option>
                        <option value="60">60��</option>
                  </select></td>
                  <td><select name="place" id="place" class="sm-width">
                        <option value="NULL">�⺻</option>
                           <c:forEach var="place" items="${placeList}">
                                    <option value="${place}">${place.label}</option>
                                   </c:forEach>
                  </select></td>
                  <td><input type="submit" value="��ȸ"></td>
               </tr>
            </tbody>
         </table>
      </form>

   <div class="pc-table">
      <table>
         <thead>
            <tr>
               <th class="type">������(�̹���, ����)</th>
               <th class="type">���</th>
               <th class="type">�г���</th>
               <th class="type">����</th>
               <th class="type">����</th>
               <th class="type">���ƿ� ��</th>
            </tr>
         </thead>
         <tbody>

            <c:set var="now" value="<%=new java.util.Date()%>" />
            <c:set var="sysYear">
               <fmt:formatDate value="${now}" pattern="yyyy" />
            </c:set>

            <c:set var="size" value="${fn:length(userVOList)}" />
            <c:forEach var="i" begin="0" end="${size-1}">
               <c:choose>
                  <c:when test="${userVOList[i].getUserSex() eq 'false'}">
                     <c:set var="sex" value="����" />
                  </c:when>

                  <c:otherwise>
                     <c:set var="sex" value="����" />
                  </c:otherwise>
               </c:choose>

               <tr>
                  <td>
                     <div class="title">������ ����</div> <a
                     href="/otherSchedule?useNO=${userVOList[i].getUserNO()}&scheduleNO=${scheduleVOList[i].getScheduleNO()}">
                        <img src="resources/img/scheduleImg.png" alt="">
                  </a>
                  </td>
                  <td><c:out value="${scheduleVOList[i].getPlace()}" /></td>
                  <td><c:out value="${userVOList[i].getUserNickname()}" /></td>
                  <td><c:out value="${sex}" /></td>
                  <td><c:out value="${sysYear-userVOList[i].getUserAge()}��" /></td>
                  <td><c:out
                        value="${scheduleVOList[i].getScheduleLikeCount()}" /></td>
               </tr>
            </c:forEach>
         </tbody>
      </table>
   </div>
   <!--          </div>
      </div>
   </div>  -->

   <jsp:include page="/incl/Footer.jsp" />
</body>
</html>