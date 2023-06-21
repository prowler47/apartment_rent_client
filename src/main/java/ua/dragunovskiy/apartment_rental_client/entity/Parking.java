package ua.dragunovskiy.apartment_rental_client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parking {
    private Long id;
    private String name;
    private int time;
}
