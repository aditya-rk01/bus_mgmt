package com.example.bus_mgmt.ticket;

import com.example.bus_mgmt.bus.bus;
import com.example.bus_mgmt.bus.bus_dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ticket_dao_jdbc implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private bus_dao busDao;

    public ticket_dao_jdbc() {
    }

    public ticket getTicketById(int number) {
        String sql = "SELECT * FROM ticket WHERE tid = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{number}, new ticketRowMapper());
    }

    public List<ticket> getAll() {
        String sql = "SELECT * FROM ticket";
        List<ticket> tickets = jdbcTemplate.query(sql, new ticketRowMapper());
        return tickets;
    }

    public void addTicket(ticket a_ticket)
    {
        String sql = "INSERT INTO ticket (tid, pid, src, dest, bno, fare)" + "VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, a_ticket.getTid(), a_ticket.getPid(), a_ticket.getSrc(),
                a_ticket.getDest(), a_ticket.getBno(), a_ticket.getFare());

        bus Bus=busDao.findById(a_ticket.getBno()).get();

        sql = "UPDATE bus SET available=? WHERE number=?;";
        jdbcTemplate.update(sql, Bus.getAvailable()-1, a_ticket.getBno());
    }

    @Override
    public void run(String... args) throws Exception {
        String sql = "CREATE TABLE IF NOT EXISTS ticket(tid int primary key, pid int, src varchar(255), dest varchar(255), bno int, fare int);";
        jdbcTemplate.update(sql);
    }
}
