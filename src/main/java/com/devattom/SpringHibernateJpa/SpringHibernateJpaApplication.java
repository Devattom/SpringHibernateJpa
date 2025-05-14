package com.devattom.SpringHibernateJpa;

import com.devattom.SpringHibernateJpa.DAO.StudentDAO;
import com.devattom.SpringHibernateJpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringHibernateJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> createStudent(studentDAO);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student...");
		Student student = new Student("Tom", "Devattom", "t.rousselin@test.com");

		System.out.println("Saving the student...");
		studentDAO.save(student);

		System.out.println("Saved student with id: " + student.getId());
	}
}
