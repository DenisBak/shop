package ru.multicard.mock.shop.mapping;


import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;

import ru.multicard.mock.shop.controller.response.ClientDto;
import ru.multicard.mock.shop.db.entities.ClientEntity;

@Mapper(componentModel = "spring")
@MapperConfig(imports = GoodMapper.class)
public interface ClientMapper {

    ClientDto modelToDto(ClientEntity client);

}