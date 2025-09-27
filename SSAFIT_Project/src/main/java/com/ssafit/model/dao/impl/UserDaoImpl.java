package com.ssafit.model.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.ssafit.model.dao.UserDao;
import com.ssafit.model.dto.User;

public class UserDaoImpl implements UserDao {
	private static AtomicInteger userId = new AtomicInteger();
	private static UserDao userDao = new UserDaoImpl();
	private Map <Integer, Boolean> signedInMap = new HashMap<>();
	private Map<Integer, User> userMap = new HashMap<>();

	
	private UserDaoImpl() {
		getInit();
	}
	
	//더미 데이터
	private void getInit() {
		 User u1 = new User("gcy9293@naver.com","1234","chaeyeon");
		    u1.setUserId(1); // 아이디값 넣어
		    userMap.put(1, u1);

		    User u2 = new User("solha@gmail.com","1234","solha");
		    u2.setUserId(2);
		    userMap.put(2, u2);

		    User u3 = new User("heily@gmail.com","1234","heily");
		    u3.setUserId(3);
		    userMap.put(3, u3);

		    userId.set(3);  //userId의 시작값을 4로 변
	}
	
	private static int updateId() {
		return userId.incrementAndGet();
	}
	
	public static UserDao getInstance() {
		return userDao;
	}
	
	//개인 페이지
	@Override
	public User getUser(int userId) {
		return userMap.get(userId);
	}

	//회원가입
	@Override
	public void userSignUp(User user) {
		
		user.setUserId(updateId());
		userMap.put(user.getUserId(), user);
	}

	//로그인
	@Override
	public User userSignIn(User user) {
		
		String inputEmail = user.getUserEmail();
		String inputPassword = user.getUserPassword();
		
		for (Map.Entry<Integer, User> entry : userMap.entrySet()) {
			User u = entry.getValue();
			
			if (u.getUserEmail().equals(inputEmail) && u.getUserPassword().equals(inputPassword)) {
				
				signedInMap.put(entry.getKey(),true);
				System.out.println("[로그인 성공] : " + u.getUserNickname());
				return u;
			} 
		}
				System.out.println("[로그인 실패] : 이메일 또는 비밀번호가 잘못되었습니다.");
				return null;
			
	}

	//로그아웃
	@Override
	public void userSignOut(int userId) {
		if (signedInMap.containsKey(userId)) {
			signedInMap.remove(userId);
			System.out.println("[로그아웃 성공] : " + userMap.get(userId).getUserNickname());
		} else {
			System.out.println("[로그아웃 실패] : 이미 로그아웃 상태입니다.");
		}
		
	}

	//탈퇴
	@Override
	public void userDelete(int userId) {
		signedInMap.remove(userId);
		userMap.remove(userId);
		System.out.println("[회원 탈퇴]");
	}
    
}
