<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../common/header.jsp" %>

<div class="container mt-4">
  <h3>리뷰 작성</h3>
  <form action="<%= request.getContextPath() %>/review?act=add" method="post">
    <input type="hidden" name="videoId" value="<%= request.getAttribute("videoId") %>">

    <div class="mb-3">
      <label class="form-label">작성자</label>
      <input type="text" name="writer" class="form-control" required>
    </div>

    <div class="mb-3">
      <label class="form-label">제목</label>
      <input type="text" name="title" class="form-control" required>
    </div>

    <div class="mb-3">
      <label class="form-label">내용</label>
      <textarea name="content" class="form-control" rows="5" required></textarea>
    </div>

    <button type="submit" class="btn btn-success">등록</button>
    <a href="javascript:history.back()" class="btn btn-secondary">취소</a>
  </form>
</div>

<%@ include file="../common/footer.jsp" %>
