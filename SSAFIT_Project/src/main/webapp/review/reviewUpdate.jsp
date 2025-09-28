<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ssafit.model.dto.VideoReview" %>
<%@ include file="../common/header.jsp" %>

<%
    VideoReview review = (VideoReview) request.getAttribute("review");
%>

<div class="container mt-4">
  <h3>리뷰 수정</h3>
  <form action="review?act=update" method="post">
    <input type="hidden" name="reviewId" value="<%= review.getReviewId() %>">
    <input type="hidden" name="videoId" value="<%= review.getVideoId() %>">

    <div class="mb-3">
      <label class="form-label">작성자</label>
      <input type="text" name="writer" value="<%= review.getWriter() %>" class="form-control" required>
    </div>

    <div class="mb-3">
      <label class="form-label">제목</label>
      <input type="text" name="title" value="<%= review.getTitle() %>" class="form-control" required>
    </div>

    <div class="mb-3">
      <label class="form-label">내용</label>
      <textarea name="content" class="form-control" rows="5" required><%= review.getContent() %></textarea>
    </div>

    <button type="submit" class="btn btn-primary">수정</button>
    <a href="review?act=detail&reviewId=<%= review.getReviewId() %>" class="btn btn-secondary">취소</a>
  </form>
</div>

<%@ include file="../common/footer.jsp" %>
