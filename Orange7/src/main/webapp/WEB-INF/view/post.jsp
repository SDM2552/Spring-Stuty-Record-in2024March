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
    <title>Orange - ${board.title}</title>
    <!-- Favicon-->
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <!-- Core theme CSS (includes Bootstrap)-->
    <link rel="stylesheet" href="css/style2.css">
    <link href="css/postStyles.css" rel="stylesheet" />
    <script src="https://kit.fontawesome.com/cb08c62fff.js" crossorigin="anonymous"></script>
	
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
			onclick="location.href='memberUpdateForm2.do'">
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
            <div class="col-lg-8">
                <!-- Post content-->
                <article>
                    <!-- Post header-->
                    <header class="mb-4">
                        <!-- Post title-->
                       
                        <h1 name="title" class="fw-bolder mb-1">${board.title}</h1>
                        <!-- Post meta content-->
                        <div class="text-muted fst-italic mb-2">Posted on ${board.regtime} by </div>
                         <div name="writer" class="text-muted fst-italic mb-2">${board.name}</div>
                         <div class="text-muted fst-italic mb-2">조회수 : ${board.hits}</div>
                    </header>
                   
                    
                    <!-- Post content-->
                    <section class="mb-5">

                        <p name="content" class="fs-5 mb-4">${board.content}</p>
                    </section>
                </article>
                
                <!-- Comments section-->
                <section class="mb-5">
                    <div class="card bg-light">
                        <div class="card-body">
                            <!-- Comment form-->
                               <form action="commentwrite.jsp" method="post" class="mb-4 formwrap" style="display: flex; align-items: center;">
                            	<input type="hidden" name="boardId" value="${board.num}">
                                <textarea class="textarea" name="comment" class="form-control mr-2" rows="3" placeholder="댓글 입력 칸"></textarea>
                                <button type="submit" id="commentbtn" class="btn btn-sm btn-primary btn1">댓글 작성</button>
                            </form>
                            <!-- Single comment-->
                            <!-- <div class="d-flex"> -->

                            <div class="ms-3">
                                <!-- <div class="fw-bold">댓글 작성자</div> -->
                                <!-- 댓글 내용 -->
                                 <div class="commentwrap1">
                                <table class="commentwrap">

<c:forEach var="co" items="${comments}">
                                    <td>${co.commentWriter}</td>
                                    <tr>
                                        <td>${co.comment}</td>
                                        <td>${co.commentTime}</td>
                                        <td><form action="commentdelete.jsp" method="post">
                                        <input type="hidden" name="commentId" value="${co.commentId}">
                                        <input type="hidden" name="boardId" value="${board.num}">
                                        <button class="xbtn" type="submit"><i class="fa-solid fa-square-xmark"></i></button>
                                        </form></td>
                                    </tr>
</c:forEach>
                                </table>
                                </div>
                                <!-- </div> -->
                            </div>
                            <!-- </div> -->
                            
                        </div>
                </section>
                        
            </div>
             <div class="lastbtn">
                 		<button type="button" class="btn btn-primary btn1" onclick="location.href='list'">목록으로</button>
                        <button type="button" class="btn btn-primary btn1" onclick="location.href='write?num=${board.num}'">글 수정</button>
                        <button type="button" class="btn btn-primary btn1" onclick="location.href='delete.jsp?num=${board.num}'">글 삭제</button>
                        </div>
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
</body>

</html>