
<%@ include file="common/header.jspf" %>
<%@ include file="common/nav.jspf" %>
        <table>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>desc</th>
                <th>date</th>
                <th>done</th>
            </tr>
            <form:form>
            <tr>
                <td><form:input type="text" name="id" path="id"/></td>
                <td><form:input type="text" name="name" path="name"/></td>
                <td><form:input type="text" name="description" path="description"/></td>
                <td><form:input type="text" name="targetDate" path="targetDate"/></td>
                <td><form:input type="text" name="isDone" path="isDone"/></td>
            </tr>
            <button class="btn btn-success">Submit</button>
        </form:form>
        </table>
        <%@ include file="common/footer.jspf" %>
    