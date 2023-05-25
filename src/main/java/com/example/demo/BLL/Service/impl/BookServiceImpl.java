package com.example.demo.BLL.Service.impl;

import com.example.demo.BLL.DTO.BookDTO;
import com.example.demo.BLL.Exceptions.NotFoundException;

import com.example.demo.BLL.Mapper.impl.BookMapper;
import com.example.demo.BLL.Service.abtract.BookService;

import com.example.demo.DAL.BookEntity;
import com.example.demo.DAL.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepo;

    private final BookMapper bookMapper;



    @Override
    public List<BookDTO> getByAuthor(String author) throws NotFoundException {
        List<BookEntity> bookList = bookRepo.findBookEntitiesByAuthor(author);
        if(bookList.isEmpty()) {
            throw new NotFoundException("Entity not found");
        }

        return  bookMapper.fromEntityListToDtoList(bookList);
    }

    @Override
    public List<BookDTO> getByTitle(String title) throws NotFoundException {
        List<BookEntity> bookList = bookRepo.findBookEntitiesByTitle(title);
        if(bookList.isEmpty()) {
            throw new NotFoundException("Entity not found");
        }

        return  bookMapper.fromEntityListToDtoList(bookList);
    }

    @Override
    public BookDTO insert(BookDTO Dto) {
        BookEntity entityToSave = bookMapper.fromDtoToEntity(Dto);
        BookEntity entitySaved = bookRepo.save(entityToSave);
        return  bookMapper.fromEntityToDto(entitySaved);
    }

    @Override
    public BookDTO getById(Integer id) throws NotFoundException {
        BookEntity bookEntity = bookRepo.findById(id).orElseThrow(() -> new NotFoundException("Entity not found in DB"));
        return bookMapper.fromEntityToDto(bookEntity);
    }

    @Override
    public List<BookDTO> getAll() {
        List<BookEntity> bookEntityList = bookRepo.findAll();
        return bookMapper.fromEntityListToDtoList(bookEntityList);
    }

    @Override
    public BookDTO upsert(BookDTO Dto) throws NotFoundException {
        BookEntity bookEntity = bookRepo.findById(Dto.getId()).orElseThrow(() -> new NotFoundException("Entity not found in DB"));

        BookEntity  bookEntityUpd= bookRepo.save(bookMapper.fromDtoToEntity(Dto));

        return bookMapper.fromEntityToDto(bookEntityUpd);
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        BookEntity bookEntity = bookRepo.findById(id).orElseThrow(() -> new NotFoundException("Entity not found in DB"));
        bookRepo.delete(bookEntity);

    }
}
