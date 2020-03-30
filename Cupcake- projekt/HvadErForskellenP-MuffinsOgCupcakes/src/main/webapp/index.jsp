<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="./includes/headerStartside.inc"%>
<%@ page contentType="text/html; charset=UTF-8" %>
    <div class="bod">
        <c:if test = "${requestScope.error!= null}" >
            <h2>Der skete en fejl! Prøv Igen </h2>
            ${requestScope.error}

        </c:if>
        <h1>Velkommen til Olskers Cupcakes.</h1>
        <h2>Her sælger vi de bedste af de bedste cupcakes! Og vi har mange varianter.</h2>

        <form  action="FrontController" method="post">
            <input type="hidden" name="target" value="to" >
            <input type="hidden" name="to" value="signup" >
        <a id="SignUpButton"  onclick="toSignup()"> Sign up nu og få en gratis Cupcake </a>
        </form>
        <img src="resources/Cupcake.png" id="cupcakeImg" alt="billede af cupcake på homepage">
    </div>

<%@include file="./includes/footer.inc"%>

