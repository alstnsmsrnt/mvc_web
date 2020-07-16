<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>
<%@ page import="fan.gesi.model.*" %>
<%@ page import="User.*" %>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="./css/cloud_css.css">

    <style media="screen">
      .container {
        margin-top : 10%;
        
      }
      th{
        color : white;
      }

      td{
        color : white;
      }

      .title.text-center {
        margin-bottom : 3em;
        color : white;
      }

      body {
      
        background-image: url("${pageContext.request.contextPath}/imgs/wood-1866667.jpg");
        background-size: cover;
        background-repeat: no-repeat;

      }

    </style>

  </head>


  <body>
    <div class="container-fluid">

        <div class="container" style="margin-top:5%">
        
       
        <%
        
        	if(session.getAttribute("usernum") == null){//어디에 유저넘? DAO의?
        %>
      
        <input class="btn btn-outline-dark" type="button" value="ログイン" style="margin-left:95%" onclick="location.href='/login'">
        
        <%
        	}else{
        		
		%>
              	
			<div class="row">
				<div class="col-6">
					<input class="btn btn-outline-dark" type="button" value="logout" onclick="location.href='/logout'">
		
				</div>
				
				<div class="col-6">
					<input class="btn btn-outline-dark float-right" type="button" value="書き込み" onclick="location.href='/write'">
				</div>
			</div>
		
		<% 
        
        	}
        %>
        
        <div class="title text-center" style="margin-top:50px;">
          <h1>掲示板ページ</h1>
        </div>

        <table class="table table-hover text-center">
          <thead>
            <tr>
              <th width="20%">番号</th>
              <th>タイトル</th>
              <th>作成者</th>
              <th>日付</th>
            </tr>
          </thead>
          
          <tbody>
          
          <%
          
          	// String pageNumber_str = request.getParameter("pageNumber");
          	// int pageNumber = Integer.parseInt(pageNumber_str);
          	
          	int pageNumber = (int)request.getAttribute("pageNumber");
          	int pageCount = (int)request.getAttribute("pageCount");
          
          	ArrayList<WriterVO> arrayList = (ArrayList<WriterVO>)request.getAttribute("arrayList"); //메인으로 부터의 값
            UserDAO userDAO = new UserDAO();

          	for(int i=0; i < arrayList.size(); i++){
          		
          		String writerID = userDAO.writerID(arrayList.get(i).getUsernum());      	
          %>
          
          
          	<tr>
          		<td><%= arrayList.get(i).getBoardID() %></td>
          		<td><a class="white-text" href="/view?boardid=<%= arrayList.get(i).getBoardID()%>"><%= arrayList.get(i).getTitle() %></a></td>
          		<td><%= writerID %></td>
          		<td><%= arrayList.get(i).getDate() %></td>
          	</tr>
          	
          <%
          
          	}   
          	
       	   %>
           
          
          

          </tbody>
          
         
                                                                                                                                                                                                                                                                                                                                                 
        </table>

        
          <div class="row">
          	
			<div class="col-6">
			<%
				if(pageNumber <= 1){
					
				
			%>
				<button type="button" class="btn btn-outline-dark disabled">前へ</button>
			
			
			<%

				}else{
					
			%>

				<button type="button" class="btn btn-outline-dark" onclick="location.href='/main?pageNumber=<%=pageNumber - 1%>'">前へ</button>
			
			<%
			
				}
			%>
			</div>
			

			
			<div class="col-6">
			
			<%
				if(pageNumber >= pageCount){
					
				
			%>
				<button type="button" class="btn btn-outline-dark disabled float-right">次へ</button>
			
			
			<%

				}else{
					
			%>

				<button type="button" class="btn btn-outline-dark float-right" onclick="location.href='/main?pageNumber=<%=pageNumber + 1%>'">次へ</button>
			
			<%
			
				}
			%>
			
				
				
			</div>
  					

          </div>
          	

          	
          </div>
        
		
        
        
      </div>

  </body>
</html>
