<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>

<div class="container">
  <h2 style="text-align:center;">회원가입</h2>

  <!-- 절대경로 + UTF-8로 전송 -->
  <form action="<%=request.getContextPath()%>/user" method="POST" accept-charset="UTF-8">
    <input type="hidden" name="act" value="signup">

    <input type="text"     name="userEmail"    placeholder="이메일"   required>
    <input type="password" name="userPassword" placeholder="비밀번호" required>
    <input type="text"     name="userNickName" placeholder="닉네임"   required>

    <button type="submit">가입하기</button>
  </form>

  <div style="text-align:center;">
    <a href="<%=request.getContextPath()%>/user?act=signin">이미 계정이 있으신가요? 로그인</a>
  </div>
</div>

<%@ include file="../common/footer.jsp" %>
