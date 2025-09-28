package com.ssafit.model.dao;

import java.util.List;
import com.ssafit.model.dto.VideoReview;

public interface VideoReviewDao {
    VideoReview getReview(int reviewId);
    
    List<VideoReview> getReviewList(int videoId);
    
    void reviewAdd(VideoReview review);
    
    void reviewUpdate(VideoReview review);
    
    void reviewDelete(int reviewId);
}
