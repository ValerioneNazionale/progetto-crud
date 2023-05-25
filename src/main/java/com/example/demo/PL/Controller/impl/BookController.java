package com.example.demo.PL.Controller.impl;

import com.example.demo.BLL.DTO.BookDTO;
import com.example.demo.BLL.Exceptions.NotFoundException;
import com.example.demo.BLL.Service.abtract.BookService;
import com.example.demo.PL.Controller.abtract.GenericController;
import com.example.demo.PL.Mapper.impl.BookRestMapper;
import com.example.demo.PL.Rest.BookRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController implements GenericController<BookRest> {

    private final BookService bookService;
    private final BookRestMapper bookRestMapper;

    @GetMapping(path = "")
    public ResponseEntity<List<BookRest>> getByAuthor(@RequestParam String author) {
       // try {
            List<BookDTO> bookDTOList = bookService.getByAuthor(author);
            List<BookRest> bookRestList = bookRestMapper.fromDtoListToRestList(bookDTOList);
            return new ResponseEntity<>(bookRestList, HttpStatus.OK);
//        } catch (NotFoundException e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//        }

    }

    @Override
    @PostMapping
    public ResponseEntity<BookRest> post(@RequestBody BookRest rest) {//post con 2 possibilita = post e put

            BookDTO DTO = bookService.insert(bookRestMapper.fromRestToDto(rest));
            BookRest restToPost = bookRestMapper.fromDtoToRest(DTO);
            return new ResponseEntity<>(restToPost, HttpStatus.CREATED);


    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<BookRest> getById(@PathVariable Integer id) {
        try {
            BookDTO dto = bookService.getById(id);
            BookRest rest = bookRestMapper.fromDtoToRest(dto);
            return new ResponseEntity<>(rest, HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @Override
    @GetMapping(path = "/books")
    public ResponseEntity<List<BookRest>> getAll() {
        List<BookRest> listRest = bookRestMapper.fromDtoListToRestList(bookService.getAll());
        return new ResponseEntity<>(listRest, HttpStatus.OK);


    }


    @Override
    @PutMapping(path = "/{id}")
    public ResponseEntity<BookRest> put(@RequestBody BookRest rest) {
//        try {
            BookDTO bookDTO = bookService.upsert(bookRestMapper.fromRestToDto(rest));
            return new ResponseEntity<>(bookRestMapper.fromDtoToRest(bookDTO), HttpStatus.OK);

//        } catch (NotFoundException e) {
//            e.printStackTrace();
//            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
        }


//
//    @PutMapping(path = "/{id}")
//    public ResponseEntity<BookRest> put(@PathVariable("id") Integer id, @RequestBody BookRest rest) {
//        try {
//            BookRest bookRest = bookRestMapper.fromDtoToRest(bookDTO);
//            return ResponseEntity.ok(bookRest);
//        } catch (NotFoundException e) {
//            e.printStackTrace();
//            return ResponseEntity.notFound().build();
//        }
//    }       rest.setId(id);
//    BookDTO bookDTO = bookService.update(bookRestMapper.fromRestToDto(rest));
//}
//

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {

        try {
            bookService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
