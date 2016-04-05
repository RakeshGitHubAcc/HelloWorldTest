<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Test Restful webservice :
<br/>
Text: <a href="<%= request.getRequestURL() %>rest/publish/Rakesh">Click</a>
<br/>
(Json): <a href="<%= request.getRequestURL() %>rest/info/10">Click</a>

</body>
</html>