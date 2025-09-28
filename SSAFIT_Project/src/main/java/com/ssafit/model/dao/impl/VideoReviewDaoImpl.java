package com.ssafit.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.ssafit.model.dao.VideoReviewDao;
import com.ssafit.model.dto.VideoReview;

public class VideoReviewDaoImpl implements VideoReviewDao {

    private static VideoReviewDaoImpl instance = new VideoReviewDaoImpl();
    private List<VideoReview> reviewDB = new ArrayList<>();
    private int seq = 1;

    private VideoReviewDaoImpl() {}

    public static VideoReviewDaoImpl getInstance() {
        return instance;
    }

    @Override
    public VideoReview getReview(int reviewId) {
        return reviewDB.stream().filter(r -> r.getReviewId() == reviewId).findFirst().orElse(null);
    }

    @Override
    public List<VideoReview> getReviewList(int videoId) {
        List<VideoReview> list = new ArrayList<>();
        for (VideoReview r : reviewDB) {
            if (r.getVideoId() == videoId) list.add(r);
        }
        return list;
    }

    @Override
    public void reviewAdd(VideoReview review) {
        review.setReviewId(seq++);
        reviewDB.add(review);
    }

    @Override
    public void reviewUpdate(VideoReview review) {
        for (int i = 0; i < reviewDB.size(); i++) {
            if (reviewDB.get(i).getReviewId() == review.getReviewId()) {
                reviewDB.set(i, review);
                return;
            }
        }
    }

    @Override
    public void reviewDelete(int reviewId) {
        reviewDB.removeIf(r -> r.getReviewId() == reviewId);
    }
}
