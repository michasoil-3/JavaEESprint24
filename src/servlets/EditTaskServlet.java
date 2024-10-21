package servlets;

import db.DBManager;
import functools.Functools;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

@WebServlet(value="/edit-task")
public class EditTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        HashMap<String, Object> hm = new HashMap<>();
        Functools.handleParametersHashmap(hm, req);
        boolean completed = req.getParameter("completed").equals("Yes");
        DBManager.editTask(
                id,
                (String) hm.get("name"),
                (String) hm.get("description"),
                (LocalDateTime) hm.get("deadline"),
                (String) hm.get("category"),
                completed
        );
        String selectedCategory = req.getParameter("selectedCategory");
        req.getRequestDispatcher("/?selectedCategory=" + selectedCategory).forward(req, resp);
    }
}
