<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../common/header.jsp" %>

<h2 class="text-center mb-4">영상 등록</h2>
<form action="video?act=add" method="post" class="mx-auto" style="max-width:600px;">
  <div class="mb-3">
    <input type="text" name="title" class="form-control" placeholder="제목" required>
  </div>
  <div class="mb-3">
    <input type="text" name="url" class="form-control" placeholder="영상 URL" required>
  </div>
  <div class="mb-3">
    <input type="text" name="part" class="form-control" placeholder="운동 부위" required>
  </div>
  <div class="mb-3">
    <input type="text" name="channelName" class="form-control" placeholder="채널명" required>
  </div>
  <button type="submit" class="btn btn-success w-100">등록하기</button>
</form>

<%@ include file="../common/footer.jsp" %>
