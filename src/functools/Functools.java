package functools;

import models.Task;

import java.time.LocalDateTime;

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
        return task.getDeadline().isBefore(today);
    }
}

