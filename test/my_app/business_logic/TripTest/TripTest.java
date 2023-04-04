package my_app.business_logic.TripTest;

import static org.junit.jupiter.api.Assertions.*;

import my_app.business_logic.Trip;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TripTest {
    private Trip trip;
    String default_name = "tokyo";
    LocalDate default_start_date = LocalDate.of(2023, 1, 1);
    LocalDate default_end_date = LocalDate.of(2023, 1, 11);
    float default_amount = 0;
    float delta_num = 0.001F;
    @BeforeEach
    void setup() {
        Trip trip = new Trip(default_name, default_start_date, default_end_date);
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
        String wrong_name = "google";
        assertNotEquals(wrong_name, trip.getName());
    }

    @Test
    void setName() {
        String test_name = "amazon";
        trip.setName(test_name);
        assertEquals(test_name, trip.getName());
    }

    @Test
    void getStart_date() {
        assertEquals(default_start_date, trip.getStart_date());
    }

    @Test
    void getStart_dateF() {
        LocalDate test_date = LocalDate.of(2023, 02, 02);
        assertNotEquals(test_date, trip.getStart_date());
    }

    @Test
    void setStart_date() {
        LocalDate test_date = LocalDate.of(2023, 02, 02);
        trip.setStart_date(test_date);
        assertEquals(test_date, trip.getStart_date());
    }

    @Test
    void getEnd_date() {
        assertEquals(default_end_date, trip.getEnd_date());
    }

    @Test
    void getEnd_dateF() {
        LocalDate test_date = LocalDate.of(2023, 02, 02);
        assertNotEquals(default_end_date, trip.getEnd_date());
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