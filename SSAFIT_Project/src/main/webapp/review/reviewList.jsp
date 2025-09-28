<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ssafit.model.dto.VideoReview" %>

<%@ include file="../common/header.jsp" %>

<%
    List<VideoReview> reviews = (List<VideoReview>) request.getAttribute("reviews");
    int videoId = (Integer) request.getAttribute("videoId");
%>

<div class="container mt-4">
  <h2>리뷰 목록</h2>
  <a href="review?act=addform&videoId=<%=videoId%>" class="btn btn-success mb-3">리뷰 작성</a>

  <%
    if (reviews != null && !reviews.isEmpty()) {
      for (VideoReview r : reviews) {
  %>
        <div class="card mb-3">
          <div class="card-body">
            <h5 class="card-title"><%= r.getTitle() %></h5>
            <p class="card-text"><%= r.getContent() %></p>
            <small class="text-muted">작성자: <%= r.getWriter() %> | 조회수: <%= r.getViewCount() %></small><br>
            <a href="review?act=detail&reviewId=<%= r.getReviewId() %>" class="btn btn-primary btn-sm">상세보기</a>
          </div>
        </div>
  <%
      }
    } else {
  %>
      <p>등록된 리뷰가 없습니다.</p>
  <%
    }
  %>
</div>

<%@ include file="../common/footer.jsp" %>
