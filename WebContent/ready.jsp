<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SimpleQuiz</title>
  <style type="text/css">
   
    body { margin: 0; font-family:'Verdana' }
   .layout {
    width: 980px; margin: auto; background: #d3dfe9; }
   .wrap { padding: 20px; }
  </style>
 </head>
 <body>
  <div class="layout">
   <div align = "center" class="wrap">
   <h1>Hello, ${name}. Are you ready?</h1>
   
  	<form  action="quiz.do" method="get">
  		<b> You have questions. Lets go!   </b><br><br>
		
   		<input type="submit" value="Run" />
   	</form>
   </div>
  </div>
 </body>
</html>