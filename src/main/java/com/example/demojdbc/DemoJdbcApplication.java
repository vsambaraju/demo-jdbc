package com.example.demojdbc;

import com.sun.org.apache.xpath.internal.operations.Quo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoJdbcApplication {

	@Autowired
	private StudentJdbcRepository studentJdbcRepository;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/students/{id}")
	public Student findById(@PathVariable long id){
		if(studentJdbcRepository.findById(id)!=null){
			return studentJdbcRepository.findById(id);
		}
		return null;
	}

	@GetMapping("/students")
	public List<Student> findAll(){
		return studentJdbcRepository.findAll();
	}

	@GetMapping("/quote")
	public Quote getQuote(){
		final String link = "http://gturnquist-quoters.cfapps.io/api/random";

		Quote quote = restTemplate.getForObject(link,Quote.class);
		return quote;

	}

	@PostMapping("/students")
	public String addStudent(@RequestBody Student student){
		int ret = studentJdbcRepository.addStudent(student);
		if(ret==1){
			return "success";
		}
		return "failure";
	}

	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable long id){
		int ret = studentJdbcRepository.deleteStudent(id);
		if(ret==1){
			return "success";
		}
		return "failure";
	}

	@PutMapping("/students/{id}")
	public String updateStudent(@RequestBody Student student, @PathVariable long id){
		int ret = studentJdbcRepository.updateStudent(id, student);
		if(ret==1){
			return "success";
		}
		return "failure";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoJdbcApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Do any additional configuration here
		return builder.build();
	}
}
