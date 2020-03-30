<%--
  Created by IntelliJ IDEA.
  User: Benjamin
  Date: 12/03/2020
  Time: 16.23
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/includes/header.inc"%>

<div class="bod">
    <form class="signupForm" action="FrontController" method="POST">
        <h1> Log in </h1>
        <input type="hidden" name="target" value="login" >
        <label class="label" >Email:</label><br>
        <input class="field" type="text"  name="email" value="" placeholder="Something@Email.com">
        <label class="label" >Password:</label><br>
        <input class="field" type="text"  name="password" value="" placeholder="******">
        <input class="button" type="submit" value="Submit">
    </form>
</div>
    <c:if test = "${requestScope.error!= null}" >

        <h2>Error ! </h2>
        ${requestScope.error}

    </c:if>
</div>
<%@include file="/includes/footer.inc"%>