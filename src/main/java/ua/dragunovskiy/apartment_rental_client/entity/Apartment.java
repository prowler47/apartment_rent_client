package ua.dragunovskiy.apartment_rental_client.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apartment {
    private long id;
    private String address;
    private int price;
    private String city;
    private boolean petFriendly;
}
