package my_app.business_logic.TripTest;

import my_app.business_logic.Trip;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TripDefault {
    private Trip trip;
    private final String default_name = "New Trip";
    private float default_amount = 0;
    private float delta_num = 0.001F;
    @BeforeEach
    void setup() {
        trip = new Trip();
    }

    @AfterEach
    void tear_down() {
        trip = null;
    }

    @Test
    void getName() {
        assertEquals(default_name, trip.getName());
    }

    @Test
    void getNameF() {
        String wrong_name = "tesla";
        assertNotEquals(wrong_name, trip.getName());
    }

    @Test
    void setName() {
        String test_name = "meta";
        trip.setName(test_name);
        assertEquals(test_name, trip.getName());
    }

    @Test
    void getStart_date() {
        assertNull(trip.getStart_date());
    }

    @Test
    void setStart_date() {
        LocalDate test_date = LocalDate.of(2023, 02, 02);
        trip.setStart_date(test_date);
        assertEquals(test_date, trip.getStart_date());
    }

    @Test
    void getEnd_date() {
        assertNull(trip.getEnd_date());
    }

    @Test
    void setEnd_date() {
        LocalDate test_date = LocalDate.of(2023, 02, 02);
        trip.setEnd_date(test_date);
        assertEquals(test_date, trip.getEnd_date());
    }

    @Test
    void getBudget_amount() {
        assertEquals(default_amount, trip.getBudget_amount(), delta_num);
    }

    @Test
    void getBudget_amountF() {
        float test_amount = 2000.0F;
        assertNotEquals(test_amount, trip.getBudget_amount(), delta_num);
    }

    @Test
    void setBudget_amount() {
        float test_amount = 2000.0F;
        trip.setBudget_amount(test_amount);
        assertEquals(test_amount, trip.getBudget_amount());
    }
}