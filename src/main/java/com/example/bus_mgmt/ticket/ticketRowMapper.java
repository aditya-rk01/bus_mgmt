package com.example.bus_mgmt.ticket;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
public class ticketRowMapper implements RowMapper<ticket>{
    @Override
    public ticket mapRow(ResultSet rs, int rowNum) throws SQLException {

        ticket Ticket = new ticket();
        Ticket.setTid(rs.getInt("tid"));
        Ticket.setPid(rs.getInt("pid"));
        Ticket.setSrc(rs.getString("src"));
        Ticket.setDest(rs.getString("dest"));
        Ticket.setBno(rs.getInt("bno"));
        Ticket.setFare(rs.getInt("fare"));
        return Ticket;
    }
}