<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lucky Sevens</title>
    </head>
    <body>
        <h1>Lucky Sevens</h1>
        <p>
            Please enter a money amount.
        </p>
        <form method="post" action="LuckySevensJSPServlet">
            <input type="text" name="moneyInput"/><br/>
            <input type="submit" value="Roll Dice"/>
        </form>
    </body>
</html>
