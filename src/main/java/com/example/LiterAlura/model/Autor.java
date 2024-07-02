package com.example.LiterAlura.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;
    private LocalDate fechaNacimiento;
    private LocalDate fechaMuerte;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor(){

    };

    public Autor(DatosAutor a){
        this.nombre = a.nombre();
        this.fechaNacimiento = LocalDate.of(a.fechaDeNacimiento(),1, 1);;
        this.fechaMuerte = LocalDate.of(a.fechaDeMuerte(), 1,1);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaMuerte() {
        return fechaMuerte;
    }

    public void setFechaMuerte(LocalDate fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        List<String> listaLibros = new ArrayList<>();
        for (int i = 0; i < libros.size(); i++) {
            listaLibros.add(libros.get(i).getTitulo());
        }
        return String.format("""
                ========== Autor ==========
                Nombre: %s
                Fecha de Nacimiento: %s
                Fecha de deceso: %s
                Libros: [%s]
                ===========================
                """, nombre, fechaNacimiento.getYear(), fechaMuerte.getYear(), String.join(", ", listaLibros));
    }
}
