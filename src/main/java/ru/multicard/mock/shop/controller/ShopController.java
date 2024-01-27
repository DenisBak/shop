package ru.multicard.mock.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.multicard.mock.shop.controller.response.ClientDto;
import ru.multicard.mock.shop.service.ClientService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShopController {
	private final ClientService service;

	// Future realisation
}
