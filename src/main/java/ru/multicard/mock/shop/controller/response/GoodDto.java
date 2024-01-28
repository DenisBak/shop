package ru.multicard.mock.shop.controller.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoodDto {
    private String name;
    private BigDecimal price;
}
