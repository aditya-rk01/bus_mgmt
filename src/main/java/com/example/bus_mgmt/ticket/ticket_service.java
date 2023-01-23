package com.example.bus_mgmt.ticket;

import com.example.bus_mgmt.bus.bus_service;
import com.example.bus_mgmt.passenger.passenger_service;
import com.example.bus_mgmt.route.route_service;
import com.example.bus_mgmt.bus.bus;
import com.example.bus_mgmt.passenger.passenger;
import com.example.bus_mgmt.route.route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bus_mgmt.ticket.ticket_dao_jdbc;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;


@Service
public class ticket_service {

    /*
    @Autowired
    private ticket_dao ticketDao;
    */
    @Autowired
    private ticket_dao_jdbc ticketDaoJdbc;

    //initializing services
    @Autowired
    public passenger_service pServ;

    @Autowired
    public bus_service bServ;

    @Autowired
    public route_service rServ;

    public List<ticket> getAll_ticket_details(){
        return ticketDaoJdbc.getAll();
    }

    public ticket get_ticket_details(int number){
        return ticketDaoJdbc.getTicketById(number);
    }

    //check how many tickets at present + 1
    public int generateTicketno()
    {
        return getAll_ticket_details().size()+1;
    }

    //function to book ticket
    public void addTicket( ticket a_ticket){
        System.out.println(a_ticket.getSrc()+" "+a_ticket.getDest());
        if(checkPassenger(a_ticket.getPid())) //check if passenger exists
        {
            int assign_bno=checkBusAvailiblity(a_ticket.getSrc(), a_ticket.getDest()); //check if bus is available, if so then lock seat in bus
            // if bus is available and then seat is available then assign_bno will return the booked bus number.
            if(assign_bno!=-1)
            {
                int fare=calculateFare(a_ticket.getSrc(), a_ticket.getDest()); //call function calculateFare
                a_ticket.setBno(assign_bno); //update the object variable from null to value
                a_ticket.setFare(fare); //update the object variable from null to value
                a_ticket.setTid(generateTicketno()); //update the object variable from null to value
                ticketDaoJdbc.addTicket(a_ticket); //insert ticket in database
            }
        }
    }

    public int calculateFare(String src, String dest)
    {
        return (returnSid(dest)-returnSid(src))*100;
    }

    public boolean checkPassenger(int pid)
    {
        List<passenger> all_passenger = pServ.getAll_passenger_details(); //retrieve all passengers
        int i;
        for(i=0; i<all_passenger.size() ; ++i)
        {
            if(all_passenger.get(i).getPid() == pid) //check if passenger exists
            {
                return true;
            }
        }
        return false;
    }

    public int returnSid(String sname) //return station_id for the corresponding station name.
    {
        List<route> all_route=rServ.getAll_route_details(); //get all route details
        int i;
        for(i=0; i<all_route.size(); ++i)
        {
            if(Objects.equals(all_route.get(i).getSname(), sname))
                return all_route.get(i).getSid();
        }
        return -1;
    }

    public int checkBusAvailiblity(String src, String dest)
    {
        //get source and dest ids
        int src_num=returnSid(src);
        int dest_num=returnSid(dest);

        List<bus> all_bus=bServ.getAll_bus_details();
        int i;
        for(i=0; i<all_bus.size(); ++i)
        {
            if((returnSid(all_bus.get(i).getSrc())<=src_num) && (returnSid(all_bus.get(i).getDest())>=dest_num)) //check if src and dest lies in any bus route
            {
                if(all_bus.get(i).getAvailable()>0) //if in such bus, seat is available or not
                {
                    all_bus.get(i).setAvailable(all_bus.get(i).getAvailable());
                    //bServ.updateBus(all_bus.get(i));  //write object in database
                    return all_bus.get(i).getNumber(); //return the bus number in which seat is booked.
                }
            }
        }
        return -1;
    }

    /*
    public void updateTicket(ticket u_ticket){
        ticketDao.save(u_ticket);
    }
    */
}
