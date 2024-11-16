package br.com.alura.veiculo;

import br.com.alura.veiculo.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VeiculoApplication implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.menu();
	}

	public static void main(String[] args) {
		SpringApplication.run(VeiculoApplication.class, args);
	}

}
