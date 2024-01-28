package ru.multicard.mock.shop.service.impl;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import ru.multicard.mock.shop.controller.response.ClientDto;
import ru.multicard.mock.shop.controller.response.GoodDto;
import ru.multicard.mock.shop.controller.response.PurchaseDto;
import ru.multicard.mock.shop.db.repo.ClientRepository;
import ru.multicard.mock.shop.db.repo.GoodRepository;
import ru.multicard.mock.shop.db.repo.PurchaseRepository;
import ru.multicard.mock.shop.mapping.ClientMapper;
import ru.multicard.mock.shop.mapping.GoodMapper;
import ru.multicard.mock.shop.mapping.PurchaseMapper;
import ru.multicard.mock.shop.service.ShopService;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShopServiceImpl implements ShopService {
	private final PurchaseRepository purchaseRepository;
	private final PurchaseMapper purchaseMapper;

	private final GoodRepository goodRepository;
	private final GoodMapper goodMapper;

	private final ClientRepository clientRepository;
	private final ClientMapper clientMapper;

	@Override
	public List<PurchaseDto> getLastWeekPurchases() {
		return purchaseMapper.toListDto(purchaseRepository.findAllByDateAfter(LocalDate.now().minusWeeks(1)));
	}

	@Override
	public GoodDto getLastMonthMostPopularGood() {
		return goodMapper.modelToDto(goodRepository.findAll().stream()
				.max(Comparator.comparing(entity -> entity.getPurchases().stream()
						.filter(purchase -> purchase.getDate().isAfter(LocalDate.now().minusMonths(1))).count()))
				.orElse(null));
	}

	@Override
	public ClientDto getHalfYearBestBuyer() {
		return clientMapper.modelToDto(clientRepository
				.findById(purchaseRepository.findTopByDateAfterOrderByCountDesc(LocalDate.now().minusMonths(6)).getId())
				.orElse(null));
	}

	@Override
	public GoodDto mostSellGoodAmongEighteen() {
		return goodMapper.modelToDto(goodRepository.getMostSellGoodAmongEighteen());
	}

}
