<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 추가</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
	<%-- ajax를 사용하려면 더 많은 함수가 있는 jquery js를 포함해야 한다. --%>
 	 <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 	 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원 정보 추가</h1>
		
		<form id="form" method="post" action="/lesson06/ex01/add_user">
			<b>이름:</b>
			<input type="text" class="form-control" name="name"><br>
			
			<b>생년월일:</b>
			<input type="text" class="form-control" name="yyyymmdd"><br>
			
			<b>email:</b>
			<input type="text" class="form-control" name="email"><br>
			
			<b>자기소개:</b>
			<textarea name="introduce" rows="10" cols="30" class="form-control"></textarea><br>
			
			<input type="submit" id="addBtn" class="btn btn-success" value="추가">
		</form>
	</div>
	
<script>
	$(document).ready(function() {
		// (1) jquery의 submit 기능 이용하기 id="form"을 통채로 가져오기
/* 		 $('#form').on('submit', function(e) { //form에서 submit이 일어났을 때 function이 작동
			// e.preventDefault(); // 기본으로 submit 되는 것을 막는다, 안넣으면 validation을 했는데도 그냥 submit이 되어버린다.
			
			alert("추가 버튼 클릭");
			
			//validation
			let name = $('input[name=name]').val().trim(); // 이름 가져와서 앞뒤 여백 제거
			if (name == '') {
				alert("이름을 입력하세요.");
				return false;
			}
			
			let yyyymmdd = $('input[name=yyyymmdd]').val().trim();
			if (yyyymmdd == '' {
				alert("생년월일을 입력하세요.");
				return false;
			}
			
			$(this).submit();
		});  */
		
		//(2) jQuery의 AJAX 통신 이용하기
		$('#addBtn').on('click', function(e) {
			e.preventDefault(); // 기본 submit 동작 되는 것을 막는다.
			// alert("추가 버튼 클릭");
			
			//validation
			let name = $('input[name=name]').val().trim(); // 이름 가져와서 앞뒤 여백 제거
			if (name == '') {
				alert("이름을 입력하세요.");
				return false;
			}
			
			let yyyymmdd = $('input[name=yyyymmdd]').val().trim();
			if (yyyymmdd == '' {
				alert("생년월일을 입력하세요.");
				return false;
			}
			
			if (inNaN(yyyymmdd)) {
				alert("숫자만 입력해 주세요.");
				return false;
			}
			
			let email = $('input[name=email]').val().trim();
			let introduce = $('textarea[name=introduce]').val();
			
			// AJAX : 폼태그와 상관없이 비동기로 별도 요청
			$.ajax({
				type: 'POST'
				, url: '/lesson06/ex01/add_user'
				, data: {"name" : name, "yyyymmdd" : yyyymmdd, "email" : email, "introduce : introduce"}
				, success : function(data) { // AJAX 결과는 String이다.
					alert(data);
					location.href= "/lesson06/ex01/after_add_user";
					//location.reload(); - 새로고침
				}
				, complete : function(data) {
					alert("완료"); 
				}
				, error: function(e) {
					alert("에러" + e);
				}
			});
		});
	});
</script>

</body>
</html>