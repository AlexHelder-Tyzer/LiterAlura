package com.example.LiterAlura.principal;

import com.example.LiterAlura.model.*;
import com.example.LiterAlura.repository.AutorRepository;
import com.example.LiterAlura.repository.LiteraluraRepository;
import com.example.LiterAlura.service.ConsumoAPI;
import com.example.LiterAlura.service.ConvierteDatos;
import org.springframework.aop.scope.ScopedProxyUtils;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private LiteraluraRepository repositorioLibro;
    private AutorRepository repositorioAutor;
    private List<Libro> libros;

    private final String API_BASE = "https://gutendex.com/books/";

    public Principal(LiteraluraRepository repositoryLibro, AutorRepository repositoryAutor){
        this.repositorioLibro = repositoryLibro;
        this.repositorioAutor = repositoryAutor;
    }

    public void runProgram() {
        try{
            var opcion = -1;

            while (opcion != 0) {
                var menu = """
                    *********************************************
                    ***** Bienvenidos al Sistema LiterAlura *****
                    *********************************************
                    1. Buscar libro por titulo
                    2. Listar libros registrados
                    3. Listar autores regitrados
                    4. Listar autores vivos en un determinado anho
                    5. Listar libros por idioma

                    0. Salir
                    *********************************************
                    """;
                System.out.println(menu);
                System.out.println("============ Ingrese la opcion: ");
                opcion = Integer.parseInt(teclado.nextLine());

                switch (opcion) {
                    case 1:
                        buscarLibroPorTitulo();
                        break;
                    case 2:
                        listarLibrosRegistrados();
                        break;
                    case 3:
                        listarAutoresRegistrados();
                        break;
                    case 4:
                        listarAutoresVivosAnho();
                        break;
                    case 5:
                        listarLibrosPorIdioma();
                        break;
                    case 0:
                        System.out.println("Cerrando la palicacion!!");
                        break;
                    default:
                        System.out.println("Opcion invalida!! Seleccione una de las opciones mostradas =)");
                }
            }
        }catch(NumberFormatException e){
            System.out.println("Solo se aceptan valores NUMERICOS!!! " + e.getMessage());
            runProgram();
        }

    }

    private Datos getObtenerDatos(){
        System.out.println("Digite el titulo del libro: ");
        String tituloLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(API_BASE + "?search=" + tituloLibro.replace(" ", "+"));
        Datos datos = conversor.obtenerDatos(json, Datos.class); //llena la clase Datos, con los datos de la API
        return datos; //devuelve datos generales de busqueda
    }

    private void buscarLibroPorTitulo(){

        Datos datos = getObtenerDatos();
        DatosLibro datosLibro = datos.resultados().getFirst(); // devuelve el primer libro encontrado
        Libro libro = new Libro(datosLibro);
        //System.out.println(libro);// muestra el libro

        Optional<Libro> existeLibro = repositorioLibro.findByTituloContainsIgnoreCase(libro.getTitulo());
        if(existeLibro.isPresent()){
            System.out.println("Libro " + libro.getTitulo().toUpperCase() + " registrado en la BASE DE DATOS!");
        }
        else{
            if(!datosLibro.autor().isEmpty()){
                DatosAutor datosAutor = datosLibro.autor().getFirst(); // recupera los datos del autor
                Autor autor = new Autor(datosAutor); // Setea la clase Autor con sus respectivos datos

                Optional<Autor> busquedaAutor = repositorioAutor.findByNombreContainsIgnoreCase(autor.getNombre());
                Autor autorExistente; //Obtener el autor existente o guardar el nuevo autor
                if (busquedaAutor.isEmpty()) {
                    autorExistente = repositorioAutor.save(autor); // Si no tiene un valor, guardamos el nuevo autor en el repositorio y usamos el autor guardado
                } else {
                    autorExistente = busquedaAutor.get(); // Si tiene un valor, lo usamos
                }
                libro.setAutor(autorExistente);// Asignar el autor al libro
                repositorioLibro.save(libro); //Guardar el libro en el repositorio
                mostrarLibroUnico(libro, autor);
            }
            else{
                System.out.println("Libro encontrado sin Autor en la API");
            }
        }

    }

    private void mostrarLibroUnico(Libro libro, Autor autor){
        System.out.printf("""
                ========== Libro ==========
                Título:\t\t%s
                Autor:\t\t%s
                Idioma:\t\t%s
                Descargas:\t%d
                ===========================
                """, libro.getTitulo(), autor.getNombre(), libro.getIdiomas(), libro.getNumeroDescargas());
    }

    private void listarLibrosRegistrados(){
        List<Libro> librosGuardados = repositorioLibro.listar();
        if (librosGuardados.isEmpty()){
            System.out.println("No se encontraron libros");
        }
        else{
            System.out.println("=============== LIBROS REGISTRADOS =============");
            librosGuardados.forEach(System.out::println);
        }
    }

    private void listarAutoresRegistrados(){
        List<Autor> autor = repositorioAutor.listarAutores();
        if(autor.isEmpty()){
            System.out.println("No existen autores registrados");
        }
        else{
            autor.forEach(System.out::println);
        }
    }

    private void listarAutoresVivosAnho(){
        System.out.println("Ingrese el anho donde el autor este vivo: ");
        String anho = teclado.nextLine();
        List<Autor> autor = repositorioAutor.listarAutoresVivosAnho(LocalDate.of(Integer.parseInt(anho), 1,1));
        if(autor.isEmpty()){
            System.out.println("No existen autores Vivos!!");
        }
        else{
            autor.forEach(System.out::println);
        }
    }

    private void listarLibrosPorIdioma(){
        System.out.println("""
                    ==== IDIOMAS DISPONIBLES ====
                    1. ES - Espanhol
                    2. EN - Ingles
                    3. FR - Frances
                    4. PT - Portugues
                    
                    Escriba la opcion del idioma:
                    """);
        try
        {
            int idiomaOpcion = Integer.parseInt(teclado.nextLine());
            switch (idiomaOpcion){
                case 1:
                    mostrarLibrosIdioma("[es]");
                    break;
                case 2:
                    mostrarLibrosIdioma("[en]");
                    break;
                case 3:
                    mostrarLibrosIdioma("[fr]");
                    break;
                case 4:
                    mostrarLibrosIdioma("[pt]");
                    break;
                default:
                    System.out.println("Opcion Incorrecta!!");
                    break;
            }
        }catch (NumberFormatException e){
            System.out.println("Solo se aceptan valores Numericos!! " + e.getMessage());
        }

    }

    private void mostrarLibrosIdioma(String lenguaje){
        Idioma idioma = Idioma.fromGutendex(lenguaje);
        libros = repositorioLibro.findByIdiomas(idioma);
        if (libros.isEmpty())
        {
            System.out.println("No se encontro ninugn libro en el idioma " + idioma);
        }
        else{
            libros.forEach(System.out::println);
        }
    }
}
