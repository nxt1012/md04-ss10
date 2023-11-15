package spring.mvc.bt.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Home {
    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("customerName", "quý khách!");
        return "home";
    }
}
