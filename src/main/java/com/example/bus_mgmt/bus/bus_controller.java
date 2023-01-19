package com.example.bus_mgmt.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class bus_controller {
    @Autowired
    private bus_service busService;

    @GetMapping("/buses")
    public List<bus> getAll_bus_details(){
        return busService.getAll_bus_details();
    }

    @GetMapping("/buses/{number}")
    public bus get_bus_details(@PathVariable int number){
        return busService.get_bus_details(number);
    }

    @PostMapping("/buses")
    public void addBus(@RequestBody bus a_bus){
        busService.addBus(a_bus);
    }

    @PutMapping("/buses/{id}")
    public void updateBus(@RequestBody bus u_bus){busService.updateBus(u_bus);}
}
