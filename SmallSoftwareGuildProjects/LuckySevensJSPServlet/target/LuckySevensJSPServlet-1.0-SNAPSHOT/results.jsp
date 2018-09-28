<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>Results</title>
    </head>
    <body>
        <h1>Results</h1>
        <p>
            You bet $${input}.
        </p>
        <p>
            You are broke after ${rollCounter} rolls.
        </p>
        
        <p>
            You should have quit after ${rollMax} rolls when you had $${max} dollars. 
        </p>
        <a href="index.jsp">Play again?</a>
    </body>
</html>
