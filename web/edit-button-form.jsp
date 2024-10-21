<form method="GET" id="editForm" action="${pageContext.request.contextPath}/edit-task">
  <input type="hidden" id="hiddenIdInput" name="id">
  <label for="name">Name:</label><br>
  <input type="text" style="width: 465px;" id="name" name="name"><br>
  <label for="description">Description:</label>
  <textarea style="width: 465px;" id="description" name="description"></textarea><br>
  <label for="category">Category:</label><br>
  <select id="category" name="category">
    <option>N/A</option>
    <option>Personal</option>
    <option>Professional</option>
    <option>School</option>
  </select><br>
  <label for="deadline">Deadline (optional):</label><br>
  <input type="datetime-local" id="deadline" name="deadline"><br>
  <label for="completed">Completed?</label><br>
  <select id="completed" name="completed">
    <option>No</option>
    <option>Yes</option>
  </select><br>
  <button class="btn btn-primary">Edit</button>
</form>
