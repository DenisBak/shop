package ru.multicard.mock.shop.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import ru.multicard.mock.shop.controller.request.CreatePurchaseRequestDto;
import ru.multicard.mock.shop.controller.response.PurchaseResponseDto;
import ru.multicard.mock.shop.service.ShopService;

@RestController
@RequestMapping(value = "/api/purchase")
@RequiredArgsConstructor
public class PurchaseController {
    private final ShopService service;

    @GetMapping("/all")
    public List<PurchaseResponseDto> getAllPurchases() {
        return service.getAllPurchases();
    }

    @GetMapping("/weekly")
    public List<PurchaseResponseDto> lastWeekPurchases() {
        return service.getLastWeekPurchases();
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPurchase(@RequestBody CreatePurchaseRequestDto request) {
        ResponseEntity<?> response;

        try {
            response = ResponseEntity.ok().body("Purchase " + service.createPurchase(request).getName() + " was created!");
        } catch (Throwable ex) {
            response = ResponseEntity.internalServerError().body(ex.getMessage());
        }
        return response;
    }
}
