<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <table class="table1">
<c:forEach var="member" items="${list}">
<tr>
	<td>${member.id}</td>
	<td>${member.name}</td>
	<td>${member.age}</td>
	<td>${member.email}</td>
	<td>${member.memo}</td>
	<td><button onclick="editMember(this)" data-id="${member.id}" data-name="${member.name}" data-age="${member.age}" data-email="${member.email}" data-memo="${member.memo}">수정</button>
	<form method="post" action="delete">
    <input type="hidden" name="id" value="${member.id}">
    <button type="submit">삭제</button>
</form>
	</td>
</tr>
</c:forEach>
    </table>

    <style>
        .table1 {
            border-collapse: separate;
            border-spacing: 0;
            background-color: rgb(243, 230, 255);
            ;
        }

        .table1 th,
        .table1 td {
            padding: 4px;
            border: 1px solid white;
        }
        .table1 td {
    white-space: nowrap; /* 텍스트 줄바꿈 방지 */
}

.table1 td button {
    display: inline-block; /* 인라인 블록 요소로 표시하여 한 줄에 정렬 */
    margin-right: 5px; /* 오른쪽 여백 추가 */
}
    </style>
    <script>
    function editMember(button) {
    	var previousCancelButton = document.getElementById("cancelButton");
        if (previousCancelButton) {
            previousCancelButton.remove();
        }
        // 버튼에서 데이터 속성을 읽어와서 멤버 정보를 가져옴
        var id = button.getAttribute("data-id");
        var name = button.getAttribute("data-name");
        var age = button.getAttribute("data-age");
        var email = button.getAttribute("data-email");
        var memo = button.getAttribute("data-memo");

        // 입력 필드에 멤버 정보 자동으로 채우기
        document.getElementById("editName").value = name;
        document.getElementById("editAge").value = age;
        document.getElementById("editEmail").value = email;
        document.getElementById("editMemo").value = memo;
        
        document.getElementById("editForm").action = "update?id=" + id;
        document.getElementById("submitButton").value = "정보 수정";
        
        var cancelButton = document.createElement("button");
        cancelButton.id = "cancelButton"; // 취소 버튼에 ID 할당
        cancelButton.textContent = "취소";
        cancelButton.onclick = function() {
        	event.preventDefault(); // 폼의 제출을 방지
            // 취소 버튼 클릭 시 페이지를 /table로 이동
            window.location.href = "/table";
        };
        document.getElementById("buttonContainer").appendChild(cancelButton);
    }
    </script>
</body>
</html>