public class Review {
    private Customer customer;
    private Lesson lesson;
    private String reviewText;
    private int rating;

    public Review(Customer customer, Lesson lesson, String reviewText, int rating) {
        this.customer = customer;
        this.lesson = lesson;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public String getReviewText() {
        return reviewText;
    }

    public int getRating() {
        return rating;
    }
}
