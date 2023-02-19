
<%@ include file="common/header.jspf" %>
<%@ include file="common/nav.jspf" %>
        <div class="container">
            welcome!!
            <hr>
            <table class="table">
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Is Done</th>
                </tr>
                <c:forEach items="${todos}" var="todo">  
                <tr>
                    <td>${todo.name}</td>
                    <td>${todo.description}</td>
                    <td>${todo.targetDate}</td>
                    <td>${todo.isDone}</td>
                    <td><a href="update-todo?id=${todo.id}" class="btn btn-primary">Update</a></td>
                    <td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
                </tr>
                </c:forEach> 
            </table>
            <a href="add-todo" class="btn btn-success">add todo</a>
        </div>
        <%@ include file="common/footer.jspf" %>
        