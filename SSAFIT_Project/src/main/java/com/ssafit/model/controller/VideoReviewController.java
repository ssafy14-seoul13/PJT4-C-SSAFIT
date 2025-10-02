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

        if (act == null) act = "list";

        switch (act) {
            case "detail":   doDetail(request, response); break;
            case "addform":  doAddForm(request, response); break;
            case "add":      doAdd(request, response); break;
            case "list":     doList(request, response); break;
            case "updateform": doUpdateForm(request, response); break;
            case "update":   doUpdate(request, response); break;
            case "delete":   doDelete(request, response); break;
        }
    }

    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        VideoReview review = reviewService.getReview(reviewId);

        if (review != null) {
            review.setViewCount(review.getViewCount() + 1);
            reviewService.reviewUpdate(review);
        }

        request.setAttribute("review", review);
        request.getRequestDispatcher("/review/reviewDetail.jsp").forward(request, response);
    }

    private void doAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int videoId = Integer.parseInt(request.getParameter("videoId"));
        request.setAttribute("videoId", videoId);
        request.getRequestDispatcher("/review/reviewAdd.jsp").forward(request, response);
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int videoId = Integer.parseInt(request.getParameter("videoId"));
        String writer = request.getParameter("writer");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        
        VideoReview review = new VideoReview(0, videoId, writer, title, content, 0);
        reviewService.reviewAdd(review);

        response.sendRedirect("review?act=list&videoId=" + videoId);
    }

    private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int videoId = Integer.parseInt(request.getParameter("videoId"));
        List<VideoReview> reviews = reviewService.getReviewList(videoId);

        request.setAttribute("reviews", reviews);
        request.setAttribute("videoId", videoId);
        request.getRequestDispatcher("/review/reviewList.jsp").forward(request, response);
    }

    private void doUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        VideoReview review = reviewService.getReview(reviewId);

        request.setAttribute("review", review);
        request.getRequestDispatcher("/review/reviewUpdate.jsp").forward(request, response);
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        int videoId = Integer.parseInt(request.getParameter("videoId"));
        String writer = request.getParameter("writer");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        VideoReview review = new VideoReview(0, videoId, writer, title, content, 0);
        reviewService.reviewUpdate(review);

        response.sendRedirect("review?act=detail&reviewId=" + reviewId);
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int reviewId = Integer.parseInt(request.getParameter("reviewId"));
        int videoId = Integer.parseInt(request.getParameter("videoId"));

        reviewService.reviewDelete(reviewId);
        response.sendRedirect("review?act=list&videoId=" + videoId);
    }
}
