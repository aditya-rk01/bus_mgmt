package com.example.bus_mgmt.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class route_service {

    @Autowired
    private route_dao routeDao;

    public List<route> getAll_route_details(){
        return routeDao.findAll();
    }

    public route get_route_details(int number){
        return routeDao.findById(number).get();
    }

    public void addRoute(route a_route){
        routeDao.save(a_route);
    }

    public void updateRoute(route u_route){
        routeDao.save(u_route);
    }
}
