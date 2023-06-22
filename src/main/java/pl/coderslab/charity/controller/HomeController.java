package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.create.DonationService;
import pl.coderslab.charity.service.create.InstitutionService;

import java.util.List;


@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;


    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }
    @ModelAttribute("institutions")
    public List<Institution> institutions(){
        return institutionService.findAll();
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("countQuantities", donationService.countQuantities());
        model.addAttribute("countDonations", donationService.countDonations());
        return "index";
    }
}
