<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ssafit.model.dto.VideoReview" %>
<%@ include file="../common/header.jsp" %>

<%
    VideoReview review = (VideoReview) request.getAttribute("review");
%>

<div class="container mt-4">
  <h3><%= review.getTitle() %></h3>
  <p><%= review.getContent() %></p>
  <small class="text-muted">
    작성자: <%= review.getWriter() %> | 조회수: <%= review.getViewCount() %>
  </small>

  <div class="mt-3">
    <a href="review?act=updateform&reviewId=<%= review.getReviewId() %>" class="btn btn-warning">수정</a>
    <a href="review?act=delete&reviewId=<%= review.getReviewId() %>&videoId=<%= review.getVideoId() %>" class="btn btn-danger">삭제</a>
    <a href="review?act=list&videoId=<%= review.getVideoId() %>" class="btn btn-secondary">목록</a>
  </div>
</div>

<%@ include file="../common/footer.jsp" %>
