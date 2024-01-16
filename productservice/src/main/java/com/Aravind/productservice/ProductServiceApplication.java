package com.Aravind.productservice;

//import com.Aravind.productservice.InheritanceExample.tableperclass.*;

//import com.Aravind.productservice.InheritanceExample.tableperclass.UserRepository;

//import com.Aravind.productservice.InheritanceExample.tableperclass.UserRepository;

import com.Aravind.productservice.InheritanceExample.joinedtable.MentorRepository;
import com.Aravind.productservice.InheritanceExample.joinedtable.StudentRepository;
import com.Aravind.productservice.repositories.CategoryRepository;
import com.Aravind.productservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {
	private MentorRepository mentorRepository;
	private StudentRepository studentRepository;
	private CategoryRepository categoryRepository;
	private ProductRepository productRepository;
//	private UserRepository userRepository;
//	public ProductServiceApplication(MentorRepository mentorRepository, StudentRepository studentRepository, UserRepository userRepository){
//		this.mentorRepository = mentorRepository;
//		this.studentRepository = studentRepository;
////		this.userRepository = userRepository;
//	}
	public ProductServiceApplication(MentorRepository mentorRepository, StudentRepository studentRepository, CategoryRepository categoryRepository, ProductRepository productRepository){
		this.mentorRepository = mentorRepository;
		this.studentRepository = studentRepository;
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
//		this.userRepository = userRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Mentor mentor = new Mentor();
//		mentor.setName("aravind");
//		mentor.setEmail("aravind@gmail.com");
//		mentor.setAvg_rating(100);
//		mentor.setId(5);
//		mentorRepository.save(mentor);
//		Student student = new Student();
//		student.setBatch("batch1");
//		student.setPsp(100);
//		student.setName("prave");
//		student.setEmail("prave@gmail.com");
//		student.setId(4);
//		studentRepository.save(student);
//		List<User> users = userRepository.findAll();
//		for(User u : users){
//			System.out.println(u.getName());
//		}
//		Category category = new Category();
//		category.setName("dresses");
//		Category savedCategory = categoryRepository.save(category);
//		Product product = new Product();
//		product.setName("shirt");
//		product.setImage("random");
//		product.setDescription("can wear as tops");
//		product.setPrice(100);
//		product.setCategory(savedCategory);
//		productRepository.save(product);
		


	}
}
