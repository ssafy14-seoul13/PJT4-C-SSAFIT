<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.ssafit.model.dto.Video" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ssafit.model.dto.VideoReview" %>
<%@ include file="../common/header.jsp" %>

<%
    Video video = (Video) request.getAttribute("video");
    List<VideoReview> reviews = (List<VideoReview>) request.getAttribute("reviews");
%>

<div class="container mt-4">
  <!-- 영상 상세 -->
  <div class="card shadow-lg mb-4">
    <div class="ratio ratio-16x9">
      <iframe class="card-img-top" src="<%= video.getUrl() %>" allowfullscreen></iframe>
    </div>
    <div class="card-body text-center">
      <h3 class="card-title fw-bold"><%= video.getTitle() %></h3>
      <p>부위: <%= video.getPart() %></p>
      <p class="text-muted">채널: <%= video.getChannelName() %></p>
    </div>
  </div>

  <!-- 리뷰 등록 버튼 -->
  <div class="mb-3 text-end">
    <a href="review?act=addform&videoId=<%= video.getId() %>" class="btn btn-success">리뷰 작성</a>
  </div>

  <!-- 리뷰 목록 -->
  <h4>리뷰 목록</h4>
  <%
    if (reviews != null && !reviews.isEmpty()) {
        for (VideoReview r : reviews) {
  %>
    <div class="card mb-3">
      <div class="card-body">
        <h5 class="card-title"><%= r.getTitle() %></h5>
        <p class="card-text"><%= r.getContent() %></p>
        <small class="text-muted">작성자: <%= r.getWriter() %> | 조회수: <%= r.getViewCount() %></small>
        <div class="mt-2">
          <a href="review?act=detail&reviewId=<%= r.getReviewId() %>" class="btn btn-primary btn-sm">상세보기</a>
          <a href="review?act=updateform&reviewId=<%= r.getReviewId() %>" class="btn btn-warning btn-sm">수정</a>
          <a href="review?act=delete&reviewId=<%= r.getReviewId() %>&videoId=<%= video.getId() %>" class="btn btn-danger btn-sm">삭제</a>
        </div>
      </div>
    </div>
  <%
        }
    } else {
  %>
    <p class="text-muted">아직 등록된 리뷰가 없습니다.</p>
  <%
    }
  %>
</div>

<%@ include file="../common/footer.jsp" %>
