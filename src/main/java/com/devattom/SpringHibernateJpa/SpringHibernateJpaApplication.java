package com.devattom.SpringHibernateJpa;

import com.devattom.SpringHibernateJpa.DAO.StudentDAO;
import com.devattom.SpringHibernateJpa.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringHibernateJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			readStudent(studentDAO);

//			getAllStudents(studentDAO);

			getStudentsByLastName(studentDAO);
		};
	}

	private void getStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Devattom");
		for(Student student : students) {
			System.out.println(student);
		}
	}

	private void getAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for(Student student : students) {
			System.out.println(student);
		}
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student...");
		Student student1 = new Student("Tom", "Devattom", "t.rousselin@test.com");
		Student student2 = new Student("Luz", "Otero", "l.otero@test.com");
		Student student3 = new Student("T", "test", "t.test@test.com");

		System.out.println("Saving the student...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

		System.out.println("Saved student with id: " + student1.getId());
		System.out.println("Saved student with id: " + student2.getId());
		System.out.println("Saved student with id: " + student3.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println(studentDAO.findById(3));
	}
}
