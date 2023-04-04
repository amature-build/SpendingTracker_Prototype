package my_app.business_logic;

import java.time.LocalDate;

public class Trip {
    private String name;
    private LocalDate start_date, end_date;
    private float budget_amount;

    public Trip() {
        this.name = "New Trip";
        this.budget_amount = 0;
    }
    public Trip(String trip_name, LocalDate trip_start_date, LocalDate trip_end_date) {
        this.name = trip_name;
        this.start_date = trip_start_date;
        this.end_date = trip_end_date;
        this.budget_amount = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
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
}
