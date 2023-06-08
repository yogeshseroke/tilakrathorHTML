<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="stuSer" method="post">

<input type="text" name="txt1" placeholder="enter ID" />

<br><br>

<input type="text" name="txt2" placeholder="enter Name" />

<br><br>

<input type="submit" name="btn" value="Save" />

</form>

 <%
            if(request.getParameter("q")!=null)
            {
                out.print(request.getParameter("q"));
            }
         %>

</body>
</html>