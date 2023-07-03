package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
public class HomeController {

    private static final String INDEX = "index";
    private static final String LOGGED = "logged";

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
    public String getIndex(Model model){
        Integer countQuantities = donationService.countQuantities();
        Integer countDonations = donationService.countDonations();
        model.addAttribute("countQuantities", countQuantities);
        model.addAttribute("countDonations", countDonations);
        return INDEX;
    }

    @RequestMapping("/logged")
    public String getLogged(Model model){
        Integer countQuantities = donationService.countQuantities();
        Integer countDonations = donationService.countDonations();
        model.addAttribute("countQuantities", countQuantities);
        model.addAttribute("countDonations", countDonations);
        return LOGGED;
    }
}
