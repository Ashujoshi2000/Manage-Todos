
        <%@ include file="common/header.jspf" %>
        <%@ include file="common/nav.jspf" %>
        <form:form method="post" modelAttribute="todo">
        
            <fieldset>
                <form:label path="name">name : </form:label>
                <form:input type="text" name="name" path="name" required="required"/>
            </fieldset>
                
            <fieldset>
                <form:label path="description">description : </form:label>
                <form:input type="text" name="description" path="description"/>
                <form:errors type="text" path="description"/>
            </fieldset>

            <fieldset>
                <form:label path="targetDate">Target Date : </form:label>
                <form:input type="text" name="targetDate" path="targetDate"/>
                <form:errors type="text" path="targetDate"/>
            </fieldset>

            <form:input type="hidden" name="id" path="id"/>
            <form:input type="hidden" name="isDone" path="isDone"/>
            
            <button class="btn btn-success">Submit</button>
        </form:form>
        
        <%@ include file="common/footer.jspf" %>
        <script type="text/javascript">
            $('#targetDate').datepicker({
                format: 'yyyy-mm-dd'
            });
        </script>
        
   