package ua.dragunovskiy.apartment_rental_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.dragunovskiy.apartment_rental_client.entity.*;
import ua.dragunovskiy.apartment_rental_client.service.ApartmentService;
import ua.dragunovskiy.apartment_rental_client.service.InfoStructGetService;
import ua.dragunovskiy.apartment_rental_client.service.InfoStructUpdateService;

@Controller
@RequestMapping("/info/update")
public class InfoStructUpdateController {
    @Autowired
    private ApartmentService apartmentService;

    @Autowired
    private InfoStructGetService infoStructGetService;

    @Autowired
    private InfoStructUpdateService infoStructUpdateService;

    @GetMapping("/editEduc/{apartmentId}/{infoId}")
    public String updateEducEstablishment(@PathVariable("apartmentId") Long apartmentId, @PathVariable("infoId") Long infoId, Model model) {
        EducationEstablishment educationEstablishmentForUpdate = new EducationEstablishment();
        Apartment apartment = apartmentService.getApartmentById(apartmentId);
        EducationEstablishment educEstablishmentToUpdate = infoStructGetService.getEducEstablishmentById(apartmentId, infoId);
        educationEstablishmentForUpdate.setName(educEstablishmentToUpdate.getName());
        educationEstablishmentForUpdate.setTime(educEstablishmentToUpdate.getTime());
        model.addAttribute("apartment", apartment);
        model.addAttribute("educForUpdate", educationEstablishmentForUpdate);
        model.addAttribute("educToUpdate", educEstablishmentToUpdate);
        return "editEduc";
    }

    @PutMapping("/updateEduc/{apartmentId}/{infoId}")
    public String updateEducEstablishment(@PathVariable("apartmentId") Long apartmentId, @PathVariable("infoId") Long infoId, @ModelAttribute("educForUpdate") EducationEstablishment educationEstablishmentForUpdate) {
        infoStructUpdateService.updateEducEstablishment(apartmentId, infoId, educationEstablishmentForUpdate);
        return "redirect:/info/get/educList/" + apartmentId;
    }

    @GetMapping("/editHospital/{apartmentId}/{infoId}")
    public String updateHospital(@PathVariable("apartmentId") Long apartmentId, @PathVariable("infoId") Long infoId, Model model) {
        Hospital hospitalForUpdate = new Hospital();
        Apartment apartment = apartmentService.getApartmentById(apartmentId);
        Hospital hospitalToUpdate = infoStructGetService.getHospitalById(apartmentId, infoId);
        hospitalForUpdate.setName(hospitalToUpdate.getName());
        hospitalForUpdate.setTime(hospitalToUpdate.getTime());
        model.addAttribute("apartment", apartment);
        model.addAttribute("hospitalForUpdate", hospitalForUpdate);
        model.addAttribute("hospitalToUpdate", hospitalToUpdate);
        return "editHospital";
    }

    @PutMapping("/updateHospital/{apartmentId}/{infoId}")
    public String updateHospital(@PathVariable("apartmentId") Long apartmentId, @PathVariable("infoId") Long infoId, @ModelAttribute("hospitalForUpdate") Hospital hospitalForUpdate) {
        infoStructUpdateService.updateHospital(apartmentId, infoId, hospitalForUpdate);
        return "redirect:/info/get/hospitalsList/" + apartmentId;
    }

    @GetMapping("/editParking/{apartmentId}/{infoId}")
    public String updateParking(@PathVariable("apartmentId") Long apartmentId, @PathVariable("infoId") Long infoId, Model model) {
        Parking parkingForUpdate = new Parking();
        Apartment apartment = apartmentService.getApartmentById(apartmentId);
        Parking parkingToUpdate = infoStructGetService.getParkingById(apartmentId, infoId);
        parkingForUpdate.setName(parkingToUpdate.getName());
        parkingForUpdate.setTime(parkingToUpdate.getTime());
        model.addAttribute("apartment", apartment);
        model.addAttribute("parkingForUpdate", parkingForUpdate);
        model.addAttribute("parkingToUpdate", parkingToUpdate);
        return "editParking";
    }

    @PutMapping("/updateParking/{apartmentId}/{infoId}")
    public String updateParking(@PathVariable("apartmentId") Long apartmentId, @PathVariable("infoId") Long infoId, @ModelAttribute("parkingForUpdate") Parking parkingForUpdate) {
        infoStructUpdateService.updateParking(apartmentId, infoId, parkingForUpdate);
        return "redirect:/info/get/parkingList/" + apartmentId;
    }

    @GetMapping("/editRoadJunction/{apartmentId}/{infoId}")
    public String updateRoadJunction(@PathVariable("apartmentId") Long apartmentId, @PathVariable("infoId") Long infoId, Model model) {
        RoadJunction roadJunctionForUpdate = new RoadJunction();
        Apartment apartment = apartmentService.getApartmentById(apartmentId);
        RoadJunction roadJunctionToUpdate = infoStructGetService.getRoadJunctionById(apartmentId, infoId);
        roadJunctionForUpdate.setName(roadJunctionToUpdate.getName());
        roadJunctionForUpdate.setTime(roadJunctionToUpdate.getTime());
        model.addAttribute("apartment", apartment);
        model.addAttribute("roadJunctionForUpdate", roadJunctionForUpdate);
        model.addAttribute("roadJunctionToUpdate", roadJunctionToUpdate);
        return "editRoadJunction";
    }

    @PutMapping("/updateRoadJunction/{apartmentId}/{infoId}")
    public String updateRoadJunction(@PathVariable("apartmentId") Long apartmentId, @PathVariable("infoId") Long infoId, @ModelAttribute("roadJunctionForUpdate") RoadJunction roadJunctionForUpdate) {
        infoStructUpdateService.updateRoadJunction(apartmentId, infoId, roadJunctionForUpdate);
        return "redirect:/info/get/roadJunctionsList/" + apartmentId;
    }

    @GetMapping("/editStore/{apartmentId}/{infoId}")
    public String updateStore(@PathVariable("apartmentId") Long apartmentId, @PathVariable("infoId") Long infoId, Model model) {
        Store storeForUpdate = new Store();
        Apartment apartment = apartmentService.getApartmentById(apartmentId);
        Store storeToUpdate = infoStructGetService.getStoreById(apartmentId, infoId);
        storeForUpdate.setName(storeToUpdate.getName());
        storeForUpdate.setTime(storeToUpdate.getTime());
        model.addAttribute("apartment", apartment);
        model.addAttribute("storeForUpdate", storeForUpdate);
        model.addAttribute("storeToUpdate", storeToUpdate);
        return "editStore";
    }

    @PutMapping("/updateStore/{apartmentId}/{infoId}")
    public String updateStore(@PathVariable("apartmentId") Long apartmentId, @PathVariable("infoId") Long infoId, @ModelAttribute("storeForUpdate") Store storeForUpdate) {
        infoStructUpdateService.updateStore(apartmentId, infoId, storeForUpdate);
        return "redirect:/info/get/storesList/" + apartmentId;
    }
}
