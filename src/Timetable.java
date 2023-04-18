
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
}
