package com.example.demo.PL.Mapper.abtract;

import java.util.List;

public interface GenericRestMapper <D,R>{

    R fromDtoToRest(D Dto);
    D fromRestToDto(R Rest);
    List<R> fromDtoListToRestList(List<D>Dtos);
    List<D> fromRestListToDtoList(List<R>Rests);

}

