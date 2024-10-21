package functools;

import jakarta.servlet.http.HttpServletRequest;
import models.Task;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Functools {
    public static String[] months = {
            "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
    };

    public static String renderTimestamp(int hour, int minute) {
        String toReturn = "";
        if (hour <= 9) {
            toReturn += "0" + hour + ":";
        } else {
            toReturn += hour + ":";
        }
        if (minute <= 9) {
            toReturn += "0" + minute;
        } else {
            toReturn += minute;
        }
        return toReturn;
    }

    public static String renderDeadline(Task task) {
        if (task.getDeadline() == null) {
            return "N/A";
        } else {
            if (task.getDeadline().getHour() == 0 && task.getDeadline().getMinute() == 0) {
                return task.getDeadline().getDayOfMonth() + " " + months[task.getDeadline().getMonth().getValue() - 1] + " " + task.getDeadline().getYear();
            } else {
                return task.getDeadline().getDayOfMonth() + " " + months[task.getDeadline().getMonth().getValue() - 1] + " " + task.getDeadline().getYear() + " (" + renderTimestamp(
                        task.getDeadline().getHour(), task.getDeadline().getMinute()
                ) + ")";
            }
        }
    }

    public static boolean isOverdue(LocalDateTime today, Task task) {
        if (task.getDeadline() == null) {
            return false;
        }
        return task.getDeadline().isBefore(today) && !task.isCompleted();
    }

    public static void handleParametersHashmap(HashMap<String, Object> hm, HttpServletRequest req) {
        hm.put("name", req.getParameter("name"));
        hm.put("description", req.getParameter("description"));
        String deadlineStr = req.getParameter("deadline");
        if (!deadlineStr.isEmpty()) {
            hm.put("deadline", LocalDateTime.parse(deadlineStr));
        } else {
            hm.put("deadline", null);
        }
        String category = req.getParameter("category");
        if (category.equals("N/A")) {
            hm.put("category", null);
        } else {
            hm.put("category", category.toLowerCase());
        }
    }
}

