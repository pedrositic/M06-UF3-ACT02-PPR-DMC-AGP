package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Cotxe;

import reactor.core.publisher.Flux;

@Repository
@EnableReactiveMongoRepositories
public interface CotxeRepository extends ReactiveMongoRepository<Cotxe, String> {
  Flux<Cotxe> findByMarca(String marca);
}
