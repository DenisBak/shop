package ru.multicard.mock.shop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.multicard.mock.shop.controller.response.ClientDto;
import ru.multicard.mock.shop.db.repo.ClientRepository;
import ru.multicard.mock.shop.mapping.ClientMapper;
import ru.multicard.mock.shop.service.ClientService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClientServiceImpl implements ClientService {
	private final ClientRepository clientRepository;
	private final ClientMapper clientMapper;

	@Override
	public List<ClientDto> findAll() {
		return clientMapper.toListDto(clientRepository.findAll());
	}

	@Override
	public ClientDto findById(Long id) {
		return clientMapper.modelToDto(clientRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User with id: " + id + " not found")));
	}
}
