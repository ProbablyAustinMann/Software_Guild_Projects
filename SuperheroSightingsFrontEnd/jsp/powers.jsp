<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Powers</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <style>
            tr:nth-child(even) {
                background-color:peachpuff;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Powers</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/viewheroes">Heroes</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/viewlocations">Locations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/vieworgs">Organizations</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/viewpowers">Powers</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/viewsightings">Sightings</a></li>
                </ul>    
            </div>
            <h2 class="text-center">Known Powers</h2>
            <div class="col-md-6">
                <table style="width:100%">
                    <c:forEach var="currentPower" items="${powerList}">
                        <tr>
                            <td>
                                <a href="viewpowerinfo?powerId=${currentPower.powerId}">${currentPower.powerDescription}</a>
                            </td>
                            <td>
                                <a href="deletepower?powerId=${currentPower.powerId}">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-md-6">
                    <h2 class="text-center">Add New Power</h2>
                    <form class="form-horizontal" 
                          role="form" method="POST" 
                          action="addpower">
                        <div class="form-group">
                            <label for="add-power-description" class="col-md-4 control-label">Description:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="powerDescription" placeholder="Power Description"/>
                            </div>
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
