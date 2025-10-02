package com.ssafit.model.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ssafit.model.dao.VideoDao;
import com.ssafit.model.dto.Video;
import com.ssafit.util.DBUtil;

public class VideoDaoImpl implements VideoDao {
    private static VideoDao dao = new VideoDaoImpl();

    private VideoDaoImpl() {}

    public static VideoDao getInstance() {
        return dao;
    }

    // 단일 영상 조회
    @Override
    public Video getVideo(int videoId) {
        String sql = "SELECT * FROM video WHERE video_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, videoId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Video(
                        rs.getInt("video_id"),
                        rs.getString("title"),
                        rs.getString("url"),
                        rs.getString("part"),
                        rs.getString("channel_name")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 영상 추가
    @Override
    public void videoAdd(Video video) {
        String sql = "INSERT INTO video (title, url, part, channel_name) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, video.getTitle());
            pstmt.setString(2, video.getUrl());
            pstmt.setString(3, video.getPart());
            pstmt.setString(4, video.getChannelName());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    video.setId(rs.getInt(1)); // DB에서 생성된 PK 세팅
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 전체 영상 조회
    @Override
    public List<Video> getVideoList() {
        List<Video> list = new ArrayList<>();
        String sql = "SELECT * FROM video";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                list.add(new Video(
                    rs.getInt("video_id"),
                    rs.getString("title"),
                    rs.getString("url"),
                    rs.getString("part"),
                    rs.getString("channel_name")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 영상 수정
    @Override
    public void videoUpdate(Video video) {
        String sql = "UPDATE video SET title=?, url=?, part=?, channel_name=? WHERE video_id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, video.getTitle());
            pstmt.setString(2, video.getUrl());
            pstmt.setString(3, video.getPart());
            pstmt.setString(4, video.getChannelName());
            pstmt.setInt(5, video.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 영상 삭제
    @Override
    public void videoDelete(int videoId) {
        String sql = "DELETE FROM video WHERE video_id=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, videoId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
