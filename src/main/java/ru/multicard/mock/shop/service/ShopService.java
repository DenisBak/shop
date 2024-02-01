package ru.multicard.mock.shop.service;

import java.util.List;

import ru.multicard.mock.shop.controller.request.CreatePurchaseRequestDto;
import ru.multicard.mock.shop.controller.response.ClientResponseDto;
import ru.multicard.mock.shop.controller.response.GoodResponseDto;
import ru.multicard.mock.shop.controller.response.PurchaseResponseDto;

public interface ShopService {
    List<PurchaseResponseDto> getLastWeekPurchases();

    GoodResponseDto getLastMonthMostPopularGood();

    ClientResponseDto getHalfYearBestBuyer();

    GoodResponseDto mostSellGoodAmongEighteen();

    PurchaseResponseDto createPurchase(CreatePurchaseRequestDto purchaseReq);

    List<PurchaseResponseDto> getAllPurchases();

    List<GoodResponseDto> getAllGoods();

    List<ClientResponseDto> getAllClients();
}
