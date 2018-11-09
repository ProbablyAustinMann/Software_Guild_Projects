<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hero Information</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <style>
            tr:nth-child(even) {
                background-color:peachpuff;
            }
            td {
                border: 1px solid black;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Heroes</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/viewheroes">Heroes</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/viewlocations">Locations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/vieworgs">Organizations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/viewpowers">Powers</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/viewsightings">Sightings</a></li>
                </ul>    
            </div>
            <h2 class="text-center">${heroInfo.heroName}</h2>
            <div>
                <p>
                    <b>Description:</b> ${heroInfo.heroDescription}<br/>
                <table>
                    <tr><th><b>Powers:</b></th></tr> <c:forEach var="currentPower" items="${heroInfo.power}">
                        <tr><td><a href="viewpowerinfo?powerId=${currentPower.powerId}">${currentPower.powerDescription}</a></td></tr>
                    </c:forEach>
                </table>
                </p>
                <a href="heroedit?heroId=${heroInfo.heroId}">Edit <c:out value="${heroInfo.getHeroName()}"/>'s Information</a>

            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>
