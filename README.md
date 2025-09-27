# 🌟 SSAFIT 프로젝트

## 📌 0. 프로젝트 개요
**SSAFIT**은 운동 영상 정보를 기반으로 **운동 추천 및 리뷰 서비스**를 제공하는 웹 애플리케이션입니다.  
사용자는 다양한 운동 영상을 탐색하고, **운동 부위별 추천**, **영상 리뷰 작성**, **운동 계획 관리** 등 기능을 활용할 수 있습니다.  

본 프로젝트는 **Servlet & JSP 기반의 MVC 아키텍처**를 직접 구현하며,  
Tomcat 환경에서 요청/응답 흐름을 이해하고 웹 서버를 구축하는 것을 목표로 하였습니다.

---

## 🛠 1. 준비 사항

### 🔹 사용 데이터
- YouTube 운동 영상 데이터 (샘플 기반)

### 🔹 개발 언어 & 도구
- **Java (Servlet/JSP)**  
- **HTML, CSS **
- **Tomcat v10.x**  
- **Eclipse(STS), VSCode**

### 🔹 라이브러리 & 프레임워크
- **Bootstrap Framework** (UI/스타일링)

---

## 📂 2. 프로젝트 구조
```plaintext
SSAFIT/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/ssafit/
│   │   │       ├── controller/
│   │   │       │   ├── MainController.java
│   │   │       │   ├── UserController.java
│   │   │       │   ├── VideoController.java
│   │   │       │   └── VideoReviewController.java
│   │   │       ├── model/
│   │   │       │   ├── dao/
│   │   │       │   │   ├── UserDao.java
│   │   │       │   │   ├── VideoDao.java
│   │   │       │   │   ├── VideoReviewDao.java
│   │   │       │   │   └── impl/...
│   │   │       │   ├── dto/
│   │   │       │   │   ├── User.java
│   │   │       │   │   ├── Video.java
│   │   │       │   │   └── VideoReview.java
│   │   │       │   ├── service/
│   │   │       │   │   ├── UserService.java
│   │   │       │   │   ├── VideoService.java
│   │   │       │   │   ├── VideoReviewService.java
│   │   │       │   │   └── impl/...
│   │   └── webapp/
│   │       ├── common/
│   │       │   ├── header.jsp
│   │       │   └── footer.jsp
│   │       ├── user/
│   │       │   ├── userSignIn.jsp
│   │       │   ├── userSignUp.jsp
│   │       │   └── userPage.jsp
│   │       ├── video/
│   │       ├── review/
│   │       ├── index.jsp
│   │       └── main.jsp
└── README.md
```
---
## 💡 3. 주요 기능

### ✅ 필수 기능
- 회원 관리: 로그인 / 로그아웃 / 회원가입 / 수정 / 탈퇴  
- 영상 관리: 영상 등록 / 전체 조회 / 운동 부위별 검색  
- 리뷰 관리: 영상 리뷰 등록 / 조회  

### ⭐ 추가 기능
- 찜 영상 목록 관리  
- 자유 게시판 (커뮤니티)  
- 운동 계획 관리 (시각화 포함)  

---

## 👥 4. 팀 구성
- ** 솔하 채연  
