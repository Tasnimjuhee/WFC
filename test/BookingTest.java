/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Tasnim Akther Juhee
 */
public class BookingTest {
    
    public BookingTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Booking.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Booking instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomer method, of class Booking.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        Booking instance = null;
        Customer expResult = null;
        Customer result = instance.getCustomer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLesson method, of class Booking.
     */
    @Test
    public void testGetLesson() {
        System.out.println("getLesson");
        Booking instance = null;
        Lesson expResult = null;
        Lesson result = instance.getLesson();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class Booking.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Booking instance = null;
        String expResult = "";
        String result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class Booking.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        String status = "";
        Booking instance = null;
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLesson method, of class Booking.
     */
    @Test
    public void testSetLesson() {
        System.out.println("setLesson");
        Lesson lesson = null;
        Booking instance = null;
        instance.setLesson(lesson);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
