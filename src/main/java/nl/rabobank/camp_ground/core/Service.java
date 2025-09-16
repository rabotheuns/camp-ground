package nl.rabobank.camp_ground.core;

import nl.rabobank.camp_ground.api.DTO;
import nl.rabobank.camp_ground.core.mapper.bm;
import nl.rabobank.camp_ground.entity.Employee;
import nl.rabobank.camp_ground.entity.camp;
import nl.rabobank.camp_ground.repository.BRepository;
import nl.rabobank.camp_ground.repository.empRep;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private BRepository bRepository;

    @Autowired
    private empRep empRep;

    @Autowired
    private bm bm;

    public void make(DTO c, String u1) {
        List<Employee> employees = empRep.find(u1);
        camp booking = bm.ent(c, employees.get(0));
        bRepository.save(booking);
    }

    public List<DTO> llSchdlsInThDtbse() {
        List<camp> camps = bRepository.findAll();

        return camps.stream().map((camp camp) -> bm.DTO1(camp, camp.getBookinguser().getUsername(), c(camp))).collect(Collectors.toList());
    }

    public BigDecimal c(camp b) {
        BigDecimal t = new BigDecimal(0);

        if (b.getFoodrequired() && !b.getDrinksrequired() && !b.getBonfirerequired())
            t = t.add(BigDecimal.valueOf(400));
        else if (b.getDrinksrequired() && !b.getFoodrequired() && !b.getBonfirerequired())
        {
            t = t.add(BigDecimal.valueOf(400));
        }
        else if (b.getBonfirerequired() && !b.getFoodrequired() && !b.getDrinksrequired().booleanValue())
        {
            t = t.add(BigDecimal.valueOf(200));
        } else if (b.getFoodrequired() && b.getDrinksrequired() && !b.getBonfirerequired()) { t = t.add(BigDecimal.valueOf(800));} else if (b.getFoodrequired() && b.getBonfirerequired() && !b.getDrinksrequired()) {
            t = t.add(BigDecimal
                    .valueOf(600));
        }
        else if ((b.getDrinksrequired()&&b.getBonfirerequired()&&!b.getFoodrequired())) {
            t = t.add(BigDecimal.valueOf(600));
        }
        else if ((b.getFoodrequired()
                && b.getDrinksrequired() &&
                b.getBonfirerequired()))
            t = t.add(BigDecimal.valueOf(900));
        else t = t.add(BigDecimal.valueOf(100));

        return t;
    }

    public boolean verifyPass(String a1, String b2) {
        List<Employee> e = empRep.findByUsernameAndPassword(a1, b2);

        if (e.size() == 1) return true;
        else return false;
    }
}
