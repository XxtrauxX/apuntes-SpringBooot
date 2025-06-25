package service;

//comunicacion entre las entidades y los dto
package com.example.examen.service.impl;

import com.example.examen.dto.ProductoDTO;
import com.example.examen.entity.Producto;
import com.example.examen.repository.ProductoRepository;
import com.example.examen.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> findAll() {
        return productoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductoDTO> findById(Long id) {
        return productoRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public ProductoDTO save(ProductoDTO productoDTO) {
        Producto producto = convertToEntity(productoDTO);
        Producto savedProducto = productoRepository.save(producto);
        return convertToDTO(savedProducto);
    }

    @Override
    public Optional<ProductoDTO> update(Long id, ProductoDTO productoDTO) {
        return productoRepository.findById(id)
            .map(existingProducto -> {
                existingProducto.setNombre(productoDTO.getNombre());
                existingProducto.setPrecio(productoDTO.getPrecio());
                existingProducto.setStock(productoDTO.getStock());
                Producto updatedProducto = productoRepository.save(existingProducto);
                return convertToDTO(updatedProducto);
            });
    }

    @Override
    public boolean deleteById(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // --- Métodos de conversión ---
    
    private ProductoDTO convertToDTO(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());
        return dto;
    }

    private Producto convertToEntity(ProductoDTO dto) {
        Producto producto = new Producto();
        // No se asigna el ID para la creación
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        return producto;
    }
}