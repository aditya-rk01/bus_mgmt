package com.example.bus_mgmt.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bus_service {

    @Autowired
    private bus_dao busDao;

    public List<bus> getAll_bus_details(){
        return busDao.findAll();
    }

    public bus get_bus_details(int number){
        return busDao.findById(number).get();
    }

    public void addBus(bus a_bus){
        busDao.save(a_bus);
    }

    public void updateBus(bus u_bus){
        busDao.save(u_bus);
    }
}
