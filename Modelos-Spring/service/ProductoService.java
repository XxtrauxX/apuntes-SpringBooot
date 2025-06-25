package service;

package com.example.examen.service;

//logica principal se comunica con el Repositorio


import com.example.examen.dto.ProductoDTO;
import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<ProductoDTO> findAll();
    Optional<ProductoDTO> findById(Long id);
    ProductoDTO save(ProductoDTO productoDTO);
    Optional<ProductoDTO> update(Long id, ProductoDTO productoDTO);
    boolean deleteById(Long id);
}
