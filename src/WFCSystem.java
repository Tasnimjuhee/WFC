
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.time.temporal.TemporalAdjusters;

public class WFCSystem {

    private List<Customer> customers;
    private Timetable timetable;
    private List<Lesson> lessons;

    public WFCSystem() {
        customers = new ArrayList<>();
        lessons = new ArrayList<>();
        timetable = new Timetable(lessons);
    }

    public static void main(String[] args) {
        WFCSystem wfcSystem = new WFCSystem();
        wfcSystem.initTimetable();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nWelcome to the Weekend Fitness Club (WFC) Booking System");
            System.out.println("--------------------------------------------------------");
            System.out.println("1. Add a customer");
            System.out.println("2. Book a group fitness lesson");
            System.out.println("3. Change/Cancel a booking");
            System.out.println("4. Attend a lesson");
            System.out.println("5. Generate monthly lesson report");
            System.out.println("6. Generate monthly champion fitness type report");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.next();
                    int id = wfcSystem.addCustomer(name);
                    System.out.println("Customer added successfully with ID : " + id);
                    break;
                case 2:
                    System.out.print("Enter customer ID: ");
                    int customerId = scanner.nextInt();
                    wfcSystem.timetable.displayTimetable();
                    System.out.print("Enter lesson ID: ");
                    int lessonId = scanner.nextInt();
                    int bid = wfcSystem.bookLesson(customerId, lessonId);
                    if (bid != -1) {
                        System.out.println("Booked with ID : " + bid);
                    }
                    break;
                case 3:
                    System.out.print("Enter customer ID: ");
                    customerId = scanner.nextInt();
                    System.out.print("Enter booking ID: ");
                    int bookingId = scanner.nextInt();
                    System.out.print("Enter new lesson ID (or 0 to cancel): ");
                    int newLessonId = scanner.nextInt();
                    wfcSystem.changeOrCancelBooking(customerId, bookingId, newLessonId);
                    break;
                case 4:
                    System.out.print("Enter customer ID: ");
                    customerId = scanner.nextInt();
                    System.out.print("Enter lesson ID: ");
                    lessonId = scanner.nextInt();
                    wfcSystem.attendLesson(customerId, lessonId);
                    break;
                case 5:
                    System.out.print("Enter month number (e.g., 3 for March): ");
                    int month = scanner.nextInt();
                    wfcSystem.generateMonthlyLessonReport(month);
                    break;
                case 6:
                    System.out.print("Enter month number (e.g., 3 for March): ");
                    month = scanner.nextInt();
                    wfcSystem.generateMonthlyChampionFitnessTypeReport(month);
                    break;
                case 0:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    public void initTimetable() {
        // Define lesson types, days, and prices
        String[] lessonTypes = {"Spin", "Yoga", "Bodysculpt", "Zumba"};
        String[] days = {"Saturday", "Sunday"};
        double[] prices = {10.0, 12.0, 15.0, 8.0};

        // Initialize the timetable with lessons
        int lessonId = 1;
        for (int i = 0; i < 8; i++) { // 8 weekends
            for (int j = 0; j < lessonTypes.length; j++) { // 4 lesson types
                for (String day : days) { // Saturday and Sunday
                    Lesson lesson = new Lesson(lessonId, lessonTypes[j], day, 5, prices[j]);
                    lessons.add(lesson);
                    lessonId++;
                }
            }
        }
    }

    public int addCustomer(String name) {
        int customerId = customers.size() + 1;
        customers.add(new Customer(customerId, name));
        return customerId;
    }

    public int bookLesson(int customerId, int lessonId) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            if (customer.hasBookingForLesson(lessonId)) {
                System.out.println("Customer has already booked this lesson!");
                return -1;
            }

            Lesson lesson = timetable.getLessonById(lessonId);
            if (lesson != null) {
                if (lesson.getAttendees().size() < lesson.getCapacity()) {
                    int bookingId = customer.getBookings().size() + 1;
                    Booking booking = new Booking(bookingId, customer, lesson, "Booked");
                    customer.addBooking(booking);
                    lesson.addAttendee(customer);
                    return bookingId;
                } else {
                    System.out.println("Lesson is full!");
                }
            } else {
                System.out.println("Invalid lesson ID!");
            }
        } else {
            System.out.println("Invalid customer ID!");
        }
        return -1;
    }

    public void changeOrCancelBooking(int customerId, int bookingId, int newLessonId) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            if (newLessonId == 0) {
                customer.cancelBooking(bookingId);
            } else {
                Lesson newLesson = timetable.getLessonById(newLessonId);
                if (newLesson != null) {
                    customer.changeBooking(bookingId, newLesson);
                } else {
                    System.out.println("Invalid new lesson ID!");
                }
            }
        } else {
            System.out.println("Invalid customer ID!");
        }
    }

    public void attendLesson(int customerId, int lessonId) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            if (customer.hasBookingForLesson(lessonId)) {
                Lesson lesson = timetable.getLessonById(lessonId);
                if (lesson.getAttendees().size() < lesson.getCapacity()) {
                    System.out.println("Customer attended the lesson successfully!");
                } else {
                    System.out.println("Lesson is full!");
                }
            } else {
                System.out.println("Customer does not have a booking for this lesson!");
            }
        } else {
            System.out.println("Invalid customer ID!");
        }
    }

    public void generateMonthlyLessonReport(int month) {
        LocalDate now = LocalDate.now();
        int year = now.getYear();

        System.out.println("\nMonthly Lesson Report - " + month + "/" + year);
        for (Lesson lesson : lessons) {
            LocalDate lessonDate = LocalDate.of(year, month, 1).with(TemporalAdjusters.firstInMonth(DayOfWeek.valueOf(lesson.getDay().toUpperCase())));
            while (lessonDate.getMonthValue() == month) {
                System.out.println("Lesson ID: " + lesson.getId() + " | Type: " + lesson.getType() + " | Date: " + lessonDate + " | Attendees: " + lesson.getAttendees().size() + "/" + lesson.getCapacity());
                lessonDate = lessonDate.plusWeeks(1);
            }
        }
    }

    public void generateMonthlyChampionFitnessTypeReport(int month) {
        Map<String, Integer> fitnessTypeCount = new HashMap<>();
        for (Customer customer : customers) {
            for (Booking booking : customer.getBookings()) {
                LocalDate lessonDate = booking.getLesson().getDate();
                if (lessonDate.getMonthValue() == month) {
                    String type = booking.getLesson().getType();
                    fitnessTypeCount.put(type, fitnessTypeCount.getOrDefault(type, 0) + 1);
                }
            }
        }

        System.out.println("\nMonthly Champion Fitness Type Report - " + month);
        String championType = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : fitnessTypeCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                championType = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        System.out.println("Champion Fitness Type: " + championType + " | Bookings: " + maxCount);
    }

    private Customer getCustomerById(int id) {
        return customers.stream().filter(customer -> customer.getId() == id).findFirst().orElse(null);
    }
}
