package nl.rabobank.camp_ground.core;
import nl.rabobank.camp_ground.entity.camp;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    //test correctly tests all possible combinations of food, drinks and bonfire but can possibly be split up into multiple tests
    //test can be used to verify code when refactoring

    @Test
    void testCalculateCost() {
        Service service = new Service();

        camp booking1 = new camp();
        booking1.setId(UUID.randomUUID());
        booking1.setBookingname("Test Booking 1");
        booking1.setBookingdate(LocalDate.now());
        booking1.setFoodrequired(true);
        booking1.setDrinksrequired(true);
        booking1.setBonfirerequired((true));
        BigDecimal expectedCost1 = BigDecimal.valueOf(900);
        assertEquals(expectedCost1, service.c(booking1));

        camp booking2 = new camp();
        booking2.setId(UUID.randomUUID());
        booking2.setBookingname("Test Booking 2");
        booking2.setBookingdate(LocalDate.now());
        booking2.setFoodrequired(true);
        booking2.setDrinksrequired(true);
        booking2.setBonfirerequired((false));
        BigDecimal expectedCost2 = BigDecimal.valueOf(800);
        assertEquals(expectedCost2, service.c(booking2));

        camp booking3 = new camp();
        booking3.setId(UUID.randomUUID());
        booking3.setBookingname("Test Booking 3");
        booking3.setBookingdate(LocalDate.now());
        booking3.setFoodrequired(true);
        booking3.setDrinksrequired(false);
        booking3.setBonfirerequired((true));
        BigDecimal expectedCost3 = BigDecimal.valueOf(600);
        assertEquals(expectedCost3, service.c(booking3));

        camp booking4 = new camp();
        booking4.setId(UUID.randomUUID());
        booking4.setBookingname("Test Booking 4");
        booking4.setBookingdate(LocalDate.now());
        booking4.setFoodrequired(false);
        booking4.setDrinksrequired(true);
        booking4.setBonfirerequired(true);
        BigDecimal expectedCost4 = BigDecimal.valueOf(600);
        assertEquals(expectedCost4, service.c(booking4));

        camp booking5 = new camp();
        booking5.setId(UUID.randomUUID());
        booking5.setBookingname("Test Booking 5");
        booking5.setBookingdate(LocalDate.now());
        booking5.setFoodrequired(true);
        booking5.setDrinksrequired(false);
        booking5.setBonfirerequired(false);
        BigDecimal expectedCost5 = BigDecimal.valueOf(400);
        assertEquals(expectedCost5, service.c(booking5));

        camp booking6 = new camp();
        booking6.setId(UUID.randomUUID());
        booking6.setBookingname("Test Booking 6");
        booking6.setBookingdate(LocalDate.now());
        booking6.setFoodrequired(false);
        booking6.setDrinksrequired(true);
        booking6.setBonfirerequired(false);
        BigDecimal expectedCost6 = BigDecimal.valueOf(400);
        assertEquals(expectedCost6, service.c(booking6));

        camp booking7 = new camp();
        booking7.setId(UUID.randomUUID());
        booking7.setBookingname("Test Booking 7");
        booking7.setBookingdate(LocalDate.now());
        booking7.setFoodrequired(false);
        booking7.setDrinksrequired(false);
        booking7.setBonfirerequired(true);
        BigDecimal expectedCost7 = BigDecimal.valueOf(200);
        assertEquals(expectedCost7, service.c(booking7));

        camp booking8 = new camp();
        booking8.setId(UUID.randomUUID());
        booking8.setBookingname("Test Booking 7");
        booking8.setBookingdate(LocalDate.now());
        booking8.setFoodrequired(false);
        booking8.setDrinksrequired(false);
        booking8.setBonfirerequired(false);
        BigDecimal expectedCost8 = BigDecimal.valueOf(100);
        assertEquals(expectedCost8, service.c(booking8));
    }
}
