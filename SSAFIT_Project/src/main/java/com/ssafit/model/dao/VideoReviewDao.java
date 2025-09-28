package com.ssafit.model.dao;

import java.util.List;
import com.ssafit.model.dto.VideoReview;

public interface VideoReviewDao {
    // 특정 리뷰 조회
    public abstract VideoReview getReview(int reviewId);

    // 특정 영상의 모든 리뷰 조회
    public abstract List<VideoReview> getReviewList(int videoId);

    // 리뷰 등록
    public abstract void reviewAdd(VideoReview review);

    // 리뷰 수정
    public abstract void reviewUpdate(VideoReview review);

    // 리뷰 삭제
    public abstract void reviewDelete(int reviewId);
}
