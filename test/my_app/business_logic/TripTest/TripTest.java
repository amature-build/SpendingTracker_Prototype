package my_app.business_logic.TripTest;

import static org.junit.jupiter.api.Assertions.*;

import my_app.business_logic.Trip;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TripTest {
    private Trip trip;
    private final String default_name = "tokyo";
    private final LocalDate default_start_date = LocalDate.of(2023, 1, 1);
    private final LocalDate default_end_date = LocalDate.of(2023, 1, 11);
    private final float default_amount = 0.0F;
    private final float delta_num = 0.001F;
    @BeforeEach
    void setup() {
        trip = new Trip(default_name, default_start_date, default_end_date);
    }

    @AfterEach
    void tear_down() {
        trip = null;
    }

    @Test
    void InvalidArgConstructor() {
        String test_name = "sdl#$%123AMAZON";
        assertThrows(IllegalArgumentException.class, () -> trip = new Trip(test_name, default_start_date, default_end_date));
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
        String test_name = "amazon445Der";
        trip.setName(test_name);
        assertEquals(test_name, trip.getName());
    }

    @Test
    void setWrongName() {
        String test_name = "ama%$^on";
        assertThrows(IllegalArgumentException.class, () -> trip.setName(test_name));
    }

    @Test
    void getStart_date() {
        assertEquals(default_start_date, trip.getStart_date());
    }

    @Test
    void getStart_dateF() {
        LocalDate test_date = LocalDate.of(2023, 2, 2);
        assertNotEquals(test_date, trip.getStart_date());
    }

    @Test
    void setStart_date() {
        LocalDate test_date = LocalDate.of(2023, 2, 2);
        trip.setStart_date(test_date);
        assertEquals(test_date, trip.getStart_date());
    }

    @Test
    void getEnd_date() {
        assertEquals(default_end_date, trip.getEnd_date());
    }

    @Test
    void getEnd_dateF() {
        LocalDate test_date = LocalDate.of(2023, 2, 2);
        assertNotEquals(test_date, trip.getEnd_date());
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

    @Test
    void increase_budget() {
        float test_amount = 140F;
        float set_amount = 2000F;
        float expected = test_amount + set_amount;
        trip.setBudget_amount(set_amount);
        trip.increase_budget_amount(test_amount);
        assertEquals(expected, trip.getBudget_amount());
    }

    @Test
    void increase_budget_NegAmount() {
        float test_amount = -140F;
        float set_amount = 2000F;
        float expected = set_amount + (-test_amount);
        trip.setBudget_amount(set_amount);
        trip.increase_budget_amount(test_amount);
        assertEquals(expected, trip.getBudget_amount());
    }

    @Test
    void decrease_budget() {
        float test_amount = 140F;
        float set_amount = 2000F;
        float expected = set_amount - test_amount;
        trip.setBudget_amount(set_amount);
        trip.decrease_budget_amount(test_amount);
        assertEquals(expected, trip.getBudget_amount());
    }

    @Test
    void decrease_budget_NegAmount() {
        float test_amount = -140F;
        float set_amount = 2000F;
        float expected = set_amount - (-test_amount);
        trip.setBudget_amount(set_amount);
        trip.decrease_budget_amount(test_amount);
        assertEquals(expected, trip.getBudget_amount());
    }
}
