<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/includes/adminHeader.inc"%>
<%@ page contentType="text/html; charset=UTF-8" %>


<div class="bod">


    <h1 id="BrugerH1"> Nuværende brugere</h1>

    <table >
        <tr>
            <th>Email</th>
            <th>saldo</th>
            <th>Rolle</th>
        </tr>
      <c:forEach var="user" items="${requestScope.brugerListe}">
          <tr>
              <td>${user.email}</td>
              <td style="width: 20%; text-align: center;">${user.password} kr.
                  <form action="FrontController" method="post" style="text-align:center">
                      <input type="hidden" name="target" value="to" >
                      <input type="hidden" name="to" value="tilfojBelob" >
                  <button class="tilføjKnap" value="${user.email}" name="bruger"> add more </button> <!--  Password er saldo i dette tilfælde haha -->
                  </form>
              </td>
              <td>${user.role}
              <form action="FrontController" method="post" style="text-align:center">
                  <input type="hidden" name="target" value="deleteBruger" >
                <button style="float: right" class="sletKnap" value="${user.email}" name="slet"> Slet bruger </button>
              </form>
              </td>
          </tr>

      </c:forEach>
    </table>
</div>
<%@include file="/includes/footer.inc"%>