package ua.dragunovskiy.apartment_rental_client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.dragunovskiy.apartment_rental_client.entity.*;

import java.util.List;

@Service
public class InfoStructGetService {

    @Autowired
    private RestTemplate restTemplate;

    public List<EducationEstablishment> getAllEducEstablishments(Long id) {
        String URL = "http://localhost:8080/info/get/educList/" + id;
        ResponseEntity<List<EducationEstablishment>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<EducationEstablishment>>() {});
        return responseEntity.getBody();
    }

    public EducationEstablishment getEducEstablishmentById(Long apartmentId, Long infoId) {
        return getAllEducEstablishments(apartmentId).stream()
                .filter(e -> e.getId().equals(infoId))
                .findFirst()
                .orElse(null);
    }

    public List<Parking> getAllParking(Long id) {
        String URL = "http://localhost:8080/info/get/parkingList/" + id;
        ResponseEntity<List<Parking>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Parking>>() {});
        return responseEntity.getBody();
    }

    public Parking getParkingById(Long apartmentId, Long infoId) {
        return getAllParking(apartmentId).stream()
                .filter(e -> e.getId().equals(infoId))
                .findFirst()
                .orElse(null);
    }

    public List<Hospital> getAllHospitals(Long id) {
        String URL = "http://localhost:8080/info/get/hospitalsList/" + id;
        ResponseEntity<List<Hospital>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Hospital>>() {});
        return responseEntity.getBody();
    }

    public Hospital getHospitalById(Long apartmentId, Long infoId) {
        return getAllHospitals(apartmentId).stream()
                .filter(e -> e.getId().equals(infoId))
                .findFirst()
                .orElse(null);
    }

    public List<RoadJunction> getAllRoadJunctions(Long id) {
        String URL = "http://localhost:8080/info/get/roadJunctionsList/" + id;
        ResponseEntity<List<RoadJunction>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<RoadJunction>>() {});
        return responseEntity.getBody();
    }

    public RoadJunction getRoadJunctionById(Long apartmentId, Long infoId) {
        return getAllRoadJunctions(apartmentId).stream()
                .filter(e -> e.getId().equals(infoId))
                .findFirst()
                .orElse(null);
    }

    public List<Store> getAllStores(Long id) {
        String URL = "http://localhost:8080/info/get/storesList/" + id;
        ResponseEntity<List<Store>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Store>>() {});
        return responseEntity.getBody();
    }

    public Store getStoreById(Long apartmentId, Long infoId) {
        return getAllStores(apartmentId).stream()
                .filter(e -> e.getId().equals(infoId))
                .findFirst()
                .orElse(null);
    }
 }