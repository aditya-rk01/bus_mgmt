package com.example.bus_mgmt.bus;

import com.example.bus_mgmt.strd_error;
import org.springframework.beans.NullValueInNestedPathException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class bus_service {

    @Autowired
    private bus_dao busDao;

    public List<bus> getAll_bus_details(){
        return busDao.findAll();
    }

    public bus get_bus_details(int number) throws strd_error {
        try{
            return busDao.findById(number).get();
        }
        catch(NoSuchElementException e) {
            throw new strd_error("No bus exists");
        }
    }

    public bus addBus(@Valid bus a_bus) throws strd_error {
        try {
            busDao.save(a_bus);
            return new bus();
        }
        catch(Exception e){
            throw new strd_error("Something is NULL here!!");
        }

    }

    public void updateBus(bus u_bus){
        busDao.save(u_bus);
    }
}
