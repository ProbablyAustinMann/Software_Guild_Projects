<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Heroes</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
        <style>
            tr:nth-child(even) {
                background-color:peachpuff;
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
            <h2 class="text-center">Extraordinary Individuals</h2>
            <div class="col-md-6">
                <table style="width:100%">
                    <c:forEach var="currentHero" items="${heroList}">
                        <tr>
                            <td>
                                <a href="viewheroinfo?heroId=${currentHero.heroId}">${currentHero.heroName}</a>
                            </td>
                            <td>
                                <a href="deletehero?heroId=${currentHero.heroId}">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-md-6">
                <h2 class="text-center">Add New Hero</h2>
                <form class="form-horizontal" 
                      role="form" method="POST" 
                      action="addhero">
                    <div class="form-group">
                        <label for="add-hero-name" class="col-md-4 control-label">Hero Name:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="heroName" placeholder="Hero Name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-hero-description" class="col-md-4 control-label">Hero Description:</label>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="heroDescription" placeholder="Hero Description"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-power" class="col-md-4 control-label">Power:</label>
                        <select multiple name="powerList" class="form-control">
                            <option value="" disabled selected>Choose Powers</option>
                            <c:forEach var="currentPower" items="${powerList}">
                                <option value="${currentPower.powerId}"> 
                                    ${currentPower.powerDescription}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-default" value="Submit"/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

