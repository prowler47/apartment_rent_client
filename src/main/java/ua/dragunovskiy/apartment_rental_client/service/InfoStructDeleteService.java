package ua.dragunovskiy.apartment_rental_client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InfoStructDeleteService {

    @Autowired
    private RestTemplate restTemplate;

    public void deleteEduc(Long apartmentId, Long educId) {
        String URl = "http://localhost:8080/info/delete/educ/" + apartmentId + "/" + educId;
        restTemplate.delete(URl);
    }

    public void deleteHospital(Long apartmentId, Long hospitalId) {
        String URl = "http://localhost:8080/info/delete/hospital/" + apartmentId + "/" + hospitalId;
        restTemplate.delete(URl);
    }

    public void deleteRoadJunction(Long apartmentId, Long roadJunctionId) {
        String URl = "http://localhost:8080/info/delete/roadJunction/" + apartmentId + "/" + roadJunctionId;
        restTemplate.delete(URl);
    }

    public void deleteParking(Long apartmentId, Long parkingId) {
        String URl = "http://localhost:8080/info/delete/parking/" + apartmentId + "/" + parkingId;
        restTemplate.delete(URl);
    }

    public void deleteStore(Long apartmentId, Long storeId) {
        String URl = "http://localhost:8080/info/delete/store/" + apartmentId + "/" + storeId;
        restTemplate.delete(URl);
    }
}
