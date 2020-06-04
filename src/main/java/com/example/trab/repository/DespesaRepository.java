package com.example.trab.repository;

import com.example.trab.models.Despesa;

import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface DespesaRepository extends CrudRepository<Despesa, Long> {

    List<Despesa> findByDescription(String description);

}
