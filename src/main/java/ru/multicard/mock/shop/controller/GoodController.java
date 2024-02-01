package ru.multicard.mock.shop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.multicard.mock.shop.controller.response.GoodResponseDto;
import ru.multicard.mock.shop.service.ShopService;

@RestController
@RequestMapping(value = "/api/good")
@RequiredArgsConstructor
public class GoodController {
	private final ShopService service;
	@GetMapping("/all")
	public List<GoodResponseDto> allGoods() {
		return service.getAllGoods();
	}

	@GetMapping("/monthly/best")
	public GoodResponseDto lastMonthMostPopularGood() {
		return service.getLastMonthMostPopularGood();
	}

	@GetMapping("/eighteen/best")
	public GoodResponseDto mostSellGoodAmongEighteen() {
		return service.mostSellGoodAmongEighteen();
	}
}
