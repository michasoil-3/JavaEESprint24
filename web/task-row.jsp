<tr>
    <td><%=task.getName()%></td>
    <td><%=task.getDescription()%></td>
    <td><%=Functools.renderDeadline(task)%></td>
    <%
        boolean isOverdue = Functools.isOverdue(LocalDateTime.now(), task);
        if (isOverdue) {
    %>
    <td class="text-danger">Overdue</td>
    <% } else { %>
    <td class="text-<%=task.isCompleted() ? "success" : "warning" %>"><%=task.isCompleted() ? "Yes" : "No" %></td>
    <% } %>
    <td><button class="btn btn-secondary details-btn" data-bs-toggle="modal" data-bs-target="#editTaskModal"
                data-id="<%=task.getId()%>"
                data-name="<%=task.getName()%>"
                data-description="<%=task.getDescription()%>"
                data-category="<%=task.getCategory()%>"
                data-deadline="<%=task.getDeadline()%>"
                data-completion="<%=task.isCompleted()%>">Details</button></td>
</tr>