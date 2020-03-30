<%--
  Created by IntelliJ IDEA.
  User: Patrick
  Date: 23/03/2020
  Time: 09.08
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/includes/adminHeader.inc"%>
<%@ page contentType="text/html; charset=UTF-8" %>



<div class="bod">


    <h1>Indsæt beløb på brugeren: ${requestScope.email}</h1>

    <div class="InsertMoneyBlok">

        <form>
            <h1> Beløb: </h1>
            <input type="hidden" name="target" value="tilfojBelob" >
            <input type="hidden" name="email" value="${requestScope.email}" >
            <input class="field" type="number"  name="beløb" value="" placeholder="0 kr.">
            <input class="button" type="submit" value="Indsæt">

        </form>

    </div>


</div>





<%@include file="/includes/footer.inc"%>