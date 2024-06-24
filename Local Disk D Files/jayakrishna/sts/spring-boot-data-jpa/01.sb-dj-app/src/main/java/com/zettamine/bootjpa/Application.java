package com.zettamine.bootjpa;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zettamine.bootjpa.entities.Customer;
import com.zettamine.bootjpa.entities.CustomerRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

//	@Autowired
//	public void setCustomerRepo(CustomerRepository customerRepo) {
//		this.customerRepo = customerRepo;
//	}

	private CustomerRepository customerRepo;
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	@Autowired
	public Application(CustomerRepository repo) {
		this.customerRepo = repo;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		CustomerRepository custRepo = context.getBean(CustomerRepository.class);

//		  custRepo.save(new Customer(101,"Jaya Krishna","9666410798"));
		  custRepo.save(new Customer(114,"Akash","9666410798"));

		/*
		 * Customer c1 = new Customer(102, "Hari Prasad", "7564864475"); Customer c2 =
		 * new Customer(103, "Chandu Ganesh", "8594795885"); Customer c3 = new
		 * Customer(104, "Venkat", "9347191061"); Customer c4 = new Customer(105,
		 * "Siva", "9885239176"); Customer c5 = new Customer(106, "bhavya",
		 * "7637463763"); Customer c6 = new Customer(107, "Zai", "9875755885"); Customer
		 * c7 = new Customer(108, "Bharat", "9347191061"); Customer c8 = new
		 * Customer(109, "Kittu", "8675849039"); Customer c9 = new Customer(110,
		 * "Akash", "9885239176"); Customer c10 = new Customer(111, "Chathur",
		 * "8957854753"); Customer c11= new Customer(112, "David", "8594795885");
		 * Customer c12 = new Customer(113, "Eeshwar", "9347191061"); Customer c13 = new
		 * Customer(114, "Farooq", "9885239176");
		 * 
		 * ArrayList<Customer> list = new ArrayList<>(); list.add(c1); list.add(c2);
		 * list.add(c3); list.add(c5); list.add(c6); list.add(c7); list.add(c8);
		 * list.add(c9); list.add(c10); list.add(c11); list.add(c12); list.add(c13);
		 * 
		 * custRepo.saveAll(list);
		 */

		/*
		 * Optional<Customer> cust = custRepo.findById(101);
		 * System.out.println(cust.get());
		 */

		/*
		 * Iterable<Customer> all = custRepo.findAll(); System.out.println(all);
		 */

		/*
		 * List<Integer> list = Arrays.asList(101,201,394,104,103); Iterable<Customer>
		 * customers = custRepo.findAllById(list); System.out.println(customers);
		 */

		/*
		 * long totalCustomers = custRepo.count();
		 * System.out.println("Total Records of the customers in the database : " +
		 * totalCustomers);
		 */

		/*
		 * boolean existsById = custRepo.existsById(101);
		 * System.out.println("Is the current existed : " + existsById);
		 */

		/* custRepo.delete(new Customer(102,"jaya krishna","9666410798")); */

		/*
		 * List<Integer> list = Arrays.asList(101,102,103,474,8374);
		 * custRepo.deleteAllById(list);
		 */

		/* custRepo.deleteAll(); */

	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Optional<Customer> optCust= customerRepo.findByCustomerName("Jaya Krishna");
		 * if(optCust.isPresent()) LOGGER.info(optCust.get().toString()); else
		 * LOGGER.error("No Record Found...!");
		 */

		/*
		 * Optional<Customer> optCust= customerRepo.findByCustomerNumber("9347191061");
		 * if(optCust.isPresent()) LOGGER.info(optCust.get().toString()); else
		 * LOGGER.error("No Record Found...!");
		 */

		/*
		 * Optional<Customer> optCust =
		 * customerRepo.findByCustomerNameAndCustomerNumber("Venkat", "9347191061");
		 * if(optCust.isPresent()) LOGGER.info(optCust.get().toString()); else
		 * LOGGER.error("No Record Found...!");
		 */

		/*
		 * Integer rows = customerRepo.deleteByCustomerName("Siva");
		 * System.out.println("Rows deleted : "+rows);
		 */

		List<Customer> evenId = customerRepo.findEvenId();
		System.out.println(evenId);

	}

}
