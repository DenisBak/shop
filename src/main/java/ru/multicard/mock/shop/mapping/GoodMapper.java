package ru.multicard.mock.shop.mapping;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;

import ru.multicard.mock.shop.controller.response.GoodResponseDto;
import ru.multicard.mock.shop.db.entities.GoodEntity;

@Mapper(componentModel = "spring")
@MapperConfig(imports = PurchaseMapper.class)
public interface GoodMapper {
	List<GoodResponseDto> toListDto(List<GoodEntity> goodEntities);
	GoodResponseDto modelToDto(GoodEntity good);
}