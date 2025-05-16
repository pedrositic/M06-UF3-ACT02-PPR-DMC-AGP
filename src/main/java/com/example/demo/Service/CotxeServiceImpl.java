package com.example.demo.Service;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.CotxeDTO;
import com.example.demo.Mapper.CotxeMapper;
import com.example.demo.Model.Cotxe;
import com.example.demo.Repository.CotxeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CotxeServiceImpl implements CotxeService {

  private final CotxeRepository cotxeRepository; // Repositori injectat
  private final CotxeMapper cotxeMapper; // Mapper injectat

  public CotxeServiceImpl(CotxeRepository cotxeRepository, CotxeMapper cotxeMapper) {
    this.cotxeRepository = cotxeRepository;
    this.cotxeMapper = cotxeMapper;
  }

  @Override
  public Mono<Cotxe> save(CotxeDTO cotxeDTO) {
    // Converteix el DTO a entitat i guarda'l al repositori
    Cotxe cotxe = cotxeMapper.toEntity(cotxeDTO);
    return cotxeRepository.save(cotxe);
  }

  @Override
  public Mono<Cotxe> findById(String id) {
    // Cerca un cotxe per ID
    return cotxeRepository.findById(id);
  }

  @Override
  public Flux<Cotxe> findAll() {
    // Retorna tots els cotxes
    return cotxeRepository.findAll();
  }

  @Override
  public Mono<Cotxe> update(CotxeDTO cotxeDTO) {
    // Actualitza un cotxe existent
    return cotxeRepository.findById(cotxeDTO.id()) // Busca el cotxe pel seu ID
        .map(existingCotxe -> {
          // Actualitza les propietats del cotxe amb les dades del DTO
          existingCotxe.setMarca(cotxeDTO.marca());
          existingCotxe.setModel(cotxeDTO.model());
          existingCotxe.setAny(cotxeDTO.any());
          existingCotxe.setPreu(cotxeDTO.preu());
          existingCotxe.setColor(cotxeDTO.color());
          return existingCotxe;
        })
        .flatMap(cotxeRepository::save); // Guarda el cotxe actualitzat
  }

  @Override
  public Mono<Void> delete(String id) {
    // Esborra un cotxe per ID
    return cotxeRepository.deleteById(id);
  }
}