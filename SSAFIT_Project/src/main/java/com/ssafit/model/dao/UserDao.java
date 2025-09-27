package com.ssafit.model.dao;

import com.ssafit.model.dto.User;

public interface UserDao {
	// 개인 페이지
	public abstract User getUser(int userId);

	// 회원가입
	public abstract void userSignUp(User user);

	// 로그인
	public abstract User userSignIn(User user);

	// 로그아웃
	public abstract void userSignOut(int userId);

	// 탈퇴
	public abstract void userDelete(int userId);
}