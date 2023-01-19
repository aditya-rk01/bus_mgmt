package com.example.bus_mgmt.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ticket_controller {
    @Autowired
    private ticket_service ticketService;

    @GetMapping("/tickets")
    public List<ticket> getAll_ticket_details(){
        return ticketService.getAll_ticket_details();
    }

    @GetMapping("/tickets/{number}")
    public ticket get_ticket_details(@PathVariable int number){
        return ticketService.get_ticket_details(number);
    }

    @PostMapping("/tickets")
    public void addTicket(@RequestBody ticket a_ticket){
        ticketService.addTicket(a_ticket);
    }

    @PutMapping("/tickets/{id}")
    public void updateTicket(@RequestBody ticket u_ticket){ticketService.updateTicket(u_ticket);}
}
