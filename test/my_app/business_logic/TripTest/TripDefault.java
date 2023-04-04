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
    private final float default_amount = 0.0F;
    private final float delta_num = 0.001F;
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
    void setName() {
        String test_name = "meta";
        trip.setName(test_name);
        assertEquals(test_name, trip.getName());
    }

    @Test
    void setWrongName() {
        String test_name = "m@#ta";
        assertThrows(IllegalArgumentException.class, () -> {
            trip.setName(test_name);
        });
    }

    @Test
    void getStart_date() {
        assertNull(trip.getStart_date());
    }

    @Test
    void setStart_date() {
        LocalDate test_date = LocalDate.of(2023, 2, 2);
        trip.setStart_date(test_date);
        assertEquals(test_date, trip.getStart_date());
    }

    @Test
    void getEnd_date() {
        assertNull(trip.getEnd_date());
    }

    @Test
    void setEnd_date() {
        LocalDate test_date = LocalDate.of(2023, 2, 2);
        trip.setEnd_date(test_date);
        assertEquals(test_date, trip.getEnd_date());
    }

    @Test
    void getBudget_amount() {
        assertEquals(default_amount, trip.getBudget_amount(), delta_num);
    }
}
