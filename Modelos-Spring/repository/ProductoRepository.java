package com.example.examen.repository;

import com.example.examen.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Spring Data JPA creará la implementación automáticamente.
    // Puedes añadir métodos de consulta personalizados aquí si es necesario.
    // Ej: Optional<Producto> findByNombre(String nombre);
}