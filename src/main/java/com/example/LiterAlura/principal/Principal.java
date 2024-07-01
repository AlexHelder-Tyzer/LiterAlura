package com.example.LiterAlura.principal;

import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);

    public void runProgram() {
        var opcion = -1;

        while (opcion != 0) {
            var menu = """
                    ====== Bienvenidos al Sistema LiterAlura ======
                    1. Buscar libro por titulo
                    2. Listar libros registrados
                    3. Listar autores regitrados
                    4. Listar autores vivos en un determinado anho
                    5. Listar libros por idioma

                    0. Salir
                    """;
            System.out.println(menu);
            System.out.println("============ Ingrese la opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("test");
                    ;
                    break;
                case 0:
                    System.out.println("Cerrando la palicacion!!");
                    break;
                default:
                    System.out.println("Opcion invalida!!");
            }
        }
    }
}
