<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Superhero Sightings</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Superhero Sightings</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/viewheroes">Heroes</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/viewlocations">Locations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/vieworgs">Organizations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/viewpowers">Powers</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/viewsightings">Sightings</a></li>
                </ul>    
            </div>
            <h2 class="text-center">Welcome to Superhero Sightings!</h2>
            <h3 class="text-center">Recent Activity:</h3>
            <c:forEach var="currentSight" items="${lastTen}">
                <h5><a href="viewsightinginfo?sightingId=${currentSight.sightingId}">${currentSight.date} | ${currentSight.sightingDescription}</a></h5>
            </c:forEach>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

