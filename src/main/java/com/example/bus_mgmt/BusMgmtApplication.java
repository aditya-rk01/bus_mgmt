package com.example.bus_mgmt;

import com.example.bus_mgmt.ticket.ticket_dao_jdbc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BusMgmtApplication {

	private ticket_dao_jdbc ticketDaoJdbc;
	public static void main(String[] args) {
		SpringApplication.run(BusMgmtApplication.class, args);
	}
}
