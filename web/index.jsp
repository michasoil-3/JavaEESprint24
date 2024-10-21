<%@ page import="db.DBManager" %>
<%@ page import="models.Task" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="functools.Functools" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String selectedCategory = (String) request.getAttribute("selectedCategory"); %>
<html>
<head>
    <title>Home</title>
    <%@ include file="links.jsp" %>
</head>
    <body>
        <%@ include file="navbar.jsp"%>
        <div class="modal fade" id="addTaskModal" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Add new task</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <%@ include file="add-button-form.jsp" %>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="editTaskModal" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Edit task</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <%@ include file="edit-button-form.jsp" %>
                    </div>
                    <div class="modal-footer">
                        <a class="btn btn-danger" id="deleteButton">Delete</a>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

        <button class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#addTaskModal">
            <span>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-square-fill" viewBox="0 0 16 16">
                    <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm6.5 4.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3a.5.5 0 0 1 1 0"></path>
                </svg>
                New task
            </span>
        </button>

        <%
            ArrayList<Task> tasks;
            if (selectedCategory == null) {
                tasks = DBManager.getTasks();
            } else {
                tasks = DBManager.getTasksByCategory(selectedCategory);
            }

            if (selectedCategory != null) { %>
            <div>
                <p class="text-warning">You have applied a filter for the following category: <%=selectedCategory%></p>
            </div>
        <% } %>
        <%
            if (tasks.isEmpty()) {
        %>
        <div>
            <p>Oops, looks like you don't have any tasks!</p>
        </div>
        <%
            } else {

        %>
                <div>
                    <table class="table table-primary border border-secondary border-2">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Deadline</th>
                            <th>Is complete?</th>
                            <th>Details</th>
                        </tr>
                        </thead>
                        <tbody>
                        <% for (Task task: tasks) {%>
                            <%@ include file="task-row.jsp" %>
                        <% } %>
        <%
            }
        %>
                        <script>
                            const editTaskModal = document.getElementById('editTaskModal');
                            editTaskModal.addEventListener('show.bs.modal', event => {
                                // Getting button
                                const button = event.relatedTarget;

                                // Data extraction
                                const id = button.getAttribute("data-id");
                                const name = button.getAttribute('data-name');
                                const description = button.getAttribute('data-description');
                                const category = button.getAttribute('data-category');
                                const deadline = button.getAttribute('data-deadline');
                                const completion = button.getAttribute('data-completion');

                                // Autofill
                                const modalNameInput = editTaskModal.querySelector('#name');
                                const modalDescriptionInput = editTaskModal.querySelector('#description');
                                const modalCategorySelect = editTaskModal.querySelector('#category');
                                const modalDeadlineInput = editTaskModal.querySelector('#deadline');
                                const modalCompletionSelect = editTaskModal.querySelector('#completed');

                                modalNameInput.value = name;
                                modalDescriptionInput.value = description;
                                modalCategorySelect.value = category === "null" ? "N/A" : category.charAt(0).toUpperCase() + category.substring(1, category.length);
                                modalDeadlineInput.value = deadline;
                                modalCompletionSelect.value = completion === 'true' ? 'Yes' : 'No';

                                // Ensuring delete button works
                                const deleteButton = document.querySelector("#deleteButton")
                                deleteButton.href = "${pageContext.request.contextPath}/delete-task?id=" + id + "&selectedCategory=<%= selectedCategory == null ? "" : selectedCategory %>";

                                // Setting correct action for edit form
                                const hiddenIdInput = document.querySelector("#hiddenIdInput")
                                hiddenIdInput.value = id

                                // Setting correct filtering category for edit form
                                const hiddenCategoryFilterer = document.querySelector("#hiddenCategoryToFilter")
                                hiddenCategoryFilterer.value = "<%= selectedCategory == null ? "" : selectedCategory %>";
                            });
                        </script>
                        </tbody>
                    </table>
                </div>
    </body>
</html>
