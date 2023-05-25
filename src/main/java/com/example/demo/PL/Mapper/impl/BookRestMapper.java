package com.example.demo.PL.Mapper.impl;

import com.example.demo.BLL.DTO.BookDTO;
import com.example.demo.PL.Mapper.abtract.GenericRestMapper;
import com.example.demo.PL.Rest.BookRest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookRestMapper extends GenericRestMapper<BookDTO, BookRest>{

}
