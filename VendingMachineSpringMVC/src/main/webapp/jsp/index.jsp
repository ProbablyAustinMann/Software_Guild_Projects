<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Vending Machine</title>
  <link href="css/bootstrap.css"
        rel="stylesheet">
</head>
<body>
  <div class="container">
    <h1>Vending Machine</h1>
    <hr/>
    <ul class="list-group" id="errorMessages"></ul>

    <div class="col-md-8">
<div id='buttons' class='row'>
    <form>
        <c:forEach var="currentItem" items="${itemList}">
            <div class="col-md-4" id="button">
        <button type="button" class="btn btn-block btn-info" style="margin-bottom: 30px">
            <p>${currentItem.machineNumber}</p>
            <p>${currentItem.name}</p>
            <p>${currentItem.price}</p>
            <p>${currentItem.numberInInventory}</p>
        </button>
    </div>
        </c:forEach>
    </form>
</div>
    </div>

    <div class="col-md-4">
      <div id="moneyIn">
        <h2>Total $ In</h2>
        <div class="col-md-8">
            <input type="text"
                   class="form-control"
                   id="moneyInputBox"
                   placeholder="Total Money" required/>
                   <button type="button"
                           id="addDollar"
                           class="btn btn-default"
                           name="1.00">
                       Add Dollar
                   </button>
                   <button type="button"
                           id="addQuarter"
                           class="btn btn-default"
                           name="0.25">
                       Add Quarter
                   </button>
                   <button type="button"
                           id="addDime"
                           class="btn btn-default"
                           name="0.10">
                       Add Dime
                   </button>
                   <button type="button"
                           id="addNickel"
                           class="btn btn-default"
                           name="0.05">
                       Add Nickel
                   </button>
                   <hr/>
        </div>
      </div>

      <div id="messages">
        <h2>Messages</h2>
        <div class="col-md-20">
            <input type="text"
                   class="form-control"
                   id="messageBox"/>

                   <div id="item">
                     <h2>Item:</h2>
                     <div class="col-md-8">
                         <input type="text"
                                class="form-control"
                                id="itemBox"/>
                                <button type="button"
                                        id="makePurchaseButton"
                                        class="btn btn-default"
                                        value="purchase">
                                    Make Purchase
                                </button>
                                <hr/>
        </div>
      </div>

      <div id="change">
        <h2>Change-Box</h2>
        <div class="col-md-20">
            <input type="text"
                   class="form-control"
                   id="changeBox"/>
                   <button type="button"
                           id="returnChangeButton"
                           class="btn btn-default"
                           value="change">
                       Return Change
                   </button>
                   <hr/>

    </div>

  </div>
        
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>

