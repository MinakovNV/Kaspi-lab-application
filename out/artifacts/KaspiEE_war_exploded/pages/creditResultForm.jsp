<%--
  Created by IntelliJ IDEA.
  User: Nikita Minakov
  Date: 20.05.2020
  Time: 12:34 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<header>
    <%@ include file="../pages/links.jsp"%>
</header>

<head>
    <title>Credit Request Page</title>
    <%@ include file="../pages/header.jsp"%>

</head>
<body>

    <style>
        body{
            background-color: #6A6C6E;
        }
    </style>

    <div class="container">
        <form id="contact" action="" method="post">
            <h3>Credit request result: </h3>

            <h4><%=request.getAttribute("result")%></h4>

            <fieldset>
                <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Continue</button>
            </fieldset>

            <p class="copyright">Designed 4 <a href="https://kaspi.kz" target="_blank" title="">Kaspi.kz</a></p>
        </form>
    </div>

</body>

</html>