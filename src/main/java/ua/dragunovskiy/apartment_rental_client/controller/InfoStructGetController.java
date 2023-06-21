package ua.dragunovskiy.apartment_rental_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.dragunovskiy.apartment_rental_client.service.ApartmentService;
import ua.dragunovskiy.apartment_rental_client.service.InfoStructGetService;

@Controller
@RequestMapping("/info/get")
public class InfoStructGetController {

    @Autowired
    private InfoStructGetService infoStructGetService;

    @Autowired
    private ApartmentService apartmentService;

    @GetMapping("/educList/{id}")
    public String getAllEducEstablishments(@PathVariable("id") Long id, Model model) {
        model.addAttribute("educList", infoStructGetService.getAllEducEstablishments(id));
        model.addAttribute("apartment", apartmentService.getApartmentById(id));
        return "allEduc";
    }

    @GetMapping("/parkingList/{id}")
    public String getAllParking(@PathVariable("id") Long id, Model model) {
        model.addAttribute("parkingList", infoStructGetService.getAllParking(id));
        model.addAttribute("apartment", apartmentService.getApartmentById(id));
        return "allParking";
    }

    @GetMapping("/hospitalsList/{id}")
    public String getAllHospitals(@PathVariable("id") Long id, Model model) {
        model.addAttribute("hospitalsList", infoStructGetService.getAllHospitals(id));
        model.addAttribute("apartment", apartmentService.getApartmentById(id));
        return "allHospitals";
    }

    @GetMapping("/roadJunctionsList/{id}")
    public String getAllRoadJunctionsList(@PathVariable("id") Long id, Model model) {
        model.addAttribute("roadJunctionsList", infoStructGetService.getAllRoadJunctions(id));
        model.addAttribute("apartment", apartmentService.getApartmentById(id));
        return "allRoadJunctions";
    }

    @GetMapping("/storesList/{id}")
    public String getAllStores(@PathVariable("id") Long id, Model model) {
        model.addAttribute("storesList", infoStructGetService.getAllStores(id));
        model.addAttribute("apartment", apartmentService.getApartmentById(id));
        return "allStores";
    }
}
