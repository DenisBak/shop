package ru.multicard.mock.shop.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.multicard.mock.shop.service.ClientService;

@RestController
@RequiredArgsConstructor
public class ShopController {
	private final ClientService service;

	// Future realisation
}
