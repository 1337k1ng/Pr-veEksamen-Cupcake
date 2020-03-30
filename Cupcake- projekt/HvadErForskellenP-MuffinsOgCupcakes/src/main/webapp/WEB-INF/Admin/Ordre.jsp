<%@include file="/includes/adminHeader.inc"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="bod">


    <h1 id="BrugerH1">Alle ordre</h1>

    <table >
        <tr>
            <th>Tidspunkt</th>
            <th>Email</th>
            <th>Bund</th>
            <th>Top</th>
            <th>Antal</th>
            <th>Total pris</th>
        </tr>
        <c:forEach var="ordre" items="${requestScope.ordreListe}">
        <tr>

            <td>${ordre.tidspunkt}</td>
            <td>${ordre.email}</td>
            <td>${ordre.bund}</td>
            <td>${ordre.top}</td>
            <td> 1 </td>
            <td>${ordre.pris}</td>



        </tr>

        </c:forEach>
        </table>

</div>





<%@include file="/includes/footer.inc"%>