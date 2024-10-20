package servlets;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(value="/add-task")
public class AddTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String deadlineStr = req.getParameter("deadline");
        LocalDateTime deadline = null;
        if (!deadlineStr.isEmpty()) {
            deadline = LocalDateTime.parse(deadlineStr);
        }
        String category = req.getParameter("category");
        if (category.equals("N/A")) {
            category = null;
        } else {
            category = category.toLowerCase();
        }
        // YES DEADL, YES CAT
        // YES DEADL, NO CAT
        // NO DEADL, YES CAT
        // NO DEADL, NO CAT

        if (!deadlineStr.isEmpty() && category != null) {
            DBManager.addTask(name, description, deadline, category);
        }
        if (!deadlineStr.isEmpty() && category == null) {
            DBManager.addTask(name, description, deadline);
        }

        if (deadlineStr.isEmpty() && category != null) {
            DBManager.addTask(name, description, category);
        }

        if (deadlineStr.isEmpty() && category == null) {
            DBManager.addTask(name, description);
        }
        req.getRequestDispatcher("/").forward(req, resp);
    }
}
