<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>おみくじ結果表示</title>
</head>
<body>
今日の運勢は<%=request.getAttribute("omikujiResult") %>
</body>
</html>