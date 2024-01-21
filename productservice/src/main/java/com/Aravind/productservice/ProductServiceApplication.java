package com.Aravind.productservice;

//import com.Aravind.productservice.InheritanceExample.tableperclass.*;

//import com.Aravind.productservice.InheritanceExample.tableperclass.UserRepository;

//import com.Aravind.productservice.InheritanceExample.tableperclass.UserRepository;

import com.Aravind.productservice.InheritanceExample.joinedtable.MentorRepository;
import com.Aravind.productservice.InheritanceExample.joinedtable.StudentRepository;
import com.Aravind.productservice.repositories.CategoryRepository;
import com.Aravind.productservice.repositories.OrderRepository;
import com.Aravind.productservice.repositories.PriceRepository;
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
	private PriceRepository priceRepository;
	private OrderRepository orderRepository;
//	private UserRepository userRepository;
//	public ProductServiceApplication(MentorRepository mentorRepository, StudentRepository studentRepository, UserRepository userRepository){
//		this.mentorRepository = mentorRepository;
//		this.studentRepository = studentRepository;
////		this.userRepository = userRepository;
//	}
	public ProductServiceApplication(MentorRepository mentorRepository,
									 StudentRepository studentRepository,
									 CategoryRepository categoryRepository,
									 ProductRepository productRepository,
									 PriceRepository priceRepository,
									 OrderRepository orderRepository){
		this.mentorRepository = mentorRepository;
		this.studentRepository = studentRepository;
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.priceRepository = priceRepository;
		this.orderRepository = orderRepository;
//		this.userRepository = userRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
//	@Transactional
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


		//-------------------------------------------------------

//		Category category = new Category();
//		category.setName("dresses");
//		Category savedCategory = categoryRepository.save(category);
//		Price price = new Price("100", "Rupee");
//		Price savedprice = priceRepository.save(price);
//
//		Product product = new Product();
//		product.setTitle("shirt");
//		product.setImage("random");
//		product.setDescription("can wear as tops");
//		product.setPrice(savedprice);
//		product.setCategory(savedCategory);
//		Product savedProduct = productRepository.save(product);
//		Optional<Category> category = categoryRepository.findById(UUID.fromString("38decb45-6bee-4834-93ba-596df45311d6"));
//		Category returnedCategory = category.get();
//		List<Product> products = returnedCategory.getProducts();
//		System.out.print(products);
//      JQueryMethods
//		productRepository.deleteById(UUID.fromString("7aa72fad-4b16-45d3-a8a1-618fc636b5e1"));
//		Product returnedprodcut = productRepository.findbyTitleAndPrice_currency("shirt", 100);
//		System.out.println(returnedprodcut.getTitle());
//		Product returnedProduct = productRepository.abc("shirt");
//		System.out.println(returnedProduct.getTitle());


	}
}
