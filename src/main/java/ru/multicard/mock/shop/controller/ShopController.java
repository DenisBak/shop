package ru.multicard.mock.shop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.multicard.mock.shop.controller.response.ClientDto;
import ru.multicard.mock.shop.controller.response.GoodDto;
import ru.multicard.mock.shop.controller.response.PurchaseDto;
import ru.multicard.mock.shop.service.ShopService;

@RestController("/shop")
@RequiredArgsConstructor
public class ShopController {
	private final ShopService service;

	@GetMapping("/weekly/purchase")
	public List<PurchaseDto> lastWeekPurchases() {
		return service.getLastWeekPurchases();
	}

	@GetMapping("/monthly/good/best")
	public GoodDto lastMonthMostPopularGood() {
		return service.getLastMonthMostPopularGood();
	}

	@GetMapping("/halfyearly/buyer/best")
	public ClientDto halfYearBestBuyer() {
		return service.getHalfYearBestBuyer();
	}

	@GetMapping("/good/eighteen/best")
	public GoodDto mostSellGoodAmongEighteen() {
		return service.mostSellGoodAmongEighteen();
	}
}
