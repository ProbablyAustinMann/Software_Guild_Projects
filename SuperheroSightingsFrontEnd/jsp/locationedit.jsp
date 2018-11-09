<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Location</title>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    </head>
    <body>
        <h1 class="text-center">Edit <c:out value="${locationedit.getLocationName()}"/></h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/viewheroes">Heroes</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/viewlocations">Locations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/vieworgs">Organizations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/viewpowers">Powers</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/viewsightings">Sightings</a></li>
                </ul>    
            </div>
        <form class="form-horizontal" 
              role="form" method="POST" 
              action="editlocation">
            <div class="form-group">
                <label for="add-location-name" class="col-md-4 control-label">Location Name</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" name="locationName" placeholder="Location Name"/>
                </div>
            </div>
            <div class="form-group">
                <label for="add-address" class="col-md-4 control-label">Street Address:</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" name="address" placeholder="Street Address"/>
                </div>
            </div>
            <div class="form-group">
                <label for="add-latitude" class="col-md-4 control-label">Latitude:</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" name="latitude" placeholder="Latitude"/>
                </div>
            </div>
            <div class="form-group">
                <label for="add-longitude" class="col-md-4 control-label">Longitude:</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" name="longitude" placeholder="Longitude"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-4 col-md-8">
                    <input type="submit" class="btn btn-default" value="Submit"/>
                </div>
            </div>
            <input type="hidden" id="locationId" name="locationId" value="<c:out value="${locationedit.getLocationId()}"/>">
        </form>
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>
