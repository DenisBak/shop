package ru.multicard.mock.shop.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDto {
    private Long id;
    private String name;
    private String lastname;
    private int age;
}
