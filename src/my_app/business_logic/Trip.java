package my_app.business_logic;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Trip {
    private String name;
    private LocalDate start_date, end_date;
    private float budget_amount;

    public Trip() {
        this.name = "New Trip";
        this.budget_amount = 0;
    }
    public Trip(String trip_name, LocalDate trip_start_date, LocalDate trip_end_date) {
        setName(trip_name);
        this.start_date = trip_start_date;
        this.end_date = trip_end_date;
        this.budget_amount = 0;
    }

    private boolean check_name(String test_name) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9 ]+");
        return pattern.matcher(test_name).matches();
    }

    private boolean check_number(String test_num) {
        Pattern pattern = Pattern.compile("[0-9]");
        return pattern.matcher(test_num).matches();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (!check_name(name)) {
            throw new IllegalArgumentException("Trip name can only contain letters, numbers, and spaces");
        }

        this.name = name;
    }

    public LocalDate getStart_date() {
        return this.start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return this.end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public float getBudget_amount() {
        return this.budget_amount;
    }

    public void setBudget_amount(float budget_amount) {
        this.budget_amount = budget_amount;
    }

    public void increase_budget_amount(float amount) {
        String s_amount = String.valueOf(amount);
        if (!check_number(s_amount)) {
            throw new IllegalArgumentException("Amount can only contain numbers.");
        }
        this.budget_amount += amount;
    }
}
