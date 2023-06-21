package ua.dragunovskiy.apartment_rental_client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.dragunovskiy.apartment_rental_client.entity.*;

import java.util.List;

@Service
public class InfoStructUpdateService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private InfoStructGetService infoStructGetService;


    public void updateEducEstablishment(Long apartmentId, Long infoId, EducationEstablishment educationEstablishmentForUpdate) {
        String URL = "http://localhost:8080/info/update/educ/" + apartmentId + "/" + infoId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        EducationEstablishment educationEstablishmentToUpdate = infoStructGetService.getAllEducEstablishments(apartmentId).stream()
                .filter(e -> e.getId().equals(infoId))
                .findFirst()
                .orElse(null);
        if (educationEstablishmentToUpdate != null) {
            educationEstablishmentToUpdate.setName(educationEstablishmentForUpdate.getName());
            educationEstablishmentToUpdate.setTime(educationEstablishmentForUpdate.getTime());
        }
        HttpEntity<EducationEstablishment> requestEntity = new HttpEntity<>(educationEstablishmentToUpdate, headers);
        restTemplate.exchange(URL, HttpMethod.PUT, requestEntity, new ParameterizedTypeReference<Object>() {});
    }

    public void updateHospital(Long apartmentId, Long infoId, Hospital hospitalForUpdate) {
        String URL = "http://localhost:8080/info/update/hospital/" + apartmentId + "/" + infoId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Hospital hospitalToUpdate = infoStructGetService.getAllHospitals(apartmentId).stream()
                .filter(e -> e.getId().equals(infoId))
                .findFirst()
                .orElse(null);
        if (hospitalToUpdate != null) {
            hospitalToUpdate.setName(hospitalForUpdate.getName());
            hospitalToUpdate.setTime(hospitalForUpdate.getTime());
        }
        HttpEntity<Hospital> requestEntity = new HttpEntity<>(hospitalToUpdate, headers);
        restTemplate.exchange(URL, HttpMethod.PUT, requestEntity, new ParameterizedTypeReference<Object>() {});

    }

    public void updateParking(Long apartmentId, Long infoId, Parking parkingForUpdate) {
        String URL = "http://localhost:8080/info/update/parking/" + apartmentId + "/" + infoId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Parking parkingToUpdate = infoStructGetService.getAllParking(apartmentId).stream()
                .filter(e -> e.getId().equals(infoId))
                .findFirst()
                .orElse(null);
        if (parkingToUpdate != null) {
            parkingToUpdate.setName(parkingForUpdate.getName());
            parkingToUpdate.setTime(parkingForUpdate.getTime());
        }
        HttpEntity<Parking> requestEntity = new HttpEntity<>(parkingToUpdate, headers);
        restTemplate.exchange(URL, HttpMethod.PUT, requestEntity, new ParameterizedTypeReference<Object>() {});
    }

    public void updateRoadJunction(Long apartmentId, Long infoId, RoadJunction roadJunctionForUpdate) {
        String URL = "http://localhost:8080/info/update/roadJunction/" + apartmentId + "/" + infoId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RoadJunction roadJunctionToUpdate = infoStructGetService.getAllRoadJunctions(apartmentId).stream()
                .filter(e -> e.getId().equals(infoId))
                .findFirst()
                .orElse(null);
        if (roadJunctionToUpdate != null) {
            roadJunctionToUpdate.setName(roadJunctionForUpdate.getName());
            roadJunctionToUpdate.setTime(roadJunctionForUpdate.getTime());
        }
        HttpEntity<RoadJunction> requestEntity = new HttpEntity<>(roadJunctionToUpdate, headers);
        restTemplate.exchange(URL, HttpMethod.PUT, requestEntity, new ParameterizedTypeReference<Object>() {});
    }

    public void updateStore(Long apartmentId, Long infoId, Store storeForUpdate) {
        String URL = "http://localhost:8080/info/update/store/" + apartmentId + "/" + infoId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Store storeToUpdate = infoStructGetService.getAllStores(apartmentId).stream()
                .filter(e -> e.getId().equals(infoId))
                .findFirst()
                .orElse(null);
        if (storeToUpdate != null) {
            storeToUpdate.setName(storeForUpdate.getName());
            storeToUpdate.setTime(storeForUpdate.getTime());
        }
        HttpEntity<Store> requestEntity = new HttpEntity<>(storeToUpdate, headers);
        restTemplate.exchange(URL, HttpMethod.PUT, requestEntity, new ParameterizedTypeReference<Object>() {});
    }

}
