
import java.util.ArrayList;
import java.util.List;

public class Customer {

    private int id;
    private String name;
    private List<Booking> bookings;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
        this.bookings = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void changeBooking(int bookingId, Lesson newLesson) {
        Booking booking = getBookingById(bookingId);
        if (booking != null) {
            if (newLesson.getAttendees().size() < newLesson.getCapacity()) {
                // Release one place from the previously booked lesson
                booking.getLesson().removeAttendee(this);

                // Update the booking with the new lesson
                booking.setLesson(newLesson);
                newLesson.addAttendee(this);
                booking.setStatus("Changed"); // Update the booking status

                System.out.println("Booking change is successful!");
            } else {
                System.out.println("Lesson is full! Please select another lesson.");
            }
        } else {
            System.out.println("Invalid booking ID!");
        }
    }

    public void cancelBooking(int bookingId) {
        Booking booking = getBookingById(bookingId);
        if (booking != null) {
            booking.setStatus("Cancelled");
            System.out.println("Booking cancelled!");
            bookings.remove(booking);
        } else {
            System.out.println("Invalid booking ID!");
        }
    }

    public Booking getBookingById(int bookingId) {
        return bookings.stream().filter(booking -> booking.getId() == bookingId).findFirst().orElse(null);
    }

    public boolean hasBookingForLesson(int lessonId) {
        return bookings.stream().anyMatch(booking -> booking.getLesson().getId() == lessonId);
    }

    public boolean hasAttendedLesson(int lessonId) {
        return bookings.stream().anyMatch(booking -> booking.getLesson().getId() == lessonId && booking.getStatus().equals("Attended"));
    }

}
