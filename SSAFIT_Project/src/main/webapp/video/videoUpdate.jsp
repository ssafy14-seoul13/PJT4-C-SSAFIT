<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../common/header.jsp" %>

<h2 class="text-center mb-4">영상 수정</h2>
<form action="video?act=update" method="post" class="mx-auto" style="max-width:600px;">
  <input type="hidden" name="videoId" value="${video.id}">
  <div class="mb-3">
    <input type="text" name="title" value="${video.title}" class="form-control" required>
  </div>
  <div class="mb-3">
    <input type="text" name="url" value="${video.url}" class="form-control" required>
  </div>
  <div class="mb-3">
    <input type="text" name="part" value="${video.part}" class="form-control" required>
  </div>
  <div class="mb-3">
    <input type="text" name="channelName" value="${video.channelName}" class="form-control" required>
  </div>
  <button type="submit" class="btn btn-warning w-100">수정하기</button>
</form>

<%@ include file="../common/footer.jsp" %>
