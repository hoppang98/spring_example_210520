<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리 (1)</title>
</head>
<body>

	<h1>1. 변수 정의하기 (c:set)</h1>
	<c:set var="number1" value="100"/> 
	number1 : ${number1} <br> <%-- number1 : 100 --%>
	<c:set var="number2">250</c:set> 
	number2 : ${number2} <br> <%-- number2 : 250 --%>
	number1 + number2 : ${number1 + number2} <br> <%-- number1 + number2 : 350 --%>
	
	<h1>2. 변수 출력하기 (c:out)</h1>
	number1: <c:out value="${number1}"/> <br> number1: 100
	<c:out value="Hello world!!!" /> <br> <%-- Hello world!!! --%>
	<c:out value="<script>alert('얼럿창 띄우기');</script>" /> <br> <%-- 문구 그대로 출력된다. <script>alert('얼럿창 띄우기');</script> --%>
	
	<%-- 스크립트가 수행된다 --%>
	<c:out value="<script>alert('얼럿창 띄우기');</script>" escapeXml="false" />
	<%-- 문구 그대로 출력 --%>
	<c:out value="<script>alert('얼럿창 띄우기');</script>" escapeXml="true" />
	
	<h1>3. 조건문 (c:if)</h1>
	<c:if test="${number1 > 50}">
		number1은 50보다 크다.<br>
	</c:if>
	
	<c:if test="${number1 == 100}">
		number1은 100이다.<br>
	</c:if>
	
	<c:if test="${number1 eq 100}"> <%-- eq와 ==은 같은 효과 --%>)
		number1은 100이다.<br>
	</c:if>
	
	<c:if test="${number1 ne 222}"> <%-- ne와 !=은 같은 효과 --%>)
		number1은 222이 아니다.<br>
	</c:if>
	
	<c:if test="${not empty number1}"> <%-- null = empty --%>
		number1은 비어있지 않다.<br>
	</c:if>
</body>
</html>