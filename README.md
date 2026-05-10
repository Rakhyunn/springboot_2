## 1차 요구사항 구현
- [X] 유저가 루트 url로 접속시에 게시글 리스트 페이지(http://주소:포트/article/list)가 나온다.
- [X] 리스트 페이지에서는 등록 버튼이 있고 버튼을 누르면 http://주소:포트/article/create 경로로 이동하고 등록 폼이 나온다.
- [X] 게시글 등록을 하면 http://주소:포트/article/create로 POST 요청을 보내어 DB에 해당 내용을 저장한다.
- [X] 게시글 등록이 되면 해당 게시글 리스트 페이지로 리다이렉트 된다. 페이지 URL 은 http://주소:포트/article/list 이다.
- [X] 리스트 페이지에서 해당 게시글을 클릭하면 상세페이지로 이동한다. 해당 경로는 http://주소:포트/article/detail/{id} 가 된다.
- [X] 게시글 상세 페이지에는 목록 버튼이 있다. 목록 버튼을 누르면 게시글 리스트 페이지로 이동하게 된다.

# 2차 요구사항
- [X] 게시글 상세페이지(http://주소:포트/article/detail/{id})에 수정 버튼이 있다. 수정 버튼을 누르면 게시글을 수정 할 수 있는 폼이나 오고 수정이 가능하다.
- [X] 게시글 상세페이지에 삭제 버튼이 있다. 삭제 버튼을 누르면 게시글이 삭제가 된다. 삭제 후 리스트 페이지로 리다이렉트 된다.
- [X] 모든 페이지 상단에 루트 디렉토리로 이동하는 버튼이 있다.(예: 로고)
- [X] 모든 페이지 상단에 로그인 상태 표시하는 버튼이 있다.(예: 로그인 / 로그아웃) 
- [X] 모든 페이지 회원가입 버튼이 있다. 버튼을 누르면 회원가입 폼으로 이동한다.
	- [X] 회원가입 폼은 유저ID, 닉네임, 비빌번호, 비밀번호 확인으로 구성된다. 회원가입 버튼을 누르면 데이터 검증 후 회원가입이 된다.
- [X] 로그인 버튼을 누르면 로그인 폼으로 이동한다. 
	- [X] 로그인 페이지는 사용자 유저ID과 비밀번호를 입력하는 폼으로 구성되고 로그인 버튼을 누르면 데이터 검증 후 로그인이 된다.
- [X] 로그아웃 버튼을 누르면 로그아웃이 된다.
- [X] 유저가 게시글 작성 및 수정  접근시 로그인 여부를 검사하고 본인 글에 대해서만 수정 / 삭제가 가능하다.(본인 글에 대해서만 수정 / 삭제가 가능하다.)
- [X] (선택)메인페이지에 검색 기능이 구현되어야 한다. input 박스에 내용을 적고 검색 버튼을 누르면 해당 문자가 포함된 게시글이 리스트업 되어야 한다.

## 미비사(선택)항 or 막힌 부분
### 프론트 구현 미숙
- 1차 때와 마찬가지로 뷰 구현 시 타임리프와 html을 구현하는 것이 미숙하여 AI와 교안을 적극 활용하여 구현하였습니다.
- 그래도 읽어보면서 구현해서 문법이나 방식이 어느 정도 눈에 익고 있습니다.
- 검색 `input`에 검색 후 키워드가 없어져서 알아보니 유지하려면 모델에 전달해야 하는 것을 파악하였습니다.
### 스프링 시큐리티
- 아무래도 아예 처음 접하는 부분이라 구글링, AI, 교안을 활용하여 구현하였습니다.
- 거의 교안을 보며 따라 구현하며 이해했지만 `SecurityConfig`, `MemberSecurityService`를 따로 구현하는 이유나 `MemberRole`을 역할 등 애매하게 이해하고 넘어간 부분이 많아 공부할 부분이 있습니다.
- 더불어 스프링 시큐리티 동작이 아직은 어색해서 원리를 더 공부하고 알아보려고 합니다.(내부 함수나 구현하는 여러 방식 등 탐색 및 공부)

## UI/UX (화면 캡처본을 복사 붙여 넣기, url 주소 나오도록)
- 게시글 리스트 페이지
  <img width="1272" height="601" alt="image" src="https://github.com/user-attachments/assets/a3b63595-e4c4-4863-9efd-417d4bb9a7de" />
- 게시글 등록 폼 페이지
  <img width="1274" height="947" alt="image" src="https://github.com/user-attachments/assets/39f7c2a4-7ee7-4a3f-966e-a6cc3a536392" />
- 게시글 상세 페이지
  - 본인 게시물일 경우(수정, 삭제 버튼 노출)
    <img width="1271" height="677" alt="image" src="https://github.com/user-attachments/assets/36928bb2-017c-4816-9969-af3762fd92dd" />
  - 본인 게시물이 아닐 경우(목록 버튼만 노출)
    <img width="1274" height="601" alt="image" src="https://github.com/user-attachments/assets/059b9137-b620-4d36-a131-844094977e4d" />
- 게시글 수정 페이지
  <img width="1277" height="762" alt="image" src="https://github.com/user-attachments/assets/14fddfea-7866-4d1a-b17d-99b5325500a6" />
- 로그인 페이지
  <img width="1269" height="931" alt="image" src="https://github.com/user-attachments/assets/ce293fe1-565d-419f-9a86-6cc2063682fd" />
- 회원가입 페이지
  <img width="1270" height="783" alt="image" src="https://github.com/user-attachments/assets/5a793c05-cc68-455a-8208-322ac78001ea" />
- (선택) 검색 페이지
  - 제목이나 내용 포함되면 노출
  <img width="1274" height="587" alt="image" src="https://github.com/user-attachments/assets/f624257a-e4e4-4cd3-b6c6-a7d00103ae15" />
