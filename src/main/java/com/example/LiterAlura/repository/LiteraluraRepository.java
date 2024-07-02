package com.example.LiterAlura.repository;

import com.example.LiterAlura.model.Autor;
import com.example.LiterAlura.model.Idioma;
import com.example.LiterAlura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LiteraluraRepository extends JpaRepository<Libro, Long> {
    Optional<Libro> findByTituloContainsIgnoreCase(String tituloLibro);

    @Query("select l from Libro l")
    List<Libro> listar();


    List<Libro> findByIdiomas(Idioma idioma);
}