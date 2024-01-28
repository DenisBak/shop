package ru.multicard.mock.shop.mapping;


import java.util.List;

import org.mapstruct.Mapper;

import ru.multicard.mock.shop.controller.response.PurchaseDto;
import ru.multicard.mock.shop.db.entities.PurchaseEntity;

@Mapper(componentModel = "spring")
public interface PurchaseMapper {

    PurchaseDto modelToDto(PurchaseEntity purchase);

    List<PurchaseDto> toListDto(List<PurchaseEntity> purchaseEntities);
}