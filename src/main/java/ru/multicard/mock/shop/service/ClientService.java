package ru.multicard.mock.shop.service;

import ru.multicard.mock.shop.controller.response.ClientDto;

import java.util.List;

public interface ClientService {
    List<ClientDto> findAll();
    ClientDto findById(Long id);
}
