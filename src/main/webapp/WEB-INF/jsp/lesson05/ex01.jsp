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
	
</body>
</html>