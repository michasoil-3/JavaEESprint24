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

@WebServlet(value="/add-task")
public class AddTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> hm = new HashMap<>();
        Functools.handleParametersHashmap(hm, req);
        DBManager.addTask(
                (String) hm.get("name"),
                (String) hm.get("description"),
                (LocalDateTime) hm.get("deadline"),
                (String) hm.get("category")
        );
        req.getRequestDispatcher("/").forward(req, resp);
    }
}
