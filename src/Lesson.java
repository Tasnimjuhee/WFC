
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;

public class Lesson {

    private int id;
    private String type;
    private String day;
    private int capacity;
    private double price;
    private List<Customer> attendees;
    private List<Review> reviews;

    public Lesson(int id, String type, String day, int capacity, double price) {
        this.id = id;
        this.type = type;
        this.day = day;
        this.capacity = capacity;
        this.price = price;
        this.attendees = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDay() {
        return day;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getDate() {
        LocalDate now = LocalDate.now();
        LocalDate lessonDate = LocalDate.of(now.getYear(), now.getMonthValue(), 1).with(TemporalAdjusters.firstInMonth(DayOfWeek.valueOf(this.day.toUpperCase())));
        while (lessonDate.isBefore(now)) {
            lessonDate = lessonDate.plusWeeks(1);
        }
        return lessonDate;
    }

    public List<Customer> getAttendees() {
        return attendees;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addAttendee(Customer customer) {
        if (attendees.size() < capacity) {
            attendees.add(customer);
        } else {
            System.out.println("Lesson is full!");
        }
    }

    public void removeAttendee(Customer customer) {
        attendees.remove(customer);
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public double getAverageRating() {
        if (reviews.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Review review : reviews) {
            sum += review.getRating();
        }
        return sum / reviews.size();
    }

}
