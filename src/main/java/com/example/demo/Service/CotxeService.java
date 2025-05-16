package com.example.demo.Service;

import com.example.demo.DTO.CotxeDTO;
import com.example.demo.Model.Cotxe;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CotxeService {
    Mono<Cotxe> save(CotxeDTO cotxeDTO);
    Mono<Cotxe> findById(String id);
    Flux<Cotxe> findAll();
    Mono<Cotxe> update(CotxeDTO cotxeDTO);
    Mono<Void> delete(String id);
}