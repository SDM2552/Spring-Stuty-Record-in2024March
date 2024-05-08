<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Orange site</title>
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">
    <script src="https://kit.fontawesome.com/cb08c62fff.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
    <script src="js/ie.js"></script>
</head>

<body>

    <header>
        <div class="inner">
            <h1><a href="move">Orange</a></h1>

            <ul id="gnb">
                <li><a href="list">Orange</a></li>
                <li><a href="list">Orange</a></li>
                <li><a href="list">Orange</a></li>
                <li><a href="list">Orange</a></li>
                <li><a href="login">Orange</a></li>
            </ul>

            <ul class="util">
<%
if(session.getAttribute("userId")!=null){	
%>
	<li><form action="logout" method="post">
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


    <figure>
        <video src="img/a.mp4" autoplay muted loop></video>
        <div class="inner">
            <h1>Orange</h1>
            <p>Orange is Orange and Orange of Orange with Orange also Orange where Orange that Orange kind of<br>
                Orange by Orange in Orange on the Orange out Orange is Orange and Orange of Orange with Orange <br>
                also Orange where Orange that Orange kind of Orange by Orange in Orange on the Orange out Orange is<br>
                Orange and Orange of Orange with Orange also Orange where Orange that Orange kind of Orange by Orange in
                Orange <br>
                on the Orange out Orange? Orange!
                <br>
            </p>
            <a href="#">view detail</a>
        </div>
    </figure>

    <section>
        <div class="inner">
            <h1>RECENT ORANGE NEWS</h1>
            <div class="wrap">
                <article>
                    <div class="pic">
                        <img src="img/bigorange2.jpeg" alt="1번째 콘텐츠 이미지">
                    </div>
                    <h2><a href="#">맛있는 오렌지가 열렸어요!</a></h2>
                    <p>농부 김정길(62) 씨가 수박만한 오렌지를 들고 함박 웃음을 짓고 있다. 김정길 씨는 이 오렌지를 마을 사람들과 나누어 먹었다고 한다...(더보기)</p>
                </article>

                <article>
                    <div class="pic">
                        <img src="img/fallorange2.jpeg" alt="2번째 콘텐츠 이미지">
                    </div>
                    <h2><a href="#">지구 최후의 날</a></h2>
                    <p>오늘 밤 20시 거대한 오렌지가 지구에 추락한다. 과학자들은 지구가 멸망할 거라고 말했다. 세상의 모든 생명들 안녕!...(더보기)</p>
                </article>

                <article>
                    <div class="pic">
                        <img src="img/orangecubic.jpeg" alt="3번째 콘텐츠 이미지">
                    </div>
                    <h2><a href="#">반짝반짝 오렌지</a></h2>
                    <p>오렌지는 보석보다 반짝거리며 향기롭고 맛있다. 이런 오렌지가 세상에서 가장 귀중하다는건 당연한 사실 아닐까?...(더보기)</p>
                </article>

                <article>
                    <div class="pic">
                        <img src="img/orangeburger.jpeg" alt="4번째 콘텐츠 이미지">
                    </div>
                    <h2><a href="#">오렌지 버거</a></h2>
                    <p>맥도리아는 이번달 28일 오렌지를 넣어 만든 신제품 '오렌지 버거'를 발표했다. 오렌지 버거는 선풍적인 인기를 끌며 품절대란이 났다고 한다...(더보기)</p>
                </article>
            </div>
        </div>
    </section>

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
                    "Oranges are the most awesome fruits you can find in the world!"<br>
                    TEL : 031-123-1234 C.P : 010-1234-5678
                </address>
                <p>
                    2024 Orange Company &copy; copyright all right reserved.
                </p>
            </div>
        </div>
    </footer>




</body>

</html>