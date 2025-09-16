package nl.rabobank.camp_ground.core.mapper;

import nl.rabobank.camp_ground.api.DTO;
import nl.rabobank.camp_ground.entity.camp;
import nl.rabobank.camp_ground.entity.Employee;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class bm {

    static public DTO DTO1(camp camp, final String bookingUsername, BigDecimal cost) {
        DTO dto = new DTO();
        dto.setId(camp.getId());
        dto.setBookingname(camp.getBookingname());
        dto.setBookingdate(camp.getBookingdate());
        dto.setBookingusernam(bookingUsername);
        dto.setFoodrequired(camp.getFoodrequired());
        dto.setDrinksrequired(camp.getDrinksrequired());
        dto.setBonfirerequired(camp.getBonfirerequired());
        dto.setCost(cost);
        return dto;
    }

    public camp ent(DTO in, Employee e1) {
        final camp camp = new camp();
        camp.setId(in.getId());
        camp.setBookingname(in.getBookingname());
        camp.setBookingdate(in.getBookingdate());
        camp.setBookinguser(e1);
        camp.setFoodrequired(in.getFoodrequired());
        camp.setDrinksrequired(in.getDrinksrequired());
        camp.setBonfirerequired((in.getBonfirerequired()));
        return camp;
    }
}
