package com.example.demo.Model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "cotxes")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cotxe implements Serializable {
  @Id
  private String id;
  private String marca;
  private String model;
  private Integer any;
  private Double preu;
  private String color;
}