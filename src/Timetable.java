
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Timetable {

    private List<Lesson> lessons;

    public Timetable(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void generateTimetable() {
        System.out.println("\nTimetable:");
        for (Lesson lesson : lessons) {
            System.out.println("Lesson ID: " + lesson.getId() + " | Type: " + lesson.getType() + " | Day: " + lesson.getDay() + " | Price: " + lesson.getPrice());
        }
    }

    public List<Lesson> getLessonsByDay(String day) {
        return lessons.stream()
                .filter(lesson -> lesson.getDay().equalsIgnoreCase(day))
                .collect(Collectors.toList());
    }

    public List<Lesson> getLessonsByType(String type) {
        return lessons.stream()
                .filter(lesson -> lesson.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    public Lesson getLessonById(int id) {
        return lessons.stream().filter(lesson -> lesson.getId() == id).findFirst().orElse(null);
    }

    public void displayTimetable() {
        System.out.println("\nTimetable:");
        for (Lesson lesson : lessons) {
            System.out.println("Lesson ID: " + lesson.getId() + " | Type: " + lesson.getType() + " | Day: " + lesson.getDay() + " | Price: " + lesson.getPrice());
        }
    }

    public void displayTimetableByDay(String day) {
        if (!Lesson.isValidDay(day)) {
            System.out.println("Invalid day: " + day);
            return;
        }
        System.out.println("\nTimetable for " + day + ":");
        lessons.stream()
                .filter(lesson -> lesson.getDay().equalsIgnoreCase(day))
                .forEach(lesson -> System.out.println("Lesson ID: " + lesson.getId() + " | Type: " + lesson.getType() + " | Day: " + lesson.getDay() + " | Price: " + lesson.getPrice()));
    }

    public void displayTimetableByType(String type) {
        if (!Lesson.isValidType(type)) {
            System.out.println("Invalid type: " + type);
            return;
        }
        System.out.println("\nTimetable for " + type + ":");
        lessons.stream()
                .filter(lesson -> lesson.getType().equalsIgnoreCase(type))
                .forEach(lesson -> System.out.println("Lesson ID: " + lesson.getId() + " | Type: " + lesson.getType() + " | Day: " + lesson.getDay() + " | Price: " + lesson.getPrice()));
    }

    public void displayTimetableByDayAndType(String day, String type) {
        if (!Lesson.isValidDay(day) || !Lesson.isValidType(type)) {
            System.out.println("Invalid day or type: " + day + ", " + type);
            return;
        }
        System.out.println("\nTimetable for " + day + " and " + type + ":");
        lessons.stream()
                .filter(lesson -> lesson.getDay().equalsIgnoreCase(day) && lesson.getType().equalsIgnoreCase(type))
                .forEach(lesson -> System.out.println("Lesson ID: " + lesson.getId() + " | Type: " + lesson.getType() + " | Day: " + lesson.getDay() + " | Price: " + lesson.getPrice()));
    }

}
