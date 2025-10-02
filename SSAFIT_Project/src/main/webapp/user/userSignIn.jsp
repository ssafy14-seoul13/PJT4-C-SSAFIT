<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<div class="container">
  <h2 style="text-align:center;">로그인</h2>
  
  <form action="<%=request.getContextPath()%>/user" method="post">
  	<input type="hidden" name="act" value="signin">
    <input type="text" name="userEmail" placeholder="이메일 입력" required>
    <input type="password" name="userPassword" placeholder="비밀번호 입력" required>
    <button type="submit">로그인</button>
  </form>
  
  <div style="text-align:center;">
   <a href="<%=request.getContextPath()%>/user?act=signupform">회원가입</a>
  </div>
</div>
<%@ include file="../common/footer.jsp" %>
