package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.create.CategoryService;
import pl.coderslab.charity.service.create.DonationService;
import pl.coderslab.charity.service.create.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DonationController {

    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;

    @GetMapping("/donationForm")
    public String add(Model model) {
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/donationForm")
    public String addSave(@Valid Donation donation, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        donationService.save(donation);
        return "redirect:/formConfirmation";
    }

    @GetMapping("/formConfirmation")
    public String showConfirmationPage() {
        return "form_confirmation";
    }

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return categoryService.findAll();
    }


    @ModelAttribute("institutions")
    public List<Institution> getInstitutions() {
        return institutionService.findAll();
    }

}