<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Orange - 글쓰기</title>
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/ckeditor.js"></script>
        <script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/translations/ko.js"></script>
        <script>
          ClassicEditor.create( document.querySelector( '#editor' ), {
            language: "ko"
          } );
        </script>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/writeStyles.css" rel="stylesheet" />
     <link rel="stylesheet" href="css/style2.css">

</head>

<body>
<header>
        <div class="inner">
            <h1><a class="header1" href="move">Orange</a></h1>

            <ul id="gnb">
                <li><a href="list">Orange</a></li>
                <li><a href="list">Orange</a></li>
                <li><a href="list">Orange</a></li>
                <li><a href="list">Orange</a></li>
                <li><a href="list">Orange</a></li>
            </ul>

            <ul class="util">
<%
if(session.getAttribute("userId")!=null){	
%>
	<li><form action="logout.jsp" method="post">
	<%=session.getAttribute("userName")%> 님 환영합니다.
	<input class="info" type="submit" value="로그아웃">
	<input class="info" type="button" value="회원 정보 수정"
			onclick="location.href='memberUpdateForm2.jsp'">
	</form></li>
	
<%
} else {
%>
				<li><input class="info" type="button" value="로그인"
			onclick="location.href='login'"></li>
			<li><input class="info" type="button" value="회원 가입"
			onclick="location.href='signUp'"></li>
<%
}
%>
				<li><input class="info" type="button" value="메인 페이지"
			onclick="location.href='move'"></li>
            </ul>
        </div>
    </header>
    <!-- Page content-->
    <div class="container mt-5">
        <div class="row">
            
                <!-- Post content-->
                <article class="writewrap">
                    <h1> 글 작성</h1>
                    <form action="${action}" method="POST">
 
                        <!-- Post header-->
                        <header class="mb-4">
                            <!-- Post title-->
                            
                            <div class="col-12">

                                <input type="text" name="title" value="${board.title}" class="form-control" id="address" placeholder="제목" required>
                                <div class="invalid-feedback">
                                    제목을 입력해 주세요.
                                </div>
                            </div>
                            <div class="col-12"> <!-- 작성자 -->
                                <input type="text" readonly name="writer" value="${board.name}" class="form-control" id="address" placeholder="<%=session.getAttribute("userName")%>"
                                    required>

                            </div>
                            <!-- Post meta content-->
                            <div class="text-muted fst-italic mb-2">바르고 고운 말을 써 주세요.</div>
                        </header>
                        <!-- Post content-->
                        <section class="mb-5">

                            <textarea name="content" id="editor">${board.content}</textarea>
                        </section>
                        <div class="forbutton">
                            <button type="submit" class="btn btn-warning">저장</button>
                            <button type="button" class="btn btn-warning" onclick="history.back()">취소</button>
                        </div>
                    </form>
                </article>


            
        </div>
    </div>
<footer>
        <div class="inner">
            <div class="upper">
                <h1>Orange Company</h1>
                <ul>
                    <li><a href="#">Policy</a></li>
                    <li><a href="#">Terms</a></li>
                    <li><a href="#">Family Site</a></li>
                    <li><a href="#">Sitemap</a></li>
                </ul>
            </div>

            <div class="lower">
                <address>
                    Orange is awesome fruits where you seen in the world!<br>
                    TEL : 031-123-1234 C.P : 010-1234-5678
                </address>
                <p>
                    2024 Orange Company &copy; copyright all right reserved.
                </p>
            </div>
        </div>
    </footer>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/ckeditor.js"></script>
    <script>
        ClassicEditor.create(document.querySelector('#editor'));
    </script>
</body>

</html>