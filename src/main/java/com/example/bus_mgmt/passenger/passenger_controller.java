package com.example.bus_mgmt.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class passenger_controller {
    @Autowired
    private passenger_service passengerService;

    @GetMapping("/passengers")
    public List<passenger> getAll_passenger_details(){
        return passengerService.getAll_passenger_details();
    }

    @GetMapping("/passengers/{number}")
    public passenger get_passenger_details(@PathVariable int number){
        return passengerService.get_passenger_details(number);
    }

    @PostMapping("/passengers")
    public void addPassenger(@RequestBody passenger a_passenger){
        passengerService.addPassenger(a_passenger);
    }

    @PutMapping("/passengers/{id}")
    public void updatePassenger(@RequestBody passenger u_passenger){passengerService.updatePassenger(u_passenger);}
}
