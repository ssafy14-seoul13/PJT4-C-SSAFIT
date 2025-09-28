package com.ssafit.model.controller;

import java.io.IOException;
import java.util.List;

import com.ssafit.model.dto.VideoReview;
import com.ssafit.model.service.VideoReviewService;
import com.ssafit.model.service.impl.VideoReviewServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/review")
public class VideoReviewController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private VideoReviewService reviewService = VideoReviewServiceImpl.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String act = request.getParameter("act");

        switch (act) {
        case "detail":   // 리뷰 상세
            doDetail(request, response);
            break;
        case "addform":  // 리뷰 등록 폼
            doAddForm(request, response);
            break;
        case "add":      // 리뷰 등록
            doAdd(request, response);
            break;
        case "list":     // 특정 영상의 리뷰 목록
            doList(request, response);
            break;
        case "updateform": // 리뷰 수정 폼
            doUpdateForm(request, response);
            break;
        case "update":   // 리뷰 수정
            doUpdate(request, response);
            break;
        case "delete":   // 리뷰 삭제
            doDelete(request, response);
            break;
        }
    }

    // 특정 리뷰 상세 보기
    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        VideoReview review = reviewService.getReview(reviewId);

        if (review != null) {
            review.setViewCount(review.getViewCount() + 1); // 조회수 증가
            reviewService.reviewUpdate(review);
        }

        request.setAttribute("review", review);
        request.getRequestDispatcher("/review/reviewDetail.jsp").forward(request, response);
    }

    // 리뷰 등록 폼
    private void doAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int videoId = Integer.parseInt(request.getParameter("videoId"));
        request.setAttribute("videoId", videoId);
        request.getRequestDispatcher("/review/reviewAdd.jsp").forward(request, response);
    }

    // 리뷰 등록 처리
    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int videoId = Integer.parseInt(request.getParameter("videoId"));
        String writer = request.getParameter("writer");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        VideoReview review = new VideoReview(videoId, 0, writer, title, content);
        reviewService.reviewAdd(review);

        response.sendRedirect("review?act=list&videoId=" + videoId);
    }

    // 특정 영상의 리뷰 목록
    private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int videoId = Integer.parseInt(request.getParameter("videoId"));
        List<VideoReview> reviews = reviewService.getReviewList(videoId);

        request.setAttribute("reviews", reviews);
        request.setAttribute("videoId", videoId);
        request.getRequestDispatcher("/review/reviewList.jsp").forward(request, response);
    }

    // 리뷰 수정 폼
    private void doUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        VideoReview review = reviewService.getReview(reviewId);

        request.setAttribute("review", review);
        request.getRequestDispatcher("/review/reviewUpdate.jsp").forward(request, response);
    }

    // 리뷰 수정 처리
    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        int videoId = Integer.parseInt(request.getParameter("videoId"));
        String writer = request.getParameter("writer");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        VideoReview review = new VideoReview(videoId, reviewId, writer, title, content);
        reviewService.reviewUpdate(review);

        response.sendRedirect("review?act=detail&reviewId=" + reviewId);
    }

    // 리뷰 삭제
    private void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        int videoId = Integer.parseInt(request.getParameter("videoId"));

        reviewService.reviewDelete(reviewId);
        response.sendRedirect("review?act=list&videoId=" + videoId);
    }
}
