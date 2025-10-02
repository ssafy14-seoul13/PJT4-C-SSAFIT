package com.ssafit.model.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ssafit.model.dao.VideoReviewDao;
import com.ssafit.model.dto.VideoReview;
import com.ssafit.util.DBUtil;

public class VideoReviewDaoImpl implements VideoReviewDao {

    private static VideoReviewDaoImpl instance = new VideoReviewDaoImpl();

    private VideoReviewDaoImpl() {}

    public static VideoReviewDaoImpl getInstance() {
        return instance;
    }

    // 리뷰 단건 조회
    @Override
    public VideoReview getReview(int reviewId) {
        String sql = "SELECT * FROM review WHERE review_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, reviewId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new VideoReview(
                        rs.getInt("review_id"),
                        rs.getInt("video_id"),
                        rs.getString("writer"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getInt("view_count")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 특정 영상의 리뷰 목록
    @Override
    public List<VideoReview> getReviewList(int videoId) {
        List<VideoReview> list = new ArrayList<>();
        String sql = "SELECT * FROM review WHERE video_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, videoId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new VideoReview(
                        rs.getInt("review_id"),
                        rs.getInt("video_id"),
                        rs.getString("writer"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getInt("view_count")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 리뷰 등록
    @Override
    public void reviewAdd(VideoReview review) {
        String sql = "INSERT INTO review (video_id, writer, title, content) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, review.getVideoId());
            pstmt.setString(2, review.getWriter());
            pstmt.setString(3, review.getTitle());
            pstmt.setString(4, review.getContent());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    review.setReviewId(rs.getInt(1)); // PK 세팅
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 리뷰 수정
    @Override
    public void reviewUpdate(VideoReview review) {
        String sql = "UPDATE review SET title=?, content=? WHERE review_id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, review.getTitle());
            pstmt.setString(2, review.getContent());
            pstmt.setInt(3, review.getReviewId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 리뷰 삭제
    @Override
    public void reviewDelete(int reviewId) {
        String sql = "DELETE FROM review WHERE review_id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, reviewId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
