package com.ssafit.model.service.impl;

import java.util.List;

import com.ssafit.model.dao.VideoReviewDao;
import com.ssafit.model.dao.impl.VideoReviewDaoImpl;
import com.ssafit.model.dto.VideoReview;
import com.ssafit.model.service.VideoReviewService;

public class VideoReviewServiceImpl implements VideoReviewService {
	
	private static VideoReviewService service = new VideoReviewServiceImpl();
	private VideoReviewDao dao = VideoReviewDaoImpl.getInstance();
	
	private VideoReviewServiceImpl() {}
	
	public static VideoReviewService getInstance() {
		return service;
	}

	@Override
	public VideoReview getReview(int reviewId) {
		return dao.getReview(reviewId);
	}

	@Override
	public List<VideoReview> getReviewList(int videoId) {
		return dao.getReviewList(videoId);
	}

	@Override
	public void reviewAdd(VideoReview review) {
		dao.reviewAdd(review);
	}

	@Override
	public void reviewUpdate(VideoReview review) {
		dao.reviewUpdate(review);
	}

	@Override
	public void reviewDelete(int reviewId) {
		dao.reviewDelete(reviewId);
	}
}
