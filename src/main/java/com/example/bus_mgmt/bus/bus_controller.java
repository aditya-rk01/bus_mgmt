package com.example.bus_mgmt.bus;

import com.example.bus_mgmt.strd_error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public bus get_bus_details(@PathVariable int number) throws strd_error {
        return busService.get_bus_details(number);
    }

    @PostMapping("/add-bus")
    public bus addBus(@Valid @RequestBody bus a_bus) throws strd_error {
        return busService.addBus(a_bus);
    }

    @PutMapping("/buses/{id}")
    public void updateBus(@RequestBody bus u_bus){busService.updateBus(u_bus);}
}
