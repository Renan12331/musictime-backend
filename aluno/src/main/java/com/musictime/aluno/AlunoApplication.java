package com.musictime.aluno;

import com.musictime.aluno.model.Aluno;
import com.musictime.aluno.repository.AlunoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AlunoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlunoApplication.class, args);
	}
	@Bean
CommandLineRunner initDatabase(AlunoRepository alunoRepository){
		return args -> {
			alunoRepository.deleteAll();

			Aluno a = new Aluno();
			a.setName("Renan");
			a.setMatricula("202345620003");
			a.setCpf("340.140.568-23");
			a.setEndereco("Rua.Palmas,Brumado");
			a.setCurso("Violão");

			alunoRepository.save(a);
		};
  }
}
