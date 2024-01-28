package ru.multicard.mock.shop.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;

import ru.multicard.mock.shop.controller.response.GoodDto;
import ru.multicard.mock.shop.db.entities.GoodEntity;

@Mapper(componentModel = "spring")
@MapperConfig(imports = PurchaseMapper.class)
public interface GoodMapper {

	GoodDto modelToDto(GoodEntity good);
}