package com.example.LiterAlura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @ManyToOne
    private Autor autor;
    @Enumerated(EnumType.STRING)
    private Idioma idiomas; //ojo
    private Long numeroDescargas;

    public Libro(){

    }

    public Libro(DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();
        this.numeroDescargas = datosLibro.numeroDeDescargas();
        this.idiomas = Idioma.fromGutendex(String.valueOf(datosLibro.idiomas()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Long numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    public Idioma getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(Idioma idiomas) {
        this.idiomas = idiomas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        String autorL = Optional.ofNullable(autor).map(Autor::getNombre).orElse("Autor Desconocido!");
        return String.format("""
                ========== Libro ==========
                Título:\t\t%s
                Autor:\t\t%s
                Idioma:\t\t%s
                Descargas:\t%d
                ===========================
                """, titulo, autorL, idiomas, numeroDescargas);
    }
}
