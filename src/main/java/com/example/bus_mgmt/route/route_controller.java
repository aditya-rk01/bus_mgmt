package com.example.bus_mgmt.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class route_controller {
    @Autowired
    private route_service routeService;

    @GetMapping("/routes")
    public List<route> getAll_route_details(){
        return routeService.getAll_route_details();
    }

    @GetMapping("/routes/{number}")
    public route get_route_details(@PathVariable int number){
        return routeService.get_route_details(number);
    }

    @PostMapping("/routes")
    public void addRoute(@RequestBody route a_route){
        routeService.addRoute(a_route);
    }

    @PutMapping("/routes/{id}")
    public void updateRoute(@RequestBody route u_route){routeService.updateRoute(u_route);}
}
