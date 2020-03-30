<%@include file="/includes/headerLoggetInd.inc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="FunctionLayer.MuffinBasket"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="bod">
    <table>
        <tr>
            <th>Muffin top</th>
            <th>Muffin bund</th>
            <th>Pris</th>
            <th>Slet ordre</th>
        </tr>
        <c:forEach var="item" items="${MuffinBasket.muffinsIKurv}">
            <tr>
                <td>${item.getTopType()}</td>
                <td>${item.getBundType()}</td>
                <td>${item.getStrPris()}</td>
                <td>
                    <form action="FrontController" method="post" style="text-align:center">
                        <input type="hidden" name="target" value="muffindel" >
                        <button name="muf" class="sletKnap" value="${item.getMuffinPos()}">Slet Muffin</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p style="text-decoration: underline:">Totalt beløb: ${MuffinBasket.totalAmount()}</p>
    <form class="signupForm" action="FrontController" method="post">
        <input type="hidden" name="target" value="checkoutBasket" >
        <input class="button" type="submit" value="Checkout">
    </form>
    <p style="color: red">Der var ikke nok penge på konto, fyld venligst op</p>
</div>
<%@include file="/includes/footer.inc"%>