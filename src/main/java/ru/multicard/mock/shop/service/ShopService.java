package ru.multicard.mock.shop.service;

import java.util.List;

import ru.multicard.mock.shop.controller.response.ClientDto;
import ru.multicard.mock.shop.controller.response.GoodDto;
import ru.multicard.mock.shop.controller.response.PurchaseDto;

public interface ShopService {
    List<PurchaseDto> getLastWeekPurchases();

    GoodDto getLastMonthMostPopularGood();

    ClientDto getHalfYearBestBuyer();

    GoodDto mostSellGoodAmongEighteen();
}
