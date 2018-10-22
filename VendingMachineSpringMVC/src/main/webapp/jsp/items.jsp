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
    <form action="chooseItem" method="GET">
        <c:forEach var="currentItem" items="${itemList}">
            <div class="col-md-4" id="button">
        <button type="submit" name="itemButton" class="btn btn-block btn-info" style="margin-bottom: 30px" value="${currentItem.machineNumber}">
            <p name="machineNumber">${currentItem.machineNumber}</p>
            <p name="name">${currentItem.name}</p>
            <p name="price">${currentItem.price}</p>
            <p name="numberInInventory">${currentItem.numberInInventory}</p>
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
            <form action="moneyInput" method="GET">
            <input type="text"
                   class="form-control"
                   name="moneyInput"
                   id="moneyInputBox"
                   value="${total}"/>
            <button type="submit"
                           id="addDollar"
                           class="btn btn-default"
                           name="moneyButton"
                           value="1.00">
                       Add Dollar
                   </button>
                   <button type="submit"
                           id="addQuarter"
                           class="btn btn-default"
                           name="moneyButton"
                           value="0.25">
                       Add Quarter
                   </button>
                   <button type="submit"
                           id="addDime"
                           class="btn btn-default"
                           name="moneyButton"
                           value="0.10">
                       Add Dime
                   </button>
                   <button type="submit"
                           id="addNickel"
                           class="btn btn-default"
                           name="moneyButton"
                           value="0.05">
                       Add Nickel
                   </button>
        </form>
            <hr/>
        </div>
      </div>

      <div id="messages">
        <h2>Messages</h2>
        <div class="col-md-20">
            <form action="vendItem" method="GET">
            <input type="text"
                   class="form-control"
                   id="messageBox"
                   value="${message}"/>
                   <div id="item">
                     <h2>Item:</h2>
                     <div class="col-md-8">
                         <input type="text"
                                class="form-control"
                                name="itemBox"
                                value="${inputInt}"/>
                                <button type="submit"
                                        id="makePurchaseButton"
                                        class="btn btn-default">
                                    Make Purchase
                                </button>
                     </form>
                                <hr/>
        </div>
      </div>

      <div id="change">
        <h2>Change-Box</h2>
        <form action="giveChange" method="GET">
        <div class="col-md-20">
            <input type="text"
                   class="form-control"
                   id="changeBox"
                   value="${quarterString} quarters, ${dimeString} dimes, ${nickelString} nickels."/>
                   <button type="submit"
                           id="returnChangeButton"
                           class="btn btn-default"
                           value="change">
                       Return Change
                   </button>
                   <hr/>

    </div>
      </form>
  </div>
        
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
