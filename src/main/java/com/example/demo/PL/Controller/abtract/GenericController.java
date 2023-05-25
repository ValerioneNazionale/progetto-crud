package com.example.demo.PL.Controller.abtract;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenericController <R>{
    ResponseEntity<R> post(R rest) ;

    /**
     * ##########
     * #  READ  #
     * ##########
     */
    ResponseEntity<R> getById(Integer id);

    ResponseEntity<List<R>> getAll();

    /**
     * ############
     * #  UPDATE  #
     * ############
     */
    ResponseEntity<R> put(R rest);

    /**
     * ############
     * #  DELETE  #
     * ############
     */
    ResponseEntity<Void> delete(Integer id);
}
