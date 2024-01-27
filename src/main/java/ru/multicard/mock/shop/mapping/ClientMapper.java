package ru.multicard.mock.shop.mapping;


import org.mapstruct.Mapper;
import ru.multicard.mock.shop.controller.response.ClientDto;
import ru.multicard.mock.shop.db.entities.ClientEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientEntity dtoToModel(ClientDto ClientDto);

    ClientDto modelToDto(ClientEntity User);

    List<ClientDto> toListDto(List<ClientEntity> Users);
}