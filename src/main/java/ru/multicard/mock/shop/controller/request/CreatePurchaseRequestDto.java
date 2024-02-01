package ru.multicard.mock.shop.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePurchaseRequestDto {
    private String name;
    private String clientName;
    private List<String> basket;
    private int count;
    private double amount;
    private LocalDate date;
}
