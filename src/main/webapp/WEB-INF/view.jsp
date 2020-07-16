
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fan.gesi.model.WriterVO"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page isELIgnored="false"%>

<%
	WriterVO writerVO = (WriterVO)request.getAttribute("writerVO");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
<meta name="viewport"
	content="width=device-width, height=device-height, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
<link type="text/css" rel="stylesheet" href="css/froala_blocks.css">
<style>
.fdb-block {
	border-bottom: 1px solid var(- -light);
}

body {
	background-image:
		url("${pageContext.request.contextPath}/imgs/wood-1866667.jpg");
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<style>
#navigator {
	position: sticky;
	top: 0;
	z-index: 1000;
}

#navigator .navbar-toggler-icon {
	background-image:
		url("data:image/svg+xml;charset=utf8,%3Csvg viewBox='0 0 30 30' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath stroke='rgba(0, 0, 0, 0.5)' stroke-width='2' stroke-linecap='round' stroke-miterlimit='10' d='M4 7h22M4 15h22M4 23h22'/%3E%3C/svg%3E");
}

@media ( max-width : 720px) {
	#navigator {
		border-bottom: 1px solid #ccc;
	}
}

#navigator a {
	font-size: 14px;
}

#navigator+section {
	padding: 250px 0;
}
</style>


	<script>
  var page = window.location.pathname.split('/')
  page = page[page.length - 1]

  var nav = document.querySelector('a[href="' + page + '"]')
  if (nav) {
    nav.classList.add('active')
  }
  
  function menu(){
	  location.href="/main";
  }
  function update(){
	  location.href="/update";
  }
  function deletes(){
	  location.href="/delete";
  }

</script>




	<!-- Forms 7 -->
	<section class="mt-5">

		<div class="container-fluid">


			<div class="row justify-content-center">


				<div class="col-6">

					<div class="p-2 font-weight-bold">
						<label for="title">タイトル</label>
					</div>
					<div class="card text-center">
						<div class="card-header" id="title">
							<%= writerVO.getTitle() %>
						</div>
					</div>
				</div>
			</div>

			<div class="row justify-content-center">
				<div class="col-6">

					<div class="p-2 font-weight-bold">
						<label for="content">内容</label>
					</div>
					<div class="card text-center">
						<div class="card-body" id="content">
							<%= writerVO.getContent() %>
						</div>
					</div>
				</div>


			</div>


			<div class="row justify-content-center" style="margin-top: 5%">
				<div class="col-6">
					<div class="row">
						<div class="col-4">
							<button type="button" class="btn btn-outline-dark"
								onclick="menu()">メニュー</button>
						</div>

						<%
        
        				if(session.getAttribute("usernum") != null){//어디에 유저넘? DAO의?
        				
        				%>
						<div class="col-4 text-center">

							<form action="update" method="get">
								<input type="hidden" name="boardID"
									value="<%= writerVO.getBoardID()%>">
								<button type="submit" class="btn btn-outline-dark">修正</button>
							</form>
						</div>

						<div class="col-4">
							<form action="delete" method="post">
								<input type="hidden" name="boardID"
									value="<%= writerVO.getBoardID()%>">
								<button type="submit" class="btn btn-outline-dark float-right">削除</button>
							</form>
						</div>
						<% 
						} 
						%>
					</div>

				</div>
			</div>












		</div>

	</section>





</body>
</html>
