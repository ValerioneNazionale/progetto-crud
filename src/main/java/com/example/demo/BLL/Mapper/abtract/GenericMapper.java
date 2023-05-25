package com.example.demo.BLL.Mapper.abtract;

import java.util.List;

public interface GenericMapper<E,D>{
    D fromEntityToDto(E enity);
    E fromDtoToEntity(D Dto);
    List<D> fromEntityListToDtoList(List<E>entities);
    List<E> fromDtoListToEntityList(List<D>Dto);
}
