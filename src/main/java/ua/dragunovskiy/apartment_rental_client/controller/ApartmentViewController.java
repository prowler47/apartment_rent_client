package ua.dragunovskiy.apartment_rental_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.dragunovskiy.apartment_rental_client.entity.Apartment;
import ua.dragunovskiy.apartment_rental_client.service.ApartmentService;

@Controller
@RequestMapping("/apartments")
public class ApartmentViewController {

    @Autowired
    private ApartmentService apartmentService;


    @GetMapping("/viewAll")
    public String getAllApartments(Model model) {
        model.addAttribute("apartmentsList", apartmentService.getAllApartment());
        return "allApartments";
    }

    @GetMapping("/getContainsAddress/{address}")
    public String getApartmentsByContainsAddress(@PathVariable("address") String address, Model model) {
        model.addAttribute("apartmentsList", apartmentService.getApartmentsByContainsAddress(address));
        return "allApartmentsByContainsAddress";
    }

    @GetMapping("/search")
    public String searchApartments(@RequestParam("keyword") String keyword, @RequestParam(value = "checkBox", required = false) boolean checkBox, Model model) {
        model.addAttribute("checkBox", checkBox);
        model.addAttribute("result", apartmentService.getApartmentsByContainsAddress(keyword, checkBox));
        return "allApartmentsByContainsAddress";
    }

    @GetMapping("/{id}")
    public String getApartmentById(@PathVariable("id") Long id, Model model) {
        Apartment apartmentById = apartmentService.getApartmentById(id);
        model.addAttribute("apartment", apartmentById);
        return "apartment";
    }

    @GetMapping("/new")
    public String addNewApartment(Model model) {
        Apartment apartment = new Apartment();
        model.addAttribute("newApartment", apartment);
        return "addApartment";

    }

    @PostMapping("/add")
    public String addNewApartment(@ModelAttribute("newApartment") Apartment apartment, @RequestParam(value = "petFriendly", required = false) boolean petFriendly) {
        apartment.setPetFriendly(petFriendly);
        apartmentService.addNewApartment(apartment);
        return "redirect:/apartments/viewAll";
    }

    @GetMapping("/edit/{apartmentId}")
    public String updateApartment(@PathVariable("apartmentId") Long apartmentId, Model model) {
        Apartment apartmentToUpdate = apartmentService.getApartmentById(apartmentId);
        Apartment apartmentForUpdate = new Apartment();
        apartmentForUpdate.setAddress(apartmentToUpdate.getAddress());
        apartmentForUpdate.setPrice(apartmentToUpdate.getPrice());
        apartmentForUpdate.setCity(apartmentToUpdate.getCity());
        model.addAttribute("apartmentForUpdate", apartmentForUpdate);
        model.addAttribute("apartmentToUpdate", apartmentToUpdate);
        return "editApartment";
    }

    @PutMapping("/update/{apartmentId}")
    public String updateApartment(@PathVariable("apartmentId") Long apartmentId, @ModelAttribute("apartmentForUpdate") Apartment apartmentForUpdate) {
        apartmentService.updateApartment(apartmentId, apartmentForUpdate);
        return "redirect:/apartments/viewAll";
    }

    @RequestMapping("/delete/{apartmentId}")
    public String deleteApartment(@PathVariable("apartmentId") Long apartmentId) {
        apartmentService.deleteApartment(apartmentId);
        return "redirect:/apartments/viewAll";
    }
}
