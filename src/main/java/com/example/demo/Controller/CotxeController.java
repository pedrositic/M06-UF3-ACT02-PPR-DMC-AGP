package com.example.demo.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.CotxeDTO;
import com.example.demo.Model.Cotxe;
import com.example.demo.Service.CotxeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/cotxes")
public class CotxeController {

  private final CotxeService cotxeService;

  public CotxeController(CotxeService cotxeService) {
    this.cotxeService = cotxeService;
  }

  @PostMapping
  public Mono<Cotxe> createCotxe(@RequestBody CotxeDTO cotxeDTO) {
    return cotxeService.save(cotxeDTO);
  }

  @GetMapping("/{id}")
  public Mono<Cotxe> getCotxeById(@PathVariable String id) {
    return cotxeService.findById(id);
  }

  @GetMapping
  public Flux<Cotxe> getAllCotxes() {
    return cotxeService.findAll();
  }

  @PutMapping
  public Mono<Cotxe> updateCotxe(@RequestBody CotxeDTO cotxeDTO) {
    return cotxeService.update(cotxeDTO);
  }

  @DeleteMapping("/{id}")
  public Mono<Void> deleteCotxe(@PathVariable String id) {
    return cotxeService.delete(id);
  }
}