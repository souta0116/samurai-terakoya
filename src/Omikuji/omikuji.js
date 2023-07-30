<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>おみくじを引くよ</title>

<script type="text/javascript">
    // サーブレットにリクエストを投げる
    function execute() {
        location.href = "/BlogApplication/omikuji"
    }
</script>
</head>
<body>
    <!-- おみくじを引くためのボタン -->
    <input type="button" value="おみくじを引く" onclick="execute()">
</body>
</html>