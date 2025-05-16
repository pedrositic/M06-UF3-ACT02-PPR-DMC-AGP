package com.example.demo.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.DTO.CotxeDTO;
import com.example.demo.Model.Cotxe;

@Mapper(componentModel = "spring")
public interface CotxeMapper {
  CotxeMapper INSTANCE = Mappers.getMapper(CotxeMapper.class);

  CotxeDTO toDto(Cotxe cotxe);

  Cotxe toEntity(CotxeDTO cotxeDTO);
}