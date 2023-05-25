package com.example.demo.BLL.Service.abtract;

import com.example.demo.BLL.DTO.BookDTO;
import com.example.demo.BLL.Exceptions.NotFoundException;

import java.util.List;

public interface BookService extends CrudService<BookDTO> {

    List<BookDTO> getByAuthor(String author) throws NotFoundException;
    List<BookDTO> getByTitle(String title) throws NotFoundException;
}
