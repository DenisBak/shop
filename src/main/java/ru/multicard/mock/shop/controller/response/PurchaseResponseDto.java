package ru.multicard.mock.shop.controller.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseResponseDto {
	private String basket;
	private int count;
	private double amount;
	private LocalDate date;
	private String name;
}
