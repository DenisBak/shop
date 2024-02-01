package ru.multicard.mock.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.multicard.mock.shop.controller.response.ClientResponseDto;
import ru.multicard.mock.shop.service.ShopService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/client")
@RequiredArgsConstructor
public class ClientController {
    private final ShopService service;

    @GetMapping("/halfyearly/best")
    public ClientResponseDto halfYearBestBuyer() {
        return service.getHalfYearBestBuyer();
    }

    @GetMapping("/all")
    public List<ClientResponseDto> all() {
        return service.getAllClients();
    }
}
