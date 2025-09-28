package com.ssafit.model.controller;

import java.io.IOException;
import java.util.List;

import com.ssafit.model.dto.Video;
import com.ssafit.model.service.VideoService;
import com.ssafit.model.service.impl.VideoServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/video")
public class VideoController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private VideoService videoService = VideoServiceImpl.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String act = request.getParameter("act");

        switch (act) {
        case "detail": // 영상 상세
            doDetail(request, response);
            break;
        case "addform": // 영상 등록 폼
            doAddForm(request, response);
            break;
        case "add": // 영상 등록
            doAdd(request, response);
            break;
        case "list": // 영상 전체 목록
            doList(request, response);
            break;
        case "updateform": // 영상 수정 폼
            doUpdateForm(request, response);
            break;
        case "update": // 영상 수정
            doUpdate(request, response);
            break;
        case "delete": // 영상 삭제
            doDelete(request, response);
            break;
        }
    }

    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int videoId = Integer.parseInt(request.getParameter("videoId"));
        Video video = videoService.getVideo(videoId);

        request.setAttribute("video", video);
        request.getRequestDispatcher("/video/videoDetail.jsp").forward(request, response);
    }

    private void doAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/video/videoAdd.jsp").forward(request, response);
    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String url = request.getParameter("url");
        String part = request.getParameter("part");
        String channelName = request.getParameter("channelName");

        Video video = new Video(0, title, url, part, channelName);
        videoService.videoAdd(video);

        response.sendRedirect("video?act=list");
    }

    private void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Video> videoList = videoService.getVideoList();

        request.setAttribute("videos", videoList);
        request.getRequestDispatcher("/video/videoList.jsp").forward(request, response);
    }

    private void doUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int videoId = Integer.parseInt(request.getParameter("videoId"));
        Video video = videoService.getVideo(videoId);

        request.setAttribute("video", video);
        request.getRequestDispatcher("/video/videoUpdate.jsp").forward(request, response);
    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int videoId = Integer.parseInt(request.getParameter("videoId"));
        String title = request.getParameter("title");
        String url = request.getParameter("url");
        String part = request.getParameter("part");
        String channelName = request.getParameter("channelName");

        Video video = new Video(videoId, title, url, part, channelName);
        videoService.videoUpdate(video);

        response.sendRedirect("video?act=detail&videoId=" + videoId);
    }

    private void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int videoId = Integer.parseInt(request.getParameter("videoId"));

        videoService.videoDelete(videoId);
        response.sendRedirect("video?act=list");
    }
}
