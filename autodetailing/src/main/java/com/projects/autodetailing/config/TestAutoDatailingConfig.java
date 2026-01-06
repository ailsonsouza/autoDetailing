package com.projects.autodetailing.config;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projects.autodetailing.emuns.OrderStatus;
import com.projects.autodetailing.emuns.PaymentStatus;
import com.projects.autodetailing.entities.Client;
import com.projects.autodetailing.entities.Employee;
import com.projects.autodetailing.entities.Order;
import com.projects.autodetailing.entities.OrderService;
import com.projects.autodetailing.entities.Service;
import com.projects.autodetailing.repositories.ClientRepository;
import com.projects.autodetailing.repositories.EmployeeRepository;
import com.projects.autodetailing.repositories.OrderRepository;
import com.projects.autodetailing.repositories.OrderServiceJPARepository;
import com.projects.autodetailing.repositories.ServiceRepository;

@Configuration
@Profile("test")
public class TestAutoDatailingConfig implements CommandLineRunner{

	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderServiceJPARepository orderServiceJPARepository;
	
	@Override
	public void run(String... args) throws Exception {

		Client client1 = new Client(null, "Ailson", "754.956.852-80", "67 981854835", sdf.parse("29/12/2025"), "mora em curitiba");
		Client client2 = new Client(null, "Sabrina", "754.956.852-80", "67 981854835", sdf.parse("29/12/2025"), "mora em Joinvile");
		clientRepository.saveAll(Arrays.asList(client1, client2));
		
		Employee employee1 = new Employee(null, "Anderson", "41 985623569", "tingui curitiba", 8639.63);
		Employee employee2 = new Employee(null, "Roberto", "41 985623569", "tingui curitiba", 8639.63);
		employeeRepository.saveAll(Arrays.asList(employee1, employee2));
		
		Service service1 = new Service(null, "Lavação completa", 70.0);
		Service service2 = new Service(null, "Lavação incompleta", 70.0);
		serviceRepository.saveAll(Arrays.asList(service1, service2));
		
		Order order1 = new Order(null, Instant.now(), OrderStatus.IN_PROGRESS, PaymentStatus.BOLETO, 0.1, client2);
		Order order2 = new Order(null, Instant.now(), OrderStatus.IN_PROGRESS, PaymentStatus.BOLETO, 0.1, client1);
		Order order3 = new Order(null, Instant.now(), OrderStatus.IN_PROGRESS, PaymentStatus.BOLETO, 0.1, client2);
		Order order4 = new Order(null, Instant.now(), OrderStatus.IN_PROGRESS, PaymentStatus.BOLETO, 0.1, client1);
		orderRepository.saveAll(Arrays.asList(order1, order2, order3, order4));
		
		OrderService orderService1 = new OrderService(order1, service2, 2, service2.getPrice());
		OrderService orderService2 = new OrderService(order1, service1, 2, service1.getPrice());
		OrderService orderService3 = new OrderService(order2, service2, 2, service2.getPrice());
		OrderService orderService4 = new OrderService(order3, service1, 2, service1.getPrice());
		orderServiceJPARepository.saveAll(Arrays.asList(orderService1, orderService2, orderService3, orderService4));
		
		
	}

}
