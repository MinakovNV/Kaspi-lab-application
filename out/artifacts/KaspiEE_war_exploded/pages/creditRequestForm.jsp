<%--
  Created by IntelliJ IDEA.
  User: Nikita Minakov
  Date: 18.05.2020
  Time: 11:37 AM
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
        background-color: #6A6C6E; /* Цвет фона веб-страницы */
    }
</style>

    <div class="container">
        <form id="contact" action="" method="post">
            <h3>Your credit request</h3>
            <h4>Please fill the following form</h4>
            <fieldset>
                <input placeholder="First Name" type="text" tabindex="1" name="fname" required autofocus>
            </fieldset>
            <fieldset>
                <input placeholder="Last Name" type="text" tabindex="2" name="lname" required>
            </fieldset>
            <fieldset>
                <input placeholder="Second name" type="text" tabindex="3" name="sname" required>
            </fieldset>
            <fieldset>
                <input placeholder="IIN" type="text" tabindex="4" name="iin" required>
            </fieldset>
            <fieldset>
                <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
            </fieldset>
            <p class="copyright">Designed 4 <a href="https://kaspi.kz" target="_blank" title="">Kaspi.kz</a></p>
        </form>
    </div>

</body>




</html>