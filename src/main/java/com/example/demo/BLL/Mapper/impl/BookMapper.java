package com.example.demo.BLL.Mapper.impl;

import com.example.demo.BLL.DTO.BookDTO;
import com.example.demo.BLL.Mapper.abtract.GenericMapper;
import com.example.demo.DAL.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper extends GenericMapper<BookEntity, BookDTO> {

}
