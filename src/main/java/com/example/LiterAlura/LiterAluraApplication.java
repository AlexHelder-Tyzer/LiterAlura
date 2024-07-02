package com.example.LiterAlura;

import com.example.LiterAlura.principal.Principal;
import com.example.LiterAlura.repository.AutorRepository;
import com.example.LiterAlura.repository.LiteraluraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	@Autowired //indica a spring que haga una inyeccioon de dependencias
	private LiteraluraRepository repositoryLibro; // Indica la dependencia a usar
	@Autowired
	private AutorRepository repositoryAutor;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositoryLibro, repositoryAutor);
		principal.runProgram();
	}
}
