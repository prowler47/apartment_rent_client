package ua.dragunovskiy.apartment_rental_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.dragunovskiy.apartment_rental_client.entity.*;
import ua.dragunovskiy.apartment_rental_client.service.ApartmentService;
import ua.dragunovskiy.apartment_rental_client.service.InfoStructAddService;


@Controller
@RequestMapping("/info/add")
public class InfoStructAddController {

    @Autowired
    private InfoStructAddService infoStructAddService;

    @Autowired
    private ApartmentService apartmentService;

    @GetMapping("/newEduc/{apartmentId}")
    public String addNewEducEstablishment(@PathVariable("apartmentId") Long apartmentId, Model model) {
        Apartment apartmentById = apartmentService.getApartmentById(apartmentId);
        EducationEstablishment educationEstablishment = new EducationEstablishment();
        model.addAttribute("apartment", apartmentById);
        model.addAttribute("newEducEstablishment", educationEstablishment);
        return "addEducEstablishment";
    }

    @PostMapping("/addEduc/{apartmentId}")
    public String addNewEducEstablishment(@PathVariable("apartmentId") Long apartmentId, @ModelAttribute("newEducEstablishment") EducationEstablishment educationEstablishment) {
        Apartment apartment = apartmentService.getApartmentById(apartmentId);
        if (apartment != null) {
                infoStructAddService.addEducEstablishment(apartmentId, educationEstablishment);
        }
        return "redirect:/info/get/educList/" + apartmentId;
    }

    @GetMapping("/newHospital/{apartmentId}")
    public String addNewHospital(@PathVariable("apartmentId") Long apartmentId, Model model) {
        Apartment apartmentById = apartmentService.getApartmentById(apartmentId);
        Hospital hospital = new Hospital();
        model.addAttribute("apartment", apartmentById);
        model.addAttribute("newHospital", hospital);
        return "addHospital";
    }

    @PostMapping("/addHospital/{apartmentId}")
    public String addNewHospital(@PathVariable("apartmentId") Long apartmentId, @ModelAttribute("newHospital") Hospital hospital) {
        Apartment apartmentById = apartmentService.getApartmentById(apartmentId);
        if (apartmentId != null) {
            infoStructAddService.addHospital(apartmentId, hospital);
        }
        return "redirect:/info/get/hospitalsList/" + apartmentId;
    }

    @GetMapping("/newParking/{apartmentId}")
    public String addNewParking(@PathVariable("apartmentId") Long apartmentId, Model model) {
        Apartment apartmentById = apartmentService.getApartmentById(apartmentId);
        Parking parking = new Parking();
        model.addAttribute("apartment", apartmentById);
        model.addAttribute("newParking", parking);
        return "addParking";
    }

    @PostMapping("/addParking/{apartmentId}")
    public String addNewParking(@PathVariable("apartmentId") Long apartmentId, @ModelAttribute("newParking") Parking parking) {
        Apartment apartmentById = apartmentService.getApartmentById(apartmentId);
        if (apartmentId != null) {
            infoStructAddService.addParking(apartmentId, parking);
        }
        return "redirect:/info/get/parkingList/" + apartmentId;
    }

    @GetMapping("/newRoadJunction/{apartmentId}")
    public String addNewRoadJunction(@PathVariable("apartmentId") Long apartmentId, Model model) {
        Apartment apartmentById = apartmentService.getApartmentById(apartmentId);
        RoadJunction roadJunction = new RoadJunction();
        model.addAttribute("apartment", apartmentById);
        model.addAttribute("newRoadJunction", roadJunction);
        return "addRoadJunction";
    }

    @PostMapping("/addRoadJunction/{apartmentId}")
    public String addNewRoadJunction(@PathVariable("apartmentId") Long apartmentId, @ModelAttribute("newRoadJunction") RoadJunction roadJunction) {
        Apartment apartmentById = apartmentService.getApartmentById(apartmentId);
        if (apartmentById != null) {
            infoStructAddService.addRoadJunction(apartmentId, roadJunction);
        }
        return "redirect:/info/get/roadJunctionsList/" + apartmentId;
    }

    @GetMapping("/newStore/{apartmentId}")
    public String addNewStore(@PathVariable("apartmentId") Long apartmentId, Model model) {
        Apartment apartmentById = apartmentService.getApartmentById(apartmentId);
        Store store = new Store();
        model.addAttribute("apartment", apartmentById);
        model.addAttribute("newStore", store);
        return "addStore";
    }

    @PostMapping("/addStore/{apartmentId}")
    public String addNewStore(@PathVariable("apartmentId") Long apartmentId, @ModelAttribute("newStore") Store store) {
        Apartment apartmentById = apartmentService.getApartmentById(apartmentId);
        if (apartmentById != null) {
            infoStructAddService.addStore(apartmentId, store);
        }
        return "redirect:/info/get/storesList/" + apartmentId;
    }
}
