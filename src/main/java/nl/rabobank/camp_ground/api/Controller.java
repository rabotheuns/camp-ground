package nl.rabobank.camp_ground.api;

import jakarta.servlet.http.HttpSession;
import nl.rabobank.camp_ground.core.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Service sv;

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/doLogin")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        boolean Rs = sv.verifyPass(username, password);
        if (Rs == true)
        {
            session.setAttribute("loggedInUser", username);
            return "redirect:/booking";
        }
        else
            return "login_error";
    }

    @GetMapping("/booking")
    public String booking(HttpSession session, Model model) {
        String loggedInUser = (String) session.getAttribute("loggedInUser");
        List<DTO> ShedUles = sv.llSchdlsInThDtbse();
        model.addAttribute("bookings", ShedUles);
        if (loggedInUser != null) {
            model.addAttribute("loggedInUser", loggedInUser);
            return "booking";
        } else
            return "redirect:/login";

    }

    @PostMapping("/booking/add")
    public String book(@RequestParam String bookingname,
            @RequestParam String bookingdate,
            @RequestParam Boolean foodrequired,
            @RequestParam Boolean drinksrequired,
            @RequestParam Boolean bonfirerequired,
            HttpSession session) {
        String loggedInUser = (String) session.getAttribute("loggedInUser");
        DTO d = new DTO();
        d.setBookingname(bookingname);
        d.setBookingdate(LocalDate.parse(bookingdate));
        d.setFoodrequired(foodrequired != null && foodrequired);
        d.setDrinksrequired(drinksrequired != null && drinksrequired);
        d.setBonfirerequired(bonfirerequired != null && bonfirerequired);
        sv.make(d, loggedInUser);
        return "redirect:/booking";
    }
}
