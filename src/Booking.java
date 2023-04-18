public class Booking {
    private int id;
    private Customer customer;
    private Lesson lesson;
    private String status;

    public Booking(int id, Customer customer, Lesson lesson, String status) {
        this.id = id;
        this.customer = customer;
        this.lesson = lesson;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
}
