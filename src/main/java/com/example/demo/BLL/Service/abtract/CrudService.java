package com.example.demo.BLL.Service.abtract;

import com.example.demo.BLL.Exceptions.NotFoundException;

import java.util.List;

public interface CrudService<T>{
    T insert(T Dto) throws NotFoundException;
    T getById(Integer id)throws NotFoundException;
    List<T> getAll();
    T upsert(T Dto) throws NotFoundException;
    void delete(Integer id) throws NotFoundException;
}
