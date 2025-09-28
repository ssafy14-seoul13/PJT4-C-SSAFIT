<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ssafit.model.dto.Video" %>
<%@ include file="../common/header.jsp" %>

<h2 class="text-center mb-4">영상 목록 🎥</h2>
<div class="mb-3 text-end">
  <a href="video?act=addform" class="btn btn-success">영상 등록</a>
</div>

<div class="container">
  <div class="row justify-content-center">
    <%
      List<Video> videos = (List<Video>) request.getAttribute("videos");
      if (videos != null) {
          for (Video v : videos) {
    %>
      <!-- 카드 -->
      <div class="col-md-8 mb-4">
        <div class="card shadow-lg rounded-4">
          <!-- 영상 -->
          <div class="ratio ratio-16x9">
            <iframe class="card-img-top" src="<%= v.getUrl() %>" allowfullscreen></iframe>
          </div>
          <div class="card-body text-center">
            <h4 class="card-title fw-bold"><%= v.getTitle() %></h4>
            <p class="card-text">부위: <%= v.getPart() %></p>
            <p class="card-text text-muted">채널: <%= v.getChannelName() %></p>
          </div>
          <div class="card-footer text-center">
            <a href="video?act=detail&videoId=<%= v.getId() %>" class="btn btn-primary btn-lg">상세보기</a>
          </div>
        </div>
      </div>
    <%
          }
      }
    %>
  </div>
</div>

<%@ include file="../common/footer.jsp" %>
