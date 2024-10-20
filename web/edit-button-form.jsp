<form method="GET" action="${pageContext.request.contextPath}/edit-task">
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
  <label for="completion">Completed?</label><br>
  <select id="completion">
    <option>No</option>
    <option>Yes</option>
  </select><br>
  <button class="btn btn-primary">Edit</button>
</form>
