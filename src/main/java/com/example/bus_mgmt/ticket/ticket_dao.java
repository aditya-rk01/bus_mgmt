package com.example.bus_mgmt.ticket;


import com.example.bus_mgmt.bus.bus;
import com.example.bus_mgmt.bus.bus_dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

public interface ticket_dao extends JpaRepository<ticket, Integer> {

}
