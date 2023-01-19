package com.example.bus_mgmt.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class passenger_service {

    @Autowired
    private passenger_dao passengerDao;

    public List<passenger> getAll_passenger_details(){
        return passengerDao.findAll();
    }

    public passenger get_passenger_details(int number){
        return passengerDao.findById(number).get();
    }

    public void addPassenger(passenger a_passenger){
        passengerDao.save(a_passenger);
    }

    public void updatePassenger(passenger u_passenger){
        passengerDao.save(u_passenger);
    }
}
