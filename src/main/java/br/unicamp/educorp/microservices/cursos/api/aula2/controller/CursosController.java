package br.unicamp.educorp.microservices.cursos.api.aula2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.educorp.microservices.cursos.api.aula2.model.Curso;

@RestController
public class CursosController {

	public List<Curso> getCursosRepository() {

		List<Curso> cursos = new ArrayList<>();

		cursos.add(new Curso(1, "MIC", "Microservices"));
		cursos.add(new Curso(2, "ELK", "ElasticSearch/Logstash/Kibana"));
		cursos.add(new Curso(3, "PYT", "Python"));
		cursos.add(new Curso(4, "BIZ", "Bizagi"));

		return cursos;
	}

	@GetMapping("/cursos/v1")
	public ResponseEntity<String> getAllCursosText() {
		return ResponseEntity.ok("meus cursos: " + getCursosRepository());
	}

	@GetMapping("/cursos/v2")
	public ResponseEntity<List<Curso>> getAllCursos() {
		return new ResponseEntity<List<Curso>>(getCursosRepository(), HttpStatus.OK);
	}
	
	/*
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context) {
		return args -> {
			System.out.println("### Listando os beans providos pelo Spring Boot:");
			Stream.of(context.getBeanDefinitionNames())//
					.sorted()//
					.forEach(System.out::println);

			System.out.println("### Listando os beans RestController:");
			Map<String, Object> restBeans = context.getBeansWithAnnotation(RestController.class);
			restBeans//
					.forEach((k, v) -> System.out.println(k + " : " + v));
		};
	}
	*/

}
