package com.ssafit.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.ssafit.model.dao.UserDao;
import com.ssafit.model.dto.User;
import com.ssafit.util.DBUtil;

public class UserDaoImpl implements UserDao {

    private static UserDaoImpl instance = new UserDaoImpl();
    private UserDaoImpl() {}
    public static UserDaoImpl getInstance() {
        return instance;
    }

    // 개인 페이지 (ID로 회원 조회)
    @Override
    public User getUser(int userId) {
    	// sql문 삽입
        String sql = "SELECT * FROM user WHERE user_id = ?";
        // DB와 연동
        try (Connection conn = DBUtil.getConnection();
        		// SQL실행도구
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                        rs.getInt("user_id"),
                        rs.getString("user_email"),
                        rs.getString("user_password"),
                        rs.getString("user_nickname")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 회원가입
    @Override
    public void userSignUp(User user) {
        String sql = "INSERT INTO user(user_email, user_password, user_nickname) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, user.getUserEmail());
            pstmt.setString(2, user.getUserPassword());
            pstmt.setString(3, user.getUserNickname());
            pstmt.executeUpdate();

            // AUTO_INCREMENT된 user_id 가져오기
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    user.setUserId(rs.getInt(1));
                }
            }
            System.out.println("[회원가입 성공] : " + user.getUserNickname());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 로그인
    @Override
    public User userSignIn(User user) {
        String sql = "SELECT * FROM user WHERE user_email = ? AND user_password = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUserEmail());
            pstmt.setString(2, user.getUserPassword());

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    User loginUser = new User(
                        rs.getInt("user_id"),
                        rs.getString("user_email"),
                        rs.getString("user_password"),
                        rs.getString("user_nickname")
                    );
                    System.out.println("[로그인 성공] : " + loginUser.getUserNickname());
                    return loginUser;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("[로그인 실패] : 이메일 또는 비밀번호 오류");
        return null;
    }

    // 로그아웃 (DB에서는 세션 관리 X → Controller/Service에서 세션으로 처리)
    @Override
    public void userSignOut(int userId) {
        System.out.println("[로그아웃 처리] : 실제로는 세션 invalidate()로 관리");
    }

    // 회원 탈퇴
    @Override
    public void userDelete(int userId) {
        String sql = "DELETE FROM user WHERE user_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
            System.out.println("[회원 탈퇴 성공]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
