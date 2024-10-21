package servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value="/")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String selectedCategory = req.getParameter("selectedCategory");
        if (selectedCategory != null) {
            if (selectedCategory.isEmpty()) {
                selectedCategory = null;
            } else {
                selectedCategory = selectedCategory.trim().toLowerCase();
            }
        }

        req.setAttribute("selectedCategory", selectedCategory);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
