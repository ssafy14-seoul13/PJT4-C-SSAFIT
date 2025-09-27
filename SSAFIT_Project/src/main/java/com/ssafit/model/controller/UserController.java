package com.ssafit.model.controller;

import java.io.IOException;

import com.ssafit.model.dto.User;
import com.ssafit.model.service.UserService;
import com.ssafit.model.service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserService userService = UserServiceImpl.getInstance();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String act = request.getParameter("act");
		
		switch (act) {
		case "page": // 개인 페이지
			doUserPage(request,response);
			break;
		case "signupform": // 회원가입
			doSignUpForm(request,response);
			break;
		case "signup": // 회원가입
			doSignUp(request,response);
			break;
		case "signin": // 로그인
			doSignIn(request,response);
			break;
		case "signout": // 로그아웃
			doSignOut(request,response);
			break;
		case "remove": // 탈퇴
			doRemove(request,response);
			break;
		
		}
	
	}


	private void doUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    int userId = Integer.parseInt(request.getParameter("userId"));
		
		request.setAttribute("user", userService.getUser(userId));
		request.getRequestDispatcher("/user/userPage.jsp").forward(request, response);
	}


	private void doSignUpForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/user/userSignUp.jsp").forward(request, response);
	}
	
	
	private void doSignUp(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		String userNickName = request.getParameter("userNickName");
		
		User user = new User (userEmail, userPassword, userNickName);
		
		userService.userSignUp(user);
		response.sendRedirect("main.jsp");
	}

	private void doSignIn(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 로그인 폼에서 입력 한 값 꺼내서저
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		
		// 가져온 정보로 user로 저
		User user = new User (userEmail, userPassword);
		
		// userService에 저장한 정보와 같으면 user객체 리턴 , 아니면 null
		User signInUser = userService.userSignIn(user);
		
		if (signInUser != null) {
			request.getSession().setAttribute("signInUser", signInUser);
			response.sendRedirect("user?act=page&userId=" + signInUser.getUserId());
		} else {
		    response.sendRedirect(request.getContextPath() + "/user/userSignIn.jsp");
		    return;
		}
		
	}

	private void doSignOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		userService.userSignOut(userId);
		request.getSession().invalidate();
		response.sendRedirect("user?act=signin");
		
	}

	private void doRemove(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int userId = Integer.parseInt(request.getParameter("userId"));
		
		userService.userDelete(userId);
		response.sendRedirect("user?act=signin");

		
	}

}
