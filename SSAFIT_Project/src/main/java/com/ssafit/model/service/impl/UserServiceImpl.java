package com.ssafit.model.service.impl;


import com.ssafit.model.dao.UserDao;
import com.ssafit.model.dao.impl.UserDaoImpl;
import com.ssafit.model.dto.User;
import com.ssafit.model.service.*;

public class UserServiceImpl implements UserService {

	//싱글턴
	private static UserService userService = new UserServiceImpl();
	
	private UserDao userDao = UserDaoImpl.getInstance();
	
	private UserServiceImpl() {}
	
	public static UserService getInstance() {
		return userService;
	}
	
	//개인 페이지
	@Override
	public User getUser(int userId) {
		return userDao.getUser(userId);
	}

	//회원가입
	@Override
	public void userSignUp(User user) {
		userDao.userSignUp(user);
	}

	//로그인
	@Override
	public User userSignIn(User user) {
		return userDao.userSignIn(user);
	}

	//로그아웃
	@Override
	public void userSignOut(int userId) {
		userDao.userSignOut(userId);
	}

	//탈퇴
	@Override
	public void userDelete(int userId) {
		userDao.userDelete(userId);
	}

}
