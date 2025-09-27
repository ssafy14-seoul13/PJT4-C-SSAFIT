<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ssafit.model.dto.User" %>
<%@ include file="../common/header.jsp" %>


<% User user = (User) request.getAttribute("user");
%>


<div class="container" style="text-align:center;">
  <h2><%= user.getUserNickname() %> 님 환영합니다 🎉</h2>
  <p>이메일: <%= user.getUserEmail() %></p>
  
  <a href="user?act=signout&userId=<%= user.getUserId() %>">로그아웃</a> | 
  <a href="user?act=remove&userId=<%= user.getUserId() %>">회원탈퇴</a>
</div>
<%@ include file="../common/footer.jsp" %>
