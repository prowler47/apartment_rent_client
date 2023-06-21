package ua.dragunovskiy.apartment_rental_client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.dragunovskiy.apartment_rental_client.entity.Apartment;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApartmentService {
    @Autowired
    private RestTemplate restTemplate;


    public List<Apartment> getAllApartment() {
        String URl = "http://localhost:8080/apartments/";
        ResponseEntity<List<Apartment>> responseEntity = restTemplate.exchange(URl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Apartment>>() {});
        return responseEntity.getBody();
    }

    public List<Apartment> getApartmentsByContainsAddress(String address) {
        String URl = "http://localhost:8080/apartments/byContainsName/" + address;
        ResponseEntity<List<Apartment>> responseEntity = restTemplate.exchange(URl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Apartment>>() {});
        return responseEntity.getBody();
    }


    public List<Apartment> getApartmentsByContainsAddress(String address, boolean checkBox) {
        String URl = "http://localhost:8080/apartments/byContainsName/" + address;
        ResponseEntity<List<Apartment>> responseEntity = restTemplate.exchange(URl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Apartment>>() {});
        List<Apartment> apartmentListByName = responseEntity.getBody();
        if (checkBox) {
            assert apartmentListByName != null;
            return apartmentListByName.stream()
                    .filter(Apartment::isPetFriendly)
                    .collect(Collectors.toList());
        } else {
            return apartmentListByName;
        }
    }

    public Apartment getApartmentById(Long id) {
        String URL = "http://localhost:8080/apartments/" + id;
        ResponseEntity<Apartment> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<Apartment>() {});
        return responseEntity.getBody();
    }

  public void addNewApartment(Apartment apartment) {
      String URL = "http://localhost:8080/apartments/add";
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
      HttpEntity<Apartment> requestEntity = new HttpEntity<>(apartment, headers);
      ResponseEntity<List<Apartment>> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, requestEntity, new ParameterizedTypeReference<List<Apartment>>() {});
  }

  public void updateApartment(Long apartmentId, Apartment apartmentForUpdate) {
      String URL = "http://localhost:8080/apartments/update/" + apartmentId;
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
      Apartment apartmentToUpdate = getApartmentById(apartmentId);
      apartmentToUpdate.setAddress(apartmentForUpdate.getAddress());
      apartmentToUpdate.setPrice(apartmentForUpdate.getPrice());
      apartmentToUpdate.setCity(apartmentForUpdate.getCity());
      apartmentToUpdate.setPetFriendly(apartmentForUpdate.isPetFriendly());
      HttpEntity<Apartment> requestEntity = new HttpEntity<>(apartmentToUpdate, headers);
      restTemplate.exchange(URL, HttpMethod.PUT, requestEntity, new ParameterizedTypeReference<Object>() {});
  }

  public void deleteApartment(Long apartmentId) {
        restTemplate.delete("http://localhost:8080/apartments/" + apartmentId);
  }
}
