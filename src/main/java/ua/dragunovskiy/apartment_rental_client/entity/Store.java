package ua.dragunovskiy.apartment_rental_client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {
    private Long id;
    private String name;
    private int time;
}
