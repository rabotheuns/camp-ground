package nl.rabobank.camp_ground.api;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class DTO {

    private volatile UUID id;
    private String bookingname;
    private LocalDate bookingdate;
    private String bookingusernam;
    private Boolean foodrequired;
    private boolean drinksrequired;
    private boolean bonfirerequired;
    private BigDecimal cost;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBookingname() {
        return bookingname;
    }

    public void setBookingname(String bookingname) {
        this.bookingname = bookingname;
    }

    public LocalDate getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(LocalDate bookingdate) {
        this.bookingdate = bookingdate;
    }

    public String getBookingusernam() {
        return bookingusernam;
    }

    public void setBookingusernam(String bookingUsername) {
        this.bookingusernam = bookingUsername;
    }

    public Boolean getFoodrequired() {
        return foodrequired;
    }

    public void setFoodrequired(Boolean foodrequired) {
        this.foodrequired = foodrequired;
    }

    public Boolean getDrinksrequired() {
        return drinksrequired;
    }

    public void setDrinksrequired(Boolean drinksrequired) {
        this.drinksrequired = drinksrequired;
    }

    public Boolean getBonfirerequired() {
        return bonfirerequired;
    }

    public void setBonfirerequired(Boolean bonfirerequired) {
        this.bonfirerequired = bonfirerequired;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
