package com.ssafit.model.service.impl;

import java.util.List;
import com.ssafit.model.dao.VideoDao;
import com.ssafit.model.dao.impl.VideoDaoImpl;
import com.ssafit.model.dto.Video;
import com.ssafit.model.service.VideoService;

public class VideoServiceImpl implements VideoService {
    private static VideoService service = new VideoServiceImpl();
    private VideoDao dao = VideoDaoImpl.getInstance();

    private VideoServiceImpl() {}

    public static VideoService getInstance() {
        return service;
    }

    @Override
    public Video getVideo(int videoId) {
        return dao.getVideo(videoId);
    }

    @Override
    public void videoAdd(Video video) {
        dao.videoAdd(video);
    }

    @Override
    public List<Video> getVideoList() {
        return dao.getVideoList();
    }

    @Override
    public void videoUpdate(Video video) {
        dao.videoUpdate(video);
    }

    @Override
    public void videoDelete(int videoId) {
        dao.videoDelete(videoId);
    }
}
