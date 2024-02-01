package ru.multicard.mock.shop.service.impl;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import ru.multicard.mock.shop.controller.request.CreatePurchaseRequestDto;
import ru.multicard.mock.shop.controller.response.ClientResponseDto;
import ru.multicard.mock.shop.controller.response.GoodResponseDto;
import ru.multicard.mock.shop.controller.response.PurchaseResponseDto;
import ru.multicard.mock.shop.db.entities.ClientEntity;
import ru.multicard.mock.shop.db.entities.GoodEntity;
import ru.multicard.mock.shop.db.entities.PurchaseEntity;
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
	private static HashMap<String, ClientEntity> clients = new HashMap<>();
	private static HashMap<String, GoodEntity> goods = new HashMap<>();

	private final PurchaseRepository purchaseRepository;
	private final PurchaseMapper purchaseMapper;

	private final GoodRepository goodRepository;
	private final GoodMapper goodMapper;

	private final ClientRepository clientRepository;
	private final ClientMapper clientMapper;

	@PostConstruct
	public void initCache() {
		clientRepository.findAll().forEach(entity -> clients.put(entity.getName(), entity));
		goodRepository.findAll().forEach(entity -> goods.put(entity.getName(), entity));
	}

	@Override
	public List<PurchaseResponseDto> getLastWeekPurchases() {
		return purchaseMapper.toListDto(purchaseRepository.findAllByDateAfter(LocalDate.now().minusWeeks(1)));
	}

	@Override
	public GoodResponseDto getLastMonthMostPopularGood() {
		return goodMapper.modelToDto(goodRepository.findAll().stream()
				.max(Comparator.comparing(entity -> entity.getPurchases().stream()
						.filter(purchase -> purchase.getDate().isAfter(LocalDate.now().minusMonths(1))).count()))
				.orElse(null));
	}

	@Override
	public ClientResponseDto getHalfYearBestBuyer() {
		return clientMapper.modelToDto(clientRepository
				.findById(purchaseRepository.findTopByDateAfterOrderByCountDesc(LocalDate.now().minusMonths(6)).getId())
				.orElse(null));
	}

	@Override
	public GoodResponseDto mostSellGoodAmongEighteen() {
		return goodMapper.modelToDto(goodRepository.getMostSellGoodAmongEighteen());
	}

	@Override
	@Transactional
	public PurchaseResponseDto createPurchase(CreatePurchaseRequestDto purchaseReq) {
		PurchaseEntity purchase = purchaseRepository.save(
				new PurchaseEntity(null, clients.get(purchaseReq.getClientName()), purchaseReq.getBasket().toString(),
						purchaseReq.getCount(), purchaseReq.getAmount(), purchaseReq.getDate(), purchaseReq.getName(),
						purchaseReq.getBasket().stream().filter(good -> goods.get(good) != null)
								.map(good -> goods.get(good)).collect(Collectors.toList())));

		return purchaseMapper.modelToDto(purchase);
	}

	@Override
	public List<PurchaseResponseDto> getAllPurchases() {
		return purchaseMapper.toListDto(purchaseRepository.findAll());
	}

	@Override
	public List<GoodResponseDto> getAllGoods() {
		return goodMapper.toListDto(goodRepository.findAll());
	}

	@Override
	public List<ClientResponseDto> getAllClients() {
		return clientMapper.toListDto(clientRepository.findAll());
	}

}
