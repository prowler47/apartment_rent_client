package ua.dragunovskiy.apartment_rental_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.dragunovskiy.apartment_rental_client.service.InfoStructDeleteService;

@Controller
@RequestMapping("/info/delete")
public class InfoStructDeleteController {

    @Autowired
    private InfoStructDeleteService infoStructDeleteService;

    @RequestMapping("/educ/{apartmentId}/{educId}")
    public String deleteEducEstablishment(@PathVariable("apartmentId") Long apartmentId, @PathVariable("educId") Long educId) {
        infoStructDeleteService.deleteEduc(apartmentId, educId);
        return "redirect:/info/get/educList/" + apartmentId;
    }

    @RequestMapping("/hospital/{apartmentId}/{hospitalId}")
    public String deleteHospital(@PathVariable("apartmentId") Long apartmentId, @PathVariable("hospitalId") Long hospitalId) {
        infoStructDeleteService.deleteHospital(apartmentId, hospitalId);
        return "redirect:/info/get/hospitalsList/" + apartmentId;
    }

    @RequestMapping("/roadJunction/{apartmentId}/{roadJunctionId}")
    public String deleteRoadJunction(@PathVariable("apartmentId") Long apartmentId, @PathVariable("roadJunctionId") Long roadJunctionId) {
        infoStructDeleteService.deleteRoadJunction(apartmentId, roadJunctionId);
        return "redirect:/info/get/roadJunctionsList/" + apartmentId;
    }

    @RequestMapping("/parking/{apartmentId}/{parkingId}")
    public String deleteParking(@PathVariable("apartmentId") Long apartmentId, @PathVariable("parkingId") Long parkingId) {
        infoStructDeleteService.deleteParking(apartmentId, parkingId);
        return "redirect:/info/get/parkingList/" + apartmentId;
    }

    @RequestMapping("/store/{apartmentId}/{storeId}")
    public String deleteStore(@PathVariable("apartmentId") Long apartmentId, @PathVariable("storeId") Long storeId) {
        infoStructDeleteService.deleteStore(apartmentId, storeId);
        return "redirect:/info/get/storesList/" + apartmentId;
    }
}
