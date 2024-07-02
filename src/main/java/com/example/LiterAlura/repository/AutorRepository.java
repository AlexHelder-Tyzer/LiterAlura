package com.example.LiterAlura.repository;

import com.example.LiterAlura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombreContainsIgnoreCase(String nombreAutor);

    @Query("SELECT a FROM Autor a")
    List<Autor> listarAutores();

    @Query("SELECT a FROM Autor a WHERE (:anho > a.fechaNacimiento) and (:anho < a.fechaMuerte)")
    List<Autor> listarAutoresVivosAnho(LocalDate anho);


}
