package ru.multicard.mock.shop.mapping;


import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;

import ru.multicard.mock.shop.controller.response.ClientResponseDto;
import ru.multicard.mock.shop.db.entities.ClientEntity;

@Mapper(componentModel = "spring")
@MapperConfig(imports = GoodMapper.class)
public interface ClientMapper {
    List<ClientResponseDto> toListDto(List<ClientEntity> clients);

    ClientResponseDto modelToDto(ClientEntity client);

}