package com.example.trab.repository;

import com.example.trab.models.Receita;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReceitaRepository extends CrudRepository<Receita, Long> {

    List<Receita> findByDescription(String description);

}
