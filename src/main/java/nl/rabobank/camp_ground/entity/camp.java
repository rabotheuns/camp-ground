package nl.rabobank.camp_ground.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "campbooking")
public class camp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String bookingname;
    private LocalDate bookingdate;

    @ManyToOne
    @JoinColumn(name = "bookinguser", referencedColumnName = "id")
    private Employee bookinguser;

    private boolean foodrequired;
    private Boolean drinksrequired;
    private Boolean bonfirerequired;

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

    public Employee getBookinguser() {
        return bookinguser;
    }

    public void setBookinguser(Employee bookinguser) {
        this.bookinguser = bookinguser;
    }

    public Boolean getFoodrequired() {
        return foodrequired;
    }

    public void setFoodrequired(Boolean foodRequired) {
        this.foodrequired = foodRequired;
    }

    public Boolean getDrinksrequired() {
        return drinksrequired;
    }

    public void setDrinksrequired(Boolean drinksRequired) {
        this.drinksrequired = drinksRequired;
    }

    public boolean getBonfirerequired() {
        return bonfirerequired;
    }

    public void setBonfirerequired(boolean bonfirerequired) {
        this.bonfirerequired = bonfirerequired;
    }
}
