public class Review {
    private Customer customer;
    private String review;
    private int rating;

    public Review(Customer customer, String review, int rating) {
        this.customer = customer;
        this.review = review;
        this.rating = rating;
    }

    // Getters and setters
    public Customer getCustomer() {
        return customer;
    }

    public String getReview() {
        return review;
    }

    public int getRating() {
        return rating;
    }
}
