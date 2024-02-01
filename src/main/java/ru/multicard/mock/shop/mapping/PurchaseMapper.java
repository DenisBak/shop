package ru.multicard.mock.shop.mapping;


import java.util.List;

import org.mapstruct.Mapper;

import ru.multicard.mock.shop.controller.response.PurchaseResponseDto;
import ru.multicard.mock.shop.db.entities.PurchaseEntity;

@Mapper(componentModel = "spring")
public interface PurchaseMapper {

    PurchaseResponseDto modelToDto(PurchaseEntity purchase);

    List<PurchaseResponseDto> toListDto(List<PurchaseEntity> purchaseEntities);
}