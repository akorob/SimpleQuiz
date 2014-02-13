<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="myfn" uri="http://samplefn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>SimpleQuiz Welcome Page</title>
	  	<style type="text/css">
	    	body {font-family:'Verdana'; margin: 0; }
	   		.layout {width: 980px; margin: auto; background: #d3dfe9; }
	   		.wrap { padding: 20px; }
	  	</style>
	</head>
 	<body >
		 <div class="layout">
	   		<div  class="wrap">
	  		 User: ${name}<br><br>
	   
		
		<br><br>
	  	   	<form  action="quiz.do" method="post">
			  		<fieldset> 
						<legend>Question ${currQuesNum} from ${totalNumber}</legend> 
						<b>${questionText}</b><br><br>
						<c:forEach var="avAnsw" items="${availAnsw}">
							<c:if test="${singleAnsw==false}">
								<input type="checkbox" name="answ" value="${avAnsw}" ${myfn:contains(checkedAnsw,avAnsw)}/> ${avAnsw} <br>
								
							</c:if>
							<c:if test="${singleAnsw==true}">
								<input type="radio" name="answ" value="${avAnsw}" ${myfn:contains(checkedAnsw,avAnsw)}/>  ${avAnsw} <br>
							</c:if>
							
						</c:forEach>
						
					</fieldset><br><br>
			   		<input type="submit" name="act" value="Next" />
			   		<input type="submit" name="act" value="Finish" style="float: right;" />
		   		</form>
   			</div>
  		</div>
 	</body>
</html>