<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<%@ page isELIgnored="false"%>

<%
	if(session.getAttribute("usernum") == null){
		response.sendRedirect("/main");
	}else{
		
		int usernum = (int) session.getAttribute("usernum");
%>


<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title></title>
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/froala_blocks.css">
    <style>
        body {
            background-image: url("${pageContext.request.contextPath}/imgs/wood-1866667.jpg");
            background-size: cover;
            background-repeat: no-repeat;
        }
    </style>
</head>

<body>

    <div class="container" style="margin-top: 100px;">

        <form action="/writeAction" method="post">
            <div class="form-group">
                <label for="exampleFormControlInput1" class="font-weight-bold">タイトル</label> <input type="text" class="form-control" id="exampleFormControlInput1" name="title">
            </div>

            <div class="form-group">
                <label for="exampleFormControlTextarea1" class="font-weight-bold">内容</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" name="content" rows="10"></textarea>
            </div>

            <input type="hidden" value="<%=usernum %>" name="usernum">
            

            <button type="submit" class="btn btn-outline-dark">登録</button>
            <button type="button" class="btn btn-outline-dark" onclick="location.href='/main'">目録</button>
        </form>
    </div>



</body>

</html>

<%
	}
%>
