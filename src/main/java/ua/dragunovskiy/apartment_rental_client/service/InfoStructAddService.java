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

@Service
public class InfoStructAddService {

    @Autowired
    private RestTemplate restTemplate;

    public void addEducEstablishment(Long apartmentId, EducationEstablishment educationEstablishment) {
        String URL = "http://localhost:8080/info/add/educ/" + apartmentId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<EducationEstablishment> requestEntity = new HttpEntity<>(educationEstablishment, headers);
        restTemplate.exchange(URL, HttpMethod.POST, requestEntity, new ParameterizedTypeReference<Object>() {});
    }

    public void addHospital(Long apartmentId, Hospital hospital) {
        String URL = "http://localhost:8080/info/add/hospital/" + apartmentId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Hospital> requestEntity = new HttpEntity<>(hospital, headers);
        restTemplate.exchange(URL, HttpMethod.POST, requestEntity, new ParameterizedTypeReference<Object>() {});
    }

    public void addParking(Long apartmentId, Parking parking) {
        String URL = "http://localhost:8080/info/add/parking/" + apartmentId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Parking> requestEntity = new HttpEntity<>(parking, headers);
        restTemplate.exchange(URL, HttpMethod.POST, requestEntity, new ParameterizedTypeReference<Object>() {});
    }

    public void addRoadJunction(Long apartmentId, RoadJunction roadJunction) {
        String URL = "http://localhost:8080/info/add/roadJunction/" + apartmentId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<RoadJunction> requestEntity = new HttpEntity<>(roadJunction, headers);
        restTemplate.exchange(URL, HttpMethod.POST, requestEntity, new ParameterizedTypeReference<Object>() {});
    }

    public void addStore(Long apartmentId, Store store) {
        String URL = "http://localhost:8080/info/add/store/" + apartmentId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Store> requestEntity = new HttpEntity<>(store, headers);
        restTemplate.exchange(URL, HttpMethod.POST, requestEntity, new ParameterizedTypeReference<Object>() {});
    }
}
