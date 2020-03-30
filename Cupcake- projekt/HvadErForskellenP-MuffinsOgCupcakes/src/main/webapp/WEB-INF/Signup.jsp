<%--
  Created by IntelliJ IDEA.
  User: Benjamin
  Date: 12/03/2020
  Time: 16.23
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/includes/header.inc"%>


<div class="bod">
    <form class="signupForm" action="FrontController" method="post">
        <h1> Sign up   <h2 style="color: red"> ${requestScope.error} </h2></h1>
        <input type="hidden" name="target" value="register" >
        <label class="label" >Email:</label><br>
        <input class="field" type="text"  name="email" value="" placeholder="Something@Email.com">
        <label class="label" >Password:</label><br>
        <input class="field" type="password"  name="password1" value="" placeholder="******">
        <label  class="label">Confirm password:</label><br>
        <input class="field" type="password"  name="password2" value="" placeholder="******">
        <input class="button" type="submit" value="Submit">
    </form>

    <c:if test = "${requestScope.error!= null}" >




    </c:if>


</div>
<%@include file="/includes/footer.inc"%>